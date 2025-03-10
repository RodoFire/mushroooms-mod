package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.Blocks;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockListManager;
import net.rodofire.easierworldcreator.blockdata.blocklist.OrderedBlockListManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.blockdata.sorter.BlockSorter;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.shape.block.placer.animator.StructurePlaceAnimator;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.easierworldcreator.util.LongPosHelper;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrangeMushroomFeatureOTH extends OrangeMushroomOTH {
    public OrangeMushroomFeatureOTH(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected BlockList getHugeTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height) {
        List<BlockPos> posList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            posList.add(pos.up(i));
        }

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0 && distance != 4) {
                    int partialHeight = (int) ((float) random.nextBetween(3, 8) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(pos.add(i, k, j));
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
                        posList.add(end.add(i, -k, j));
                    }
                }
            }
        }
        return new BlockList(Blocks.MUSHROOM_STEM.getDefaultState(), posList);
    }

    @Override
    protected BlockList getTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height) {
        List<BlockPos> posList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            posList.add(pos.up(i));
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0) {
                    int partialHeight = (int) ((float) random.nextBetween(2, 6) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(pos.add(i, k, j));
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
                        posList.add(end.add(i, -k, j));
                    }
                }
            }
        }
        return new BlockList(Blocks.MUSHROOM_STEM.getDefaultState(), posList);
    }

    @Override
    protected SphereGen[] getCap(StructureWorldAccess world, Random random, BlockPos pos, int radius, int radiusY, BlockList trunk) {
        SphereGen sphere = new SphereGen(end.down(radiusY / 2), radius);
        sphere.setRadiusY(radiusY);
        sphere.setHalfSphere(SphereGen.SphereType.HALF);
        sphere.setHalfSphereDirection(Direction.UP);
        SphereGen voidSphere = new SphereGen(end.down(radiusY), (int) (radius * 1.3f));
        voidSphere.setRadiusY(radiusY);
        return new SphereGen[]{sphere, voidSphere};
    }

    @Override
    protected void place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, BlockListManager coordinates, SphereGen sphere, SphereGen secondSphere) {
        Map<ChunkPos, LongOpenHashSet> posSet = sphere.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> maskPosSet = secondSphere.getShapeCoordinates();

        /// on masque les pos à partir de la deuxième sphere
        for (ChunkPos chunkPos : posSet.keySet()) {
            posSet.get(chunkPos).removeAll(maskPosSet.get(chunkPos));
        }

        Map<ChunkPos, LongOpenHashSet> newSet = new HashMap<>();
        Long2FloatOpenHashMap noiseMap = new Long2FloatOpenHashMap();

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);
        for (Map.Entry<ChunkPos, LongOpenHashSet> entry : posSet.entrySet()) {
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


        BlockListManager manager = layerManager.get(newSet);
        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT_INVERTED);
        sorter.setCenterPoint(pos);

        OrderedBlockListManager comp = coordinates.getOrdered(sorter);
        sorter.setCenterPoint(end);
        sorter.setType(BlockSorter.BlockSorterType.FROM_POINT_INVERTED);
        OrderedBlockListManager var = manager.getOrdered(sorter);

        sorter.setAxisDirection(new Vec3d(0, 1, 0));
        sorter.setType(BlockSorter.BlockSorterType.FROM_PLANE_INVERTED);
        comp.put(sorter.sortOrderedBlockList(var));

        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, sorter, StructurePlaceAnimator.AnimatorTime.LINEAR_TICKS);
        animator.setBounds(new Pair<>(1, 80));

        animator.place(new BlockSorter(BlockSorter.BlockSorterType.INVERSE).sortOrderedBlockList(comp));
    }
}
