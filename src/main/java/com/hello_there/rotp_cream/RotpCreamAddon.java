package com.hello_there.rotp_cream;

import com.hello_there.rotp_cream.config.CreamConfig;
import com.hello_there.rotp_cream.init.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RotpCreamAddon.MOD_ID)
public class RotpCreamAddon {
    public static final String MOD_ID = "rotp_cream";
    public static final Logger LOGGER = LogManager.getLogger();

    public RotpCreamAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);
        InitEffects.EFFECTS.register(modEventBus);
        InitBlocks.BLOCKS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CreamConfig.SPEC, "rotp_cream.toml");

    }
}