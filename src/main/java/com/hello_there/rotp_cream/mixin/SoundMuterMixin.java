package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundEngine;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundEngine.class)
public class SoundMuterMixin {
    @Inject(method = "play", at = @At("HEAD"), cancellable = true)
    private void onPlaySound(ISound sound, CallbackInfo ci) {
        ClientPlayerEntity player = Minecraft.getInstance().player;

        if (player != null && player.hasEffect(InitEffects.TRUE_BLINDNESS.get())) {
            ResourceLocation soundLocation = sound.getLocation();

            if (!soundLocation.equals(InitSounds.CREAM_VOID_FORM_SHORT.get().getRegistryName()) &&
                    !soundLocation.equals(InitSounds.CREAM_VOID.get().getRegistryName()) &&
                    !soundLocation.equals(InitSounds.CREAM_VOID_START.get().getRegistryName()) &&
                    !soundLocation.equals(InitSounds.CREAM_VOID_END.get().getRegistryName())) {

                ci.cancel();
            }
        }
    }
}