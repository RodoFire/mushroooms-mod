package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockListUtil;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.DefaultBlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.comparator.DefaultBlockListComparator;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapePlaceType;
import net.rodofire.easierworldcreator.util.WorldGenUtil;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.*;

public class YellowMushroomWGFeature extends YellowMushroomWG {

    public YellowMushroomWGFeature(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected DefaultBlockListComparator generateHugeTrunk(StructureWorldAccess world, BlockPos pos, BlockPos end, int height, HugeMushroomFeatureConfig config) {
        DefaultBlockListComparator blockList = new DefaultBlockListComparator();

        //on créé plusieurs lignes qui vont servir à appaissir le tronc.
        Set<BlockPos> posList = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            LineGen line = new LineGen(world, pos, AbstractBlockShapeBase.PlaceMoment.OTHER, end);
            line.setBlockLayer(new BlockLayerComparator(new BlockLayer(Blocks.MUSHROOM_STEM.getDefaultState())));
            posList.addAll(BlockListUtil.unDivideBlockList(line.getBlockListWithVerification(line.getBlockPos())).get(0).getPosList());

            line = new LineGen(world, pos.north().up(Random.create().nextBetween(-1, 1)), AbstractBlockShapeBase.PlaceMoment.OTHER, end.north().up(Random.create().nextBetween(-1, 1)));
            line.setBlockLayer(new BlockLayerComparator(new BlockLayer(Blocks.MUSHROOM_STEM.getDefaultState())));
            posList.addAll(BlockListUtil.unDivideBlockList(line.getBlockListWithVerification(line.getBlockPos())).get(0).getPosList());

            line = new LineGen(world, pos.south().up(Random.create().nextBetween(-1, 1)), AbstractBlockShapeBase.PlaceMoment.OTHER, end.south().up(Random.create().nextBetween(-1, 1)));
            line.setBlockLayer(new BlockLayerComparator(new BlockLayer(Blocks.MUSHROOM_STEM.getDefaultState())));
            posList.addAll(BlockListUtil.unDivideBlockList(line.getBlockListWithVerification(line.getBlockPos())).get(0).getPosList());

            line = new LineGen(world, pos.east().up(Random.create().nextBetween(-1, 1)), AbstractBlockShapeBase.PlaceMoment.OTHER, end.up(Random.create().nextBetween(-1, 1)));
            line.setBlockLayer(new BlockLayerComparator(new BlockLayer(Blocks.MUSHROOM_STEM.getDefaultState())));
            posList.addAll(BlockListUtil.unDivideBlockList(line.getBlockListWithVerification(line.getBlockPos())).get(0).getPosList());

            line = new LineGen(world, pos.west().up(Random.create().nextBetween(-1, 1)), AbstractBlockShapeBase.PlaceMoment.OTHER, end.up(Random.create().nextBetween(-1, 1)));
            line.setBlockLayer(new BlockLayerComparator(new BlockLayer(Blocks.MUSHROOM_STEM.getDefaultState())));
            posList.addAll(BlockListUtil.unDivideBlockList(line.getBlockListWithVerification(line.getBlockPos())).get(0).getPosList());
        }


        blockList.put(new DefaultBlockList(posList.stream().toList(), Blocks.MUSHROOM_STEM.getDefaultState()));

        return blockList;
    }

    @Override
    protected DefaultBlockListComparator generateTrunk(StructureWorldAccess world, BlockPos pos, BlockPos end, int height, HugeMushroomFeatureConfig config) {
        LineGen line = new LineGen(world, pos, AbstractBlockShapeBase.PlaceMoment.OTHER, end);
        line.setBlockLayer(new BlockLayerComparator(new BlockLayer(Blocks.MUSHROOM_STEM.getDefaultState())));
        return new DefaultBlockListComparator(BlockListUtil.unDivideBlockList(line.getBlockListWithVerification(line.getBlockPos())));
    }

    @Override
    protected SphereGen[] generateCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DefaultBlockListComparator coordinates) {
        SphereGen sphere = new SphereGen(world, pos2.down(large / 2), AbstractBlockShapeBase.PlaceMoment.OTHER, (int) (1.5 * large));
        sphere.setRadiusY(large);
        BlockLayer layer = new BlockLayer(List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.getDefaultState()), List.of((short) 2, (short) 1));
        sphere.setBlockLayer(new BlockLayerComparator(layer));
        sphere.setLayerPlace(AbstractBlockShapePlaceType.LayerPlace.RANDOM);


        int rot1 = Random.create().nextBetween(0, 30);
        int rot2 = Random.create().nextBetween(0, 360);
        sphere.setZRotation(rot1);
        sphere.setSecondYRotation(rot2);

        SphereGen secondSphere = new SphereGen(world, pos2.down(large), AbstractBlockShapeBase.PlaceMoment.OTHER, (int) ((1.5 + (float) Random.create().nextBetween(0, 5) / 10) * (large - 1)));
        secondSphere.setRadiusY(large);


        secondSphere.setZRotation(rot1);
        secondSphere.setSecondYRotation(rot2);

        return new SphereGen[]{sphere, secondSphere};
    }

    @Override
    protected SphereGen[] generateFlatterCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DefaultBlockListComparator coordinates) {
        SphereGen sphere = new SphereGen(world, pos2.down(large / 2), AbstractBlockShapeBase.PlaceMoment.OTHER, 2 * large);
        sphere.setRadiusY(large);

        int rot1 = Random.create().nextBetween(0, 30);
        int rot2 = Random.create().nextBetween(0, 360);
        sphere.setZRotation(rot1);
        sphere.setSecondYRotation(rot2);

        BlockLayer layer = new BlockLayer(List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.getDefaultState()), List.of((short) 2, (short) 1));
        sphere.setBlockLayer(new BlockLayerComparator(layer));
        sphere.setLayerPlace(AbstractBlockShapePlaceType.LayerPlace.RANDOM);

        SphereGen secondSphere = new SphereGen(world, pos2.down(large), AbstractBlockShapeBase.PlaceMoment.OTHER, (int) ((2 + (float) Random.create().nextBetween(0, 4) / 10) * (large - 0.75f)));
        secondSphere.setRadiusY(large);


        secondSphere.setZRotation(rot1);
        secondSphere.setSecondYRotation(rot2);

        return new SphereGen[]{sphere, secondSphere};
    }


    protected boolean place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, DefaultBlockListComparator coordinates, SphereGen sphere, SphereGen secondSphere) {
        Set<BlockPos> posSet = new HashSet<>();
        List<Set<BlockPos>> posSphere = sphere.getBlockPos();
        for (Set<BlockPos> blockPosSet : posSphere) {
            posSet.addAll(blockPosSet);
        }
        posSphere = secondSphere.getBlockPos();
        for (Set<BlockPos> blockPosSet : posSphere) {
            posSet.removeAll(blockPosSet);
        }

        Map<ChunkPos, Set<BlockPos>> chunkMap = new HashMap<>();
        for (BlockPos pos1 : posSet) {
            WorldGenUtil.modifyChunkMap(pos1, chunkMap);
        }

        List<Set<DefaultBlockList>> blockList = sphere.getBlockListWithVerification(new ArrayList<>(chunkMap.values()));
        DefaultBlockListComparator comparator = new DefaultBlockListComparator(BlockListUtil.unDivideBlockList(blockList));
        coordinates.placeAll(world);
        comparator.placeAll(world);
        return true;
    }


}