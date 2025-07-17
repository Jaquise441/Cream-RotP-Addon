package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.init.power.non_stand.ModPowers;
import com.github.standobyte.jojo.power.impl.nonstand.INonStandPower;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.config.CreamConfig;
import com.hello_there.rotp_cream.entity.CreamEntity;
import com.hello_there.rotp_cream.init.InitBlocks;
import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitStands;
import com.hello_there.rotp_cream.init.InitSounds;
import com.hello_there.rotp_cream.util.BlacklistHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.SPlaySoundEffectPacket;
import net.minecraft.network.play.server.SStopSoundPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreamVoidBall extends StandEntityAction {
    private static final Set<UUID> activeBalls = new HashSet<>();
    private static final Map<UUID,Integer> mapActiveTicks = new HashMap<>();
    private final Map<UUID, Integer> voidDamageCooldowns = new HashMap<>();
    public static final StandPose VOID_BALL = new StandPose("cream_void_ball");
    private final Map<Entity, Boolean> teleportedEntities = new HashMap<>();
    private static final int GET_FUCKED_LMAO = -9999;
    private static final Set<net.minecraft.block.Block> GRASSY_BLOCKS = new HashSet<net.minecraft.block.Block>() {{
        add(Blocks.GRASS_BLOCK);
        add(Blocks.MYCELIUM);
        add(Blocks.PODZOL);
    }};

    public static boolean isVoidBallActive(LivingEntity user, IStandPower power) {
        return isVoidBallActive(user);
    }

    @Override
    protected Action<IStandPower> replaceAction(IStandPower power, ActionTarget target) {
        if(power.getStandManifestation() instanceof CreamEntity){
            CreamEntity creamEntity = (CreamEntity) power.getStandManifestation();
            if(creamEntity.isSemiVoidActive() && CreamConfig.HAVE_VOIDDASH.get()){
                return InitStands.CREAM_VOID_DASH.get();
            }
            if(creamEntity.isBallVoidActive()){
                return InitStands.CREAM_VOID_BALL_CANCEL.get();
            }
        }
        return super.replaceAction(power, target);
    }

    private final Map<UUID, Integer> voidedPlayers = new HashMap<>();


    public CreamVoidBall(Builder builder) {
        super(builder);
    }

    @Override
    public boolean cancelHeldOnGettingAttacked(IStandPower power, DamageSource dmgSource, float dmgAmount) {
        return CreamConfig.VOIDBALL_CANCEL_ON_DAMAGE.get();
    }

    @Override
    public boolean heldAllowsOtherAction(IStandPower power, Action<IStandPower> action) {
        if (activeBalls.contains(power.getUser().getUUID())) {
            return action == InitStands.CREAM_VOID_BALL_CANCEL.get();
        }
        return false;
    }

    @Override
    public ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        CreamEntity creamEntity = (CreamEntity) power.getStandManifestation();
        if (stand.isManuallyControlled()) {
            return ActionConditionResult.createNegative(new TranslationTextComponent("message.cream.nu_uh"));
        }

        if (creamEntity.isSemiVoidActive())
            return ActionConditionResult.createNegative(new TranslationTextComponent("message.cream.nu_uh2"));
        return super.checkStandConditions(stand, power, target);
    }

    @Override
    public void onTaskSet(World world, StandEntity standEntity, IStandPower standPower, Phase phase, StandEntityTask task, int ticks) {
        super.onTaskSet(world, standEntity, standPower, phase, task, ticks);
        mapActiveTicks.putIfAbsent(standPower.getUser().getUUID(),0);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        activeBalls.add(user.getUUID());
        mapActiveTicks.putIfAbsent(user.getUUID(),0);

        userPower.setCooldownTimer(InitStands.CREAM_VOID_BALL_CANCEL.get(), 20);
        userPower.consumeStamina(CreamConfig.VOIDBALL_STAMINA.get().floatValue());

        playSound((PlayerEntity) user, InitSounds.CREAM_VOID_START.get(), false);

        user.addEffect(new EffectInstance(InitEffects.VOIDED.get(), Integer.MAX_VALUE, 0, false, false));
        standEntity.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), Integer.MAX_VALUE, 0, false, false));

        PlayerEntity player = (PlayerEntity) user;
        player.abilities.flying = true;
        if (player.isCreative()) {
            player.abilities.mayfly = false;
        }
        player.onUpdateAbilities();
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            if (userPower.getStamina() <= 0) {
                CreamVoidBallCancel cancelAction = (CreamVoidBallCancel) InitStands.CREAM_VOID_BALL_CANCEL.get();
                userPower.setHeldAction(cancelAction);
                cancelAction.standPerform(world, standEntity, userPower, task);
                return;
            }
            mapActiveTicks.put(userPower.getUser().getUUID(),mapActiveTicks.get(userPower.getUser().getUUID())+1);
        }

        if(mapActiveTicks.containsKey(userPower.getUser().getUUID())){
            if (mapActiveTicks.get(userPower.getUser().getUUID()) >= CreamConfig.VOIDBALL_DURATION.get()) {
                CreamVoidBallCancel cancelAction = (CreamVoidBallCancel) InitStands.CREAM_VOID_BALL_CANCEL.get();
                userPower.setHeldAction(cancelAction);
                cancelAction.standPerform(world, standEntity, userPower, task);
                return;
            }
        }

        boolean isVampire = INonStandPower.getNonStandPowerOptional(userPower.getUser())
                .map(power -> power.getType() == ModPowers.VAMPIRISM.get())
                .orElse(false);

        float staminaCostPerTick = isVampire ? getStaminaCostPerTickVamp(userPower) : getStaminaCostPerTick(userPower);

        if (staminaCostPerTick > 0 && !userPower.consumeStamina(staminaCostPerTick)) {
            userPower.stopHeldAction(false);
            return;
        }

        if (standEntity.isManuallyControlled()) {
            CreamVoidBallCancel cancelAction = (CreamVoidBallCancel) InitStands.CREAM_VOID_BALL_CANCEL.get();
            userPower.setHeldAction(cancelAction);
            cancelAction.standPerform(world, standEntity, userPower, task);
            return;
        }

        INonStandPower.getNonStandPowerOptional(userPower.getUser()).ifPresent(nonStandPower -> {
            if (nonStandPower.getHeldAction() != null) {
                nonStandPower.stopHeldAction(false);
            }
        });

        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        AxisAlignedBB voidArea = user.getBoundingBox().inflate(1.5);

        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            player.abilities.flying = true;

            if (player.isCreative()) {
                player.abilities.mayfly = false;
            }

            player.onUpdateAbilities();
        }

        AtomicBoolean anyEntityTeleported = new AtomicBoolean(false);

        world.getEntitiesOfClass(Entity.class, voidArea).forEach(entity -> {
            if (entity != user && entity != standEntity && !teleportedEntities.containsKey(entity) &&
                    (!(entity instanceof PlayerEntity) || !((PlayerEntity) entity).abilities.invulnerable) &&
                    !BlacklistHandler.isEntityBlacklisted(entity)) {

                if (CreamConfig.VOID_INSTAKILLS.get()) {
                    if (entity instanceof PlayerEntity) {
                        PlayerEntity playerEntity = (PlayerEntity) entity;
                        if (playerEntity.isAlive()) {
                            playerEntity.addEffect(new EffectInstance(Effects.INVISIBILITY, 20, 0, false, false));
                            playerEntity.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
                            teleportedEntities.put(entity, true);
                            anyEntityTeleported.set(true);
                        }
                    }
                    else if (!(entity instanceof ItemEntity) || CreamConfig.VOIDBALL_DELETE_ITEMS.get()) {
                        entity.teleportTo(entity.getX(), GET_FUCKED_LMAO, entity.getZ());
                        teleportedEntities.put(entity, true);
                        anyEntityTeleported.set(true);
                    }
                } else {
                    if (entity instanceof LivingEntity) {
                        LivingEntity living = (LivingEntity) entity;
                        int cooldown = voidDamageCooldowns.getOrDefault(entity.getUUID(), 0);

                        if (cooldown <= 0) {
                            boolean wasAlive = living.isAlive();
                            living.hurt(DamageSource.OUT_OF_WORLD, CreamConfig.VOID_DAMAGE.get().floatValue());
                            voidDamageCooldowns.put(entity.getUUID(), CreamConfig.VOID_DAMAGE_COOLDOWN.get());

                            if (wasAlive && !living.isAlive()) {
                                anyEntityTeleported.set(true);
                            }
                        } else {
                            voidDamageCooldowns.put(entity.getUUID(), cooldown - 1);
                        }
                    }
                    else if (!(entity instanceof ItemEntity) || CreamConfig.VOIDBALL_DELETE_ITEMS.get()) {
                        entity.remove();
                    }
                }
            }
        });

        if (anyEntityTeleported.get() && user instanceof PlayerEntity) {
            playSound((PlayerEntity) user, InitSounds.CREAM_VOID.get(), false);
        }

        BlockPos centerPos = new BlockPos(user.getX(), user.getEyeY() - 0.5, user.getZ());
        BlockPos.betweenClosedStream(centerPos.offset(-1, -1, -1), centerPos.offset(1, 1, 1)).forEach(pos -> {
            BlockState state = world.getBlockState(pos);
            if (!blacklist(state)) {
                if (!world.getFluidState(pos).isEmpty()) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                } else {
                    world.destroyBlock(pos, false);
                }
            }
        });

        if (user.isShiftKeyDown()) {
            BlockPos belowCenter = user.blockPosition().below();

            for (int xOffset = -1; xOffset <= 1; xOffset++) {
                for (int zOffset = -1; zOffset <= 1; zOffset++) {
                    BlockPos targetPos = belowCenter.offset(xOffset, 0, zOffset);
                    BlockState state = world.getBlockState(targetPos);

                    if (!blacklist(state)) {
                        if (!world.getFluidState(targetPos).isEmpty()) {
                            world.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
                        } else {
                            world.destroyBlock(targetPos, false);
                        }
                    }
                }
            }
        }

        BlockPos groundCenter = user.blockPosition().below();
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int zOffset = -1; zOffset <= 1; zOffset++) {
                BlockPos groundPos = groundCenter.offset(xOffset, 0, zOffset);
                BlockState groundState = world.getBlockState(groundPos);

                if (GRASSY_BLOCKS.contains(groundState.getBlock())) {
                    world.setBlock(groundPos, Blocks.DIRT.defaultBlockState(), 3);
                }
            }
        }

        if (!world.getFluidState(centerPos).isEmpty()) {
            BlockPos.betweenClosedStream(centerPos.offset(-1, -1, -1), centerPos.offset(1, 1, 1)).forEach(pos -> {
                if (!world.getFluidState(pos).isEmpty()) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                }
            });
        }

        if (userPower.getStamina() <= 0) {
            userPower.stopHeldAction(false);
        }
    }

    private boolean blacklist(BlockState state) {
        return BlacklistHandler.isBlockBlacklisted(state.getBlock());
    }

    @Override
    public void onTaskStopped(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task, StandEntityAction newAction) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        if (user instanceof PlayerEntity && !((PlayerEntity) user).isCreative()) {
            PlayerEntity player = (PlayerEntity) user;
            player.abilities.setFlyingSpeed(0.05F);
            player.abilities.mayfly = false;
            player.abilities.flying = false;
            player.onUpdateAbilities();
        }

        if (user instanceof PlayerEntity && ((PlayerEntity) user).isCreative()) {
            PlayerEntity player = (PlayerEntity) user;
            player.abilities.setFlyingSpeed(0.05F);
            player.abilities.mayfly = true;
            player.abilities.flying = false;
            player.onUpdateAbilities();
        }

        if (activeBalls.contains(user.getUUID())) {
            if (!user.level.isClientSide) {
                int cooldownTicks = 0;

                Integer ticksUsed = mapActiveTicks.remove(user.getUUID());
                if (ticksUsed == null) {
                    ticksUsed = 0;
                }

                if (user instanceof PlayerEntity && ((PlayerEntity) user).isCreative()) {
                    cooldownTicks = 0;
                }
                else {
                    boolean isVampire = INonStandPower.getNonStandPowerOptional(user)
                            .map(power -> power.getType() == ModPowers.VAMPIRISM.get())
                            .orElse(false);

                    if (isVampire) {
                        if (!CreamConfig.VOIDBALL_DYNAMIC_COOLDOWN.get()) {
                            cooldownTicks = CreamConfig.VOIDBALL_VAMPIRE_COOLDOWN.get();
                        }
                        else {
                            cooldownTicks = (int) (ticksUsed * CreamConfig.VOIDBALL_VAMPIRE_COOLDOWN_MULTIPLIER.get());
                            cooldownTicks = Math.max(cooldownTicks, CreamConfig.VOIDBALL_VAMPIRE_MIN_COOLDOWN.get());
                        }
                    } else {
                        if (CreamConfig.VOIDBALL_DYNAMIC_COOLDOWN.get()) {
                            cooldownTicks = (int)(ticksUsed * CreamConfig.VOIDBALL_DYNAMIC_COOLDOWN_MULTIPLIER.get());
                            cooldownTicks = Math.max(cooldownTicks, CreamConfig.VOIDBALL_DYNAMIC_MINIMUM_COOLDOWN.get());
                        } else {
                            cooldownTicks = CreamConfig.VOIDBALL_COOLDOWN.get();
                        }
                    }
                }

                if (cooldownTicks > 0) {
                    userPower.setCooldownTimer(this, cooldownTicks);
                    userPower.setCooldownTimer(InitStands.CREAM_VOID_DASH.get(), cooldownTicks);
                }

                if (user instanceof PlayerEntity) {
                    stopSound((PlayerEntity) user, InitSounds.CREAM_VOID_START.get());
                    stopSound((PlayerEntity) user, InitSounds.CREAM_VOID_FORM_SHORT.get());
                    playSound((PlayerEntity) user, InitSounds.CREAM_VOID_END.get(), false);
                }
            }
        }

        activeBalls.remove(user.getUUID());
        user.removeEffect(InitEffects.VOIDED.get());
        standEntity.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());

        teleportedEntities.clear();
    }

    private float getStaminaCostPerTick(IStandPower power) {
        if (!CreamConfig.PROGRESSIVE_STAMINA_COST.get()) {
            return CreamConfig.VOIDBALL_STAMINA_COST_TICK.get().floatValue();
        }

        int resolveLevel = power.getResolveLevel();
        if (resolveLevel <= 2) {
            return CreamConfig.STAMINA_COST_RESOLVE_2.get().floatValue();
        } else if (resolveLevel == 3) {
            return CreamConfig.STAMINA_COST_RESOLVE_3.get().floatValue();
        } else {
            return CreamConfig.STAMINA_COST_RESOLVE_4.get().floatValue();
        }
    }

    private float getStaminaCostPerTickVamp(IStandPower power) {
        if (!CreamConfig.PROGRESSIVE_STAMINA_COST.get()) {
            return CreamConfig.VOIDBALL_STAMINA_COST_TICK_VAMPIRE.get().floatValue();
        }

        int resolveLevel = power.getResolveLevel();
        if (resolveLevel <= 2) {
            return CreamConfig.STAMINA_COST_RESOLVE_2_VAMPIRE.get().floatValue();
        } else if (resolveLevel == 3) {
            return CreamConfig.STAMINA_COST_RESOLVE_3_VAMPIRE.get().floatValue();
        } else {
            return CreamConfig.STAMINA_COST_RESOLVE_4_VAMPIRE.get().floatValue();
        }
    }

    public static void cleanup(LivingEntity user) {
        if (isVoidBallActive(user, null)) {
            user.removeEffect(InitEffects.VOIDED.get());
            IStandPower.getStandPowerOptional(user).ifPresent(standPower -> {
                if (standPower.hasPower()) {
                    StandEntity standEntity = (StandEntity) standPower.getStandManifestation();
                    if (standEntity != null) {
                        standEntity.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());
                    }
                }
            });

            if (user instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) user;
                stopSound(player, InitSounds.CREAM_VOID_START.get());
                stopSound(player, InitSounds.CREAM_VOID_FORM_SHORT.get());
                playSound(player, InitSounds.CREAM_VOID_END.get(), false);
            }

            if (user instanceof PlayerEntity && !((PlayerEntity) user).isCreative()) {
                PlayerEntity player = (PlayerEntity) user;
                player.abilities.setFlyingSpeed(0.05F);
                player.abilities.mayfly = false;
                player.abilities.flying = false;
                player.onUpdateAbilities();
            }

            if (user instanceof PlayerEntity && ((PlayerEntity) user).isCreative()) {
                PlayerEntity player = (PlayerEntity) user;
                player.abilities.setFlyingSpeed(0.05F);
                player.abilities.mayfly = true;
                player.abilities.flying = false;
                player.onUpdateAbilities();
            }
        }
    }

    @SubscribeEvent
    public static void onEntityViewRender(EntityViewRenderEvent.FogDensity event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && mc.player.hasEffect(InitEffects.TRUE_BLINDNESS.get())) {
            event.setDensity(0.5f);
            event.setCanceled(true);
        }
    }




    private static void playSound(PlayerEntity player, SoundEvent sound, boolean forCreamUserOnly) {
        if (player instanceof ServerPlayerEntity) {
            ServerWorld world = (ServerWorld) player.level;
            Vector3d position = player.position();

            if (forCreamUserOnly) {
                ((ServerPlayerEntity) player).connection.send(new SPlaySoundEffectPacket(sound, SoundCategory.PLAYERS, player.getX(), player.getY(), player.getZ(), 1.0F, 1.0F));
            } else {
                world.getPlayers(p -> p.position().distanceTo(position) <= 20).forEach(p -> {
                    ((ServerPlayerEntity) p).connection.send(new SPlaySoundEffectPacket(sound, SoundCategory.PLAYERS, position.x, position.y, position.z, 1.0F, 1.0F));
                });
            }
        }
    }

    private static void stopSound(PlayerEntity player, SoundEvent sound) {
        if (player instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) player).connection.send(new SStopSoundPacket(sound.getRegistryName(), SoundCategory.PLAYERS));
        }
    }

    public static boolean isVoidBallActive(LivingEntity user) {
        return activeBalls.contains(user.getUUID());
    }


    public static void removeBallActive(LivingEntity user){
        activeBalls.remove(user.getUUID());
    }


    @Mod.EventBusSubscriber
    public static class VoidBallEvents {
        @SubscribeEvent
        public static void onBlockBreak(PlayerEvent.BreakSpeed event) {
            PlayerEntity player = event.getPlayer();
            if (isVoidBallActive(player)) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onItemPickup(EntityItemPickupEvent event) {
            PlayerEntity player = event.getPlayer();
            if (isVoidBallActive(player)) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
            if (event.getEntity() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) event.getEntity();
                if (isVoidBallActive(player)) {
                    event.setCanceled(true);
                }
            }
        }

        @SubscribeEvent
        public static void onEntityAttack(LivingAttackEvent event) {
            if (event.getSource().getEntity() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
                if (isVoidBallActive(player)) {
                    event.setCanceled(true);
                }
            }
        }

        @SubscribeEvent
        public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
            PlayerEntity player = event.getPlayer();
            if (isVoidBallActive(player)) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
            PlayerEntity player = event.getPlayer();
            if (isVoidBallActive(player)) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
            PlayerEntity player = event.getPlayer();
            if (isVoidBallActive(player)) {
                event.setCanceled(true);
            }
        }
    }
}