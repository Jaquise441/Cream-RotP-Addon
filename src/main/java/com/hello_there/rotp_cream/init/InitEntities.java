package com.hello_there.rotp_cream.init;

import com.hello_there.rotp_cream.RotpCreamAddon;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = RotpCreamAddon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, RotpCreamAddon.MOD_ID
    );
};
