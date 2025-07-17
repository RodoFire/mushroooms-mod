package fr.rodofire.mushrooomsmod.datagen.recipe;/*package fr.rodofire.mushrooomsmod.datagen.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.recipe.ForgeRecipe;
import org.jetbrains.annotations.Nullable;*/

/*public class ForgeRecipeBuilder implements CraftingRecipeJsonBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;

    private final Advancement.Builder advancement = Advancement.Builder.create();

    public ForgeRecipeBuilder(ItemConvertible ingredient, ItemConvertible result, int count) {
        this.result = result.asItem();
        this.ingredient = Ingredient.ofItems(ingredient);
        this.count = count;
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.advancement.criterion(name, criterion);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public Item getOutputItem() {
        return result;
    }

    @Override
    public void offerTo(RecipeExporter exporter, ResourceLocation recipeId) {
        //this.advancement.parent(new ResourceLocation("recipes/root"))
        //        .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
        //        .rewards(AdvancementRewards.Builder.recipe(recipeId));

        //exporter.accept(new JsonBuilder(recipeId, this.result, this.count, this.ingredient, this.advancement,
        //        new ResourceLocation(recipeId.getPath(), "recipes/" + recipeId.getPath())));
//
    }*/



    /*public static class JsonBuilder implements RecipeJsonProvider {
        private final ResourceLocation id;
        private final Item result;
        private final Ingredient ingredient;
        private final int count;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public JsonBuilder(ResourceLocation id, Item result, int count, Ingredient ingredient,
                           Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.result = result;
            this.ingredient = ingredient;
            this.count = count;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serialize(JsonObject json) {
            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson());

            json.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", Registries.ITEM.getId(this.result).toString());
            if (this.count > 1) {
                jsonobject.addProperty("count", this.count);
            }

            json.add("output", jsonobject);
        }

        @Override
        public ResourceLocation getRecipeId() {
            return new ResourceLocation(MushrooomsModConstants.MOD_ID,
                    Registries.ITEM.getId(this.result).getPath() + "_from_forge");
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return ForgeRecipe.Serializer.INSTANCE;
        }

        @Nullable
        @Override
        public JsonObject toAdvancementJson() {
            return this.advancement.toJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }*/
//}

/*public class ForgeRecipeBuilder implements CraftingRecipeJsonBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final Advancement.Builder advancement = Advancement.Builder.create();

    public ForgeRecipeBuilder(ItemConvertible ingredient, ItemConvertible result, int count, int craftTime, int energyAmount) {
        this.ingredient = Ingredient.ofItems(ingredient);
        this.result = result.asItem();
        this.count = count;
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> conditions) {
        this.advancement.criterion(name, conditions);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public Item getOutputItem() {
        return result;
    }

    @Override
    public void offerTo(RecipeExporter exporter, ResourceLocation recipeId) {
        //this.advancement.parent(new ResourceLocation("recipes/root"))
        //        .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
        //        .rewards(AdvancementRewards.Builder.recipe(recipeId));

        exporter.accept(new JsonBuilder(recipeId, this.result, this.count, this.ingredient,
                this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/"
                + recipeId.getPath())));
    }

    public static class JsonBuilder implements RecipeJsonProvider {
        private final ResourceLocation id;
        private final Item result;
        private final Ingredient ingredient;
        private final int count;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public JsonBuilder(ResourceLocation id, Item result, int count, Ingredient ingredient,
                           Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.result = result;
            this.ingredient = ingredient;
            this.count = count;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serialize(JsonObject json) {
            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson(true));

            json.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", Registries.ITEM.getId(this.result).toString());
            if (this.count > 1) {
                jsonobject.addProperty("count", this.count);
            }

            json.add("output", jsonobject);
        }

        @Override
        public ResourceLocation id() {
            return new ResourceLocation(MushrooomsModConstants.MOD_ID,
                    Registries.ITEM.getId(this.result).getPath() + "from_forge");
        }

        @Override
        public RecipeSerializer<?> serializer() {
            return ForgeRecipe.Serializer.INSTANCE;
        }

        @Nullable
        @Override
        public AdvancementEntry advancement() {
            return new AdvancementEntry(id(), advancement.build(id()).value());
        }
    }
}*/


