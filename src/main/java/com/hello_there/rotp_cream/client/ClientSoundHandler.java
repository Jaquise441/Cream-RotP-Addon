package com.hello_there.rotp_cream.client;

import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientSoundHandler {
    private static final Set<ResourceLocation> ALLOWED_SOUNDS = new HashSet<>();

    private static Set<ResourceLocation> getAllowedSounds() {
        if (ALLOWED_SOUNDS.isEmpty()) {
            ALLOWED_SOUNDS.add(InitSounds.CREAM_VOID_FORM_SHORT.getId());
            ALLOWED_SOUNDS.add(InitSounds.CREAM_VOID.getId());
            ALLOWED_SOUNDS.add(InitSounds.CREAM_VOID_START.getId());
            ALLOWED_SOUNDS.add(InitSounds.CREAM_VOID_END.getId());
        }
        return ALLOWED_SOUNDS;
    }

    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent event) {
        PlayerEntity player = Minecraft.getInstance().player;
        if (player != null && player.hasEffect(InitEffects.TRUE_BLINDNESS.get())) {
            ResourceLocation soundLocation = event.getSound().getLocation();
            if (!getAllowedSounds().contains(soundLocation)) {
                event.setResultSound(null);
            }
        }
    }
}