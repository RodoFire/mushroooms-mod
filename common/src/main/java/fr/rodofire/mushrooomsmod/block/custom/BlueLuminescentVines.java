package fr.rodofire.mushrooomsmod.block.custom;

 
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class BlueLuminescentVines extends Block implements BonemealableBlock {
    public static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 16, 10);
    public static final IntegerProperty STAGE = BlockStateProperties.AGE_4;

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    public BlueLuminescentVines(Properties settings) {
        super(settings);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!canSurvive(state, world, pos) || world.isClientSide) return;
        changeBlockState((ServerLevel) world, pos.below(), state);
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
        while (!world.getBlockState(pos.above()).is(Blocks.AIR)) {
            pos = pos.above();
        }
        changeBlockState(world, pos, state);

        world.setBlockAndUpdate(pos.above(), ModBlocks.CAERULEA_VOLUBILIS.get().withPropertiesOf(state.setValue(STAGE, 0)));
    }

    public void changeBlockState(ServerLevel world, BlockPos pos, BlockState state) {
        int stage = maxStage(world, pos);
        BlockPos newpos = pos;
        if (stage < 5) {
            for (int i = 1; i <= stage; ++i) {
                BlockState blockstate = world.getBlockState(newpos);
                if (blockstate.is(ModBlocks.CAERULEA_VOLUBILIS.get())) {
                    world.setBlockAndUpdate(newpos, ModBlocks.CAERULEA_VOLUBILIS.get().withPropertiesOf(state.setValue(STAGE, i)));
                    newpos = newpos.below();
                }
            }
        } else {
            world.setBlockAndUpdate(pos, ModBlocks.CAERULEA_VOLUBILIS.get().withPropertiesOf(state.setValue(STAGE, 1)));
        }
    }

    public Integer maxStage(ServerLevel world, BlockPos pos) {
        int stage = 0;
        for (int i = 1; i < 7; ++i) {
            BlockState blockstate = world.getBlockState(pos);
            if (blockstate.is(ModBlocks.CAERULEA_VOLUBILIS.get())) {
                stage++;
            }
            pos = pos.below();
        }
        return stage;
    }


    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.is(ModBlocks.CAERULEA_VOLUBILIS.get())) {
            return true;
        }
        return this.canPlantOnTop(blockState, world, blockPos);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.isSolidRender(world, pos);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canSurvive(world, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }
}
