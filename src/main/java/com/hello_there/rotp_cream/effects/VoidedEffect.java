package com.hello_there.rotp_cream.effects;

import com.github.standobyte.jojo.potion.UncurableEffect;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.hello_there.rotp_cream.RotpCreamAddon;
import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class VoidedEffect extends UncurableEffect {
    public VoidedEffect(int color) {
        super(EffectType.NEUTRAL, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide()) {
            int duration = entity.getEffect(this).getDuration();

            entity.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), duration, 0, false, false));
            entity.addEffect(new EffectInstance(Effects.INVISIBILITY, duration, 0, false, false));
            entity.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, duration, 6, false, false));
            entity.addEffect(new EffectInstance(InitEffects.TRUE_BLINDNESS.get(), duration, 0, false, false));

            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                if (!player.isCreative()) {
                    player.abilities.invulnerable = true;
                }
            }
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, net.minecraft.entity.ai.attributes.AttributeModifierManager attributeManager, int amplifier) {
        super.removeAttributeModifiers(entity, attributeManager, amplifier);

        entity.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());
        entity.removeEffect(Effects.INVISIBILITY);
        entity.removeEffect(Effects.MOVEMENT_SPEED);
        entity.removeEffect(Effects.BLINDNESS);
        entity.removeEffect(InitEffects.TRUE_BLINDNESS.get());

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.isCreative()) {
                player.abilities.invulnerable = false;
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Mod.EventBusSubscriber(modid = RotpCreamAddon.MOD_ID)
    public static class Events {
        @SubscribeEvent
        public static void onBlockBreak(PlayerEvent.BreakSpeed event) {
            PlayerEntity player = event.getPlayer();
            if (player.hasEffect(InitEffects.VOIDED.get())) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onItemPickup(EntityItemPickupEvent event) {
            PlayerEntity player = event.getPlayer();
            if (player.hasEffect(InitEffects.VOIDED.get())) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
            if (event.getEntity() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) event.getEntity();
                if (player.hasEffect(InitEffects.VOIDED.get())) {
                    event.setCanceled(true);
                }
            }
        }

        @SubscribeEvent
        public static void onEntityAttack(LivingAttackEvent event) {
            if (event.getSource().getEntity() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
                if (player.hasEffect(InitEffects.VOIDED.get())) {
                    event.setCanceled(true);
                }
            }
        }

        @SubscribeEvent
        public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
            PlayerEntity player = event.getPlayer();
            if (player.hasEffect(InitEffects.VOIDED.get())) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
            PlayerEntity player = event.getPlayer();
            if (player.hasEffect(InitEffects.VOIDED.get())) {
                event.setCanceled(true);
            }
        }
    }
}