package fr.rodofire.mushrooomsmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import fr.rodofire.mushrooomsmod.entity.ModEntities;
import fr.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import fr.rodofire.mushrooomsmod.entity.custom.LockedInventoryArmorStand;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class KeyItem extends Item {
    public KeyItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player user, LivingEntity entity, InteractionHand hand) {
        Level world = entity.getCommandSenderWorld();
        if (world.isClientSide) return InteractionResult.PASS;
        ServerLevel worldServer = (ServerLevel) world;
        CompoundTag nbt;
        @Nullable var data = stack.get(DataComponents.CUSTOM_DATA);

        if (data == null) return InteractionResult.PASS;
        nbt = data.copyTag();
        System.out.println(data+"  "+nbt );

        //0e2a8643-40df-3a07-bffe-aa9fb0809920

        if (!nbt.contains(("uuid"))) nbt.putUUID("uuid", UUID.randomUUID());

        if (entity instanceof InventoryArmorStandEntity) {
            //if the type is locked inventory, the player uuid will be added if
            System.out.println(user.getUUID());
            if (entity instanceof LockedInventoryArmorStand inv) {
                if (inv.getKeyUUID() != null) {
                    if (inv.getKeyUUID().equals(nbt.getUUID("uuid")) && !inv.canPlayerUse(user))
                        inv.addAutorizedPlayer(user.getUUID());
                } else {
                    inv.addAutorizedPlayer(user.getUUID());
                    inv.setKeyUUID(nbt.getUUID("uuid"));
                }
            } else {
                NonNullList<NonNullList<ItemStack>> inventory = ((InventoryArmorStandEntity) entity).getInventory();
                System.out.println(inventory);
                BlockPos pos = entity.blockPosition();
                float f = entity.getVisualRotationYInDegrees();
                entity.remove(Entity.RemovalReason.DISCARDED);
                Consumer<LockedInventoryArmorStand> consumer = EntityType.createDefaultStackConfig(worldServer, stack, user);
                LockedInventoryArmorStand newEntity = ModEntities.LOCKED_INVENTORY_ARMOR_STAND.create(worldServer, consumer, pos, MobSpawnType.SPAWN_EGG, true, true);
                if (newEntity == null) {
                    return InteractionResult.FAIL;
                }
                newEntity.setInventory(inventory);
                System.out.println("keyItem" + nbt.getUUID("uuid"));
                newEntity.setKeyUUID(nbt.getUUID("uuid"));
                newEntity.addAutorizedPlayer(user.getUUID());
                newEntity.moveTo(entity.getX(), entity.getY(), entity.getZ(), f, 0.0f);
                worldServer.addFreshEntityWithPassengers(newEntity);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        super.appendHoverText(stack, context, tooltip, type);
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.keyItem").withStyle(ChatFormatting.BLUE));
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.keyItem1").withStyle(ChatFormatting.BLUE));
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.keyItem2").withStyle(ChatFormatting.BLUE));
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.keyItem3").withStyle(ChatFormatting.BLUE));
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.keyItem4").withStyle(ChatFormatting.BLUE));
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.keyItem5").withStyle(ChatFormatting.BLUE));
        } else {
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.shift"));
        }
    }
}
