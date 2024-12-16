package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.DefaultBlockList;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.maths.FastMaths;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.placer.blocks.util.BlockPlaceUtil;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapePlaceType;
import net.rodofire.easierworldcreator.shape.block.simplegen.GenLines;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.CustomBlueMushroom;

import java.util.*;

public class CustomBlueMushroomFeatureWG extends CustomBlueMushroom {
    public CustomBlueMushroomFeatureWG(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxLarge, BlockState state, int large, int height, DefaultBlockList blockLists, int yOffset) {
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.06f);
        SphereGen sphere = new SphereGen(world, pos.up(height - 2), AbstractBlockShapeBase.PlaceMoment.OTHER, large);
        sphere.setRadiusY(height);
        sphere.setZRotation(MathUtil.getRandomOpposite() * (random.nextBetween(0, 20) + random.nextBetween(0, 10)));
        sphere.setSecondYRotation(random.nextBetween(0, 180));

        BlockLayer layer = new BlockLayer(List.of(ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.getDefaultState()), List.of((short) 3, (short) 1));
        sphere.setBlockLayer(new BlockLayerComparator(layer));
        sphere.setLayerPlace(AbstractBlockShapePlaceType.LayerPlace.RANDOM);
        List<Set<BlockPos>> posList = sphere.getBlockPos();

        Map<Pair<Integer, Integer>, Float> offset = new HashMap<>();
        List<Set<BlockPos>> newPosList = new ArrayList<>();
        int index = 0;
        for (Set<BlockPos> set : posList) {
            newPosList.add(new HashSet<>());
            for (BlockPos pos1 : set) {
                Pair<Integer, Integer> plan = new Pair<>(pos1.getX(), pos1.getZ());
                offset.computeIfAbsent(plan, k -> noise.GetNoise(pos1.getX(), pos1.getZ()));
                float a = offset.get(plan);
                newPosList.get(index).add(pos1.add(new BlockPos(0, (int) (3 * a), 0)));
            }
            index++;
        }

        sphere.place(newPosList);
    }

    @Override
    public DefaultBlockList generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.5f);

        float c3 = (float) 360 / height;
        float rapport = (float) minlarge / maxlarge;
        for (float j = 1; j <= maxlarge; ++j) {
            float c1 = (j + (j * rapport)) / 2;
            float c2 = (j - (j * rapport)) / 2;

            for (int u = 0; u <= height; u++) {

                float a = c1 + c2 * FastMaths.getFastCos(u * c3);

                for (float v = 0; v <= 360; v += 45 / j) {

                    int x = (int) (a * FastMaths.getFastCos(v));
                    int z = (int) (a * FastMaths.getFastSin(v));
                    mutable.set(pos, x, u, z);
                    float t = 4 * noise.GetNoise(mutable.getX(), mutable.getZ());
                    if (u == 0) {
                        GenLines.generateAxisLine(world, mutable, (int) (Math.abs(t * 4)), Direction.DOWN, trunk);
                    }
                    if (t < 1) {
                        BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable.down());
                    } else {
                        BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable);
                        if (t > 1) {
                            BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable.up());
                        }
                    }

                }
            }
        }
        return null;
    }


}
