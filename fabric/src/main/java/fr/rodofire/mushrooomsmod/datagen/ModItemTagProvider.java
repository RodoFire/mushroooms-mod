package fr.rodofire.mushrooomsmod.datagen;

import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.item.ModItems;
import fr.rodofire.mushrooomsmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
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
                .add(ModItems.PURPLE_MUSHROOM_POWDER.get());

        getOrCreateTagBuilder(ModTags.Items.FORGEABLE_ITEMS)
                .add(Items.DIAMOND)
                .add(ModItems.AMBER_ITEM.get());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BLUE_LUMINESCENT_PLANKS.get().asItem())
                .add(ModBlocks.PELTOGYNE_PLANKS.get().asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_LUMINESCENT_LOG.get().asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get().asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get().asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD.get().asItem())

                .add(ModBlocks.PELTOGYNE_LOG.get().asItem())
                .add(ModBlocks.PELTOGYNE_STRIPPED_LOG.get().asItem())
                .add(ModBlocks.PELTOGYNE_WOOD.get().asItem())
                .add(ModBlocks.PELTOGYNE_STRIPPED_WOOD.get().asItem());

        getOrCreateTagBuilder(ModTags.Items.HAMMERS)
                .add(ModItems.IRON_HAMMER.get());

        getOrCreateTagBuilder(ModTags.Items.BLUE_LUMINESCENT_LOGS)
                .add(ModBlocks.BLUE_LUMINESCENT_LOG.get().asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get().asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_WOOD.get().asItem())
                .add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get().asItem());

        getOrCreateTagBuilder(ModTags.Items.PELTOGYNE_LOGS)
                .add(ModBlocks.PELTOGYNE_LOG.get().asItem())
                .add(ModBlocks.PELTOGYNE_STRIPPED_LOG.get().asItem())
                .add(ModBlocks.PELTOGYNE_WOOD.get().asItem())
                .add(ModBlocks.PELTOGYNE_STRIPPED_WOOD.get().asItem());
    }
}
