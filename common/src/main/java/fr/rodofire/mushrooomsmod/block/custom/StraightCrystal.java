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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class StraightCrystal extends Block {
    public static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 16, 13);
    public static final DirectionProperty VERTICAL_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
    public static final IntegerProperty STAGE = BlockStateProperties.AGE_1;

    public StraightCrystal(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE, VERTICAL_DIRECTION);
    }

    public boolean canPlace(LevelReader world, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        Direction direction = state.getValue(VERTICAL_DIRECTION);
        Direction direction2 = direction.getOpposite();
        if (blockState.is(this)) direction2 = blockState.getValue(VERTICAL_DIRECTION);
        return blockState.equals(state) || direction2 == direction || blockState.isFaceSturdy(world, pos, state.getValue(VERTICAL_DIRECTION));
    }

    public Direction getDirection(BlockState state, LevelReader world, BlockPos pos) {
        if (canPlace(world, pos.below(), state)) return Direction.UP;
        else if (canPlace(world, pos.above(), state)) return Direction.DOWN;
        return null;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction direction = getDirection(state, world, pos);
        return direction == Direction.UP || direction == Direction.DOWN;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        Direction direction2 = state.getValue(VERTICAL_DIRECTION);
        if (!canPlace(world, pos.relative(direction2.getOpposite()), state)) {
            return Blocks.AIR.defaultBlockState();
        }
        if (world.getBlockState(pos.relative(direction)).is(this)) {
            return state;
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    public void updateState(Level world, BlockPos pos, BlockState state, Direction direction) {
        if (world.getBlockState(pos.relative(direction.getOpposite())).is(this)) {
            world.setBlockAndUpdate(pos.relative(direction.getOpposite()), state.setValue(STAGE, 1).setValue(VERTICAL_DIRECTION, direction));
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level world = ctx.getLevel();
        Direction direction = ctx.getNearestLookingVerticalDirection().getOpposite();
        BlockPos pos = ctx.getClickedPos();
        BlockState blockState = this.defaultBlockState();
        if (canPlace(world, pos.relative(direction.getOpposite()), blockState.setValue(VERTICAL_DIRECTION, direction))) {
            updateState(world, pos, blockState, direction);
            return blockState.setValue(VERTICAL_DIRECTION, direction).setValue(STAGE, 0);
        } else if (canPlace(world, pos.relative(direction), blockState.setValue(VERTICAL_DIRECTION, direction.getOpposite()))) {
            updateState(world, pos, blockState, direction.getOpposite());
            return blockState.setValue(VERTICAL_DIRECTION, direction.getOpposite()).setValue(STAGE, 0);
        }
        return null;
    }

    public static void generateStraightCrystal(Level world, BlockPos pos, BlockState state, int height) {
        for (int i = 0; i < height; i++) {
            if (world.getBlockState(pos.above(i+1)).isAir()) {
                world.setBlockAndUpdate(pos.above(i), state.setValue(VERTICAL_DIRECTION, Direction.UP).setValue(STAGE, 1));
                continue;
            }
            world.setBlockAndUpdate(pos.above(i), state.setValue(VERTICAL_DIRECTION, Direction.UP).setValue(STAGE, 0));
            return;
        }
        world.setBlockAndUpdate(pos.above(height), state.setValue(VERTICAL_DIRECTION, Direction.UP).setValue(STAGE, 0));
    }
}
