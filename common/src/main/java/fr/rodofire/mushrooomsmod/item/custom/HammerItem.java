package fr.rodofire.mushrooomsmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.recipe.ForgeRecipe;

import java.util.List;
import java.util.Optional;

public class HammerItem extends TieredItem {
    double attackDamage;
    double attackSpeed;
    int maxcrushableblocks;
    private int hammeruse = 0;

    public HammerItem(Tier material, int maxcrushableblocks, Properties settings) {
        super(material, settings);
        this.maxcrushableblocks = maxcrushableblocks;
    }

    public static ItemAttributeModifiers createAttributeModifiers(Tier material, int baseAttackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (float)baseAttackDamage + material.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }


    public static ItemStack getResult(Level world, ItemStack stack) {
        RecipeManager recipeManager = world.getRecipeManager();
        RegistryAccess registryManager = world.registryAccess();
        Optional<RecipeHolder<ForgeRecipe>> optional = world
                .getRecipeManager()
                .getRecipeFor(ForgeRecipe.Type.INSTANCE, new SingleRecipeInput(stack), world);
        if (optional.isPresent()) return optional.get().value().getResultItem(registryManager);
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level world, BlockPos pos, Player miner) {
        if (hammeruse != 0) return mine(world, pos);
        if (world.isClientSide()) {
            return mine(world, pos);
        }
        return use(world, pos, miner);
    }


    public boolean mine(Level world, BlockPos pos) {
        return !world.getBlockState(pos).is(ModBlocks.FORGE_BLOCK.get());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (hammeruse != 0) hammeruse--;
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        tooltip.add(Component.translatable("tooltip.mushrooomsmod.hammer.usage").withStyle(ChatFormatting.AQUA));
        super.appendHoverText(stack, context, tooltip, type);
    }

    public int getHammerUse() {
        return this.hammeruse;
    }

    public boolean use(Level world, BlockPos pos, Player miner) {
        Block targetedblock = world.getBlockState(pos).getBlock();
        if (targetedblock.equals(ModBlocks.FORGE_BLOCK)) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            Container inventory = (Container) blockEntity;
            hammeruse = 200;
            if (inventory.getItem(0).getCount() == 0) return false;
            else {

                int transfer;
                int crushed = inventory.getItem(1).getCount();
                int crush = inventory.getItem(0).getCount();

                if (64 - crushed <= crush) crush = crushed;

                ItemStack stack = inventory.getItem(0);
                ItemStack result = getResult(world, stack);
                if (result == ItemStack.EMPTY) return false;

                if (crush <= maxcrushableblocks) {
                    inventory.setItem(0, ItemStack.EMPTY);
                    result.setCount(crush + crushed);
                    inventory.setItem(1, result);
                } else {
                    inventory.removeItem(0, transfer = RandomSource.create().nextIntBetweenInclusive(1, maxcrushableblocks));
                    result.setCount(transfer + crushed);
                    inventory.setItem(1, result);
                }

                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1f, 1.0f / (world.getRandom().nextFloat() * 0.5f + 1.0f) + 0.2f);
            }
            return false;
        }
        return true;
    }
}
