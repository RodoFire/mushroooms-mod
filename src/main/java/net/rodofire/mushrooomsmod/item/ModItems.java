package net.rodofire.mushrooomsmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.effect.ModStatusEffects;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.item.Custom.*;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;

public class ModItems {
    public static final Item INVENTORY_ARMOR_STAND = registerItem("inventory_armor_stand_item", new InventoryArmorStandItem(new FabricItemSettings().maxCount(16)));

    //Blocks
    public static final Item PURPLE_MUSHROOM_POWDER = registerItem("mushroom_powder_purple", new Item(new FabricItemSettings()));

    //Flowers
    public static final Item CAERULEA_VOLUBILIS_ITEM = registerItem("caerulea_volubilis_item", new AliasedBlockItem(ModBlocks.CAERULEA_VOLUBILIS, new FabricItemSettings()));

    //Vines
    public static final Item PINK_MUSHROOM_VINES_ITEM = registerItem("mushroom_vines_pink_item", new AliasedBlockItem(ModBlocks.PINK_MUSHROOM_VINES, new FabricItemSettings()));
    //Big Mushrooms
    public static final Item BIG_PURPLE_MUSHROOM_SEED = registerItem("mushroom_big_purple_seed", new AliasedBlockItem(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT, new FabricItemSettings()));
    public static final Item BIG_GREEN_MUSHROOM_SEED = registerItem("mushroom_big_green_seed", new AliasedBlockItem(ModBlocks.BIG_GREEN_MUSHROOM_PLANT, new FabricItemSettings()));
    public static final Item BOOST_MUSHROOM_ITEM = registerItem("mushroom_boost_item", new AliasedBlockItem(ModBlocks.MUSHROOM_BOOSTING, new FabricItemSettings()));
    public static final Item DANGEROUS_BOOST_MUSHROOM_ITEM = registerItem("mushroom_boost_dangerous_item", new AliasedBlockItem(ModBlocks.DANGEROUS_MUSHROOM_BOOSTING, new FabricItemSettings()));

    //food
    public static final Item BAGUETTE = registerItem("baguette", new Item(new FabricItemSettings().food(ModFoodComponents.BAGUETTE)));
    public static final Item LUMINESCENT_SCHROOM_SOUP = registerItem("luminescent_schroom_soup", new SchroomSoup(new FabricItemSettings().food(ModFoodComponents.BLUE_LUMINESCENT_SCHROOM_SOUP), ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE, new StatusEffectInstance(ModStatusEffects.FLICKERING, 3000, 0)));
    public static final Item FLEUR_BERRIES_ITEM = registerItem("fleur_berries_item", new AliasedBlockItem(ModBlocks.FLEUR_BERRIES, new FabricItemSettings()));
    public static final Item YELLOW_BERRIES = registerItem("berries_yellow", new Item(new FabricItemSettings().food(ModFoodComponents.YELLOW_BERRIES)));
    public static final Item COOKED_YELLOW_BERRIES = registerItem("berries_cooked_yellow", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_YELLOW_BERRIES)));

    //Lights
    public static final Item GREEN_TORCH = registerItem("torch_green_item", new VerticallyAttachableBlockItem(ModBlocks.GREEN_TORCH, ModBlocks.WALL_GREEN_TORCH, new Item.Settings(), Direction.DOWN));

    //Disc
    public static final Item HYMNE_FRANCAIS_MUSIC_DISC = registerItem("hymne_francais_music_disc", new MusicDiscItem(11, ModSounds.LA_MARSEILLAISE_DISC, new FabricItemSettings().maxCount(1), 80));
    public static final Item HYMNE_URSS_MUSIC_DISC = registerItem("hymne_urss_music_disc", new MusicDiscItem(10, ModSounds.HYMEN_URSS, new FabricItemSettings().maxCount(1), 210));

    //Egg
    public static final Item GROKI_SPAWN_EGG = registerItem("groki_spawn_egg", new SpawnEggItem(ModEntities.GROKI, 0x765A34, 0x1BC2CF, new FabricItemSettings()));
    public static final Item BOLETE_COW_SPAWN_EGG = registerItem("bolete_cow_spawn_egg", new SpawnEggItem(ModEntities.BOLETE_COW, 0xBF28DD, 0xF4DBF9, new FabricItemSettings()));
    public static final Item PLOTI_SPAWN_EGG = registerItem("ploti_spawn_egg", new SpawnEggItem(ModEntities.PLOTI, 0x674f35, 0x4e361c, new FabricItemSettings()));
    public static final Item CRYSTAL_CREEPER_SPAWN_EGG = registerItem("crystal_creeper_spawn_egg", new SpawnEggItem(ModEntities.CRYSTAL_CREEPER, 0x50D122, 0xDE310F, new FabricItemSettings()));
    public static final Item CRYSTAL_GOLEM_SPAWN_EGG = registerItem("crystal_golem_spawn_egg", new SpawnEggItem(ModEntities.CRYSTAL_GOLEM, 0x9A9A9A, 0xE57FF3, new FabricItemSettings()));
    public static final Item SCHROOM_STICK_SPAWN_EGG = registerItem("schroom_stick_spawn_egg", new SpawnEggItem(ModEntities.SCHROOM_STICK, 0xd3ccc4, 0xd81a1a, new FabricItemSettings()));
    //public static final Item MOSQUITO_SPAWN_EGG = registerItem("mosquito_spawn_egg", new SpawnEggItem(ModEntities.MOSQUITO_ENTITY, 0x897540, 0x222221, new FabricItemSettings()));


    //Crystals related
    public static final Item CRUSHED_DIAMOND = registerItem("crushed_diamond", new Item(new FabricItemSettings()));
    public static final Item PINK_CRYSTAL_ITEM = registerItem("crystal_pink_item", new AliasedBlockItem(ModBlocks.PINK_CRYSTAL, new FabricItemSettings()));
    public static final Item BLUE_CRYSTAL_ITEM = registerItem("crystal_blue_item", new AliasedBlockItem(ModBlocks.BLUE_CRYSTAL, new FabricItemSettings()));
    public static final Item RED_CRYSTAL_ITEM = registerItem("crystal_red_item", new AliasedBlockItem(ModBlocks.RED_CRYSTAL, new FabricItemSettings()));
    public static final Item AMBER_ITEM = registerItem("amber_item", new CrushableItems(new FabricItemSettings()));
    public static final Item CRUSHED_AMBER_ITEM = registerItem("amber_crushed_item", new Item(new FabricItemSettings()));
    //Tools
    public static final Item IRON_HAMMER = registerItem("iron_hammer", new HammerItem(ToolMaterials.IRON, 27, -3.8f, 4, new FabricItemSettings()));
    public static final Item KEY = registerItem("key", new KeyItem(new FabricItemSettings().maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MushrooomsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MushrooomsMod.LOGGER.info("registering mod items");
    }
}
