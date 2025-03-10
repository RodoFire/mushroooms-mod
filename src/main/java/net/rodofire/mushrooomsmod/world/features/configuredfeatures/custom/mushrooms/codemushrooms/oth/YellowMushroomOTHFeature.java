package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.Blocks;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockListManager;
import net.rodofire.easierworldcreator.blockdata.blocklist.OrderedBlockListManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.blockdata.sorter.BlockSorter;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.animator.StructurePlaceAnimator;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.easierworldcreator.util.LongPosHelper;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.*;

public class YellowMushroomOTHFeature extends YellowMushroomOTH {

    public YellowMushroomOTHFeature(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected BlockListManager generateHugeTrunk(StructureWorldAccess world, BlockPos pos, BlockPos end, int height, HugeMushroomFeatureConfig config, Random random) {
        BlockListManager blockList = new BlockListManager();

        //on créé plusieurs lignes qui vont servir à appaissir le tronc.
        LongOpenHashSet posList = new LongOpenHashSet();
        LineGen line = new LineGen(pos, end);
        for (int i = 0; i < 4; i++) {
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );

            line = new LineGen(pos.north().up(random.nextBetween(-1, 1)), end.north().up(random.nextBetween(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );

            line = new LineGen(pos.south().up(random.nextBetween(-1, 1)), end.south().up(random.nextBetween(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );

            line = new LineGen(pos.east().up(random.nextBetween(-1, 1)), end.up(random.nextBetween(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );

            line = new LineGen(pos.west().up(random.nextBetween(-1, 1)), end.up(random.nextBetween(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );
        }

        LongArrayList finalPos = new LongArrayList(posList);
        blockList.put(Blocks.MUSHROOM_STEM.getDefaultState(), finalPos);

        return blockList;
    }

    @Override
    protected BlockListManager generateTrunk(StructureWorldAccess world, BlockPos pos, BlockPos end, int height, HugeMushroomFeatureConfig config) {
        LineGen line = new LineGen(pos, end);
        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(trunkLayer));
        return layerManager.get(line.getShapeCoordinates());
    }

    @Override
    protected SphereGen[] generateCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, BlockListManager coordinates, Random random) {
        SphereGen sphere = new SphereGen(pos2.down(large / 2), (int) (1.5 * large));
        sphere.setRadiusY(large);


        int rot1 = random.nextBetween(0, 30);
        int rot2 = random.nextBetween(0, 360);

        Rotator rotator1 = new Rotator(pos2.down(large / 2), 0, rot1, rot2);
        Rotator rotator2 = new Rotator(pos2.down(large), 0, rot1, rot2);
        sphere.setRotator(rotator1);

        SphereGen secondSphere = new SphereGen(pos2.down(large), (int) ((1.5 + (float) random.nextBetween(0, 5) / 10) * (large - 1)));
        secondSphere.setRadiusY(large);

        secondSphere.setRotator(rotator2);

        return new SphereGen[]{sphere, secondSphere};
    }

    @Override
    protected SphereGen[] generateFlatterCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, BlockListManager coordinates, Random random) {
        SphereGen sphere = new SphereGen(pos2.down(large / 2), 2 * large);
        sphere.setRadiusY(large);

        int rot1 = random.nextBetween(0, 30);
        int rot2 = random.nextBetween(0, 360);

        Rotator rotator1 = new Rotator(pos2.down(large / 2), 0, rot1, rot2);
        Rotator rotator2 = new Rotator(pos2.down(large), 0, rot1, rot2);

        sphere.setRotator(rotator1);

        SphereGen secondSphere = new SphereGen(pos2.down(large), (int) ((2 + (float) random.nextBetween(0, 4) / 10) * (large - 0.75f)));

        secondSphere.setRadiusY(large);

        secondSphere.setRotator(rotator2);

        return new SphereGen[]{sphere, secondSphere};
    }


    protected boolean place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, BlockListManager manager, SphereGen sphere, SphereGen secondSphere) {
        Map<ChunkPos, LongOpenHashSet> posSphere = sphere.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> maskPosSet = secondSphere.getShapeCoordinates();

        posSphere.forEach((chunkPos, coordinates) -> {
            LongOpenHashSet mask = maskPosSet.get(chunkPos);
            System.out.println(LongPosHelper.decodeBlockPos(coordinates.iterator().nextLong()));
            if (mask == null) return;
            coordinates.removeAll(mask);
        });
        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(capLayer));


        BlockListManager manager2 = layerManager.get(posSphere);
        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT_INVERTED);
        sorter.setCenterPoint(pos);

        OrderedBlockListManager comp = manager.getOrdered(sorter);
        sorter.setCenterPoint(pos2);
        comp.put(manager2.getOrdered(sorter));

        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, sorter, StructurePlaceAnimator.AnimatorTime.LINEAR_TICKS);
        animator.setBounds(new Pair<>(1, 60));
        animator.place(new BlockSorter(BlockSorter.BlockSorterType.INVERSE).sortOrderedBlockList(comp));

        return true;
    }


}