package com.hello_there.rotp_cream.effects;

import com.github.standobyte.jojo.potion.UncurableEffect;
import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TrueBlindnessEffect extends UncurableEffect {
    public TrueBlindnessEffect(int color) {
        super(EffectType.HARMFUL, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide() && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if (player.isSprinting()) {
                player.setSprinting(false);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @SubscribeEvent
    public static void shitAss(LivingEvent.LivingUpdateEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity instanceof PlayerEntity && entity.hasEffect(InitEffects.TRUE_BLINDNESS.get())) {
            PlayerEntity player = (PlayerEntity) entity;
            if (player.isSprinting()) {
                player.setSprinting(false);
            }
        }
    }
}
