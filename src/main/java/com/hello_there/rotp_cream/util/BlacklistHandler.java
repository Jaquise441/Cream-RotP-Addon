package com.hello_there.rotp_cream.util;

import com.hello_there.rotp_cream.RotpCreamAddon;
import com.hello_there.rotp_cream.config.CreamConfig;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

public class BlacklistHandler {
    private static final Set<Block> blockBlacklist = new HashSet<>();
    private static final Set<EntityType<?>> entityBlacklist = new HashSet<>();

    public static void init() {
        updateBlacklists();
    }

    private static void updateBlacklists() {
        blockBlacklist.clear();
        entityBlacklist.clear();

        for (String id : CreamConfig.VOID_BLOCK_BLACKLIST.get()) {
            Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(id));
            if (block != null) {
                blockBlacklist.add(block);
            }
        }

        for (EntityType<?> type: ForgeRegistries.ENTITIES){
            if(CreamConfig.VOID_ENTITY_BLACKLIST.get().contains(type.getRegistryName().toString())){
                entityBlacklist.add(type);
            }
        }

    }

    public static boolean isBlockBlacklisted(Block block) {
        return blockBlacklist.contains(block);
    }

    public static boolean isEntityBlacklisted(Entity entity) {
        return entityBlacklist.contains(entity.getType());
    }
}