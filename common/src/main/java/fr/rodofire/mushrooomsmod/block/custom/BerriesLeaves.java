package fr.rodofire.mushrooomsmod.block.custom;

import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.ToIntFunction;

public class BerriesLeaves extends LeavesBlock implements BonemealableBlock {
    public static final int MAX_DISTANCE = 7;
    public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static BooleanProperty BERRIES = BlockStateProperties.BERRIES;

    public BerriesLeaves(Properties settings) {
        super(settings);
    }

    private static BlockState updateDistance(BlockState state, LevelAccessor world, BlockPos pos) {
        int i = 7;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        for (Direction direction : Direction.values()) {
            mutable.setWithOffset(pos, direction);
            i = Math.min(i, getDistanceAt(world.getBlockState(mutable)) + 1);
            if (i == 1) break;
        }
        return state.setValue(DISTANCE, i);
    }

    private static int getDistanceAt(BlockState state) {
        return LeavesBlock.getOptionalDistanceAt(state).orElse(7);
    }

    public static ToIntFunction<BlockState> getLuminanceSupplier() {
        return state -> state.getValue(BERRIES) ? 14 : 0;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BERRIES, DISTANCE, PERSISTENT, WATERLOGGED);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (!world.isClientSide) {
            if (state.getValue(BERRIES)) {
                if (player.getMainHandItem().getItem() == ModBlocks.OAK_BERRIES_LEAVES.get().asItem())
                    return InteractionResult.PASS;
                world.setBlock(pos, state.setValue(BERRIES, false), 2);
                Block.popResource(world, pos, new ItemStack(ModItems.YELLOW_BERRIES.get(), 1));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        BlockState blockState = this.defaultBlockState().setValue(PERSISTENT, true).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER).setValue(BERRIES, RandomSource.create().nextIntBetweenInclusive(0, 4) == 0);
        return updateDistance(blockState, ctx.getLevel(), ctx.getClickedPos());
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        if (!world.isClientSide) {
            if (!state.getValue(BERRIES)) {
                world.setBlock(pos, state.setValue(BERRIES, true), 2);
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (state.getValue(BERRIES)) return;
        if (RandomSource.create().nextInt(4) == 0) {
            world.setBlock(pos, state.setValue(BERRIES, true), 2);
        }
    }
}
