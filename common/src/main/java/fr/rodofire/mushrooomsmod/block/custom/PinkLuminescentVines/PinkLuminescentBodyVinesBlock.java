package fr.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

public class PinkLuminescentBodyVinesBlock extends Block implements BonemealableBlock {
    public static final VoxelShape SHAPE = Block.box(6.0, 0.0, 6.0, 8.0, 16.0, 8.0);
    public static BooleanProperty MANY_VINES = BooleanProperty.create("many_vines");


    public PinkLuminescentBodyVinesBlock(Properties settings) {
        super(settings);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MANY_VINES);
    }

    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
        BlockState blocAuDessus = world.getBlockState(pos.above());
        if ((blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK || blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_BODY_VINES) && state.getValue(MANY_VINES)) {

            BlockState blockState = state.setValue(MANY_VINES, false);
            world.setBlock(pos, blockState, Block.UPDATE_CLIENTS);

        }
    }


    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {

    }
}
