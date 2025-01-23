package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapePlaceType;
import net.rodofire.easierworldcreator.util.FastNoiseLite;

import java.util.*;

public abstract class DefaultRockFeature extends Feature<DefaultFeatureConfig> {
    private int height;
    private int width;
    private BlockState block;


    public DefaultRockFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BlockPos pos = context.getOrigin();
        if (world.getBlockState(pos).getBlock() == Blocks.GRASS)
            pos.add(0, -1, 0);

        if (!world.getBlockState(pos.down()).isOpaqueFullCube(world, pos)) {
            return false;
        }
        BlockLayer layer = this.getBlockLayer();
        Vec3i dimensions = this.getDimesions();

        SphereGen circleGen = new SphereGen(world, pos, AbstractBlockShapeBase.PlaceMoment.WORLD_GEN, 0);
        circleGen.setHalfSphere(SphereGen.SphereType.HALF);

        circleGen.setRadiusX(dimensions.getX());
        circleGen.setRadiusY(dimensions.getY());
        circleGen.setRadiusZ(dimensions.getZ());

        circleGen.setZRotation(random.nextBetween(-20, 20));
        circleGen.setYRotation(random.nextBetween(-20, 20));

        layer.setBlocksToForce(Set.of(Blocks.GRASS_BLOCK, Blocks.DIRT));
        circleGen.setBlockLayer(new BlockLayerComparator(layer));


        circleGen.setLayerPlace(AbstractBlockShapePlaceType.LayerPlace.NOISE3D);
        FastNoiseLite placeNoise = new FastNoiseLite((int) world.getSeed());
        placeNoise.SetFrequency(0.2f);
        circleGen.setNoise(placeNoise);

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);

        Map<ChunkPos, Set<BlockPos>> posList = circleGen.getBlockPos();
        for (Set<BlockPos> set : posList.values()) {
            List<BlockPos> toAdd = new ArrayList<>();
            Iterator<BlockPos> iter = set.iterator();
            while (iter.hasNext()) {
                BlockPos blockPos = iter.next();
                float value = noise.GetNoise(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (value > 0.8f) {
                    toAdd.add(blockPos.up());
                } else if (value < 0.1f && value > -0.1f) {
                    iter.remove();
                } else if (value < 0.8f) {
                    toAdd.add(blockPos.down());
                }
            }
            set.addAll(toAdd);
        }

        circleGen.place(posList);

        return true;
    }

    public abstract BlockLayer getBlockLayer();

    public abstract Vec3i getDimesions();


}
