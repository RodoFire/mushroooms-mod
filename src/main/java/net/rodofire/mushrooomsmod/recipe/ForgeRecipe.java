package net.rodofire.mushrooomsmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.recipe.book.ModBooksCategory;
import net.rodofire.mushrooomsmod.recipe.display.ForgeDisplay;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public record ForgeRecipe(@NotNull Ingredient recipeItem,
                          @NotNull ItemStack output) implements Recipe<SingleStackRecipeInput> {

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return recipeItem.test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        System.out.println("craft: " + input.item() + "   " + output.copy());
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleStackRecipeInput>> getSerializer() {
        return ModRecipes.FORGING_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<SingleStackRecipeInput>> getType() {
        return ModRecipes.FORGING_TYPE;
    }


    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(recipeItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return ModBooksCategory.FORGING;
    }

    @Override
    public List<RecipeDisplay> getDisplays() {
        return List.of(
                new ForgeDisplay(
                        Ingredient.toDisplay(Optional.of(this.recipeItem)),
                        new SlotDisplay.StackSlotDisplay(this.output),
                        new SlotDisplay.ItemSlotDisplay(ModBlocks.FORGE_BLOCK.asItem())
                )
        );
    }


    public static class Type implements RecipeType<ForgeRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "forge_crafting";

        private Type() {
        }
    }


    public static class ForgeSerializer implements RecipeSerializer<ForgeRecipe> {
        public static final ForgeSerializer INSTANCE = new ForgeSerializer();
        public static final String ID = "forge_crafting";

        private static final PacketCodec<RegistryByteBuf, ForgeRecipe> PACKET_CODEC = PacketCodec.ofStatic(ForgeSerializer::write, ForgeSerializer::read);

        private static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.recipeItem),
                ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
        ).apply(instance, ForgeRecipe::new));

        @Override
        public MapCodec<ForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ForgeRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        public static ForgeRecipe read(RegistryByteBuf buf) {
            Ingredient inputs;

            inputs = Ingredient.PACKET_CODEC.decode(buf);

            ItemStack output = ItemStack.PACKET_CODEC.decode(buf);

            return new ForgeRecipe(inputs, output);
        }

        public static void write(RegistryByteBuf buf, ForgeRecipe recipe) {
            buf.writeInt(1);

            Ingredient.PACKET_CODEC.encode(buf, recipe.recipeItem());
            ItemStack.PACKET_CODEC.encode(buf, recipe.output());
        }
    }
}

