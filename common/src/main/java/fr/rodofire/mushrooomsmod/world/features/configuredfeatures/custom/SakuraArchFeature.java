package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.StructurePlacementRuleManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.shape.block.gen.TorusGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.placer.ShapePlacer;
import fr.rodofire.ewc.shape.block.placer.WGShapeData;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.util.ModTags;
import fr.rodofire.mushrooomsmod.world.features.config.ArchConfig;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util.RockUtil;

import java.util.Map;
import java.util.Set;

public class SakuraArchFeature extends Feature<ArchConfig> {
    public SakuraArchFeature(Codec<ArchConfig> configCodec) {
        super(configCodec);
    }

    //Since that arch generation is pretty big, we need to change the generation to be chunk independant
    @Override
    public boolean place(FeaturePlaceContext<ArchConfig> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        boolean bl = false;
        for (int i = 0; i < 20; i++) {
            if (world.getBlockState(pos.below(i)).isSolidRender(world, pos.below(i))) bl = true;
        }
        if (!bl) return false;

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);

        int radiusx = random.nextIntBetweenInclusive(13, 35);
        int radiusz = random.nextIntBetweenInclusive(13, 35);
        int innerRadius = random.nextIntBetweenInclusive(2, 7);

        TorusGen torus = new TorusGen(pos, innerRadius, radiusx);
        torus.setOuterRadiusZ(radiusz);

        BlockLayer stone = RockUtil.getRandomBlockLayer(
                random.nextIntBetweenInclusive(3, 5),
                random.nextIntBetweenInclusive(2, 5),
                Blocks.STONE.defaultBlockState(),
                world.getSeed(),
                RockUtil.getRandomStone(random, Blocks.TUFF.defaultBlockState()));

        BlockLayer grass = new BlockLayer(LayerPlacer.ofRandom(random), Blocks.GRASS_BLOCK.defaultBlockState(), 1);

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
                random.nextIntBetweenInclusive(-10, -10),
                -random.nextIntBetweenInclusive(40, 140),
                random.nextIntBetweenInclusive(0, 360)
        );

        torus.setRotator(rotator);
        torus.setTorusType(TorusGen.TorusType.HORIZONTAL_HALF);

        //torus.setSecondxrotation(Random.create().nextBetween(0, 180));

        Map<ChunkPos, LongOpenHashSet> posList = torus.getShapeCoordinates();

        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.WORLD_GEN, WGShapeData.ofStep(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, MushrooomsModConstants.MOD_ID + "-sakura_arch"), pos, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "sakura_arch"));
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
