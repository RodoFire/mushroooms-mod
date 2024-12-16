package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.easierworldcreator.shape.block.simplegen.GenCircles;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

import java.util.List;
import java.util.Set;


public class CustomGreenMushroomFeature extends CustomGreenMushroom {
    public CustomGreenMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected void trunkPlace(BlockPos start, BlockPos.Mutable mutable, StructureWorldAccess world, ModMushroomFeatureConfig config, int height, Random random) {
        BlockState blockState = config.stemProvider.get(random, start);
        for (int i = 0; i <= height; ++i) {
            mutable.set(start, 0, i, 0);
            this.setBlockState(world, mutable, blockState);
        }
    }

    /* generate a cap
        the boolean bigcap determine if the cap will be 3 blocks high or 1
     */
    @Override
    protected void capPlacer(BlockPos start, BlockPos.Mutable mutable, StructureWorldAccess world, ModMushroomFeatureConfig config, int large, int height, Random random, boolean bigcap) {
        BlockState blockState = config.capProvider.get(random, start);
        placecaps(start, mutable, world, large, height, blockState);

        if (bigcap) {
            placecaps(start, mutable, world, (int)(0.7*large), height + 1, blockState);
            placecaps(start, mutable, world, (int)(0.7*large), height - 1, blockState);
        }
    }

    protected void placecaps(BlockPos start, BlockPos.Mutable mutable, StructureWorldAccess world, int large, int height, BlockState blockState) {
        //generate circle
        mutable.set(start, 0, height, 0);
        GenCircles.generateFullCircle(world, large, mutable, false, Set.of(Blocks.MUSHROOM_STEM), List.of(blockState));
    }


}
