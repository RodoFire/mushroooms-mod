package net.rodofire.mushrooomsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup MUSHROOM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MushrooomsMod.MOD_ID, "luminescent_mushroom"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mushroooms"))
                    .icon(() -> new ItemStack(ModBlocks.BLUE_LUMINESCENT_MUSHROOM)).entries((displayContext, entries) -> {
                        //Blocks
                        //Wood
                        entries.add(ModBlocks.BLUE_LUMINESCENT_LOG);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_WOOD);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_PLANKS);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_STAIRS);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_SLAB);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_FENCE);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_DOOR);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_BUTTON);

                        entries.add(ModBlocks.PELTOGYNE_LOG);
                        entries.add(ModBlocks.PELTOGYNE_WOOD);
                        entries.add(ModBlocks.PELTOGYNE_STRIPPED_LOG);
                        entries.add(ModBlocks.PELTOGYNE_STRIPPED_WOOD);
                        entries.add(ModBlocks.PELTOGYNE_PLANKS);
                        entries.add(ModBlocks.PELTOGYNE_STAIRS);
                        entries.add(ModBlocks.PELTOGYNE_SLAB);
                        entries.add(ModBlocks.PELTOGYNE_FENCE);
                        entries.add(ModBlocks.PELTOGYNE_FENCE_GATE);
                        entries.add(ModBlocks.PELTOGYNE_DOOR);
                        entries.add(ModBlocks.PELTOGYNE_TRAPDOOR);
                        entries.add(ModBlocks.PELTOGYNE_PRESSURE_PLATE);
                        entries.add(ModBlocks.PELTOGYNE_BUTTON);

                        //Building Blocks
                        entries.add(ModBlocks.LAVA_BLACKSTONE);
                        entries.add(ModBlocks.LAVA_BLACKSTONE_BRICKS);
                        entries.add(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);
                        entries.add(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS);

                        //Crystal related
                        entries.add(ModBlocks.RAW_AMBER_BLOCK);
                        entries.add(ModBlocks.AMBER_MINERAL);
                        entries.add(ModBlocks.AMBER_BLOCK);
                        entries.add(ModBlocks.AMBER_BLOCK_SANDIFIED);
                        entries.add(ModBlocks.AMBER_ORE);

                        //Idk
                        entries.add(ModBlocks.CLOUD_BLOCK);


                        //Natural
                        //Mushroom Related
                        entries.add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.BLUE_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.PURPLE_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.GREEN_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.YELLOW_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.ORANGE_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(Blocks.RED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(Blocks.BROWN_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM);
                        entries.add(ModBlocks.TRANSPARENT_MUSHROOM_STEM);
                        entries.add(ModBlocks.GREEN_MUSHROOM_STEM);
                        entries.add(ModBlocks.COMPRESSED_PURPLE_MUSHROOM);

                        //Soft Blocks
                        entries.add(ModBlocks.COMPRESSED_DIRT);
                        entries.add(ModBlocks.LIGHT_COMPRESSED_DIRT);

                        //Hard Blocks
                        entries.add(ModBlocks.PURPLE_SCHROOM_DEESLATE);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE);
                        entries.add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT);
                        entries.add(ModBlocks.RHYOLITE);
                        entries.add(ModBlocks.RHYOLITE_TILES);

                        /*-------------------- Natural Blocks --------------------*/
                        //Leaves
                        entries.add(ModBlocks.BLUE_LUMINESCENT_LEAVES);
                        entries.add(ModBlocks.BLUE_COLORFUL_LEAVES);
                        entries.add(ModBlocks.PURPLE_COLORFUL_LEAVES);
                        entries.add(ModBlocks.GREEN_COLORFUL_LEAVES);
                        entries.add(ModBlocks.YELLOW_COLORFUL_LEAVES);
                        entries.add(ModBlocks.ORANGE_COLORFUL_LEAVES);
                        entries.add(ModBlocks.RED_COLORFUL_LEAVES);
                        entries.add(ModBlocks.PINK_COLORFUL_LEAVES);
                        entries.add(ModBlocks.OAK_BERRIES_LEAVES);
                        entries.add(ModBlocks.PELTOGYNE_LEAVES);

                        //Mushrooms
                        entries.add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM);
                        entries.add(ModBlocks.BLUE_MUSHROOM);
                        entries.add(ModBlocks.PURPLE_MUSHROOM);
                        entries.add(ModBlocks.GREEN_MUSHROOM);
                        entries.add(ModBlocks.YELLOW_MUSHROOM);
                        entries.add(ModBlocks.ORANGE_MUSHROOM);
                        entries.add(Blocks.RED_MUSHROOM);
                        entries.add(ModBlocks.FERTILE_RED_MUSHROOM);
                        entries.add(ModBlocks.LUMINESCENT_PINK_MUSHROOM);
                        entries.add(Blocks.BROWN_MUSHROOM);

                        //Sapling
                        entries.add(ModBlocks.BLUE_LUMINESCENT_SAPPLING);
                        entries.add(ModBlocks.OAK_BERRIES_SAPLING);
                        entries.add(ModBlocks.PELTOGYNE_SAPLING);
                        entries.add(ModBlocks.COLORFUL_TREE_SAPLING);

                        //Flowers Mushrooms
                        entries.add(ModBlocks.STERILE_BLUE_MUSHROOM);
                        entries.add(ModBlocks.MUSHROOM_SMALL_BROWN);
                        entries.add(ModBlocks.MUSHROOM_SMALL_RED);
                        entries.add(ModBlocks.MUSHROOM_DEATH_TRUMPET);

                        //Side Mushrooms
                        entries.add(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT);
                        entries.add(ModBlocks.LOG_MUSHROOM_BROWN);

                        //Flowers
                        entries.add(ModBlocks.PREHISTO_PINK_SCHROOM);
                        entries.add(ModBlocks.PREHISTO_BLUE_SCHROOM);
                        entries.add(ModBlocks.PREHISTURPLE_SCHROOM);
                        entries.add(ModBlocks.PREHISTO_GREEN_SCHROOM);
                        entries.add(ModBlocks.MUSHROOM_FLOWERS);
                        entries.add(ModBlocks.RED_LUMERIA);
                        entries.add(ModBlocks.SOL_OCCIDENTIS);
                        entries.add(ModBlocks.CYANUS_RUBENS);
                        entries.add(ModBlocks.CYANEA);
                        entries.add(ModBlocks.FUTIALI);
                        entries.add(ModBlocks.NOCTULICA);
                        entries.add(ModBlocks.TURQUOSUM_STILUS);
                        entries.add(ModBlocks.SAPHIRA_FLORENS);
                        entries.add(ModBlocks.PREHISTORIC_ROSE);
                        entries.add(ModBlocks.ORANGE_PERENNIAL);
                        entries.add(ModBlocks.BLUE_PERENNIAL);
                        entries.add(ModBlocks.GREEN_PERENNIAL);
                        entries.add(ModBlocks.PINK_PERENNIAL);
                        entries.add(ModBlocks.LUMINESCENT_PERENNIAL);
                        entries.add(ModBlocks.PURPLE_PERENNIAL);
                        entries.add(ModBlocks.YELLOW_PERENNIAL);
                        entries.add(ModBlocks.YELLOW_QUINCE);
                        entries.add(ModBlocks.RED_QUINCE);
                        entries.add(ModBlocks.TINY_LILAC);
                        entries.add(ModBlocks.OCULAE);
                        entries.add(ModBlocks.YELICE);
                        entries.add(ModBlocks.FLAMESTHYSIA);
                        entries.add(ModBlocks.APAGANTHE);
                        entries.add(ModBlocks.PINK_HEATER);
                        entries.add(ModBlocks.WYSTERIA);
                        entries.add(ModBlocks.BLUEBELL);
                        entries.add(ModBlocks.VIPERIN);
                        entries.add(ModBlocks.HIBISCUS);
                        entries.add(ModBlocks.PLATUM);
                        entries.add(ModBlocks.DIANTHUS);
                        entries.add(ModBlocks.CYCAS);
                        entries.add(ModBlocks.ARUM);
                        entries.add(ModBlocks.HYDRANGEA);
                        entries.add(ModBlocks.ANEMONE);
                        entries.add(ModBlocks.JACYNTHE);
                        entries.add(ModBlocks.ACONIT);
                        entries.add(ModBlocks.PERVENCHE);
                        entries.add(ModBlocks.RAPANGE_FLOWERS);
                        entries.add(ModItems.FLEUR_BERRIES_ITEM);
                        entries.add(ModBlocks.PICK_BLUE);

                        //Grass
                        entries.add(ModBlocks.TINY_GRASS);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_GRASS);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS);

                        //Vines
                        entries.add(ModItems.CAERULEA_VOLUBILIS_ITEM);
                        entries.add(ModItems.PINK_MUSHROOM_VINES_ITEM);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_VINES);

                        //Big Mushrooms
                        entries.add(ModItems.BIG_PURPLE_MUSHROOM_SEED);
                        entries.add(ModItems.BIG_GREEN_MUSHROOM_SEED);
                        entries.add(ModItems.PURPLE_MUSHROOM_POWDER);
                        entries.add(ModBlocks.TINY_PURPLE_MUSHROOM);
                        entries.add(ModBlocks.LITTLE_PURPLE_MUSHROOM);
                        entries.add(ModBlocks.MEDIUM_PURPLE_MUSHROOM);
                        entries.add(ModBlocks.BIG_PURPLE_MUSHROOM);
                        entries.add(ModBlocks.TINY_GREEN_MUSHROOM);
                        entries.add(ModBlocks.LITTLE_GREEN_MUSHROOM);
                        entries.add(ModBlocks.MEDIUM_GREEN_MUSHROOM);
                        entries.add(ModBlocks.BIG_GREEN_MUSHROOM);
                        entries.add(ModItems.BOOST_MUSHROOM_ITEM);
                        entries.add(ModItems.DANGEROUS_BOOST_MUSHROOM_ITEM);


                        //Light Blocks
                        entries.add(ModBlocks.GREEN_LANTERN);
                        entries.add(ModBlocks.RED_LANTERN);
                        entries.add(ModItems.GREEN_TORCH);
                        entries.add(ModBlocks.GREEN_CAMPFIRE);


                        //Music Disk
                        entries.add(ModItems.HYMNE_FRANCAIS_MUSIC_DISC);
                        entries.add(ModItems.HYMNE_URSS_MUSIC_DISC);

                        entries.add(ModItems.GROKI_SPAWN_EGG);
                        entries.add(ModItems.BOLETE_COW_SPAWN_EGG);
                        entries.add(ModItems.PLOTI_SPAWN_EGG);
                        entries.add(ModItems.CRYSTAL_CREEPER_SPAWN_EGG);
                        entries.add(ModItems.CRYSTAL_GOLEM_SPAWN_EGG);
                        //entries.add(ModItems.MOSQUITO_SPAWN_EGG);
                        //entries.add(ModItems.SCHROOM_STICK_SPAWN_EGG);

                        //crystal
                        entries.add(ModItems.PINK_CRYSTAL_ITEM);
                        entries.add(ModBlocks.PINK_CRYSTAL_BLOCK);

                        entries.add(ModItems.BLUE_CRYSTAL_ITEM);
                        entries.add(ModBlocks.BLUE_CRYSTAL_BLOCK);
                        entries.add(ModItems.RED_CRYSTAL_ITEM);
                        entries.add(ModBlocks.RED_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.WHITE_CRYSTAL);
                        entries.add(ModBlocks.WHITE_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.BLUE_CRYSTAL_CLUSTER);

                        entries.add(ModItems.CRUSHED_DIAMOND);
                        entries.add(ModItems.AMBER_ITEM);
                        entries.add(ModItems.CRUSHED_AMBER_ITEM);

                        //Utils
                        entries.add(ModBlocks.FORGE_BLOCK);

                        //Tools
                        entries.add(ModItems.IRON_HAMMER);
                        entries.add(ModItems.INVENTORY_ARMOR_STAND);
                        entries.add(ModItems.KEY);

                        //Food
                        entries.add(ModItems.BAGUETTE);
                        entries.add(ModItems.LUMINESCENT_SCHROOM_SOUP);
                        entries.add(ModItems.YELLOW_BERRIES);
                        entries.add(ModItems.COOKED_YELLOW_BERRIES);

                        //dev
                        //entries.add(ModBlocks.FEATURE_TESTER);


                    }).build());

    public static void registerItemGroup() {
        MushrooomsMod.LOGGER.info("Registering Mod Item Group for Mushrooomsmod");
    }
}
