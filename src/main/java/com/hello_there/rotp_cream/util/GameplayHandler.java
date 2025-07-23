package com.hello_there.rotp_cream.util;

import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.entity.CreamEntity;
import com.hello_there.rotp_cream.init.InitEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class GameplayHandler {


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        PlayerEntity user = event.player;
        if(!user.level.isClientSide){
            if(!(IStandPower.getPlayerStandPower(user).getStandManifestation() instanceof CreamEntity)){
                user.removeEffect(InitEffects.INSIDE_CREAM.get());
                user.removeEffect(InitEffects.TRUE_BLINDNESS.get());
                if(CreamVoidBall.isVoidBallActive(user)){
                    CreamVoidBall.removeBallActive(user);
                }
                if(CreamSemiVoidState.isSemiVoidActive(user)){
                    CreamSemiVoidState.remoteSemiVoidActive(user);
                }
            }
            if(!CreamSemiVoidState.isSemiVoidActive(user)){
                user.removeEffect(InitEffects.INSIDE_CREAM.get());
            }
            if(!CreamVoidBall.isVoidBallActive(user)){
                user.removeEffect(InitEffects.TRUE_BLINDNESS.get());
            }

        }
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityLeavingWorld(EntityLeaveWorldEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof LivingEntity){
            LivingEntity livingEntity = (LivingEntity) entity;
            if(CreamVoidBall.isVoidBallActive(livingEntity)){
                CreamVoidBall.cleanup(livingEntity);
            }
            if(CreamSemiVoidState.isSemiVoidActive(livingEntity)){
                CreamSemiVoidState.cleanup(livingEntity);
            }

        }
    }



    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerDisconnect(PlayerEvent.PlayerLoggedOutEvent event){
        PlayerEntity player = event.getPlayer();
        if(CreamVoidBall.isVoidBallActive(player)){
            CreamVoidBall.cleanup(player);
        }
        if(CreamSemiVoidState.isSemiVoidActive(player)){
            CreamSemiVoidState.cleanup(player);
        }
    }

}
