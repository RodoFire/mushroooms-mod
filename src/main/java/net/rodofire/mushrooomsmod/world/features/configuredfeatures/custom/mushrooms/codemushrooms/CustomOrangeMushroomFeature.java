package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.rodofire.easierworldcreator.worldgenutil.GenSpheres;

import java.util.ArrayList;

public class CustomOrangeMushroomFeature extends CustomOrangeMushroom {
    public CustomOrangeMushroomFeature(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected void generateGiantTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config) {
        BlockState blockState = config.stemProvider.get(random, pos);
        int firstlarge = Random.create().nextBetween(2, 4);
        int lastlarge = 1;

        for (int i = 0; i <= height; ++i) {
            mutable.set(pos, 0, i, 0);
            this.setBlockState(world, mutable, blockState);
        }
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(Random.create().nextBetween(3, height / 3));
        coordinates.add(Random.create().nextBetween(3, height / 3));
        coordinates.add(Random.create().nextBetween(3, height / 3));
        coordinates.add(Random.create().nextBetween(3, height / 3));

        for (int i = 0; i < 4; ++i) {
            coordinates.add(Random.create().nextBetween(2, coordinates.get(i) - 1));
        }
        for (int i = 0; i < 4; ++i) {
            coordinates.add(Random.create().nextBetween(0, coordinates.get(i) - 1));
        }
        placeBase(world, mutable, pos, blockState, 1, 0, coordinates.get(0));
        placeBase(world, mutable, pos, blockState, 0, 1, coordinates.get(1));
        placeBase(world, mutable, pos, blockState, 0, -1, coordinates.get(2));
        placeBase(world, mutable, pos, blockState, -1, 0, coordinates.get(3));

        placeBase(world, mutable, pos, blockState, -2, 0, coordinates.get(8));
        placeBase(world, mutable, pos, blockState, 0, 2, coordinates.get(9));
        placeBase(world, mutable, pos, blockState, 0, 2, coordinates.get(10));
        placeBase(world, mutable, pos, blockState, -2, 0, coordinates.get(11));

        placeBase(world, mutable, pos, blockState, 1, 1, coordinates.get(4));
        placeBase(world, mutable, pos, blockState, 1, -1, coordinates.get(5));
        placeBase(world, mutable, pos, blockState, -1, 1, coordinates.get(6));
        placeBase(world, mutable, pos, blockState, -1, -1, coordinates.get(7));

        ArrayList<Integer> topcoordinates = new ArrayList<>();
        topcoordinates.add(Random.create().nextBetween(2, height / 4));
        topcoordinates.add(Random.create().nextBetween(2, height / 4));
        topcoordinates.add(Random.create().nextBetween(2, height / 4));
        topcoordinates.add(Random.create().nextBetween(2, height / 4));

        for (int i = 0; i < 4; ++i) {
            topcoordinates.add(Random.create().nextBetween(0, topcoordinates.get(i) - 1));
        }

        placeTop(world, mutable, pos, blockState, 1, 0, height, topcoordinates.get(0));
        placeTop(world, mutable, pos, blockState, 0, 1, height, topcoordinates.get(1));
        placeTop(world, mutable, pos, blockState, 0, -1, height, topcoordinates.get(2));
        placeTop(world, mutable, pos, blockState, -1, 0, height, topcoordinates.get(3));

        placeTop(world, mutable, pos, blockState, 1, 1, height, topcoordinates.get(4));
        placeTop(world, mutable, pos, blockState, 1, -1, height, topcoordinates.get(5));
        placeTop(world, mutable, pos, blockState, -1, 1, height, topcoordinates.get(6));
        placeTop(world, mutable, pos, blockState, -1, -1, height, topcoordinates.get(7));


    }

    @Override
    protected void generateGiantCap(StructureWorldAccess world, Random random, BlockPos pos, int height, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, int large) {
        BlockState blockState = config.capProvider.get(random, pos);
        BlockState blockState2 = Blocks.AIR.getDefaultState();

        GenSpheres.generateFullEllipsoid(world, (int) (large * 0.9f), (int) (large * 2.4f), (int) (large * 0.9f), pos.add(0, (int) (height - 2.4 * large + 4), 0), blockState);
        GenSpheres.generateFullEllipsoid(world, (int) ((large - 1) * 0.9f), (int) ((large - 1) * 2.4f), (int) ((large - 1) * 0.9f), pos.add(0, (int) (height - 2.4 * large + 4), 0), blockState);
        /*for (float secondlarge = large - 2; secondlarge <= large; secondlarge = secondlarge + 0.25f) {
            for (double i = -Math.PI / (3 * large); i <= Math.PI / 2; i = i + Math.PI / (8 * large)) {
                for (double j = -Math.PI; j <= Math.PI; j = j + Math.PI / (7 * large)) {
                    double x = secondlarge * 0.9 * Math.cos(i) * Math.cos(j);
                    double z = secondlarge * 0.9 * Math.cos(i) * Math.sin(j);
                    double y = secondlarge * 2.4 * Math.sin(i);
                    mutable.set(pos, (int) x, (int) (y + height - 2.4 * large + 4), (int) z);
                    if (!world.getBlockState(mutable).isOf(blockState.getBlock()))
                        this.setBlockState(world, mutable, blockState);
                }
            }
        }
        for (float secondlarge = 0; secondlarge < large - 0.75f; secondlarge = secondlarge + 0.25f) {
            for (double i = 0; i <= Math.PI / 2; i = i + Math.PI / (4 * large)) {
                for (double j = -Math.PI; j <= Math.PI; j = j + Math.PI / (4 * large)) {
                    double x = secondlarge * 0.9 * Math.cos(i) * Math.cos(j);
                    double z = secondlarge * 0.9 * Math.cos(i) * Math.sin(j);
                    double y = secondlarge * 2.4 * Math.sin(i);
                    mutable.set(pos, (int) x, (int) (y + height - 2.4 * large), (int) z);
                    if (world.getBlockState(mutable).isOf(blockState.getBlock()))
                        this.setBlockState(world, mutable, blockState2);
                }
            }
        }*/
    }

    @Override
    protected void generateTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config) {
        BlockState blockState = config.stemProvider.get(random, pos);
        int firstlarge = Random.create().nextBetween(2, 4);
        int lastlarge = 1;

        for (int i = 0; i <= height; ++i) {
            mutable.set(pos, 0, i, 0);
            this.setBlockState(world, mutable, blockState);
        }
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(Random.create().nextBetween(1, height / 3));
        coordinates.add(Random.create().nextBetween(1, height / 3));
        coordinates.add(Random.create().nextBetween(1, height / 3));
        coordinates.add(Random.create().nextBetween(1, height / 3));

        for (int i = 0; i < 4; ++i) {
            coordinates.add(Random.create().nextBetween(0, coordinates.get(i) - 1));
        }

        placeBase(world, mutable, pos, blockState, 1, 0, coordinates.get(0));
        placeBase(world, mutable, pos, blockState, 0, 1, coordinates.get(1));
        placeBase(world, mutable, pos, blockState, 0, -1, coordinates.get(2));
        placeBase(world, mutable, pos, blockState, -1, 0, coordinates.get(3));

        placeBase(world, mutable, pos, blockState, 1, 1, coordinates.get(4));
        placeBase(world, mutable, pos, blockState, 1, -1, coordinates.get(5));
        placeBase(world, mutable, pos, blockState, -1, 1, coordinates.get(6));
        placeBase(world, mutable, pos, blockState, -1, -1, coordinates.get(7));


        ArrayList<Integer> topcoordinates = new ArrayList<>();
        topcoordinates.add(Random.create().nextBetween(2, height / 4 + 1));
        topcoordinates.add(Random.create().nextBetween(2, height / 4 + 1));
        topcoordinates.add(Random.create().nextBetween(2, height / 4 + 1));
        topcoordinates.add(Random.create().nextBetween(2, height / 4 + 1));

        placeTop(world, mutable, pos, blockState, 1, 0, height, topcoordinates.get(0));
        placeTop(world, mutable, pos, blockState, 0, 1, height, topcoordinates.get(1));
        placeTop(world, mutable, pos, blockState, 0, -1, height, topcoordinates.get(2));
        placeTop(world, mutable, pos, blockState, -1, 0, height, topcoordinates.get(3));


    }

    protected void placeBase(StructureWorldAccess world, BlockPos.Mutable mutable, BlockPos pos, BlockState blockState, int x, int z, int height) {
        for (int j = 0; j <= height; ++j) {
            mutable.set(pos, x, j, z);
            this.setBlockState(world, mutable, blockState);
        }
    }

    protected void placeTop(WorldAccess world, BlockPos.Mutable mutable, BlockPos pos, BlockState blockState, int x, int z, int height, int secondheight) {
        for (int j = height - secondheight; j <= height; ++j) {
            mutable.set(pos, x, j, z);
            this.setBlockState(world, mutable, blockState);
        }
    }


    @Override
    protected void generateCap(StructureWorldAccess world, Random random, BlockPos pos, int height, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, int large) {
        BlockState blockState = config.capProvider.get(random, pos);
        BlockState blockState2 = Blocks.AIR.getDefaultState();

        GenSpheres.generateFullEllipsoid(world, large, (int) (2.4 * large), large, pos.add(0, height - large + 3, 0), blockState, true);
        GenSpheres.generateFullEllipsoid(world, large - 1, (int) (2.4 * (large - 1)), large - 1, pos.add(0, height - large - 1, 0), blockState2, true);
        /*for (float secondlarge = large - 2; secondlarge <= large; secondlarge = secondlarge + 0.25f) {
            for (double i = -Math.PI / (3 * large); i <= Math.PI / 2; i = i + Math.PI / (7 * large)) {
                for (double j = -Math.PI; j <= Math.PI; j = j + Math.PI / (6 * large)) {
                    double x = secondlarge * Math.cos(i) * Math.cos(j);
                    double z = secondlarge * Math.cos(i) * Math.sin(j);
                    double y = secondlarge * 2.4 * Math.sin(i);
                    mutable.set(pos, (int) x, (int) (y + height - large + 3), (int) z);
                    if (!world.getBlockState(mutable).isOf(blockState.getBlock()))
                        this.setBlockState(world, mutable, blockState);
                }
            }
        }*/
        /*for (float secondlarge = 0; secondlarge < large - 0.75f; secondlarge = secondlarge + 0.25f) {
            for (double i = 0; i <= Math.PI / 2; i = i + Math.PI / (4 * large)) {
                for (double j = -Math.PI; j <= Math.PI; j = j + Math.PI / (4 * large)) {
                    double x = secondlarge * Math.cos(i) * Math.cos(j);
                    double z = secondlarge * Math.cos(i) * Math.sin(j);
                    double y = secondlarge * 2.4 * Math.sin(i);
                    mutable.set(pos, (int) x, (int) (y + height - large - 1), (int) z);
                    if (world.getBlockState(mutable).isOf(blockState.getBlock()))
                        this.setBlockState(world, mutable, blockState2);
                }
            }
        }*/
    }


}
