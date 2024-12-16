package net.rodofire.mushrooomsmod.client.colors;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.world.biome.FoliageColors;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class ModColor {
    public static void createBlockColors() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
                    if (world == null || pos == null) {
                        return FoliageColors.DEFAULT;
                    }
                    return BiomeColors.getFoliageColor(world, pos);
                }
                , ModBlocks.OAK_BERRIES_LEAVES);

    }

    public static void createItemColors() {
        /*ColorProviderRegistry.Item.register((stack, tintIndex) -> FoliageColors.getDefaultColor()
                , ModBlocks.OAK_BERRIES_LEAVES.asItem());*/

    }
}
