package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.structure.NbtPlacer;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.ArrayList;

public class GreenCryingMushroomFeature extends GreenCryingMushroom {

    public GreenCryingMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    protected ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random, boolean bees) {
        return ModConfiguredFeatures.GREEN_MUSHROOM_TREE;
    }

    @Override
    protected ArrayList<Integer> getCoordinates(LevelAccessor world, RandomSource random, BlockPos pos, BlockPos.MutableBlockPos mutable, int height, HugeMushroomFeatureConfiguration config) {
        int direction = random.nextIntBetweenInclusive(0, 3);
        ArrayList<Integer> heightb = new ArrayList<>();
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(0);
        coordinates.add(0);

        heightb.add(0);

        ArrayList<Integer> values = new ArrayList<>();

        if (height < 7) {
            heightb.add(random.nextIntBetweenInclusive(height / 3, 2 * height / 3 - 1));
            heightb.add((random.nextIntBetweenInclusive(heightb.get(1) + 1, (height * 2) / 3)));
        } else {

            heightb.add(random.nextIntBetweenInclusive(height / 4, height / 2));
            heightb.add((random.nextIntBetweenInclusive(heightb.get(1) + 1, (height * 3) / 4 - 1)));
            heightb.add((random.nextIntBetweenInclusive(heightb.get(2) + 1, (height * 3) / 4)));
        }
        values.add(heightb.size());
        values.addAll(heightb);

        ArrayList<Integer> directions = getTrunkDirection(direction, heightb.size() - 1, coordinates);

        values.addAll(directions);

        return values;
    }


    protected ArrayList<Integer> getTrunkDirection(int direction, int stop, ArrayList<Integer> coordinates) {
        if (stop <= 0) return coordinates;
        int randomx;
        int randomz;
        if (coordinates.size() == 2) {
            randomx = 0;
            randomz = 0;
        } else {
            randomx = coordinates.get(coordinates.size() - 2);
            randomz = coordinates.get(coordinates.size() - 1);
        }
        int newrandom = random.nextIntBetweenInclusive(0, 1);


        randomz = switch (direction) {
            case 0 -> {
                randomx = randomx + newrandom;
                yield randomz + (1 - newrandom);
            }
            case 1 -> {
                randomx = randomx + newrandom;
                yield randomz - (1 - newrandom);
            }
            case 2 -> {
                randomx = randomx - newrandom;
                yield randomz + (1 - newrandom);
            }
            default -> {
                randomx = randomx - newrandom;
                yield randomz - (1 - newrandom);
            }
        };
        coordinates.add(randomx);
        coordinates.add(randomz);
        return getTrunkDirection(direction, stop - 1, coordinates);
    }

    protected void placeTrunk(ArrayList<Integer> height, BlockPos.MutableBlockPos mutable, BlockPos start, LevelAccessor world, BlockState blockstate, ArrayList<Integer> coordinates, int lastheight) {
        int a = 0;
        int randomx;
        int randomz;
        int intheight;
        int maxheight;
        while (height.size() != a + 1) {
            intheight = height.get(a);
            maxheight = height.get(a + 1);
            randomx = coordinates.get(2 * a);
            randomz = coordinates.get(2 * a + 1);
            for (int i = intheight; i <= maxheight; ++i) {
                mutable.setWithOffset(start, randomx, i, randomz);
                this.setBlock(world, mutable, blockstate);
            }
            ++a;
        }
        for (int i = height.get(height.size() - 1); i <= lastheight; ++i) {
            randomx = coordinates.get(coordinates.size() - 2);
            randomz = coordinates.get(coordinates.size() - 1);
            mutable.setWithOffset(start, randomx, i, randomz);
            this.setBlock(world, mutable, blockstate);
        }
    }

    @Override
    protected Integer[] generateFirstCap(LevelAccessor world, RandomSource random, BlockPos start, int y, Integer[] coordinates, BlockPos.MutableBlockPos mutable, HugeMushroomFeatureConfiguration config, int large) {
        int cap = getCap(large);
        int large1;
        int rotation = random.nextInt(4);
        Rotation blockRotation;

        String path = "green_cap/first_cap/green_first_cap_" + large + "_" + cap;

        mutable.setWithOffset(start, coordinates[0], y, coordinates[1]);

        blockRotation = getBlockRotation(rotation);

        Integer[] coordinatesRotation = getCoordinatesRotation(rotation, large);
        large = coordinatesRotation[0];
        large1 = coordinatesRotation[1];


        place(world, mutable, large, large1, path, blockRotation);
        return new Integer[]{rotation, cap};
    }

    @Override
    protected void generateSecondCap(LevelAccessor world, RandomSource random, BlockPos start, int height, Integer[] coordinates, BlockPos.MutableBlockPos mutable, HugeMushroomFeatureConfiguration var6, int large, int rotation, int cap) {
        int large1;
        Rotation blockRotation;

        String path = "green_cap/second_cap/green_second_cap_" + large + "_" + cap + "_" + random.nextIntBetweenInclusive(1, 2);


        mutable.setWithOffset(start, coordinates[0], height - 1, coordinates[1]);

        blockRotation = getBlockRotation(rotation);

        Integer[] coordinatesRotation = getCoordinatesRotation(rotation, large + 1);
        large = coordinatesRotation[0];
        large1 = coordinatesRotation[1];
        place(world, mutable, large, large1, path, blockRotation);
    }

    @Override
    protected void generateThirdCap(LevelAccessor world, RandomSource random, BlockPos start, int height, Integer[] coordinates, BlockPos.MutableBlockPos mutable, HugeMushroomFeatureConfiguration var6, int large, int rotation) {
        int large1;
        int cap = getCap(large);
        Rotation blockRotation;

        String path = "green_cap/first_cap/green_first_cap_" + large + "_" + cap;

        mutable.setWithOffset(start, coordinates[0], height + 1, coordinates[1]);

        blockRotation = getBlockRotation(rotation);

        Integer[] coordinatesRotation = getCoordinatesRotation(rotation, large);
        large = coordinatesRotation[0];
        large1 = coordinatesRotation[1];

        place(world, mutable, large, large1, path, blockRotation);
    }

    private static void place(LevelAccessor world, BlockPos.MutableBlockPos mutable, int large, int large1, String path, Rotation blockRotation) {
        if (!world.isClientSide()) {
            BlockPos pivot = new BlockPos(large, 0, large1);
            NbtPlacer firstCap = new NbtPlacer((WorldGenLevel) world, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, path));
            firstCap.place(1.0f, mutable.offset(pivot), pivot, Mirror.NONE, blockRotation, true);
        }
    }

    protected Integer getCap(int large) {
        return switch (large) {
            case 1 -> random.nextIntBetweenInclusive(1, 6);
            case 2 -> random.nextIntBetweenInclusive(1, 5);
            case 3 -> random.nextIntBetweenInclusive(1, 8);
            default -> random.nextIntBetweenInclusive(1, 10);
        };
    }

    protected Integer[] getCoordinatesRotation(int rotation, int large) {
        int large1;
        switch (rotation) {
            case 2:
                large1 = large;
                break;
            case 1:
                large1 = -large;
                break;
            case 0:
                large = -large;
                large1 = large;
                break;
            default:
                large1 = large;
                large = -large;
                break;
        }
        return new Integer[]{large, large1};
    }

    protected Rotation getBlockRotation(int rotation) {
        return switch (rotation) {
            case 0 -> Rotation.NONE;
            case 1 -> Rotation.CLOCKWISE_90;
            case 2 -> Rotation.CLOCKWISE_180;
            default -> Rotation.COUNTERCLOCKWISE_90;
        };
    }


    @Override
    protected void placeDown(LevelAccessor world, RandomSource random, BlockPos pos, BlockPos.MutableBlockPos mutable, int height, int large, HugeMushroomFeatureConfiguration config) {
        BlockState blockstate = config.capProvider.getState(random, pos);
        int randomx;
        int randomz;
        int x;
        int z;
        int down = random.nextIntBetweenInclusive(1, large * 2);
        int random2 = 5;

        for (int i = 0; i <= down; ++i) {
            int random1 = random.nextIntBetweenInclusive(0, 3);

            if (random1 == random2) random1 = (random1 + random.nextIntBetweenInclusive(1, 3)) % 4;

            if (random1 == 0) {
                x = random.nextIntBetweenInclusive(-large - 1, large + 1);
                z = large + 1;
            } else if (random1 == 1) {
                x = random.nextIntBetweenInclusive(-large - 1, large + 1);
                z = -large - 1;
            } else if (random1 == 2) {
                z = random.nextIntBetweenInclusive(-large - 1, large + 1);
                x = large + 1;
            } else {
                z = random.nextIntBetweenInclusive(-large - 1, large + 1);
                x = -large - 1;
            }

            randomx = x < 0 ? 1 : -1;
            randomz = z < 0 ? 1 : -1;

            mutable.setWithOffset(pos, x, height - 2, z);

            boolean blockOnTop = world.getBlockState(mutable.above()).is(blockstate.getBlock());

            while (!blockOnTop) {

                if (Math.abs(x) > large + 1 || Math.abs(z) > large + 1) break;

                x = x + randomx;
                mutable.setWithOffset(pos, x, height - 2, z);

                if (world.getBlockState(mutable.above()).is(blockstate.getBlock())) break;

                z = z + randomz;
                mutable.setWithOffset(pos, x, height - 2, z);

                if (world.getBlockState(mutable.above()).is(blockstate.getBlock())) break;
            }

            int randomj = random.nextIntBetweenInclusive(0, 2);

            for (int j = 0; j <= randomj; ++j) {
                mutable.setWithOffset(pos, x, height - 2 - j, z);
                this.setBlock(world, mutable, blockstate);
            }
            random2 = random1;
        }
    }


}
