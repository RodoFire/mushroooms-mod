package fr.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.util.ModProperties;

import java.util.function.ToIntFunction;

public class PinkLuminescentHeadVinesBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(7.0, 11.0, 7.0, 8.0, 15.0, 8.0);
    public static final BooleanProperty MANY_VINES = ModProperties.MANY_VINES;

    public PinkLuminescentHeadVinesBlock(Properties settings) {
        super(settings);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }


    public InteractionResult onUse(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        BlockState blocAuDessus = world.getBlockState(pos.above());
        if (blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK || blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_BODY_VINES) {
            BlockState blockState = state.setValue(MANY_VINES, true);
            world.setBlock(pos, blockState, Block.UPDATE_CLIENTS);
            return InteractionResult.SUCCESS;
        }
        BlockState blockState = state.setValue(MANY_VINES, false);
        world.setBlock(pos, blockState, Block.UPDATE_CLIENTS);
        return InteractionResult.SUCCESS;
    }

    public static int getluminancesupplier(int luminance, Level world, BlockPos pos) {
        BlockState blocAuDessus = world.getBlockState(pos.above());
        if (blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK || blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_BODY_VINES) {
            return luminance;
        }
        return 0;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MANY_VINES);
    }

    public static ToIntFunction<BlockState> getLuminanceSupplier(int luminance) {
        return state -> state.getValue(ModProperties.MANY_VINES) ? luminance : 0;
    }

}
