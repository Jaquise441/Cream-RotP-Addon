package com.hello_there.rotp_cream.entity;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.entity.stand.StandRelativeOffset;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.client.ClientProxy;
import com.hello_there.rotp_cream.init.InitSounds;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class CreamEntity extends StandEntity {
    private int soundCD = 0;
    private static final double SIS = 2.64;

    public CreamEntity(StandEntityType<CreamEntity> type, World world) {
        super(type, world);
        unsummonOffset = getDefaultOffsetFromUser().copy();
    }

    private StandRelativeOffset offsetDefault = StandRelativeOffset.withYOffset(0, 0.5, -0.5);
    private StandRelativeOffset offsetDefaultArmsOnly = StandRelativeOffset.withYOffset(0, 0, 0);

    public StandRelativeOffset getDefaultOffsetFromUser() {
        return isArmsOnlyMode() ? offsetDefaultArmsOnly : offsetDefault;
    }
}