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
import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

public class CreamSemiVoidState extends StandEntityAction {
    public static final StandPose SEMI_VOID_STATE = new StandPose("cream_semi_void_state");
    private static final Map<UUID,Integer> activeTicksMap = new HashMap<>();
    private static final Set<UUID> semiVoidActives = new HashSet<>();

    //TODO: I genuinely gotta find a better name for this than fucking dumbass "semivoidstate" bruh


    public CreamSemiVoidState(Builder builder) {
        super(builder);
    }



    @Override
    protected Action<IStandPower> replaceAction(IStandPower power, ActionTarget target) {
        if(power.getStandManifestation() instanceof CreamEntity){
            CreamEntity creamEntity = (CreamEntity) power.getStandManifestation();
            if(creamEntity.isSemiVoidActive()){
                return InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get();
            }
        }
        return super.replaceAction(power, target);
    }


    @Override
    public boolean cancelHeldOnGettingAttacked(IStandPower power, DamageSource dmgSource, float dmgAmount) {
        return CreamConfig.SEMIVOID_CANCEL_ON_DAMAGE.get();
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
        activeTicksMap.putIfAbsent(userPower.getUser().getUUID(),0);

        semiVoidActives.add(user.getUUID());
        user.addEffect(new EffectInstance(InitEffects.INSIDE_CREAM.get(),Integer.MAX_VALUE,0,false,false,false));


        userPower.setCooldownTimer(InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get(), 20);
        userPower.consumeStamina(CreamConfig.SEMIVOID_STAMINA.get().floatValue());

        user.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), Integer.MAX_VALUE, 1, false, false));

        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            CreamVoidBall.setPlayerFlyingSpeed(player,(float)CreamConfig.SEMIVOID_FLY_SPEED.get().doubleValue());
            player.abilities.flying = true;
            player.onUpdateAbilities();
        }
    }




    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        if (!world.isClientSide) {
            if (userPower.getStamina() <= 0) {
                CreamSemiVoidStateCancel cancelAction = (CreamSemiVoidStateCancel) InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get();
                userPower.setHeldAction(cancelAction);
                cancelAction.standPerform(world, standEntity, userPower, task);
                return;
            }
            activeTicksMap.put(user.getUUID(),activeTicksMap.get(user.getUUID())+1);
        }

        if (activeTicksMap.get(user.getUUID()) >= CreamConfig.SEMIVOID_DURATION.get()) {
            CreamSemiVoidStateCancel cancelAction = (CreamSemiVoidStateCancel) InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get();
            userPower.setHeldAction(cancelAction);
            cancelAction.standPerform(world, standEntity, userPower, task);
            return;
        }

        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            float flySpeed = player.isSprinting() ? (float)CreamConfig.SEMIVOID_FLY_SPEED_SPRINT.get().doubleValue() : (float)CreamConfig.SEMIVOID_FLY_SPEED.get().doubleValue();
            CreamVoidBall.setPlayerFlyingSpeed(player,flySpeed);
            player.abilities.flying = true;

            if (player.isCreative()) {
                player.abilities.mayfly = false;
            }

            player.onUpdateAbilities();
        }


        if (standEntity.isManuallyControlled()) {
            CreamSemiVoidStateCancel cancelAction = (CreamSemiVoidStateCancel) InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get();
            userPower.setHeldAction(cancelAction);
            cancelAction.standPerform(world, standEntity, userPower, task);
            return;
        }

        boolean isVampire = INonStandPower.getNonStandPowerOptional(userPower.getUser())
                .map(power -> power.getType() == ModPowers.VAMPIRISM.get())
                .orElse(false);

        float staminaCostPerTick = isVampire ? getStaminaCostPerTickVamp(userPower) : getStaminaCostPerTick(userPower);

        if (staminaCostPerTick > 0 && !userPower.consumeStamina(staminaCostPerTick)) {
            userPower.stopHeldAction(false);
            return;
        }
    }

    @Override
    public void onTaskStopped(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task, StandEntityAction newAction) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        if (semiVoidActives.contains(user.getUUID())) {
            if (!user.level.isClientSide) {
                int cooldownTicks = 0;

                Integer ticksUsed = activeTicksMap.remove(user.getUUID());
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
                        if (!CreamConfig.SEMIVOID_DYNAMIC_COOLDOWN.get()) {
                            cooldownTicks = CreamConfig.SEMIVOID_VAMPIRE_COOLDOWN.get();
                        }
                        else {
                            cooldownTicks = (int) (ticksUsed * CreamConfig.SEMIVOID_VAMPIRE_COOLDOWN_MULTIPLIER.get());
                            cooldownTicks = Math.max(cooldownTicks, CreamConfig.SEMIVOID_VAMPIRE_MIN_COOLDOWN.get());
                        }
                    }
                    else {
                        if (CreamConfig.SEMIVOID_DYNAMIC_COOLDOWN.get()) {
                            cooldownTicks = (int) (ticksUsed * CreamConfig.SEMIVOID_DYNAMIC_COOLDOWN_MULTIPLIER.get());
                            cooldownTicks = Math.max(cooldownTicks, CreamConfig.SEMIVOID_DYNAMIC_MINIMUM_COOLDOWN.get());
                        } else {
                            cooldownTicks = CreamConfig.SEMIVOID_COOLDOWN.get();
                        }
                    }
                }

                if (cooldownTicks > 0) {
                    userPower.setCooldownTimer(this, cooldownTicks);
                }
            }
        }

        semiVoidActives.remove(user.getUUID());
        user.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());
        user.removeEffect(Effects.INVISIBILITY);

        if (user instanceof PlayerEntity && !((PlayerEntity) user).isCreative()) {
            PlayerEntity player = (PlayerEntity) user;
            CreamVoidBall.setPlayerFlyingSpeed(player,0.05F);
            player.abilities.mayfly = false;
            player.abilities.flying = false;
            player.onUpdateAbilities();
        }

        if (user instanceof PlayerEntity && ((PlayerEntity) user).isCreative()) {
            PlayerEntity player = (PlayerEntity) user;
            CreamVoidBall.setPlayerFlyingSpeed(player,0.05F);
            player.abilities.mayfly = true;
            player.abilities.flying = false;
            player.onUpdateAbilities();
        }
    }

    public static void cleanup(LivingEntity user) {
        if (isSemiVoidActive(user)) {

            semiVoidActives.remove(user.getUUID());

            user.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());
            user.removeEffect(Effects.INVISIBILITY);

            if (user instanceof PlayerEntity && !((PlayerEntity) user).isCreative()) {
                PlayerEntity player = (PlayerEntity) user;
                CreamVoidBall.setPlayerFlyingSpeed(player,0.05F);
                player.abilities.mayfly = false;
                player.abilities.flying = false;
                player.onUpdateAbilities();
            }

            if (user instanceof PlayerEntity && ((PlayerEntity) user).isCreative()) {
                PlayerEntity player = (PlayerEntity) user;
                CreamVoidBall.setPlayerFlyingSpeed(player,0.05F);
                player.abilities.mayfly = true;
                player.abilities.flying = false;
                player.onUpdateAbilities();
            }
        }
    }

    private float getStaminaCostPerTick(IStandPower power) {
        if (!CreamConfig.PROGRESSIVE_STAMINA_COST.get()) {
            return CreamConfig.SEMIVOID_STAMINA_COST_TICK.get().floatValue();
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
            return CreamConfig.SEMIVOID_STAMINA_COST_TICK_VAMPIRE.get().floatValue();
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

    @Override
    public boolean heldAllowsOtherAction(IStandPower power, Action<IStandPower> action) {
        return action == InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get()
                || action == InitStands.CREAM_VOID_DASH.get();
    }

    public static void remoteSemiVoidActive(LivingEntity user){
        semiVoidActives.remove(user.getUUID());
    }


    public static boolean isSemiVoidActive(LivingEntity user) {
        return semiVoidActives.contains(user.getUUID());
    }


    @Mod.EventBusSubscriber
    public static class SemiVoidEvents {
        @SubscribeEvent
        public static void onBlockBreak(PlayerEvent.BreakSpeed event) {
            PlayerEntity player = event.getPlayer();
            if (isSemiVoidActive(player)) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onItemPickup(EntityItemPickupEvent event) {
            PlayerEntity player = event.getPlayer();
            if (isSemiVoidActive(player)) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
            if (event.getEntity() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) event.getEntity();
                if (isSemiVoidActive(player)) {
                    event.setCanceled(true);
                }
            }
        }

        @SubscribeEvent
        public static void onEntityAttack(LivingAttackEvent event) {
            if (event.getSource().getEntity() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
                if (isSemiVoidActive(player)) {
                    event.setCanceled(true);
                }
            }
        }

        @SubscribeEvent
        public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
            PlayerEntity player = event.getPlayer();
            if (isSemiVoidActive(player)) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
            PlayerEntity player = event.getPlayer();
            if (isSemiVoidActive(player)) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
            PlayerEntity player = event.getPlayer();
            if (isSemiVoidActive(player)) {
                event.setCanceled(true);
            }
        }
    }
}