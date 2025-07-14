package com.hello_there.rotp_cream.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CreamConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue VOIDBALL_CANCEL_ON_DAMAGE;
    public static final ForgeConfigSpec.BooleanValue VOIDBALL_DELETE_ITEMS;
    public static final ForgeConfigSpec.DoubleValue VOIDBALL_STAMINA_COST_TICK;
    public static final ForgeConfigSpec.IntValue VOIDBALL_DURATION;
    public static final ForgeConfigSpec.IntValue VOIDBALL_COOLDOWN;
    public static final ForgeConfigSpec.IntValue VOIDBALL_VAMPIRE_COOLDOWN;
    public static final ForgeConfigSpec.DoubleValue VOIDBALL_VAMPIRE_COOLDOWN_MULTIPLIER;
    public static final ForgeConfigSpec.IntValue VOIDBALL_VAMPIRE_MIN_COOLDOWN;
    public static final ForgeConfigSpec.BooleanValue VOIDBALL_DYNAMIC_COOLDOWN;
    public static final ForgeConfigSpec.DoubleValue VOIDBALL_DYNAMIC_COOLDOWN_MULTIPLIER;
    public static final ForgeConfigSpec.IntValue VOIDBALL_DYNAMIC_MINIMUM_COOLDOWN;
    public static final ForgeConfigSpec.BooleanValue VOIDDASH_DELETE_ITEMS;
    public static final ForgeConfigSpec.IntValue VOIDDASH_COOLDOWN;
    public static final ForgeConfigSpec.BooleanValue SEMIVOID_CANCEL_ON_DAMAGE;
    public static final ForgeConfigSpec.DoubleValue SEMIVOID_STAMINA_COST_TICK;
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

        BUILDER.push("Cream Void Ball Config");
        VOIDBALL_CANCEL_ON_DAMAGE = BUILDER
                .comment("Whether Void Ball should be cancelled during the wind-up process when you takes damage. (Default is true)")
                .define("voidBallCancelOnDamage", true);
        VOIDBALL_DELETE_ITEMS = BUILDER
                .comment("Whether items on the ground should be deleted during Void Ball (true) or left untouched (false). (Default is false) (WARNING: It is NOT recommended for this to be turned of if you are playing in a server. This config is here directly so that player's inventories won't be deleted if they die from Cream's Void Ball.)")
                .define("voidBallDeleteItems", false);
        VOIDBALL_STAMINA_COST_TICK = BUILDER
                .comment("Stamina cost per tick while using Void Ball. Only works if Progressive Stamina Cost Per Tick is turned off. (Default is 1.0 stamina per tick)")
                .defineInRange("voidBallStaminaCostTick", 1.0, 0.0, 100.0);
        VOIDBALL_DURATION = BUILDER
                .comment("Maximum duration for Void Ball in ticks. (20 ticks = 1 second, Default is Integer.MAX_VALUE)")
                .defineInRange("voidBallDuration", Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        VOIDBALL_COOLDOWN = BUILDER
                .comment("Cooldown for Void Ball in ticks. Only works when Dynamic Cooldown is disabled. (Default is 240 ticks = 12 seconds)")
                .defineInRange("voidBallCooldown", 240, 0, 120000);
        VOIDBALL_DYNAMIC_COOLDOWN = BUILDER
                .comment("Toggle for whether Void Ball should use dynamic cooldown based on usage duration. (Default is true)")
                .define("voidBallDynamicCooldown", true);
        VOIDBALL_DYNAMIC_COOLDOWN_MULTIPLIER = BUILDER
                .comment("Multiplier for calculating Void Ball's dynamic cooldown. (Default is 2.0) (2.0 means cooldown equals double the usage time)")
                .defineInRange("voidBallDynamicCooldownMultiplier", 2.0, 0.0, 10.0);
        VOIDBALL_DYNAMIC_MINIMUM_COOLDOWN = BUILDER
                .comment("Minimum cooldown for Void Ball when using dynamic cooldown. (Default is 120 ticks = 6 seconds) (Prevents extremely short cooldowns from brief uses)")
                .defineInRange("voidBallDynamicMinimumCooldown", 120, 0, 120000);
        VOIDBALL_VAMPIRE_COOLDOWN = BUILDER
                .comment("Cooldown for Vampires using Void Ball in ticks. Only works when Dynamic Cooldown is disabled. (Default is 200 ticks = 10 seconds)")
                .defineInRange("voidBallVampireBaseCooldown", 200, 0, 120000);
        VOIDBALL_VAMPIRE_COOLDOWN_MULTIPLIER = BUILDER
                .comment("Multiplier for calculating Void Ball's dynamic cooldown for Vampires. (Default is 1.5) (1.5 means 50% longer cooldown than normal)")
                .defineInRange("voidBallVampireCooldownMultiplier", 1.5, 0.0, 10.0);
        VOIDBALL_VAMPIRE_MIN_COOLDOWN = BUILDER
                .comment("Minimum cooldown for Void Ball when using dynamic cooldown when you are a Vampire. (Default is 100 ticks = 5 seconds)")
                .defineInRange("voidBallVampireMinCooldown", 100, 0, 120000);
        BUILDER.pop();

        BUILDER.push("Cream Void Dash Config");
        VOIDDASH_DELETE_ITEMS = BUILDER
                .comment("Whether items on the ground should be deleted during Void Dash (true) or left untouched (false). (Default is false) (WARNING: It is NOT recommended for this to be turned of if you are playing in a server. This config is here directly so that player's inventories won't be deleted if they die from Cream's Void Ball.)")
                .define("voidDashDeleteItems", false);
        VOIDDASH_COOLDOWN = BUILDER
                .comment("Cooldown (in ticks) for Void Dash. (Default is 240 ticks = 12 seconds)")
                .defineInRange("voidDashCooldown", 240, 0, 120000);
        BUILDER.pop();

        BUILDER.push("Cream Semi-Void State Config");
        SEMIVOID_CANCEL_ON_DAMAGE = BUILDER
                .comment("Whether Semi-Void State should be cancelled during the wind-up process when you takes damage. (Default is true)")
                .define("samiVoidCancelOnDamage", true);
        SEMIVOID_STAMINA_COST_TICK = BUILDER
                .comment("Stamina cost per tick while in Semi-Void State. Only works if Progressive Stamina Cost Per Tick is turned off. (Default is 2.0 stamina per tick)")
                .defineInRange("semiVoidStaminaCostTick", 2.0, 0.0, 100.0);
        SEMIVOID_DURATION = BUILDER
                .comment("Maximum (in ticks) duration for Semi-Void State. (Default is Integer.MAX_VALUE)")
                .defineInRange("semiVoidDuration", Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        SEMIVOID_COOLDOWN = BUILDER
                .comment("Cooldown for Semi-Void State in ticks. Only works when Dynamic Cooldown is disabled. (Default is 240 ticks = 12 seconds)")
                .defineInRange("semiVoidCooldown", 240, 0, 120000);
        SEMIVOID_DYNAMIC_COOLDOWN = BUILDER
                .comment("Toggle for whether Semi-Void State should use dynamic cooldown based on usage duration. (Default is true)")
                .define("semiVoidDynamicCooldown", true);
        SEMIVOID_DYNAMIC_COOLDOWN_MULTIPLIER = BUILDER
                .comment("Multiplier for calculating Semi-Void State's dynamic cooldown. (Default is 1.5) (1.5 means cooldown equals 1.5x the usage time)")
                .defineInRange("semiVoidDynamicCooldownMultiplier", 1.5, 0.0, 10.0);
        SEMIVOID_DYNAMIC_MINIMUM_COOLDOWN = BUILDER
                .comment("Minimum cooldown for Semi-Void State when using dynamic cooldown. (Default is 120 ticks = 6 seconds) (Prevents extremely short cooldowns from brief uses)")
                .defineInRange("semiVoidDynamicMinimumCooldown", 120, 0, 120000);
        BUILDER.pop();

        BUILDER.push("Cream Stamina Config for Void Ball and Semi-Void State");
        PROGRESSIVE_STAMINA_COST = BUILDER
                .comment("Whether stamina cost should be scaled with your resolve level (true) or use the other configs in their respective sections (false). (Default is true)")
                .define("progressiveStaminaCost", true);

        STAMINA_COST_RESOLVE_2 = BUILDER
                .comment("Stamina cost per tick when your resolve level is 2. (Default is 5.0)")
                .defineInRange("staminaCostResolve2", 5.0, 0.0, 12000.0);

        STAMINA_COST_RESOLVE_3 = BUILDER
                .comment("Stamina cost per tick when your resolve level is 3. (Default is 3.0)")
                .defineInRange("staminaCostResolve3", 3.0, 0.0, 12000.0);

        STAMINA_COST_RESOLVE_4 = BUILDER
                .comment("Stamina cost per tick when your resolve level is 4. (Default is 1.0)")
                .defineInRange("staminaCostResolve4", 1.0, 0.0, 12000.0);
        BUILDER.pop();


        SPEC = BUILDER.build();
    }
}