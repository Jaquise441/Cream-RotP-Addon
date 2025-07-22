package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandStatFormulas;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import com.hello_there.rotp_cream.config.CreamConfig;
import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitSounds;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;

import static com.hello_there.rotp_cream.action.CreamSemiVoidState.isSemiVoidActive;
import static com.hello_there.rotp_cream.action.CreamVoidBall.isVoidBallActive;

public class CreamClaw extends StandEntityLightAttack {

    public CreamClaw(Builder builder) {
        super(builder);
    }

    @Override
    protected ActionConditionResult checkSpecificConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        if (isVoidBallActive(user, power)) {
            return ActionConditionResult.NEGATIVE;
        }

        if (isSemiVoidActive(user)) {
            return ActionConditionResult.NEGATIVE;
        }

        return super.checkSpecificConditions(user, power, target);
    }

    @Override
    public StandEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
        return new CreamClawInstance(stand, target, dmgSource)
                .copyProperties(super.punchEntity(stand, target, dmgSource))
                .impactSound(InitSounds.CREAM_CLAW)
                .damage((float) stand.getAttackDamage() - 10F)
                .reduceKnockback(1.5F);
    }

    public static class CreamClawInstance extends LightPunchInstance {

        public CreamClawInstance(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
            super(stand, target, dmgSource);
        }

        @Override
        protected void afterAttack(StandEntity stand, Entity target, StandEntityDamageSource dmgSource, StandEntityTask task, boolean hurt, boolean killed) {
            super.afterAttack(stand, target, dmgSource, task, hurt, killed);
            if(target instanceof LivingEntity){
                LivingEntity targetio = (LivingEntity) target;

                int currentLevel = targetio.hasEffect(InitEffects.BLEEDING.get()) ?
                        targetio.getEffect(InitEffects.BLEEDING.get()).getAmplifier() : -1;

                int newLevel;
                if (currentLevel < 0) {
                    newLevel = 0;
                } else if (currentLevel < 2) {
                    newLevel = currentLevel + 1;
                } else {
                    newLevel = 2;
                }

                if (currentLevel >= 0) {
                    targetio.removeEffect(InitEffects.BLEEDING.get());
                }

                targetio.addEffect(new EffectInstance(
                        InitEffects.BLEEDING.get(), 25, newLevel, false, false)
                );
            }

        }
    }
}