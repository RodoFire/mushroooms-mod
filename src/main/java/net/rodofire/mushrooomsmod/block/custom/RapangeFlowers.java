package net.rodofire.mushrooomsmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.rodofire.mushrooomsmod.block.entity.RapangeFlowersBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class RapangeFlowers extends BlockWithEntity {
    public static final MapCodec<RapangeFlowers> CODEC = RapangeFlowers.createCodec(RapangeFlowers::new);
    private static final VoxelShape SHAPEUP = Block.createCuboidShape(4d, 0d, 4d, 12d, 16d, 12d);
    private static final VoxelShape SHAPEDOWN = Block.createCuboidShape(4d, 0d, 4d, 12d, 4, 12d);
    public static BooleanProperty UP = Properties.UP;
    private int time;

    public RapangeFlowers(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    public static ToIntFunction<BlockState> getLuminanceSupplier() {
        return state -> state.get(UP) ? 13 : 0;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? SHAPEUP : SHAPEDOWN;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(BlockTags.DIRT);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (!canPlaceAt(state, world, pos)) return Blocks.AIR.getDefaultState();
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(UP, true);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RapangeFlowersBlockEntity(pos, state);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world.isClient()) return;
        world.setBlockState(pos, state.with(UP, false), 2);
        this.time = 0;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.get(UP) && this.time == 0) {
            world.setBlockState(pos, state.with(UP, true), 2);
        } else if (this.time != 0) this.time--;
        super.randomTick(state, world, pos, random);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.PASS;
        if (player.getMainHandStack().getItem() == Items.BONE_MEAL) {
            player.getMainHandStack().decrement(1);
            if (player.isCreative()) player.getMainHandStack().decrement(-1);
            Block.dropStacks(state, world, pos);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
