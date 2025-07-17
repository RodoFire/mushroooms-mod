package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplings {
    public static final TreeGrower BLUE_LUMINESCENT_SAPLING = new TreeGrower("blue_luminescent_sapling", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.BLUE_LUMINESCENT_TREE),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());

    public static final TreeGrower OAK_BERRIES_SAPLING_GENERATOR = new TreeGrower("oak_berries_sapling", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.OAK_BERRIES_TREE),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());

    public static final TreeGrower PELTOGYNE_SAPLING_GENERATOR = new TreeGrower("peltogyne_sapling", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.PELTOGYNE_TREE),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());

    public static final TreeGrower COLORFUL_TREE_SAPLING_GENERATOR = new TreeGrower("colorful_tree_sapling", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.COLORFUL_TREE),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
}
