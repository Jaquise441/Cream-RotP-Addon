package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class InsideCreamMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        Entity entity = (Entity)(Object)this;

        if (entity.level.isClientSide && entity instanceof ClientPlayerEntity) {
            ClientPlayerEntity player = (ClientPlayerEntity) entity;
            Minecraft mc = Minecraft.getInstance();

            if (player == mc.player) {
                boolean shouldHaveEffect = CreamSemiVoidState.isSemiVoidActive(player) && mc.options.getCameraType().isFirstPerson();

                boolean hasEffect = player.hasEffect(InitEffects.INSIDE_CREAM.get());

                if (shouldHaveEffect && !hasEffect) {
                    player.addEffect(new EffectInstance(InitEffects.INSIDE_CREAM.get(), 999999, 0, false, false, false
                    ));
                }
                else if (!shouldHaveEffect && hasEffect) {
                    player.removeEffect(InitEffects.INSIDE_CREAM.get());
                }
            }
        }
    }
}