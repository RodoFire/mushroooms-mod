package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> YELLOW_BERRIES = List.of(ModItems.YELLOW_BERRIES);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryEntryLookup<Item> registry = registryLookup.getOrThrow(RegistryKeys.ITEM);
                //Blocks
                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_PURPLE_MUSHROOM, 1)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.PURPLE_MUSHROOM_POWDER)
                        .criterion(hasItem(ModItems.PURPLE_MUSHROOM_POWDER), conditionsFromItem(ModItems.PURPLE_MUSHROOM_POWDER))
                        .offerTo(exporter/*Identifier.of(("compressed_purple_mushroom_craft"));


                //Food
                offerPressurePlateRecipe(ModItems.BAGUETTE, Items.BREAD);
                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                        .input('#', Items.WHEAT)
                        .pattern("###")
                        .pattern("###")
                        .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                        .offerTo(exporter,"baguettess_craft");

                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.FOOD, ModItems.LUMINESCENT_SCHROOM_SOUP, 1)
                        .input('#', ModBlocks.BLUE_LUMINESCENT_MUSHROOM)
                        .input('C', Items.BOWL)
                        .pattern(" # ")
                        .pattern("#C#")
                        .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                        .offerTo(exporter,"blue_luminescent_soup_craft"*/);


                //Lights
                /*ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_LANTERN, 1)
                        .pattern("RRR")
                        .pattern("RSR")
                        .pattern("RRR")
                        .input('R', Items.IRON_NUGGET)
                        .input('S', ModItems.GREEN_TORCH)
                        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                        .criterion(hasItem(ModBlocks.GREEN_TORCH), conditionsFromItem(ModBlocks.GREEN_TORCH))
                        .offerTo(exporter, "green_lantern_craft");*/

                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_LANTERN, 1)
                        .pattern("RRR")
                        .pattern("RSR")
                        .pattern("RRR")
                        .input('R', Items.IRON_NUGGET)
                        .input('S', Blocks.REDSTONE_TORCH)
                        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                        .criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH))
                        .offerTo(exporter, "red_lantern_craft");

                /*ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_TORCH, 1)
                        .pattern("RS")
                        .input('R', Blocks.TORCH)
                        .input('S', Items.GREEN_DYE)
                        .criterion(hasItem(Blocks.TORCH), conditionsFromItem(Blocks.TORCH))
                        .criterion(hasItem(Items.GREEN_DYE), conditionsFromItem(Items.GREEN_DYE))
                        .offerTo(exporter, "green_torch_craft");*/

                //dye
                //yellow
                offerSingleOutputShapelessRecipe(Items.YELLOW_DYE, ModBlocks.YELLOW_QUINCE, "yellow_dye");
                offerSingleOutputShapelessRecipe(Items.YELLOW_DYE, ModBlocks.YELLOW_PERENNIAL, "yellow_dye");
                offerSingleOutputShapelessRecipe(Items.YELLOW_DYE, ModBlocks.YELICE, "yellow_dye");

                //orange
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, ModBlocks.SOL_OCCIDENTIS, "orange_dye");
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, ModBlocks.ORANGE_PERENNIAL, "orange_dye");
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, ModBlocks.FLAMESTHYSIA, "orange_dye");
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, ModBlocks.HIBISCUS, "orange_dye");

                //red
                offerSingleOutputShapelessRecipe(Items.RED_DYE, ModBlocks.PREHISTORIC_ROSE, "red_dye");
                offerSingleOutputShapelessRecipe(Items.RED_DYE, ModBlocks.RED_QUINCE, "red_dye");
                offerSingleOutputShapelessRecipe(Items.RED_DYE, ModBlocks.OCULAE, "red_dye");

                //light blue
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.LUMINESCENT_PERENNIAL, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.CYANEA, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.FUTIALI, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.NOCTULICA, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.TURQUOSUM_STILUS, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.SAPHIRA_FLORENS, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModItems.CAERULEA_VOLUBILIS_ITEM, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.APAGANTHE, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.PLATUM, "light_blue_dye");
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, ModBlocks.PERVENCHE, "light_blue_dye");

                //blue
                offerSingleOutputShapelessRecipe(Items.BLUE_DYE, ModBlocks.BLUE_PERENNIAL, "blue_dye");
                offerSingleOutputShapelessRecipe(Items.BLUE_DYE, ModBlocks.BLUEBELL, "blue_dye");
                offerSingleOutputShapelessRecipe(Items.BLUE_DYE, ModBlocks.ANEMONE, "blue_dye");
                offerSingleOutputShapelessRecipe(Items.BLUE_DYE, ModBlocks.JACYNTHE, "blue_dye");

                //purple
                offerSingleOutputShapelessRecipe(Items.PURPLE_DYE, ModBlocks.PURPLE_PERENNIAL, "purple_dye");
                offerSingleOutputShapelessRecipe(Items.PURPLE_DYE, ModBlocks.WYSTERIA, "purple_dye");
                offerSingleOutputShapelessRecipe(Items.PURPLE_DYE, ModBlocks.TINY_LILAC, "purple_dye");
                offerSingleOutputShapelessRecipe(Items.PURPLE_DYE, ModBlocks.ACONIT, "purple_dye");

                //pink
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, ModBlocks.PINK_PERENNIAL, "pink_dye");
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, ModBlocks.PINK_HEATER, "pink_dye");
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, ModBlocks.DIANTHUS, "pink_dye");
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, ModBlocks.CYCAS, "pink_dye");
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, ModBlocks.HYDRANGEA, "pink_dye");

                //green
                offerSingleOutputShapelessRecipe(Items.GREEN_DYE, ModBlocks.GREEN_PERENNIAL, "green_dye");
                offerSingleOutputShapelessRecipe(Items.GREEN_DYE, ModBlocks.VIPERIN, "green_dye");
                offerSingleOutputShapelessRecipe(Items.GREEN_DYE, ModBlocks.ARUM, "green_dye");


                //Construction Blocks
                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVA_BLACKSTONE_BRICKS, 4)
                        .pattern("RR")
                        .pattern("RR")
                        .input('R', ModBlocks.LAVA_BLACKSTONE)
                        .criterion(hasItem(ModBlocks.LAVA_BLACKSTONE), conditionsFromItem(ModBlocks.LAVA_BLACKSTONE))
                        .offerTo(exporter, "lava_blackstone_bricks_craft");

                offerPressurePlateRecipe(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS, ModBlocks.LAVA_BLACKSTONE_BRICKS);
                offerPressurePlateRecipe(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS, ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_TILES, ModBlocks.RHYOLITE);

                //Wood
                offerPlanksRecipe(ModBlocks.BLUE_LUMINESCENT_PLANKS, ModTags.Items.BLUE_LUMINESCENT_LOGS, 4);
                offerPressurePlateRecipe(ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE, ModBlocks.BLUE_LUMINESCENT_PLANKS);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_LUMINESCENT_SLAB, ModBlocks.BLUE_LUMINESCENT_PLANKS);
                createStairsRecipe(ModBlocks.BLUE_LUMINESCENT_STAIRS, Ingredient.ofItems(ModBlocks.BLUE_LUMINESCENT_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "blue_luminescent_stairs");
                offerSingleOutputShapelessRecipe(ModBlocks.BLUE_LUMINESCENT_BUTTON, ModBlocks.BLUE_LUMINESCENT_PLANKS, "button");
                createTrapdoorRecipe(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR, Ingredient.ofItems(ModBlocks.BLUE_LUMINESCENT_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "blue_luminescent_trapdoor");
                createDoorRecipe(ModBlocks.BLUE_LUMINESCENT_DOOR, Ingredient.ofItems(ModBlocks.BLUE_LUMINESCENT_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "blue_luminescent_door");
                createFenceGateRecipe(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE, Ingredient.ofItems(ModBlocks.BLUE_LUMINESCENT_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "blue_luminescent_fence_gate");
                createFenceRecipe(ModBlocks.BLUE_LUMINESCENT_FENCE, Ingredient.ofItems(ModBlocks.BLUE_LUMINESCENT_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "blue_luminescent_fence");

                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD, 3)
                        .pattern("RR")
                        .pattern("RR")
                        .input('R', ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG)
                        .criterion(hasItem(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG), conditionsFromItem(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG))
                        .offerTo(exporter, "blue_luminescent_stripped_wood_craft");

                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_LUMINESCENT_WOOD, 4)
                        .pattern("RR")
                        .pattern("RR")
                        .input('R', ModBlocks.BLUE_LUMINESCENT_LOG)
                        .criterion(hasItem(ModBlocks.BLUE_LUMINESCENT_LOG), conditionsFromItem(ModBlocks.BLUE_LUMINESCENT_LOG))
                        .offerTo(exporter, "blue_luminescent_wood_craft");


                offerPlanksRecipe(ModBlocks.PELTOGYNE_PLANKS, ModTags.Items.PELTOGYNE_LOGS, 4);
                offerPressurePlateRecipe(ModBlocks.PELTOGYNE_PRESSURE_PLATE, ModBlocks.PELTOGYNE_PLANKS);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PELTOGYNE_SLAB, ModBlocks.PELTOGYNE_PLANKS);
                createStairsRecipe(ModBlocks.PELTOGYNE_STAIRS, Ingredient.ofItems(ModBlocks.PELTOGYNE_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "peltogyne_stairs");
                offerSingleOutputShapelessRecipe(ModBlocks.PELTOGYNE_BUTTON, ModBlocks.PELTOGYNE_PLANKS, "button");
                createTrapdoorRecipe(ModBlocks.PELTOGYNE_TRAPDOOR, Ingredient.ofItems(ModBlocks.PELTOGYNE_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "peltogyne_trapdoor");
                createDoorRecipe(ModBlocks.PELTOGYNE_DOOR.asItem(), Ingredient.ofItems(ModBlocks.PELTOGYNE_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "peltogyne_door");
                createFenceGateRecipe(ModBlocks.PELTOGYNE_FENCE_GATE, Ingredient.ofItems(ModBlocks.PELTOGYNE_PLANKS)).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "peltogyne_fence_gate");
                createFenceRecipe(ModBlocks.PELTOGYNE_FENCE, Ingredient.ofItems(ModBlocks.PELTOGYNE_PLANKS.asItem())).criterion(hasItem(ModBlocks.PELTOGYNE_PLANKS), conditionsFromItem(ModBlocks.PELTOGYNE_PLANKS)).offerTo(exporter, "peltogyne_fence");

                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PELTOGYNE_STRIPPED_WOOD, 3)
                        .pattern("RR")
                        .pattern("RR")
                        .input('R', ModBlocks.PELTOGYNE_STRIPPED_LOG)
                        .criterion(hasItem(ModBlocks.PELTOGYNE_STRIPPED_LOG), conditionsFromItem(ModBlocks.PELTOGYNE_STRIPPED_LOG))
                        .offerTo(exporter, "peltogyne_stripped_wood_craft");

                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PELTOGYNE_WOOD, 4)
                        .pattern("RR")
                        .pattern("RR")
                        .input('R', ModBlocks.PELTOGYNE_LOG)
                        .criterion(hasItem(ModBlocks.PELTOGYNE_LOG), conditionsFromItem(ModBlocks.PELTOGYNE_LOG))
                        .offerTo(exporter, "peltogyne_wood_craft");


                //utils
                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.MISC, ModBlocks.FORGE_BLOCK)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern("SRS")
                        .input('R', Blocks.IRON_BLOCK)
                        .input('S', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Blocks.IRON_BLOCK))
                        .offerTo(exporter, "forge_craft");

                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.MISC, ModBlocks.FORGE_BLOCK)
                        .pattern("S S")
                        .pattern("SRS")
                        .pattern(" S ")
                        .input('S', Items.IRON_INGOT)
                        .input('R', Blocks.ANVIL)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Blocks.ANVIL))
                        .offerTo(exporter, "forge_craft_with_anvil");

                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.MISC, ModItems.IRON_HAMMER)
                        .pattern("BBB")
                        .pattern("ISI")
                        .pattern(" S ")
                        .input('S', Items.STICK)
                        .input('B', Blocks.IRON_BLOCK)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Blocks.IRON_BLOCK))
                        .offerTo(exporter, "hammer_craft");

                //Crystals
                //offerCompactingRecipe( RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_BLOCK, ModItems.CRUSHED_AMBER_ITEM);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.CRUSHED_AMBER_ITEM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.AMBER_ITEM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_AMBER_BLOCK);
                offerCompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CRYSTAL_BLOCK, ModItems.BLUE_CRYSTAL_ITEM);
                offerCompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CRYSTAL_BLOCK, ModItems.RED_CRYSTAL_ITEM);


                //Forge Recipe
        /*new ForgeRecipeBuilder(Items.DIAMOND, ModItems.CRUSHED_DIAMOND, 1)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter,"diamond_forge_craft"));

        new ForgeRecipeBuilder(ModItems.AMBER_ITEM, ModItems.CRUSHED_AMBER_ITEM, 1)
                .criterion(hasItem(ModItems.AMBER_ITEM), conditionsFromItem(Items.AIR))
                .offerTo(exporter,"amber_forge_craft"));*/

                offerSmelting(YELLOW_BERRIES, RecipeCategory.FOOD, ModItems.COOKED_YELLOW_BERRIES, 0.3f, 100, "yellow_berries");
                offerBlasting(YELLOW_BERRIES, RecipeCategory.FOOD, ModItems.COOKED_YELLOW_BERRIES, 0.3f, 50, "yellow_berries");

                //inventory armor stand
                ShapedRecipeJsonBuilder.create(registry, RecipeCategory.MISC, ModItems.INVENTORY_ARMOR_STAND)
                        .pattern("SSS")
                        .pattern(" C ")
                        .pattern("SPS")
                        .input('S', Items.STICK)
                        .input('P', Blocks.SMOOTH_STONE_SLAB)
                        .input('C', Blocks.CHEST)
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Blocks.CHEST))
                        .offerTo(exporter, "inventory_armor_stand_craft");

            }
        };
    }


    @Override
    public String getName() {
        return "recipes." + MushrooomsMod.MOD_ID;
    }
}
