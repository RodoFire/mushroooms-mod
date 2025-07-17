package fr.rodofire.mushrooomsmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
 
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import fr.rodofire.mushrooomsmod.block.entity.ForgeBE;
import fr.rodofire.mushrooomsmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ForgeBlock extends BaseEntityBlock implements EntityBlock {
    public static final MapCodec<ForgeBlock> CODEC = ForgeBlock.simpleCodec(ForgeBlock::new);
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public ForgeBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ForgeBE(pos, state);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player,  BlockHitResult hit) {
        //TODO verify offhand
        if ( world.isClientSide()) return InteractionResult.PASS;

        BlockEntity blockEntity = world.getBlockEntity(pos);
        Container inventory = (Container) blockEntity;
        ItemStack itemStack = player.getMainHandItem();
        ItemStack putItemStack = itemStack.getItem().getDefaultInstance();
        int itemfirstslot = inventory.getItem(0).getCount();
        putItemStack.setCount(itemfirstslot + 1);
        if (!inventory.isEmpty()) {
            //code to give the inventory to the player
            if (itemStack.isEmpty() || !itemStack.is(ModTags.Items.FORGEABLE_ITEMS)) {
                if (itemStack.isEmpty()) {
                    //give it to the slot
                    if (inventory.getItem(1).isEmpty()) {
                        player.addItem(inventory.getItem(0));
                        inventory.removeItemNoUpdate(0);
                        inventory.setItem(0, ItemStack.EMPTY);
                    } else {
                        player.addItem(inventory.getItem(1));
                        inventory.removeItemNoUpdate(1);
                        inventory.setItem(0, ItemStack.EMPTY);
                    }
                    return InteractionResult.SUCCESS;
                } else {
                    //drop the item
                    if (inventory.getItem(1).isEmpty()) {
                        popResource(world, pos.above(), inventory.getItem(0));
                        inventory.removeItemNoUpdate(0);
                        inventory.setItem(0, ItemStack.EMPTY);
                    } else {
                        popResource(world, pos.above(), inventory.getItem(1));
                        inventory.removeItemNoUpdate(1);
                        inventory.setItem(0, ItemStack.EMPTY);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
            //put stuff
            if (inventory.getItem(0).getCount() != 64) {
                if (itemStack.is(ModTags.Items.FORGEABLE_ITEMS)) {
                    if (player.isShiftKeyDown()) {
                        inventory.setItem(0, putItemStack);
                        itemStack.shrink(64);
                    } else {
                        inventory.setItem(0, putItemStack);
                        if (!player.isCreative()) itemStack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }

        } else {
            if (!itemStack.is(ModTags.Items.FORGEABLE_ITEMS)) return InteractionResult.PASS;
            if (player.isShiftKeyDown()) {
                inventory.setItem(0, putItemStack);
                itemStack.shrink(64);
            } else {
                inventory.setItem(0, putItemStack);
                itemStack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return super.getTicker(world, state, type);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ForgeBE) {
                Containers.dropContents(world, pos, (Container) blockEntity);
                world.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, world, pos, newState, moved);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        tooltip.add(Component.translatable("tooltip.mushrooomsmod.forge_block").withStyle(ChatFormatting.BLUE));
        super.appendHoverText(stack, context, tooltip, options);
    }
}
