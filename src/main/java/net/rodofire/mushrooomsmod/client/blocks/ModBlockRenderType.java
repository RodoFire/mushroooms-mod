package net.rodofire.mushrooomsmod.client.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class ModBlockRenderType {
    public static void createTransludentBlocks() {
        getTransludent(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK);
        getTransludent(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK);
        getTransludent(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM);
        getTransludent(ModBlocks.TRANSPARENT_MUSHROOM_STEM);


        getTransludent(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
        getTransludent(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);
        getTransludent(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);

        getTransludent(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
        getTransludent(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
        getTransludent(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);


        getTransludent(ModBlocks.PINK_LUMINESCENT_BODY_VINES);
        getTransludent(ModBlocks.PINK_LUMINESCENT_HEAD_VINES);


        getTransludent(ModBlocks.BIG_PURPLE_MUSHROOM);
        getTransludent(ModBlocks.BIG_GREEN_MUSHROOM);
        getTransludent(ModBlocks.MEDIUM_GREEN_MUSHROOM);
        getTransludent(ModBlocks.MEDIUM_PURPLE_MUSHROOM);
        getTransludent(ModBlocks.LITTLE_GREEN_MUSHROOM);
        getTransludent(ModBlocks.LITTLE_PURPLE_MUSHROOM);
        getTransludent(ModBlocks.TINY_PURPLE_MUSHROOM);
        getTransludent(ModBlocks.TINY_GREEN_MUSHROOM);


        getTransludent(ModBlocks.RED_CRYSTAL_BLOCK);
        getTransludent(ModBlocks.BLUE_CRYSTAL_BLOCK);
        getTransludent(ModBlocks.WHITE_CRYSTAL_BLOCK);
        getTransludent(ModBlocks.AMBER_MINERAL);
    }

    public static void createCutoutBlocks() {

        //Mushrooms
        getCutout(ModBlocks.BLUE_MUSHROOM);
        getCutout(ModBlocks.GREEN_MUSHROOM);
        getCutout(ModBlocks.BLUE_LUMINESCENT_MUSHROOM);
        getCutout(ModBlocks.PURPLE_MUSHROOM);
        getCutout(ModBlocks.LUMINESCENT_PINK_MUSHROOM);
        getCutout(ModBlocks.ORANGE_MUSHROOM);
        getCutout(ModBlocks.YELLOW_MUSHROOM);
        getCutout(ModBlocks.FERTILE_RED_MUSHROOM);


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OAK_BERRIES_LEAVES, RenderLayer.getCutoutMipped());


        getCutout(ModBlocks.STERILE_BLUE_MUSHROOM);
        getCutout(ModBlocks.MUSHROOM_SMALL_BROWN);
        getCutout(ModBlocks.MUSHROOM_SMALL_RED);
        getCutout(ModBlocks.MUSHROOM_DEATH_TRUMPET);
        getCutout(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT);
        getCutout(ModBlocks.LOG_MUSHROOM_BROWN);


        getCutout(ModBlocks.POTTED_STERILE_BLUE_MUSHROOM);
        getCutout(ModBlocks.POTTED_MUSHROOM_SMALL_BROWN);
        getCutout(ModBlocks.POTTED_MUSHROOM_SMALL_RED);


        getCutout(ModBlocks.MUSHROOM_FLOWERS);
        getCutout(ModBlocks.OCULAE);
        getCutout(ModBlocks.SOL_OCCIDENTIS);
        getCutout(ModBlocks.CYANUS_RUBENS);
        getCutout(ModBlocks.CYANEA);
        getCutout(ModBlocks.FUTIALI);
        getCutout(ModBlocks.NOCTULICA);
        getCutout(ModBlocks.TURQUOSUM_STILUS);
        getCutout(ModBlocks.SAPHIRA_FLORENS);
        getCutout(ModBlocks.CAERULEA_VOLUBILIS);
        getCutout(ModBlocks.PREHISTORIC_ROSE);
        getCutout(ModBlocks.PREHISTO_PINK_SCHROOM);
        getCutout(ModBlocks.PREHISTO_BLUE_SCHROOM);
        getCutout(ModBlocks.PREHISTURPLE_SCHROOM);
        getCutout(ModBlocks.PREHISTO_GREEN_SCHROOM);

        getCutout(ModBlocks.BLUE_PERENNIAL);
        getCutout(ModBlocks.PINK_PERENNIAL);
        getCutout(ModBlocks.PURPLE_PERENNIAL);
        getCutout(ModBlocks.LUMINESCENT_PERENNIAL);
        getCutout(ModBlocks.YELLOW_PERENNIAL);
        getCutout(ModBlocks.GREEN_PERENNIAL);
        getCutout(ModBlocks.ORANGE_PERENNIAL);

        getCutout(ModBlocks.RED_QUINCE);
        getCutout(ModBlocks.YELLOW_QUINCE);
        getCutout(ModBlocks.TINY_LILAC);
        getCutout(ModBlocks.YELICE);
        getCutout(ModBlocks.FLAMESTHYSIA);
        getCutout(ModBlocks.APAGANTHE);
        getCutout(ModBlocks.PINK_HEATER);
        getCutout(ModBlocks.WYSTERIA);
        getCutout(ModBlocks.BLUEBELL);
        getCutout(ModBlocks.VIPERIN);
        getCutout(ModBlocks.HIBISCUS);
        getCutout(ModBlocks.PLATUM);
        getCutout(ModBlocks.DIANTHUS);
        getCutout(ModBlocks.CYCAS);
        getCutout(ModBlocks.ARUM);
        getCutout(ModBlocks.HYDRANGEA);
        getCutout(ModBlocks.ANEMONE);
        getCutout(ModBlocks.JACYNTHE);
        getCutout(ModBlocks.PERVENCHE);
        getCutout(ModBlocks.ACONIT);
        getCutout(ModBlocks.FLEUR_BERRIES);
        getCutout(ModBlocks.PICK_BLUE);


        getCutout(ModBlocks.TINY_GRASS);
        getCutout(ModBlocks.BLUE_LUMINESCENT_GRASS);
        getCutout(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS);


        getCutout(ModBlocks.PINK_MUSHROOM_VINES);
        getCutout(ModBlocks.PINK_MUSHROOM_VINES_PLANT);
        getCutout(ModBlocks.BLUE_LUMINESCENT_VINES);


        getCutout(ModBlocks.POTTED_BLUE_LUMINESCENT_MUSHROOM);
        getCutout(ModBlocks.POTTED_PURPLE_MUSHROOM);
        getCutout(ModBlocks.POTTED_GREEN_MUSHROOM);
        getCutout(ModBlocks.POTTED_BLUE_MUSHROOM);
        getCutout(ModBlocks.POTTED_LUMINESCENT_PINK_MUSHROOM);
        getCutout(ModBlocks.POTTED_FERTILE_RED_MUSHROOM);
        getCutout(ModBlocks.POTTED_MUSHROOM_DEATH_TRUMPET);

        getCutout(ModBlocks.POTTED_CYANEA);
        getCutout(ModBlocks.POTTED_CYANUS_RUBENS);
        getCutout(ModBlocks.POTTED_SOL_OCCIDENTIS);
        getCutout(ModBlocks.POTTED_FUTIALI);
        getCutout(ModBlocks.POTTED_NOCTULICA);
        getCutout(ModBlocks.POTTED_OCULAE);
        getCutout(ModBlocks.POTTED_PREHISTORIC_ROSE);
        getCutout(ModBlocks.POTTED_PREHISTURPLE_SCHROOM);
        getCutout(ModBlocks.POTTED_PREHISTO_BLUE_SCHROOM);
        getCutout(ModBlocks.POTTED_PREHISTO_PINK_SCHROOM);
        getCutout(ModBlocks.POTTED_PREHISTO_GREEN_SCHROOM);

        getCutout(ModBlocks.POTTED_BLUE_PERENNIAL);
        getCutout(ModBlocks.POTTED_GREEN_PERENNIAL);
        getCutout(ModBlocks.POTTED_PINK_PERENNIAL);
        getCutout(ModBlocks.POTTED_LUMINESCENT_PERENNIAL);
        getCutout(ModBlocks.POTTED_PURPLE_PERENNIAL);
        getCutout(ModBlocks.POTTED_YELLOW_PERENNIAL);
        getCutout(ModBlocks.POTTED_ORANGE_PERENNIAL);

        getCutout(ModBlocks.POTTED_RED_QUINCE);
        getCutout(ModBlocks.POTTED_YELLOW_QUINCE);
        getCutout(ModBlocks.POTTED_YELICE);
        getCutout(ModBlocks.POTTED_FLAMESTHYSIA);
        getCutout(ModBlocks.POTTED_APAGANTHE);
        getCutout(ModBlocks.POTTED_WYSTERIA);
        getCutout(ModBlocks.POTTED_BLUEBELL);
        getCutout(ModBlocks.POTTED_VIPERIN);
        getCutout(ModBlocks.POTTED_HIBISCUS);
        getCutout(ModBlocks.POTTED_PLATUM);
        getCutout(ModBlocks.POTTED_DIANTHUS);
        getCutout(ModBlocks.POTTED_CYCAS);
        getCutout(ModBlocks.POTTED_ARUM);
        getCutout(ModBlocks.POTTED_HYDRANGEA);
        getCutout(ModBlocks.POTTED_ANEMONE);
        getCutout(ModBlocks.POTTED_JACYNTHE);
        getCutout(ModBlocks.POTTED_BLUE_LUMINESCENT_SAPPLING);
        getCutout(ModBlocks.OAK_BERRIES_SAPLING);


        getCutout(ModBlocks.BLUE_LUMINESCENT_LEAVES);
        getCutout(ModBlocks.RED_COLORFUL_LEAVES);
        getCutout(ModBlocks.GREEN_COLORFUL_LEAVES);
        getCutout(ModBlocks.YELLOW_COLORFUL_LEAVES);
        getCutout(ModBlocks.PURPLE_COLORFUL_LEAVES);
        getCutout(ModBlocks.BLUE_COLORFUL_LEAVES);
        getCutout(ModBlocks.PINK_COLORFUL_LEAVES);
        getCutout(ModBlocks.ORANGE_COLORFUL_LEAVES);
        getCutout(ModBlocks.OAK_BERRIES_LEAVES);
        getCutout(ModBlocks.PELTOGYNE_LEAVES);


        getCutout(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR);
        getCutout(ModBlocks.PELTOGYNE_TRAPDOOR);

        getCutout(ModBlocks.BLUE_LUMINESCENT_DOOR);
        getCutout(ModBlocks.PELTOGYNE_DOOR);

        getCutout(ModBlocks.BLUE_LUMINESCENT_SAPPLING);
        getCutout(ModBlocks.PELTOGYNE_SAPLING);
        getCutout(ModBlocks.COLORFUL_TREE_SAPLING);

        getCutout(ModBlocks.BLUE_LUMINESCENT_SLAB);
        getCutout(ModBlocks.PELTOGYNE_SLAB);

        getCutout(ModBlocks.BLUE_LUMINESCENT_STAIRS);
        getCutout(ModBlocks.PELTOGYNE_STAIRS);


        getCutout(ModBlocks.GREEN_LANTERN);
        getCutout(ModBlocks.RED_LANTERN);
        getCutout(ModBlocks.GREEN_TORCH);
        getCutout(ModBlocks.WALL_GREEN_TORCH);
        getCutout(ModBlocks.GREEN_CAMPFIRE);


        getCutout(ModBlocks.BLUE_CRYSTAL);
        getCutout(ModBlocks.RED_CRYSTAL);
        getCutout(ModBlocks.WHITE_CRYSTAL);
    }

    public static void getCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }

    public static void getTransludent(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
    }
}
