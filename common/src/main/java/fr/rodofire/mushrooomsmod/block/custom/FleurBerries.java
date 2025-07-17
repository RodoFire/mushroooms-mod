package fr.rodofire.mushrooomsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class FleurBerries extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SHAPE = Block.box(2d, 0d, 2d, 14d, 28d, 14d);

    public FleurBerries(Properties settings) {
        super(settings);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return ModBlocks.FLEUR_BERRIES.get().defaultBlockState().setValue(BlockStateProperties.AGE_3, RandomSource.create().nextIntBetweenInclusive(0, 3));
    }


    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return state.getValue(AGE) <= 3;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        int i = state.getValue(AGE);
        if (i < 3) {
            world.setBlockAndUpdate(pos, state.setValue(AGE, i + 1));
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).is(BlockTags.DIRT);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world.isClientSide) return InteractionResult.PASS;
        if ((player.getMainHandItem().getItem() == Items.BONE_MEAL || player.getOffhandItem().getItem() == Items.BONE_MEAL)) {
            if (state.getValue(AGE) == 3) {
                Block.dropResources(state, world, pos);
            }
            return InteractionResult.PASS;
        }
        if (state.getValue(AGE) != 0) {
            int f = 1;
            world.setBlockAndUpdate(pos, state.setValue(AGE, 0));
            this.popExperience((ServerLevel) world, pos, 1);
            world.playSound(null, pos, SoundEvents.CAVE_VINES_BREAK, SoundSource.BLOCKS, state.getValue(AGE), 1.0f);
            if (player.getOffhandItem().getItem() == Items.SHEARS || player.getMainHandItem().getItem() == Items.SHEARS) {
                f = 2;
            }
            Block.popResource(world, pos, new ItemStack(ModItems.YELLOW_BERRIES.get(), f * state.getValue(AGE)));
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (RandomSource.create().nextInt(10) != 0) return;
        if (state.getValue(AGE) == 3) return;
        world.setBlockAndUpdate(pos, state.setValue(AGE, state.getValue(AGE) + 1));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
}
