package fr.rodofire.mushrooomsmod.client.colors;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

public class ModColor {
    public static void createBlockColors() {
        //TODO color
        /*ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
                    if (world == null || pos == null) {
                        return FoliageColor.getDefaultColor();
                    }
                    return BiomeColors.getAverageFoliageColor(world, pos);
                }
                , ModBlocks.OAK_BERRIES_LEAVES);*/

    }

    public static void createItemColors() {
        /*ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColor.getDefaultColor()
                , ModBlocks.OAK_BERRIES_LEAVES.asItem());*/

    }
}
