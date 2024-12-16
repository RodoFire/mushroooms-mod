package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class CustomLuminescentPinkMushroom extends Feature<HugeMushroomFeatureConfig> {
    public CustomLuminescentPinkMushroom(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }

    protected void generateStem(WorldAccess world, Random random, BlockPos pos, BlockPos start, HugeMushroomFeatureConfig config, int height, BlockPos.Mutable mutablePos, BlockPos.Mutable mutable) {
        for (int i = 0; i < height; ++i) {
            mutablePos.set(pos).move(Direction.UP, i);
            if (world.getBlockState(mutablePos).isOpaqueFullCube()) continue;
            this.setBlockState(world, mutablePos, config.stemProvider.get(random, pos));
            if (i == height - 3) {
                mutable.set(start, 0, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
            }
            if (i == height - 2) {
                mutable.set(start, 0, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, -1, i, 0);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, 1, i, 0);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
            }
            if (i == height - 1) {
                mutable.set(start, 0, i, 1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, -1, i, 0);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, 1, i, 0);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, 0, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, -1, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, -1, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
            }
        }
    }

    protected int getHeight(Random random) {
        int i = random.nextInt(5) + 4;
        if (random.nextInt(14) == 0) {
            i *= 2;
        }
        return i;
    }

    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, BlockPos.Mutable mutablePos, HugeMushroomFeatureConfig config) {
        int i = pos.getY();
        if (i < world.getBottomY() + 1 || i + height + 1 >= world.getDimension().height()) {
            return false;
        }
        BlockState blockState = world.getBlockState(pos.down());
        if (!HugeMushroomFeature.isSoil(blockState) && !blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return false;
        }
        for (int j = 0; j <= height; ++j) {
            int k = this.getCapSize(-1, -1, config.foliageRadius, j);
            for (int l = -k; l <= k; ++l) {
                for (int m = -k; m <= k; ++m) {
                    BlockState blockState2 = world.getBlockState(mutablePos.set(pos, l, j, m));
                    if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<HugeMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();
        int i = this.getHeight(random);
        if (!this.canGenerate(structureWorldAccess, blockPos, i, mutable = new BlockPos.Mutable(), hugeMushroomFeatureConfig)) {
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

    protected abstract void generateCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int var7);

    protected abstract void generateSecondCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int var7);

    protected abstract void generateBottomCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int var7);
}
