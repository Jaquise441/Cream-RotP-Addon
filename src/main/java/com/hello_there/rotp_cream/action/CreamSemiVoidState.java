package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.config.CreamConfig;
import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitStands;
import com.hello_there.rotp_cream.init.InitSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.WeakHashMap;

public class CreamSemiVoidState extends StandEntityAction {
    private boolean isSemiVoidActive = false;
    private static final Map<LivingEntity, CreamSemiVoidState> ACTIVE_INSTANCES = new WeakHashMap<>();
    public static final StandPose SEMI_VOID_STATE = new StandPose("cream_semi_void_state");
    private int activeTicks = 0;

    //TODO: I genuinely gotta find a better name for this than fucking dumbass "semivoidstate" bruh


    public CreamSemiVoidState(Builder builder) {
        super(builder);
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
        activeTicks = 0;
        isSemiVoidActive = true;
        ACTIVE_INSTANCES.put(user, this);

        userPower.setCooldownTimer(InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get(), 20);

        user.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), Integer.MAX_VALUE, 1, false, false));
        user.addEffect(new EffectInstance(Effects.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));

        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
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
            activeTicks++;
        }

        if (activeTicks >= CreamConfig.SEMIVOID_DURATION.get()) {
            CreamSemiVoidStateCancel cancelAction = (CreamSemiVoidStateCancel) InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get();
            userPower.setHeldAction(cancelAction);
            cancelAction.standPerform(world, standEntity, userPower, task);
            return;
        }

        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            player.abilities.flying = true;
            player.onUpdateAbilities();
        }

        if (standEntity.isManuallyControlled()) {
            CreamSemiVoidStateCancel cancelAction = (CreamSemiVoidStateCancel) InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get();
            userPower.setHeldAction(cancelAction);
            cancelAction.standPerform(world, standEntity, userPower, task);
            return;
        }

        float staminaCostPerTick = getStaminaCostPerTick(userPower);
        if (staminaCostPerTick > 0 && !userPower.consumeStamina(staminaCostPerTick)) {
            userPower.stopHeldAction(false);
        }
    }

    @Override
    public void onTaskStopped(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task, StandEntityAction newAction) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        if (isSemiVoidActive) {
            if (!user.level.isClientSide) {
                int cooldownTicks;
                if (CreamConfig.SEMIVOID_DYNAMIC_COOLDOWN.get()) {
                    cooldownTicks = (int) (activeTicks * CreamConfig.SEMIVOID_DYNAMIC_COOLDOWN_MULTIPLIER.get());
                    cooldownTicks = Math.max(cooldownTicks, CreamConfig.SEMIVOID_DYNAMIC_MINIMUM_COOLDOWN.get());
                } else {
                    cooldownTicks = CreamConfig.SEMIVOID_COOLDOWN.get();
                }
                userPower.setCooldownTimer(this, cooldownTicks);
            }
        }

        isSemiVoidActive = false;
        ACTIVE_INSTANCES.remove(user);

        user.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());
        user.removeEffect(Effects.INVISIBILITY);

        if (user instanceof PlayerEntity && !((PlayerEntity) user).isCreative()) {
            PlayerEntity player = (PlayerEntity) user;
            player.abilities.mayfly = false;
            player.abilities.flying = false;
            player.onUpdateAbilities();
        }
    }

    public static void cleanup(LivingEntity user) {
        if (isSemiVoidActive(user)) {
            CreamSemiVoidState instance = ACTIVE_INSTANCES.get(user);
            if (instance != null) {
                instance.isSemiVoidActive = false;
            }
            ACTIVE_INSTANCES.remove(user);

            user.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());
            user.removeEffect(Effects.INVISIBILITY);

            if (user instanceof PlayerEntity && !((PlayerEntity) user).isCreative()) {
                PlayerEntity player = (PlayerEntity) user;
                player.abilities.mayfly = false;
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

    @Override
    public boolean heldAllowsOtherAction(IStandPower power, Action<IStandPower> action) {
        return action == InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get()
                || action == InitStands.CREAM_VOID_DASH.get();
    }

    @Nullable
    @Override
    public Action<IStandPower> getVisibleAction(IStandPower power, ActionTarget target) {
        if (isSemiVoidActive()) {
            return InitStands.CREAM_SEMI_VOID_STATE_CANCEL.get();
        }
        return super.getVisibleAction(power, target);
    }

    public static boolean isSemiVoidActive(LivingEntity user) {
        return ACTIVE_INSTANCES.containsKey(user) && ACTIVE_INSTANCES.get(user).isSemiVoidActive();
    }

    public boolean isSemiVoidActive() {
        return isSemiVoidActive;
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