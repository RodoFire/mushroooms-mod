package fr.rodofire.mushrooomsmod.datagen;

import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        /*-------------------- Tools Minable --------------------*/
        //Pickaxe
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE.get())
                .add(ModBlocks.PURPLE_SCHROOM_DEESLATE.get())
                .add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT.get())
                .add(ModBlocks.RED_LANTERN.get())
                .add(ModBlocks.GREEN_LANTERN.get())
                .add(ModBlocks.GREEN_CAMPFIRE.get())
                .add(ModBlocks.RHYOLITE.get())
                .add(ModBlocks.RHYOLITE_TILES.get())
                .add(ModBlocks.LAVA_BLACKSTONE_BRICKS.get())
                .add(ModBlocks.LAVA_BLACKSTONE.get())
                .add(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS.get())
                .add(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS.get())
                //.add(ModBlocks.PINK_CRYSTAL.get())
                .add(ModBlocks.PINK_CRYSTAL_BLOCK.get())
                .add(ModBlocks.AMBER_BLOCK.get())
                .add(ModBlocks.RAW_AMBER_BLOCK.get())
                .add(ModBlocks.AMBER_ORE.get())
                .add(ModBlocks.AMBER_MINERAL.get())
                .add(ModBlocks.AMBER_BLOCK_SANDIFIED.get())
                .add(ModBlocks.BLUE_CRYSTAL.get())
                .add(ModBlocks.BLUE_CRYSTAL_BLOCK.get())
                .add(ModBlocks.RED_CRYSTAL.get())
                .add(ModBlocks.RED_CRYSTAL_BLOCK.get())
                .add(ModBlocks.WHITE_CRYSTAL_BLOCK.get())
                .add(ModBlocks.WHITE_CRYSTAL.get());

        //Shovel
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.COMPRESSED_PURPLE_MUSHROOM.get())
                .add(ModBlocks.COMPRESSED_DIRT.get())
                .add(ModBlocks.LIGHT_COMPRESSED_DIRT.get());

        //Axe
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BLUE_MUSHROOM_BLOCK.get())
                .add(ModBlocks.PURPLE_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK.get())
                .add(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK.get())
                .add(ModBlocks.GREEN_MUSHROOM_BLOCK.get())
                .add(ModBlocks.YELLOW_MUSHROOM_BLOCK.get())
                .add(ModBlocks.ORANGE_MUSHROOM_BLOCK.get())


                .add(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK.get())

                .add(ModBlocks.ORANGE_MUSHROOM_BLOCK.get())
                .add(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK.get())

                .add(ModBlocks.YELLOW_MUSHROOM_BLOCK.get())
                .add(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK.get())

                .add(ModBlocks.BLUE_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK.get())

                .add(ModBlocks.GREEN_MUSHROOM_BLOCK.get())
                .add(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK.get())

                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK.get())

                .add(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK.get())
                .add(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK.get())


                .add(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK.get())

                .add(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK.get())


                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM.get())
                .add(ModBlocks.GREEN_MUSHROOM_STEM.get())
                .add(ModBlocks.TRANSPARENT_MUSHROOM_STEM.get())

                .add(ModBlocks.BLUE_LUMINESCENT_LOG.get())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get())
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD.get())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get())
                .add(ModBlocks.BLUE_LUMINESCENT_PLANKS.get())
                .add(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR.get())
                .add(ModBlocks.BLUE_LUMINESCENT_DOOR.get())
                .add(ModBlocks.BLUE_LUMINESCENT_BUTTON.get())
                .add(ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE.get())
                .add(ModBlocks.BLUE_LUMINESCENT_STAIRS.get())
                .add(ModBlocks.BLUE_LUMINESCENT_SLAB.get())
                .add(ModBlocks.BLUE_LUMINESCENT_FENCE.get())
                .add(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE.get())


                .add(ModBlocks.PELTOGYNE_LOG.get())
                .add(ModBlocks.PELTOGYNE_WOOD.get())
                .add(ModBlocks.PELTOGYNE_STRIPPED_LOG.get())
                .add(ModBlocks.PELTOGYNE_STRIPPED_WOOD.get())
                .add(ModBlocks.PELTOGYNE_PLANKS.get())
                .add(ModBlocks.PELTOGYNE_STAIRS.get())
                .add(ModBlocks.PELTOGYNE_SLAB.get())
                .add(ModBlocks.PELTOGYNE_FENCE.get())
                .add(ModBlocks.PELTOGYNE_FENCE_GATE.get())
                .add(ModBlocks.PELTOGYNE_DOOR.get())
                .add(ModBlocks.PELTOGYNE_TRAPDOOR.get())
                .add(ModBlocks.PELTOGYNE_PRESSURE_PLATE.get())
                .add(ModBlocks.PELTOGYNE_BUTTON.get());

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.BLUE_LUMINESCENT_LEAVES.get())
                .add(ModBlocks.RED_COLORFUL_LEAVES.get())
                .add(ModBlocks.YELLOW_COLORFUL_LEAVES.get())
                .add(ModBlocks.BLUE_COLORFUL_LEAVES.get())
                .add(ModBlocks.PURPLE_COLORFUL_LEAVES.get())
                .add(ModBlocks.ORANGE_COLORFUL_LEAVES.get())
                .add(ModBlocks.GREEN_COLORFUL_LEAVES.get())
                .add(ModBlocks.OAK_BERRIES_LEAVES.get())
                .add(ModBlocks.PELTOGYNE_LEAVES.get())
                .add(ModBlocks.PINK_COLORFUL_LEAVES.get());


        /*-------------------- Natural Blocks --------------------*/
        //Leaves
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.BLUE_LUMINESCENT_LEAVES.get())
                .add(ModBlocks.RED_COLORFUL_LEAVES.get())
                .add(ModBlocks.YELLOW_COLORFUL_LEAVES.get())
                .add(ModBlocks.BLUE_COLORFUL_LEAVES.get())
                .add(ModBlocks.PURPLE_COLORFUL_LEAVES.get())
                .add(ModBlocks.ORANGE_COLORFUL_LEAVES.get())
                .add(ModBlocks.GREEN_COLORFUL_LEAVES.get())
                .add(ModBlocks.OAK_BERRIES_LEAVES.get())
                .add(ModBlocks.PELTOGYNE_LEAVES.get())
                .add(ModBlocks.PINK_COLORFUL_LEAVES.get());

        //Mushroom Plant
        getOrCreateTagBuilder(ModTags.Blocks.MUSHROOM_PLANT)
                .add(ModBlocks.YELLOW_MUSHROOM.get())
                .add(ModBlocks.PURPLE_MUSHROOM.get())
                .add(ModBlocks.ORANGE_MUSHROOM.get())
                .add(ModBlocks.BLUE_MUSHROOM.get())
                .add(ModBlocks.GREEN_MUSHROOM.get())
                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM.get())
                .add(ModBlocks.LUMINESCENT_PINK_MUSHROOM.get())
                .add(Blocks.RED_MUSHROOM)
                .add(Blocks.BROWN_MUSHROOM)
                .add(ModBlocks.FERTILE_RED_MUSHROOM.get())

                .add(ModBlocks.STERILE_BLUE_MUSHROOM.get())
                .add(ModBlocks.MUSHROOM_SMALL_BROWN.get())
                .add(ModBlocks.MUSHROOM_SMALL_RED.get())
                .add(ModBlocks.MUSHROOM_DEATH_TRUMPET.get())
                .add(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT.get())

                .add(ModBlocks.PREHISTO_BLUE_SCHROOM.get())
                .add(ModBlocks.PREHISTO_GREEN_SCHROOM.get())
                .add(ModBlocks.PREHISTO_PINK_SCHROOM.get())
                .add(ModBlocks.PREHISTURPLE_SCHROOM.get());

        //Flowers
        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.YELLOW_MUSHROOM.get())
                .add(ModBlocks.PURPLE_MUSHROOM.get())
                .add(ModBlocks.ORANGE_MUSHROOM.get())
                .add(ModBlocks.BLUE_MUSHROOM.get())
                .add(ModBlocks.GREEN_MUSHROOM.get())
                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM.get())
                .add(ModBlocks.LUMINESCENT_PINK_MUSHROOM.get())
                .add(Blocks.RED_MUSHROOM)
                .add(Blocks.BROWN_MUSHROOM)
                .add(ModBlocks.FERTILE_RED_MUSHROOM.get())

                .add(ModBlocks.STERILE_BLUE_MUSHROOM.get())
                .add(ModBlocks.MUSHROOM_SMALL_BROWN.get())
                .add(ModBlocks.MUSHROOM_SMALL_RED.get())
                .add(ModBlocks.MUSHROOM_DEATH_TRUMPET.get())
                .add(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT.get())

                .add(ModBlocks.PREHISTO_BLUE_SCHROOM.get())
                .add(ModBlocks.PREHISTO_GREEN_SCHROOM.get())
                .add(ModBlocks.PREHISTO_PINK_SCHROOM.get())
                .add(ModBlocks.PREHISTURPLE_SCHROOM.get())

                .add(ModBlocks.RED_LUMERIA.get())
                .add(ModBlocks.MUSHROOM_FLOWERS.get())

                .add(ModBlocks.SOL_OCCIDENTIS.get())
                .add(ModBlocks.CYANUS_RUBENS.get())
                .add(ModBlocks.CYANEA.get())
                .add(ModBlocks.FUTIALI.get())
                .add(ModBlocks.NOCTULICA.get())
                .add(ModBlocks.TURQUOSUM_STILUS.get())
                .add(ModBlocks.SAPHIRA_FLORENS.get())
                .add(ModBlocks.PREHISTORIC_ROSE.get())
                .add(ModBlocks.ORANGE_PERENNIAL.get())
                .add(ModBlocks.BLUE_PERENNIAL.get())
                .add(ModBlocks.GREEN_PERENNIAL.get())
                .add(ModBlocks.PINK_PERENNIAL.get())
                .add(ModBlocks.LUMINESCENT_PERENNIAL.get())
                .add(ModBlocks.PURPLE_PERENNIAL.get())
                .add(ModBlocks.YELLOW_PERENNIAL.get())
                .add(ModBlocks.YELLOW_QUINCE.get())
                .add(ModBlocks.RED_QUINCE.get())
                .add(ModBlocks.TINY_LILAC.get())
                .add(ModBlocks.OCULAE.get())
                .add(ModBlocks.YELICE.get())
                .add(ModBlocks.FLAMESTHYSIA.get())
                .add(ModBlocks.APAGANTHE.get())
                .add(ModBlocks.PINK_HEATER.get())
                .add(ModBlocks.WYSTERIA.get())
                .add(ModBlocks.BLUEBELL.get())
                .add(ModBlocks.VIPERIN.get())
                .add(ModBlocks.HIBISCUS.get())
                .add(ModBlocks.PLATUM.get())
                .add(ModBlocks.DIANTHUS.get())
                .add(ModBlocks.CYCAS.get())
                .add(ModBlocks.ARUM.get())
                .add(ModBlocks.HYDRANGEA.get())
                .add(ModBlocks.ANEMONE.get())
                .add(ModBlocks.JACYNTHE.get())
                .add(ModBlocks.ACONIT.get())
                .add(ModBlocks.PERVENCHE.get())
                .add(ModBlocks.PICK_BLUE.get())

                //Vines
                .add(ModBlocks.CAERULEA_VOLUBILIS.get())
                .add(ModBlocks.PINK_MUSHROOM_VINES.get())
                .add(ModBlocks.PINK_MUSHROOM_VINES_PLANT.get())
                .add(ModBlocks.PINK_LUMINESCENT_BODY_VINES.get())
                .add(ModBlocks.PINK_LUMINESCENT_HEAD_VINES.get())
                .add(ModBlocks.BLUE_LUMINESCENT_VINES.get())

                .add(ModBlocks.TINY_GREEN_MUSHROOM.get())
                .add(ModBlocks.LITTLE_GREEN_MUSHROOM.get())
                .add(ModBlocks.MEDIUM_GREEN_MUSHROOM.get())
                .add(ModBlocks.BIG_GREEN_MUSHROOM.get())
                .add(ModBlocks.BIG_GREEN_MUSHROOM_PLANT.get())
                .add(ModBlocks.TINY_PURPLE_MUSHROOM.get())
                .add(ModBlocks.LITTLE_PURPLE_MUSHROOM.get())
                .add(ModBlocks.MEDIUM_PURPLE_MUSHROOM.get())
                .add(ModBlocks.BIG_PURPLE_MUSHROOM.get())
                .add(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get());

        getOrCreateTagBuilder(ModTags.Blocks.GRASS)
                .add(Blocks.SHORT_GRASS)
                .add(Blocks.TALL_GRASS)
                .add(ModBlocks.TINY_GRASS.get())
                .add(ModBlocks.BLUE_LUMINESCENT_GRASS.get())
                .add(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS.get());

        //Dirt
        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE.get())
                .add(ModBlocks.PURPLE_SCHROOM_DEESLATE.get())
                .add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT.get());

        //Mushroom Grow Blocks
        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE.get())
                .add(ModBlocks.PURPLE_SCHROOM_DEESLATE.get())
                .add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT.get());

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.BLUE_LUMINESCENT_SAPPLING.get())
                .add(ModBlocks.COLORFUL_TREE_SAPLING.get())
                .add(ModBlocks.PELTOGYNE_SAPLING.get());


        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ModBlocks.CAERULEA_VOLUBILIS.get())
                .add(ModBlocks.BLUE_LUMINESCENT_VINES.get());


        /*-------------------- Construction Blocks --------------------*/
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.BLUE_LUMINESCENT_FENCE.get())
                .add(ModBlocks.PELTOGYNE_FENCE.get());

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE.get())
                .add(ModBlocks.PELTOGYNE_FENCE_GATE.get());

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_LUMINESCENT_LOG.get())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get())
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD.get())

                .add(ModBlocks.PELTOGYNE_LOG.get())
                .add(ModBlocks.PELTOGYNE_WOOD.get())
                .add(ModBlocks.PELTOGYNE_STRIPPED_LOG.get())
                .add(ModBlocks.PELTOGYNE_STRIPPED_WOOD.get())
                .add(ModBlocks.PELTOGYNE_PLANKS.get());

        getOrCreateTagBuilder(ModTags.Blocks.MUSHROOM_SPAWNABLE)
                .add(Blocks.MYCELIUM)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.DIRT)
                .add(Blocks.ROOTED_DIRT);

        getOrCreateTagBuilder(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.MOSSY_COBBLESTONE)
                .add(Blocks.COBBLED_DEEPSLATE);

        getOrCreateTagBuilder(ModTags.Blocks.ROCKY_STALACTITE_BASE)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.MOSSY_COBBLESTONE)
                .add(Blocks.TUFF)
                .add(Blocks.STONE);

        getOrCreateTagBuilder(ModTags.Blocks.ROCKY_STALACTITE_TOP)
                .add(Blocks.COBBLESTONE_WALL)
                .add(Blocks.MOSSY_COBBLESTONE_WALL)
                .add(Blocks.ANDESITE_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.MOSSY_STALACTITE_BASE)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.MOSSY_COBBLESTONE)
                .add(Blocks.TUFF)
                .add(Blocks.STONE)
                .add(Blocks.MOSS_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.MOSSY_STALACTITE_TOP)
                .add(Blocks.COBBLESTONE_WALL)
                .add(Blocks.MOSSY_COBBLESTONE_WALL)
                .add(Blocks.ANDESITE_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.FLUIDS)
                .add(Blocks.WATER)
                .add(Blocks.LAVA);
    }
}
