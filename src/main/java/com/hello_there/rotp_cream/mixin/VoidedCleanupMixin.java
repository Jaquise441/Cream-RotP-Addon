package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.action.CreamVoidDash;
import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class VoidedCleanupMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity.hasEffect(InitEffects.VOIDED.get())) {
            boolean shouldRemove = true;

            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                if (CreamVoidBall.isVoidBallActive(player, null) ||
                        CreamVoidDash.isVoidDashActive(player)) {
                    shouldRemove = false;
                }
            }

            if (shouldRemove) {
                entity.removeEffect(InitEffects.VOIDED.get());
            }
        }
    }
}