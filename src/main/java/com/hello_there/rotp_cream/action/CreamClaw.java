package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;

public class CreamClaw extends StandEntityLightAttack {

    public CreamClaw(Builder builder) {
        super(builder);
    }

    @Override
    protected ActionConditionResult checkSpecificConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        if (power.getHeldAction() instanceof CreamVoidBall && ((CreamVoidBall) power.getHeldAction()).isVoidBallActive()) {
            return ActionConditionResult.createNegative(ITextComponent.nullToEmpty("Cannot use this ability while Void Ball is active."));
        } //dumb fuckass shit

        return super.checkSpecificConditions(user, power, target);
    }

    @Override
    public StandEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
        return new CreamClawInstance(stand, target, dmgSource)
                .copyProperties(super.punchEntity(stand, target, dmgSource))
                .armorPiercing((float) stand.getAttackDamage() * 0.01F)
                .disableBlocking((float) stand.getProximityRatio(target) - 0.25F)
                .impactSound(InitSounds.CREAM_CLAW)
                .damage((float) stand.getAttackDamage() * 0.75F)
                .reduceKnockback(1.5F);

    }

    public static class CreamClawInstance extends LightPunchInstance {

        public CreamClawInstance(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
            super(stand, target, dmgSource);
        }

        @Override
        protected void afterAttack(StandEntity stand, Entity target, StandEntityDamageSource dmgSource, StandEntityTask task, boolean hurt, boolean killed) {
            super.afterAttack(stand, target, dmgSource, task, hurt, killed);

            if (hurt && target instanceof LivingEntity) {
                LivingEntity livingTarget = (LivingEntity) target;

                livingTarget.addEffect(new EffectInstance(ModStatusEffects.BLEEDING.get(), 25, 0, false, false));
                livingTarget.addEffect(new EffectInstance(InitEffects.BLEEDING.get(), 25, 2, false, false));
            }
        }
    }
}
