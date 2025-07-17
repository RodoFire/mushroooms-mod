package fr.rodofire.mushrooomsmod.block.custom.bigmushroom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

public class BigMushroom extends Block {
    public BigMushroom(Properties settings) {
        super(settings);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.is(BlockTags.MUSHROOM_GROW_BLOCK) || blockState.is(ModBlocks.COMPRESSED_PURPLE_MUSHROOM.get())) {
            return true;
        }
        return this.canPlantOnTop(blockState, world, blockPos);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.isSolidRender(world, pos);
    }


}
