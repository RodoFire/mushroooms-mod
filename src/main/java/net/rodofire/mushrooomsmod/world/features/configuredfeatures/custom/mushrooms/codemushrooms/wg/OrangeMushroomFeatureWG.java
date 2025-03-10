package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockListManager;
import net.rodofire.easierworldcreator.blockdata.blocklist.DividedBlockListManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.shape.block.placer.ShapePlacer;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.easierworldcreator.util.LongPosHelper;
import net.rodofire.easierworldcreator.util.WorldGenUtil;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.*;

public class OrangeMushroomFeatureWG extends OrangeMushroomWG {
    public OrangeMushroomFeatureWG(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected DividedBlockListManager getHugeTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height) {
        LongArrayList posList = new LongArrayList();
        long encodedPos = LongPosHelper.encodeBlockPos(pos);
        for (int i = 0; i < height; i++) {
            posList.add(LongPosHelper.up(encodedPos, i));
        }

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0 && distance != 4) {
                    int partialHeight = (int) ((float) random.nextBetween(3, 8) / distance);
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
                    int partialHeight = (int) ((float) random.nextBetween(3, 8) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(LongPosHelper.encodeBlockPos(end.add(i, -k, j)));
                    }
                }
            }
        }
        DividedBlockListManager dividedManager = new DividedBlockListManager();
        dividedManager.put(Blocks.MUSHROOM_STEM.getDefaultState(), posList);
        return dividedManager;
    }

    @Override
    protected DividedBlockListManager getTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height) {
        LongArrayList posList = new LongArrayList();
        long encodedPos = LongPosHelper.encodeBlockPos(pos);
        for (int i = 0; i < height; i++) {
            posList.add(LongPosHelper.up(encodedPos, i));
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0) {
                    int partialHeight = (int) ((float) random.nextBetween(2, 6) / distance);
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
                    int partialHeight = (int) ((float) random.nextBetween(2, 6) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(LongPosHelper.encodeBlockPos(end.add(i, -k, j)));
                    }
                }
            }
        }
        DividedBlockListManager dividedManager = new DividedBlockListManager();
        dividedManager.put(Blocks.MUSHROOM_STEM.getDefaultState(), posList);
        return dividedManager;
    }

    @Override
    protected SphereGen[] getCap(StructureWorldAccess world, Random random, BlockPos pos, int radius, int radiusY, DividedBlockListManager trunk) {
        SphereGen sphere = new SphereGen(end.down(radiusY / 2), radius);
        sphere.setRadiusY(radiusY);
        sphere.setHalfSphere(SphereGen.SphereType.HALF);
        sphere.setHalfSphereDirection(Direction.UP);
       SphereGen voidSphere = new SphereGen(end.down(radiusY), (int) (radius * 1.3f));
        voidSphere.setRadiusY(radiusY);
        return new SphereGen[]{sphere, voidSphere};
    }

    @Override
    protected void place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, DividedBlockListManager coordinates, SphereGen sphere, SphereGen secondSphere) {
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
                                new LayerPlacer(LayerPlacer.PlacingType.RANDOM),
                                List.of(ModBlocks.ORANGE_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK.getDefaultState()),
                                List.of((short) 4, (short) 2, (short) 1))
                )
        );


        coordinates.put(layerManager.getDivided(newSet));

        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.WORLD_GEN, pos, Identifier.of(MushrooomsMod.MOD_ID, "orange_mushroom"));
        placer.place(coordinates);
    }
}
