package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.block.custom.bigmushroom.BigMushroomPlant;
import net.rodofire.mushrooomsmod.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //Blocks
        //Mushroom
        addDrop(ModBlocks.PURPLE_MUSHROOM_BLOCK);
        addDrop(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK);


        addDrop(ModBlocks.ORANGE_MUSHROOM_BLOCK);
        addDrop(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK);

        addDrop(ModBlocks.YELLOW_MUSHROOM_BLOCK);
        addDrop(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK);

        addDrop(ModBlocks.BLUE_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK);

        addDrop(ModBlocks.GREEN_MUSHROOM_BLOCK);
        addDrop(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK);

        addDrop(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

        addDrop(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK);
        addDrop(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

        addDrop(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK);

        addDrop(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK);

        //Mushroom related
        addDrop(ModBlocks.GREEN_MUSHROOM_STEM);
        addDrop(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM);
        addDrop(ModBlocks.TRANSPARENT_MUSHROOM_STEM);
        addDrop(ModBlocks.COMPRESSED_PURPLE_MUSHROOM);

        //Soft Blocks
        addDrop(ModBlocks.COMPRESSED_DIRT);
        addDrop(ModBlocks.LIGHT_COMPRESSED_DIRT);

        //Hard Blocks
        addDrop(ModBlocks.PURPLE_SCHROOM_DEESLATE, oreDrops(ModBlocks.PURPLE_SCHROOM_DEESLATE, Blocks.DEEPSLATE.asItem()));
        addDrop(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE, oreDrops(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE, Blocks.DEEPSLATE.asItem()));
        addDrop(ModBlocks.GREEN_STONY_SCHROOM_DEPOT, oreDrops(ModBlocks.GREEN_STONY_SCHROOM_DEPOT, Blocks.STONE.asItem()));
        addDrop(ModBlocks.RHYOLITE);
        addDrop(ModBlocks.RHYOLITE_TILES);
        addDrop(ModBlocks.LAVA_BLACKSTONE);

        //Mushrooms
        addDrop(ModBlocks.PURPLE_MUSHROOM);
        addDrop(ModBlocks.GREEN_MUSHROOM);
        addDrop(ModBlocks.BLUE_MUSHROOM);
        addDrop(ModBlocks.BLUE_LUMINESCENT_MUSHROOM);
        addDrop(ModBlocks.LUMINESCENT_PINK_MUSHROOM);
        addDrop(ModBlocks.FERTILE_RED_MUSHROOM);

        addDrop(ModBlocks.TRANSPARENT_MUSHROOM_STEM);
        addDrop(ModBlocks.GREEN_MUSHROOM_STEM);
        addDrop(ModBlocks.MUSHROOM_FLOWERS);
        addDrop(ModBlocks.ORANGE_MUSHROOM);
        addDrop(ModBlocks.YELLOW_MUSHROOM);
        addDrop(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK);

        //Flowers Mushrooms
        addDrop(ModBlocks.STERILE_BLUE_MUSHROOM);
        addDrop(ModBlocks.MUSHROOM_SMALL_BROWN);
        addDrop(ModBlocks.MUSHROOM_SMALL_RED);
        addDrop(ModBlocks.MUSHROOM_DEATH_TRUMPET);
        addDrop(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT);
        addDrop(ModBlocks.LOG_MUSHROOM_BROWN);

        //Flowers
        addDrop(ModBlocks.MUSHROOM_FLOWERS);
        addDrop(ModBlocks.RED_LUMERIA);
        addDrop(ModBlocks.SOL_OCCIDENTIS);
        addDrop(ModBlocks.CYANUS_RUBENS);
        addDrop(ModBlocks.CYANEA);
        addDrop(ModBlocks.CYANUS_RUBENS);
        addDrop(ModBlocks.FUTIALI);
        addDrop(ModBlocks.NOCTULICA);
        addDrop(ModBlocks.TURQUOSUM_STILUS);
        addDrop(ModBlocks.SAPHIRA_FLORENS);
        addDrop(ModBlocks.PREHISTORIC_ROSE);
        addDrop(ModBlocks.YELLOW_QUINCE);
        addDrop(ModBlocks.RED_QUINCE);
        addDrop(ModBlocks.ORANGE_PERENNIAL);
        addDrop(ModBlocks.BLUE_PERENNIAL);
        addDrop(ModBlocks.PURPLE_PERENNIAL);
        addDrop(ModBlocks.LUMINESCENT_PERENNIAL);
        addDrop(ModBlocks.PINK_PERENNIAL);
        addDrop(ModBlocks.GREEN_PERENNIAL);
        addDrop(ModBlocks.YELLOW_PERENNIAL);
        addDrop(ModBlocks.TINY_LILAC);
        addDrop(ModBlocks.YELICE);
        addDrop(ModBlocks.FLAMESTHYSIA);
        addDrop(ModBlocks.APAGANTHE);
        addDrop(ModBlocks.PINK_HEATER);
        addDrop(ModBlocks.WYSTERIA);
        addDrop(ModBlocks.BLUEBELL);
        addDrop(ModBlocks.VIPERIN);
        addDrop(ModBlocks.HIBISCUS);
        addDrop(ModBlocks.PLATUM);
        addDrop(ModBlocks.DIANTHUS);
        addDrop(ModBlocks.CYCAS);
        addDrop(ModBlocks.ARUM);
        addDrop(ModBlocks.HYDRANGEA);
        addDrop(ModBlocks.ANEMONE);
        addDrop(ModBlocks.JACYNTHE);
        addDrop(ModBlocks.ACONIT);
        addDrop(ModBlocks.PERVENCHE);
        addDrop(ModBlocks.OCULAE);
        addDrop(ModBlocks.PICK_BLUE);

        addDrop(ModBlocks.RAPANGE_FLOWERS);
        addDrop(ModBlocks.FLEUR_BERRIES);

        //Grass
        addDrop(ModBlocks.TINY_GRASS);

        //Vines
        addDrop(ModBlocks.PINK_MUSHROOM_VINES, ModItems.PINK_MUSHROOM_VINES_ITEM);
        addDrop(ModBlocks.PINK_MUSHROOM_VINES_PLANT, ModItems.PINK_MUSHROOM_VINES_ITEM);
        addDrop(ModBlocks.CAERULEA_VOLUBILIS);
        addDrop(ModBlocks.BLUE_LUMINESCENT_VINES);

        //Big Mushrooms
        addDrop(ModBlocks.TINY_PURPLE_MUSHROOM);
        addDrop(ModBlocks.LITTLE_PURPLE_MUSHROOM);
        addDrop(ModBlocks.MEDIUM_PURPLE_MUSHROOM);
        addDrop(ModBlocks.BIG_PURPLE_MUSHROOM);

        addDrop(ModBlocks.TINY_GREEN_MUSHROOM);
        addDrop(ModBlocks.LITTLE_GREEN_MUSHROOM);
        addDrop(ModBlocks.MEDIUM_GREEN_MUSHROOM);
        addDrop(ModBlocks.BIG_GREEN_MUSHROOM);

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT).properties(StatePredicate.Builder.create().exactMatch(BigMushroomPlant.AGE, 3));
        addDrop(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT, cropDrops(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT, ModItems.PURPLE_MUSHROOM_POWDER, ModItems.BIG_PURPLE_MUSHROOM_SEED, builder));

        //Potted Flowers
        addPottedPlantDrops(ModBlocks.POTTED_BLUE_LUMINESCENT_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_GREEN_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_PURPLE_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_BLUE_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_LUMINESCENT_PINK_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_OCULAE);
        addPottedPlantDrops(ModBlocks.POTTED_SOL_OCCIDENTIS);
        addPottedPlantDrops(ModBlocks.POTTED_CYANUS_RUBENS);
        addPottedPlantDrops(ModBlocks.POTTED_CYANEA);
        addPottedPlantDrops(ModBlocks.POTTED_FUTIALI);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTORIC_ROSE);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTURPLE_SCHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTO_BLUE_SCHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTO_GREEN_SCHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTO_PINK_SCHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_ORANGE_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_BLUE_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_YELLOW_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_PURPLE_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_LUMINESCENT_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_PINK_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_GREEN_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_RED_QUINCE);
        addPottedPlantDrops(ModBlocks.POTTED_YELLOW_QUINCE);
        addPottedPlantDrops(ModBlocks.POTTED_YELICE);
        addPottedPlantDrops(ModBlocks.POTTED_FLAMESTHYSIA);
        addPottedPlantDrops(ModBlocks.POTTED_APAGANTHE);
        addPottedPlantDrops(ModBlocks.POTTED_WYSTERIA);
        addPottedPlantDrops(ModBlocks.POTTED_BLUEBELL);
        addPottedPlantDrops(ModBlocks.POTTED_VIPERIN);
        addPottedPlantDrops(ModBlocks.POTTED_HIBISCUS);
        addPottedPlantDrops(ModBlocks.POTTED_PLATUM);
        addPottedPlantDrops(ModBlocks.POTTED_DIANTHUS);
        addPottedPlantDrops(ModBlocks.POTTED_CYCAS);
        addPottedPlantDrops(ModBlocks.POTTED_ARUM);
        addPottedPlantDrops(ModBlocks.POTTED_HYDRANGEA);
        addPottedPlantDrops(ModBlocks.POTTED_ANEMONE);
        addPottedPlantDrops(ModBlocks.POTTED_JACYNTHE);
        addPottedPlantDrops(ModBlocks.POTTED_YELLOW_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_ORANGE_MUSHROOM);

        //Potted Flowers Mushrooms
        addPottedPlantDrops(ModBlocks.POTTED_STERILE_BLUE_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_MUSHROOM_SMALL_BROWN);
        addPottedPlantDrops(ModBlocks.POTTED_MUSHROOM_SMALL_RED);


        //Light Blocks
        addDrop(ModBlocks.RED_LANTERN);
        addDrop(ModBlocks.GREEN_LANTERN);
        addDrop(ModBlocks.GREEN_TORCH);

        //Construction Blocks
        addDrop(ModBlocks.LAVA_BLACKSTONE_BRICKS);
        addDrop(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);
        addDrop(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS);

        //wood
        addDrop(ModBlocks.BLUE_LUMINESCENT_LOG);
        addDrop(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG);
        addDrop(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD);
        addDrop(ModBlocks.BLUE_LUMINESCENT_WOOD);
        addDrop(ModBlocks.BLUE_LUMINESCENT_PLANKS);
        addDrop(ModBlocks.BLUE_LUMINESCENT_DOOR, doorDrops(ModBlocks.BLUE_LUMINESCENT_DOOR));
        addDrop(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR);
        addDrop(ModBlocks.BLUE_LUMINESCENT_BUTTON);
        addDrop(ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE);
        addDrop(ModBlocks.BLUE_LUMINESCENT_STAIRS);
        addDrop(ModBlocks.BLUE_LUMINESCENT_SLAB, slabDrops(ModBlocks.BLUE_LUMINESCENT_SLAB));
        addDrop(ModBlocks.BLUE_LUMINESCENT_FENCE);
        addDrop(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE);
        addDrop(ModBlocks.BLUE_LUMINESCENT_SAPPLING);
        addDrop(ModBlocks.OAK_BERRIES_SAPLING);


        addDrop(ModBlocks.PELTOGYNE_LOG);
        addDrop(ModBlocks.PELTOGYNE_WOOD);
        addDrop(ModBlocks.PELTOGYNE_STRIPPED_LOG);
        addDrop(ModBlocks.PELTOGYNE_STRIPPED_WOOD);
        addDrop(ModBlocks.PELTOGYNE_PLANKS);
        addDrop(ModBlocks.PELTOGYNE_STAIRS);
        addDrop(ModBlocks.PELTOGYNE_SLAB);
        addDrop(ModBlocks.PELTOGYNE_FENCE);
        addDrop(ModBlocks.PELTOGYNE_FENCE_GATE);
        addDrop(ModBlocks.PELTOGYNE_DOOR);
        addDrop(ModBlocks.PELTOGYNE_TRAPDOOR);
        addDrop(ModBlocks.PELTOGYNE_PRESSURE_PLATE);
        addDrop(ModBlocks.PELTOGYNE_BUTTON);
        addDrop(ModBlocks.PELTOGYNE_SAPLING);

        addDrop(ModBlocks.COLORFUL_TREE_SAPLING);


        //Leaves
        addDrop(ModBlocks.BLUE_LUMINESCENT_LEAVES, leavesDrops(ModBlocks.BLUE_LUMINESCENT_LEAVES, ModBlocks.BLUE_LUMINESCENT_SAPPLING, 0.025f));
        addDrop(ModBlocks.RED_COLORFUL_LEAVES, leavesDrops(ModBlocks.RED_COLORFUL_LEAVES, ModBlocks.COLORFUL_TREE_SAPLING, 0.025f));
        addDrop(ModBlocks.BLUE_COLORFUL_LEAVES, leavesDrops(ModBlocks.BLUE_COLORFUL_LEAVES, ModBlocks.COLORFUL_TREE_SAPLING, 0.025f));
        addDrop(ModBlocks.ORANGE_COLORFUL_LEAVES, leavesDrops(ModBlocks.ORANGE_COLORFUL_LEAVES, ModBlocks.COLORFUL_TREE_SAPLING, 0.025f));
        addDrop(ModBlocks.YELLOW_COLORFUL_LEAVES, leavesDrops(ModBlocks.YELLOW_COLORFUL_LEAVES, ModBlocks.COLORFUL_TREE_SAPLING, 0.025f));
        addDrop(ModBlocks.PURPLE_COLORFUL_LEAVES, leavesDrops(ModBlocks.PURPLE_COLORFUL_LEAVES, ModBlocks.COLORFUL_TREE_SAPLING, 0.025f));
        addDrop(ModBlocks.GREEN_COLORFUL_LEAVES, leavesDrops(ModBlocks.GREEN_COLORFUL_LEAVES, ModBlocks.COLORFUL_TREE_SAPLING, 0.025f));
        addDrop(ModBlocks.PINK_COLORFUL_LEAVES, leavesDrops(ModBlocks.PINK_COLORFUL_LEAVES, ModBlocks.COLORFUL_TREE_SAPLING, 0.025f));
        addDrop(ModBlocks.OAK_BERRIES_LEAVES, leavesDrops(ModBlocks.OAK_BERRIES_LEAVES, ModBlocks.OAK_BERRIES_SAPLING, 0.025f));
        addDrop(ModBlocks.PELTOGYNE_LEAVES, leavesDrops(ModBlocks.PELTOGYNE_LEAVES, ModBlocks.PELTOGYNE_SAPLING, 0.025f));

        //Crystals
        addDropWithSilkTouch(Block.getBlockFromItem(ModItems.PINK_CRYSTAL_ITEM), ModBlocks.PINK_CRYSTAL);
        addDrop(ModBlocks.PINK_CRYSTAL_BLOCK);
        addDrop(ModBlocks.BLUE_CRYSTAL);
        addDrop(ModBlocks.RED_CRYSTAL);
        addDrop(ModBlocks.RED_CRYSTAL_BLOCK);
        addDrop(ModBlocks.BLUE_CRYSTAL_BLOCK);
        addDrop(ModBlocks.WHITE_CRYSTAL_BLOCK);
        addDrop(ModBlocks.WHITE_CRYSTAL);

        addDrop(ModBlocks.AMBER_BLOCK);
        addDrop(ModBlocks.AMBER_MINERAL);
        addDrop(ModBlocks.RAW_AMBER_BLOCK);
        addDrop(ModBlocks.AMBER_BLOCK_SANDIFIED);
        addDrop(ModBlocks.AMBER_ORE, oreDrops(ModBlocks.AMBER_ORE, ModItems.AMBER_ITEM));

        //Utils
        addDrop(ModBlocks.FORGE_BLOCK);

        //Idk
        addDrop(ModBlocks.CLOUD_BLOCK);
    }
}
