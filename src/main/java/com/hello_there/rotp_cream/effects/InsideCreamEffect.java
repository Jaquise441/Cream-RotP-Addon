package com.hello_there.rotp_cream.effects;

import com.github.standobyte.jojo.potion.UncurableEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectType;

public class InsideCreamEffect extends UncurableEffect {
    public InsideCreamEffect(int color) {
        super(EffectType.HARMFUL, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}