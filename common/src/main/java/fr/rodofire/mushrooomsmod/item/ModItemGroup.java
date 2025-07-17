package fr.rodofire.mushrooomsmod.item;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.platform.Services;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItemGroup {
    private static final List<Supplier<Item>> ITEMS = new ArrayList<>();
    public static Supplier<CreativeModeTab> MUSHROOOMS_GROUP;

  /*  public static final CreativeModeTab MUSHROOM_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "luminescent_mushroom"),
            FabricItemGroup.builder().title(Component.translatable("itemgroup.mushroooms"))
                    .icon(() -> new ItemStack(ModBlocks.BLUE_LUMINESCENT_MUSHROOM)).displayItems((displayContext, entries) -> {
                        //Blocks
                        //Wood
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_LOG);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_WOOD);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_PLANKS);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_STAIRS);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_SLAB);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_FENCE);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_FENCE_GATE);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_DOOR);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_TRAPDOOR);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_BUTTON);

                        ITEMS.add() (ModBlocks.PELTOGYNE_LOG);
                        ITEMS.add() (ModBlocks.PELTOGYNE_WOOD);
                        ITEMS.add() (ModBlocks.PELTOGYNE_STRIPPED_LOG);
                        ITEMS.add() (ModBlocks.PELTOGYNE_STRIPPED_WOOD);
                        ITEMS.add() (ModBlocks.PELTOGYNE_PLANKS);
                        ITEMS.add() (ModBlocks.PELTOGYNE_STAIRS);
                        ITEMS.add() (ModBlocks.PELTOGYNE_SLAB);
                        ITEMS.add() (ModBlocks.PELTOGYNE_FENCE);
                        ITEMS.add() (ModBlocks.PELTOGYNE_FENCE_GATE);
                        ITEMS.add() (ModBlocks.PELTOGYNE_DOOR);
                        ITEMS.add() (ModBlocks.PELTOGYNE_TRAPDOOR);
                        ITEMS.add() (ModBlocks.PELTOGYNE_PRESSURE_PLATE);
                        ITEMS.add() (ModBlocks.PELTOGYNE_BUTTON);

                        //Building Blocks
                        ITEMS.add() (ModBlocks.LAVA_BLACKSTONE);
                        ITEMS.add() (ModBlocks.LAVA_BLACKSTONE_BRICKS);
                        ITEMS.add() (ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);
                        ITEMS.add() (ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS);

                        //Crystal related
                        ITEMS.add() (ModBlocks.RAW_AMBER_BLOCK);
                        ITEMS.add() (ModBlocks.AMBER_MINERAL);
                        ITEMS.add() (ModBlocks.AMBER_BLOCK);
                        ITEMS.add() (ModBlocks.AMBER_BLOCK_SANDIFIED);
                        ITEMS.add() (ModBlocks.AMBER_ORE);

                        //Idk
                        ITEMS.add() (ModBlocks.CLOUD_BLOCK);


                        //Natural
                        //Mushroom Related
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (ModBlocks.BLUE_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (ModBlocks.PURPLE_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (ModBlocks.GREEN_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (ModBlocks.YELLOW_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (ModBlocks.ORANGE_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (Blocks.RED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.RED_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (Blocks.BROWN_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK);
                        ITEMS.add() (ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK);

                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM);
                        ITEMS.add() (ModBlocks.TRANSPARENT_MUSHROOM_STEM);
                        ITEMS.add() (ModBlocks.GREEN_MUSHROOM_STEM);
                        ITEMS.add() (ModBlocks.COMPRESSED_PURPLE_MUSHROOM);

                        //Soft Blocks
                        ITEMS.add() (ModBlocks.COMPRESSED_DIRT);
                        ITEMS.add() (ModBlocks.LIGHT_COMPRESSED_DIRT);

                        //Hard Blocks
                        ITEMS.add() (ModBlocks.PURPLE_SCHROOM_DEESLATE);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE);
                        ITEMS.add() (ModBlocks.GREEN_STONY_SCHROOM_DEPOT);
                        ITEMS.add() (ModBlocks.RHYOLITE);
                        ITEMS.add() (ModBlocks.RHYOLITE_TILES);

                        /*-------------------- Natural Blocks --------------------
                        //Leaves
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_LEAVES);
                        ITEMS.add() (ModBlocks.BLUE_COLORFUL_LEAVES);
                        ITEMS.add() (ModBlocks.PURPLE_COLORFUL_LEAVES);
                        ITEMS.add() (ModBlocks.GREEN_COLORFUL_LEAVES);
                        ITEMS.add() (ModBlocks.YELLOW_COLORFUL_LEAVES);
                        ITEMS.add() (ModBlocks.ORANGE_COLORFUL_LEAVES);
                        ITEMS.add() (ModBlocks.RED_COLORFUL_LEAVES);
                        ITEMS.add() (ModBlocks.PINK_COLORFUL_LEAVES);
                        ITEMS.add() (ModBlocks.OAK_BERRIES_LEAVES);
                        ITEMS.add() (ModBlocks.PELTOGYNE_LEAVES);

                        //Mushrooms
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_MUSHROOM);
                        ITEMS.add() (ModBlocks.BLUE_MUSHROOM);
                        ITEMS.add() (ModBlocks.PURPLE_MUSHROOM);
                        ITEMS.add() (ModBlocks.GREEN_MUSHROOM);
                        ITEMS.add() (ModBlocks.YELLOW_MUSHROOM);
                        ITEMS.add() (ModBlocks.ORANGE_MUSHROOM);
                        ITEMS.add() (Blocks.RED_MUSHROOM);
                        ITEMS.add() (ModBlocks.FERTILE_RED_MUSHROOM);
                        ITEMS.add() (ModBlocks.LUMINESCENT_PINK_MUSHROOM);
                        ITEMS.add() (Blocks.BROWN_MUSHROOM);

                        //Sapling
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_SAPPLING);
                        ITEMS.add() (ModBlocks.OAK_BERRIES_SAPLING);
                        ITEMS.add() (ModBlocks.PELTOGYNE_SAPLING);
                        ITEMS.add() (ModBlocks.COLORFUL_TREE_SAPLING);

                        //Flowers Mushrooms
                        ITEMS.add() (ModBlocks.STERILE_BLUE_MUSHROOM);
                        ITEMS.add() (ModBlocks.MUSHROOM_SMALL_BROWN);
                        ITEMS.add() (ModBlocks.MUSHROOM_SMALL_RED);
                        ITEMS.add() (ModBlocks.MUSHROOM_DEATH_TRUMPET);
                        ITEMS.add() (ModBlocks.BUSHY_YELLOW_MUSHROOM);
                        ITEMS.add() (ModBlocks.BRIGHT_YELLOW_MUSHROOM);
                        ITEMS.add() (ModBlocks.TALL_YELLOW_MUSHROOMS);

                        //Side Mushrooms
                        ITEMS.add() (ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT);
                        ITEMS.add() (ModBlocks.LOG_MUSHROOM_BROWN);

                        //Flowers
                        ITEMS.add() (ModBlocks.PREHISTO_PINK_SCHROOM);
                        ITEMS.add() (ModBlocks.PREHISTO_BLUE_SCHROOM);
                        ITEMS.add() (ModBlocks.PREHISTURPLE_SCHROOM);
                        ITEMS.add() (ModBlocks.PREHISTO_GREEN_SCHROOM);
                        ITEMS.add() (ModBlocks.MUSHROOM_FLOWERS);
                        ITEMS.add() (ModBlocks.RED_LUMERIA);
                        ITEMS.add() (ModBlocks.SOL_OCCIDENTIS);
                        ITEMS.add() (ModBlocks.CYANUS_RUBENS);
                        ITEMS.add() (ModBlocks.CYANEA);
                        ITEMS.add() (ModBlocks.FUTIALI);
                        ITEMS.add() (ModBlocks.NOCTULICA);
                        ITEMS.add() (ModBlocks.TURQUOSUM_STILUS);
                        ITEMS.add() (ModBlocks.SAPHIRA_FLORENS);
                        ITEMS.add() (ModBlocks.PREHISTORIC_ROSE);
                        ITEMS.add() (ModBlocks.ORANGE_PERENNIAL);
                        ITEMS.add() (ModBlocks.BLUE_PERENNIAL);
                        ITEMS.add() (ModBlocks.GREEN_PERENNIAL);
                        ITEMS.add() (ModBlocks.PINK_PERENNIAL);
                        ITEMS.add() (ModBlocks.LUMINESCENT_PERENNIAL);
                        ITEMS.add() (ModBlocks.PURPLE_PERENNIAL);
                        ITEMS.add() (ModBlocks.YELLOW_PERENNIAL);
                        ITEMS.add() (ModBlocks.YELLOW_QUINCE);
                        ITEMS.add() (ModBlocks.RED_QUINCE);
                        ITEMS.add() (ModBlocks.TINY_LILAC);
                        ITEMS.add() (ModBlocks.OCULAE);
                        ITEMS.add() (ModBlocks.YELICE);
                        ITEMS.add() (ModBlocks.FLAMESTHYSIA);
                        ITEMS.add() (ModBlocks.APAGANTHE);
                        ITEMS.add() (ModBlocks.PINK_HEATER);
                        ITEMS.add() (ModBlocks.WYSTERIA);
                        ITEMS.add() (ModBlocks.BLUEBELL);
                        ITEMS.add() (ModBlocks.VIPERIN);
                        ITEMS.add() (ModBlocks.HIBISCUS);
                        ITEMS.add() (ModBlocks.PLATUM);
                        ITEMS.add() (ModBlocks.DIANTHUS);
                        ITEMS.add() (ModBlocks.CYCAS);
                        ITEMS.add() (ModBlocks.ARUM);
                        ITEMS.add() (ModBlocks.HYDRANGEA);
                        ITEMS.add() (ModBlocks.ANEMONE);
                        ITEMS.add() (ModBlocks.JACYNTHE);
                        ITEMS.add() (ModBlocks.ACONIT);
                        ITEMS.add() (ModBlocks.PERVENCHE);
                        ITEMS.add() (ModBlocks.RAPANGE_FLOWERS);
                        ITEMS.add() (ModItems.FLEUR_BERRIES_ITEM);
                        ITEMS.add() (ModBlocks.PICK_BLUE);

                        //Grass
                        ITEMS.add() (ModBlocks.TINY_GRASS);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_GRASS);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_TALL_GRASS);

                        //Vines
                        ITEMS.add() (ModItems.CAERULEA_VOLUBILIS_ITEM);
                        ITEMS.add() (ModItems.PINK_MUSHROOM_VINES_ITEM);
                        ITEMS.add() (ModBlocks.BLUE_LUMINESCENT_VINES);

                        //Big Mushrooms
                        ITEMS.add() (ModItems.BIG_PURPLE_MUSHROOM_SEED);
                        ITEMS.add() (ModItems.BIG_GREEN_MUSHROOM_SEED);
                        ITEMS.add() (ModItems.PURPLE_MUSHROOM_POWDER);
                        ITEMS.add() (ModBlocks.TINY_PURPLE_MUSHROOM);
                        ITEMS.add() (ModBlocks.LITTLE_PURPLE_MUSHROOM);
                        ITEMS.add() (ModBlocks.MEDIUM_PURPLE_MUSHROOM);
                        ITEMS.add() (ModBlocks.BIG_PURPLE_MUSHROOM);
                        ITEMS.add() (ModBlocks.TINY_GREEN_MUSHROOM);
                        ITEMS.add() (ModBlocks.LITTLE_GREEN_MUSHROOM);
                        ITEMS.add() (ModBlocks.MEDIUM_GREEN_MUSHROOM);
                        ITEMS.add() (ModBlocks.BIG_GREEN_MUSHROOM);
                        ITEMS.add() (ModItems.BOOST_MUSHROOM_ITEM);
                        ITEMS.add() (ModItems.DANGEROUS_BOOST_MUSHROOM_ITEM);


                        //Light Blocks
                        ITEMS.add() (ModBlocks.GREEN_LANTERN);
                        ITEMS.add() (ModBlocks.RED_LANTERN);
                        ITEMS.add() (ModItems.GREEN_TORCH);
                        ITEMS.add() (ModBlocks.GREEN_CAMPFIRE);


                        //Music Disk
                        //entries.add(ModItems.HYMNE_FRANCAIS_MUSIC_DISC);
                        //entries.add(ModItems.HYMNE_URSS_MUSIC_DISC);

                        ITEMS.add() (ModItems.GROKI_SPAWN_EGG);
                        ITEMS.add() (ModItems.BOLETE_COW_SPAWN_EGG);
                        ITEMS.add() (ModItems.PLOTI_SPAWN_EGG);
                        ITEMS.add() (ModItems.CRYSTAL_CREEPER_SPAWN_EGG);
                        ITEMS.add() (ModItems.CRYSTAL_GOLEM_SPAWN_EGG);
                        ITEMS.add() (ModItems.SCHROOM_STICK_SPAWN_EGG);
                        ITEMS.add() (ModItems.SQUIRREL_STICK_SPAWN_EGG);

                        //crystal
                        //entries.add(ModItems.PINK_CRYSTAL_ITEM);
                        ITEMS.add() (ModBlocks.PINK_CRYSTAL_BLOCK);

                        ITEMS.add() (ModItems.BLUE_CRYSTAL_ITEM);
                        ITEMS.add() (ModBlocks.BLUE_CRYSTAL_BLOCK);
                        ITEMS.add() (ModItems.RED_CRYSTAL_ITEM);
                        ITEMS.add() (ModBlocks.RED_CRYSTAL_BLOCK);
                        ITEMS.add() (ModBlocks.WHITE_CRYSTAL);
                        ITEMS.add() (ModBlocks.WHITE_CRYSTAL_BLOCK);
                        ITEMS.add() (ModBlocks.BLUE_CRYSTAL_CLUSTER);

                        ITEMS.add() (ModItems.CRUSHED_DIAMOND);
                        ITEMS.add() (ModItems.AMBER_ITEM);
                        ITEMS.add() (ModItems.CRUSHED_AMBER_ITEM);

                        //Utils
                        ITEMS.add() (ModBlocks.FORGE_BLOCK);

                        //Tools
                        ITEMS.add() (ModItems.IRON_HAMMER);
                        ITEMS.add() (ModItems.INVENTORY_ARMOR_STAND);
                        ITEMS.add() (ModItems.KEY);

                        //Food
                        ITEMS.add() (ModItems.BAGUETTE);
                        ITEMS.add() (ModItems.LUMINESCENT_SCHROOM_SOUP);
                        ITEMS.add() (ModItems.YELLOW_BERRIES);
                        ITEMS.add() (ModItems.COOKED_YELLOW_BERRIES);

                        //dev
                        //entries.add(ModBlocks.FEATURE_TESTER);


                    }).build());*/

    public static void registerItemGroup() {
        MushrooomsModConstants.LOGGER.info("|\tRegistering Item Group");
        ITEMS.addAll(ModBlocks.BLOCK_ITEMS);
        ITEMS.addAll(ModItems.ITEMS);

        MUSHROOOMS_GROUP = Services.PLATFORM.createCreativeTab("itemgroup.mushroooms", () -> new ItemStack(ModBlocks.BLUE_LUMINESCENT_MUSHROOM.get()), ITEMS);
    }
}
