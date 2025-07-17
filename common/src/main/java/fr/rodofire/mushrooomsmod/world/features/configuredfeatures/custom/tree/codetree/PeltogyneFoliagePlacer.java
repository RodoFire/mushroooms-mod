package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.placer.ShapePlacer;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;

public class PeltogyneFoliagePlacer extends FoliagePlacer {
    public static final PeltogyneFoliagePlacer INSTANCE = new PeltogyneFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1), 3);
    public static final MapCodec<PeltogyneFoliagePlacer> CODEC = MapCodec.unit(() -> INSTANCE);
    private final int height;

    public PeltogyneFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.PELTOGYNE_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader world, FoliageSetter placer, RandomSource random, TreeConfiguration config, int trunkHeight, FoliageAttachment treeNode, int foliageHeight, int radius, int offset) {

        SphereGen sphereGen = new SphereGen(treeNode.pos(), random.nextIntBetweenInclusive(2, 3));
        BlockLayer layer = new BlockLayer(
                LayerPlacer.ofRandom(random),
                config.foliageProvider.getState(random, treeNode.pos())
        );

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(layer));
        ShapePlacer placer1 = new ShapePlacer((WorldGenLevel) world, ShapePlacer.PlaceMoment.OTHER, treeNode.pos());
        placer1.place(sphereGen.getShapeCoordinates(), layerManager);
    }

    @Override
    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
