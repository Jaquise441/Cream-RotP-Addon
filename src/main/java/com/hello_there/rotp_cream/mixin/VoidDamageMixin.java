package com.hello_there.rotp_cream.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class VoidDamageMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        Entity entity = (Entity)(Object)this;

        if (entity.getY() < -9000) {
            if (entity instanceof LivingEntity) {
                LivingEntity living = (LivingEntity) entity;
                living.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
            } else {
                entity.remove();
            }
        }
    }
}