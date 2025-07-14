package com.hello_there.rotp_cream.init;

import com.hello_there.rotp_cream.RotpCreamAddon;
import com.hello_there.rotp_cream.block.VoidBarrierBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, RotpCreamAddon.MOD_ID
    );

    public static final RegistryObject<Block> VOID_BARRIER = BLOCKS.register("void_barrier",
            () -> new VoidBarrierBlock(Block.Properties.copy(Blocks.BARRIER)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}