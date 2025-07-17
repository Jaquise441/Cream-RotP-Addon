package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class F1Mixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && (mc.player.hasEffect(InitEffects.TRUE_BLINDNESS.get()) || mc.player.hasEffect(InitEffects.INSIDE_CREAM.get()))) {
            mc.options.hideGui = false;
        }
    }
}