package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import java.util.ArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public abstract class GreenCryingMushroom extends Feature<HugeMushroomFeatureConfiguration> {
    RandomSource random;


    public GreenCryingMushroom(Codec<HugeMushroomFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(LevelAccessor world, BlockPos pos, int height, int large, BlockPos.MutableBlockPos mutable, ArrayList<Integer> coordinates, ArrayList<Integer> heightb, boolean threecap) {
        int a = 0;
        int randomx;
        int randomz;
        int intheight;
        int maxheight;
        while (heightb.size() != a + 1) {
            intheight = heightb.get(a);
            maxheight = heightb.get(a + 1);
            randomx = coordinates.get(2 * a);
            randomz = coordinates.get(2 * a + 1);
            for (int i = intheight; i <= maxheight; ++i) {
                mutable.setWithOffset(pos, randomx, i, randomz);
                BlockState state = world.getBlockState(mutable);
                if (!state.is(BlockTags.LEAVES) && !state.isAir() && !state.is(BlockTags.FLOWERS))
                    return false;
            }
            ++a;
        }
        for (int i = -large; i <= large; ++i) {
            for (int j = -large; j <= large; ++j) {
                mutable.setWithOffset(pos, i + coordinates.get(coordinates.size() - 2), height, j + coordinates.get(coordinates.size() - 1));
                BlockState state = world.getBlockState(mutable);
                if (!state.is(BlockTags.LEAVES) && !state.isAir() && !state.is(BlockTags.FLOWERS))
                    return false;

            }
        }
        for (int i = -large - 1; i <= large + 1; ++i) {
            for (int j = -large - 1; j <= large + 1; ++j) {
                mutable.setWithOffset(pos, i + coordinates.get(coordinates.size() - 2), height - 1, j + coordinates.get(coordinates.size() - 1));
                BlockState state = world.getBlockState(mutable);
                if (!state.is(BlockTags.LEAVES) && !state.isAir() && !state.is(BlockTags.FLOWERS))
                    return false;

            }
        }
        if (threecap) {
            for (int i = -large + 1; i <= large - 1; ++i) {
                for (int j = -large - 1; j <= large + 1; ++j) {
                    mutable.setWithOffset(pos, i + coordinates.get(coordinates.size() - 2), height + 1, j + coordinates.get(coordinates.size() - 1));
                    BlockState state = world.getBlockState(mutable);
                    if (!state.is(BlockTags.LEAVES) && !state.isAir() && !state.is(BlockTags.FLOWERS))
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
        this.random = random;
        HugeMushroomFeatureConfiguration hugeMushroomFeatureConfig = context.config();
        mutable = new BlockPos.MutableBlockPos();
        boolean threecap = true;
        int secondlarge;

        if(!structureWorldAccess.getBlockState(blockPos.below()).isSolidRender(structureWorldAccess, blockPos.below())) return false;

        ArrayList<Integer> heightb = new ArrayList<>();
        ArrayList<Integer> coordinates = new ArrayList<>();

        int large = random.nextIntBetweenInclusive(1, 4);
        int height = random.nextIntBetweenInclusive(5, 12);

        ArrayList<Integer> values = getCoordinates(structureWorldAccess, random, blockPos, mutable, height, hugeMushroomFeatureConfig);
        for (int i = 1; i < values.get(0) + 1; ++i) {
            heightb.add(values.get(i));
        }
        for (int i = values.get(0) + 1; i < values.size(); ++i) {
            coordinates.add(values.get(i));
        }
        if (random.nextIntBetweenInclusive(0, 3) == 0) {
            threecap = false;
        }


        if (!this.canGenerate(structureWorldAccess, blockPos, height + 1, large, mutable, coordinates, heightb, threecap)) {
            return false;
        }


        Integer[] lastcoordinates = new Integer[2];
        lastcoordinates[0] = coordinates.get(coordinates.size() - 2);
        lastcoordinates[1] = coordinates.get(coordinates.size() - 1);
        Integer[] secondvalues = this.generateFirstCap(structureWorldAccess, random, blockPos, height + 2, lastcoordinates, mutable, hugeMushroomFeatureConfig, large);
        int rotation = secondvalues[0];
        int cap = secondvalues[1];
        this.generateSecondCap(structureWorldAccess, random, blockPos, height + 2, lastcoordinates, mutable, hugeMushroomFeatureConfig, large, rotation, cap);

        if (threecap) {
            if (large == 1) {
                secondlarge = 0;
            } else {
                secondlarge = large - random.nextIntBetweenInclusive(2, large);
            }
            this.generateThirdCap(structureWorldAccess, random, blockPos, height + 2, lastcoordinates, mutable, hugeMushroomFeatureConfig, secondlarge, rotation);
        }
        placeTrunk(heightb, mutable, blockPos, structureWorldAccess, Blocks.MUSHROOM_STEM.defaultBlockState(), coordinates, height + 1);

        if (large > 2)
            placeDown(structureWorldAccess, random, blockPos, mutable, height + 2, large + 1, hugeMushroomFeatureConfig);
        return true;
    }

    protected abstract ArrayList<Integer> getCoordinates(LevelAccessor world, RandomSource random, BlockPos pos, BlockPos.MutableBlockPos mutable, int height, HugeMushroomFeatureConfiguration config);

    protected abstract void placeTrunk(ArrayList<Integer> height, BlockPos.MutableBlockPos mutable, BlockPos start, LevelAccessor world, BlockState blockstate, ArrayList<Integer> coordinates, int lastheight);

    protected abstract Integer[] generateFirstCap(LevelAccessor var1, RandomSource var2, BlockPos var3, int var4, Integer[] coordinates, BlockPos.MutableBlockPos var5, HugeMushroomFeatureConfiguration var6, int large);

    protected abstract void generateSecondCap(LevelAccessor var1, RandomSource var2, BlockPos var3, int var4, Integer[] coordinates, BlockPos.MutableBlockPos var5, HugeMushroomFeatureConfiguration var6, int large, int rotation, int cap);

    protected abstract void generateThirdCap(LevelAccessor var1, RandomSource var2, BlockPos var3, int var4, Integer[] coordinates, BlockPos.MutableBlockPos var5, HugeMushroomFeatureConfiguration var6, int large, int rotation);

    protected abstract void placeDown(LevelAccessor world, RandomSource random, BlockPos pos, BlockPos.MutableBlockPos mutable, int height, int large, HugeMushroomFeatureConfiguration config);
}
