package net.rodofire.mushrooomsmod.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.recipe.RecipeEntry;
import net.rodofire.mushrooomsmod.recipe.ForgeRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForgeDisplay extends BasicDisplay {
    public ForgeDisplay(RecipeEntry<ForgeRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().recipeItem())),
                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().output()))));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ForgeCategory.FORGE_EMPOWERING;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return null;
    }
    /*private RecipeEntry<ForgeRecipe> recipe;

    public ForgeDisplay(EntryIngredient inputs, EntryIngredient outputs) {
        super(Collections.singletonList(inputs), Collections.singletonList(outputs));
    }


    public ForgeDisplay(RecipeEntry<ForgeRecipe> recipe) {
        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(recipe.value().output()))));
        this.recipe = recipe;
    }



    private static List<EntryIngredient> getInputList(ForgeRecipe recipe) {
        if (recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        list.add(EntryIngredients.ofIngredient(recipe.recipeItem()));
        return list;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ForgeCategory.FORGE_EMPOWERING;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return null;
    }*/


}
