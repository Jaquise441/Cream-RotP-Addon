package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class CreamChomp extends StandEntityAction {
    public static final StandPose CHOMP = new StandPose("cream_chomp");

    private int tickCounter = 0;

    public CreamChomp(Builder builder) {
        super(builder);
    }

    @Override
    public ActionConditionResult checkTarget(ActionTarget target, LivingEntity user, IStandPower power) {
        if (power.getHeldAction() instanceof CreamVoidBall && ((CreamVoidBall) power.getHeldAction()).isVoidBallActive()) {
            return ActionConditionResult.createNegative(ITextComponent.nullToEmpty("Cannot use this ability while Void Ball is active."));
        } //heheheha

        Entity targetEntity = target.getEntity();
        if (targetEntity instanceof LivingEntity && user.distanceTo(targetEntity) <= 4.0D) {
            return ActionConditionResult.POSITIVE;
        }
        return conditionMessage("no_target");
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
                livingTarget.addEffect(new EffectInstance(ModStatusEffects.STUN.get(), 20, 0));
            }
        }

        tickCounter = 0;
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
                userPower.stopHeldAction(true);
            }
        }
    }

    private void moveCream(StandEntity standEntity, LivingEntity target) {
        Vector3d targetPos = target.position();
        Vector3d lookVec = target.getLookAngle().normalize().scale(1.0D);

        standEntity.setPos(targetPos.x + lookVec.x, targetPos.y, targetPos.z + lookVec.z);
    }
}
