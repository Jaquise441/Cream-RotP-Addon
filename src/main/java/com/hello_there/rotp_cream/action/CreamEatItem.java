package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.config.CreamConfig;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import static com.hello_there.rotp_cream.action.CreamSemiVoidState.isSemiVoidActive;
import static com.hello_there.rotp_cream.action.CreamVoidBall.isVoidBallActive;

public class CreamEatItem extends StandEntityAction {

    public CreamEatItem(Builder builder) {
        super(builder);
    }

    @Override
    protected ActionConditionResult checkSpecificConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        if (this == InitStands.CREAM_VOID_BALL_CANCEL.get()) {
            return super.checkConditions(user, power, target);
        }

        if (isVoidBallActive(user, power)) {
            return ActionConditionResult.NEGATIVE;
        }

        if (isSemiVoidActive(user)) {
            return ActionConditionResult.NEGATIVE;
        }

        ItemStack offhandItem = user.getOffhandItem();
        if (offhandItem.isEmpty()) {
            return conditionMessage("no_item_in_offhand_cream");
        }
        return super.checkSpecificConditions(user, power, target);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = userPower.getUser();
        ItemStack offhandItem = user.getOffhandItem();
        if (!offhandItem.isEmpty()) {
            offhandItem.shrink(1);
        }
    }

    @Override
    public void onTaskStopped(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task, StandEntityAction newAction) {
        userPower.setCooldownTimer(this, CreamConfig.EAT_ITEM_COOLDOWN.get());
    }
}