package com.hello_there.rotp_cream.util;

import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.entity.CreamEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class GameplayHandler {


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        PlayerEntity user = event.player;
        if(!user.level.isClientSide){
            if(!(IStandPower.getPlayerStandPower(user).getStandManifestation() instanceof CreamEntity)){
                if(CreamVoidBall.isVoidBallActive(user)){
                    CreamVoidBall.removeBallActive(user);
                }
                if(CreamSemiVoidState.isSemiVoidActive(user)){
                    CreamSemiVoidState.remoteSemiVoidActive(user);
                }
            }
        }
    }
}
