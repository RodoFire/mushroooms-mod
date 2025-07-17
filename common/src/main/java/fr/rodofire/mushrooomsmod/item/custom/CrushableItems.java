package fr.rodofire.mushrooomsmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import fr.rodofire.mushrooomsmod.item.ModItems;

import java.util.List;

public class CrushableItems extends Item {

    public CrushableItems(Properties settings) {
        super(settings);
    }

    public static ItemStack getCrushed(ItemStack stack) {
        Item item = stack.getItem();
        if (stack.getItem().equals(Items.DIAMOND)) return ModItems.CRUSHED_DIAMOND.get().asItem().getDefaultInstance();
        if (stack.getItem().equals(ModItems.AMBER_ITEM)) return ModItems.CRUSHED_AMBER_ITEM.get().asItem().getDefaultInstance();
        return null;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        tooltip.add(Component.translatable("tooltip.mushrooomsmod.crushable_items"));
        super.appendHoverText(stack, context, tooltip, type);
    }
}
