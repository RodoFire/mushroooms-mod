package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;

public abstract class CustomGreenSecondMushroom extends Feature<HugeMushroomFeatureConfig> {
    Random random;


    public CustomGreenSecondMushroom(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, int large, BlockPos.Mutable mutable, ArrayList<Integer> coordinates, ArrayList<Integer> heightb, boolean threecap) {
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
                mutable.set(pos, randomx, i, randomz);
                BlockState state = world.getBlockState(mutable);
                if (!state.isIn(BlockTags.LEAVES) && !state.isAir() && !state.isIn(BlockTags.FLOWERS))
                    return false;
            }
            ++a;
        }
        for (int i = -large; i <= large; ++i) {
            for (int j = -large; j <= large; ++j) {
                mutable.set(pos, i + coordinates.get(coordinates.size() - 2), height, j + coordinates.get(coordinates.size() - 1));
                BlockState state = world.getBlockState(mutable);
                if (!state.isIn(BlockTags.LEAVES) && !state.isAir() && !state.isIn(BlockTags.FLOWERS))
                    return false;

            }
        }
        for (int i = -large - 1; i <= large + 1; ++i) {
            for (int j = -large - 1; j <= large + 1; ++j) {
                mutable.set(pos, i + coordinates.get(coordinates.size() - 2), height - 1, j + coordinates.get(coordinates.size() - 1));
                BlockState state = world.getBlockState(mutable);
                if (!state.isIn(BlockTags.LEAVES) && !state.isAir() && !state.isIn(BlockTags.FLOWERS))
                    return false;

            }
        }
        if (threecap) {
            for (int i = -large + 1; i <= large - 1; ++i) {
                for (int j = -large - 1; j <= large + 1; ++j) {
                    mutable.set(pos, i + coordinates.get(coordinates.size() - 2), height + 1, j + coordinates.get(coordinates.size() - 1));
                    BlockState state = world.getBlockState(mutable);
                    if (!state.isIn(BlockTags.LEAVES) && !state.isAir() && !state.isIn(BlockTags.FLOWERS))
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
        this.random = random;
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();
        mutable = new BlockPos.Mutable();
        boolean threecap = true;
        int secondlarge;

        ArrayList<Integer> heightb = new ArrayList<>();
        ArrayList<Integer> coordinates = new ArrayList<>();

        int large = random.nextBetween(1, 4);
        int height = random.nextBetween(5, 12);

        ArrayList<Integer> values = getCoordinates(structureWorldAccess, random, blockPos, mutable, height, hugeMushroomFeatureConfig);
        for (int i = 1; i < values.get(0) + 1; ++i) {
            heightb.add(values.get(i));
        }
        for (int i = values.get(0) + 1; i < values.size(); ++i) {
            coordinates.add(values.get(i));
        }
        if (random.nextBetween(0, 3) == 0) {
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
                secondlarge = large - random.nextBetween(2, large);
            }
            this.generateThirdCap(structureWorldAccess, random, blockPos, height + 2, lastcoordinates, mutable, hugeMushroomFeatureConfig, secondlarge, rotation);
        }
        placeTrunk(heightb, mutable, blockPos, structureWorldAccess, Blocks.MUSHROOM_STEM.getDefaultState(), coordinates, height + 1);

        if (large > 2)
            placeDown(structureWorldAccess, random, blockPos, mutable, height + 2, large + 1, hugeMushroomFeatureConfig);
        return true;
    }

    protected abstract ArrayList<Integer> getCoordinates(WorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config);

    protected abstract void placeTrunk(ArrayList<Integer> height, BlockPos.Mutable mutable, BlockPos start, WorldAccess world, BlockState blockstate, ArrayList<Integer> coordinates, int lastheight);

    protected abstract Integer[] generateFirstCap(WorldAccess var1, Random var2, BlockPos var3, int var4, Integer[] coordinates, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int large);

    protected abstract void generateSecondCap(WorldAccess var1, Random var2, BlockPos var3, int var4, Integer[] coordinates, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int large, int rotation, int cap);

    protected abstract void generateThirdCap(WorldAccess var1, Random var2, BlockPos var3, int var4, Integer[] coordinates, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int large, int rotation);

    protected abstract void placeDown(WorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, int large, HugeMushroomFeatureConfig config);
}
