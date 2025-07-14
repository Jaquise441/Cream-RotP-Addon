package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.power.non_stand.ModPowers;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.nonstand.INonStandPower;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CreamVoidBallCancel extends StandEntityAction {

    public CreamVoidBallCancel(Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            if (userPower.getHeldAction() instanceof CreamVoidBall) {
                userPower.stopHeldAction(true);
            }
        }
    }

    @Override
    public boolean isUnlocked(IStandPower power) {
        return InitStands.CREAM_VOID_BALL.get().isUnlocked(power);
    }
}