package fr.rodofire.mushrooomsmod.block.custom;

import com.mojang.serialization.MapCodec;
 
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import fr.rodofire.mushrooomsmod.block.entity.RapangeFlowersBE;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class RapangeFlowers extends BaseEntityBlock {
    public static final MapCodec<RapangeFlowers> CODEC = RapangeFlowers.simpleCodec(RapangeFlowers::new);
    private static final VoxelShape SHAPEUP = Block.box(4d, 0d, 4d, 12d, 16d, 12d);
    private static final VoxelShape SHAPEDOWN = Block.box(4d, 0d, 4d, 12d, 4, 12d);
    public static BooleanProperty UP = BlockStateProperties.UP;
    private int time;

    public RapangeFlowers(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    public static ToIntFunction<BlockState> getLuminanceSupplier() {
        return state -> state.getValue(UP) ? 13 : 0;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(UP) ? SHAPEUP : SHAPEDOWN;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).is(BlockTags.DIRT);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (!canSurvive(state, world, pos)) return Blocks.AIR.defaultBlockState();
        return state;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return super.getStateForPlacement(ctx).setValue(UP, true);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RapangeFlowersBE(pos, state);
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (world.isClientSide()) return;
        world.setBlock(pos, state.setValue(UP, false), 2);
        this.time = 0;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!state.getValue(UP) && this.time == 0) {
            world.setBlock(pos, state.setValue(UP, true), 2);
        } else if (this.time != 0) this.time--;
        super.randomTick(state, world, pos, random);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world.isClientSide) return InteractionResult.PASS;
        if (player.getMainHandItem().getItem() == Items.BONE_MEAL) {
            player.getMainHandItem().shrink(1);
            if (player.isCreative()) player.getMainHandItem().shrink(-1);
            Block.dropResources(state, world, pos);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
