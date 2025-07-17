package fr.rodofire.mushrooomsmod.screen;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import fr.rodofire.mushrooomsmod.block.entity.ForgeBE;

public class ForgeScreenHandler /*extends AbstractContainerMenu*/ {

/*
    private final Container inventory;
    private final ContainerData propertyDelegate;
    public final ForgeBE blockEntity;

    //public static final PacketCodec<RegistryByteBuf, ForgeScreenHandler> PACKET_CODEC = PacketCodec.tuple(
    //        PacketCodecs.STRING, buf -> buf. );


    public ForgeScreenHandler(int i, Inventory playerInventory) {
        //super(ModScreenHandlers.FORGE_SCREEN_HANDLER, i);
        this(i, playerInventory, playerInventory.player.level().getBlockEntity(playerInventory.player.blockPosition()),
                new SimpleContainerData(2));
    }


    @Override
    public ItemStack quickMoveStack(Player player, int slot) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }


    /*public static final PacketCodec<RegistryByteBuf, ForgeScreenHandler> PACKET_CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, ForgeScreenHandler::label, ForgeScreenHandler::new);*/


    /*public ForgeScreenHandler(int syncId, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.FORGE_SCREEN_HANDLER, syncId);


        this.inventory = ((Inventory) blockEntity);
        //inventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((ForgeBlockEntity) blockEntity);

        this.addSlot(new Slot(null, 0, 25, 32));
        this.addSlot(new Slot(null, 1, 133, 32));

        addProperties(arrayPropertyDelegate);
    }*/
/*
    public ForgeScreenHandler(int syncId, Inventory playerInventory,
                              BlockEntity blockEntity, ContainerData arrayPropertyDelegate) {
        super(ModScreenHandlers.FORGE_SCREEN_HANDLER, syncId);

        checkContainerSize(((Container) blockEntity), 2);
        this.inventory = ((Container) blockEntity);
        inventory.startOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((ForgeBE) blockEntity);

        this.addSlot(new Slot(inventory, 0, 25, 32));
        this.addSlot(new Slot(inventory, 1, 133, 32));

        addDataSlots(arrayPropertyDelegate);
    }
*/
}
