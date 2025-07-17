package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public abstract class CustomLuminescentBlueMushroom extends Feature<HugeMushroomFeatureConfiguration> {
    RandomSource random;

    public CustomLuminescentBlueMushroom(Codec<HugeMushroomFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    protected void generateStem(LevelAccessor world, RandomSource random, BlockPos pos, HugeMushroomFeatureConfiguration config, int height, BlockPos.MutableBlockPos mutablePos) {
        for (int i = 0; i < height; ++i) {
            mutablePos.set(pos).move(Direction.UP, i);
            if (world.getBlockState(mutablePos).isSolidRender(world, mutablePos)) continue;
            this.setBlock(world, mutablePos, config.stemProvider.getState(random, pos));
        }
    }

    protected int getHeight(RandomSource random) {
        int i = random.nextInt(3) + 4;
        if (random.nextInt(12) == 0) {
            i *= 2;
        }
        return i;
    }

    protected boolean canGenerate(LevelAccessor world, BlockPos pos, int height, BlockPos.MutableBlockPos mutablePos, HugeMushroomFeatureConfiguration config, int large) {
        BlockState blockState = world.getBlockState(pos.below());
        if (!blockState.is(BlockTags.DIRT) && !blockState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return false;
        }
        for (int j = height - 3; j <= height; ++j) {
            int k = large;
            for (int l = -k; l <= k; ++l) {
                for (int m = -k; m <= k; ++m) {
                    BlockState blockState2 = world.getBlockState(mutablePos.setWithOffset(pos, l, j, m));
                    if (blockState2.isAir() || blockState2.is(BlockTags.LEAVES))
                        continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean place(FeaturePlaceContext<HugeMushroomFeatureConfiguration> context) {
        BlockPos.MutableBlockPos mutable;
        WorldGenLevel structureWorldAccess = context.level();
        BlockPos blockPos = context.origin();
        this.random = context.random();
        HugeMushroomFeatureConfiguration hugeMushroomFeatureConfig = context.config();

        int i = this.getHeight(random);
        int large = this.getCapSize(hugeMushroomFeatureConfig.foliageRadius);

        if (!this.canGenerate(structureWorldAccess, blockPos, i, mutable = new BlockPos.MutableBlockPos(), hugeMushroomFeatureConfig, large)) {
            return false;
        }

        this.generateCap(structureWorldAccess, random, blockPos, i, mutable, hugeMushroomFeatureConfig, large);
        this.generateStem(structureWorldAccess, random, blockPos, hugeMushroomFeatureConfig, i, mutable);
        return true;
    }

    protected abstract int getCapSize(int var1);

    protected abstract void generateCap(LevelAccessor var1, RandomSource var2, BlockPos var3, int var4, BlockPos.MutableBlockPos var5, HugeMushroomFeatureConfiguration var6, int large);
}
