package fr.rodofire.mushrooomsmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import fr.rodofire.mushrooomsmod.block.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ForgeBE extends BlockEntity implements ImplementedInventory {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(2, ItemStack.EMPTY);

    public ForgeBE(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FORGE_BLOCK.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        super.saveAdditional(nbt, registryLookup);
        ContainerHelper.saveAllItems(nbt,inventory, registryLookup);
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        super.loadAdditional(nbt, registryLookup);
        inventory.clear();
        ContainerHelper.loadAllItems(nbt, inventory, registryLookup);
    }

    public ItemStack getInventory() {
        return inventory.get(inventory.size() - 1);
    }


    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void setChanged() {
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        super.setChanged();
    }

    public ArrayList<ItemStack> getRenderStack() {
        ArrayList<ItemStack> itemStacks = new ArrayList<>();
        if (inventory.get(0).getCount() == 0 && inventory.get(1).getCount() == 0) itemStacks.add(ItemStack.EMPTY);
        else if (inventory.get(0).getCount() != 0 && inventory.get(1).getCount() == 0) itemStacks.add(inventory.get(0));
        else if (inventory.get(1).getCount() != 0 && inventory.get(0).getCount() == 0) itemStacks.add(inventory.get(1));
        else {
            itemStacks.add(inventory.get(0));
            itemStacks.add(inventory.get(1));
        }
        return itemStacks;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registryLookup) {
        return saveWithoutMetadata(registryLookup);
    }
}
