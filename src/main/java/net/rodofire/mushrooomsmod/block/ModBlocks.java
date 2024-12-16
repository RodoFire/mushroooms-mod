package net.rodofire.mushrooomsmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.custom.*;
import net.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines.PinkLuminescentBodyVinesBlock;
import net.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines.PinkLuminescentHeadVinesBlock;
import net.rodofire.mushrooomsmod.block.custom.PinkMushroomBlock.PinkMushroomVinesBodyBlock;
import net.rodofire.mushrooomsmod.block.custom.PinkMushroomBlock.PinkMushroomVinesHeadBlock;
import net.rodofire.mushrooomsmod.block.custom.bigmushroom.*;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.particle.ModParticles;
import net.rodofire.mushrooomsmod.sound.ModBlockSoundGroup;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModSaplings;

import java.util.function.Function;


public class ModBlocks {
    /*--------------------Natural Blocks--------------------*/

    /*-----------Mushroom Block Related-----------*/
    //Mushroom Block
    public static final Block PURPLE_MUSHROOM_BLOCK = registerBlock("mushroom_block_purple", settings -> new FermentedMushroomBlock(() -> ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block ORANGE_MUSHROOM_BLOCK = registerBlock("mushroom_block_orange", settings -> new FermentedMushroomBlock(() -> ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block YELLOW_MUSHROOM_BLOCK = registerBlock("mushroom_block_yellow", settings -> new FermentedMushroomBlock(() -> ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BLUE_MUSHROOM_BLOCK = registerBlock("mushroom_block_blue", settings -> new FermentedMushroomBlock(() -> ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block GREEN_MUSHROOM_BLOCK = registerBlock("mushroom_block_green", settings -> new FermentedMushroomBlock(() -> ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BLUE_LUMINESCENT_MUSHROOM_BLOCK = registerBlock("mushroom_block_blue_luminescent", settings -> new FermentedTransparentMushroomBlock(() -> ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block PINK_LUMINESCENT_MUSHROOM_BLOCK = registerBlock("mushroom_block_pink_luminescent", settings -> new FermentedTransparentMushroomBlock(() -> ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));

    //Fermented Stage 1
    public static final Block PURPLE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_purple", settings -> new FermentedMushroomBlock(() -> ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block ORANGE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_orange", settings -> new FermentedMushroomBlock(() -> ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block YELLOW_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_yellow", settings -> new FermentedMushroomBlock(() -> ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BLUE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_blue", settings -> new FermentedMushroomBlock(() -> ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block GREEN_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_green", settings -> new FermentedMushroomBlock(() -> ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_blue_luminescent", settings -> new FermentedTransparentMushroomBlock(() -> ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(state -> 8));
    public static final Block PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_pink_luminescent", settings -> new FermentedTransparentMushroomBlock(() -> ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(state -> 8));
    public static final Block RED_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_red", settings -> new FermentedMushroomBlock(() -> ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BROWN_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_brown", settings -> new FermentedMushroomBlock(() -> ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));

    //Fermented Stage 2
    public static final Block PURPLE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_purple", settings -> new FermentedMushroomBlock(() -> ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block ORANGE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_orange", settings -> new FermentedMushroomBlock(() -> ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block YELLOW_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_yellow", settings -> new FermentedMushroomBlock(() -> ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BLUE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_blue", settings -> new FermentedMushroomBlock(() -> ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block GREEN_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_green", settings -> new FermentedMushroomBlock(() -> ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_blue_luminescent", settings -> new FermentedTransparentMushroomBlock(() -> ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(state -> 8));
    public static final Block PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_pink_luminescent", settings -> new FermentedTransparentMushroomBlock(() -> ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(state -> 8));
    public static final Block RED_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_red", settings -> new FermentedMushroomBlock(() -> ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BROWN_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_brown", settings -> new FermentedMushroomBlock(() -> ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK, false, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));

    //Fermented Mushrooms
    public static final Block PURPLE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_purple", settings -> new FermentedMushroomBlock(() -> ModBlocks.PURPLE_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block ORANGE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_orange", settings -> new FermentedMushroomBlock(() -> ModBlocks.ORANGE_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block YELLOW_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_yellow", settings -> new FermentedMushroomBlock(() -> ModBlocks.YELLOW_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BLUE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_blue", settings -> new FermentedMushroomBlock(() -> ModBlocks.BLUE_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block GREEN_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_green", settings -> new FermentedMushroomBlock(() -> ModBlocks.GREEN_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_blue_luminescent", settings -> new FermentedTransparentMushroomBlock(() -> ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(state -> 8));
    public static final Block PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_pink_luminescent", settings -> new FermentedTransparentMushroomBlock(() -> ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(state -> 8));
    public static final Block RED_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_red", settings -> new FermentedMushroomBlock(() -> Blocks.RED_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block BROWN_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_brown", settings -> new FermentedMushroomBlock(() -> Blocks.BROWN_MUSHROOM_BLOCK, true, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));

    //mushrooms
    public static final Block GREEN_MUSHROOM = registerBlock("mushroom_green", settings -> new MushroomPlantBlock(ModConfiguredFeatures.GREEN_MUSHROOM_TREE_KEY, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM));
    public static final Block PURPLE_MUSHROOM = registerBlock("mushroom_purple", settings -> new MushroomPlantBlock(ModConfiguredFeatures.PURPLE_MUSHROOM_KEY, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM));
    public static final Block BLUE_MUSHROOM = registerBlock("mushroom_blue", settings -> new MushroomPlantBlock(ModConfiguredFeatures.BLUE_MUSHROOM_TREE_KEY_WG, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM));
    public static final Block BLUE_LUMINESCENT_MUSHROOM = registerBlock("mushroom_blue_luminescent", settings -> new MushroomPlantBlock(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE_KEY, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).luminance(state -> 5));
    public static final Block LUMINESCENT_PINK_MUSHROOM = registerBlock("mushroom_pink_luminescent", settings -> new MushroomPlantBlock(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE_KEY, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).luminance(state -> 5));
    public static final Block ORANGE_MUSHROOM = registerBlock("mushroom_orange", settings -> new MushroomPlantBlock(ModConfiguredFeatures.ORANGE_MUSHROOM_TREE_KEY_WG, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM));
    public static final Block YELLOW_MUSHROOM = registerBlock("mushroom_yellow", settings -> new MushroomPlantBlock(ModConfiguredFeatures.YELLOW_MUSHROOM_TREE_KEY_WG, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).luminance(state -> 5));
    public static final Block FERTILE_RED_MUSHROOM = registerBlock("mushroom_fertile_red", settings -> new MushroomPlantBlock(ModConfiguredFeatures.FERTILE_RED_MUSHROOM_KEY, settings), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM));

    //Big Mushrooms
    public static final Block BIG_PURPLE_MUSHROOM_PLANT = registerHiddenBlock("mushroom_big_plant_purple", BigPurpleMushroomPlant::new, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM));
    public static final Block TINY_PURPLE_MUSHROOM = registerBlock("mushroom_tiny_purple", settings -> new TinyPurpleMushroom(settings, ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY_WG), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).noCollision().nonOpaque());
    public static final Block LITTLE_PURPLE_MUSHROOM = registerBlock("mushroom_little_purple", settings -> new LittlePurpleMushroom(settings, ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY_WG), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque());
    public static final Block MEDIUM_PURPLE_MUSHROOM = registerBlock("mushroom_medium_purple", settings -> new MediumPurpleMushroom(settings, ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY_WG), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque());
    public static final Block BIG_PURPLE_MUSHROOM = registerBlock("mushroom_big_purple", settings -> new BigPurpleMushroom(settings, ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY_WG), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque());
    public static final Block TINY_GREEN_MUSHROOM = registerBlock("mushroom_tiny_green", settings -> new TinyGreenMushroom(settings, ModConfiguredFeatures.BIG_GREEN_MUSHROOM_TREE_KEY), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque());
    public static final Block LITTLE_GREEN_MUSHROOM = registerBlock("mushroom_little_green", settings -> new LittleGreenMushroom(settings, ModConfiguredFeatures.BIG_GREEN_MUSHROOM_TREE_KEY), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque());
    public static final Block MEDIUM_GREEN_MUSHROOM = registerBlock("mushroom_medium_green", settings -> new MediumGreenMushroom(settings, ModConfiguredFeatures.BIG_GREEN_MUSHROOM_TREE_KEY), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque());
    public static final Block BIG_GREEN_MUSHROOM = registerBlock("mushroom_big_green", settings -> new BigGreenMushroom(settings, ModConfiguredFeatures.BIG_GREEN_MUSHROOM_TREE_KEY), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque());
    public static final Block BIG_GREEN_MUSHROOM_PLANT = registerHiddenBlock("mushroom_big_plant_green", BigGreenMushroomPlant::new, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM));
    public static final Block RED_LUMERIA = registerBlock("red_lumeria", settings -> new BigRedMushroom(settings, ModConfiguredFeatures.BIG_RED_MUSHROOM_TREE_KEY), AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().noCollision());

    //Side Mushrooms
    public static final Block SIDE_MUSHROOM_BLUE_LUMINESCENT = registerBlock("mushroom_side_blue_luminescent", SideMushroom::new, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).luminance(state -> 11));
    public static final Block LOG_MUSHROOM_BROWN = registerBlock("mushroom_log_brown", LogMushroom::new, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque());

    //Flowers Mushroom
    public static final Block STERILE_BLUE_MUSHROOM = registerBlock("mushroom_small_blue", MushroomFlower::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block MUSHROOM_SMALL_BROWN = registerBlock("mushroom_small_brown", MushroomFlower::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block MUSHROOM_SMALL_RED = registerBlock("mushroom_small_red", MushroomFlower::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block MUSHROOM_DEATH_TRUMPET = registerBlock("mushroom_death_trumpet", MushroomFlower::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block MUSHROOM_BOOSTING = registerHiddenBlock("mushroom_boosting", BoostingMushroom::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block DANGEROUS_MUSHROOM_BOOSTING = registerHiddenBlock("dangerous_mushroom_boosting", DangerousBoostingMushroom::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());

    //Mushroom Stem
    public static final Block TRANSPARENT_MUSHROOM_STEM = registerBlock("mushroom_stem_transparent", TransparentBlock::new, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(state -> 9));
    public static final Block BLUE_LUMINESCENT_MUSHROOM_STEM = registerBlock("mushroom_stem_blue_luminescent", TransparentBlock::new, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(state -> 9));
    public static final Block GREEN_MUSHROOM_STEM = registerBlock("mushroom_stem_green", TransparentBlock::new, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK).nonOpaque());

    //Other Mushrooms Blocks
    public static final Block COMPRESSED_PURPLE_MUSHROOM = registerBlock("mushroom_compressed_purple", Block::new, AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK));

    //Soft Blocks
    public static final Block COMPRESSED_DIRT = registerBlock("dirt_compressed", Block::new, AbstractBlock.Settings.copy(Blocks.DIRT));
    public static final Block LIGHT_COMPRESSED_DIRT = registerBlock("dirt_compressed_light", Block::new, AbstractBlock.Settings.copy(Blocks.DIRT));

    /*-----------Stone Related-----------*/
    //Hard Blocks
    public static final Block PURPLE_SCHROOM_DEESLATE = registerBlock("deepslate_mushroom_purple", Block::new, AbstractBlock.Settings.copy(Blocks.DEEPSLATE).requiresTool().instrument(NoteBlockInstrument.BASEDRUM));
    public static final Block BLUE_LUMINESCENT_SCHROOM_DEEPSLATE = registerBlock("deepslate_mushroom_blue_luminescent", GrassBlock::new, AbstractBlock.Settings.copy(Blocks.DEEPSLATE).requiresTool().instrument(NoteBlockInstrument.BASEDRUM));
    public static final Block GREEN_STONY_SCHROOM_DEPOT = registerBlock("stone_mushroom_green", Block::new, AbstractBlock.Settings.copy(Blocks.STONE).requiresTool().instrument(NoteBlockInstrument.BASEDRUM));
    public static final Block RHYOLITE = registerBlock("rhyolite", Block::new, AbstractBlock.Settings.copy(Blocks.STONE).requiresTool().instrument(NoteBlockInstrument.BASEDRUM));
    public static final Block LAVA_BLACKSTONE = registerBlock("blackstone_lava", Block::new, AbstractBlock.Settings.copy(Blocks.BLACKSTONE).luminance(state -> 8));

    /*-----------Flower Related-----------*/
    //Flowers
    public static final Block OCULAE = registerBlock("oculae", settings -> new FlowerBlock(StatusEffects.DARKNESS, 1000, settings), AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).nonOpaque().noCollision());
    public static final Block CYANUS_RUBENS = registerBlock("cyanus_rubens", settings -> new FlowerBlock(StatusEffects.DARKNESS, 1000, settings), AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).nonOpaque().noCollision());
    public static final Block CYANEA = registerBlock("cyanea", settings -> new FlowerBlock(StatusEffects.DARKNESS, 1000, settings), AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).luminance(state -> 12).nonOpaque().noCollision());
    public static final Block SOL_OCCIDENTIS = registerBlock("sol_occidens", settings -> new FlowerBlock(StatusEffects.DARKNESS, 1000, settings), AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).nonOpaque().noCollision());
    public static final Block FUTIALI = registerBlock("futiali", settings -> new FlowerBlock(StatusEffects.DARKNESS, 1000, settings), AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).nonOpaque().luminance(state -> 11).noCollision());
    public static final Block MUSHROOM_FLOWERS = registerBlock("mushroom_flowers", settings -> new FlowersMushroomBlock(ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY_WG, settings), AbstractBlock.Settings.copy(Blocks.TALL_GRASS).nonOpaque().noCollision());
    public static final Block TURQUOSUM_STILUS = registerBlock("turquosum_stilus", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).luminance(state -> 11).nonOpaque().noCollision());
    public static final Block NOCTULICA = registerBlock("noctulica", settings -> new FlowerBlock(StatusEffects.DARKNESS, 1000, settings), AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).luminance(state -> 12).nonOpaque().noCollision());
    public static final Block SAPHIRA_FLORENS = registerBlock("saphira_florens", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().luminance(state -> 11).noCollision());
    public static final Block PREHISTORIC_ROSE = registerBlock("prehistoric_rose", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PREHISTO_PINK_SCHROOM = registerBlock("prehisto_pink_schroom", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PREHISTURPLE_SCHROOM = registerBlock("prehisturple_schroom", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PREHISTO_BLUE_SCHROOM = registerBlock("prehisto_blue_schroom", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PREHISTO_GREEN_SCHROOM = registerBlock("prehisto_green_schroom", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block YELLOW_PERENNIAL = registerBlock("perennial_yellow", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PINK_PERENNIAL = registerBlock("perennial_pink", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block BLUE_PERENNIAL = registerBlock("perennial_blue", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block GREEN_PERENNIAL = registerBlock("perennial_green", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block LUMINESCENT_PERENNIAL = registerBlock("perennial_luminescent", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block ORANGE_PERENNIAL = registerBlock("perennial_orange", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PURPLE_PERENNIAL = registerBlock("perennial_purple", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block RED_QUINCE = registerBlock("quince_red", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block YELLOW_QUINCE = registerBlock("quince_yellow", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block TINY_LILAC = registerBlock("tiny_lilac", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block YELICE = registerBlock("yelice", settings -> new FlowerBlock(StatusEffects.GLOWING, 5, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block FLAMESTHYSIA = registerBlock("flamesthysia", settings -> new FlowerBlock(StatusEffects.GLOWING, 5, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block APAGANTHE = registerBlock("apaganthe", settings -> new FlowerBlock(StatusEffects.GLOWING, 5, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PINK_HEATER = registerBlock("pink_heater", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block WYSTERIA = registerBlock("wysteria", settings -> new FlowerBlock(StatusEffects.GLOWING, 5, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block BLUEBELL = registerBlock("bluebell", settings -> new FlowerBlock(StatusEffects.GLOWING, 5, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block VIPERIN = registerBlock("viperin", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block HIBISCUS = registerBlock("hibiscus", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PLATUM = registerBlock("platum", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).luminance(state -> 10).nonOpaque().noCollision());
    public static final Block DIANTHUS = registerBlock("dianthus", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block CYCAS = registerBlock("cycas", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block ARUM = registerBlock("arum", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block HYDRANGEA = registerBlock("hydrangea", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block ANEMONE = registerBlock("anemone", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block JACYNTHE = registerBlock("jacynthe", settings -> new FlowerBlock(StatusEffects.GLOWING, 10, settings), AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block PERVENCHE = registerBlock("pervenche", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block ACONIT = registerBlock("aconit", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision());
    public static final Block RAPANGE_FLOWERS = registerBlock("rapange_flowers", RapangeFlowers::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().noCollision().luminance(RapangeFlowers.getLuminanceSupplier()));
    public static final Block FLEUR_BERRIES = registerHiddenBlock("berries_fleur", FleurBerries::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().luminance(state -> state.get(Properties.AGE_3) * 4));

    public static final Block PICK_BLUE = registerBlock("pick_blue", PickBlue::new, AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).nonOpaque().luminance(state -> 11));

    /*-----------Potted Blocks-----------*/
    //Potted Mushrooms
    public static final Block POTTED_STERILE_BLUE_MUSHROOM = registerHiddenBlock("potted_sterile_blue_mushroom", settings -> new FlowerPotBlock(STERILE_BLUE_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_MUSHROOM_SMALL_BROWN = registerHiddenBlock("potted_mushroom_small_brown", settings -> new FlowerPotBlock(MUSHROOM_SMALL_BROWN, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_MUSHROOM_SMALL_RED = registerHiddenBlock("potted_mushroom_small_red", settings -> new FlowerPotBlock(MUSHROOM_SMALL_RED, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_MUSHROOM_DEATH_TRUMPET = registerHiddenBlock("potted_mushroom_death_trumpet", settings -> new FlowerPotBlock(MUSHROOM_DEATH_TRUMPET, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());

    //Potted Flowers
    public static final Block POTTED_GREEN_MUSHROOM = registerHiddenBlock("potted_green_mushroom", settings -> new FlowerPotBlock(GREEN_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_BLUE_MUSHROOM = registerHiddenBlock("potted_blue_mushroom", settings -> new FlowerPotBlock(BLUE_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PURPLE_MUSHROOM = registerHiddenBlock("potted_purple_mushroom", settings -> new FlowerPotBlock(PURPLE_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_BLUE_LUMINESCENT_MUSHROOM = registerHiddenBlock("potted_blue_luminescent_mushroom", settings -> new FlowerPotBlock(BLUE_LUMINESCENT_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque().luminance(state -> 5));
    public static final Block POTTED_LUMINESCENT_PINK_MUSHROOM = registerHiddenBlock("potted_luminescent_pink_mushroom", settings -> new FlowerPotBlock(LUMINESCENT_PINK_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_ORANGE_MUSHROOM = registerHiddenBlock("potted_orange_mushroom", settings -> new FlowerPotBlock(ORANGE_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_YELLOW_MUSHROOM = registerHiddenBlock("potted_yellow_mushroom", settings -> new FlowerPotBlock(YELLOW_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_FERTILE_RED_MUSHROOM = registerHiddenBlock("potted_mushroom_fertile_red", settings -> new FlowerPotBlock(FERTILE_RED_MUSHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());

    public static final Block POTTED_OCULAE = registerHiddenBlock("potted_oculae", settings -> new FlowerPotBlock(OCULAE, settings), AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM).nonOpaque());
    public static final Block POTTED_CYANUS_RUBENS = registerHiddenBlock("potted_cyanus_rubens", settings -> new FlowerPotBlock(CYANUS_RUBENS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_CYANEA = registerHiddenBlock("potted_cyanea", settings -> new FlowerPotBlock(CYANEA, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_SOL_OCCIDENTIS = registerHiddenBlock("potted_sol_occidentis", settings -> new FlowerPotBlock(SOL_OCCIDENTIS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_FUTIALI = registerHiddenBlock("potted_futiali", settings -> new FlowerPotBlock(FUTIALI, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_NOCTULICA = registerHiddenBlock("potted_noctulica", settings -> new FlowerPotBlock(NOCTULICA, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PREHISTORIC_ROSE = registerHiddenBlock("potted_prehistoric_rose", settings -> new FlowerPotBlock(PREHISTORIC_ROSE, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PREHISTO_BLUE_SCHROOM = registerHiddenBlock("potted_prehisto_blue_schroom", settings -> new FlowerPotBlock(PREHISTO_BLUE_SCHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PREHISTO_PINK_SCHROOM = registerHiddenBlock("potted_prehisto_pink_schroom", settings -> new FlowerPotBlock(PREHISTO_PINK_SCHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PREHISTURPLE_SCHROOM = registerHiddenBlock("potted_prehisturple_schroom", settings -> new FlowerPotBlock(PREHISTURPLE_SCHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PREHISTO_GREEN_SCHROOM = registerHiddenBlock("potted_prehisto_green_schroom", settings -> new FlowerPotBlock(PREHISTO_GREEN_SCHROOM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());

    public static final Block POTTED_YELLOW_PERENNIAL = registerHiddenBlock("potted_perennial_yellow", settings -> new FlowerPotBlock(YELLOW_PERENNIAL, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_GREEN_PERENNIAL = registerHiddenBlock("potted_perennial_green", settings -> new FlowerPotBlock(GREEN_PERENNIAL, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_ORANGE_PERENNIAL = registerHiddenBlock("potted_perennial_orange", settings -> new FlowerPotBlock(ORANGE_PERENNIAL, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_BLUE_PERENNIAL = registerHiddenBlock("potted_perennial_blue", settings -> new FlowerPotBlock(BLUE_PERENNIAL, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_LUMINESCENT_PERENNIAL = registerHiddenBlock("potted_perennial_luminescent", settings -> new FlowerPotBlock(LUMINESCENT_PERENNIAL, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PINK_PERENNIAL = registerHiddenBlock("potted_perennial_pink", settings -> new FlowerPotBlock(PINK_PERENNIAL, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());

    public static final Block POTTED_PURPLE_PERENNIAL = registerHiddenBlock("potted_perennial_purple", settings -> new FlowerPotBlock(PURPLE_PERENNIAL, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_RED_QUINCE = registerHiddenBlock("potted_quince_red", settings -> new FlowerPotBlock(RED_QUINCE, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_YELLOW_QUINCE = registerHiddenBlock("potted_quince_yellow", settings -> new FlowerPotBlock(YELLOW_QUINCE, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_YELICE = registerHiddenBlock("potted_yelice", settings -> new FlowerPotBlock(YELICE, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_FLAMESTHYSIA = registerHiddenBlock("potted_flamesthysia", settings -> new FlowerPotBlock(FLAMESTHYSIA, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_APAGANTHE = registerHiddenBlock("potted_apaganthe", settings -> new FlowerPotBlock(APAGANTHE, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_WYSTERIA = registerHiddenBlock("potted_wysteria", settings -> new FlowerPotBlock(WYSTERIA, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_BLUEBELL = registerHiddenBlock("potted_bluebell", settings -> new FlowerPotBlock(WYSTERIA, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_VIPERIN = registerHiddenBlock("potted_viperin", settings -> new FlowerPotBlock(VIPERIN, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_HIBISCUS = registerHiddenBlock("potted_hibiscus", settings -> new FlowerPotBlock(HIBISCUS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PLATUM = registerHiddenBlock("potted_platum", settings -> new FlowerPotBlock(PLATUM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_DIANTHUS = registerHiddenBlock("potted_dianthus", settings -> new FlowerPotBlock(DIANTHUS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_CYCAS = registerHiddenBlock("potted_cycas", settings -> new FlowerPotBlock(CYCAS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_ARUM = registerHiddenBlock("potted_arum", settings -> new FlowerPotBlock(ARUM, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_HYDRANGEA = registerHiddenBlock("potted_hydrangea", settings -> new FlowerPotBlock(HYDRANGEA, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_ANEMONE = registerHiddenBlock("potted_anemone", settings -> new FlowerPotBlock(ANEMONE, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_JACYNTHE = registerHiddenBlock("potted_jacynthe", settings -> new FlowerPotBlock(JACYNTHE, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_BLUE_LUMINESCENT_SAPPLING = registerHiddenBlock("potted_blue_luminescent_sappling", settings -> new FlowerPotBlock(ModBlocks.BLUE_LUMINESCENT_SAPPLING, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_COLORFUL_TREE_SAPLING = registerHiddenBlock("potted_colorful_tree_sapling", settings -> new FlowerPotBlock(ModBlocks.COLORFUL_TREE_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_PELTOGYNE_SAPLING = registerHiddenBlock("potted_peltogyne_sapling", settings -> new FlowerPotBlock(ModBlocks.PELTOGYNE_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());
    public static final Block POTTED_OAK_BERRIES_SAPLING = registerHiddenBlock("potted_oak_berries_sapling", settings -> new FlowerPotBlock(ModBlocks.OAK_BERRIES_LEAVES, settings), AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM).nonOpaque());


    //Grass
    public static final Block TINY_GRASS = registerBlock("tiny_grass", ShortPlantBlock::new, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS));
    public static final Block BLUE_LUMINESCENT_GRASS = registerBlock("grass_blue_luminescent", ShortPlantBlock::new, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).luminance(state -> 9));
    public static final Block BLUE_LUMINESCENT_TALL_GRASS = registerBlock("grass_tall_blue_luminescent", TallPlantBlock::new, AbstractBlock.Settings.copy(Blocks.TALL_GRASS).luminance(state -> 11));

    //Vines
    public static final Block PINK_MUSHROOM_VINES = registerHiddenBlock("mushroom_vines_pink", PinkMushroomVinesHeadBlock::new, AbstractBlock.Settings.create().breakInstantly().sounds(BlockSoundGroup.CAVE_VINES).pistonBehavior(PistonBehavior.DESTROY).noCollision());
    public static final Block PINK_MUSHROOM_VINES_PLANT = registerHiddenBlock("mushroom_vines_pink_plant", PinkMushroomVinesBodyBlock::new, AbstractBlock.Settings.create().breakInstantly().sounds(BlockSoundGroup.CAVE_VINES).pistonBehavior(PistonBehavior.DESTROY).noCollision());
    public static final Block PINK_LUMINESCENT_BODY_VINES = registerHiddenBlock("mushroom_vines_pink_luminescent_body", PinkLuminescentBodyVinesBlock::new, AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.HONEY).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().luminance(state -> state.get(PinkLuminescentBodyVinesBlock.MANY_VINES) ? 0 : 15));
    public static final Block PINK_LUMINESCENT_HEAD_VINES = registerHiddenBlock("mushroom_vines_pink_luminescent_head", PinkLuminescentHeadVinesBlock::new, AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.HONEY).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().luminance(state -> 3));
    public static final Block CAERULEA_VOLUBILIS = registerHiddenBlock("caerulea_volubilis", BlueLuminescentVines::new, AbstractBlock.Settings.copy(Blocks.TWISTING_VINES).luminance(state -> 12));
    public static final Block BLUE_LUMINESCENT_VINES = registerBlock("vines_blue_luminescent", RoofSimpleVines::new, AbstractBlock.Settings.copy(Blocks.VINE).nonOpaque().luminance(state -> 10));

    //Leaves
    public static final Block BLUE_LUMINESCENT_LEAVES = registerBlock("leaves_blue_luminescent", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).luminance(state -> 10).nonOpaque());
    public static final Block RED_COLORFUL_LEAVES = registerBlock("leaves_colorful_red", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque());
    public static final Block PINK_COLORFUL_LEAVES = registerBlock("leaves_colorful_pink", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque());
    public static final Block ORANGE_COLORFUL_LEAVES = registerBlock("leaves_colorful_orange", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque());
    public static final Block YELLOW_COLORFUL_LEAVES = registerBlock("leaves_colorful_yellow", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque());
    public static final Block GREEN_COLORFUL_LEAVES = registerBlock("leaves_colorful_green", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque());
    public static final Block BLUE_COLORFUL_LEAVES = registerBlock("leaves_colorful_blue", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque());
    public static final Block PURPLE_COLORFUL_LEAVES = registerBlock("leaves_colorful_purple", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque());
    public static final Block OAK_BERRIES_LEAVES = registerBlock("leaves_oak_berries", BerriesLeaves::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).luminance(BerriesLeaves.getLuminanceSupplier()));
    public static final Block PELTOGYNE_LEAVES = registerBlock("leaves_peltogyne", LeavesBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque());


    //Light Blocks
    public static final Block RED_LANTERN = registerBlock("lantern_red", LanternBlock::new, AbstractBlock.Settings.copy(Blocks.LANTERN).luminance(state -> 15).nonOpaque());
    public static final Block GREEN_LANTERN = registerBlock("lantern_green", LanternBlock::new, AbstractBlock.Settings.copy(Blocks.LANTERN).luminance(state -> 13).nonOpaque());
    public static final Block GREEN_TORCH = registerHiddenBlock("torch_green", settings -> new TorchBlock(ModParticles.GREENFIRE_PARTICLE, settings), AbstractBlock.Settings.copy(Blocks.TORCH).luminance(state -> 12).nonOpaque());
    public static final Block WALL_GREEN_TORCH = registerHiddenBlock("torch_wall_green", settings -> new WallTorchBlock(ModParticles.GREENFIRE_PARTICLE, settings), AbstractBlock.Settings.copy(Blocks.WALL_TORCH).luminance(state -> 12).nonOpaque());
    public static final Block GREEN_CAMPFIRE = registerBlock("campfire_green", settings -> new CampfireBlock(true, 1, settings), AbstractBlock.Settings.copy(Blocks.CAMPFIRE).luminance(state -> 13).nonOpaque());


    //Construction Blocks
    public static final Block LAVA_BLACKSTONE_BRICKS = registerBlock("blackstone_lava_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.BLACKSTONE).luminance(state -> 8));
    public static final Block LAVA_BLACKSTONE_MEDIUM_BRICKS = registerBlock("blackstone_lava_medium_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.BLACKSTONE).luminance(state -> 8));
    public static final Block LAVA_BLACKSTONE_TINY_BRICKS = registerBlock("blackstone_lava_tiny_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.BLACKSTONE).luminance(state -> 8));
    public static final Block RHYOLITE_TILES = registerBlock("rhyolite_tiles", Block::new, AbstractBlock.Settings.copy(Blocks.BRICKS).nonOpaque());

    //Wood
    public static final Block BLUE_LUMINESCENT_LOG = registerBlock("log_blue_luminescent", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LOG));
    public static final Block PELTOGYNE_LOG = registerBlock("log_peltogyne", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_LOG));

    public static final Block BLUE_LUMINESCENT_WOOD = registerBlock("wood_blue_luminescent", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_WOOD));
    public static final Block PELTOGYNE_WOOD = registerBlock("wood_peltogyne", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_WOOD));

    public static final Block BLUE_LUMINESCENT_STRIPPED_LOG = registerBlock("log_stripped_blue_luminescent", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG));
    public static final Block PELTOGYNE_STRIPPED_LOG = registerBlock("log_stripped_peltogyne", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG));

    public static final Block BLUE_LUMINESCENT_STRIPPED_WOOD = registerBlock("wood_stripped_blue_luminescent", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD));
    public static final Block PELTOGYNE_STRIPPED_WOOD = registerBlock("wood_stripped_peltogyne", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD));

    public static final Block BLUE_LUMINESCENT_PLANKS = registerBlock("planks_blue_luminescent", Block::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block PELTOGYNE_PLANKS = registerBlock("planks_peltogyne", Block::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));

    public static final Block BLUE_LUMINESCENT_TRAPDOOR = registerBlock("trapdoor_blue_luminescent", settings -> new TrapdoorBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR));
    public static final Block PELTOGYNE_TRAPDOOR = registerBlock("trapdoor_peltogyne", settings -> new TrapdoorBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR));

    public static final Block BLUE_LUMINESCENT_DOOR = registerBlock("door_blue_luminescent", settings -> new DoorBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_DOOR));
    public static final Block PELTOGYNE_DOOR = registerBlock("door_peltogyne", settings -> new DoorBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_DOOR));

    public static final Block BLUE_LUMINESCENT_BUTTON = registerBlock("button_blue_luminescent", settings -> new ButtonBlock(BlockSetType.OAK, 20, settings), AbstractBlock.Settings.copy(Blocks.OAK_BUTTON));
    public static final Block PELTOGYNE_BUTTON = registerBlock("button_peltogyne", settings -> new ButtonBlock(BlockSetType.OAK, 20, settings), AbstractBlock.Settings.copy(Blocks.OAK_BUTTON));

    public static final Block BLUE_LUMINESCENT_PRESSURE_PLATE = registerBlock("pressure_plate_blue_luminescent", settings -> new PressurePlateBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
    public static final Block PELTOGYNE_PRESSURE_PLATE = registerBlock("pressure_plate_peltogyne", settings -> new PressurePlateBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE));

    public static final Block BLUE_LUMINESCENT_FENCE = registerBlock("fence_blue_luminescent", FenceBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_FENCE));
    public static final Block PELTOGYNE_FENCE = registerBlock("fence_peltogyne", FenceBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_FENCE));

    public static final Block BLUE_LUMINESCENT_STAIRS = registerBlock("stairs_blue_luminescent", settings -> new StairsBlock(BLUE_LUMINESCENT_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).luminance(state -> 8));
    public static final Block PELTOGYNE_STAIRS = registerBlock("stairs_peltogyne", settings -> new StairsBlock(PELTOGYNE_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).luminance(state -> 8));

    public static final Block BLUE_LUMINESCENT_SLAB = registerBlock("slab_blue_luminescent", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_SLAB));
    public static final Block PELTOGYNE_SLAB = registerBlock("slab_peltogyne", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_SLAB));

    public static final Block BLUE_LUMINESCENT_FENCE_GATE = registerBlock("fence_gate_blue_luminescent", settings -> new FenceGateBlock(WoodType.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE));
    public static final Block PELTOGYNE_FENCE_GATE = registerBlock("fence_gate_peltogyne", settings -> new FenceGateBlock(WoodType.OAK, settings), AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE));

    public static final Block COLORFUL_TREE_SAPLING = registerBlock("sapling_colorful_tree", settings -> new SaplingBlock(ModSaplings.COLORFUL_TREE_SAPLING_GENERATOR, settings), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));
    public static final Block BLUE_LUMINESCENT_SAPPLING = registerBlock("sappling_blue_luminescent", settings -> new SaplingBlock(ModSaplings.BLUE_LUMINESCENT_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));
    public static final Block OAK_BERRIES_SAPLING = registerBlock("sapling_oak_berries", settings -> new SaplingBlock(ModSaplings.OAK_BERRIES_SAPLING_GENERATOR, settings), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).luminance(state -> 9));
    public static final Block PELTOGYNE_SAPLING = registerBlock("sapling_peltogyne", settings -> new SaplingBlock(ModSaplings.PELTOGYNE_SAPLING_GENERATOR, settings), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));

    //Crystal Blocks
    public static final Block PINK_CRYSTAL = registerHiddenBlock("crystal_pink", Block::new, AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER));
    public static final Block BLUE_CRYSTAL = registerHiddenBlock("crystal_blue", StraightCrystal::new, AbstractBlock.Settings.create().solid().nonOpaque().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5f).pistonBehavior(PistonBehavior.DESTROY).luminance(state -> 8));
    public static final Block RED_CRYSTAL = registerHiddenBlock("crystal_red", StraightCrystal::new, AbstractBlock.Settings.create().solid().nonOpaque().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5f).pistonBehavior(PistonBehavior.DESTROY).luminance(state -> 8));
    public static final Block RED_CRYSTAL_BLOCK = registerBlock("crystal_block_red", TransparentBlock::new, AbstractBlock.Settings.create().solid().nonOpaque().sounds(ModBlockSoundGroup.PINK_CRYSTAL).luminance(state -> 12).strength(2.8f));
    public static final Block BLUE_CRYSTAL_BLOCK = registerBlock("crystal_block_blue", TransparentBlock::new, AbstractBlock.Settings.copy(ModBlocks.RED_CRYSTAL_BLOCK).luminance(state -> 12));
    public static final Block PINK_CRYSTAL_BLOCK = registerBlock("crystal_block_pink", AmethystBlock::new, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).sounds(ModBlockSoundGroup.PINK_CRYSTAL));
    public static final Block WHITE_CRYSTAL = registerBlock("crystal_white", SimpleCystal::new, AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER));
    public static final Block WHITE_CRYSTAL_BLOCK = registerBlock("crystal_block_white", TransparentBlock::new, AbstractBlock.Settings.copy(ModBlocks.RED_CRYSTAL_BLOCK).luminance(state -> 12));

    public static final Block BLUE_CRYSTAL_CLUSTER = registerBlock("crystal_blue_1", TallBlock::new, AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER).luminance(state -> 11));

    public static final Block RAW_AMBER_BLOCK = registerBlock("amber_block_raw", Block::new, AbstractBlock.Settings.copy(Blocks.RAW_GOLD_BLOCK));
    public static final Block AMBER_MINERAL = registerBlock("amber_block_mineral", TransparentBlock::new, AbstractBlock.Settings.create().luminance(state -> 9).nonOpaque().strength(2.0f));
    public static final Block AMBER_BLOCK = registerBlock("amber_block", AmbreBlock::new, AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK));
    public static final Block AMBER_BLOCK_SANDIFIED = registerBlock("amber_block_sandified", settings -> new SandifiedAmbreBlock(settings, ModBlocks.AMBER_BLOCK), AbstractBlock.Settings.copy(Blocks.SANDSTONE));
    public static final Block AMBER_ORE = registerBlock("amber_ore", Block::new, AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE));

    //Util Blocks
    public static final Block FORGE_BLOCK = registerBlock("forge_block", ForgeBlock::new, AbstractBlock.Settings.copy(Blocks.ANVIL).nonOpaque());

    //Idk
    public static final Block CLOUD_BLOCK = registerBlock("cloud_block", Block::new, AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK).strength(0.6f));

    //dev
    public static final Block FEATURE_TESTER = registerBlock("feature_block", settings -> new FeatureTester(settings, ModConfiguredFeatures.FEATURE_TESTER_KEY), AbstractBlock.Settings.create());


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings.registryKey(keyOf(name)));
        Block block2 = Registry.register(Registries.BLOCK, keyOf(name), block);
        registerBlockItem(name, block2);
        return block2;
    }

    private static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MushrooomsMod.MOD_ID, id));
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(MushrooomsMod.MOD_ID, name), new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(keyOfItem(name))));
    }
    public static RegistryKey<Item> keyOfItem(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MushrooomsMod.MOD_ID, id));
    }

    private static Block registerHiddenBlock(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return Blocks.register(keyOf(id), factory, settings);
    }

    public static void registerModBlocks() {
        MushrooomsMod.LOGGER.info("Registering Blocks");
    }
}
