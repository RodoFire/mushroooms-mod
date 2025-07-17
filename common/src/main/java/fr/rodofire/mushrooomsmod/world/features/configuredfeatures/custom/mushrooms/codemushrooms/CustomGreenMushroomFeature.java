package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.shape.block.simplegen.GenCircles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import fr.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

import java.util.List;
import java.util.Set;


public class CustomGreenMushroomFeature extends CustomGreenMushroom {
    public CustomGreenMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected void trunkPlace(BlockPos start, BlockPos.MutableBlockPos mutable, WorldGenLevel world, ModMushroomFeatureConfig config, int height, RandomSource random) {
        BlockState blockState = config.stemProvider.getState(random, start);
        for (int i = 0; i <= height; ++i) {
            mutable.setWithOffset(start, 0, i, 0);
            this.setBlock(world, mutable, blockState);
        }
    }

    /* generate a cap
        the boolean bigcap determine if the cap will be 3 blocks high or 1
     */
    @Override
    protected void capPlacer(BlockPos start, BlockPos.MutableBlockPos mutable, WorldGenLevel world, ModMushroomFeatureConfig config, int large, int height, RandomSource random, boolean bigcap) {
        BlockState blockState = config.capProvider.getState(random, start);
        placecaps(start, mutable, world, large, height, blockState);

        if (bigcap) {
            placecaps(start, mutable, world, (int)(0.7*large), height + 1, blockState);
            placecaps(start, mutable, world, (int)(0.7*large), height - 1, blockState);
        }
    }

    protected void placecaps(BlockPos start, BlockPos.MutableBlockPos mutable, WorldGenLevel world, int large, int height, BlockState blockState) {
        //generate circle
        mutable.setWithOffset(start, 0, height, 0);
        GenCircles.generateFullCircle(world, large, mutable, false, Set.of(Blocks.MUSHROOM_STEM), List.of(blockState));
    }


}
