package fr.rodofire.mushrooomsmod.util;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MUSHROOM_PLANT = createTag("mushroom_plant");
        public static final TagKey<Block> GRASS = createTag("mushroom_plant");
        public static final TagKey<Block> MUSHROOM_SPAWNABLE = createTag("mushroom_spawnable");
        public static final TagKey<Block> ROCKY_STALACTITE_BASE = createTag("rocky_stalactite_base");
        public static final TagKey<Block> MOSSY_STALACTITE_BASE = createTag("mossy_stalactite_base");
        public static final TagKey<Block> ROCKY_STALACTITE_TOP = createTag("rocky_stalactite_top");
        public static final TagKey<Block> MOSSY_STALACTITE_TOP = createTag("mossy_stalactite_top");
        public static final TagKey<Block> FLUIDS = createTag("fluids");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name));
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
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_YELLOW_MUSHROOM = createTag("has_structure/yellow_mushroom_biomes");
        public static final TagKey<Biome> HAS_PURPLE_MUSHROOM = createTag("has_structure/purple_mushroom_biomes");
        public static final TagKey<Biome> HAS_GIANT_YELLOW_MUSHROOM = createTag("has_structure/giant_yellow_mushroom_biomes");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name));
        }
    }
}