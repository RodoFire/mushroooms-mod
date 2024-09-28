package net.rodofire.mushrooomsmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MUSHROOM_PLANT = createTag("mushroom_plant");
        public static final TagKey<Block> GRASS = createTag("mushroom_plant");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(MushrooomsMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> DIAMOND_ITEMS = createTag("diamond_item");
        public static final TagKey<Item> MUSHROOM_POWDER = createTag("mushroom_powder");
        public static final TagKey<Item> FORGEABLE_ITEMS = createTag("forgeable_items");
        public static final TagKey<Item> HAMMERS = createTag("hammers");

        public static final TagKey<Item> BLUE_LUMINESCENT_LOGS = createTag("blue_luminescent_logs");
        public static final TagKey<Item> PELTOGYNE_LOGS = createTag("peltogyne_logs");



        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(MushrooomsMod.MOD_ID, name));
        }
    }
}