package fr.rodofire.mushrooomsmod.block.custom;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

public class SandifiedAmbreBlock extends BlockBrushableBlock {

    public SandifiedAmbreBlock(Properties settings, Block block) {
        super(settings, block);
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        tooltip.add(Component.translatable("tooltip.mushrooomsmod.sandified_ambre").withStyle(ChatFormatting.GOLD));
        super.appendHoverText(stack, context, tooltip, options);
    }
}
