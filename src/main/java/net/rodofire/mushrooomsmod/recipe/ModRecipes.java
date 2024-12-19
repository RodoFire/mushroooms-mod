package net.rodofire.mushrooomsmod.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModRecipes {
    public static final RecipeSerializer<ForgeRecipe> FORGING_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MushrooomsMod.MOD_ID, ForgeRecipe.ForgeSerializer.ID),
            new ForgeRecipe.ForgeSerializer());

    public static final RecipeType<ForgeRecipe> FORGING_TYPE = registerType("forging");

    static <T extends Recipe<?>> RecipeType<T> registerType(String id) {
        return Registry.register(Registries.RECIPE_TYPE, Identifier.of(MushrooomsMod.MOD_ID, id), new RecipeType<T>() {
            public String toString() {
                return id;
            }
        });
    }

    public static void registerRecipes() {
        MushrooomsMod.LOGGER.info("Registering Recipes");
    }
}
