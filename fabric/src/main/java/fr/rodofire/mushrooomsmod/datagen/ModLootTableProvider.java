package fr.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.block.custom.bigmushroom.BigMushroomPlant;
import fr.rodofire.mushrooomsmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {


    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //Blocks
        //Mushroom
        dropSelf(ModBlocks.PURPLE_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK.get());


        dropSelf(ModBlocks.ORANGE_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK.get());

        dropSelf(ModBlocks.YELLOW_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK.get());

        dropSelf(ModBlocks.BLUE_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK.get());

        dropSelf(ModBlocks.GREEN_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK.get());

        dropSelf(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK.get());

        dropSelf(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK.get());

        dropSelf(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK.get());

        dropSelf(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK.get());
        dropSelf(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK.get());

        //Mushroom related
        dropSelf(ModBlocks.GREEN_MUSHROOM_STEM.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM.get());
        dropSelf(ModBlocks.TRANSPARENT_MUSHROOM_STEM.get());
        dropSelf(ModBlocks.COMPRESSED_PURPLE_MUSHROOM.get());

        //Soft Blocks
        dropSelf(ModBlocks.COMPRESSED_DIRT.get());
        dropSelf(ModBlocks.LIGHT_COMPRESSED_DIRT.get());

        //Hard Blocks
        add(ModBlocks.PURPLE_SCHROOM_DEESLATE.get(), createOreDrop(ModBlocks.PURPLE_SCHROOM_DEESLATE.get(), Blocks.DEEPSLATE.asItem()));
        add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE.get(), createOreDrop(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE.get(), Blocks.DEEPSLATE.asItem()));
        add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT.get(), createOreDrop(ModBlocks.GREEN_STONY_SCHROOM_DEPOT.get(), Blocks.STONE.asItem()));
        dropSelf(ModBlocks.RHYOLITE.get());
        dropSelf(ModBlocks.RHYOLITE_TILES.get());
        dropSelf(ModBlocks.LAVA_BLACKSTONE.get());

        //Mushrooms
        dropSelf(ModBlocks.PURPLE_MUSHROOM.get());
        dropSelf(ModBlocks.GREEN_MUSHROOM.get());
        dropSelf(ModBlocks.BLUE_MUSHROOM.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_MUSHROOM.get());
        dropSelf(ModBlocks.LUMINESCENT_PINK_MUSHROOM.get());
        dropSelf(ModBlocks.FERTILE_RED_MUSHROOM.get());

        dropSelf(ModBlocks.TRANSPARENT_MUSHROOM_STEM.get());
        dropSelf(ModBlocks.GREEN_MUSHROOM_STEM.get());
        dropSelf(ModBlocks.MUSHROOM_FLOWERS.get());
        dropSelf(ModBlocks.ORANGE_MUSHROOM.get());
        dropSelf(ModBlocks.YELLOW_MUSHROOM.get());
        dropSelf(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK.get());

        //Flowers Mushrooms
        dropSelf(ModBlocks.STERILE_BLUE_MUSHROOM.get());
        dropSelf(ModBlocks.MUSHROOM_SMALL_BROWN.get());
        dropSelf(ModBlocks.MUSHROOM_SMALL_RED.get());
        dropSelf(ModBlocks.MUSHROOM_DEATH_TRUMPET.get());
        dropSelf(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT.get());
        dropSelf(ModBlocks.LOG_MUSHROOM_BROWN.get());

        //Flowers
        dropSelf(ModBlocks.MUSHROOM_FLOWERS.get());
        dropSelf(ModBlocks.RED_LUMERIA.get());
        dropSelf(ModBlocks.BRIGHT_YELLOW_MUSHROOM.get());
        dropSelf(ModBlocks.BUSHY_YELLOW_MUSHROOM.get());
        dropSelf(ModBlocks.TALL_YELLOW_MUSHROOMS.get());
        dropSelf(ModBlocks.SOL_OCCIDENTIS.get());
        dropSelf(ModBlocks.CYANUS_RUBENS.get());
        dropSelf(ModBlocks.CYANEA.get());
        dropSelf(ModBlocks.CYANUS_RUBENS.get());
        dropSelf(ModBlocks.FUTIALI.get());
        dropSelf(ModBlocks.NOCTULICA.get());
        dropSelf(ModBlocks.TURQUOSUM_STILUS.get());
        dropSelf(ModBlocks.SAPHIRA_FLORENS.get());
        dropSelf(ModBlocks.PREHISTORIC_ROSE.get());
        dropSelf(ModBlocks.YELLOW_QUINCE.get());
        dropSelf(ModBlocks.RED_QUINCE.get());
        dropSelf(ModBlocks.ORANGE_PERENNIAL.get());
        dropSelf(ModBlocks.BLUE_PERENNIAL.get());
        dropSelf(ModBlocks.PURPLE_PERENNIAL.get());
        dropSelf(ModBlocks.LUMINESCENT_PERENNIAL.get());
        dropSelf(ModBlocks.PINK_PERENNIAL.get());
        dropSelf(ModBlocks.GREEN_PERENNIAL.get());
        dropSelf(ModBlocks.YELLOW_PERENNIAL.get());
        dropSelf(ModBlocks.TINY_LILAC.get());
        dropSelf(ModBlocks.YELICE.get());
        dropSelf(ModBlocks.FLAMESTHYSIA.get());
        dropSelf(ModBlocks.APAGANTHE.get());
        dropSelf(ModBlocks.PINK_HEATER.get());
        dropSelf(ModBlocks.WYSTERIA.get());
        dropSelf(ModBlocks.BLUEBELL.get());
        dropSelf(ModBlocks.VIPERIN.get());
        dropSelf(ModBlocks.HIBISCUS.get());
        dropSelf(ModBlocks.PLATUM.get());
        dropSelf(ModBlocks.DIANTHUS.get());
        dropSelf(ModBlocks.CYCAS.get());
        dropSelf(ModBlocks.ARUM.get());
        dropSelf(ModBlocks.HYDRANGEA.get());
        dropSelf(ModBlocks.ANEMONE.get());
        dropSelf(ModBlocks.JACYNTHE.get());
        dropSelf(ModBlocks.ACONIT.get());
        dropSelf(ModBlocks.PERVENCHE.get());
        dropSelf(ModBlocks.OCULAE.get());
        dropSelf(ModBlocks.PICK_BLUE.get());

        dropSelf(ModBlocks.RAPANGE_FLOWERS.get());
        dropSelf(ModBlocks.FLEUR_BERRIES.get());

        //Grass
        dropSelf(ModBlocks.TINY_GRASS.get());

        //Vines
        dropOther(ModBlocks.PINK_MUSHROOM_VINES.get(), ModItems.PINK_MUSHROOM_VINES_ITEM.get());
        dropOther(ModBlocks.PINK_MUSHROOM_VINES_PLANT.get(), ModItems.PINK_MUSHROOM_VINES_ITEM.get());
        dropSelf(ModBlocks.CAERULEA_VOLUBILIS.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_VINES.get());

        //Big Mushrooms
        dropSelf(ModBlocks.TINY_PURPLE_MUSHROOM.get());
        dropSelf(ModBlocks.LITTLE_PURPLE_MUSHROOM.get());
        dropSelf(ModBlocks.MEDIUM_PURPLE_MUSHROOM.get());
        dropSelf(ModBlocks.BIG_PURPLE_MUSHROOM.get());

        dropSelf(ModBlocks.TINY_GREEN_MUSHROOM.get());
        dropSelf(ModBlocks.LITTLE_GREEN_MUSHROOM.get());
        dropSelf(ModBlocks.MEDIUM_GREEN_MUSHROOM.get());
        dropSelf(ModBlocks.BIG_GREEN_MUSHROOM.get());

        LootItemBlockStatePropertyCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BigMushroomPlant.AGE, 3));
        add(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get(), createCropDrops(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get(), ModItems.PURPLE_MUSHROOM_POWDER.get(), ModItems.BIG_PURPLE_MUSHROOM_SEED.get(), builder));

        //Potted Flowers
        dropPottedContents(ModBlocks.POTTED_BLUE_LUMINESCENT_MUSHROOM.get());
        dropPottedContents(ModBlocks.POTTED_GREEN_MUSHROOM.get());
        dropPottedContents(ModBlocks.POTTED_PURPLE_MUSHROOM.get());
        dropPottedContents(ModBlocks.POTTED_BLUE_MUSHROOM.get());
        dropPottedContents(ModBlocks.POTTED_LUMINESCENT_PINK_MUSHROOM.get());
        dropPottedContents(ModBlocks.POTTED_OCULAE.get());
        dropPottedContents(ModBlocks.POTTED_SOL_OCCIDENTIS.get());
        dropPottedContents(ModBlocks.POTTED_CYANUS_RUBENS.get());
        dropPottedContents(ModBlocks.POTTED_CYANEA.get());
        dropPottedContents(ModBlocks.POTTED_FUTIALI.get());
        dropPottedContents(ModBlocks.POTTED_PREHISTORIC_ROSE.get());
        dropPottedContents(ModBlocks.POTTED_PREHISTURPLE_SCHROOM.get());
        dropPottedContents(ModBlocks.POTTED_PREHISTO_BLUE_SCHROOM.get());
        dropPottedContents(ModBlocks.POTTED_PREHISTO_GREEN_SCHROOM.get());
        dropPottedContents(ModBlocks.POTTED_PREHISTO_PINK_SCHROOM.get());
        dropPottedContents(ModBlocks.POTTED_ORANGE_PERENNIAL.get());
        dropPottedContents(ModBlocks.POTTED_BLUE_PERENNIAL.get());
        dropPottedContents(ModBlocks.POTTED_YELLOW_PERENNIAL.get());
        dropPottedContents(ModBlocks.POTTED_PURPLE_PERENNIAL.get());
        dropPottedContents(ModBlocks.POTTED_LUMINESCENT_PERENNIAL.get());
        dropPottedContents(ModBlocks.POTTED_PINK_PERENNIAL.get());
        dropPottedContents(ModBlocks.POTTED_GREEN_PERENNIAL.get());
        dropPottedContents(ModBlocks.POTTED_RED_QUINCE.get());
        dropPottedContents(ModBlocks.POTTED_YELLOW_QUINCE.get());
        dropPottedContents(ModBlocks.POTTED_YELICE.get());
        dropPottedContents(ModBlocks.POTTED_FLAMESTHYSIA.get());
        dropPottedContents(ModBlocks.POTTED_APAGANTHE.get());
        dropPottedContents(ModBlocks.POTTED_WYSTERIA.get());
        dropPottedContents(ModBlocks.POTTED_BLUEBELL.get());
        dropPottedContents(ModBlocks.POTTED_VIPERIN.get());
        dropPottedContents(ModBlocks.POTTED_HIBISCUS.get());
        dropPottedContents(ModBlocks.POTTED_PLATUM.get());
        dropPottedContents(ModBlocks.POTTED_DIANTHUS.get());
        dropPottedContents(ModBlocks.POTTED_CYCAS.get());
        dropPottedContents(ModBlocks.POTTED_ARUM.get());
        dropPottedContents(ModBlocks.POTTED_HYDRANGEA.get());
        dropPottedContents(ModBlocks.POTTED_ANEMONE.get());
        dropPottedContents(ModBlocks.POTTED_JACYNTHE.get());
        dropPottedContents(ModBlocks.POTTED_YELLOW_MUSHROOM.get());
        dropPottedContents(ModBlocks.POTTED_ORANGE_MUSHROOM.get());

        //Potted Flowers Mushrooms
        dropPottedContents(ModBlocks.POTTED_STERILE_BLUE_MUSHROOM.get());
        dropPottedContents(ModBlocks.POTTED_MUSHROOM_SMALL_BROWN.get());
        dropPottedContents(ModBlocks.POTTED_MUSHROOM_SMALL_RED.get());


        //Light Blocks
        dropSelf(ModBlocks.RED_LANTERN.get());
        dropSelf(ModBlocks.GREEN_LANTERN.get());
        dropSelf(ModBlocks.GREEN_TORCH.get());

        //Construction Blocks
        dropSelf(ModBlocks.LAVA_BLACKSTONE_BRICKS.get());
        dropSelf(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS.get());
        dropSelf(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS.get());

        //wood
        dropSelf(ModBlocks.BLUE_LUMINESCENT_LOG.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_WOOD.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_PLANKS.get());
        add(ModBlocks.BLUE_LUMINESCENT_DOOR.get(), createDoorTable(ModBlocks.BLUE_LUMINESCENT_DOOR.get()));
        dropSelf(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_BUTTON.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_STAIRS.get());
        add(ModBlocks.BLUE_LUMINESCENT_SLAB.get(), createSlabItemTable(ModBlocks.BLUE_LUMINESCENT_SLAB.get()));
        dropSelf(ModBlocks.BLUE_LUMINESCENT_FENCE.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE.get());
        dropSelf(ModBlocks.BLUE_LUMINESCENT_SAPPLING.get());
        dropSelf(ModBlocks.OAK_BERRIES_SAPLING.get());


        dropSelf(ModBlocks.PELTOGYNE_LOG.get());
        dropSelf(ModBlocks.PELTOGYNE_WOOD.get());
        dropSelf(ModBlocks.PELTOGYNE_STRIPPED_LOG.get());
        dropSelf(ModBlocks.PELTOGYNE_STRIPPED_WOOD.get());
        dropSelf(ModBlocks.PELTOGYNE_PLANKS.get());
        dropSelf(ModBlocks.PELTOGYNE_STAIRS.get());
        dropSelf(ModBlocks.PELTOGYNE_SLAB.get());
        dropSelf(ModBlocks.PELTOGYNE_FENCE.get());
        dropSelf(ModBlocks.PELTOGYNE_FENCE_GATE.get());
        dropSelf(ModBlocks.PELTOGYNE_DOOR.get());
        dropSelf(ModBlocks.PELTOGYNE_TRAPDOOR.get());
        dropSelf(ModBlocks.PELTOGYNE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PELTOGYNE_BUTTON.get());
        dropSelf(ModBlocks.PELTOGYNE_SAPLING.get());

        dropSelf(ModBlocks.COLORFUL_TREE_SAPLING.get());


        //Leaves
        add(ModBlocks.BLUE_LUMINESCENT_LEAVES.get(), createLeavesDrops(ModBlocks.BLUE_LUMINESCENT_LEAVES.get(), ModBlocks.BLUE_LUMINESCENT_SAPPLING.get(), 0.025f));
        add(ModBlocks.RED_COLORFUL_LEAVES.get(), createLeavesDrops(ModBlocks.RED_COLORFUL_LEAVES.get(), ModBlocks.COLORFUL_TREE_SAPLING.get(), 0.025f));
        add(ModBlocks.BLUE_COLORFUL_LEAVES.get(), createLeavesDrops(ModBlocks.BLUE_COLORFUL_LEAVES.get(), ModBlocks.COLORFUL_TREE_SAPLING.get(), 0.025f));
        add(ModBlocks.ORANGE_COLORFUL_LEAVES.get(), createLeavesDrops(ModBlocks.ORANGE_COLORFUL_LEAVES.get(), ModBlocks.COLORFUL_TREE_SAPLING.get(), 0.025f));
        add(ModBlocks.YELLOW_COLORFUL_LEAVES.get(), createLeavesDrops(ModBlocks.YELLOW_COLORFUL_LEAVES.get(), ModBlocks.COLORFUL_TREE_SAPLING.get(), 0.025f));
        add(ModBlocks.PURPLE_COLORFUL_LEAVES.get(), createLeavesDrops(ModBlocks.PURPLE_COLORFUL_LEAVES.get(), ModBlocks.COLORFUL_TREE_SAPLING.get(), 0.025f));
        add(ModBlocks.GREEN_COLORFUL_LEAVES.get(), createLeavesDrops(ModBlocks.GREEN_COLORFUL_LEAVES.get(), ModBlocks.COLORFUL_TREE_SAPLING.get(), 0.025f));
        add(ModBlocks.PINK_COLORFUL_LEAVES.get(), createLeavesDrops(ModBlocks.PINK_COLORFUL_LEAVES.get(), ModBlocks.COLORFUL_TREE_SAPLING.get(), 0.025f));
        add(ModBlocks.OAK_BERRIES_LEAVES.get(), createLeavesDrops(ModBlocks.OAK_BERRIES_LEAVES.get(), ModBlocks.OAK_BERRIES_SAPLING.get(), 0.025f));
        add(ModBlocks.PELTOGYNE_LEAVES.get(), createLeavesDrops(ModBlocks.PELTOGYNE_LEAVES.get(), ModBlocks.PELTOGYNE_SAPLING.get(), 0.025f));

        //Crystals
        //dropSelf();WithSilkTouch(Block.getBlockFromItem(ModItems.PINK_CRYSTAL_ITEM.get()), ModBlocks.PINK_CRYSTAL.get());
        dropSelf(ModBlocks.PINK_CRYSTAL_BLOCK.get());
        dropSelf(ModBlocks.BLUE_CRYSTAL.get());
        dropSelf(ModBlocks.RED_CRYSTAL.get());
        dropSelf(ModBlocks.RED_CRYSTAL_BLOCK.get());
        dropSelf(ModBlocks.BLUE_CRYSTAL_BLOCK.get());
        dropSelf(ModBlocks.WHITE_CRYSTAL_BLOCK.get());
        dropSelf(ModBlocks.WHITE_CRYSTAL.get());

        dropSelf(ModBlocks.AMBER_BLOCK.get());
        dropSelf(ModBlocks.AMBER_MINERAL.get());
        dropSelf(ModBlocks.RAW_AMBER_BLOCK.get());
        dropSelf(ModBlocks.AMBER_BLOCK_SANDIFIED.get());
        add(ModBlocks.AMBER_ORE.get(), createOreDrop(ModBlocks.AMBER_ORE.get(), ModItems.AMBER_ITEM.get()));

        //Utils
        dropSelf(ModBlocks.FORGE_BLOCK.get());

        //Idk
        dropSelf(ModBlocks.CLOUD_BLOCK.get());
    }
}
