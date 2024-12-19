package net.rodofire.mushrooomsmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import net.rodofire.mushrooomsmod.entity.custom.LockedInventoryArmorStand;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class KeyItem extends Item {
    public KeyItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = entity.getEntityWorld();
        if (world.isClient) return ActionResult.PASS;
        ServerWorld worldServer = (ServerWorld) world;
        NbtCompound nbt;
        @Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);

        if (data == null) return ActionResult.PASS;
        nbt = data.copyNbt();
        System.out.println(data+"  "+nbt );

        //0e2a8643-40df-3a07-bffe-aa9fb0809920

        if (!nbt.contains(("uuid"))) nbt.putUuid("uuid", UUID.randomUUID());

        if (entity instanceof InventoryArmorStandEntity) {
            //if the type is locked inventory, the player uuid will be added if
            System.out.println(user.getUuid());
            if (entity instanceof LockedInventoryArmorStand inv) {
                if (inv.getKeyUUID() != null) {
                    if (inv.getKeyUUID().equals(nbt.getUuid("uuid")) && !inv.canPlayerUse(user))
                        inv.addAutorizedPlayer(user.getUuid());
                } else {
                    inv.addAutorizedPlayer(user.getUuid());
                    inv.setKeyUUID(nbt.getUuid("uuid"));
                }
            } else {
                DefaultedList<DefaultedList<ItemStack>> inventory = ((InventoryArmorStandEntity) entity).getInventory();
                System.out.println(inventory);
                BlockPos pos = entity.getBlockPos();
                float f = entity.getBodyYaw();
                entity.remove(Entity.RemovalReason.DISCARDED);
                Consumer<LockedInventoryArmorStand> consumer = EntityType.copier(worldServer, stack, user);
                LockedInventoryArmorStand newEntity = ModEntities.LOCKED_INVENTORY_ARMOR_STAND.create(worldServer, consumer, pos, SpawnReason.MOB_SUMMONED, true, true);
                if (newEntity == null) {
                    return ActionResult.FAIL;
                }
                newEntity.setInventory(inventory);
                System.out.println("keyItem" + nbt.getUuid("uuid"));
                newEntity.setKeyUUID(nbt.getUuid("uuid"));
                newEntity.addAutorizedPlayer(user.getUuid());
                newEntity.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), f, 0.0f);
                worldServer.spawnEntityAndPassengers(newEntity);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.keyItem").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.keyItem1").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.keyItem2").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.keyItem3").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.keyItem4").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.keyItem5").formatted(Formatting.BLUE));
        } else {
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.shift"));
        }
    }
}
