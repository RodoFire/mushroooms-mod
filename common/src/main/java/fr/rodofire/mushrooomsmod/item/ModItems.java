package fr.rodofire.mushrooomsmod.item;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.effect.ModStatusEffects;
import fr.rodofire.mushrooomsmod.entity.ModEntities;
import fr.rodofire.mushrooomsmod.item.custom.*;
import fr.rodofire.mushrooomsmod.platform.RegistryHandler;
import fr.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {
    public static final List<Supplier<Item>> ITEMS = new ArrayList<>();
    private static final RegistryHandler<Item> ITEM_HANDLER = new RegistryHandler<>(BuiltInRegistries.ITEM, ITEMS);

    public static final Supplier<Item> INVENTORY_ARMOR_STAND = registerItem("inventory_armor_stand_item", new InventoryArmorStandItem(new Item.Properties().stacksTo(16)));

    //Blocks
    public static final Supplier<Item> PURPLE_MUSHROOM_POWDER = registerItem("mushroom_powder_purple", new Item(new Item.Properties()));

    //Flowers
    public static final Supplier<Item> CAERULEA_VOLUBILIS_ITEM = registerItem("caerulea_volubilis_item", new ItemNameBlockItem(ModBlocks.CAERULEA_VOLUBILIS.get(), new Item.Properties()));

    //Vines
    public static final Supplier<Item> PINK_MUSHROOM_VINES_ITEM = registerItem("mushroom_vines_pink_item", new ItemNameBlockItem(ModBlocks.PINK_MUSHROOM_VINES.get(), new Item.Properties()));
    //Big Mushrooms
    public static final Supplier<Item> BIG_PURPLE_MUSHROOM_SEED = registerItem("mushroom_big_purple_seed", new ItemNameBlockItem(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get(), new Item.Properties()));
    public static final Supplier<Item> BIG_GREEN_MUSHROOM_SEED = registerItem("mushroom_big_green_seed", new ItemNameBlockItem(ModBlocks.BIG_GREEN_MUSHROOM_PLANT.get(), new Item.Properties()));
    public static final Supplier<Item> BOOST_MUSHROOM_ITEM = registerItem("mushroom_boost_item", new ItemNameBlockItem(ModBlocks.MUSHROOM_BOOSTING.get(), new Item.Properties()));
    public static final Supplier<Item> DANGEROUS_BOOST_MUSHROOM_ITEM = registerItem("mushroom_boost_dangerous_item", new ItemNameBlockItem(ModBlocks.DANGEROUS_MUSHROOM_BOOSTING.get(), new Item.Properties()));

    //food
    public static final Supplier<Item> BAGUETTE = registerItem("baguette", new Item(new Item.Properties().food(ModFoodComponents.BAGUETTE)));
    public static final Supplier<Item> LUMINESCENT_SCHROOM_SOUP = registerItem("luminescent_schroom_soup", new SchroomSoup(new Item.Properties().food(ModFoodComponents.BLUE_LUMINESCENT_SCHROOM_SOUP), ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE, new MobEffectInstance(ModStatusEffects.FLICKERING, 3000, 0)));
    public static final Supplier<Item> FLEUR_BERRIES_ITEM = registerItem("fleur_berries_item", new ItemNameBlockItem(ModBlocks.FLEUR_BERRIES.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_BERRIES = registerItem("berries_yellow", new Item(new Item.Properties().food(ModFoodComponents.YELLOW_BERRIES)));
    public static final Supplier<Item> COOKED_YELLOW_BERRIES = registerItem("berries_cooked_yellow", new Item(new Item.Properties().food(ModFoodComponents.COOKED_YELLOW_BERRIES)));

    //Lights
    public static final Supplier<Item> GREEN_TORCH = registerItem("torch_green_item", new StandingAndWallBlockItem(ModBlocks.GREEN_TORCH.get(), ModBlocks.WALL_GREEN_TORCH.get(), new Item.Properties(), Direction.DOWN));

    //Disc
    //public static final Supplier<Item> HYMNE_FRANCAIS_MUSIC_DISC = registerItem("hymne_francais_music_disc", new MusicDiscItem(11, ModSounds.LA_MARSEILLAISE_DISC, new Item.Settings().maxCount(1), 80));
    //public static final Supplier<Item> HYMNE_URSS_MUSIC_DISC = registerItem("hymne_urss_music_disc", new MusicDiscItem(10, ModSounds.HYMEN_URSS, new Item.Settings().maxCount(1), 210));

    //Egg
    public static final Supplier<Item> GROKI_SPAWN_EGG = registerItem("groki_spawn_egg", new SpawnEggItem(ModEntities.GROKI, 0x765A34, 0x1BC2CF, new Item.Properties()));
    public static final Supplier<Item> BOLETE_COW_SPAWN_EGG = registerItem("bolete_cow_spawn_egg", new SpawnEggItem(ModEntities.BOLETE_COW, 0xBF28DD, 0xF4DBF9, new Item.Properties()));
    public static final Supplier<Item> PLOTI_SPAWN_EGG = registerItem("ploti_spawn_egg", new SpawnEggItem(ModEntities.PLOTI, 0x674f35, 0x4e361c, new Item.Properties()));
    public static final Supplier<Item> CRYSTAL_CREEPER_SPAWN_EGG = registerItem("crystal_creeper_spawn_egg", new SpawnEggItem(ModEntities.CRYSTAL_CREEPER, 0x50D122, 0xDE310F, new Item.Properties()));
    public static final Supplier<Item> CRYSTAL_GOLEM_SPAWN_EGG = registerItem("crystal_golem_spawn_egg", new SpawnEggItem(ModEntities.CRYSTAL_GOLEM, 0x9A9A9A, 0xE57FF3, new Item.Properties()));
    public static final Supplier<Item> SCHROOM_STICK_SPAWN_EGG = registerItem("schroom_stick_spawn_egg", new SpawnEggItem(ModEntities.SCHROOM_STICK, 0xd3ccc4, 0xd81a1a, new Item.Properties()));
    public static final Supplier<Item> SQUIRREL_STICK_SPAWN_EGG = registerItem("squirrel_spawn_egg", new SpawnEggItem(ModEntities.SQUIRREL, 0xedad34, 0xffeecd, new Item.Properties()));


    //Crystals related
    public static final Supplier<Item> CRUSHED_DIAMOND = registerItem("crushed_diamond", new Item(new Item.Properties()));
    //public static final Supplier<Item> PINK_CRYSTAL_ITEM = registerItem("crystal_pink_item", new AliasedBlockItem(ModBlocks.PINK_CRYSTAL, new Item.Settings()));
    public static final Supplier<Item> BLUE_CRYSTAL_ITEM = registerItem("crystal_blue_item", new ItemNameBlockItem(ModBlocks.BLUE_CRYSTAL.get(), new Item.Properties()));
    public static final Supplier<Item> RED_CRYSTAL_ITEM = registerItem("crystal_red_item", new ItemNameBlockItem(ModBlocks.RED_CRYSTAL.get(), new Item.Properties()));
    public static final Supplier<Item> AMBER_ITEM = registerItem("amber_item", new CrushableItems(new Item.Properties()));
    public static final Supplier<Item> CRUSHED_AMBER_ITEM = registerItem("amber_crushed_item", new Item(new Item.Properties()));
    //Tools
    public static final Supplier<Item> IRON_HAMMER = registerItem("iron_hammer", new HammerItem(Tiers.IRON, 27, new Item.Properties()));
    public static final Supplier<Item> KEY = registerItem("key", new KeyItem(new Item.Properties().stacksTo(1).component(DataComponents.CUSTOM_DATA, CustomData.of(new CompoundTag()))));


    private static Supplier<Item> registerItem(String name, Item item) {
        Supplier<Item> itemSupplier = () -> item;
        return ITEM_HANDLER.register(name, itemSupplier);
    }

    public static void registerModItems() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Items");
    }
}
