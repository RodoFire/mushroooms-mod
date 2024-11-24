package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        //Blocks
        //Mushrooms Blocks
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.ORANGE_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.YELLOW_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.BLUE_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.GREEN_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK);


        generator.registerSimpleCubeAll(ModBlocks.TRANSPARENT_MUSHROOM_STEM);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_MUSHROOM_STEM);
        generator.registerSimpleCubeAll(ModBlocks.COMPRESSED_PURPLE_MUSHROOM);

        //Soft Blocks
        generator.registerSimpleCubeAll(ModBlocks.COMPRESSED_DIRT);
        generator.registerSimpleCubeAll(ModBlocks.LIGHT_COMPRESSED_DIRT);

        //Hard Blocks
        generator.registerSimpleCubeAll(ModBlocks.RHYOLITE);
        generator.registerSimpleCubeAll(ModBlocks.RHYOLITE_TILES);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_BLACKSTONE);

        //Potted Flowers
        generator.registerFlowerPotPlant(ModBlocks.BLUE_MUSHROOM, ModBlocks.POTTED_BLUE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.GREEN_MUSHROOM, ModBlocks.POTTED_GREEN_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PURPLE_MUSHROOM, ModBlocks.POTTED_PURPLE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.BLUE_LUMINESCENT_MUSHROOM, ModBlocks.POTTED_BLUE_LUMINESCENT_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.LUMINESCENT_PINK_MUSHROOM, ModBlocks.POTTED_LUMINESCENT_PINK_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.YELLOW_MUSHROOM, ModBlocks.POTTED_YELLOW_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.ORANGE_MUSHROOM, ModBlocks.POTTED_ORANGE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.FERTILE_RED_MUSHROOM, ModBlocks.POTTED_FERTILE_RED_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);

        generator.registerFlowerPotPlant(ModBlocks.OCULAE, ModBlocks.POTTED_OCULAE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.CYANEA, ModBlocks.POTTED_CYANEA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.CYANUS_RUBENS, ModBlocks.POTTED_CYANUS_RUBENS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.SOL_OCCIDENTIS, ModBlocks.POTTED_SOL_OCCIDENTIS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.FUTIALI, ModBlocks.POTTED_FUTIALI, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.NOCTULICA, ModBlocks.POTTED_NOCTULICA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTORIC_ROSE, ModBlocks.POTTED_PREHISTORIC_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTO_PINK_SCHROOM, ModBlocks.POTTED_PREHISTO_PINK_SCHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTO_BLUE_SCHROOM, ModBlocks.POTTED_PREHISTO_BLUE_SCHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTURPLE_SCHROOM, ModBlocks.POTTED_PREHISTURPLE_SCHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTO_GREEN_SCHROOM, ModBlocks.POTTED_PREHISTO_GREEN_SCHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);

        generator.registerFlowerPotPlant(ModBlocks.ORANGE_PERENNIAL, ModBlocks.POTTED_ORANGE_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.BLUE_PERENNIAL, ModBlocks.POTTED_BLUE_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PURPLE_PERENNIAL, ModBlocks.POTTED_PURPLE_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.GREEN_PERENNIAL, ModBlocks.POTTED_GREEN_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.LUMINESCENT_PERENNIAL, ModBlocks.POTTED_LUMINESCENT_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.YELLOW_PERENNIAL, ModBlocks.POTTED_YELLOW_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PINK_PERENNIAL, ModBlocks.POTTED_PINK_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);

        generator.registerFlowerPotPlant(ModBlocks.RED_QUINCE, ModBlocks.POTTED_RED_QUINCE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.YELLOW_QUINCE, ModBlocks.POTTED_YELLOW_QUINCE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.YELICE, ModBlocks.POTTED_YELICE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.FLAMESTHYSIA, ModBlocks.POTTED_FLAMESTHYSIA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.APAGANTHE, ModBlocks.POTTED_APAGANTHE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.WYSTERIA, ModBlocks.POTTED_WYSTERIA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.BLUEBELL, ModBlocks.POTTED_BLUEBELL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.VIPERIN, ModBlocks.POTTED_VIPERIN, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.HIBISCUS, ModBlocks.POTTED_HIBISCUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PLATUM, ModBlocks.POTTED_PLATUM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.DIANTHUS, ModBlocks.POTTED_DIANTHUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.CYCAS, ModBlocks.POTTED_CYCAS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.ARUM, ModBlocks.POTTED_ARUM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.HYDRANGEA, ModBlocks.POTTED_HYDRANGEA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.ANEMONE, ModBlocks.POTTED_ANEMONE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.JACYNTHE, ModBlocks.POTTED_JACYNTHE, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Potted Flowers Mushrooms
        generator.registerFlowerPotPlant(ModBlocks.STERILE_BLUE_MUSHROOM, ModBlocks.POTTED_STERILE_BLUE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.MUSHROOM_SMALL_BROWN, ModBlocks.POTTED_MUSHROOM_SMALL_BROWN, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.MUSHROOM_SMALL_RED, ModBlocks.POTTED_MUSHROOM_SMALL_RED, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.MUSHROOM_DEATH_TRUMPET, ModBlocks.POTTED_MUSHROOM_DEATH_TRUMPET, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Potted Sapplings
        generator.registerFlowerPotPlant(ModBlocks.BLUE_LUMINESCENT_SAPPLING, ModBlocks.POTTED_BLUE_LUMINESCENT_SAPPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.OAK_BERRIES_SAPLING, ModBlocks.POTTED_OAK_BERRIES_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PELTOGYNE_SAPLING, ModBlocks.POTTED_PELTOGYNE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.COLORFUL_TREE_SAPLING, ModBlocks.POTTED_COLORFUL_TREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Vines
        generator.registerTintableCross(ModBlocks.BLUE_LUMINESCENT_VINES, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Grass
        generator.registerTintableCross(ModBlocks.TINY_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerTintableCross(ModBlocks.BLUE_LUMINESCENT_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerDoubleBlock(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS, BlockStateModelGenerator.TintType.TINTED);

        //Leaves
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_LEAVES);
        generator.registerSimpleCubeAll(ModBlocks.RED_COLORFUL_LEAVES);
        generator.registerSimpleCubeAll(ModBlocks.PINK_COLORFUL_LEAVES);
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_COLORFUL_LEAVES);
        generator.registerSimpleCubeAll(ModBlocks.YELLOW_COLORFUL_LEAVES);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_COLORFUL_LEAVES);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_COLORFUL_LEAVES);
        generator.registerSimpleCubeAll(ModBlocks.ORANGE_COLORFUL_LEAVES);


        //Lights
        generator.registerLantern(ModBlocks.RED_LANTERN);
        generator.registerLantern(ModBlocks.GREEN_LANTERN);
        generator.registerTorch(ModBlocks.GREEN_TORCH, ModBlocks.WALL_GREEN_TORCH);

        //Construction Blocks
        generator.registerSimpleCubeAll(ModBlocks.LAVA_BLACKSTONE_BRICKS);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS);
        //Wood
        generator.registerLog(ModBlocks.BLUE_LUMINESCENT_LOG).log(ModBlocks.BLUE_LUMINESCENT_LOG).wood(ModBlocks.BLUE_LUMINESCENT_WOOD);
        generator.registerLog(ModBlocks.PELTOGYNE_LOG).log(ModBlocks.PELTOGYNE_LOG).wood(ModBlocks.PELTOGYNE_WOOD);

        generator.registerLog(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG).log(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG).wood(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD);
        generator.registerLog(ModBlocks.PELTOGYNE_STRIPPED_LOG).log(ModBlocks.PELTOGYNE_STRIPPED_LOG).wood(ModBlocks.PELTOGYNE_STRIPPED_WOOD);

        BlockStateModelGenerator.BlockTexturePool blue_luminescent_wood_pool = generator.registerCubeAllModelTexturePool(ModBlocks.BLUE_LUMINESCENT_PLANKS);

        blue_luminescent_wood_pool.button(ModBlocks.BLUE_LUMINESCENT_BUTTON);
        blue_luminescent_wood_pool.pressurePlate(ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE);
        blue_luminescent_wood_pool.fence(ModBlocks.BLUE_LUMINESCENT_FENCE);
        blue_luminescent_wood_pool.fenceGate(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE);
        blue_luminescent_wood_pool.stairs(ModBlocks.BLUE_LUMINESCENT_STAIRS);
        blue_luminescent_wood_pool.slab(ModBlocks.BLUE_LUMINESCENT_SLAB);

        generator.registerDoor(ModBlocks.BLUE_LUMINESCENT_DOOR);
        generator.registerTrapdoor(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool peltogyne_wood_pool = generator.registerCubeAllModelTexturePool(ModBlocks.PELTOGYNE_PLANKS);

        peltogyne_wood_pool.button(ModBlocks.PELTOGYNE_BUTTON);
        peltogyne_wood_pool.pressurePlate(ModBlocks.PELTOGYNE_PRESSURE_PLATE);
        peltogyne_wood_pool.fence(ModBlocks.PELTOGYNE_FENCE);
        peltogyne_wood_pool.fenceGate(ModBlocks.PELTOGYNE_FENCE_GATE);
        peltogyne_wood_pool.stairs(ModBlocks.PELTOGYNE_STAIRS);
        peltogyne_wood_pool.slab(ModBlocks.PELTOGYNE_SLAB);

        generator.registerDoor(ModBlocks.PELTOGYNE_DOOR);
        generator.registerTrapdoor(ModBlocks.PELTOGYNE_TRAPDOOR);



        //Crystals
        generator.registerSimpleCubeAll(ModBlocks.PINK_CRYSTAL_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.AMBER_ORE);
        generator.registerSimpleCubeAll(ModBlocks.AMBER_MINERAL);
        generator.registerSimpleCubeAll(ModBlocks.RAW_AMBER_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.AMBER_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.AMBER_BLOCK_SANDIFIED);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_CRYSTAL_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.RED_CRYSTAL_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.WHITE_CRYSTAL_BLOCK);

        generator.registerTintableCross(ModBlocks.WHITE_CRYSTAL, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Idk
        generator.registerSimpleCubeAll(ModBlocks.CLOUD_BLOCK);

        //Spawn Eggs
        generator.registerParentedItemModel(ModItems.GROKI_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        generator.registerParentedItemModel(ModItems.BOLETE_COW_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        generator.registerParentedItemModel(ModItems.PLOTI_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        generator.registerParentedItemModel(ModItems.CRYSTAL_CREEPER_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        generator.registerParentedItemModel(ModItems.CRYSTAL_GOLEM_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        //generator.registerParentedItemModel(ModItems.SCHROOM_STICK_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        //generator.registerParentedItemModel(ModItems.MOSQUITO_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLUE_CRYSTAL)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_1, Properties.VERTICAL_DIRECTION)
                        .register(0, Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_blue_up_top")))
                        .register(0, Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_blue_down_top")))
                        .register(1, Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_blue_up_bottom")))
                        .register(1, Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_blue_down_bottom"))))
        );

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RED_CRYSTAL)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_1, Properties.VERTICAL_DIRECTION)
                        .register(0, Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_red_up_top")))
                        .register(0, Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_red_down_top")))
                        .register(1, Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_red_up_bottom")))
                        .register(1, Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_red_down_bottom"))))
        );

        //deepslate crystal
        /*generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.WHITE_CRYSTAL_DEEPSLATE)
                .coordinate(BlockStateVariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_white_deepslate_down")))
                        .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_white_deepslate_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RED_CRYSTAL_DEEPSLATE)
                .coordinate(BlockStateVariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_red_deepslate_down")))
                        .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_red_deepslate_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLUE_CRYSTAL_DEEPSLATE)
                .coordinate(BlockStateVariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_blue_deepslate_down")))
                        .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_blue_deepslate_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.WHITE_CRYSTAL_STONE)
                .coordinate(BlockStateVariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_white_stone_down")))
                        .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_white_deepslate_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RED_CRYSTAL_STONE)
                .coordinate(BlockStateVariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_red_stone_down")))
                        .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_red_stone_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLUE_CRYSTAL_STONE)
                .coordinate(BlockStateVariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_blue_stone_down")))
                        .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_floor_blue_stone_up"))))
        );*/
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(ModItems.BAGUETTE, Models.GENERATED);
        generator.register(ModItems.BIG_GREEN_MUSHROOM_SEED, Models.GENERATED);
        generator.register(ModItems.BIG_PURPLE_MUSHROOM_SEED, Models.GENERATED);
        generator.register(ModItems.CAERULEA_VOLUBILIS_ITEM, Models.GENERATED);
       //generator.register(ModItems.HYMNE_URSS_MUSIC_DISC, Models.GENERATED);
       //generator.register(ModItems.HYMNE_FRANCAIS_MUSIC_DISC, Models.GENERATED);
        generator.register(ModItems.PINK_MUSHROOM_VINES_ITEM, Models.GENERATED);

        //generator.register(ModItems.PINK_CRYSTAL_ITEM, Models.GENERATED);
        generator.register(ModItems.BLUE_CRYSTAL_ITEM, Models.GENERATED);
        generator.register(ModItems.RED_CRYSTAL_ITEM, Models.GENERATED);
        generator.register(ModItems.AMBER_ITEM, Models.GENERATED);
        generator.register(ModItems.CRUSHED_AMBER_ITEM, Models.GENERATED);

        generator.register(ModItems.YELLOW_BERRIES, Models.GENERATED);
        generator.register(ModItems.COOKED_YELLOW_BERRIES, Models.GENERATED);
        generator.register(ModItems.FLEUR_BERRIES_ITEM, Models.GENERATED);

        generator.register(ModItems.CRUSHED_DIAMOND, Models.GENERATED);
        generator.register(ModItems.LUMINESCENT_SCHROOM_SOUP, Models.GENERATED);
        generator.register(ModItems.PURPLE_MUSHROOM_POWDER, Models.GENERATED);
        generator.register(ModItems.KEY, Models.GENERATED);


    }

}
