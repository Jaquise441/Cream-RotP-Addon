package com.hello_there.rotp_cream.client.render.effect;

import com.hello_there.rotp_cream.RotpCreamAddon;
import com.hello_there.rotp_cream.init.InitEffects;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "rotp_cream")
public class InsideCreamRenderer {
    protected static final ResourceLocation INSIDE_CREAM = new ResourceLocation(RotpCreamAddon.MOD_ID,"textures/gui/inside_cream.png");
    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        MatrixStack matrixStack = event.getMatrixStack();
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            if (mc.player != null && (mc.player.hasEffect(InitEffects.INSIDE_CREAM.get()))) {
                mc.getTextureManager().bind(INSIDE_CREAM);
                int screenWidth = mc.getWindow().getGuiScaledWidth();
                int screenHeight = mc.getWindow().getGuiScaledHeight();

                AbstractGui.blit(matrixStack, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);

                RenderSystem.enableDepthTest();
            }
        }
    }
}