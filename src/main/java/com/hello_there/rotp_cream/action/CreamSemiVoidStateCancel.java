package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CreamSemiVoidStateCancel extends StandEntityAction {
    public CreamSemiVoidStateCancel(Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide && userPower.getHeldAction() instanceof CreamSemiVoidState) {
            userPower.stopHeldAction(true);
        }
    }

    @Override
    public boolean isUnlocked(IStandPower power) {
        return InitStands.CREAM_SEMI_VOID_STATE.get().isUnlocked(power);
    }
}