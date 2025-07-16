package com.hello_there.rotp_cream.effects;

import com.github.standobyte.jojo.potion.UncurableEffect;
import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WeakNeckEffect extends UncurableEffect {
    public WeakNeckEffect(int color) {
        super(EffectType.HARMFUL, color);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide) {
            if (entity instanceof PlayerEntity) {
            } else {
                if (entity.getRandom().nextFloat() < 0.05F * (amplifier + 1)) {
                    entity.hurt(DamageSource.GENERIC, 1.0F);
                    entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, amplifier + 1, false, false));
                    entity.addEffect(new EffectInstance(Effects.WEAKNESS, 100, amplifier + 1, false, false));
                    entity.setDeltaMovement(entity.getDeltaMovement().add(0, -0.5F, 0));
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = "rotp_cream", value = Dist.CLIENT)
    public static class ClientEventHandler {
        private static final Map<UUID, Float> OS = new HashMap<>();
        private static final float SM = 1.55F;

        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
                Minecraft mc = Minecraft.getInstance();
                PlayerEntity player = mc.player;

                if (player != null) {
                    UUID playerId = player.getUUID();

                    if (player.hasEffect(InitEffects.WEAK_NECK.get())) {
                        if (!OS.containsKey(playerId)) {
                            OS.put(playerId, (float) mc.options.sensitivity);
                        }

                        mc.options.sensitivity = OS.get(playerId) * SM;
                    } else if (OS.containsKey(playerId)) {
                        mc.options.sensitivity = OS.get(playerId);
                        OS.remove(playerId);
                    }
                }
            }
        }
    }
}