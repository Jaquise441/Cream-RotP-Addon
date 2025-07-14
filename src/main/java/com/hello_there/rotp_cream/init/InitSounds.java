package com.hello_there.rotp_cream.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.OstSoundList;

import com.hello_there.rotp_cream.RotpCreamAddon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, RotpCreamAddon.MOD_ID); // TODO sounds.json
    
    public static final RegistryObject<SoundEvent> CREAM_SUMMON_VOICELINE = SOUNDS.register("vanilla_ice_cream",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "vanilla_ice_cream")));

    public static final RegistryObject<SoundEvent> CREAM_SUMMON_SOUND = SOUNDS.register("cream_summon",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_summon")));
    
    public static final RegistryObject<SoundEvent> CREAM_UNSUMMON_SOUND = SOUNDS.register("cream_unsummon",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_unsummon")));
    
    public static final Supplier<SoundEvent> CREAM_PUNCH_LIGHT = ModSounds.STAND_PUNCH_LIGHT;
    
    public static final Supplier<SoundEvent> CREAM_PUNCH_HEAVY = ModSounds.STAND_PUNCH_HEAVY;
    
    public static final RegistryObject<SoundEvent> CREAM_CLAW = SOUNDS.register("cream_claw",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_claw")));

    public static final RegistryObject<SoundEvent> CREAM_ROAR = SOUNDS.register("cream_roar",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_roar")));


    public static final RegistryObject<SoundEvent> CREAM_HEAVY_CLAW = SOUNDS.register("cream_heavy_claw",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_heavy_claw")));

    public static final RegistryObject<SoundEvent> CREAM_SKULL_CRUSH = SOUNDS.register("cream_skullcrush",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_skullcrush")));


    public static final RegistryObject<SoundEvent> CREAM_ENTITY_VOID = SOUNDS.register("cream_entity_void",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_entity_void")));


    public static final RegistryObject<SoundEvent> CREAM_VOID_FORM = SOUNDS.register("cream_void_form",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_void_form")));

    public static final RegistryObject<SoundEvent> CREAM_CHOMP = SOUNDS.register("cream_chomp",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_chomp")));

    public static final RegistryObject<SoundEvent> CREAM_CHOMP_HIT = SOUNDS.register("cream_chomp_hit",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_chomp_hit")));
    public static final RegistryObject<SoundEvent> CREAM_CHOMP_START = SOUNDS.register("cream_chomp_start",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_chomp_start")));

    public static final RegistryObject<SoundEvent> CREAM_VOID_FORM_SHORT = SOUNDS.register("cream_void_form_short",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_void_form_short")));

    public static final RegistryObject<SoundEvent> CREAM_VOID = SOUNDS.register("cream_void",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_void")));


    public static final RegistryObject<SoundEvent> CREAM_VOID_START = SOUNDS.register("cream_void_start",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_void_start")));


    public static final RegistryObject<SoundEvent> CREAM_VOID_END = SOUNDS.register("cream_void_end",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_void_end")));

    public static final RegistryObject<SoundEvent> CREAM_CHOP = SOUNDS.register("cream_chop",
            () -> new SoundEvent(new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_chop")));

    public static final OstSoundList CREAM_OST = new OstSoundList(
            new ResourceLocation(RotpCreamAddon.MOD_ID, "cream_ost"), SOUNDS);
}
