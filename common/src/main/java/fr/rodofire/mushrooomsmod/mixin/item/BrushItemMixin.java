package fr.rodofire.mushrooomsmod.mixin.item;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import fr.rodofire.mushrooomsmod.block.custom.BlockBrushableBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(BrushItem.class)
public abstract class BrushItemMixin extends Item {
    private HitResult getHitResult(Player user) {
        return ProjectileUtil.getHitResultOnViewVector((Entity)user, entity -> !entity.isSpectator() && entity.isPickable(), user.blockInteractionRange());
    }

    @Inject(method = "usageTick", at = @At("TAIL"))
    public void amberBlock(Level world, LivingEntity user, ItemStack stack, int remainingUseTicks, CallbackInfo ci) {
        int i = this.getUseDuration(stack, user) - remainingUseTicks + 1;
        boolean bl = i % 10 == 5;
        if (bl) {
            Player playerEntity = (Player) user;
            HitResult hitResult = this.getHitResult(playerEntity);
            BlockHitResult blockHitResult = (BlockHitResult) hitResult;
            BlockPos blockPos = blockHitResult.getBlockPos();
            BlockState blockState = world.getBlockState(blockPos);
            Object object = blockState.getBlock();

            if (!world.isClientSide && object instanceof BlockBrushableBlock && ((BlockBrushableBlock) object).brush(world.getGameTime(), playerEntity, blockPos, i)) {
                EquipmentSlot equipmentSlot = stack.equals(playerEntity.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                stack.hurtAndBreak(1, user, equipmentSlot);
            }
        }
    }

    public BrushItemMixin(Properties settings) {
        super(settings);
    }
}
