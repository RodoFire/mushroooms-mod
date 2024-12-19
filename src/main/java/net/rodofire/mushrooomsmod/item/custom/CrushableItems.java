package net.rodofire.mushrooomsmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.rodofire.mushrooomsmod.item.ModItems;

import java.util.List;

public class CrushableItems extends Item {

    public CrushableItems(Settings settings) {
        super(settings);
    }

    public static ItemStack getCrushed(ItemStack stack) {
        Item item = stack.getItem();
        if (stack.getItem().equals(Items.DIAMOND)) return ModItems.CRUSHED_DIAMOND.asItem().getDefaultStack();
        if (stack.getItem().equals(ModItems.AMBER_ITEM)) return ModItems.CRUSHED_AMBER_ITEM.asItem().getDefaultStack();
        return null;
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.crushable_items"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
