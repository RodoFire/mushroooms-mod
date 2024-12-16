package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.shape.block.gen.TorusGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeLayer;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapePlaceType;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.mushrooomsmod.world.features.config.ArchConfig;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util.RockUtil;

import java.util.List;
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

        boolean bl = false;
        for (int i = 0; i < 10; i++) {
            if (world.getBlockState(pos.down(i)).isOpaqueFullCube()) bl = true;
        }
        if (!bl) return false;

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);

        int radiusx = Random.create().nextBetween(10, 23);
        int radiusz = Random.create().nextBetween(10, 23);
        int innerRadius = Random.create().nextBetween(2, 7);

        TorusGen torus = new TorusGen(world, pos, AbstractBlockShapeBase.PlaceMoment.WORLD_GEN, innerRadius, radiusx);

        BlockLayer stone = RockUtil.getRandomBlockLayer(
                Random.create().nextBetween(3, 5),
                Random.create().nextBetween(2, 5),
                Blocks.STONE.getDefaultState(),
                RockUtil.getRandomStone(Blocks.TUFF.getDefaultState()));

        stone.setBlocksToForce(Set.of(Blocks.GRASS_BLOCK, Blocks.DIRT));
        torus.setBlockLayer(new BlockLayerComparator(List.of(
                new BlockLayer(
                        Blocks.GRASS_BLOCK.getDefaultState(), 1),
                stone)));

        //torus.setTorusType(TorusGen.TorusType.HORIZONTAL_HALF);


        torus.setLayerPlace(AbstractBlockShapePlaceType.LayerPlace.NOISE3D);
        FastNoiseLite placeNoise = new FastNoiseLite((int) world.getSeed());
        placeNoise.SetFrequency(0.2f);
        torus.setNoise(placeNoise);

        torus.setOuterRadiusZ(radiusz);
        torus.setLayersType(AbstractBlockShapeLayer.LayersType.SURFACE);

        int rotationZ = Random.create().nextBetween(0, 180);
        int rotattionY = -Random.create().nextBetween(50, 140);

        torus.setZRotation(rotationZ);
        torus.setYRotation(rotattionY);
        //torus.setSecondxrotation(Random.create().nextBetween(0, 180));

        List<Set<BlockPos>> poslist = torus.getBlockPos();

        for (Set<BlockPos> set : poslist) {
            set.removeIf(pos1 -> noise.GetNoise(pos1.getX(), pos1.getY(), pos1.getZ()) <= -0.8f);
        }

        /*BlockPos pos1 = new BlockPos((int) (radiusx * FastMaths.getFastCos(rotationX)), 0, (int) (radiusz * FastMaths.getFastSin(rotationX)));
        BlockPos pos2 = new BlockPos((int) (-radiusx * FastMaths.getFastCos(rotationX)), 0, (int) (-radiusz * FastMaths.getFastSin(rotationX)));

        CylinderGen cylinder = new CylinderGen(world, pos.add(pos1), Shape.PlaceMoment.WORLD_GEN, innerRadius, 15);
        CylinderGen cylinder2 = new CylinderGen(world, pos.add(pos2), Shape.PlaceMoment.WORLD_GEN, innerRadius, 15);

        cylinder.setBlockLayers(stone);
        cylinder2.setBlockLayers(stone);

        cylinder.setYrotation(-rotattionY - 90);
        cylinder2.setYrotation(-rotattionY - 90);*/


        torus.place(poslist);
        //cylinder.place();
        //cylinder2.place();

        return true;
    }
}
