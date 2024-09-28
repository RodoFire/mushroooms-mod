package net.rodofire.mushrooomsmod.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class BlockUtils {
    public static void registerStripable() {
        StrippableBlockRegistry.register(ModBlocks.BLUE_LUMINESCENT_LOG, ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG);
        StrippableBlockRegistry.register(ModBlocks.BLUE_LUMINESCENT_WOOD, ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD);

        StrippableBlockRegistry.register(ModBlocks.PELTOGYNE_LOG, ModBlocks.PELTOGYNE_STRIPPED_LOG);
        StrippableBlockRegistry.register(ModBlocks.PELTOGYNE_WOOD, ModBlocks.PELTOGYNE_STRIPPED_WOOD);
    }

    public static void registerFlammable() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_LUMINESCENT_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_LUMINESCENT_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_LUMINESCENT_PLANKS, 5, 20);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_LUMINESCENT_LEAVES, 25, 50);


        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PELTOGYNE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PELTOGYNE_STRIPPED_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PELTOGYNE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PELTOGYNE_STRIPPED_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PELTOGYNE_PLANKS, 5, 20);
    }
}
