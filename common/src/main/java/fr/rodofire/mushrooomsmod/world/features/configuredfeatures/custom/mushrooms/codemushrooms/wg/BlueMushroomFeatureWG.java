package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockList;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.maths.FastMaths;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.placer.ShapePlacer;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.shape.block.simplegen.GenLines;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.ewc.util.LongPosHelper;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.CustomBlueMushroom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlueMushroomFeatureWG extends CustomBlueMushroom {
    public BlueMushroomFeatureWG(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public void generateLargeCap(WorldGenLevel world, RandomSource random, BlockPos pos, int maxLarge, BlockState state, int large, int height, BlockList blockLists, int yOffset) {
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.06f);
        SphereGen sphere = new SphereGen(pos.above(height - 2), large);
        sphere.setRadiusY(height);

        Rotator rotator = new Rotator(pos, 0, MathUtil.getRandomOpposite(random) * (random.nextIntBetweenInclusive(0, 20) + random.nextIntBetweenInclusive(0, 10)), random.nextIntBetweenInclusive(0, 180));
        sphere.setRotator(rotator);

        BlockLayer layer = new BlockLayer(LayerPlacer.ofRandom(random), List.of(ModBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState(), ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState()), List.of((short) 3, (short) 1));
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

        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.WORLD_GEN, pos, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "blue_mushroom"));
        placer.place(layerManager.getDivided(newPosList));
    }

    @Override
    public BlockList generateLargeTrunk(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
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
                    mutable.setWithOffset(pos, x, u, z);
                    float t = 4 * noise.GetNoise(mutable.getX(), mutable.getZ());
                    if (u == 0) {
                        GenLines.generateAxisLine(world, mutable, (int) (Math.abs(t * 4)), Direction.DOWN, trunk);
                    }
                    if (t < 1) {
                        BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable.below());
                    } else {
                        BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable);
                        if (t > 1) {
                            BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable.above());
                        }
                    }

                }
            }
        }
        return null;
    }


}
