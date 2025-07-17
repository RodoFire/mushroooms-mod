package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

public class CustomPurpleMushroomFeature extends CustomPurpleMushroom {
    public CustomPurpleMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }


    protected ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random, boolean bees) {
        return ModConfiguredFeatures.PURPLE_MUSHROOM_TREE;
    }

    @Override
    protected void generateCap(LevelAccessor world, RandomSource random, BlockPos start, int y, BlockPos.MutableBlockPos mutable, HugeMushroomFeatureConfiguration config, int i) {
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                boolean bl6;
                boolean bl = j == -i;
                boolean bl2 = j == i;
                boolean bl3 = k == -i;
                boolean bl100 = k == -i + 1;
                boolean bl101 = k == i - 1;
                boolean bl102 = j == -i + 1;
                boolean bl103 = j == i - 1;
                boolean bl4 = k == i;
                boolean bl5 = bl || bl2;
                boolean bl7 = bl6 = bl3 || bl4;
                boolean bl104 = bl100 || bl101;
                boolean bl105 = bl102 || bl103;
                if (bl5 && bl6) continue;
                if (bl5 && bl104) continue;
                if (bl6 && bl105) continue;
                mutable.setWithOffset(start, j, y, k);
                if (world.getBlockState(mutable).isSolidRender(world, mutable)) continue;
                BlockState blockState = config.capProvider.getState(random, start);
                this.setBlock(world, mutable, blockState);
            }
        }
    }


}
