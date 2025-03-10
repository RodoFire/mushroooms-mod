package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.shape.block.placer.ShapePlacer;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;

public class PeltogyneFoliagePlacer extends FoliagePlacer {
    public static final PeltogyneFoliagePlacer INSTANCE = new PeltogyneFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), 3);
    public static final MapCodec<PeltogyneFoliagePlacer> CODEC = MapCodec.unit(() -> INSTANCE);
    private final int height;

    public PeltogyneFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.PELTOGYNE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {

        SphereGen sphereGen = new SphereGen(treeNode.getCenter(), random.nextBetween(2, 3));
        BlockLayer layer = new BlockLayer(
                new LayerPlacer(LayerPlacer.PlacingType.RANDOM),
                config.foliageProvider.get(random, treeNode.getCenter())
        );

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(layer));
        ShapePlacer placer1 = new ShapePlacer((StructureWorldAccess) world, ShapePlacer.PlaceMoment.OTHER, treeNode.getCenter());
        placer1.place(sphereGen.getShapeCoordinates(), layerManager);
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
