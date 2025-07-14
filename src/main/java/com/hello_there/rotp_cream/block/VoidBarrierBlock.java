package com.hello_there.rotp_cream.block;

import net.minecraft.block.BarrierBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;

public class VoidBarrierBlock extends BarrierBlock {
    public static final BooleanProperty VOID_BLOCK = BooleanProperty.create("void_block");

    public VoidBarrierBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(VOID_BLOCK, false));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(VOID_BLOCK);
    }
}