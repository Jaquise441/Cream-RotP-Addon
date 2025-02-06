package com.hello_there.rotp_cream.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;

import com.hello_there.rotp_cream.action.*;
import com.hello_there.rotp_cream.entity.CreamEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), com.hello_there.rotp_cream.CreamAddon.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), com.hello_there.rotp_cream.CreamAddon.MOD_ID);
    
 // ======================================== Cream ========================================
    
    
    public static final RegistryObject<StandEntityAction> CREAM_PUNCH = ACTIONS.register("cream_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.CREAM_PUNCH_LIGHT)));
    
    public static final RegistryObject<StandEntityAction> CREAM_CLAW = ACTIONS.register("cream_claw",
            () -> new CreamClaw(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.CREAM_CLAW)));



    public static final RegistryObject<StandEntityHeavyAttack> CREAM_FINISHER_PUNCH = ACTIONS.register("cream_finisher_punch",
            () -> new CreamDoubleClawFinisher(new StandEntityHeavyAttack.Builder() // TODO finisher ability
                    .punchSound(InitSounds.CREAM_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityHeavyAttack> CREAM_DOUBLE_CLAW_FINISHER_PUNCH = ACTIONS.register("cream_double_claw_finisher_punch",
            () -> new CreamDoubleClawFinisher(new StandEntityHeavyAttack.Builder()
                    .punchSound(InitSounds.CREAM_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityHeavyAttack> CREAM_HEAVY_CLAW = ACTIONS.register("cream_heavy_claw",
            () -> new CreamHeavyClaw(new StandEntityHeavyAttack.Builder()
                    .shiftVariationOf(CREAM_CLAW)
                    .setFinisherVariation(CREAM_DOUBLE_CLAW_FINISHER_PUNCH)
                    .punchSound(InitSounds.CREAM_HEAVY_CLAW)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityHeavyAttack> CREAM_HEAVY_PUNCH = ACTIONS.register("cream_heavy_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .shiftVariationOf(CREAM_PUNCH)
                    .setFinisherVariation(CREAM_FINISHER_PUNCH)
                    .punchSound(InitSounds.CREAM_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> CREAM_CHOP = ACTIONS.register("cream_chop",
            () -> new CreamChop(new StandEntityLightAttack.Builder()
                    .resolveLevelToUnlock(3)
                    .punchSound(InitSounds.CREAM_PUNCH_LIGHT)));

    public static final RegistryObject<StandEntityAction> CREAM_CHOMP = ACTIONS.register("cream_chomp",
            () -> new CreamChomp(new StandEntityAction.Builder()
                    .standWindupDuration(20)
                    .staminaCost(340)
                    .cooldown(870)
                    .resolveLevelToUnlock(4)
                    .holdToFire(40, false)
                    .standPose(CreamChomp.CHOMP)
                    .standPerformDuration(20)
                    .autoSummonStand()
                    .partsRequired(StandPart.ARMS)));


    public static final RegistryObject<StandEntityAction> CREAM_BLOCK = ACTIONS.register("cream_block",
            () -> new StandEntityBlock());


    public static final RegistryObject<StandEntityAction> CREAM_VOID_BALL = ACTIONS.register("cream_void_ball",
            () -> new CreamVoidBall(new StandEntityAction.Builder()
                    .standPerformDuration(999999)
                    .holdToFire(40, false)
                    .staminaCostTick(1)
                    .ignoresPerformerStun()
                    .standPose(CreamVoidBall.VOID_BALL)
                    .standOffsetFromUser(0, 1, 0)
                    .standUserWalkSpeed(2F)
                    .heldWalkSpeed(0)
                    .staminaCost(80)
                    .resolveLevelToUnlock(1)
                    .cooldown(1)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> CREAM_VOID_BALL_CANCEL = ACTIONS.register("cream_void_ball_cancel",
            () -> new CreamVoidBallCancel(new StandEntityAction.Builder()
                    .staminaCost(80)
                    .cooldown(80)
                    .resolveLevelToUnlock(1)
                    .partsRequired(StandPart.ARMS)));


//    public static final RegistryObject<StandEntityAction> CREAM_VOID_DASH = ACTIONS.register("cream_void_dash",
//            () -> new CreamVoidDash(new StandEntityAction.Builder()
//                    .holdToFire(40, false)
//                    .standPerformDuration(15)
//                    .staminaCostTick(4)
//                    .staminaCost(40)
//                    .standUserWalkSpeed(2F)
//                    .cooldown(400)
//                    .partsRequired(StandPart.ARMS)));


    public static final RegistryObject<StandEntityAction> CREAM_EAT_ITEM = ACTIONS.register("cream_eat_item",
            () -> new CreamEatItem(new StandEntityAction.Builder()
                    .staminaCost(80)
                    .cooldown(20)
                    .resolveLevelToUnlock(2)
                    .standOffsetFromUser(0.3, 1, -0.7)
                    .standSound(InitSounds.CREAM_VOID)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> CREAM_EAT_ITEM_STACK = ACTIONS.register("cream_eat_item_stack",
            () -> new CreamEatItemStack(new StandEntityAction.Builder()
                    .shiftVariationOf(CREAM_EAT_ITEM)
                    .staminaCost(80)
                    .cooldown(80)
                    .standOffsetFromUser(0.3, 1, -0.7)
                    .resolveLevelToUnlock(2)
                    .standSound(InitSounds.CREAM_VOID)
                    .partsRequired(StandPart.ARMS)));


    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<com.hello_there.rotp_cream.entity.CreamEntity>> CREAM =
            new EntityStandRegistryObject<>("cream",
                    STANDS, 
                    () -> new EntityStandType.Builder<StandStats>()
                    .color(0x6600CC)
                    .storyPartName(ModStandsInit.PART_3_NAME)
                    .leftClickHotbar(
                            CREAM_PUNCH.get(),
                            CREAM_CLAW.get(),
                            CREAM_CHOP.get(),
                            CREAM_CHOMP.get()
                            )
                    .rightClickHotbar(
                            CREAM_BLOCK.get(),
                            CREAM_VOID_BALL.get(),
                            CREAM_EAT_ITEM.get()
                            )
                    .defaultStats(StandStats.class, new StandStats.Builder()
                            .tier(6)
                            .power(13)
                            .speed(13)
                            .range(4, 5)
                            .durability(8)
                            .precision(8)
                            .build())
                    .addSummonShout(InitSounds.CREAM_SUMMON_VOICELINE)
                    .addOst(InitSounds.CREAM_OST)
                    .build(),
                    
                    InitEntities.ENTITIES,
                    () -> new StandEntityType<CreamEntity>(com.hello_there.rotp_cream.entity.CreamEntity::new,0.75F, 2.15F)
                    .summonSound(InitSounds.CREAM_SUMMON_SOUND)
                    .unsummonSound(InitSounds.CREAM_UNSUMMON_SOUND))
            .withDefaultStandAttributes();
    

    
    // ======================================== ??? ========================================
    
    
    
}
