package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockList;
import fr.rodofire.ewc.blockdata.blocklist.BlockListManager;
import fr.rodofire.ewc.blockdata.blocklist.OrderedBlockListManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.blockdata.sorter.BlockSorter;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.placer.animator.StructurePlaceAnimator;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.ewc.util.LongPosHelper;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.Vec3;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrangeMushroomFeatureOTH extends OrangeMushroomOTH {
    public OrangeMushroomFeatureOTH(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    protected BlockList getHugeTrunk(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int height) {
        List<BlockPos> posList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            posList.add(pos.above(i));
        }

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0 && distance != 4) {
                    int partialHeight = (int) ((float) random.nextIntBetweenInclusive(3, 8) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(pos.offset(i, k, j));
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
                        posList.add(end.offset(i, -k, j));
                    }
                }
            }
        }
        return new BlockList(Blocks.MUSHROOM_STEM.defaultBlockState(), posList);
    }

    @Override
    protected BlockList getTrunk(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int height) {
        List<BlockPos> posList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            posList.add(pos.above(i));
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int distance = Math.abs(i) + Math.abs(j);
                if (distance != 0) {
                    int partialHeight = (int) ((float) random.nextIntBetweenInclusive(2, 6) / distance);
                    for (int k = 0; k < partialHeight; k++) {
                        posList.add(pos.offset(i, k, j));
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
                        posList.add(end.offset(i, -k, j));
                    }
                }
            }
        }
        return new BlockList(Blocks.MUSHROOM_STEM.defaultBlockState(), posList);
    }

    @Override
    protected SphereGen[] getCap(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int radiusY, BlockList trunk) {
        SphereGen sphere = new SphereGen(end.below(radiusY / 2), radius);
        sphere.setRadiusY(radiusY);
        sphere.setHalfSphere(SphereGen.SphereType.HALF);
        sphere.setHalfSphereDirection(Direction.UP);
        SphereGen voidSphere = new SphereGen(end.below(radiusY), (int) (radius * 1.3f));
        voidSphere.setRadiusY(radiusY);
        return new SphereGen[]{sphere, voidSphere};
    }

    @Override
    protected void place(WorldGenLevel world, BlockPos pos, BlockPos pos2, BlockListManager coordinates, SphereGen sphere, SphereGen secondSphere, RandomSource random) {
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
                                LayerPlacer.ofRandom(random),
                                List.of(ModBlocks.ORANGE_MUSHROOM_BLOCK.get().defaultBlockState(), ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState(), ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK.get().defaultBlockState()),
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

        sorter.setAxisDirection(new Vec3(0, 1, 0));
        sorter.setType(BlockSorter.BlockSorterType.FROM_PLANE_INVERTED);
        comp.put(sorter.sortOrderedBlockList(var));

        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, sorter, StructurePlaceAnimator.AnimatorTime.LINEAR_TICKS);
        animator.setBounds(new Pair<>(1, 80));

        animator.place(new BlockSorter(BlockSorter.BlockSorterType.INVERSE).sortOrderedBlockList(comp));
    }
}
