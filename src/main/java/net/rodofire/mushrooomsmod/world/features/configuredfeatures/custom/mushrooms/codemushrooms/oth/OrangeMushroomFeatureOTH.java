package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockListUtil;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.DefaultBlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.comparator.DefaultBlockListComparator;
import net.rodofire.easierworldcreator.blockdata.blocklist.ordered.comparator.DefaultOrderedBlockListComparator;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.blockdata.sorter.BlockSorter;
import net.rodofire.easierworldcreator.placer.blocks.animator.StructurePlaceAnimator;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.easierworldcreator.util.WorldGenUtil;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.*;

public class OrangeMushroomFeatureOTH extends OrangeMushroomOTH {
    public OrangeMushroomFeatureOTH(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected DefaultBlockList getHugeTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height) {
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
        return new DefaultBlockList(posList, Blocks.MUSHROOM_STEM.getDefaultState());
    }

    @Override
    protected DefaultBlockList getTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height) {
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
        return new DefaultBlockList(posList, Blocks.MUSHROOM_STEM.getDefaultState());
    }

    @Override
    protected SphereGen[] getCap(StructureWorldAccess world, Random random, BlockPos pos, int radius, int radiusY, DefaultBlockList trunk) {
        SphereGen sphere = new SphereGen(world, end.down(radiusY / 2), AbstractBlockShapeBase.PlaceMoment.ANIMATED_OTHER, radius);
        sphere.setRadiusY(radiusY);
        sphere.setHalfSphere(SphereGen.SphereType.HALF);
        sphere.setHalfSphereDirection(Direction.UP);
        sphere.setBlockLayer(new BlockLayerComparator(new BlockLayer(List.of(ModBlocks.ORANGE_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK.getDefaultState()), List.of((short) 4, (short) 2, (short) 1))));
        SphereGen voidSphere = new SphereGen(world, end.down(radiusY), AbstractBlockShapeBase.PlaceMoment.ANIMATED_OTHER, (int) (radius * 1.3f));
        voidSphere.setRadiusY(radiusY);
        return new SphereGen[]{sphere, voidSphere};
    }

    @Override
    protected void place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, DefaultBlockListComparator coordinates, SphereGen sphere, SphereGen secondSphere) {
        Set<BlockPos> posSet = new HashSet<>();
        List<Set<BlockPos>> posSphere = sphere.getBlockPos();
        for (Set<BlockPos> blockPosSet : posSphere) {
            posSet.addAll(blockPosSet);
        }
        posSphere = secondSphere.getBlockPos();
        for (Set<BlockPos> blockPosSet : posSphere) {
            posSet.removeAll(blockPosSet);
        }

        Map<Pair<Integer, Integer>, Float> noiseMap = new HashMap<>();
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);
        Map<ChunkPos, Set<BlockPos>> chunkMap = new HashMap<>();
        for (BlockPos pos1 : posSet) {
            Pair<Integer, Integer> pair = new Pair<>(pos1.getX(), pos1.getZ());
            noiseMap.computeIfAbsent(pair, fun -> noise.GetNoise(pair.getLeft(), pair.getRight()));

            WorldGenUtil.modifyChunkMap(pos1.up((int) (3 * noiseMap.get(pair))), chunkMap);
        }
        System.out.println("hudeif");

        List<Set<DefaultBlockList>> blockList = sphere.getBlockListWithVerification(new ArrayList<>(chunkMap.values()));
        DefaultBlockListComparator comparator = new DefaultBlockListComparator(BlockListUtil.unDivideBlockList(blockList));
        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT_INVERTED);
        sorter.setCenterPoint(pos);

        DefaultOrderedBlockListComparator comp = coordinates.getOrderedSorted(sorter);
        sorter.setCenterPoint(end);
        sorter.setType(BlockSorter.BlockSorterType.FROM_POINT_INVERTED);
        DefaultOrderedBlockListComparator var = comparator.getOrderedSorted(sorter);

        sorter.setAxisDirection(new Vec3d(0, 1, 0));
        sorter.setType(BlockSorter.BlockSorterType.FROM_PLANE_INVERTED);
        comp.put(sorter.sortBlockList(var));

        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, sorter, StructurePlaceAnimator.AnimatorTime.LINEAR_TICKS);
        animator.setBounds(new Pair<>(1, 80));

        animator.place(new BlockSorter(BlockSorter.BlockSorterType.INVERSE).sortBlockList(comp));
    }
}
