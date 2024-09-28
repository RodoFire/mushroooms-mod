package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.DIAMOND_ITEMS)
                .add(Items.DIAMOND_AXE)
                .add(Items.DIAMOND_SHOVEL)
                .add(Items.DIAMOND_SWORD)
                .add(Items.DIAMOND_BOOTS)
                .add(Items.DIAMOND_CHESTPLATE)
                .add(Items.DIAMOND_HELMET)
                .add(Items.DIAMOND_HOE)
                .add(Items.DIAMOND_LEGGINGS)
                .add(Items.DIAMOND_HELMET)
                .add(Items.DIAMOND_HORSE_ARMOR)
                .add(Items.DIAMOND_PICKAXE);

        getOrCreateTagBuilder(ModTags.Items.MUSHROOM_POWDER)
                .add(ModItems.PURPLE_MUSHROOM_POWDER);

        getOrCreateTagBuilder(ModTags.Items.FORGEABLE_ITEMS)
                .add(Items.DIAMOND)
                .add(ModItems.AMBER_ITEM);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BLUE_LUMINESCENT_PLANKS.asItem())
                .add(ModBlocks.PELTOGYNE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_LUMINESCENT_LOG.asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD.asItem())

                .add(ModBlocks.PELTOGYNE_LOG.asItem())
                .add(ModBlocks.PELTOGYNE_STRIPPED_LOG.asItem())
                .add(ModBlocks.PELTOGYNE_WOOD.asItem())
                .add(ModBlocks.PELTOGYNE_STRIPPED_WOOD.asItem());

        getOrCreateTagBuilder(ModTags.Items.HAMMERS)
                .add(ModItems.IRON_HAMMER);

        getOrCreateTagBuilder(ModTags.Items.BLUE_LUMINESCENT_LOGS)
                .add(ModBlocks.BLUE_LUMINESCENT_LOG.asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD.asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD.asItem());

        getOrCreateTagBuilder(ModTags.Items.PELTOGYNE_LOGS)
                .add(ModBlocks.PELTOGYNE_LOG.asItem())
                .add(ModBlocks.PELTOGYNE_STRIPPED_LOG.asItem())
                .add(ModBlocks.PELTOGYNE_WOOD.asItem())
                .add(ModBlocks.PELTOGYNE_WOOD.asItem());
    }
}
