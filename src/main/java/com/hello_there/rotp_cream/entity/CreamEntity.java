package com.hello_there.rotp_cream.entity;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.entity.stand.StandRelativeOffset;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.action.CreamSemiVoidState;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.client.ClientProxy;
import com.hello_there.rotp_cream.init.InitSounds;
import com.hello_there.rotp_cream.init.InitStands;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class CreamEntity extends StandEntity {
    private static final DataParameter<Boolean> SEMIVOID_ACTIVE = EntityDataManager.defineId(CreamEntity.class,DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> BALL_VOID_ACTIVE = EntityDataManager.defineId(CreamEntity.class,DataSerializers.BOOLEAN);
    private int soundCD = 0;
    private static final double SIS = 2.64;

    public CreamEntity(StandEntityType<CreamEntity> type, World world) {
        super(type, world);
        unsummonOffset = getDefaultOffsetFromUser().copy();
    }

    @Override
    public void tick() {
        super.tick();
        if(!level.isClientSide){
            if(this.getUser() != null){
                this.setSemiVoidActive(CreamSemiVoidState.isSemiVoidActive(this.getUser()));
                this.setBallVoidActive(CreamVoidBall.isVoidBallActive(this.getUser()));
            }
        }

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SEMIVOID_ACTIVE,false);
        this.entityData.define(BALL_VOID_ACTIVE, false);
    }


    public void setSemiVoidActive(boolean semiVoidActive){
        this.entityData.set(SEMIVOID_ACTIVE,semiVoidActive);
    }

    public boolean isSemiVoidActive(){
        return this.entityData.get(SEMIVOID_ACTIVE);
    }

    public void setBallVoidActive(boolean semiVoidActive){
        this.entityData.set(BALL_VOID_ACTIVE,semiVoidActive);
    }

    public boolean isBallVoidActive(){
        return this.entityData.get(BALL_VOID_ACTIVE);
    }

    private StandRelativeOffset offsetDefault = StandRelativeOffset.withYOffset(0, 0.5, -0.5);
    private StandRelativeOffset offsetDefaultArmsOnly = StandRelativeOffset.withYOffset(0, 0, 0);

    public StandRelativeOffset getDefaultOffsetFromUser() {
        return isArmsOnlyMode() ? offsetDefaultArmsOnly : offsetDefault;
    }
}