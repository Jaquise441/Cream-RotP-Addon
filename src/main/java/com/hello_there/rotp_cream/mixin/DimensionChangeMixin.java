package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.action.CreamVoidDash;
import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class DimensionChangeMixin {

    @Inject(method = "changeDimension", at = @At("HEAD"))
    private void onDimensionChange(ServerWorld newWorld, CallbackInfoReturnable<Entity> cir) {
        Entity entity = (Entity)(Object)this;

        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;

            if (CreamVoidBall.isVoidBallActive(livingEntity, null)) {
                CreamVoidBall.cleanup(livingEntity);
            }

            if (CreamVoidDash.isVoidDashActive(livingEntity)) {
                CreamVoidDash.cleanup(livingEntity);
            }

            if (CreamSemiVoidState.isSemiVoidActive(livingEntity)) {
                CreamSemiVoidState.cleanup(livingEntity);
            }

            if (livingEntity.hasEffect(InitEffects.VOIDED.get())) {
                livingEntity.removeEffect(InitEffects.VOIDED.get());
            }
        }
    }
}