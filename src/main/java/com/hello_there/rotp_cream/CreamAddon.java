package com.hello_there.rotp_cream;

import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitEntities;
import com.hello_there.rotp_cream.init.InitSounds;
import com.hello_there.rotp_cream.init.InitStands;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// Your addon's main file

@Mod(com.hello_there.rotp_cream.CreamAddon.MOD_ID)
public class CreamAddon {
    // The mod's id. Used quite often, mostly when creating ResourceLocation (objects).
    // Its value should match the "modid" entry in the META-INF/mods.toml file
    public static final String MOD_ID = "rotp_cream";
    public static final Logger LOGGER = LogManager.getLogger();

    public CreamAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // All DeferredRegister objects are registered here.
        // A DeferredRegister needs to be created for each type of objects that need to be registered in the game 
        // (see ForgeRegistries or JojoCustomRegistries)
        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);
        InitEffects.EFFECTS.register(modEventBus);
    }
}
