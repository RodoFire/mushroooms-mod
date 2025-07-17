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

public abstract class CustomLuminescentPinkMushroom extends Feature<HugeMushroomFeatureConfiguration> {
    public CustomLuminescentPinkMushroom(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    protected void generateStem(LevelAccessor world, RandomSource random, BlockPos pos, BlockPos start, HugeMushroomFeatureConfiguration config, int height, BlockPos.MutableBlockPos mutablePos, BlockPos.MutableBlockPos mutable) {
        for (int i = 0; i < height; ++i) {
            mutablePos.set(pos).move(Direction.UP, i);
            if (world.getBlockState(mutablePos).isSolidRender(world, mutablePos)) continue;
            this.setBlock(world, mutablePos, config.stemProvider.getState(random, pos));
            if (i == height - 3) {
                mutable.setWithOffset(start, 0, i, -1);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
            }
            if (i == height - 2) {
                mutable.setWithOffset(start, 0, i, -1);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
                mutable.setWithOffset(start, -1, i, 0);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
                mutable.setWithOffset(start, 1, i, 0);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
            }
            if (i == height - 1) {
                mutable.setWithOffset(start, 0, i, 1);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
                mutable.setWithOffset(start, -1, i, 0);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
                mutable.setWithOffset(start, 1, i, 0);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
                mutable.setWithOffset(start, 0, i, -1);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
                mutable.setWithOffset(start, -1, i, -1);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
                mutable.setWithOffset(start, -1, i, -1);
                this.setBlock(world, mutable, config.stemProvider.getState(random, pos));
            }
        }
    }

    protected int getHeight(RandomSource random) {
        int i = random.nextInt(5) + 4;
        if (random.nextInt(14) == 0) {
            i *= 2;
        }
        return i;
    }

    protected boolean canGenerate(LevelAccessor world, BlockPos pos, int height, BlockPos.MutableBlockPos mutablePos, HugeMushroomFeatureConfiguration config) {
        int i = pos.getY();
        if (i < world.getMinBuildHeight() + 1 || i + height + 1 >= world.getMaxBuildHeight()) {
            return false;
        }
        BlockState blockState = world.getBlockState(pos.below());
        if (!AbstractHugeMushroomFeature.isDirt(blockState) && !blockState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return false;
        }
        for (int j = 0; j <= height; ++j) {
            int k = this.getCapSize(-1, -1, config.foliageRadius, j);
            for (int l = -k; l <= k; ++l) {
                for (int m = -k; m <= k; ++m) {
                    BlockState blockState2 = world.getBlockState(mutablePos.setWithOffset(pos, l, j, m));
                    if (blockState2.isAir() || blockState2.is(BlockTags.LEAVES)) continue;
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
        RandomSource random = context.random();
        HugeMushroomFeatureConfiguration hugeMushroomFeatureConfig = context.config();
        int i = this.getHeight(random);
        if (!this.canGenerate(structureWorldAccess, blockPos, i, mutable = new BlockPos.MutableBlockPos(), hugeMushroomFeatureConfig)) {
            return false;
        }
        int z = hugeMushroomFeatureConfig.foliageRadius;
        this.generateBottomCap(structureWorldAccess, random, blockPos, i - 1, mutable, hugeMushroomFeatureConfig, z + 3);
        this.generateSecondCap(structureWorldAccess, random, blockPos, i, mutable, hugeMushroomFeatureConfig, z + 1);
        this.generateCap(structureWorldAccess, random, blockPos, i + 1, mutable, hugeMushroomFeatureConfig, z - 1);
        this.generateStem(structureWorldAccess, random, blockPos, blockPos, hugeMushroomFeatureConfig, i, mutable, mutable);
        return true;
    }

    protected abstract int getCapSize(int var1, int var2, int var3, int var4);

    protected abstract void generateCap(LevelAccessor var1, RandomSource var2, BlockPos var3, int var4, BlockPos.MutableBlockPos var5, HugeMushroomFeatureConfiguration var6, int var7);

    protected abstract void generateSecondCap(LevelAccessor var1, RandomSource var2, BlockPos var3, int var4, BlockPos.MutableBlockPos var5, HugeMushroomFeatureConfiguration var6, int var7);

    protected abstract void generateBottomCap(LevelAccessor var1, RandomSource var2, BlockPos var3, int var4, BlockPos.MutableBlockPos var5, HugeMushroomFeatureConfiguration var6, int var7);
}
