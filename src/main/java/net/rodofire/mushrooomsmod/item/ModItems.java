package net.rodofire.mushrooomsmod.item;

import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.effect.ModStatusEffects;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.item.Custom.*;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;

import java.util.function.Function;

public class ModItems {
    public static final Item INVENTORY_ARMOR_STAND = registerItem("inventory_armor_stand_item", settings -> new InventoryArmorStandItem(settings.maxCount(16).registryKey(keyOf("inventory_armor_stand_item"))));

    //Blocks
    public static final Item PURPLE_MUSHROOM_POWDER = registerItem("mushroom_powder_purple", Item::new);

    //Flowers
    public static final Item CAERULEA_VOLUBILIS_ITEM = registerBlockItem("caerulea_volubilis_item", ModBlocks.CAERULEA_VOLUBILIS, new Item.Settings());

    //Vines
    public static final Item PINK_MUSHROOM_VINES_ITEM = registerBlockItem("mushroom_vines_pink_item", ModBlocks.PINK_MUSHROOM_VINES, new Item.Settings());
    //Big Mushrooms
    public static final Item BIG_PURPLE_MUSHROOM_SEED = registerBlockItem("mushroom_big_purple_seed", ModBlocks.BIG_PURPLE_MUSHROOM_PLANT, new Item.Settings());
    public static final Item BIG_GREEN_MUSHROOM_SEED = registerBlockItem("mushroom_big_green_seed", ModBlocks.BIG_GREEN_MUSHROOM_PLANT, new Item.Settings());
    public static final Item BOOST_MUSHROOM_ITEM = registerBlockItem("mushroom_boost_item", ModBlocks.MUSHROOM_BOOSTING, new Item.Settings());
    public static final Item DANGEROUS_BOOST_MUSHROOM_ITEM = registerBlockItem("mushroom_boost_dangerous_item", ModBlocks.DANGEROUS_MUSHROOM_BOOSTING, new Item.Settings());

    //food
    public static final Item BAGUETTE = registerItem("baguette", settings -> new Item(settings.food(ModFoodComponents.BAGUETTE).registryKey(keyOf("baguette"))));
    public static final Item LUMINESCENT_SCHROOM_SOUP = registerItem("luminescent_schroom_soup", settings -> new SchroomSoup(settings.food(ModFoodComponents.BLUE_LUMINESCENT_SCHROOM_SOUP), ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE, new StatusEffectInstance(ModStatusEffects.FLICKERING, 3000, 0)));
    public static final Item FLEUR_BERRIES_ITEM = registerBlockItem("fleur_berries_item", ModBlocks.FLEUR_BERRIES, new Item.Settings());
    public static final Item YELLOW_BERRIES = registerItem("berries_yellow", settings -> new Item(settings.food(ModFoodComponents.YELLOW_BERRIES, ModConsumableComponents.YELLOW_BERRIES)));
    public static final Item COOKED_YELLOW_BERRIES = registerItem("berries_cooked_yellow", settings -> new Item(settings.food(ModFoodComponents.COOKED_YELLOW_BERRIES, ModConsumableComponents.COOKED_YELLOW_BERRIES)));

    //Lights
    public static final Item GREEN_TORCH = registerItem("torch_green_item", settings -> new VerticallyAttachableBlockItem(ModBlocks.GREEN_TORCH, ModBlocks.WALL_GREEN_TORCH, Direction.DOWN, settings.useBlockPrefixedTranslationKey()));

    //Egg
    public static final Item GROKI_SPAWN_EGG = registerItem("groki_spawn_egg", settings -> new SpawnEggItem(ModEntities.GROKI, settings));
    public static final Item BOLETE_COW_SPAWN_EGG = registerItem("bolete_cow_spawn_egg", settings -> new SpawnEggItem(ModEntities.BOLETE_COW, settings));
    public static final Item PLOTI_SPAWN_EGG = registerItem("ploti_spawn_egg", settings -> new SpawnEggItem(ModEntities.PLOTI, settings));
    public static final Item CRYSTAL_CREEPER_SPAWN_EGG = registerItem("crystal_creeper_spawn_egg", settings -> new SpawnEggItem(ModEntities.CRYSTAL_CREEPER, settings));
    public static final Item CRYSTAL_GOLEM_SPAWN_EGG = registerItem("crystal_golem_spawn_egg", settings -> new SpawnEggItem(ModEntities.CRYSTAL_GOLEM, settings));
    //public static final Item SCHROOM_STICK_SPAWN_EGG = registerItem("schroom_stick_spawn_egg", settings -> new SpawnEggItem(ModEntities.SCHROOM_STICK, 0xd3ccc4, 0xd81a1a, settings));
    //public static final Item MOSQUITO_SPAWN_EGG = registerItem("mosquito_spawn_egg", new SpawnEggItem(ModEntities.MOSQUITO_ENTITY, 0x897540, 0x222221, settings));


    //Crystals related
    public static final Item CRUSHED_DIAMOND = registerItem("crushed_diamond", Item::new);
    //public static final Item PINK_CRYSTAL_ITEM = registerItem("crystal_pink_item", settings -> new BlockItem(ModBlocks.PINK_CRYSTAL, settings));
    public static final Item BLUE_CRYSTAL_ITEM = registerBlockItem("crystal_blue_item", ModBlocks.BLUE_CRYSTAL, new Item.Settings());
    public static final Item RED_CRYSTAL_ITEM = registerBlockItem("crystal_red_item", ModBlocks.RED_CRYSTAL, new Item.Settings());
    public static final Item AMBER_ITEM = registerItem("amber_item", CrushableItems::new);
    public static final Item CRUSHED_AMBER_ITEM = registerItem("amber_crushed_item", Item::new);
    //Tools
    public static final Item IRON_HAMMER = registerItem("iron_hammer", settings -> new HammerItem(ToolMaterial.IRON, 27, -0.8f, 12, settings));
    public static final Item KEY = registerItem("key", settings -> new KeyItem(settings.maxCount(1).component(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(new NbtCompound()))));

    private static Item registerItem(String id, Function<Item.Settings, Item> factory) {
        return Registry.register(Registries.ITEM, Identifier.of(MushrooomsMod.MOD_ID, id), factory.apply(new Item.Settings().registryKey(keyOf(id))));
    }

    private static Item registerBlockItem(String name, Block block, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(MushrooomsMod.MOD_ID, name), new BlockItem(block, settings.useBlockPrefixedTranslationKey().registryKey(keyOf(name))));
    }

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MushrooomsMod.MOD_ID, id));
    }

    public static void registerModItems() {
        MushrooomsMod.LOGGER.info("Registering Items");
    }
}
