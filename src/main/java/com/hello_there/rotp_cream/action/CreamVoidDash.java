package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.config.CreamConfig;
import com.hello_there.rotp_cream.init.InitBlocks;
import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitStands;
import com.hello_there.rotp_cream.init.InitSounds;
import com.hello_there.rotp_cream.util.BlacklistHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.SPlaySoundEffectPacket;
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

import javax.annotation.Nullable;
import java.util.*;

public class CreamVoidDash extends StandEntityAction {
    private static final Set<UUID> DASHES = new HashSet<>();
    private static final double SEARCH_RADIUS = 1.5;
    private static final int GET_FUCKED_LMAO = -9999;
    private final Set<UUID> teleportedEntities = new HashSet<>();
    private Vector3d dashDirection;
    private static final Set<UUID> setPlayedDashSound = new HashSet<>();
    private static final Set<net.minecraft.block.Block> GRASSY_BLOCKS = new HashSet<net.minecraft.block.Block>() {{
        add(Blocks.GRASS_BLOCK);
        add(Blocks.MYCELIUM);
        add(Blocks.PODZOL);
    }};

    public CreamVoidDash(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        if (stand.isManuallyControlled()) {
            return ActionConditionResult.createNegative(new TranslationTextComponent("message.cream.nu_uh"));
        }
        return super.checkStandConditions(stand, power, target);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        this.dashDirection = user.getLookAngle().normalize();

        DASHES.add(user.getUUID());
        teleportedEntities.clear();

        playSound((PlayerEntity) user, InitSounds.CREAM_VOID_START.get(), false);

        PlayerEntity player = (PlayerEntity) user;
        player.abilities.flying = true;
        player.onUpdateAbilities();

        user.addEffect(new EffectInstance(InitEffects.VOIDED.get(), 20, 0, false, false));
        standEntity.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), 20, 0, false, false));
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        /*
        Set<BlockPos> currentBarrierPositions = new HashSet<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos pos = barrierCenter.offset(dx, 0, dz);
                currentBarrierPositions.add(pos);
                if (world.getBlockState(pos).isAir() || world.getBlockState(pos).getFluidState().isSource()) {
                    world.setBlock(pos, InitBlocks.VOID_BARRIER.get().defaultBlockState(), 3);
                }
            }
        }
         */

        Vector3d lookVec = user.getLookAngle();
        Vector3d horizontalLook = new Vector3d(lookVec.x, 0, lookVec.z).normalize();
        double speed = 5;
        Vector3d movement = horizontalLook.scale(speed);


        user.setDeltaMovement(movement.x, user.getDeltaMovement().y, movement.z);
        user.hasImpulse = true;

        voidStuff(world, user);

        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            player.abilities.flying = true;
            player.onUpdateAbilities();
        }

        if (!setPlayedDashSound.contains(user.getUUID()) && user instanceof PlayerEntity) {
            //TODO: Get a fucking dash sound
            setPlayedDashSound.add(user.getUUID());
        }
    }

    private boolean blacklisted(BlockState state) {
        return BlacklistHandler.isBlockBlacklisted(state.getBlock());
    }

    private void voidStuff(World world, LivingEntity user) {
        AxisAlignedBB voidArea = user.getBoundingBox().inflate(SEARCH_RADIUS);
        boolean anyEntityTeleported = false;

        StandEntity standEntity = IStandPower.getStandPowerOptional(user)
                .map(IStandPower::getStandManifestation)
                .filter(manifestation -> manifestation instanceof StandEntity)
                .map(manifestation -> (StandEntity)manifestation)
                .orElse(null);

        for (Entity entity : world.getEntitiesOfClass(Entity.class, voidArea)) {
            if (entity == user || entity == standEntity ||
                    entity.isInvulnerable() || teleportedEntities.contains(entity.getUUID()) ||
                    BlacklistHandler.isEntityBlacklisted(entity)) {
                continue;
            }

            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                if (player.isAlive()) {
                    player.addEffect(new EffectInstance(Effects.INVISIBILITY, 20, 0, false, false));
                    player.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
                    teleportedEntities.add(entity.getUUID());
                    anyEntityTeleported = true;
                }
            }
            else if (!(entity instanceof ItemEntity) || CreamConfig.VOIDDASH_DELETE_ITEMS.get()) {
                entity.teleportTo(entity.getX(), GET_FUCKED_LMAO, entity.getZ());
                teleportedEntities.add(entity.getUUID());
                anyEntityTeleported = true;
            }
        }

        if (anyEntityTeleported && user instanceof PlayerEntity) {
            playSound((PlayerEntity) user, InitSounds.CREAM_VOID.get(), false);
        }

        BlockPos centerPos = new BlockPos(user.getX(), user.getEyeY() - 0.5, user.getZ());
        BlockPos.betweenClosedStream(centerPos.offset(-1, -1, -1), centerPos.offset(1, 1, 1)).forEach(pos -> {
            BlockState state = world.getBlockState(pos);
            if (!blacklisted(state)) {
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

                    if (!blacklisted(state)) {
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
    }

    @Override
    public void onTaskStopped(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task, StandEntityAction newAction) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        teleportedEntities.clear();
        user.removeEffect(InitEffects.VOIDED.get());
        standEntity.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());
        CreamVoidBall.removeBallActive(user);
        playSound((PlayerEntity) user, InitSounds.CREAM_VOID_END.get(), false);

        if (!world.isClientSide && !((PlayerEntity) user).isCreative()) {
            userPower.setCooldownTimer(this, CreamConfig.VOIDDASH_COOLDOWN.get());
            userPower.setCooldownTimer(InitStands.CREAM_VOID_BALL.get(), CreamConfig.VOIDDASH_COOLDOWN.get());
        }

        DASHES.remove(user.getUUID());

        setPlayedDashSound.remove(user.getUUID());

        if (user instanceof PlayerEntity && !((PlayerEntity) user).isCreative()) {
            PlayerEntity player = (PlayerEntity) user;
            player.abilities.mayfly = false;
            player.abilities.flying = false;
            player.onUpdateAbilities();
        }
    }

    public static void cleanup(LivingEntity user) {
        if (isVoidDashActive(user)) {

            setPlayedDashSound.remove(user.getUUID());
            DASHES.remove(user.getUUID());

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
                playSound((PlayerEntity) user, InitSounds.CREAM_VOID_END.get(), false);
            }

            if (user instanceof PlayerEntity && !((PlayerEntity) user).isCreative()) {
                PlayerEntity player = (PlayerEntity) user;
                player.abilities.mayfly = false;
                player.abilities.flying = false;
                player.onUpdateAbilities();
            }
        }
    }

    private static void playSound(PlayerEntity player, SoundEvent sound, boolean forCreamUserOnly) {
        if (player instanceof ServerPlayerEntity) {
            ServerWorld world = (ServerWorld) player.level;
            Vector3d position = player.position();

            if (forCreamUserOnly) {
                ((ServerPlayerEntity) player).connection.send(
                        new SPlaySoundEffectPacket(sound, SoundCategory.PLAYERS,
                                player.getX(), player.getY(), player.getZ(), 1.0F, 1.0F));
            } else {
                world.getPlayers(p -> p.position().distanceTo(position) <= 20).forEach(p -> {
                    ((ServerPlayerEntity) p).connection.send(
                            new SPlaySoundEffectPacket(sound, SoundCategory.PLAYERS,
                                    position.x, position.y, position.z, 1.0F, 1.0F));
                });
            }
        }
    }

    public static boolean isVoidDashActive(LivingEntity user) {
        return DASHES.contains(user.getUUID());
    }

    @Override
    public boolean heldAllowsOtherAction(IStandPower power, Action<IStandPower> action) {
        return false;
    }

    @Override
    public boolean isUnlocked(IStandPower power) {
        return InitStands.CREAM_SEMI_VOID_STATE.get().isUnlocked(power);
    }
}