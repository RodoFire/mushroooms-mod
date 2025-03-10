package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.StructurePlacementRuleManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.shape.block.gen.TorusGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.shape.block.placer.ShapePlacer;
import net.rodofire.easierworldcreator.shape.block.placer.WGShapeData;
import net.rodofire.easierworldcreator.shape.block.placer.WGShapeHandler;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.rodofire.mushrooomsmod.world.features.config.ArchConfig;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util.RockUtil;

import java.util.Map;
import java.util.Set;

public class SakuraArchFeature extends Feature<ArchConfig> {
    public SakuraArchFeature(Codec<ArchConfig> configCodec) {
        super(configCodec);
    }

    //Since that arch generation is pretty big, we need to change the generation to be chunk independant
    @Override
    public boolean generate(FeatureContext<ArchConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();

        boolean bl = false;
        for (int i = 0; i < 20; i++) {
            if (world.getBlockState(pos.down(i)).isOpaqueFullCube()) bl = true;
        }
        if (!bl) return false;

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);

        int radiusx = random.nextBetween(13, 35);
        int radiusz = random.nextBetween(13, 35);
        int innerRadius = random.nextBetween(2, 7);

        TorusGen torus = new TorusGen(pos, innerRadius, radiusx);
        torus.setOuterRadiusZ(radiusz);

        BlockLayer stone = RockUtil.getRandomBlockLayer(
                random.nextBetween(3, 5),
                random.nextBetween(2, 5),
                Blocks.STONE.getDefaultState(),
                world.getSeed(),
                RockUtil.getRandomStone(Blocks.TUFF.getDefaultState()));

        BlockLayer grass = new BlockLayer(new LayerPlacer(LayerPlacer.PlacingType.RANDOM), Blocks.GRASS_BLOCK.getDefaultState(), 1);

        StructurePlacementRuleManager stoneRule = new StructurePlacementRuleManager();
        stoneRule.addTagKeys(Set.of(
                BlockTags.DIRT, ModTags.Blocks.FLUIDS, BlockTags.LEAVES
        ));

        StructurePlacementRuleManager grassRule = new StructurePlacementRuleManager();
        grassRule.addTagKeys(Set.of(
                ModTags.Blocks.FLUIDS, BlockTags.LEAVES
        ));

        grass.setRuler(grassRule);
        stone.setRuler(stoneRule);


        //torus.setTorusType(TorusGen.TorusType.HORIZONTAL_HALF);


        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE,
                new BlockLayerManager(grass, stone)
        );

        Rotator rotator = new Rotator(
                pos,
                random.nextBetween(-10, -10),
                -random.nextBetween(40, 140),
                random.nextBetween(0, 360)
        );

        torus.setRotator(rotator);
        torus.setTorusType(TorusGen.TorusType.HORIZONTAL_HALF);

        //torus.setSecondxrotation(Random.create().nextBetween(0, 180));

        Map<ChunkPos, LongOpenHashSet> posList = torus.getShapeCoordinates();

        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.WORLD_GEN, WGShapeData.ofStep(GenerationStep.Feature.TOP_LAYER_MODIFICATION, MushrooomsMod.MOD_ID + "-sakura_arch"), pos, Identifier.of(MushrooomsMod.MOD_ID, "sakura_arch"));
        placer.place(posList, layerManager);


        /*for (Set<BlockPos> set : poslist.values()) {
            set.removeIf(pos1 -> noise.GetNoise(pos1.getX(), pos1.getY(), pos1.getZ()) <= -0.8f);
        }*/

        /*BlockPos pos1 = new BlockPos((int) (radiusx * FastMaths.getFastCos(rotationX)), 0, (int) (radiusz * FastMaths.getFastSin(rotationX)));
        BlockPos pos2 = new BlockPos((int) (-radiusx * FastMaths.getFastCos(rotationX)), 0, (int) (-radiusz * FastMaths.getFastSin(rotationX)));

        CylinderGen cylinder = new CylinderGen(world, pos.add(pos1), Shape.PlaceMoment.WORLD_GEN, innerRadius, 15);
        CylinderGen cylinder2 = new CylinderGen(world, pos.add(pos2), Shape.PlaceMoment.WORLD_GEN, innerRadius, 15);

        cylinder.setBlockLayers(stone);
        cylinder2.setBlockLayers(stone);

        cylinder.setYrotation(-rotattionY - 90);
        cylinder2.setYrotation(-rotattionY - 90);*/
        //cylinder.place();
        //cylinder2.place();

        return true;
    }
}
