package com.hello_there.rotp_cream.effects;

import com.github.standobyte.jojo.potion.UncurableEffect;
import com.hello_there.rotp_cream.RotpCreamAddon;
import net.minecraft.entity.LivingEntity;
import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BleedingEffect extends UncurableEffect {
    public BleedingEffect(int color) {
        super(EffectType.HARMFUL, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide()) {
            if (amplifier == 0) amplifier = 1;
            if (entity.tickCount % amplifier == 0)
                if (entity.isAlive())
                    entity.hurt(DamageSource.MAGIC, (float) amplifier / 2);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Mod.EventBusSubscriber(modid = RotpCreamAddon.MOD_ID)
    public static class Events {
        @SubscribeEvent
        public static void onLivingHeal(LivingHealEvent event) {
            LivingEntity entity = (LivingEntity) event.getEntity();
            if (entity.hasEffect(InitEffects.BLEEDING.get()))
                event.setCanceled(true);
        }
    }
}
