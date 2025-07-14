package com.hello_there.rotp_cream.mixin;

import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.action.CreamVoidDash;
import com.hello_there.rotp_cream.init.InitBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

@Mixin(ServerPlayerEntity.class)
public abstract class VoidBarrierCleanupMixin {
    private static final int CLEANUP_RADIUS = 15;
    private final Set<BlockPos> foundBarriers = new HashSet<>();

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        if (!CreamVoidBall.isVoidBallActive(player, null) &&
                !CreamVoidDash.isVoidDashActive(player)) {
            nuhuhToVoidBarriers(player);
        }
    }

    private void nuhuhToVoidBarriers(ServerPlayerEntity player) {
        ServerWorld world = player.getLevel();
        BlockPos playerPos = player.blockPosition();
        foundBarriers.clear();

        BlockPos.betweenClosedStream(
                playerPos.offset(-CLEANUP_RADIUS, -CLEANUP_RADIUS, -CLEANUP_RADIUS),
                playerPos.offset(CLEANUP_RADIUS, CLEANUP_RADIUS, CLEANUP_RADIUS)
        ).forEach(pos -> {
            if (world.getBlockState(pos).getBlock() == InitBlocks.VOID_BARRIER.get()) {
                foundBarriers.add(pos.immutable());
            }
        });

        foundBarriers.forEach(pos -> {
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        });
    }
}