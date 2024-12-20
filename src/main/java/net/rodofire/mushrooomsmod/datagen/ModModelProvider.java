package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
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
        generator.registerFlowerPotPlantAndItem(ModBlocks.BLUE_MUSHROOM, ModBlocks.POTTED_BLUE_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.GREEN_MUSHROOM, ModBlocks.POTTED_GREEN_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PURPLE_MUSHROOM, ModBlocks.POTTED_PURPLE_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.BLUE_LUMINESCENT_MUSHROOM, ModBlocks.POTTED_BLUE_LUMINESCENT_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.LUMINESCENT_PINK_MUSHROOM, ModBlocks.POTTED_LUMINESCENT_PINK_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.YELLOW_MUSHROOM, ModBlocks.POTTED_YELLOW_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.ORANGE_MUSHROOM, ModBlocks.POTTED_ORANGE_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.FERTILE_RED_MUSHROOM, ModBlocks.POTTED_FERTILE_RED_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);

        generator.registerFlowerPotPlantAndItem(ModBlocks.OCULAE, ModBlocks.POTTED_OCULAE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.CYANEA, ModBlocks.POTTED_CYANEA, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.CYANUS_RUBENS, ModBlocks.POTTED_CYANUS_RUBENS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.SOL_OCCIDENTIS, ModBlocks.POTTED_SOL_OCCIDENTIS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.FUTIALI, ModBlocks.POTTED_FUTIALI, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.NOCTULICA, ModBlocks.POTTED_NOCTULICA, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PREHISTORIC_ROSE, ModBlocks.POTTED_PREHISTORIC_ROSE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PREHISTO_PINK_SCHROOM, ModBlocks.POTTED_PREHISTO_PINK_SCHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PREHISTO_BLUE_SCHROOM, ModBlocks.POTTED_PREHISTO_BLUE_SCHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PREHISTURPLE_SCHROOM, ModBlocks.POTTED_PREHISTURPLE_SCHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PREHISTO_GREEN_SCHROOM, ModBlocks.POTTED_PREHISTO_GREEN_SCHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);

        generator.registerFlowerPotPlantAndItem(ModBlocks.ORANGE_PERENNIAL, ModBlocks.POTTED_ORANGE_PERENNIAL, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.BLUE_PERENNIAL, ModBlocks.POTTED_BLUE_PERENNIAL, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PURPLE_PERENNIAL, ModBlocks.POTTED_PURPLE_PERENNIAL, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.GREEN_PERENNIAL, ModBlocks.POTTED_GREEN_PERENNIAL, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.LUMINESCENT_PERENNIAL, ModBlocks.POTTED_LUMINESCENT_PERENNIAL, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.YELLOW_PERENNIAL, ModBlocks.POTTED_YELLOW_PERENNIAL, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PINK_PERENNIAL, ModBlocks.POTTED_PINK_PERENNIAL, BlockStateModelGenerator.CrossType.NOT_TINTED);

        generator.registerFlowerPotPlantAndItem(ModBlocks.RED_QUINCE, ModBlocks.POTTED_RED_QUINCE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.YELLOW_QUINCE, ModBlocks.POTTED_YELLOW_QUINCE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.YELICE, ModBlocks.POTTED_YELICE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.FLAMESTHYSIA, ModBlocks.POTTED_FLAMESTHYSIA, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.APAGANTHE, ModBlocks.POTTED_APAGANTHE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.WYSTERIA, ModBlocks.POTTED_WYSTERIA, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.BLUEBELL, ModBlocks.POTTED_BLUEBELL, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.VIPERIN, ModBlocks.POTTED_VIPERIN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.HIBISCUS, ModBlocks.POTTED_HIBISCUS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PLATUM, ModBlocks.POTTED_PLATUM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.DIANTHUS, ModBlocks.POTTED_DIANTHUS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.CYCAS, ModBlocks.POTTED_CYCAS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.ARUM, ModBlocks.POTTED_ARUM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.HYDRANGEA, ModBlocks.POTTED_HYDRANGEA, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.ANEMONE, ModBlocks.POTTED_ANEMONE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.JACYNTHE, ModBlocks.POTTED_JACYNTHE, BlockStateModelGenerator.CrossType.NOT_TINTED);

        //Potted Flowers Mushrooms
        generator.registerFlowerPotPlantAndItem(ModBlocks.STERILE_BLUE_MUSHROOM, ModBlocks.POTTED_STERILE_BLUE_MUSHROOM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.MUSHROOM_SMALL_BROWN, ModBlocks.POTTED_MUSHROOM_SMALL_BROWN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.MUSHROOM_SMALL_RED, ModBlocks.POTTED_MUSHROOM_SMALL_RED, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.MUSHROOM_DEATH_TRUMPET, ModBlocks.POTTED_MUSHROOM_DEATH_TRUMPET, BlockStateModelGenerator.CrossType.NOT_TINTED);

        //Potted Sapplings
        generator.registerFlowerPotPlantAndItem(ModBlocks.BLUE_LUMINESCENT_SAPPLING, ModBlocks.POTTED_BLUE_LUMINESCENT_SAPPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.OAK_BERRIES_SAPLING, ModBlocks.POTTED_OAK_BERRIES_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.COLORFUL_TREE_SAPLING, ModBlocks.POTTED_COLORFUL_TREE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlantAndItem(ModBlocks.PELTOGYNE_SAPLING, ModBlocks.POTTED_PELTOGYNE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

        //Tall plants
        generator.registerDoubleBlockAndItem(ModBlocks.TURQUOSUM_STILUS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerDoubleBlockAndItem(ModBlocks.SAPHIRA_FLORENS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerDoubleBlockAndItem(ModBlocks.TINY_LILAC, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerDoubleBlockAndItem(ModBlocks.PINK_HEATER, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerDoubleBlockAndItem(ModBlocks.ACONIT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerDoubleBlockAndItem(ModBlocks.PERVENCHE, BlockStateModelGenerator.CrossType.NOT_TINTED);


        //Vines
        generator.registerTintableCross(ModBlocks.BLUE_LUMINESCENT_VINES, BlockStateModelGenerator.CrossType.NOT_TINTED);

        //Grass
        generator.registerTintableCross(ModBlocks.TINY_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerTintableCross(ModBlocks.BLUE_LUMINESCENT_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerDoubleBlockAndItem(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);

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

        generator.registerTintableCross(ModBlocks.WHITE_CRYSTAL, BlockStateModelGenerator.CrossType.NOT_TINTED);

        //Idk
        generator.registerSimpleCubeAll(ModBlocks.CLOUD_BLOCK);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLUE_CRYSTAL)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_1, Properties.VERTICAL_DIRECTION)
                        .register(0, Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_blue_up_top")))
                        .register(0, Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_blue_down_top")))
                        .register(1, Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_blue_up_bottom")))
                        .register(1, Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_blue_down_bottom")))
                )
        );

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RED_CRYSTAL)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_1, Properties.VERTICAL_DIRECTION)
                        .register(0, Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_red_up_top")))
                        .register(0, Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_red_down_top")))
                        .register(1, Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_red_up_bottom")))
                        .register(1, Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/crystal_red_down_bottom")))
                )
        );

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MUSHROOM_BOOSTING, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/mushroom_boost"))));
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.DANGEROUS_MUSHROOM_BOOSTING, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/mushroom_boost"))));
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RAPANGE_FLOWERS, BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MushrooomsMod.MOD_ID, "block/rapange_flowers"))));


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


        //Spawn Eggs
        generator.registerSpawnEgg(ModItems.GROKI_SPAWN_EGG, 0x765A34, 0x1BC2CF);
        generator.registerSpawnEgg(ModItems.BOLETE_COW_SPAWN_EGG, 0xBF28DD, 0xF4DBF9);
        generator.registerSpawnEgg(ModItems.PLOTI_SPAWN_EGG, 0x674f35, 0x4e361c);
        generator.registerSpawnEgg(ModItems.CRYSTAL_CREEPER_SPAWN_EGG, 0x50D122, 0xDE310F);
        generator.registerSpawnEgg(ModItems.CRYSTAL_GOLEM_SPAWN_EGG, 0x9A9A9A, 0xE57FF3);
        //generator.registerSpawnEgg(ModItems.SCHROOM_STICK_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        //generator.registerSpawnEgg(ModItems.MOSQUITO_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        generator.output.accept(ModBlocks.BIG_GREEN_MUSHROOM.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_big_green")));
        generator.output.accept(ModBlocks.BIG_PURPLE_MUSHROOM.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_big_purple")));
        generator.output.accept(ModBlocks.TINY_GREEN_MUSHROOM.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_tiny_green")));
        generator.output.accept(ModBlocks.TINY_PURPLE_MUSHROOM.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_tiny_purple")));

        generator.output.accept(ModBlocks.LITTLE_GREEN_MUSHROOM.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_little_green")));
        generator.output.accept(ModBlocks.LITTLE_PURPLE_MUSHROOM.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_little_purple")));

        generator.output.accept(ModBlocks.MEDIUM_GREEN_MUSHROOM.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_medium_green")));
        generator.output.accept(ModBlocks.MEDIUM_PURPLE_MUSHROOM.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_medium_purple")));


        generator.output.accept(ModBlocks.PICK_BLUE.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/pick_blue")));
        generator.output.accept(ModBlocks.DANGEROUS_MUSHROOM_BOOSTING.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_boost_item")));
        generator.output.accept(ModBlocks.MUSHROOM_BOOSTING.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_boost_item")));

        generator.output.accept(ModBlocks.RAPANGE_FLOWERS.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/rapange_flowers")));

        generator.output.accept(ModBlocks.PELTOGYNE_LEAVES.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "block/leaves_peltogyne1")));

        generator.output.accept(ModBlocks.LOG_MUSHROOM_BROWN.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "block/mushroom_log1_brown")));
        generator.output.accept(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT.asItem(), ItemModels.basic(Identifier.of(MushrooomsMod.MOD_ID, "item/mushroom_side_blue_luminescent")));
    }

}
