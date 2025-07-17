package fr.rodofire.mushrooomsmod.datagen;

import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.item.ModItems;
import fr.rodofire.mushrooomsmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    public void buildRecipes(RecipeOutput exporter) {
        //Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_PURPLE_MUSHROOM.get(), 1)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define(Character.valueOf('R'), ModItems.PURPLE_MUSHROOM_POWDER.get())
                .unlockedBy(getHasName(ModItems.PURPLE_MUSHROOM_POWDER.get()), has(ModItems.PURPLE_MUSHROOM_POWDER.get()))
                .save(exporter, ResourceLocation.parse(("compressed_purple_mushroom_craft")));


        //Food
        pressurePlate(exporter, ModItems.BAGUETTE.get(), Items.BREAD);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BAGUETTE.get(), 1)
                .define(Character.valueOf('#'), Items.WHEAT)
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(exporter, ResourceLocation.parse("baguettess_craft"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.LUMINESCENT_SCHROOM_SOUP.get(), 1)
                .define(Character.valueOf('#'), ModBlocks.BLUE_LUMINESCENT_MUSHROOM.get())
                .define(Character.valueOf('C'), Items.BOWL)
                .pattern(" # ")
                .pattern("#C#")
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(exporter, ResourceLocation.parse("blue_luminescent_soup_craft"));


        //Lights
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_LANTERN.get(), 1)
                .pattern("RRR")
                .pattern("RSR")
                .pattern("RRR")
                .define(Character.valueOf('R'), Items.IRON_NUGGET)
                .define(Character.valueOf('S'), ModBlocks.GREEN_TORCH.get())
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .unlockedBy(getHasName(ModBlocks.GREEN_TORCH.get()), has(ModBlocks.GREEN_TORCH.get()))
                .save(exporter, ResourceLocation.parse("green_lantern_craft"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_LANTERN.get(), 1)
                .pattern("RRR")
                .pattern("RSR")
                .pattern("RRR")
                .define(Character.valueOf('R'), Items.IRON_NUGGET)
                .define(Character.valueOf('S'), Blocks.REDSTONE_TORCH)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .unlockedBy(getHasName(Blocks.REDSTONE_TORCH), has(Blocks.REDSTONE_TORCH))
                .save(exporter, ResourceLocation.parse("red_lantern_craft"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_TORCH.get(), 1)
                .pattern("RS")
                .define(Character.valueOf('R'), Blocks.TORCH)
                .define(Character.valueOf('S'), Items.GREEN_DYE)
                .unlockedBy(getHasName(Blocks.TORCH), has(Blocks.TORCH))
                .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                .save(exporter, ResourceLocation.parse("green_torch_craft"));

        //dye
        //yellow
        oneToOneConversionRecipe(exporter, Items.YELLOW_DYE, ModBlocks.YELLOW_QUINCE.get(), "yellow_dye");
        oneToOneConversionRecipe(exporter, Items.YELLOW_DYE, ModBlocks.YELLOW_PERENNIAL.get(), "yellow_dye");
        oneToOneConversionRecipe(exporter, Items.YELLOW_DYE, ModBlocks.YELICE.get(), "yellow_dye");

        //orange
        oneToOneConversionRecipe(exporter, Items.ORANGE_DYE, ModBlocks.SOL_OCCIDENTIS.get(), "orange_dye");
        oneToOneConversionRecipe(exporter, Items.ORANGE_DYE, ModBlocks.ORANGE_PERENNIAL.get(), "orange_dye");
        oneToOneConversionRecipe(exporter, Items.ORANGE_DYE, ModBlocks.FLAMESTHYSIA.get(), "orange_dye");
        oneToOneConversionRecipe(exporter, Items.ORANGE_DYE, ModBlocks.HIBISCUS.get(), "orange_dye");

        //red
        oneToOneConversionRecipe(exporter, Items.RED_DYE, ModBlocks.PREHISTORIC_ROSE.get(), "red_dye");
        oneToOneConversionRecipe(exporter, Items.RED_DYE, ModBlocks.RED_QUINCE.get(), "red_dye");
        oneToOneConversionRecipe(exporter, Items.RED_DYE, ModBlocks.OCULAE.get(), "red_dye");

        //light blue
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.LUMINESCENT_PERENNIAL.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.CYANEA.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.FUTIALI.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.NOCTULICA.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.TURQUOSUM_STILUS.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.SAPHIRA_FLORENS.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.CAERULEA_VOLUBILIS.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.APAGANTHE.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.PLATUM.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.PERVENCHE.get(), "light_blue_dye");

        //blue
        oneToOneConversionRecipe(exporter, Items.BLUE_DYE, ModBlocks.BLUE_PERENNIAL.get(), "blue_dye");
        oneToOneConversionRecipe(exporter, Items.BLUE_DYE, ModBlocks.BLUEBELL.get(), "blue_dye");
        oneToOneConversionRecipe(exporter, Items.BLUE_DYE, ModBlocks.ANEMONE.get(), "blue_dye");
        oneToOneConversionRecipe(exporter, Items.BLUE_DYE, ModBlocks.JACYNTHE.get(), "blue_dye");

        //purple
        oneToOneConversionRecipe(exporter, Items.PURPLE_DYE, ModBlocks.PURPLE_PERENNIAL.get(), "purple_dye");
        oneToOneConversionRecipe(exporter, Items.PURPLE_DYE, ModBlocks.WYSTERIA.get(), "purple_dye");
        oneToOneConversionRecipe(exporter, Items.PURPLE_DYE, ModBlocks.TINY_LILAC.get(), "purple_dye");
        oneToOneConversionRecipe(exporter, Items.PURPLE_DYE, ModBlocks.ACONIT.get(), "purple_dye");

        //pink
        oneToOneConversionRecipe(exporter, Items.PINK_DYE, ModBlocks.PINK_PERENNIAL.get(), "pink_dye");
        oneToOneConversionRecipe(exporter, Items.PINK_DYE, ModBlocks.PINK_HEATER.get(), "pink_dye");
        oneToOneConversionRecipe(exporter, Items.PINK_DYE, ModBlocks.DIANTHUS.get(), "pink_dye");
        oneToOneConversionRecipe(exporter, Items.PINK_DYE, ModBlocks.CYCAS.get(), "pink_dye");
        oneToOneConversionRecipe(exporter, Items.PINK_DYE, ModBlocks.HYDRANGEA.get(), "pink_dye");

        //green
        oneToOneConversionRecipe(exporter, Items.GREEN_DYE, ModBlocks.GREEN_PERENNIAL.get(), "green_dye");
        oneToOneConversionRecipe(exporter, Items.GREEN_DYE, ModBlocks.VIPERIN.get(), "green_dye");
        oneToOneConversionRecipe(exporter, Items.GREEN_DYE, ModBlocks.ARUM.get(), "green_dye");


        //Construction Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVA_BLACKSTONE_BRICKS.get(), 4)
                .pattern("RR")
                .pattern("RR")
                .define(Character.valueOf('R'), ModBlocks.LAVA_BLACKSTONE.get())
                .unlockedBy(getHasName(ModBlocks.LAVA_BLACKSTONE.get()), has(ModBlocks.LAVA_BLACKSTONE.get()))
                .save(exporter, ResourceLocation.parse("lava_blackstone_bricks_craft"));

        pressurePlate(exporter, ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS.get(), ModBlocks.LAVA_BLACKSTONE_BRICKS.get());
        pressurePlate(exporter, ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS.get(), ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS.get());
        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_TILES.get(), ModBlocks.RHYOLITE.get());

        //Wood
        planksFromLogs(exporter, ModBlocks.BLUE_LUMINESCENT_PLANKS.get(), ModTags.Items.BLUE_LUMINESCENT_LOGS, 4);
        pressurePlate(exporter, ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE.get(), ModBlocks.BLUE_LUMINESCENT_PLANKS.get());
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_LUMINESCENT_SLAB.get(), ModBlocks.BLUE_LUMINESCENT_PLANKS.get());
        stairBuilder(ModBlocks.BLUE_LUMINESCENT_STAIRS.get(), Ingredient.of(ModBlocks.BLUE_LUMINESCENT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("blue_luminescent_stairs"));
        oneToOneConversionRecipe(exporter, ModBlocks.BLUE_LUMINESCENT_BUTTON.get(), ModBlocks.BLUE_LUMINESCENT_PLANKS.get(), "button");
        trapdoorBuilder(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR.get(), Ingredient.of(ModBlocks.BLUE_LUMINESCENT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("blue_luminescent_trapdoor"));
        doorBuilder(ModBlocks.BLUE_LUMINESCENT_DOOR.get(), Ingredient.of(ModBlocks.BLUE_LUMINESCENT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("blue_luminescent_door"));
        fenceGateBuilder(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE.get(), Ingredient.of(ModBlocks.BLUE_LUMINESCENT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("blue_luminescent_fence_gate"));
        fenceBuilder(ModBlocks.BLUE_LUMINESCENT_FENCE.get(), Ingredient.of(ModBlocks.BLUE_LUMINESCENT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("blue_luminescent_fence"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get(), 3)
                .pattern("RR")
                .pattern("RR")
                .define(Character.valueOf('R'), ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get()), has(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get()))
                .save(exporter, ResourceLocation.parse("blue_luminescent_stripped_wood_craft"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_LUMINESCENT_WOOD.get(), 4)
                .pattern("RR")
                .pattern("RR")
                .define(Character.valueOf('R'), ModBlocks.BLUE_LUMINESCENT_LOG.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_LUMINESCENT_LOG.get()), has(ModBlocks.BLUE_LUMINESCENT_LOG.get()))
                .save(exporter, ResourceLocation.parse("blue_luminescent_wood_craft"));


        planksFromLogs(exporter, ModBlocks.PELTOGYNE_PLANKS.get(), ModTags.Items.PELTOGYNE_LOGS, 4);
        pressurePlate(exporter, ModBlocks.PELTOGYNE_PRESSURE_PLATE.get(), ModBlocks.PELTOGYNE_PLANKS.get());
        slab(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PELTOGYNE_SLAB.get(), ModBlocks.PELTOGYNE_PLANKS.get());
        stairBuilder(ModBlocks.PELTOGYNE_STAIRS.get(), Ingredient.of(ModBlocks.PELTOGYNE_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("peltogyne_stairs"));
        oneToOneConversionRecipe(exporter, ModBlocks.PELTOGYNE_BUTTON.get(), ModBlocks.PELTOGYNE_PLANKS.get(), "button");
        trapdoorBuilder(ModBlocks.PELTOGYNE_TRAPDOOR.get(), Ingredient.of(ModBlocks.PELTOGYNE_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("peltogyne_trapdoor"));
        doorBuilder(ModBlocks.PELTOGYNE_DOOR.get().asItem(), Ingredient.of(ModBlocks.PELTOGYNE_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("peltogyne_door"));
        fenceGateBuilder(ModBlocks.PELTOGYNE_FENCE_GATE.get(), Ingredient.of(ModBlocks.PELTOGYNE_PLANKS.get())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("peltogyne_fence_gate"));
        fenceBuilder(ModBlocks.PELTOGYNE_FENCE.get(), Ingredient.of(ModBlocks.PELTOGYNE_PLANKS.get().asItem())).unlockedBy(getHasName(ModBlocks.PELTOGYNE_PLANKS.get()), has(ModBlocks.PELTOGYNE_PLANKS.get())).save(exporter, ResourceLocation.parse("peltogyne_fence"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PELTOGYNE_STRIPPED_WOOD.get(), 3)
                .pattern("RR")
                .pattern("RR")
                .define(Character.valueOf('R'), ModBlocks.PELTOGYNE_STRIPPED_LOG.get())
                .unlockedBy(getHasName(ModBlocks.PELTOGYNE_STRIPPED_LOG.get()), has(ModBlocks.PELTOGYNE_STRIPPED_LOG.get()))
                .save(exporter, ResourceLocation.parse("peltogyne_stripped_wood_craft"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PELTOGYNE_WOOD.get(), 4)
                .pattern("RR")
                .pattern("RR")
                .define(Character.valueOf('R'), ModBlocks.PELTOGYNE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.PELTOGYNE_LOG.get()), has(ModBlocks.PELTOGYNE_LOG.get()))
                .save(exporter, ResourceLocation.parse("peltogyne_wood_craft"));


        //utils
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FORGE_BLOCK.get())
                .pattern("RRR")
                .pattern(" S ")
                .pattern("SRS")
                .define(Character.valueOf('R'), Blocks.IRON_BLOCK)
                .define(Character.valueOf('S'), Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Blocks.IRON_BLOCK))
                .save(exporter, ResourceLocation.parse("forge_craft"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FORGE_BLOCK.get())
                .pattern("S S")
                .pattern("SRS")
                .pattern(" S ")
                .define(Character.valueOf('S'), Items.IRON_INGOT)
                .define(Character.valueOf('R'), Blocks.ANVIL)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Blocks.ANVIL))
                .save(exporter, ResourceLocation.parse("forge_craft_with_anvil"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_HAMMER.get())
                .pattern("BBB")
                .pattern("ISI")
                .pattern(" S ")
                .define(Character.valueOf('S'), Items.STICK)
                .define(Character.valueOf('B'), Blocks.IRON_BLOCK)
                .define(Character.valueOf('I'), Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Blocks.IRON_BLOCK))
                .save(exporter, ResourceLocation.parse("hammer_craft"));

        //Crystals
        //offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_BLOCK.get(), ModItems.CRUSHED_AMBER_ITEM.get());
        nineBlockStorageRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CRUSHED_AMBER_ITEM.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_BLOCK.get());
        nineBlockStorageRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.AMBER_ITEM.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_AMBER_BLOCK.get());
        threeByThreePacker(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CRYSTAL_BLOCK.get(), ModItems.BLUE_CRYSTAL_ITEM.get());
        threeByThreePacker(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CRYSTAL_BLOCK.get(), ModItems.RED_CRYSTAL_ITEM.get());


        //Forge Recipe
        /*new ForgeRecipeBuilder(Items.DIAMOND, ModItems.CRUSHED_DIAMOND.get(), 1)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, Identifier.of("diamond_forge_craft"));

        new ForgeRecipeBuilder(ModItems.AMBER_ITEM.get(), ModItems.CRUSHED_AMBER_ITEM.get(), 1)
                .criterion(hasItem(ModItems.AMBER_ITEM.get()), conditionsFromItem(Items.AIR))
                .offerTo(exporter, Identifier.of("amber_forge_craft"));*/

        oreSmelting(exporter, List.of(ModItems.YELLOW_BERRIES.get()), RecipeCategory.FOOD, ModItems.COOKED_YELLOW_BERRIES.get(), 0.3f, 100, "yellow_berries");
        oreBlasting(exporter, List.of(ModItems.YELLOW_BERRIES.get()), RecipeCategory.FOOD, ModItems.COOKED_YELLOW_BERRIES.get(), 0.3f, 50, "yellow_berries");

        //inventory armor stand
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INVENTORY_ARMOR_STAND.get())
                .pattern("SSS")
                .pattern(" C ")
                .pattern("SPS")
                .define(Character.valueOf('S'), Items.STICK)
                .define(Character.valueOf('P'), Blocks.SMOOTH_STONE_SLAB)
                .define(Character.valueOf('C'), Blocks.CHEST)
                .unlockedBy(getHasName(Items.STICK), has(Blocks.CHEST))
                .save(exporter, ResourceLocation.parse("inventory_armor_stand_craft"));
    }
}
