package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockList;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.maths.FastMaths;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.shape.block.placer.ShapePlacer;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.easierworldcreator.shape.block.simplegen.GenLines;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.easierworldcreator.util.LongPosHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.CustomBlueMushroom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomBlueMushroomFeatureWG extends CustomBlueMushroom {
    public CustomBlueMushroomFeatureWG(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxLarge, BlockState state, int large, int height, BlockList blockLists, int yOffset) {
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.06f);
        SphereGen sphere = new SphereGen(pos.up(height - 2), large);
        sphere.setRadiusY(height);

        Rotator rotator = new Rotator(pos, 0, MathUtil.getRandomOpposite(random) * (random.nextBetween(0, 20) + random.nextBetween(0, 10)), random.nextBetween(0, 180));
        sphere.setRotator(rotator);

        BlockLayer layer = new BlockLayer(new LayerPlacer(LayerPlacer.PlacingType.RANDOM), List.of(ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.getDefaultState()), List.of((short) 3, (short) 1));
        Map<ChunkPos, LongOpenHashSet> posList = sphere.getShapeCoordinates();

        Long2FloatOpenHashMap noiseMap = new Long2FloatOpenHashMap(posList.size());
        Map<ChunkPos, LongOpenHashSet> newPosList = new HashMap<>();
        for (Map.Entry<ChunkPos, LongOpenHashSet> set : posList.entrySet()) {
            LongOpenHashSet posSet = new LongOpenHashSet();
            for (long pos1 : set.getValue()) {
                long noise2d = (((long) LongPosHelper.decodeX(pos1) & 0xFFFF) << 32) | (LongPosHelper.decodeZ(pos1) & 0xFFFF);
                noiseMap.computeIfAbsent(noise2d, (value) -> noise.GetNoise(value >> 32, value & 0xFFFF));
                float a = noiseMap.get(noise2d);
                posSet.add(LongPosHelper.up(pos1, (int) (3 * a)));
            }
            if (!posSet.isEmpty())
                newPosList.put(set.getKey(), posSet);
        }

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(layer));

        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.WORLD_GEN, pos, Identifier.of(MushrooomsMod.MOD_ID, "blue_mushroom"));
        placer.place(layerManager.getDivided(newPosList));
    }

    @Override
    public BlockList generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
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
