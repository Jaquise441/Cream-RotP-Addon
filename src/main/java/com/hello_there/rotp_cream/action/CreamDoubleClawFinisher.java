package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitSounds;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import static com.hello_there.rotp_cream.action.CreamSemiVoidState.isSemiVoidActive;
import static com.hello_there.rotp_cream.action.CreamVoidBall.isVoidBallActive;

public class CreamDoubleClawFinisher extends StandEntityHeavyAttack {
    public static final StandPose FINISHERCLAW = new StandPose("cream_finisherclaw");

    public CreamDoubleClawFinisher(Builder builder) {
        super(builder);
    }

    @Override
    public ActionConditionResult checkConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        if (this == InitStands.CREAM_VOID_BALL_CANCEL.get()) {
            return super.checkConditions(user, power, target);
        }

        if (isVoidBallActive(user, power)) {
            return ActionConditionResult.NEGATIVE;
        }

        if (isSemiVoidActive(user)) {
            return ActionConditionResult.NEGATIVE;
        }

        return super.checkConditions(user, power, target);
    }

    @Override
    public StandEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
        return new CreamDoubleClawInstance(stand, target, dmgSource)
                .copyProperties(super.punchEntity(stand, target, dmgSource))
                .armorPiercing((float) stand.getAttackDamage() * 0.01F)
                .disableBlocking((float) stand.getProximityRatio(target) - 0.25F)
                .reduceKnockback(15.0F);

    }

    public static class CreamDoubleClawInstance extends HeavyPunchInstance {

        public CreamDoubleClawInstance(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
            super(stand, target, dmgSource);
        }

        @Override
        protected void afterAttack(StandEntity stand, Entity target, StandEntityDamageSource dmgSource, StandEntityTask task, boolean hurt, boolean killed) {
            super.afterAttack(stand, target, dmgSource, task, hurt, killed);

            LivingEntity poopityscoop = (LivingEntity) target;

            poopityscoop.addEffect(new EffectInstance(InitEffects.BLEEDING.get(), 40, 2, false, false));

        }
    }
}
