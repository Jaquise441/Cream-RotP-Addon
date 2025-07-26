package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.init.InitStands;
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
                CreamVoidBall.removeBallActive(userPower.getUser());
            }
        }
    }

    @Override
    public boolean isUnlocked(IStandPower power) {
        return InitStands.CREAM_VOID_BALL.get().isUnlocked(power);
    }
}