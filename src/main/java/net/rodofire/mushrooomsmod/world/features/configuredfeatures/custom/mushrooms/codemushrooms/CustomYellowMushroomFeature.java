package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.rodofire.easierworldcreator.util.FastMaths;
import net.rodofire.easierworldcreator.worldgenutil.GenSpheres;

import java.util.ArrayList;

public class CustomYellowMushroomFeature extends CustomYellowMushroom {
    public CustomYellowMushroomFeature(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected Integer[] generateHugeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config, int randomx, int randomz, double phi, double theta) {
        BlockState blockState = config.stemProvider.get(random, pos);


        int randomn1 = Random.create().nextBetween(1, (int) Math.abs(phi * 3));
        int randomn2 = Random.create().nextBetween(1, (int) Math.abs(phi * 3));
        int randomn3 = Random.create().nextBetween(1, (int) Math.abs(phi * 3));
        int randomn4 = Random.create().nextBetween(1, (int) Math.abs(phi * 3));
        int randomn5 = Random.create().nextBetween(1, (int) Math.abs(phi * 3));
        int randomn6 = Random.create().nextBetween(1, (int) Math.abs(phi * 3));
        int randomn7 = Random.create().nextBetween(1, (int) Math.abs(phi * 3));
        int randomn8 = Random.create().nextBetween(1, (int) Math.abs(phi * 3));

        mutable.set(pos, 0, 0, 0);
        this.setBlockState(world, mutable, blockState);
        mutable.set(pos, -1, 0, 0);
        this.setBlockState(world, mutable, blockState);
        mutable.set(pos, 1, 0, 0);
        this.setBlockState(world, mutable, blockState);
        mutable.set(pos, 0, 0, -1);
        this.setBlockState(world, mutable, blockState);
        mutable.set(pos, 0, 0, 1);
        this.setBlockState(world, mutable, blockState);


        for (int i = 0; i <= height; i++) {
            double x = i * FastMaths.getFastCos((float) theta) * FastMaths.getFastCos((float) phi);
            double z = i * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi);
            mutable.set(pos, (int) x, i, (int) z);
            this.setBlockState(world, mutable, blockState);

            //cos
            x = i * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi) + FastMaths.getFastCos((float) phi);
            mutable.set(pos, (int) x, i + randomn1, (int) z);
            this.setBlockState(world, mutable, blockState);


            x = i * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi) - FastMaths.getFastCos((float) phi);
            mutable.set(pos, (int) x, i + randomn2, (int) z);
            this.setBlockState(world, mutable, blockState);


            x = i * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi);
            z = i * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi) - FastMaths.getFastCos((float) phi);
            mutable.set(pos, (int) x, i + randomn3, (int) z);
            this.setBlockState(world, mutable, blockState);


            z = i * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi) + FastMaths.getFastCos((float) phi);
            mutable.set(pos, (int) x, i + randomn4, (int) z);
            this.setBlockState(world, mutable, blockState);

            //sin

            z = i * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi);
            x = i * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi) + FastMaths.getFastSin((float) phi);
            mutable.set(pos, (int) x, i + randomn5, (int) z);
            this.setBlockState(world, mutable, blockState);


            x = i * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi) - FastMaths.getFastSin((float) phi);
            mutable.set(pos, (int) x, i + randomn6, (int) z);
            this.setBlockState(world, mutable, blockState);


            x = i * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi);
            z = i * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi) - FastMaths.getFastSin((float) phi);
            mutable.set(pos, (int) x, i + randomn7, (int) z);
            this.setBlockState(world, mutable, blockState);

            z = i * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi) + FastMaths.getFastSin((float) phi);
            mutable.set(pos, (int) x, i + randomn8, (int) z);
            this.setBlockState(world, mutable, blockState);


        }
        double x = height * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi);
        double z = height * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi);


        Integer[] coordinates = new Integer[2];
        coordinates[0] = (int) x;
        coordinates[1] = (int) z;

        return coordinates;
    }

    @Override
    protected Integer[] generateTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config, int randomx, int randomz, double phi, double theta) {
        BlockState blockState = config.stemProvider.get(random, pos);


        for (int i = 0; i <= height; i++) {
            double x = i * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi);
            double z = i * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi);
            mutable.set(pos, (int) x, i, (int) z);
            this.setBlockState(world, mutable, blockState);
        }

        double x = height * FastMaths.getFastCos((float) phi) * FastMaths.getFastCos((float) phi);
        double z = height * FastMaths.getFastSin((float) phi) * FastMaths.getFastCos((float) phi);


        Integer[] coordinates = new Integer[2];
        coordinates[0] = (int) x;
        coordinates[1] = (int) z;
        return coordinates;
    }


    //Cap
    @Override
    protected boolean generateCap(StructureWorldAccess world, Random random, BlockPos pos, int height, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, int large, Integer[] coordinates) {
        BlockState blockState = config.capProvider.get(random, pos);
        BlockState blockState2 = Blocks.AIR.getDefaultState();
        int randomx = coordinates[0];
        int randomz = coordinates[1];
        BlockState blockState1 = config.stemProvider.get(random, pos);
        GenSpheres.generateFullEllipsoid(world, (int) (1.5 * large), large, (int) (1.5 * large), pos.add(randomx, height - large + 4, randomz), blockState);
        GenSpheres.generateFullEllipsoid(world, (int) (1.5 * (large - 1)), large, (int) (1.5 * (large - 1)), pos.add(randomx, height - large, randomz), blockState2);
        /*for (float secondlarge = 0; secondlarge <= large; secondlarge = secondlarge + 0.25f) {
            for (double i = -Math.PI / (3 * large); i <= Math.PI / 2; i = i + Math.PI / (6 * large)) {
                for (double j = -Math.PI; j <= Math.PI; j = j + Math.PI / (6 * large)) {
                    double x = secondlarge * 1.5 * Math.cos(i) * Math.cos(j);
                    double z = secondlarge * 1.5 * Math.cos(i) * Math.sin(j);
                    double y = secondlarge * Math.sin(i);
                    mutable.set(pos, (int) x + randomx, (int) (y + height - large + 4), (int) z + randomz);
                    if (!world.getBlockState(mutable).isOf(blockState1.getBlock()))
                        this.setBlockState(world, mutable, blockState);
                }
            }
        }
        for (float secondlarge = 0; secondlarge <= large; secondlarge = secondlarge + 0.25f) {
            for (double i = 0; i <= Math.PI / 2; i = i + Math.PI / (4 * large)) {
                for (double j = -Math.PI; j <= Math.PI; j = j + Math.PI / (4 * large)) {
                    double x = secondlarge * 1.4 * Math.cos(i) * Math.cos(j);
                    double z = secondlarge * 1.4 * Math.cos(i) * Math.sin(j);
                    double y = secondlarge * Math.sin(i);
                    mutable.set(pos, (int) x + randomx, (int) (y + height - large), (int) z + randomz);
                    if (world.getBlockState(mutable).isOf(blockState.getBlock()))
                        this.setBlockState(world, mutable, blockState2);
                }
            }
        }*/
        return true;
    }

    @Override
    protected boolean generateFlatterCap(StructureWorldAccess world, Random random, BlockPos pos, int height, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, int large, Integer[] coordinates) {
        BlockState blockState = config.capProvider.get(random, pos);
        BlockState blockState1 = config.stemProvider.get(random, pos);
        BlockState blockState2 = Blocks.AIR.getDefaultState();
        int randomx = coordinates[0];
        int randomz = coordinates[1];
        GenSpheres.generateFullEllipsoid(world, 2 * large, large, 2 * large, pos.add(randomx, height - large + 4, randomz), blockState);
        GenSpheres.generateFullEllipsoid(world, (int) (2 * (large - 0.75f)), large, (int) (2 * (large - 0.75f)), pos.add(randomx, height - large, randomz), blockState2);
        /*for (float secondlarge = 0; secondlarge <= large; secondlarge = secondlarge + 0.25f) {
            for (double i = -Math.PI / (3 * large); i <= Math.PI / 2; i = i + Math.PI / (8 * large)) {
                for (double j = -Math.PI; j <= Math.PI; j = j + Math.PI / (8 * large)) {
                    double x = secondlarge * 2 * Math.cos(i) * Math.cos(j);
                    double z = secondlarge * 2 * Math.cos(i) * Math.sin(j);
                    double y = secondlarge * Math.sin(i);
                    mutable.set(pos, (int) x + randomx, (int) (y + height - large + 4), (int) z + randomz);
                    if (!world.getBlockState(mutable).isOf(blockState1.getBlock()))
                        this.setBlockState(world, mutable, blockState);
                }
            }
        }
        for (float secondlarge = 0; secondlarge < large - 0.5f; secondlarge = secondlarge + 0.25f) {
            for (double i = 0; i <= Math.PI / 2; i = i + Math.PI / (5 * large)) {
                for (double j = -Math.PI; j <= Math.PI; j = j + Math.PI / (5 * large)) {
                    double x = secondlarge * 2 * Math.cos(i) * Math.cos(j);
                    double z = secondlarge * 2 * Math.cos(i) * Math.sin(j);
                    double y = secondlarge * Math.sin(i);
                    mutable.set(pos, (int) x + randomx, (int) (y + height - large), (int) z + randomz);
                    if (world.getBlockState(mutable).isOf(blockState.getBlock()))
                        this.setBlockState(world, mutable, blockState2);
                }
            }
        }*/
        return true;
    }

    @Override
    protected ArrayList<Double> direction(StructureWorldAccess world, Random random, BlockPos pos, int height, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config) {
        double theta = 0;
        double phi = Math.PI / 2;
        int randomx = Random.create().nextBetween(-7, 7);
        int randomz = Random.create().nextBetween(-7, 7);


        if (randomx < 0) {
            randomx = randomx - 2;
        } else if (randomx > 0) {
            randomx = randomx + 2;
        }

        if (randomz < 0) {
            randomz = randomz - 2;
        } else if (randomz > 0) {
            randomz = randomz + 2;
        }

        double lenght = FastMaths.getLength(randomx, randomz);

        if (randomx != 0) {
            theta = Math.atan((double) randomz / randomx);
        } else if (randomz < 0) {
            theta = 3 * Math.PI / 2;
        } else {
            theta = Math.PI / 2;
        }
        if (randomz != 0 || randomx != 0) {
            phi = Math.atan(height / lenght);
        }

        if (randomz < 0 && randomx < 0) {
            theta = theta + Math.PI;
        }

        ArrayList<Double> coordinates = new ArrayList<>();

        coordinates.add((double) randomx);
        coordinates.add((double) randomz);
        coordinates.add(phi);
        coordinates.add(phi);

        return coordinates;
    }


}
