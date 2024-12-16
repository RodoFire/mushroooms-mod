package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class CustomPurpleMushroom extends Feature<HugeMushroomFeatureConfig> {
    public CustomPurpleMushroom(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }

    protected void generateStem(WorldAccess world, Random random, BlockPos pos, HugeMushroomFeatureConfig config, int height, BlockPos.Mutable mutablePos) {
        for (int i = 0; i < height; ++i) {
            mutablePos.set(pos).move(Direction.UP, i);
            if (world.getBlockState(mutablePos).isOpaqueFullCube()) continue;
            this.setBlockState(world, mutablePos, config.stemProvider.get(random, pos));
        }
    }

    protected int getHeight(Random random) {
        int i = random.nextInt(3) + 4;
        if (random.nextInt(12) == 0) {
            i *= 2;
        }
        return i;
    }

    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, BlockPos.Mutable mutablePos, int z) {
        int i = pos.getY();        if (i < world.getBottomY() + 1 || i + height + 1 >= world.getDimension().height()) {

            return false;
        }
        BlockState blockState = world.getBlockState(pos.down());

        if (!HugeMushroomFeature.isSoil(blockState) && !blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return false;
        }
        for (int j = 0; j < height; ++j) {
            for (int l = -1; l <= 1; ++l) {
                for (int k = -1; k <= 1; ++k) {
                    BlockState blockState2 = world.getBlockState(mutablePos.set(pos, l, j, k));
                    if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        for (int l = -z; l <= z; ++l) {
            for (int m = -z; m <= z; ++m) {
                BlockState blockState2 = world.getBlockState(mutablePos.set(pos, l, height, m));
                if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                return false;
            }
        }

        for (int l = -z + 1; l <= z - 1; ++l) {
            for (int m = -z + 1; m <= z - 1; ++m) {
                BlockState blockState2 = world.getBlockState(mutablePos.set(pos, l, height + 1, m));
                if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<HugeMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        Random random = context.getRandom();
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();

        int i = this.getHeight(random);
        int z = Random.create().nextBetween(3, 6);

        if (!this.canGenerate(structureWorldAccess, blockPos, i, mutable = new BlockPos.Mutable(), z)) {
            return false;
        }

        this.generateCap(structureWorldAccess, random, blockPos, i, mutable, hugeMushroomFeatureConfig, z);
        this.generateCap(structureWorldAccess, random, blockPos, i + 1, mutable, hugeMushroomFeatureConfig, z - 1);
        this.generateStem(structureWorldAccess, random, blockPos, hugeMushroomFeatureConfig, i, mutable);

        return true;
    }


    protected abstract void generateCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int var7);
}
