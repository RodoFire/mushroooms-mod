package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.mixin.world.TrunkPlacerTypeInvoker;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.BlueLuminescentTrunkPlacer;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.ColorfulTreeTrunkPlacer;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.PeltogyneTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> BLUE_LUMINESCENT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("blue_luminescent_trunk_placer", BlueLuminescentTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> PELTOGYNE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("peltogyne_trunk_placer", PeltogyneTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> COLORFUL_TREE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("colorful_tree_trunk_placer", ColorfulTreeTrunkPlacer.CODEC);

    public static void register() {
        MushrooomsMod.LOGGER.info("Registering Trunkplacers");
    }
}
