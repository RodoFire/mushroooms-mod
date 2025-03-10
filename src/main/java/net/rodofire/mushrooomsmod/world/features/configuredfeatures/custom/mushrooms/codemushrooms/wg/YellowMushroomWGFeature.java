package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.rodofire.easierworldcreator.blockdata.blocklist.DividedBlockListManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.ShapePlacer;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.mushrooomsmod.MushrooomsMod;

import java.util.Map;
import java.util.Set;

public class YellowMushroomWGFeature extends YellowMushroomWG {

    public YellowMushroomWGFeature(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected DividedBlockListManager generateHugeTrunk(StructureWorldAccess world, BlockPos pos, BlockPos end, int height, HugeMushroomFeatureConfig config, Random random) {
        DividedBlockListManager blockList = new DividedBlockListManager();

        //on créé plusieurs lignes qui vont servir à appaissir le tronc.
        LineGen line;
        LongOpenHashSet posList = new LongOpenHashSet();
        for (int i = 0; i < 4; i++) {

            line = new LineGen(pos.north().up(random.nextBetween(-1, 1)), end.north(random.nextBetween(-1, 1)));
            posList.addAll(
                    line.getShapeCoordinates().values().stream()
                            .flatMap(Set::stream)
                            .toList()
            );

            line = new LineGen(pos.south().up(random.nextBetween(-1, 1)), end.south(random.nextBetween(-1, 1)));
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
    protected DividedBlockListManager generateTrunk(StructureWorldAccess world, BlockPos pos, BlockPos end, int height, HugeMushroomFeatureConfig config) {
        LineGen line = new LineGen(pos, end);
        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(trunkLayer));
        return layerManager.getDivided(line.getShapeCoordinates());
    }

    @Override
    protected SphereGen[] generateCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DividedBlockListManager coordinates, Random random) {
        SphereGen sphere = new SphereGen(pos2.down(large / 2), (int) (1.5 * large));
        sphere.setRadiusY(large);

        int rot1 = random.nextBetween(0, 30);
        int rot2 = random.nextBetween(0, 360);
        Rotator rotator = new Rotator(pos2.down(large / 2), 0, rot1, rot2);
        sphere.setRotator(rotator);

        SphereGen secondSphere = new SphereGen(pos2.down(large), (int) ((1.5 + (float) random.nextBetween(0, 5) / 10) * (large - 1)));
        secondSphere.setRadiusY(large);

        secondSphere.setRotator(rotator);

        return new SphereGen[]{sphere, secondSphere};
    }

    @Override
    protected SphereGen[] generateFlatterCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DividedBlockListManager coordinates, Random random) {
        SphereGen sphere = new SphereGen(pos2.down(large / 2), 2 * large);
        sphere.setRadiusY(large);

        int rot1 = random.nextBetween(0, 30);
        int rot2 = random.nextBetween(0, 360);
        Rotator rotator = new Rotator(pos2.down(large / 2), 0, rot1, rot2);

        sphere.setRotator(rotator);


        SphereGen secondSphere = new SphereGen(pos2.down(large), (int) ((2 + (float) random.nextBetween(0, 4) / 10) * (large - 0.75f)));
        secondSphere.setRadiusY(large);

        secondSphere.setRotator(rotator);

        return new SphereGen[]{sphere, secondSphere};
    }


    protected boolean place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, DividedBlockListManager manager, SphereGen sphere, SphereGen secondSphere) {
        Map<ChunkPos, LongOpenHashSet> posSphere = sphere.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> maskPos = secondSphere.getShapeCoordinates();
        posSphere.forEach((chunkPos, set) -> set.removeAll(maskPos.get(chunkPos)));


        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(capLayer));
        manager.put(layerManager.getDivided(posSphere));

        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.WORLD_GEN, pos,Identifier.of(MushrooomsMod.MOD_ID, "huge_yellow_mushroom"));
        placer.place(manager);
        return true;
    }


}