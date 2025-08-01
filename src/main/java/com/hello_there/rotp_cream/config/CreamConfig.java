package com.hello_there.rotp_cream.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class CreamConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue VOIDBALL_CANCEL_ON_DAMAGE;
    public static final ForgeConfigSpec.BooleanValue VOIDBALL_DELETE_ITEMS;
    public static final ForgeConfigSpec.DoubleValue VOIDBALL_STAMINA_COST_TICK;
    public static final ForgeConfigSpec.DoubleValue VOIDBALL_STAMINA_COST_TICK_VAMPIRE;
    public static final ForgeConfigSpec.IntValue VOIDBALL_DURATION;
    public static final ForgeConfigSpec.IntValue VOIDBALL_COOLDOWN;
    public static final ForgeConfigSpec.IntValue VOIDBALL_VAMPIRE_COOLDOWN;
    public static final ForgeConfigSpec.DoubleValue VOIDBALL_VAMPIRE_COOLDOWN_MULTIPLIER;
    public static final ForgeConfigSpec.IntValue VOIDBALL_VAMPIRE_MIN_COOLDOWN;
    public static final ForgeConfigSpec.BooleanValue VOIDBALL_DYNAMIC_COOLDOWN;
    public static final ForgeConfigSpec.DoubleValue VOIDBALL_DYNAMIC_COOLDOWN_MULTIPLIER;
    public static final ForgeConfigSpec.IntValue VOIDBALL_DYNAMIC_MINIMUM_COOLDOWN;
    public static final ForgeConfigSpec.BooleanValue VOIDDASH_DELETE_ITEMS;
    public static final ForgeConfigSpec.BooleanValue HAVE_VOIDDASH;
    public static final ForgeConfigSpec.IntValue VOIDDASH_COOLDOWN;
    public static final ForgeConfigSpec.BooleanValue SEMIVOID_CANCEL_ON_DAMAGE;
    public static final ForgeConfigSpec.DoubleValue SEMIVOID_STAMINA_COST_TICK;
    public static final ForgeConfigSpec.DoubleValue SEMIVOID_STAMINA_COST_TICK_VAMPIRE;
    public static final ForgeConfigSpec.IntValue SEMIVOID_DURATION;
    public static final ForgeConfigSpec.IntValue SEMIVOID_COOLDOWN;
    public static final ForgeConfigSpec.BooleanValue SEMIVOID_DYNAMIC_COOLDOWN;
    public static final ForgeConfigSpec.DoubleValue SEMIVOID_DYNAMIC_COOLDOWN_MULTIPLIER;
    public static final ForgeConfigSpec.IntValue SEMIVOID_DYNAMIC_MINIMUM_COOLDOWN;
    public static final ForgeConfigSpec.IntValue CHOP_COOLDOWN;
    public static final ForgeConfigSpec.IntValue CHOMP_COOLDOWN;
    public static final ForgeConfigSpec.IntValue EAT_ITEM_COOLDOWN;
    public static final ForgeConfigSpec.IntValue EAT_ITEM_STACK_COOLDOWN;
    public static final ForgeConfigSpec.BooleanValue PROGRESSIVE_STAMINA_COST;
    public static final ForgeConfigSpec.DoubleValue STAMINA_COST_RESOLVE_2;
    public static final ForgeConfigSpec.DoubleValue STAMINA_COST_RESOLVE_3;
    public static final ForgeConfigSpec.DoubleValue STAMINA_COST_RESOLVE_4;
    public static final ForgeConfigSpec.DoubleValue STAMINA_COST_RESOLVE_2_VAMPIRE;
    public static final ForgeConfigSpec.DoubleValue STAMINA_COST_RESOLVE_3_VAMPIRE;
    public static final ForgeConfigSpec.DoubleValue STAMINA_COST_RESOLVE_4_VAMPIRE;
    public static final ForgeConfigSpec.IntValue SEMIVOID_VAMPIRE_COOLDOWN;
    public static final ForgeConfigSpec.DoubleValue SEMIVOID_VAMPIRE_COOLDOWN_MULTIPLIER;
    public static final ForgeConfigSpec.IntValue SEMIVOID_VAMPIRE_MIN_COOLDOWN;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> VOID_BLOCK_BLACKLIST;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> VOID_ENTITY_BLACKLIST;
    public static final ForgeConfigSpec.BooleanValue VOID_INSTAKILLS;
    public static final ForgeConfigSpec.IntValue VOID_DAMAGE;
    public static final ForgeConfigSpec.IntValue VOID_DAMAGE_COOLDOWN;
    public static final ForgeConfigSpec.DoubleValue SEMIVOID_FLY_SPEED;
    public static final ForgeConfigSpec.DoubleValue SEMIVOID_FLY_SPEED_SPRINT;
    public static final ForgeConfigSpec.DoubleValue VOIDBALL_STAMINA;
    public static final ForgeConfigSpec.DoubleValue SEMIVOID_STAMINA;
    public static final ForgeConfigSpec.DoubleValue VOIDDASH_STAMINA;
    public static final ForgeConfigSpec.BooleanValue EXCLUDE_VOID_FROM_BLOCK_BREAKING;
    public static final ForgeConfigSpec.BooleanValue CONVERT_GRASS_TO_DIRT;

    static {
        BUILDER.push("Cream Chop Config");
        CHOP_COOLDOWN = BUILDER
                .comment("Cooldown (in ticks) for Cream's Chop attack. (Default is 175 ticks = 8.75 seconds)")
                .defineInRange("chopCooldown", 175, 0, 120000);
        BUILDER.pop();

        BUILDER.push("Cream Chomp Config");
        CHOMP_COOLDOWN = BUILDER
                .comment("Cooldown (in ticks) for Cream's Chomp attack. (Default is 360 ticks = 18 seconds)")
                .defineInRange("chompCooldown", 360, 0, 120000);
        BUILDER.pop();

        BUILDER.push("Cream Eat Item Config");
        EAT_ITEM_COOLDOWN = BUILDER
                .comment("Cooldown (in ticks) for the Eat Item ability. (Default is 20 ticks = 1 second)")
                .defineInRange("eatItemCooldown", 20, 0, 120000);
        EAT_ITEM_STACK_COOLDOWN = BUILDER
                .comment("Cooldown (in ticks) for the Eat Item Stack ability. (Default is 80 ticks = 4 seconds)")
                .defineInRange("eatItemStackCooldown", 80, 0, 120000);
        BUILDER.pop();

        BUILDER.push("Void-Killing and Block Breaking Config");
        VOID_INSTAKILLS = BUILDER
                .comment("Whether entities should be instantly killed by Enter the Void and Void Dash (true) or take damage instead (false). If it is set to false (so damaging instead) the deletion sound only plays if the entity dies, so there is no indication on if you hit an entity or not. (Default is true)")
                .define("voidInstaKills", true);
        VOID_DAMAGE = BUILDER
                .comment("Amount of void damage to deal when Instakilling Void  is set to false. (Default is 30")
                .defineInRange("voidDamage", 30, 0,120000);
        VOID_DAMAGE_COOLDOWN = BUILDER
                .comment("Cooldown (in ticks) between each damaging of an entity by the void. This means that if an entity that has more health than what Cream does as damage while in Enter the Void, it takes (by default) 20 ticks for the entity to get damaged by the void again if they are still in it. In other words, it's invisibility frames. Should be obvious, but this only works if Instakilling Void is set to false. (Default is 20 = 1 second)")
                .defineInRange("voidDamageCooldown", 20, 0, 120000);
        EXCLUDE_VOID_FROM_BLOCK_BREAKING = BUILDER
                .comment("Whether Enter the Void or Void Dash should ignore the jojoAbilitiesBreakBlocks gamerule and always break blocks (true) or abide by the gamerule (false). (Default is false)")
                .define("excludeVoidFromBlockBreaking", false);
        CONVERT_GRASS_TO_DIRT = BUILDER
                .comment("Whether Enter the Void and Void Dash should scrape the grass off of grassy blocks (grass, mycelium, podzol) and convert it to dirt (true) or don't (false) (Default is true)")
                .define("convertGrassToDirt", true);
        BUILDER.pop();

        BUILDER.push("Cream Enter the Void Config");
        VOIDBALL_STAMINA = BUILDER
                .comment("Stamina cost of Enter the Void (Default is 360) (Version 1.0 had 80)")
                .defineInRange("voidBallStaminaCost", 360.0, 0.0, 10000.0);
        VOIDBALL_CANCEL_ON_DAMAGE = BUILDER
                .comment("Whether Enter the Void should be cancelled during the wind-up process when you takes damage. (Default is true)")
                .define("voidBallCancelOnDamage", true);
        VOIDBALL_DELETE_ITEMS = BUILDER
                .comment("Whether items on the ground should be deleted during Enter the Void (true) or left untouched (false). (Default is false) (WARNING: It is NOT recommended for this to be turned of if you are playing in a server. This config is here directly so that player's inventories won't be deleted if they die from Cream's Enter the Void.)")
                .define("voidBallDeleteItems", false);
        VOIDBALL_STAMINA_COST_TICK = BUILDER
                .comment("Stamina cost per tick while using Enter the Void. Only works if Progressive Stamina Cost Per Tick is turned off. (Default is 1.0 stamina per tick)")
                .defineInRange("voidBallStaminaCostTick", 1.0, 0.0, 100.0);
        VOIDBALL_DURATION = BUILDER
                .comment("Maximum duration for Enter the Void in ticks. (20 ticks = 1 second, Default is Integer.MAX_VALUE)")
                .defineInRange("voidBallDuration", Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        VOIDBALL_COOLDOWN = BUILDER
                .comment("Cooldown for Enter the Void in ticks. Only works when Dynamic Cooldown is disabled. (Default is 240 ticks = 12 seconds)")
                .defineInRange("voidBallCooldown", 240, 0, 120000);
        VOIDBALL_DYNAMIC_COOLDOWN = BUILDER
                .comment("Toggle for whether Enter the Void should use dynamic cooldown based on usage duration. (Default is true)")
                .define("voidBallDynamicCooldown", true);
        VOIDBALL_DYNAMIC_MINIMUM_COOLDOWN = BUILDER
                .comment("Minimum cooldown for Enter the Void when using dynamic cooldown. (Default is 120 ticks = 6 seconds) (Prevents extremely short cooldowns from brief uses)")
                .defineInRange("voidBallDynamicMinimumCooldown", 120, 0, 120000);
        VOIDBALL_DYNAMIC_COOLDOWN_MULTIPLIER = BUILDER
                .comment("Multiplier for calculating Enter the Void's dynamic cooldown. (Default is 2.0) (2.0 means cooldown equals double the usage time)")
                .defineInRange("voidBallDynamicCooldownMultiplier", 2.0, 0.0, 10.0);
        BUILDER.pop();

        BUILDER.push("Cream Void Dash Config");
        HAVE_VOIDDASH = BUILDER
                .comment("Whether to have the Void Dash ability available while you are using Enter Cream (true) or not have it even show up (false). (Default is true)")
                .define("haveVoidDash", true);
        VOIDDASH_STAMINA = BUILDER
                .comment("Stamina cost of Enter Cream (Default is 300) (Version 1.0 had 150)")
                .defineInRange("voidBallStaminaCost", 300.0, 0.0, 10000.0);
        VOIDDASH_DELETE_ITEMS = BUILDER
                .comment("Whether items on the ground should be deleted during Void Dash (true) or left untouched (false). (Default is false) (WARNING: It is NOT recommended for this to be turned of if you are playing in a server. This config is here directly so that player's inventories won't be deleted if they die from Cream's Enter the Void.)")
                .define("voidDashDeleteItems", false);
        VOIDDASH_COOLDOWN = BUILDER
                .comment("Cooldown (in ticks) for Void Dash. (Default is 240 ticks = 12 seconds)")
                .defineInRange("voidDashCooldown", 240, 0, 120000);
        BUILDER.pop();

        BUILDER.push("Cream Enter Cream Config");
        SEMIVOID_STAMINA = BUILDER
                .comment("Stamina cost of Enter Cream (Default is 300) (Version 1.0 had 0 cause I forgor)")
                .defineInRange("voidBallStaminaCost", 300.0, 0.0, 10000.0);
        SEMIVOID_CANCEL_ON_DAMAGE = BUILDER
                .comment("Whether Enter Cream should be cancelled during the wind-up process when you takes damage. (Default is true)")
                .define("samiVoidCancelOnDamage", true);
        SEMIVOID_STAMINA_COST_TICK = BUILDER
                .comment("Stamina cost per tick while in Enter Cream. Only works if Progressive Stamina Cost Per Tick is turned off. (Default is 2.0 stamina per tick)")
                .defineInRange("semiVoidStaminaCostTick", 2.0, 0.0, 100.0);
        SEMIVOID_DURATION = BUILDER
                .comment("Maximum (in ticks) duration for Enter Cream. (Default is Integer.MAX_VALUE)")
                .defineInRange("semiVoidDuration", Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        SEMIVOID_COOLDOWN = BUILDER
                .comment("Cooldown for Enter Cream in ticks. Only works when Dynamic Cooldown is disabled. (Default is 240 ticks = 12 seconds)")
                .defineInRange("semiVoidCooldown", 240, 0, 120000);
        SEMIVOID_DYNAMIC_COOLDOWN = BUILDER
                .comment("Toggle for whether Enter Cream should use dynamic cooldown based on usage duration. (Default is true)")
                .define("semiVoidDynamicCooldown", true);
        SEMIVOID_DYNAMIC_COOLDOWN_MULTIPLIER = BUILDER
                .comment("Multiplier for calculating Enter Cream's dynamic cooldown. (Default is 1.5) (1.5 means cooldown equals 1.5x the usage time)")
                .defineInRange("semiVoidDynamicCooldownMultiplier", 1.5, 0.0, 10.0);
        SEMIVOID_DYNAMIC_MINIMUM_COOLDOWN = BUILDER
                .comment("Minimum cooldown for Enter Cream when using dynamic cooldown. (Default is 120 ticks = 6 seconds) (Prevents extremely short cooldowns from brief uses)")
                .defineInRange("semiVoidDynamicMinimumCooldown", 120, 0, 120000);
        SEMIVOID_FLY_SPEED = BUILDER
                .comment("Base flying speed while in Enter Cream (Default is 0.04) (The defualt fly speed during creative mode is 0.05)")
                .defineInRange("semiVoidFlySpeed", 0.04, 0, 1.0);
        SEMIVOID_FLY_SPEED_SPRINT = BUILDER
                .comment("Flying speed while sprinting in Enter Cream (Default is 0.02) (Keep in mind you need to lower this to be at least 0.02 LESS then the base speed, to not let spring-flying be a thing. If you want sprint-flying to be a thing, set it to be the same as the base flying speed, so by default 0.04 in this case.)")
                .defineInRange("semiVoidFlySpeedSprint", 0.02, 0, 1.0);
        BUILDER.pop();

        BUILDER.push("Cream Stamina Config for Enter the Void and Enter Cream");
        PROGRESSIVE_STAMINA_COST = BUILDER
                .comment("Whether stamina cost should be scaled with your resolve level (true) or use the other configs in their respective sections (false). (Default is true)")
                .define("progressiveStaminaCost", true);

        STAMINA_COST_RESOLVE_2 = BUILDER
                .comment("Stamina cost per tick when your resolve level is 2. (Default is 7.0) (Version 1.0 had 10.0 as the default)")
                .defineInRange("staminaCostResolve2", 7.0, 0.0, 12000.0);

        STAMINA_COST_RESOLVE_3 = BUILDER
                .comment("Stamina cost per tick when your resolve level is 3. (Default is 5.0) (Version 1.0 had 7.0 as the default)")
                .defineInRange("staminaCostResolve3", 5.0, 0.0, 12000.0);

        STAMINA_COST_RESOLVE_4 = BUILDER
                .comment("Stamina cost per tick when your resolve level is 4. (Default is 3.0) (Version 1.0 had 4.0 as the default)")
                .defineInRange("staminaCostResolve4", 3.0, 0.0, 12000.0);
        BUILDER.pop();

        BUILDER.push("Vampire-Specific Configs");
        VOIDBALL_VAMPIRE_COOLDOWN = BUILDER
                .comment("Cooldown for Vampires using Enter the Void in ticks. Only works when Dynamic Cooldown is disabled. (Default is 200 ticks = 10 seconds) ")
                .defineInRange("voidBallVampireBaseCooldown", 200, 0, 120000);
        VOIDBALL_STAMINA_COST_TICK_VAMPIRE = BUILDER
                .comment("Stamina cost per tick while using Enter the Void as a Vampire. Only works if Progressive Stamina Cost Per Tick is turned off. (Default is 1.0 stamina per tick)")
                .defineInRange("voidBallStaminaCostTickVamp", 1.0, 0.0, 100.0);
        VOIDBALL_VAMPIRE_COOLDOWN_MULTIPLIER = BUILDER
                .comment("Multiplier for calculating Enter the Void's dynamic cooldown as a Vampire. (Default is 1.5) (1.5 means 50% longer cooldown than normal)")
                .defineInRange("voidBallVampireCooldownMultiplier", 1.5, 0.0, 10.0);
        VOIDBALL_VAMPIRE_MIN_COOLDOWN = BUILDER
                .comment("Minimum cooldown for Enter the Void when using dynamic cooldown when you are a Vampire. (Default is 100 ticks = 5 seconds)")
                .defineInRange("voidBallVampireMinCooldown", 100, 0, 120000);
        STAMINA_COST_RESOLVE_2_VAMPIRE = BUILDER
                .comment("Stamina cost per tick when your resolve level is 2 as a Vampire. (Default is 6.0) (Version 1.0 had 5.5 as the default)")
                .defineInRange("staminaCostResolve2Vamp", 6.0, 0.0, 12000.0);
        STAMINA_COST_RESOLVE_3_VAMPIRE = BUILDER
                .comment("Stamina cost per tick when your resolve level is 3 as a Vampire. (Default is 4.0) (Version 1.0 had 3.5 as the default)")
                .defineInRange("staminaCostResolve3Vamp", 4.0, 0.0, 12000.0);
        STAMINA_COST_RESOLVE_4_VAMPIRE = BUILDER
                .comment("Stamina cost per tick when your resolve level is 4 as a Vampire. (Default is 2.0) (Version 1.0 had 1.5 as the default)")
                .defineInRange("staminaCostResolve4Vamp", 2.0, 0.0, 12000.0);
        SEMIVOID_STAMINA_COST_TICK_VAMPIRE = BUILDER
                .comment("Stamina cost per tick while in Enter Cream as a Vampire. Only works if Progressive Stamina Cost Per Tick is turned off. (Default is 2.0 stamina per tick)")
                .defineInRange("semiVoidStaminaCostTickVamp", 1.5, 0.0, 100.0);
        SEMIVOID_VAMPIRE_COOLDOWN = BUILDER
                .comment("Cooldown for Vampires using Enter Cream in ticks. Only works when Dynamic Cooldown is disabled. (Default is 200 ticks = 10 seconds)")
                .defineInRange("semiVoidVampireCooldown", 200, 0, 120000);
        SEMIVOID_VAMPIRE_COOLDOWN_MULTIPLIER = BUILDER
                .comment("Multiplier for calculating Enter Cream's dynamic cooldown as a Vampire. (Default is 1.5) (1.5 means 50% longer cooldown than normal)")
                .defineInRange("semiVoidVampireCooldownMultiplier", 1.25, 0.0, 10.0);
        SEMIVOID_VAMPIRE_MIN_COOLDOWN = BUILDER
                .comment("Minimum cooldown for Enter Cream when using dynamic cooldown as a Vampire. (Default is 100 ticks = 5 seconds)")
                .defineInRange("semiVoidVampireMinCooldown", 100, 0, 120000);
        BUILDER.pop();

        BUILDER.push("Blacklist Configs for Enter the Void and Void Dash");
        VOID_BLOCK_BLACKLIST = BUILDER
                .comment("List of blocks that should not be affected by Enter the Void and Void Dash (format: modid:blockname) (yes, this does support modded blocks, just get the correct id for it.")
                .defineList("blockBlacklist", Arrays.asList(
                        "minecraft:bedrock",
                        "minecraft:barrier",
                        "minecraft:command_block",
                        "minecraft:repeating_command_block",
                        "minecraft:chain_command_block",
                        "minecraft:structure_block",
                        "minecraft:structure_void",
                        "minecraft:end_portal",
                        "minecraft:end_portal_frame",
                        "minecraft:nether_portal",
                        "minecraft:end_gateway",
                        "gravestone:gravestone"
                ), obj -> obj instanceof String);
        VOID_ENTITY_BLACKLIST = BUILDER
                .comment("List of entities that should not be affected by Enter the Void and Void Dash (format: modid:entityname) (yes, this does support modded entities, just get the correct id for it.")
                .defineList("entityBlacklist", Arrays.asList(
                        "minecraft:ender_dragon",
                        "minecraft:wither",
                        "corpse:corpse",
                        "enigmaticgraves:grave"
                ), obj -> obj instanceof String);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}