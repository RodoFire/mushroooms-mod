package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public abstract class CustomPurpleMushroom extends Feature<HugeMushroomFeatureConfiguration> {
    public CustomPurpleMushroom(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
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

    protected boolean canGenerate(LevelAccessor world, BlockPos pos, int height, BlockPos.MutableBlockPos mutablePos, int z) {
        int i = pos.getY();
        if (i < world.getMinBuildHeight() + 1 || i + height + 1 >= world.getMaxBuildHeight()) {
            return false;
        }
        BlockState blockState = world.getBlockState(pos.below());

        if (!AbstractHugeMushroomFeature.isDirt(blockState) && !blockState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return false;
        }
        for (int j = 0; j < height; ++j) {
            for (int l = -1; l <= 1; ++l) {
                for (int k = -1; k <= 1; ++k) {
                    BlockState blockState2 = world.getBlockState(mutablePos.setWithOffset(pos, l, j, k));
                    if (blockState2.isAir() || blockState2.is(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        for (int l = -z; l <= z; ++l) {
            for (int m = -z; m <= z; ++m) {
                BlockState blockState2 = world.getBlockState(mutablePos.setWithOffset(pos, l, height, m));
                if (blockState2.isAir() || blockState2.is(BlockTags.LEAVES)) continue;
                return false;
            }
        }

        for (int l = -z + 1; l <= z - 1; ++l) {
            for (int m = -z + 1; m <= z - 1; ++m) {
                BlockState blockState2 = world.getBlockState(mutablePos.setWithOffset(pos, l, height + 1, m));
                if (blockState2.isAir() || blockState2.is(BlockTags.LEAVES)) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(FeaturePlaceContext<HugeMushroomFeatureConfiguration> context) {
        BlockPos.MutableBlockPos mutable;
        BlockPos blockPos = context.origin();
        WorldGenLevel structureWorldAccess = context.level();
        RandomSource random = context.random();
        HugeMushroomFeatureConfiguration hugeMushroomFeatureConfig = context.config();

        int i = this.getHeight(random);
        int z = random.nextIntBetweenInclusive(3, 6);

        if (!this.canGenerate(structureWorldAccess, blockPos, i, mutable = new BlockPos.MutableBlockPos(), z)) {
            return false;
        }

        this.generateCap(structureWorldAccess, random, blockPos, i, mutable, hugeMushroomFeatureConfig, z);
        this.generateCap(structureWorldAccess, random, blockPos, i + 1, mutable, hugeMushroomFeatureConfig, z - 1);
        this.generateStem(structureWorldAccess, random, blockPos, hugeMushroomFeatureConfig, i, mutable);

        return true;
    }


    protected abstract void generateCap(LevelAccessor var1, RandomSource var2, BlockPos var3, int var4, BlockPos.MutableBlockPos var5, HugeMushroomFeatureConfiguration var6, int var7);
}
