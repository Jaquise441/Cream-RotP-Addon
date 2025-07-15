package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.action.CreamVoidDash;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class SpectatorMixin {
    @Inject(method = "setGameMode", at = @At("HEAD"))
    private void onGameModeChange(GameType newGameMode, CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity)(Object)this;
        if (newGameMode == GameType.SPECTATOR) {
            CreamVoidBall.cleanup(player);
            CreamVoidDash.cleanup(player);
            CreamSemiVoidState.cleanup(player);
        }
    }
}
