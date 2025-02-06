package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.power.non_stand.ModPowers;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.nonstand.INonStandPower;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.world.World;

public class CreamVoidBallCancel extends StandEntityAction {
    private static final int DEFAULT_MIN_CD = 240;
    private static final int VAMPIRE_MIN_CD = 200;

    public CreamVoidBallCancel(Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            if (userPower.getHeldAction() instanceof CreamVoidBall) {
                CreamVoidBall voidBallAction = (CreamVoidBall) userPower.getHeldAction();
                int activeTicks = voidBallAction.getActiveTicks();
                int cooldownTicks;

                boolean isVampire = INonStandPower.getNonStandPowerOptional(standEntity.getUser())
                        .map(nonStandPower -> nonStandPower.getType() == ModPowers.VAMPIRISM.get())
                        .orElse(false);

                if (isVampire) {
                    cooldownTicks = Math.max((int) (activeTicks * 1.5), VAMPIRE_MIN_CD);
                } else {
                    cooldownTicks = Math.max(activeTicks * 2, DEFAULT_MIN_CD);
                }

                userPower.stopHeldAction(true);
                userPower.setCooldownTimer(InitStands.CREAM_VOID_BALL.get(), cooldownTicks);
            }
        }
    }
    @Override
    public boolean isUnlocked(IStandPower power) {
        return InitStands.CREAM_VOID_BALL.get().isUnlocked(power);
    }
}