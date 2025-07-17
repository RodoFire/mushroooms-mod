package fr.rodofire.mushrooomsmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.block.entity.TallYellowMushroomsBE;
import org.jetbrains.annotations.Nullable;

public class TallYellowMushroom extends BaseEntityBlock {
    public static final MapCodec<TallYellowMushroom> CODEC = TallYellowMushroom.simpleCodec(TallYellowMushroom::new);

    public static BooleanProperty ENABLED = BlockStateProperties.ENABLED;
    public static EnumProperty<Direction> DIRECTION = BlockStateProperties.HORIZONTAL_FACING;

    public TallYellowMushroom(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return ModBlocks.TALL_YELLOW_MUSHROOMS.get().defaultBlockState().setValue(ENABLED, false).setValue(DIRECTION, Direction.NORTH);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ENABLED, DIRECTION);
    }

    @Override
    protected void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        Direction direction = getHorizontalDirectionFromVelocity(entity.getDeltaMovement());
/*        if (direction == null) return;
        else state = state.with(ENABLED, true).with(DIRECTION, direction);

        if (world instanceof ServerWorld serverWorld) {
            serverWorld.setBlockState(pos, state);
        }*/
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).is(BlockTags.DIRT);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return state.getValue(ENABLED);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        world.setBlock(pos, state.setValue(ENABLED, false), 2);
    }

    Direction getHorizontalDirectionFromVelocity(Vec3 velocity) {
        if (velocity.lengthSqr() < 1.0E-5) {
            return null;
        }
        return Direction.fromYRot(Mth.atan2(velocity.x, velocity.z) * (180F / (float) Math.PI));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TallYellowMushroomsBE(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}
