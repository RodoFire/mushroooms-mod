package net.rodofire.mushrooomsmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.recipe.ForgeRecipe;
import net.rodofire.mushrooomsmod.recipe.ModRecipes;

import java.util.List;

public class HammerItem extends Item {
    int maxcrushableblocks;
    private int hammeruse = 0;

    public HammerItem(ToolMaterial material, int attackDamage, float attackSpeed, int maxcrushableblocks, Settings settings) {
        super(material.applySwordSettings(settings, attackDamage, attackSpeed));
        this.maxcrushableblocks = maxcrushableblocks;
    }

    public static ItemStack getResult(World world, ItemStack stack) {
        RecipeManager recipeManager = world.getRecipeManager();
        DynamicRegistryManager registryManager = world.getRegistryManager();
        if (world instanceof ServerWorld serverWorld) {

            ServerRecipeManager.MatchGetter<SingleStackRecipeInput, ForgeRecipe> matchGetter = ServerRecipeManager.createCachedMatchGetter(
                    ModRecipes.FORGING_TYPE
            );
            SingleStackRecipeInput singleStackRecipeInput = new SingleStackRecipeInput(stack);

            ItemStack itemStack2 = (ItemStack) matchGetter.getFirstMatch(singleStackRecipeInput, serverWorld)
                    .map(recipe -> ((ForgeRecipe) recipe.value()).craft(singleStackRecipeInput, world.getRegistryManager()))
                    .orElse(stack);

            System.out.println("hammer: "+stack + "   " + itemStack2);
            return itemStack2;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (hammeruse != 0) return mine(world, pos);
        if (world.isClient()) {
            return mine(world, pos);
        }
        return use(world, pos, miner);
    }


    public boolean mine(World world, BlockPos pos) {
        return !world.getBlockState(pos).isOf(ModBlocks.FORGE_BLOCK);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (hammeruse != 0) hammeruse--;
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.hammer.usage").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }

    public int getHammerUse() {
        return this.hammeruse;
    }

    public boolean use(World world, BlockPos pos, PlayerEntity miner) {
        Block targetedblock = world.getBlockState(pos).getBlock();
        if (targetedblock.equals(ModBlocks.FORGE_BLOCK)) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            Inventory inventory = (Inventory) blockEntity;
            hammeruse = 200;
            if (inventory.getStack(0).getCount() == 0) return false;
            else {

                int transfer;
                int crushed = inventory.getStack(1).getCount();
                int crush = inventory.getStack(0).getCount();

                if (64 - crushed <= crush) crush = crushed;

                ItemStack stack = inventory.getStack(0);
                ItemStack result = getResult(world, stack);
                if (result == ItemStack.EMPTY) return false;

                if (crush <= maxcrushableblocks) {
                    inventory.setStack(0, ItemStack.EMPTY);
                    result.setCount(crush + crushed);
                    inventory.setStack(1, result);
                } else {
                    inventory.removeStack(0, transfer = Random.create().nextBetween(1, maxcrushableblocks));
                    result.setCount(transfer + crushed);
                    inventory.setStack(1, result);
                }

                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1f, 1.0f / (world.getRandom().nextFloat() * 0.5f + 1.0f) + 0.2f);
            }
            return false;
        }
        return true;
    }
}
