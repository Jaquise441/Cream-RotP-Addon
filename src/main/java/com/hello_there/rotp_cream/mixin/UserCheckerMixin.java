package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.action.CreamVoidDash;
import net.minecraft.entity.player.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class UserCheckerMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        if (!player.isAlive()) {
            CreamSemiVoidState.cleanup(player);
            return;
        }

        if (!player.isCreative() && !player.isSpectator()) {
            boolean inAnyState = CreamSemiVoidState.isSemiVoidActive(player) ||
                    CreamVoidBall.isVoidBallActive(player, null) ||
                    CreamVoidDash.isVoidDashActive(player);

            if (!inAnyState) {
                player.abilities.invulnerable = false;
                player.abilities.flying = false;
                player.abilities.mayfly = false;
                //player.removeEffect(InitEffects.TRUE_BLINDNESS.get());
                player.onUpdateAbilities();
            }
        }
    }
}