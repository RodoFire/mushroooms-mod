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

public class CustomLuminescentPinkMushroomFeature extends CustomLuminescentPinkMushroom {
    public CustomLuminescentPinkMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }


    protected ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random, boolean bees) {
        return ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE;
    }


    @Override
    protected void generateCap(LevelAccessor world, RandomSource random, BlockPos start, int y, BlockPos.MutableBlockPos mutable, HugeMushroomFeatureConfiguration config, int i) {
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                boolean bl = j == -i;
                boolean bl2 = j == i;
                boolean bl3 = k == -i;
                boolean bl100 = k == -i + 1;
                boolean bl101 = k == i - 1;
                boolean bl102 = j == -i + 1;
                boolean bl103 = j == i - 1;
                boolean bl4 = k == i;
                boolean bl5 = bl || bl2;
                boolean bl6 = bl3 || bl4;
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

    @Override
    protected void generateSecondCap(LevelAccessor world, RandomSource random, BlockPos start, int y, BlockPos.MutableBlockPos mutable, HugeMushroomFeatureConfiguration config, int z) {
        int i = z;
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                boolean bl = j == -i;
                boolean bl2 = j == i;
                boolean bl3 = k == -i;
                boolean bl4 = k == i;
                boolean bl100 = k <= -i + 3;
                boolean bl101 = k >= i - 3;
                boolean bl102 = j <= -i + 3;
                boolean bl103 = j >= i - 3;
                boolean bl200 = j == -i + 1;
                boolean bl201 = j == i - 1;
                boolean bl202 = k == i - 1;
                boolean bl203 = k == -i + 1;
                boolean bl5 = bl || bl2;
                boolean bl6 = bl3 || bl4;
                boolean bl104 = bl100 || bl101;
                boolean bl105 = bl102 || bl103;
                boolean bl204 = bl200 || bl201;
                boolean bl205 = bl202 || bl203;
                if (bl5 && bl104) continue;
                if (bl6 && bl105) continue;
                if (bl204 && bl205) continue;
                mutable.setWithOffset(start, j, y, k);
                if (world.getBlockState(mutable).isSolidRender(world, mutable)) continue;
                BlockState blockState = config.capProvider.getState(random, start);
                this.setBlock(world, mutable, blockState);
            }
        }
    }

    @Override
    protected void generateBottomCap(LevelAccessor world, RandomSource random, BlockPos start, int y, BlockPos.MutableBlockPos mutable, HugeMushroomFeatureConfiguration config, int i) {
        int e = config.foliageRadius;
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                boolean bl = j == -i;
                boolean bl2 = j == i;
                boolean bl3 = k == -i;
                boolean bl4 = k == i;

                boolean bl100 = k <= -i + 4;
                boolean bl101 = k >= i - 4;
                boolean bl102 = j <= -i + 4;
                boolean bl103 = j >= i - 4;

                boolean bl200 = k <= -i + 2;
                boolean bl201 = k >= i - 2;
                boolean bl202 = j <= -i + 2;
                boolean bl203 = j >= i - 2;

                boolean bl300 = j == -i + 1;
                boolean bl301 = j == i - 1;
                boolean bl302 = k == i - 1;
                boolean bl303 = k == -i + 1;

                boolean bl400 = k <= 3;
                boolean bl401 = k >= -3;
                boolean bl402 = j <= 3;
                boolean bl403 = j >= -3;

                boolean bl5 = bl || bl2;
                boolean bl6 = bl3 || bl4;
                boolean bl104 = bl100 || bl101;
                boolean bl105 = bl102 || bl103;
                boolean bl204 = bl200 || bl201;
                boolean bl205 = bl202 || bl203;
                boolean bl304 = bl300 || bl301;
                boolean bl305 = bl302 || bl303;
                boolean bl404 = bl400 && bl401;
                boolean bl405 = bl402 && bl403;
                if (bl5 && bl104) continue;
                if (bl6 && bl105) continue;
                if (bl204 && bl304) continue;
                if (bl205 && bl305) continue;
                if (bl205 && bl305) continue;
                if (bl404 && bl405) continue;
                bl = j >= -1;
                bl2 = j <= 1;
                bl3 = k >= -1;
                bl4 = k <= 1;
                bl100 = k > -e + 1;
                bl101 = k < e - 1;
                bl102 = j > -e + 1;
                bl103 = j < e - 1;
                bl200 = j == e;
                bl201 = j == -e;
                bl202 = k == e;
                bl203 = k == -e;
                bl5 = bl && bl2;
                bl6 = bl3 && bl4;
                bl104 = bl100 && bl101;
                bl105 = bl102 && bl103;
                bl204 = bl200 || bl201;
                bl205 = bl202 || bl203;
                if (bl105 && bl104) continue;
                if (bl6 && bl204) continue;
                if (bl5 && bl205) continue;
                mutable.setWithOffset(start, j, y, k);
                if (world.getBlockState(mutable).isSolidRender(world, mutable)) continue;
                BlockState blockState = config.capProvider.getState(random, start);
                this.setBlock(world, mutable, blockState);

            }
        }
    }


    @Override
    protected int getCapSize(int i, int j, int capSize, int y) {
        int k = 0;
        if (y < j && y >= j - 3) {
            k = capSize;
        } else if (y == j) {
            k = capSize;
        }
        return k;
    }
}
