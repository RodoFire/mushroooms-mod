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

public class CustomLuminescentBlueMushroomFeature extends CustomLuminescentBlueMushroom {

    public CustomLuminescentBlueMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    protected ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random, boolean bees) {
        return ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE;
    }

    @Override
    protected int getCapSize(int capSize) {
        return random.nextIntBetweenInclusive(capSize - 1, capSize);
    }


    @Override
    protected void generateCap(LevelAccessor world, RandomSource random, BlockPos start, int y, BlockPos.MutableBlockPos mutable, HugeMushroomFeatureConfiguration config, int large) {
        for (int i = y - 3; i <= y; ++i) {
            int j = i < y ? large : large - 1;
            for (int l = -j; l <= j; ++l) {
                for (int m = -j; m <= j; ++m) {
                    boolean bl6;
                    boolean bl = l == -j;
                    boolean bl2 = l == j;
                    boolean bl3 = m == -j;
                    boolean bl4 = m == j;
                    boolean bl5 = bl || bl2;
                    boolean bl7 = bl6 = bl3 || bl4;
                    if (i < y && bl5 == bl6) continue;
                    mutable.setWithOffset(start, l, i, m);
                    if (world.getBlockState(mutable).isSolidRender(world, mutable)) continue;
                    BlockState blockState = config.capProvider.getState(random, start);
                    this.setBlock(world, mutable, blockState);
                }
            }
        }
    }
}
