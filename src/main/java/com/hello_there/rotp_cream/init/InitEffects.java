package com.hello_there.rotp_cream.init;

import com.github.standobyte.jojo.init.ModStatusEffects;
import com.hello_there.rotp_cream.RotpCreamAddon;
import com.hello_there.rotp_cream.effects.*;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(
            ForgeRegistries.POTIONS, RotpCreamAddon.MOD_ID
    );

    public static final RegistryObject<Effect> BLEEDING = EFFECTS.register("bleeding",
            () -> new BleedingEffect(0xc7615a)
    );

    public static final RegistryObject<Effect> TRUE_BLINDNESS = EFFECTS.register("true_blindness",
            () -> new TrueBlindnessEffect(0xc7615a)
    );

    public static final RegistryObject<Effect> WEAK_NECK = EFFECTS.register("weak_neck",
            () -> new WeakNeckEffect(0xc7615a)
    );

    public static final RegistryObject<Effect> VOIDED = EFFECTS.register("voided",
            () -> new VoidedEffect(0x000000));

    public static final RegistryObject<Effect> INSIDE_CREAM = EFFECTS.register("inside_cream",
            () -> new InsideCreamEffect(0x000000));

    public static void afterEffectsRegister(){
        ModStatusEffects.setEffectAsTracked(
                INSIDE_CREAM.get()
        );
    }
}