package fr.rodofire.mushrooomsmod.recipe;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public class ModRecipes {
    public static void registerRecipes() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Recipes");
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, ForgeRecipe.Serializer.ID),
                ForgeRecipe.Serializer.INSTANCE);

        Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, ForgeRecipe.Type.ID),
                ForgeRecipe.Type.INSTANCE);
    }
}
