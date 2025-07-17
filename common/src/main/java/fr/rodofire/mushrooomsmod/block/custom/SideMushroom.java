package fr.rodofire.mushrooomsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SideMushroom extends Block {
    public SideMushroom(Properties settings) {
        super(settings);
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected static final VoxelShape EAST_SHAPE = Block.box(0, 3, 4, 8, 13, 12);
    protected static final VoxelShape WEST_SHAPE = Block.box(8, 3, 4, 16, 13, 12);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(4, 3, 0, 12, 13, 8);
    protected static final VoxelShape NORTH_SHAPE = Block.box(4, 3, 8, 12, 13, 16);

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                return EAST_SHAPE;
        }
    }

    private boolean canPlaceOn(BlockGetter world, BlockPos pos, Direction side) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isFaceSturdy(world, pos, side);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        return this.canPlaceOn(world, pos.relative(direction.getOpposite()), direction) && (world.getBlockState(pos).isAir() || world.getBlockState(pos).getBlock() == this);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (!canSurvive(state, world, pos)) return Blocks.AIR.defaultBlockState();
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level world = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        BlockState blockState = this.defaultBlockState();
        Direction[] direction = ctx.getNearestLookingDirections();
        for (int i = 0; i < direction.length; i++) {
            Direction direction1 = direction[i];
            if (direction1.getAxis().isHorizontal()) {
                blockState = blockState.setValue(FACING, direction1.getOpposite());
                if (blockState.canSurvive(world, blockPos)) {
                    return blockState;
                }
            }
        }
        return null;
    }
}
