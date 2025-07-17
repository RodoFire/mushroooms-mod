package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockListManager;
import fr.rodofire.ewc.blockdata.blocklist.OrderedBlockListManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.blockdata.sorter.BlockSorter;
import fr.rodofire.ewc.shape.block.gen.LineGen;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.animator.StructurePlaceAnimator;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.util.LongPosHelper;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class YellowMushroomOTHFeature extends YellowMushroomOTH {

    public YellowMushroomOTHFeature(Codec<HugeMushroomFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    protected BlockListManager generateHugeTrunk(WorldGenLevel world, BlockPos pos, BlockPos end, int height, HugeMushroomFeatureConfiguration config, RandomSource random) {
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

            line = new LineGen(pos.north().above(random.nextIntBetweenInclusive(-1, 1)), end.north().above(random.nextIntBetweenInclusive(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );

            line = new LineGen(pos.south().above(random.nextIntBetweenInclusive(-1, 1)), end.south().above(random.nextIntBetweenInclusive(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );

            line = new LineGen(pos.east().above(random.nextIntBetweenInclusive(-1, 1)), end.above(random.nextIntBetweenInclusive(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );

            line = new LineGen(pos.west().above(random.nextIntBetweenInclusive(-1, 1)), end.above(random.nextIntBetweenInclusive(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );
        }

        LongArrayList finalPos = new LongArrayList(posList);
        blockList.put(Blocks.MUSHROOM_STEM.defaultBlockState(), finalPos);

        return blockList;
    }

    @Override
    protected BlockListManager generateTrunk(WorldGenLevel world, BlockPos pos, BlockPos end, int height, HugeMushroomFeatureConfiguration config) {
        LineGen line = new LineGen(pos, end);
        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(trunkLayer));
        return layerManager.get(line.getShapeCoordinates());
    }

    @Override
    protected SphereGen[] generateCap(WorldGenLevel world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfiguration var6, int height, int large, BlockListManager coordinates, RandomSource random) {
        SphereGen sphere = new SphereGen(pos2.below(large / 2), (int) (1.5 * large));
        sphere.setRadiusY(large);


        int rot1 = random.nextIntBetweenInclusive(0, 30);
        int rot2 = random.nextIntBetweenInclusive(0, 360);

        Rotator rotator1 = new Rotator(pos2.below(large / 2), 0, rot1, rot2);
        Rotator rotator2 = new Rotator(pos2.below(large), 0, rot1, rot2);
        sphere.setRotator(rotator1);

        SphereGen secondSphere = new SphereGen(pos2.below(large), (int) ((1.5 + (float) random.nextIntBetweenInclusive(0, 5) / 10) * (large - 1)));
        secondSphere.setRadiusY(large);

        secondSphere.setRotator(rotator2);

        return new SphereGen[]{sphere, secondSphere};
    }

    @Override
    protected SphereGen[] generateFlatterCap(WorldGenLevel world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfiguration var6, int height, int large, BlockListManager coordinates, RandomSource random) {
        SphereGen sphere = new SphereGen(pos2.below(large / 2), 2 * large);
        sphere.setRadiusY(large);

        int rot1 = random.nextIntBetweenInclusive(0, 30);
        int rot2 = random.nextIntBetweenInclusive(0, 360);

        Rotator rotator1 = new Rotator(pos2.below(large / 2), 0, rot1, rot2);
        Rotator rotator2 = new Rotator(pos2.below(large), 0, rot1, rot2);

        sphere.setRotator(rotator1);

        SphereGen secondSphere = new SphereGen(pos2.below(large), (int) ((2 + (float) random.nextIntBetweenInclusive(0, 4) / 10) * (large - 0.75f)));

        secondSphere.setRadiusY(large);

        secondSphere.setRotator(rotator2);

        return new SphereGen[]{sphere, secondSphere};
    }


    protected boolean place(WorldGenLevel world, BlockPos pos, BlockPos pos2, BlockListManager manager, SphereGen sphere, SphereGen secondSphere) {
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