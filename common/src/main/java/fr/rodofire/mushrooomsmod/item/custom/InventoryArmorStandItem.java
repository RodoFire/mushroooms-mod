package fr.rodofire.mushrooomsmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import fr.rodofire.mushrooomsmod.entity.ModEntities;
import fr.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;

import java.util.List;
import java.util.function.Consumer;

public class InventoryArmorStandItem extends Item {
    public InventoryArmorStandItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack itemStack = context.getItemInHand();
        Vec3 vec3d = Vec3.atBottomCenterOf(pos);

        AABB box = EntityType.ARMOR_STAND.getDimensions().makeBoundingBox(vec3d.x(), vec3d.y(), vec3d.z());
        if (!world.getEntities(null, box).isEmpty()) {
            return InteractionResult.FAIL;
        }

        if (!world.isClientSide) {
            ServerLevel worldServer = (ServerLevel) world;
            Consumer<InventoryArmorStandEntity> consumer = EntityType.createDefaultStackConfig(worldServer, itemStack, context.getPlayer());

            InventoryArmorStandEntity entity = ModEntities.INVENTORY_ARMOR_STAND_ENTITY.get().create(worldServer, consumer, pos, MobSpawnType.SPAWN_EGG, true, true);
            if (entity == null) {
                return InteractionResult.FAIL;
            }
            float f = (float)Mth.floor((Mth.wrapDegrees(context.getRotation() - 180.0F) + 22.5F) / 45.0F) * 45.0F;
            entity.moveTo(entity.getX(), entity.getY(), entity.getZ(), f, 0.0f);
            worldServer.addFreshEntityWithPassengers(entity);
            itemStack.shrink(1);
        }
        return InteractionResult.sidedSuccess(world.isClientSide);
    }



    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        super.appendHoverText(stack, context, tooltip, type);
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.inventory_armor_stand_usage").withStyle(ChatFormatting.BLUE));
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.inventory_armor_stand_use").withStyle(ChatFormatting.BLUE));
        } else {
            tooltip.add(Component.translatable("tooltip.mushrooomsmod.shift"));
        }
    }
}
