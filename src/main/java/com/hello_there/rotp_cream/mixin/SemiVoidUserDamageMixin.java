package com.hello_there.rotp_cream.mixin;

import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class SemiVoidUserDamageMixin {

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (CreamSemiVoidState.isSemiVoidActive(entity)) {
            Entity attacker = source.getDirectEntity();
            if (!(attacker instanceof StandEntity)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
            else if (entity.getHealth() - amount <= 0) {
                CreamSemiVoidState.cleanup(entity);
            }
        }
    }
}