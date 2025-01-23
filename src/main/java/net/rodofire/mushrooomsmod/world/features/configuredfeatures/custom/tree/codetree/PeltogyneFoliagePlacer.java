package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;

public class PeltogyneFoliagePlacer extends FoliagePlacer {
    public static final Codec<PeltogyneFoliagePlacer> CODEC = RecordCodecBuilder.create(peltogyneFoliagePlacerInstance ->
            fillFoliagePlacerFields(peltogyneFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(peltogyneFoliagePlacerInstance, PeltogyneFoliagePlacer::new));
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

        SphereGen sphereGen = new SphereGen((StructureWorldAccess) world, treeNode.getCenter(), AbstractBlockShapeBase.PlaceMoment.OTHER, Random.create().nextBetween(2, 3));
        sphereGen.setBlockLayer(new BlockLayerComparator(new BlockLayer(config.foliageProvider.get(random, treeNode.getCenter()))));

        sphereGen.place();
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
