package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.action.CreamVoidDash;
import com.hello_there.rotp_cream.init.InitStands;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.player.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerLogoutMixin {

    @Inject(method = "disconnect", at = @At("HEAD"))
    private void onPlayerDisconnect(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity)(Object)this;

        IStandPower.getStandPowerOptional(player).ifPresent(standPower -> {
            if (standPower.getType() == InitStands.CREAM.getStandType()) {
                CreamVoidBall.cleanup(player);
                CreamVoidDash.cleanup(player);
                CreamSemiVoidState.cleanup(player);
            }
        });
    }
}