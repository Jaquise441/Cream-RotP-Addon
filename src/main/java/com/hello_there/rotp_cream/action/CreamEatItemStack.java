package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class CreamEatItemStack extends StandEntityAction {

    public CreamEatItemStack(Builder builder) {
        super(builder);
    }

    @Override
    protected ActionConditionResult checkSpecificConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        if (power.getHeldAction() instanceof CreamVoidBall && ((CreamVoidBall) power.getHeldAction()).isVoidBallActive()) {
            return ActionConditionResult.createNegative(ITextComponent.nullToEmpty("Cannot use this ability while Void Ball is active."));
        } //doesn't fucking work

        ItemStack offhandItem = user.getOffhandItem();
        if (offhandItem.isEmpty()) {
            return conditionMessage("no_item_in_offhand");
        }
        return super.checkSpecificConditions(user, power, target);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = userPower.getUser();
        if (!user.getOffhandItem().isEmpty()) {
            user.setItemInHand(Hand.OFF_HAND, ItemStack.EMPTY);
        }
    }
}
