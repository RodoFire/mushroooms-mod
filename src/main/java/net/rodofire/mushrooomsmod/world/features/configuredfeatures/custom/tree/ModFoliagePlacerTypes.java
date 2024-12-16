package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.mixin.world.FoliagePlacerTypeInvoker;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.BlueLuminescentFoliagePlacer;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.ColorfulTreeFoliagePlacer;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.PeltogyneFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<BlueLuminescentFoliagePlacer> BLUE_LUMINESCENT_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("blue_luminescent_foliage_placer", BlueLuminescentFoliagePlacer.CODEC);
    public static final FoliagePlacerType<PeltogyneFoliagePlacer> PELTOGYNE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("pentogyne_foliage_placer", PeltogyneFoliagePlacer.CODEC);
    public static final FoliagePlacerType<ColorfulTreeFoliagePlacer> COLORFUL_TREE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("colorful_tree_foliage_placer", ColorfulTreeFoliagePlacer.CODEC);

    public static void register() {
        MushrooomsMod.LOGGER.info("Registering Trunkplacers");
    }
}
