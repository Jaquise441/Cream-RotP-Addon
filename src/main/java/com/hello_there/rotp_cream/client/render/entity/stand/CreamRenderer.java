package com.hello_there.rotp_cream.client.render.entity.stand;

import com.hello_there.rotp_cream.RotpCreamAddon;
import com.hello_there.rotp_cream.entity.CreamEntity;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class CreamRenderer extends StandEntityRenderer<CreamEntity, StandEntityModel<CreamEntity>> {

    public CreamRenderer(EntityRendererManager renderManager) {
        super(renderManager, new CreamModel(),
                new ResourceLocation(RotpCreamAddon.MOD_ID, "textures/entity/stand/cream.png"), 0);
    }
}