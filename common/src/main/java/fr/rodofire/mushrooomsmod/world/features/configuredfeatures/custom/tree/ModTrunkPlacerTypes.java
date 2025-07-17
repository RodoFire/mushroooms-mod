package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.mixin.world.gen.TrunkPlacerTypeInvoker;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.BlueLuminescentTrunkPlacer;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.ColorfulTreeTrunkPlacer;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.PeltogyneTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> BLUE_LUMINESCENT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("blue_luminescent_trunk_placer", BlueLuminescentTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> PELTOGYNE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("peltogyne_trunk_placer", PeltogyneTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> COLORFUL_TREE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("colorful_tree_trunk_placer", ColorfulTreeTrunkPlacer.CODEC);

    public static void registerTrunkPlacers() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering TrunkPlacers");
    }
}
