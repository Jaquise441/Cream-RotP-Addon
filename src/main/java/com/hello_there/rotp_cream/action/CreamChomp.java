package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mod.JojoModUtil;
import com.hello_there.rotp_cream.config.CreamConfig;
import com.hello_there.rotp_cream.init.InitSounds;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import static com.hello_there.rotp_cream.action.CreamSemiVoidState.isSemiVoidActive;
import static com.hello_there.rotp_cream.action.CreamVoidBall.isVoidBallActive;

public class CreamChomp extends StandEntityAction {
    public static final StandPose CHOMP = new StandPose("cream_chomp");
    private boolean hasPlayedSound = false;
    private int tickCounter = 0;
    private boolean chomped = false;

    public CreamChomp(Builder builder) {
        super(builder);
    }

    @Override
    public ActionConditionResult checkTarget(ActionTarget target, LivingEntity user, IStandPower power) {
        if (isVoidBallActive(user, power)) {
            return ActionConditionResult.NEGATIVE;
        }

        if (isSemiVoidActive(user)) {
            return ActionConditionResult.NEGATIVE;
        }

        Entity targetEntity = target.getEntity();
        if (targetEntity instanceof LivingEntity && user.distanceTo(targetEntity) <= 4.0D) {
            return ActionConditionResult.POSITIVE;
        }
        return conditionMessage("no_target_chomp");
    }

    @Override
    public TargetRequirement getTargetRequirement() {
        return TargetRequirement.ENTITY;
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        Entity targetEntity = task.getTarget().getEntity();

        if (targetEntity instanceof LivingEntity) {
            LivingEntity livingTarget = (LivingEntity) targetEntity;

            if (!world.isClientSide) {
                livingTarget.addEffect(new EffectInstance(ModStatusEffects.STUN.get(), 20, 0, false, false));
            }
        }

        tickCounter = 0;
        hasPlayedSound = false;
        chomped = false;
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        Entity targetEntity = task.getTarget().getEntity();

        if (targetEntity instanceof LivingEntity) {
            LivingEntity livingTarget = (LivingEntity) targetEntity;

            moveCream(standEntity, livingTarget);

            tickCounter++;

            if (tickCounter >= 20) {
                livingTarget.hurt(DamageSource.GENERIC, 20.0F);

                if (!world.isClientSide && !hasPlayedSound) {
                    world.playSound(null, standEntity.getX(), standEntity.getY(), standEntity.getZ(),
                            InitSounds.CREAM_CHOMP.get(), standEntity.getSoundSource(), 1.0F, 1.0F);
                    hasPlayedSound = true;
                }

                chomped = true;
                userPower.stopHeldAction(true);
            }
        }
    }

    @Override
    public void onTaskStopped(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task, StandEntityAction newAction) {
        LivingEntity user = standEntity.getUser();

        if (chomped && !((PlayerEntity) user).isCreative()) {
            userPower.setCooldownTimer(this, CreamConfig.CHOMP_COOLDOWN.get());
        }
        chomped = false;
    }

    @Override
    public IFormattableTextComponent getTranslatedName(IStandPower power, String key) {
        String baseKey = "action.rotp_cream.cream_chomp";
        if (power == null || power.getUser() == null) {
            return new TranslationTextComponent(baseKey + ".no_chompy");
        }

        LivingEntity user = power.getUser();
        RayTraceResult rayTrace = JojoModUtil.rayTrace(user, 4.0D,
                entity -> entity instanceof LivingEntity && entity != user);

        if (rayTrace.getType() == RayTraceResult.Type.ENTITY) {
            Entity target = ((EntityRayTraceResult) rayTrace).getEntity();
            if (target != null) {
                return new TranslationTextComponent(baseKey + ".chompy", target.getName().getString());
            }
        }

        return new TranslationTextComponent(baseKey + ".no_chompy");
    }


    private void moveCream(StandEntity standEntity, LivingEntity target) {
        Vector3d targetPos = target.position();
        Vector3d lookVec = target.getLookAngle().normalize().scale(1.0D);

        standEntity.setPos(targetPos.x + lookVec.x, targetPos.y, targetPos.z + lookVec.z);
    }
}
