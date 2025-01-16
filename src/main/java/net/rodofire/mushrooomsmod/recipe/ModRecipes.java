package net.rodofire.mushrooomsmod.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModRecipes {
    public static void registerRecipes() {
        MushrooomsMod.LOGGER.info("|\t-Registering Recipes");
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MushrooomsMod.MOD_ID, ForgeRecipe.Serializer.ID),
                ForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(MushrooomsMod.MOD_ID, ForgeRecipe.Type.ID),
                ForgeRecipe.Type.INSTANCE);
    }
}
