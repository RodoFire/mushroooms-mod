package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class PickBlue extends Block {
    public static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 24, 12);

    public PickBlue(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(BlockTags.DIRT);
    }
}
