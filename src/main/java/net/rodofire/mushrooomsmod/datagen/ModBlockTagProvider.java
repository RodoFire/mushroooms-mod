package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        /*-------------------- Tools Minable --------------------*/
        //Pickaxe
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE)
                .add(ModBlocks.PURPLE_SCHROOM_DEESLATE)
                .add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT)
                .add(ModBlocks.RED_LANTERN)
                .add(ModBlocks.GREEN_LANTERN)
                .add(ModBlocks.GREEN_CAMPFIRE)
                .add(ModBlocks.RHYOLITE)
                .add(ModBlocks.RHYOLITE_TILES)
                .add(ModBlocks.LAVA_BLACKSTONE_BRICKS)
                .add(ModBlocks.LAVA_BLACKSTONE)
                .add(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS)
                .add(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS)
                .add(ModBlocks.PINK_CRYSTAL)
                .add(ModBlocks.PINK_CRYSTAL_BLOCK)
                .add(ModBlocks.AMBER_BLOCK)
                .add(ModBlocks.RAW_AMBER_BLOCK)
                .add(ModBlocks.AMBER_ORE)
                .add(ModBlocks.AMBER_MINERAL)
                .add(ModBlocks.AMBER_BLOCK_SANDIFIED)
                .add(ModBlocks.BLUE_CRYSTAL)
                .add(ModBlocks.BLUE_CRYSTAL_BLOCK)
                .add(ModBlocks.RED_CRYSTAL)
                .add(ModBlocks.RED_CRYSTAL_BLOCK)
                .add(ModBlocks.WHITE_CRYSTAL_BLOCK)
                .add(ModBlocks.WHITE_CRYSTAL);

        //Shovel
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.COMPRESSED_PURPLE_MUSHROOM)
                .add(ModBlocks.COMPRESSED_DIRT)
                .add(ModBlocks.LIGHT_COMPRESSED_DIRT);

        //Axe
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.BLUE_MUSHROOM_BLOCK)
                .add(ModBlocks.PURPLE_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK)
                .add(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK)
                .add(ModBlocks.GREEN_MUSHROOM_BLOCK)
                .add(ModBlocks.YELLOW_MUSHROOM_BLOCK)
                .add(ModBlocks.ORANGE_MUSHROOM_BLOCK)


                .add(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.ORANGE_MUSHROOM_BLOCK)
                .add(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.YELLOW_MUSHROOM_BLOCK)
                .add(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.BLUE_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.GREEN_MUSHROOM_BLOCK)
                .add(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK)
                .add(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK)


                .add(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK)


                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM)
                .add(ModBlocks.GREEN_MUSHROOM_STEM)
                .add(ModBlocks.TRANSPARENT_MUSHROOM_STEM)

                .add(ModBlocks.BLUE_LUMINESCENT_LOG)
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG)
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD)
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD)
                .add(ModBlocks.BLUE_LUMINESCENT_PLANKS)
                .add(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR)
                .add(ModBlocks.BLUE_LUMINESCENT_DOOR)
                .add(ModBlocks.BLUE_LUMINESCENT_BUTTON)
                .add(ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE)
                .add(ModBlocks.BLUE_LUMINESCENT_STAIRS)
                .add(ModBlocks.BLUE_LUMINESCENT_SLAB)
                .add(ModBlocks.BLUE_LUMINESCENT_FENCE)
                .add(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE)


                .add(ModBlocks.PELTOGYNE_LOG)
                .add(ModBlocks.PELTOGYNE_WOOD)
                .add(ModBlocks.PELTOGYNE_STRIPPED_LOG)
                .add(ModBlocks.PELTOGYNE_STRIPPED_WOOD)
                .add(ModBlocks.PELTOGYNE_PLANKS)
                .add(ModBlocks.PELTOGYNE_STAIRS)
                .add(ModBlocks.PELTOGYNE_SLAB)
                .add(ModBlocks.PELTOGYNE_FENCE)
                .add(ModBlocks.PELTOGYNE_FENCE_GATE)
                .add(ModBlocks.PELTOGYNE_DOOR)
                .add(ModBlocks.PELTOGYNE_TRAPDOOR)
                .add(ModBlocks.PELTOGYNE_PRESSURE_PLATE)
                .add(ModBlocks.PELTOGYNE_BUTTON);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.BLUE_LUMINESCENT_LEAVES)
                .add(ModBlocks.RED_COLORFUL_LEAVES)
                .add(ModBlocks.YELLOW_COLORFUL_LEAVES)
                .add(ModBlocks.BLUE_COLORFUL_LEAVES)
                .add(ModBlocks.PURPLE_COLORFUL_LEAVES)
                .add(ModBlocks.ORANGE_COLORFUL_LEAVES)
                .add(ModBlocks.GREEN_COLORFUL_LEAVES)
                .add(ModBlocks.OAK_BERRIES_LEAVES)
                .add(ModBlocks.PELTOGYNE_LEAVES)
                .add(ModBlocks.PINK_COLORFUL_LEAVES);


        /*-------------------- Natural Blocks --------------------*/
        //Leaves
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.BLUE_LUMINESCENT_LEAVES)
                .add(ModBlocks.RED_COLORFUL_LEAVES)
                .add(ModBlocks.YELLOW_COLORFUL_LEAVES)
                .add(ModBlocks.BLUE_COLORFUL_LEAVES)
                .add(ModBlocks.PURPLE_COLORFUL_LEAVES)
                .add(ModBlocks.ORANGE_COLORFUL_LEAVES)
                .add(ModBlocks.GREEN_COLORFUL_LEAVES)
                .add(ModBlocks.OAK_BERRIES_LEAVES)
                .add(ModBlocks.PELTOGYNE_LEAVES)
                .add(ModBlocks.PINK_COLORFUL_LEAVES);

        //Mushroom Plant
        getOrCreateTagBuilder(ModTags.Blocks.MUSHROOM_PLANT)
                .add(ModBlocks.YELLOW_MUSHROOM)
                .add(ModBlocks.PURPLE_MUSHROOM)
                .add(ModBlocks.ORANGE_MUSHROOM)
                .add(ModBlocks.BLUE_MUSHROOM)
                .add(ModBlocks.GREEN_MUSHROOM)
                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM)
                .add(ModBlocks.LUMINESCENT_PINK_MUSHROOM)
                .add(Blocks.RED_MUSHROOM)
                .add(Blocks.BROWN_MUSHROOM)
                .add(ModBlocks.FERTILE_RED_MUSHROOM)

                .add(ModBlocks.STERILE_BLUE_MUSHROOM)
                .add(ModBlocks.MUSHROOM_SMALL_BROWN)
                .add(ModBlocks.MUSHROOM_SMALL_RED)
                .add(ModBlocks.MUSHROOM_DEATH_TRUMPET)
                .add(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT)

                .add(ModBlocks.PREHISTO_BLUE_SCHROOM)
                .add(ModBlocks.PREHISTO_GREEN_SCHROOM)
                .add(ModBlocks.PREHISTO_PINK_SCHROOM)
                .add(ModBlocks.PREHISTURPLE_SCHROOM);

        //Flowers
        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.YELLOW_MUSHROOM)
                .add(ModBlocks.PURPLE_MUSHROOM)
                .add(ModBlocks.ORANGE_MUSHROOM)
                .add(ModBlocks.BLUE_MUSHROOM)
                .add(ModBlocks.GREEN_MUSHROOM)
                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM)
                .add(ModBlocks.LUMINESCENT_PINK_MUSHROOM)
                .add(Blocks.RED_MUSHROOM)
                .add(Blocks.BROWN_MUSHROOM)
                .add(ModBlocks.FERTILE_RED_MUSHROOM)

                .add(ModBlocks.STERILE_BLUE_MUSHROOM)
                .add(ModBlocks.MUSHROOM_SMALL_BROWN)
                .add(ModBlocks.MUSHROOM_SMALL_RED)
                .add(ModBlocks.MUSHROOM_DEATH_TRUMPET)
                .add(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT)

                .add(ModBlocks.PREHISTO_BLUE_SCHROOM)
                .add(ModBlocks.PREHISTO_GREEN_SCHROOM)
                .add(ModBlocks.PREHISTO_PINK_SCHROOM)
                .add(ModBlocks.PREHISTURPLE_SCHROOM)

                .add(ModBlocks.RED_LUMERIA)
                .add(ModBlocks.MUSHROOM_FLOWERS)

                .add(ModBlocks.SOL_OCCIDENTIS)
                .add(ModBlocks.CYANUS_RUBENS)
                .add(ModBlocks.CYANEA)
                .add(ModBlocks.FUTIALI)
                .add(ModBlocks.NOCTULICA)
                .add(ModBlocks.TURQUOSUM_STILUS)
                .add(ModBlocks.SAPHIRA_FLORENS)
                .add(ModBlocks.PREHISTORIC_ROSE)
                .add(ModBlocks.ORANGE_PERENNIAL)
                .add(ModBlocks.BLUE_PERENNIAL)
                .add(ModBlocks.GREEN_PERENNIAL)
                .add(ModBlocks.PINK_PERENNIAL)
                .add(ModBlocks.LUMINESCENT_PERENNIAL)
                .add(ModBlocks.PURPLE_PERENNIAL)
                .add(ModBlocks.YELLOW_PERENNIAL)
                .add(ModBlocks.YELLOW_QUINCE)
                .add(ModBlocks.RED_QUINCE)
                .add(ModBlocks.TINY_LILAC)
                .add(ModBlocks.OCULAE)
                .add(ModBlocks.YELICE)
                .add(ModBlocks.FLAMESTHYSIA)
                .add(ModBlocks.APAGANTHE)
                .add(ModBlocks.PINK_HEATER)
                .add(ModBlocks.WYSTERIA)
                .add(ModBlocks.BLUEBELL)
                .add(ModBlocks.VIPERIN)
                .add(ModBlocks.HIBISCUS)
                .add(ModBlocks.PLATUM)
                .add(ModBlocks.DIANTHUS)
                .add(ModBlocks.CYCAS)
                .add(ModBlocks.ARUM)
                .add(ModBlocks.HYDRANGEA)
                .add(ModBlocks.ANEMONE)
                .add(ModBlocks.JACYNTHE)
                .add(ModBlocks.ACONIT)
                .add(ModBlocks.PERVENCHE)
                .add(ModBlocks.PICK_BLUE)

                //Vines
                .add(ModBlocks.CAERULEA_VOLUBILIS)
                .add(ModBlocks.PINK_MUSHROOM_VINES)
                .add(ModBlocks.PINK_MUSHROOM_VINES_PLANT)
                .add(ModBlocks.PINK_LUMINESCENT_BODY_VINES)
                .add(ModBlocks.PINK_LUMINESCENT_HEAD_VINES)
                .add(ModBlocks.BLUE_LUMINESCENT_VINES)

                .add(ModBlocks.TINY_GREEN_MUSHROOM)
                .add(ModBlocks.LITTLE_GREEN_MUSHROOM)
                .add(ModBlocks.MEDIUM_GREEN_MUSHROOM)
                .add(ModBlocks.BIG_GREEN_MUSHROOM)
                .add(ModBlocks.BIG_GREEN_MUSHROOM_PLANT)
                .add(ModBlocks.TINY_PURPLE_MUSHROOM)
                .add(ModBlocks.LITTLE_PURPLE_MUSHROOM)
                .add(ModBlocks.MEDIUM_PURPLE_MUSHROOM)
                .add(ModBlocks.BIG_PURPLE_MUSHROOM)
                .add(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT);

        getOrCreateTagBuilder(ModTags.Blocks.GRASS)
                .add(Blocks.GRASS)
                .add(Blocks.TALL_GRASS)
                .add(ModBlocks.TINY_GRASS)
                .add(ModBlocks.BLUE_LUMINESCENT_GRASS)
                .add(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS);

        //Dirt
        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE)
                .add(ModBlocks.PURPLE_SCHROOM_DEESLATE)
                .add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT);

        //Mushroom Grow Blocks
        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE)
                .add(ModBlocks.PURPLE_SCHROOM_DEESLATE)
                .add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.BLUE_LUMINESCENT_SAPPLING)
                .add(ModBlocks.COLORFUL_TREE_SAPLING)
                .add(ModBlocks.PELTOGYNE_SAPLING);


        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ModBlocks.CAERULEA_VOLUBILIS)
                .add(ModBlocks.BLUE_LUMINESCENT_VINES);


        /*-------------------- Construction Blocks --------------------*/
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.BLUE_LUMINESCENT_FENCE)
                .add(ModBlocks.PELTOGYNE_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE)
                .add(ModBlocks.PELTOGYNE_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_LUMINESCENT_LOG)
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG)
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD)
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD)

                .add(ModBlocks.PELTOGYNE_LOG)
                .add(ModBlocks.PELTOGYNE_WOOD)
                .add(ModBlocks.PELTOGYNE_STRIPPED_LOG)
                .add(ModBlocks.PELTOGYNE_STRIPPED_WOOD)
                .add(ModBlocks.PELTOGYNE_PLANKS);


    }
}
