package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.DividedBlockListManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.placer.ShapePlacer;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.ewc.util.LongPosHelper;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrangeMushroomFeatureWG extends OrangeMushroomWG {
    public OrangeMushroomFeatureWG(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    protected DividedBlockListManager getHugeTrunk(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int height) {
        LongArrayList posList = new LongArrayList();
        long encodedPos = LongPosHelper.encodeBlockPos(pos);
        for (int i = 0; i < height; i++) {
            posList.add(LongPosHelper.up(encodedPos, i));
        }

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0 && distance != 4) {
                    int partialHeight = (int) ((float) random.nextIntBetweenInclusive(3, 8) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(LongPosHelper.add(encodedPos, i, k, j));
                    }
                }
            }
        }
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0 && distance != 4) {
                    int partialHeight = (int) ((float) random.nextIntBetweenInclusive(3, 8) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(LongPosHelper.encodeBlockPos(end.offset(i, -k, j)));
                    }
                }
            }
        }
        DividedBlockListManager dividedManager = new DividedBlockListManager();
        dividedManager.put(Blocks.MUSHROOM_STEM.defaultBlockState(), posList);
        return dividedManager;
    }

    @Override
    protected DividedBlockListManager getTrunk(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int height) {
        LongArrayList posList = new LongArrayList();
        long encodedPos = LongPosHelper.encodeBlockPos(pos);
        for (int i = 0; i < height; i++) {
            posList.add(LongPosHelper.up(encodedPos, i));
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0) {
                    int partialHeight = (int) ((float) random.nextIntBetweenInclusive(2, 6) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(LongPosHelper.add(encodedPos, i, k, j));
                    }
                }
            }
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0) {
                    int partialHeight = (int) ((float) random.nextIntBetweenInclusive(2, 6) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(LongPosHelper.encodeBlockPos(end.offset(i, -k, j)));
                    }
                }
            }
        }
        DividedBlockListManager dividedManager = new DividedBlockListManager();
        dividedManager.put(Blocks.MUSHROOM_STEM.defaultBlockState(), posList);
        return dividedManager;
    }

    @Override
    protected SphereGen[] getCap(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int radiusY, DividedBlockListManager trunk) {
        SphereGen sphere = new SphereGen(end.below(radiusY / 2), radius);
        sphere.setRadiusY(radiusY);
        sphere.setHalfSphere(SphereGen.SphereType.HALF);
        sphere.setHalfSphereDirection(Direction.UP);
        SphereGen voidSphere = new SphereGen(end.below(radiusY), (int) (radius * 1.3f));
        voidSphere.setRadiusY(radiusY);
        return new SphereGen[]{sphere, voidSphere};
    }

    @Override
    protected void place(WorldGenLevel world, BlockPos pos, BlockPos pos2, DividedBlockListManager coordinates, SphereGen sphere, SphereGen secondSphere) {
        Map<ChunkPos, LongOpenHashSet> posSphere = sphere.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> maskPos = secondSphere.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> newSet = new HashMap<>();

        posSphere.forEach((chunkPos, longSet) -> longSet.removeAll(maskPos.get(chunkPos)));

        Long2FloatOpenHashMap noiseMap = new Long2FloatOpenHashMap();
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);
        for (Map.Entry<ChunkPos, LongOpenHashSet> entry : posSphere.entrySet()) {
            LongOpenHashSet newPos = new LongOpenHashSet();
            for (long pos1 : entry.getValue()) {
                long noise2d = (long) LongPosHelper.decodeX(pos1) << 32 + LongPosHelper.decodeZ(pos1);
                noiseMap.computeIfAbsent(noise2d, (value) -> noise.GetNoise(value >> 32, value & 0xFFFF));
                newPos.add(LongPosHelper.up(pos1, (int) (3 * noiseMap.get(noise2d))));
            }
            newSet.put(entry.getKey(), newPos);
        }
        LayerManager layerManager = new LayerManager(
                LayerManager.Type.SURFACE,
                new BlockLayerManager(
                        new BlockLayer(
                                LayerPlacer.ofRandom(random),
                                List.of(ModBlocks.ORANGE_MUSHROOM_BLOCK.get().defaultBlockState(),
                                        ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState(),
                                        ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK.get().defaultBlockState()),
                                List.of((short) 4, (short) 2, (short) 1))
                )
        );


        coordinates.put(layerManager.getDivided(newSet));

        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.WORLD_GEN, pos, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "orange_mushroom"));
        placer.place(coordinates);
    }
}
