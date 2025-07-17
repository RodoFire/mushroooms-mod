package fr.rodofire.mushrooomsmod.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import fr.rodofire.mushrooomsmod.util.ModTags;

import java.util.List;
import java.util.function.Supplier;

public class FermentedMushroomBlock extends Block {
    Supplier<Block> blockSupplier;
    public boolean ismaxfermented;


    public InteractionResult onUse(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getMainHandItem();
        if (!ismaxfermented) {
            if (stack.is(ModTags.Items.MUSHROOM_POWDER)) {
                world.setBlockAndUpdate(pos, blockSupplier.get().defaultBlockState());
                if (!player.isCreative()) stack.shrink(1);
                return InteractionResult.SUCCESS;
            }
        } else {
            if (stack.is(ItemTags.AXES) && stack.getItem() instanceof AxeItem axeItem && axeItem.getTier().getSpeed() > Tiers.STONE.getSpeed()) {
                world.setBlockAndUpdate(pos, blockSupplier.get().defaultBlockState());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    public FermentedMushroomBlock(Supplier<Block> blockSupplier, boolean ismaxfermented, Properties settings) {
        super(settings);
        this.blockSupplier = blockSupplier;
        this.ismaxfermented = ismaxfermented;
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.fermented_mushroom_block").withStyle(ChatFormatting.BLUE));
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.fermented_mushroom_block_axe").withStyle(ChatFormatting.BLUE));
        }else {
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.shift"));
        }
        super.appendHoverText(stack, context, tooltip, options);
    }
}
