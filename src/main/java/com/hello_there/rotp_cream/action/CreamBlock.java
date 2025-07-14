package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.LivingEntity;

import static com.hello_there.rotp_cream.action.CreamVoidBall.isVoidBallActive;

public class CreamBlock extends StandEntityBlock {

    public CreamBlock(Builder builder){
        super(builder);
    }

    @Override
    public ActionConditionResult checkConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        if (this == InitStands.CREAM_VOID_BALL_CANCEL.get()) {
            return super.checkConditions(user, power, target);
        }

        if (isVoidBallActive(user, power)) {
            return ActionConditionResult.NEGATIVE;
        }

        return super.checkConditions(user, power, target);
    }
}
