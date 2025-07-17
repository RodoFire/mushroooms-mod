package fr.rodofire.mushrooomsmod.datagen;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        //Blocks
        //Mushrooms Blocks
        generator.createTrivialCube(ModBlocks.PURPLE_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK.get());

        generator.createTrivialCube(ModBlocks.ORANGE_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK.get());

        generator.createTrivialCube(ModBlocks.YELLOW_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK.get());

        generator.createTrivialCube(ModBlocks.BLUE_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK.get());

        generator.createTrivialCube(ModBlocks.GREEN_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK.get());

        generator.createTrivialCube(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK.get());

        generator.createTrivialCube(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK.get());

        generator.createTrivialCube(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK.get());

        generator.createTrivialCube(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK.get());
        generator.createTrivialCube(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK.get());


        generator.createTrivialCube(ModBlocks.TRANSPARENT_MUSHROOM_STEM.get());
        generator.createTrivialCube(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM.get());
        generator.createTrivialCube(ModBlocks.GREEN_MUSHROOM_STEM.get());
        generator.createTrivialCube(ModBlocks.COMPRESSED_PURPLE_MUSHROOM.get());

        //Soft Blocks
        generator.createTrivialCube(ModBlocks.COMPRESSED_DIRT.get());
        generator.createTrivialCube(ModBlocks.LIGHT_COMPRESSED_DIRT.get());

        //Hard Blocks
        generator.createTrivialCube(ModBlocks.RHYOLITE.get());
        generator.createTrivialCube(ModBlocks.RHYOLITE_TILES.get());
        generator.createTrivialCube(ModBlocks.LAVA_BLACKSTONE.get());

        //Potted Flowers
        generator.createPlant(ModBlocks.BLUE_MUSHROOM.get(), ModBlocks.POTTED_BLUE_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.GREEN_MUSHROOM.get(), ModBlocks.POTTED_GREEN_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PURPLE_MUSHROOM.get(), ModBlocks.POTTED_PURPLE_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.BLUE_LUMINESCENT_MUSHROOM.get(), ModBlocks.POTTED_BLUE_LUMINESCENT_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.LUMINESCENT_PINK_MUSHROOM.get(), ModBlocks.POTTED_LUMINESCENT_PINK_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.YELLOW_MUSHROOM.get(), ModBlocks.POTTED_YELLOW_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.ORANGE_MUSHROOM.get(), ModBlocks.POTTED_ORANGE_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.FERTILE_RED_MUSHROOM.get(), ModBlocks.POTTED_FERTILE_RED_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);

        generator.createPlant(ModBlocks.OCULAE.get(), ModBlocks.POTTED_OCULAE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.CYANEA.get(), ModBlocks.POTTED_CYANEA.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.CYANUS_RUBENS.get(), ModBlocks.POTTED_CYANUS_RUBENS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.SOL_OCCIDENTIS.get(), ModBlocks.POTTED_SOL_OCCIDENTIS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.FUTIALI.get(), ModBlocks.POTTED_FUTIALI.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.NOCTULICA.get(), ModBlocks.POTTED_NOCTULICA.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PREHISTORIC_ROSE.get(), ModBlocks.POTTED_PREHISTORIC_ROSE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PREHISTO_PINK_SCHROOM.get(), ModBlocks.POTTED_PREHISTO_PINK_SCHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PREHISTO_BLUE_SCHROOM.get(), ModBlocks.POTTED_PREHISTO_BLUE_SCHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PREHISTURPLE_SCHROOM.get(), ModBlocks.POTTED_PREHISTURPLE_SCHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PREHISTO_GREEN_SCHROOM.get(), ModBlocks.POTTED_PREHISTO_GREEN_SCHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);

        generator.createPlant(ModBlocks.ORANGE_PERENNIAL.get(), ModBlocks.POTTED_ORANGE_PERENNIAL.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.BLUE_PERENNIAL.get(), ModBlocks.POTTED_BLUE_PERENNIAL.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PURPLE_PERENNIAL.get(), ModBlocks.POTTED_PURPLE_PERENNIAL.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.GREEN_PERENNIAL.get(), ModBlocks.POTTED_GREEN_PERENNIAL.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.LUMINESCENT_PERENNIAL.get(), ModBlocks.POTTED_LUMINESCENT_PERENNIAL.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.YELLOW_PERENNIAL.get(), ModBlocks.POTTED_YELLOW_PERENNIAL.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PINK_PERENNIAL.get(), ModBlocks.POTTED_PINK_PERENNIAL.get(), BlockModelGenerators.TintState.NOT_TINTED);

        generator.createPlant(ModBlocks.RED_QUINCE.get(), ModBlocks.POTTED_RED_QUINCE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.YELLOW_QUINCE.get(), ModBlocks.POTTED_YELLOW_QUINCE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.YELICE.get(), ModBlocks.POTTED_YELICE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.FLAMESTHYSIA.get(), ModBlocks.POTTED_FLAMESTHYSIA.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.APAGANTHE.get(), ModBlocks.POTTED_APAGANTHE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.WYSTERIA.get(), ModBlocks.POTTED_WYSTERIA.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.BLUEBELL.get(), ModBlocks.POTTED_BLUEBELL.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.VIPERIN.get(), ModBlocks.POTTED_VIPERIN.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.HIBISCUS.get(), ModBlocks.POTTED_HIBISCUS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PLATUM.get(), ModBlocks.POTTED_PLATUM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.DIANTHUS.get(), ModBlocks.POTTED_DIANTHUS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.CYCAS.get(), ModBlocks.POTTED_CYCAS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.ARUM.get(), ModBlocks.POTTED_ARUM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.HYDRANGEA.get(), ModBlocks.POTTED_HYDRANGEA.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.ANEMONE.get(), ModBlocks.POTTED_ANEMONE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.JACYNTHE.get(), ModBlocks.POTTED_JACYNTHE.get(), BlockModelGenerators.TintState.NOT_TINTED);

        //Potted Flowers Mushrooms
        generator.createPlant(ModBlocks.STERILE_BLUE_MUSHROOM.get(), ModBlocks.POTTED_STERILE_BLUE_MUSHROOM.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.MUSHROOM_SMALL_BROWN.get(), ModBlocks.POTTED_MUSHROOM_SMALL_BROWN.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.MUSHROOM_SMALL_RED.get(), ModBlocks.POTTED_MUSHROOM_SMALL_RED.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.MUSHROOM_DEATH_TRUMPET.get(), ModBlocks.POTTED_MUSHROOM_DEATH_TRUMPET.get(), BlockModelGenerators.TintState.NOT_TINTED);

        //Potted Sapplings
        generator.createPlant(ModBlocks.BLUE_LUMINESCENT_SAPPLING.get(), ModBlocks.POTTED_BLUE_LUMINESCENT_SAPPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.OAK_BERRIES_SAPLING.get(), ModBlocks.POTTED_OAK_BERRIES_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.PELTOGYNE_SAPLING.get(), ModBlocks.POTTED_PELTOGYNE_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createPlant(ModBlocks.COLORFUL_TREE_SAPLING.get(), ModBlocks.POTTED_COLORFUL_TREE_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);

        //Vines
        generator.createCrossBlockWithDefaultItem(ModBlocks.BLUE_LUMINESCENT_VINES.get(), BlockModelGenerators.TintState.NOT_TINTED);

        //Grass
        generator.createCrossBlockWithDefaultItem(ModBlocks.TINY_GRASS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createCrossBlockWithDefaultItem(ModBlocks.BLUE_LUMINESCENT_GRASS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createDoublePlant(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS.get(), BlockModelGenerators.TintState.TINTED);

        //Leaves
        generator.createTrivialCube(ModBlocks.BLUE_LUMINESCENT_LEAVES.get());
        generator.createTrivialCube(ModBlocks.RED_COLORFUL_LEAVES.get());
        generator.createTrivialCube(ModBlocks.PINK_COLORFUL_LEAVES.get());
        generator.createTrivialCube(ModBlocks.PURPLE_COLORFUL_LEAVES.get());
        generator.createTrivialCube(ModBlocks.YELLOW_COLORFUL_LEAVES.get());
        generator.createTrivialCube(ModBlocks.BLUE_COLORFUL_LEAVES.get());
        generator.createTrivialCube(ModBlocks.GREEN_COLORFUL_LEAVES.get());
        generator.createTrivialCube(ModBlocks.ORANGE_COLORFUL_LEAVES.get());


        //Lights
        generator.createLantern(ModBlocks.RED_LANTERN.get());
        generator.createLantern(ModBlocks.GREEN_LANTERN.get());
        generator.createNormalTorch(ModBlocks.GREEN_TORCH.get(), ModBlocks.WALL_GREEN_TORCH.get());

        //Construction Blocks
        generator.createTrivialCube(ModBlocks.LAVA_BLACKSTONE_BRICKS.get());
        generator.createTrivialCube(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS.get());
        generator.createTrivialCube(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS.get());
        //Wood
        generator.woodProvider(ModBlocks.BLUE_LUMINESCENT_LOG.get()).log(ModBlocks.BLUE_LUMINESCENT_LOG.get()).wood(ModBlocks.BLUE_LUMINESCENT_WOOD.get());
        generator.woodProvider(ModBlocks.PELTOGYNE_LOG.get()).log(ModBlocks.PELTOGYNE_LOG.get()).wood(ModBlocks.PELTOGYNE_WOOD.get());

        generator.woodProvider(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get()).log(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get()).wood(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get());
        generator.woodProvider(ModBlocks.PELTOGYNE_STRIPPED_LOG.get()).log(ModBlocks.PELTOGYNE_STRIPPED_LOG.get()).wood(ModBlocks.PELTOGYNE_STRIPPED_WOOD.get());

        BlockModelGenerators.BlockFamilyProvider blue_luminescent_wood_pool = generator.family(ModBlocks.BLUE_LUMINESCENT_PLANKS.get());

        blue_luminescent_wood_pool.button(ModBlocks.BLUE_LUMINESCENT_BUTTON.get());
        blue_luminescent_wood_pool.pressurePlate(ModBlocks.BLUE_LUMINESCENT_PRESSURE_PLATE.get());
        blue_luminescent_wood_pool.fence(ModBlocks.BLUE_LUMINESCENT_FENCE.get());
        blue_luminescent_wood_pool.fenceGate(ModBlocks.BLUE_LUMINESCENT_FENCE_GATE.get());
        blue_luminescent_wood_pool.stairs(ModBlocks.BLUE_LUMINESCENT_STAIRS.get());
        blue_luminescent_wood_pool.slab(ModBlocks.BLUE_LUMINESCENT_SLAB.get());

        generator.createDoor(ModBlocks.BLUE_LUMINESCENT_DOOR.get());
        generator.createTrapdoor(ModBlocks.BLUE_LUMINESCENT_TRAPDOOR.get());

        BlockModelGenerators.BlockFamilyProvider peltogyne_wood_pool = generator.family(ModBlocks.PELTOGYNE_PLANKS.get());

        peltogyne_wood_pool.button(ModBlocks.PELTOGYNE_BUTTON.get());
        peltogyne_wood_pool.pressurePlate(ModBlocks.PELTOGYNE_PRESSURE_PLATE.get());
        peltogyne_wood_pool.fence(ModBlocks.PELTOGYNE_FENCE.get());
        peltogyne_wood_pool.fenceGate(ModBlocks.PELTOGYNE_FENCE_GATE.get());
        peltogyne_wood_pool.stairs(ModBlocks.PELTOGYNE_STAIRS.get());
        peltogyne_wood_pool.slab(ModBlocks.PELTOGYNE_SLAB.get());

        generator.createDoor(ModBlocks.PELTOGYNE_DOOR.get());
        generator.createTrapdoor(ModBlocks.PELTOGYNE_TRAPDOOR.get());


        //Crystals
        generator.createTrivialCube(ModBlocks.PINK_CRYSTAL_BLOCK.get());
        generator.createTrivialCube(ModBlocks.AMBER_ORE.get());
        generator.createTrivialCube(ModBlocks.AMBER_MINERAL.get());
        generator.createTrivialCube(ModBlocks.RAW_AMBER_BLOCK.get());
        generator.createTrivialCube(ModBlocks.AMBER_BLOCK.get());
        generator.createTrivialCube(ModBlocks.AMBER_BLOCK_SANDIFIED.get());
        generator.createTrivialCube(ModBlocks.BLUE_CRYSTAL_BLOCK.get());
        generator.createTrivialCube(ModBlocks.RED_CRYSTAL_BLOCK.get());
        generator.createTrivialCube(ModBlocks.WHITE_CRYSTAL_BLOCK.get());

        generator.createCrossBlockWithDefaultItem(ModBlocks.WHITE_CRYSTAL.get(), BlockModelGenerators.TintState.NOT_TINTED);

        //Idk
        generator.createTrivialCube(ModBlocks.CLOUD_BLOCK.get());

        //Spawn Eggs
        generator.delegateItemModel(ModItems.GROKI_SPAWN_EGG.get(), ModelLocationUtils.decorateItemModelLocation("template_spawn_egg"));
        generator.delegateItemModel(ModItems.BOLETE_COW_SPAWN_EGG.get(), ModelLocationUtils.decorateItemModelLocation("template_spawn_egg"));
        generator.delegateItemModel(ModItems.PLOTI_SPAWN_EGG.get(), ModelLocationUtils.decorateItemModelLocation("template_spawn_egg"));
        generator.delegateItemModel(ModItems.CRYSTAL_CREEPER_SPAWN_EGG.get(), ModelLocationUtils.decorateItemModelLocation("template_spawn_egg"));
        generator.delegateItemModel(ModItems.CRYSTAL_GOLEM_SPAWN_EGG.get(), ModelLocationUtils.decorateItemModelLocation("template_spawn_egg"));
        generator.delegateItemModel(ModItems.SCHROOM_STICK_SPAWN_EGG.get(), ModelLocationUtils.decorateItemModelLocation("template_spawn_egg"));
        generator.delegateItemModel(ModItems.SQUIRREL_STICK_SPAWN_EGG.get(), ModelLocationUtils.decorateItemModelLocation("template_spawn_egg"));

        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(ModBlocks.BLUE_CRYSTAL.get())
                .with(PropertyDispatch.properties(BlockStateProperties.AGE_1, BlockStateProperties.VERTICAL_DIRECTION)
                        .select(0, Direction.UP, Variant.variant().with(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_blue_up_top")))
                        .select(0, Direction.DOWN, Variant.variant().with(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_blue_down_top")))
                        .select(1, Direction.UP, Variant.variant().with(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_blue_up_bottom")))
                        .select(1, Direction.DOWN, Variant.variant().with(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_blue_down_bottom"))))
        );

        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(ModBlocks.RED_CRYSTAL.get())
                .with(PropertyDispatch.properties(BlockStateProperties.AGE_1, BlockStateProperties.VERTICAL_DIRECTION)
                        .select(0, Direction.UP, Variant.variant().with(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_red_up_top")))
                        .select(0, Direction.DOWN, Variant.variant().with(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_red_down_top")))
                        .select(1, Direction.UP, Variant.variant().with(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_red_up_bottom")))
                        .select(1, Direction.DOWN, Variant.variant().with(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_red_down_bottom"))))
        );

        //deepslate crystal
        /*generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.WHITE_CRYSTAL_DEEPSLATE.get())
                .coordinate(VariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_white_deepslate_down")))
                        .register(Direction.UP, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_white_deepslate_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RED_CRYSTAL_DEEPSLATE.get())
                .coordinate(VariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_red_deepslate_down")))
                        .register(Direction.UP, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_red_deepslate_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLUE_CRYSTAL_DEEPSLATE.get())
                .coordinate(VariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_blue_deepslate_down")))
                        .register(Direction.UP, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_blue_deepslate_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.WHITE_CRYSTAL_STONE.get())
                .coordinate(VariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_white_stone_down")))
                        .register(Direction.UP, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_white_deepslate_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RED_CRYSTAL_STONE.get())
                .coordinate(VariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_red_stone_down")))
                        .register(Direction.UP, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_red_stone_up"))))
        );
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLUE_CRYSTAL_STONE.get())
                .coordinate(VariantMap.create(Properties.VERTICAL_DIRECTION)
                        .register(Direction.DOWN, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_blue_stone_down")))
                        .register(Direction.UP, Variant.create().put(VariantProperties.MODEL, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "block/crystal_floor_blue_stone_up"))))
        );*/
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(ModItems.BAGUETTE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.BIG_GREEN_MUSHROOM_SEED.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.BIG_PURPLE_MUSHROOM_SEED.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.CAERULEA_VOLUBILIS_ITEM.get(), ModelTemplates.FLAT_ITEM);
        //generator.generateFlatItem(ModItems.HYMNE_URSS_MUSIC_DISC.get(), ModelTemplates.FLAT_ITEM);
        //generator.generateFlatItem(ModItems.HYMNE_FRANCAIS_MUSIC_DISC.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.PINK_MUSHROOM_VINES_ITEM.get(), ModelTemplates.FLAT_ITEM);

        //generator.generateFlatItem(ModItems.PINK_CRYSTAL_ITEM.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.BLUE_CRYSTAL_ITEM.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.RED_CRYSTAL_ITEM.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.AMBER_ITEM.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.CRUSHED_AMBER_ITEM.get(), ModelTemplates.FLAT_ITEM);

        generator.generateFlatItem(ModItems.YELLOW_BERRIES.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.COOKED_YELLOW_BERRIES.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.FLEUR_BERRIES_ITEM.get(), ModelTemplates.FLAT_ITEM);

        generator.generateFlatItem(ModItems.CRUSHED_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.LUMINESCENT_SCHROOM_SOUP.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.PURPLE_MUSHROOM_POWDER.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.KEY.get(), ModelTemplates.FLAT_ITEM);

        generator.generateFlatItem(ModBlocks.BUSHY_YELLOW_MUSHROOM.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModBlocks.BRIGHT_YELLOW_MUSHROOM.get().asItem(), ModelTemplates.FLAT_ITEM);
    }

}
