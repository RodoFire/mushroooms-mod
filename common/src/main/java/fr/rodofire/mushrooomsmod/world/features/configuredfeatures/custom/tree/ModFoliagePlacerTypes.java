package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.mixin.world.gen.FoliagePlacerTypeInvoker;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.BlueLuminescentFoliagePlacer;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.ColorfulTreeFoliagePlacer;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.PeltogyneFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<BlueLuminescentFoliagePlacer> BLUE_LUMINESCENT_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("blue_luminescent_foliage_placer", BlueLuminescentFoliagePlacer.CODEC);
    public static final FoliagePlacerType<PeltogyneFoliagePlacer> PELTOGYNE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("pentogyne_foliage_placer", PeltogyneFoliagePlacer.CODEC);
    public static final FoliagePlacerType<ColorfulTreeFoliagePlacer> COLORFUL_TREE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("colorful_tree_foliage_placer", ColorfulTreeFoliagePlacer.CODEC);

    public static void registerFoliagePlacers() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering FoliagePlacers");
    }
}
