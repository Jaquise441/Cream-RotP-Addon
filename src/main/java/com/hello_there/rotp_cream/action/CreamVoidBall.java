package com.hello_there.rotp_cream.action;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_cream.init.InitEffects;
import com.hello_there.rotp_cream.init.InitStands;
import com.hello_there.rotp_cream.init.InitSounds;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.SPlaySoundEffectPacket;
import net.minecraft.network.play.server.SStopSoundPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreamVoidBall extends StandEntityAction {
    private boolean isVoidBallActive = false;
    private int activeTicks = 0;
    public static final StandPose VOID_BALL = new StandPose("cream_void_ball");

    private Vector3d lastSoundPosition;
    private static final int MIN_CD = 240;
    private static final double SUT = 1.5;
    private static final double SIS = 2.64;
    private double soundCD = 0.0;

    private final Set<BlockPos> barrierPositions = new HashSet<>();
    private final Map<Entity, Boolean> teleportedEntities = new HashMap<>();
    private static final double RADIUS = 20;
    private static final int GET_FUCKED_LMAO = -9999;
    private static final double SEARCH_RADIUS = 1.5;

    public CreamVoidBall(Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        isVoidBallActive = true;
        activeTicks = 0;
        userPower.setCooldownTimer(InitStands.CREAM_VOID_BALL_CANCEL.get(), 20);

        if (user instanceof PlayerEntity) {
            applyInvulnerability((PlayerEntity) user);
            playSound((PlayerEntity) user, InitSounds.CREAM_VOID_START.get(), false);
        }

        user.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), Integer.MAX_VALUE, 1, false, false));
        user.addEffect(new EffectInstance(Effects.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
        user.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, Integer.MAX_VALUE, 6, false, false));
        user.addEffect(new EffectInstance(Effects.BLINDNESS, Integer.MAX_VALUE, 1, false, false));
        user.addEffect(new EffectInstance(InitEffects.TRUE_BLINDNESS.get(), Integer.MAX_VALUE, 1, false, false));
        standEntity.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), Integer.MAX_VALUE, 1, false, false));
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            if (userPower.getStamina() <= 0) {
                CreamVoidBallCancel cancelAction = (CreamVoidBallCancel) InitStands.CREAM_VOID_BALL_CANCEL.get();
                userPower.setHeldAction(cancelAction);
                cancelAction.standPerform(world, standEntity, userPower, task);
                return;
            }
            activeTicks++;
        }

        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        soundCD -= 1 / 20.0;

        if (soundCD <= 0 && user instanceof PlayerEntity) {
            playSound((PlayerEntity) user, InitSounds.CREAM_VOID_FORM_SHORT.get(), true);
            soundCD = SIS;
        }

        AxisAlignedBB voidArea = user.getBoundingBox().inflate(SEARCH_RADIUS);

        AtomicBoolean anyEntityTeleported = new AtomicBoolean(false);

        world.getEntitiesOfClass(Entity.class, voidArea).forEach(entity -> {
            if (entity != user && entity != standEntity && !teleportedEntities.containsKey(entity) &&
                    (!(entity instanceof PlayerEntity) || !((PlayerEntity) entity).abilities.invulnerable)) {

                entity.teleportTo(entity.getX(), GET_FUCKED_LMAO, entity.getZ());
                teleportedEntities.put(entity, true);
                anyEntityTeleported.set(true);
            }
        });

        if (anyEntityTeleported.get() && user instanceof PlayerEntity) {
            playSound((PlayerEntity) user, InitSounds.CREAM_VOID.get(), false);
        }

        BlockPos centerPos = user.blockPosition();
        int barrierYOffset = user.isShiftKeyDown() ? 2 : 1;
        BlockPos barrierCenter = centerPos.below(barrierYOffset);

        Set<BlockPos> currentBarrierPositions = new HashSet<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos pos = barrierCenter.offset(dx, 0, dz);
                currentBarrierPositions.add(pos);
                if (world.getBlockState(pos).isAir() || world.getBlockState(pos).getFluidState().isSource()) {
                    world.setBlock(pos, Blocks.BARRIER.defaultBlockState(), 3);
                    barrierPositions.add(pos);
                }
            }
        }

        barrierPositions.removeIf(pos -> {
            if (!currentBarrierPositions.contains(pos)) {
                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                return true;
            }
            return false;
        });

        BlockPos.betweenClosedStream(centerPos.offset(-1, -1, -1), centerPos.offset(1, 1, 1)).forEach(pos -> {
            if (world.getBlockState(pos).getBlock() != Blocks.BEDROCK &&
                    world.getBlockState(pos).getBlock() != Blocks.BARRIER &&
                    world.getBlockState(pos).getBlock() != Blocks.COMMAND_BLOCK &&
                    world.getBlockState(pos).getBlock() != Blocks.END_PORTAL &&
                    world.getBlockState(pos).getBlock() != Blocks.END_PORTAL_FRAME &&
                    world.getBlockState(pos).getBlock() != Blocks.NETHER_PORTAL &&
                    world.getBlockState(pos).getBlock() != Blocks.END_GATEWAY) {

                if (!world.getFluidState(pos).isEmpty()) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                } else {
                    world.destroyBlock(pos, false);
                }
            }
        });

        if (!world.getFluidState(centerPos).isEmpty()) {
            BlockPos.betweenClosedStream(centerPos.offset(-1, -1, -1), centerPos.offset(1, 1, 1)).forEach(pos -> {
                if (!world.getFluidState(pos).isEmpty()) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                }
            });
        }

        if (userPower.getStamina() <= 0) {
            userPower.stopHeldAction(false);
        }
    }

    @Override
    public void onTaskStopped(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task, StandEntityAction newAction) {
        LivingEntity user = standEntity.getUser();
        if (user == null || world.isClientSide) return;

        isVoidBallActive = false;

        int cooldownTicks = Math.max(activeTicks * 2, MIN_CD);
        userPower.setCooldownTimer(InitStands.CREAM_VOID_BALL.get(), cooldownTicks);

        user.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());
        user.removeEffect(Effects.INVISIBILITY);
        user.removeEffect(Effects.MOVEMENT_SPEED);
        user.removeEffect(Effects.BLINDNESS);
        user.removeEffect(InitEffects.TRUE_BLINDNESS.get());
        standEntity.removeEffect(ModStatusEffects.FULL_INVISIBILITY.get());

        barrierPositions.forEach(pos -> world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3));
        barrierPositions.clear();
        teleportedEntities.clear();

        if (user instanceof PlayerEntity) {
            removeInvulnerability((PlayerEntity) user);
            stopSound((PlayerEntity) user, InitSounds.CREAM_VOID_START.get());
            stopSound((PlayerEntity) user, InitSounds.CREAM_VOID_FORM_SHORT.get());
            lastSoundPosition = null;
            playSound((PlayerEntity) user, InitSounds.CREAM_VOID_END.get(), false);
        }
    }

    private void applyInvulnerability(PlayerEntity player) {
        if (!player.isCreative()) {
            player.abilities.invulnerable = true;
        }
    }

    @Nullable
    @Override
    public Action<IStandPower> getVisibleAction(IStandPower power, ActionTarget target) {
        if (isVoidBallActive()) {
            return InitStands.CREAM_VOID_BALL_CANCEL.get();
        }
        return super.getVisibleAction(power, target);
    }

    private void removeInvulnerability(PlayerEntity player) {
        if (!player.isCreative()) {
            player.abilities.invulnerable = false;
        }
    }

    private static void playSound(PlayerEntity player, SoundEvent sound, boolean forCreamUserOnly) {
        if (player instanceof ServerPlayerEntity) {
            ServerWorld world = (ServerWorld) player.level;
            Vector3d position = player.position();

            if (forCreamUserOnly) {
                ((ServerPlayerEntity) player).connection.send(new SPlaySoundEffectPacket(sound, SoundCategory.PLAYERS, player.getX(), player.getY(), player.getZ(), 1.0F, 1.0F));
            } else {
                world.getPlayers(p -> p.position().distanceTo(position) <= RADIUS).forEach(p -> {
                    ((ServerPlayerEntity) p).connection.send(new SPlaySoundEffectPacket(sound, SoundCategory.PLAYERS, position.x, position.y, position.z, 1.0F, 1.0F));
                });
            }
        }
    }

    private static void stopSound(PlayerEntity player, SoundEvent sound) {
        if (player instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) player).connection.send(new SStopSoundPacket(sound.getRegistryName(), SoundCategory.PLAYERS));
        }
    }

    public int getActiveTicks() {
        return activeTicks;
    }

    public boolean isVoidBallActive() {
        return isVoidBallActive;
    }

}
