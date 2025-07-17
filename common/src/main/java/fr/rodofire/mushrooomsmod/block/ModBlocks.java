package fr.rodofire.mushrooomsmod.block;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.block.custom.*;
import fr.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines.PinkLuminescentBodyVinesBlock;
import fr.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines.PinkLuminescentHeadVinesBlock;
import fr.rodofire.mushrooomsmod.block.custom.PinkMushroomBlock.PinkMushroomVinesBodyBlock;
import fr.rodofire.mushrooomsmod.block.custom.PinkMushroomBlock.PinkMushroomVinesHeadBlock;
import fr.rodofire.mushrooomsmod.block.custom.bigmushroom.*;
import fr.rodofire.mushrooomsmod.mixin.block.*;
import fr.rodofire.mushrooomsmod.particle.ModParticles;
import fr.rodofire.mushrooomsmod.platform.RegistryHandler;
import fr.rodofire.mushrooomsmod.sound.ModBlockSoundGroup;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModSaplings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class ModBlocks {
    public static final List<Supplier<Block>> BLOCKS = new ArrayList<>();
    public static final List<Supplier<Item>> BLOCK_ITEMS = new ArrayList<>();

    static final RegistryHandler<Block> BLOCK_HANDLER = new RegistryHandler<>(BuiltInRegistries.BLOCK, BLOCKS);
    static final RegistryHandler<Item> ITEM_HANDLER = new RegistryHandler<>(BuiltInRegistries.ITEM, BLOCK_ITEMS);


    /*--------------------Natural Blocks--------------------*/
    /*-----------Mushroom Block Related-----------*/
    //Mushroom Block
    public static final Supplier<Block> PURPLE_MUSHROOM_BLOCK = registerBlock("mushroom_block_purple", new FermentedMushroomBlock(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> ORANGE_MUSHROOM_BLOCK = registerBlock("mushroom_block_orange", new FermentedMushroomBlock(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> YELLOW_MUSHROOM_BLOCK = registerBlock("mushroom_block_yellow", new FermentedMushroomBlock(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BLUE_MUSHROOM_BLOCK = registerBlock("mushroom_block_blue", new FermentedMushroomBlock(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> GREEN_MUSHROOM_BLOCK = registerBlock("mushroom_block_green", new FermentedMushroomBlock(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BLUE_LUMINESCENT_MUSHROOM_BLOCK = registerBlock("mushroom_block_blue_luminescent", new FermentedTransparentMushroomBlock(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> PINK_LUMINESCENT_MUSHROOM_BLOCK = registerBlock("mushroom_block_pink_luminescent", new FermentedTransparentMushroomBlock(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));

    //Fermented Stage 1
    public static final Supplier<Block> PURPLE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_purple", new FermentedMushroomBlock(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> ORANGE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_orange", new FermentedMushroomBlock(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> YELLOW_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_yellow", new FermentedMushroomBlock(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BLUE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_blue", new FermentedMushroomBlock(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> GREEN_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_green", new FermentedMushroomBlock(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_blue_luminescent", new FermentedTransparentMushroomBlock(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion().lightLevel(state -> 8)));
    public static final Supplier<Block> PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_pink_luminescent", new FermentedTransparentMushroomBlock(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion().lightLevel(state -> 8)));
    public static final Supplier<Block> RED_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_red", new FermentedMushroomBlock(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BROWN_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_brown", new FermentedMushroomBlock(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));

    //Fermented Stage 2
    public static final Supplier<Block> PURPLE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_purple", new FermentedMushroomBlock(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> ORANGE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_orange", new FermentedMushroomBlock(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> YELLOW_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_yellow", new FermentedMushroomBlock(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BLUE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_blue", new FermentedMushroomBlock(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> GREEN_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_green", new FermentedMushroomBlock(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_blue_luminescent", new FermentedTransparentMushroomBlock(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion().lightLevel(state -> 8)));
    public static final Supplier<Block> PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_pink_luminescent", new FermentedTransparentMushroomBlock(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion().lightLevel(state -> 8)));
    public static final Supplier<Block> RED_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_red", new FermentedMushroomBlock(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BROWN_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_brown", new FermentedMushroomBlock(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK, false, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));

    //Fermented Mushrooms
    public static final Supplier<Block> PURPLE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_purple", new FermentedMushroomBlock(ModBlocks.PURPLE_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> ORANGE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_orange", new FermentedMushroomBlock(ModBlocks.ORANGE_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> YELLOW_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_yellow", new FermentedMushroomBlock(ModBlocks.YELLOW_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BLUE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_blue", new FermentedMushroomBlock(ModBlocks.BLUE_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> GREEN_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_green", new FermentedMushroomBlock(ModBlocks.GREEN_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_blue_luminescent", new FermentedTransparentMushroomBlock(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion().lightLevel(state -> 8)));
    public static final Supplier<Block> PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_pink_luminescent", new FermentedTransparentMushroomBlock(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion().lightLevel(state -> 8)));
    public static final Supplier<Block> RED_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_red", new FermentedMushroomBlock(() -> Blocks.RED_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Supplier<Block> BROWN_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_brown", new FermentedMushroomBlock(() -> Blocks.BROWN_MUSHROOM_BLOCK, true, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK)));

    //mushrooms
    public static final Supplier<Block> GREEN_MUSHROOM = registerBlock("mushroom_green", new MushroomBlock(ModConfiguredFeatures.GREEN_MUSHROOM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)));
    public static final Supplier<Block> PURPLE_MUSHROOM = registerBlock("mushroom_purple", new MushroomBlock(ModConfiguredFeatures.PURPLE_MUSHROOM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)));
    public static final Supplier<Block> BLUE_MUSHROOM = registerBlock("mushroom_blue", new MushroomBlock(ModConfiguredFeatures.BLUE_MUSHROOM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)));
    public static final Supplier<Block> BLUE_LUMINESCENT_MUSHROOM = registerBlock("mushroom_blue_luminescent", new MushroomBlock(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).lightLevel(state -> 5)));
    public static final Supplier<Block> LUMINESCENT_PINK_MUSHROOM = registerBlock("mushroom_pink_luminescent", new MushroomBlock(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).lightLevel(state -> 5)));
    public static final Supplier<Block> ORANGE_MUSHROOM = registerBlock("mushroom_orange", new MushroomBlock(ModConfiguredFeatures.ORANGE_MUSHROOM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)));
    public static final Supplier<Block> YELLOW_MUSHROOM = registerBlock("mushroom_yellow", new MushroomBlock(ModConfiguredFeatures.YELLOW_MUSHROOM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).lightLevel(state -> 5)));
    public static final Supplier<Block> FERTILE_RED_MUSHROOM = registerBlock("mushroom_fertile_red", new MushroomBlock(ModConfiguredFeatures.FERTILE_RED_MUSHROOM, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)));

    //Big Mushrooms
    public static final Supplier<Block> BIG_PURPLE_MUSHROOM_PLANT = registerHiddenBlock("mushroom_big_plant_purple", new BigPurpleMushroomPlant(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)));
    public static final Supplier<Block> TINY_PURPLE_MUSHROOM = registerBlock("mushroom_tiny_purple", new TinyPurpleMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noCollission().noOcclusion(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE));
    public static final Supplier<Block> LITTLE_PURPLE_MUSHROOM = registerBlock("mushroom_little_purple", new LittlePurpleMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE));
    public static final Supplier<Block> MEDIUM_PURPLE_MUSHROOM = registerBlock("mushroom_medium_purple", new MediumPurpleMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE));
    public static final Supplier<Block> BIG_PURPLE_MUSHROOM = registerBlock("mushroom_big_purple", new BigPurpleMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE));
    public static final Supplier<Block> TINY_GREEN_MUSHROOM = registerBlock("mushroom_tiny_green", new TinyGreenMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion(), ModConfiguredFeatures.CRYING_GREEN_MUSHROOM_TREE));
    public static final Supplier<Block> LITTLE_GREEN_MUSHROOM = registerBlock("mushroom_little_green", new LittleGreenMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion(), ModConfiguredFeatures.CRYING_GREEN_MUSHROOM_TREE));
    public static final Supplier<Block> MEDIUM_GREEN_MUSHROOM = registerBlock("mushroom_medium_green", new MediumGreenMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion(), ModConfiguredFeatures.CRYING_GREEN_MUSHROOM_TREE));
    public static final Supplier<Block> BIG_GREEN_MUSHROOM = registerBlock("mushroom_big_green", new BigGreenMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion(), ModConfiguredFeatures.CRYING_GREEN_MUSHROOM_TREE));
    public static final Supplier<Block> BIG_GREEN_MUSHROOM_PLANT = registerHiddenBlock("mushroom_big_plant_green", new BigGreenMushroomPlant(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM), ModBlocks.TINY_GREEN_MUSHROOM.get(), ModBlocks.LITTLE_GREEN_MUSHROOM.get(), ModBlocks.MEDIUM_GREEN_MUSHROOM.get(), ModBlocks.BIG_GREEN_MUSHROOM.get()));
    public static final Supplier<Block> RED_LUMERIA = registerBlock("red_lumeria", new BigRedMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion().noCollission(), ModConfiguredFeatures.BIG_RED_MUSHROOM_TREE));
    public static final Supplier<Block> TALL_YELLOW_MUSHROOMS = registerBlock("tall_yellow_mushrooms", new TallYellowMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion().noCollission()));

    //Side Mushrooms
    public static final Supplier<Block> SIDE_MUSHROOM_BLUE_LUMINESCENT = registerBlock("mushroom_side_blue_luminescent", new SideMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).lightLevel(state -> 11)));
    public static final Supplier<Block> LOG_MUSHROOM_BROWN = registerBlock("mushroom_log_brown", new LogMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion()));

    //Flowers Mushroom
    public static final Supplier<Block> STERILE_BLUE_MUSHROOM = registerBlock("mushroom_small_blue", new MushroomFlower(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> MUSHROOM_SMALL_BROWN = registerBlock("mushroom_small_brown", new MushroomFlower(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> MUSHROOM_SMALL_RED = registerBlock("mushroom_small_red", new MushroomFlower(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> MUSHROOM_DEATH_TRUMPET = registerBlock("mushroom_death_trumpet", new MushroomFlower(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> MUSHROOM_BOOSTING = registerHiddenBlock("mushroom_boosting", new BoostingMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> DANGEROUS_MUSHROOM_BOOSTING = registerHiddenBlock("dangerous_mushroom_boosting", new DangerousBoostingMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));

    //Mushroom Stem
    public static final Supplier<Block> TRANSPARENT_MUSHROOM_STEM = registerBlock("mushroom_stem_transparent", HalfTransparentBlockMixin.invokeCtor(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion().lightLevel(state -> 9)));
    public static final Supplier<Block> BLUE_LUMINESCENT_MUSHROOM_STEM = registerBlock("mushroom_stem_blue_luminescent", HalfTransparentBlockMixin.invokeCtor(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion().lightLevel(state -> 9)));
    public static final Supplier<Block> GREEN_MUSHROOM_STEM = registerBlock("mushroom_stem_green", HalfTransparentBlockMixin.invokeCtor(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion()));

    //Other Mushrooms Blocks
    public static final Supplier<Block> COMPRESSED_PURPLE_MUSHROOM = registerBlock("mushroom_compressed_purple", new MossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK)));

    //Soft Blocks
    public static final Supplier<Block> COMPRESSED_DIRT = registerBlock("dirt_compressed", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final Supplier<Block> LIGHT_COMPRESSED_DIRT = registerBlock("dirt_compressed_light", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    /*-----------Stone Related-----------*/
    //Hard Blocks
    public static final Supplier<Block> PURPLE_SCHROOM_DEESLATE = registerBlock("deepslate_mushroom_purple", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM)));
    public static final Supplier<Block> BLUE_LUMINESCENT_SCHROOM_DEEPSLATE = registerBlock("deepslate_mushroom_blue_luminescent", new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM)));
    public static final Supplier<Block> GREEN_STONY_SCHROOM_DEPOT = registerBlock("stone_mushroom_green", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM)));
    public static final Supplier<Block> RHYOLITE = registerBlock("rhyolite", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM)));
    public static final Supplier<Block> LAVA_BLACKSTONE = registerBlock("blackstone_lava", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).lightLevel(state -> 8)));

    /*-----------Flower Related-----------*/
    //Flowers
    public static final Supplier<Block> OCULAE = registerBlock("oculae", new FlowerBlock(MobEffects.DARKNESS, 1000, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).noOcclusion().noCollission()));
    public static final Supplier<Block> CYANUS_RUBENS = registerBlock("cyanus_rubens", new FlowerBlock(MobEffects.DARKNESS, 1000, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).noOcclusion().noCollission()));
    public static final Supplier<Block> CYANEA = registerBlock("cyanea", new FlowerBlock(MobEffects.DARKNESS, 1000, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).lightLevel(state -> 12).noOcclusion().noCollission()));
    public static final Supplier<Block> SOL_OCCIDENTIS = registerBlock("sol_occidens", new FlowerBlock(MobEffects.DARKNESS, 1000, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).noOcclusion().noCollission()));
    public static final Supplier<Block> FUTIALI = registerBlock("futiali", new FlowerBlock(MobEffects.DARKNESS, 1000, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).noOcclusion().lightLevel(state -> 11).noCollission()));
    public static final Supplier<Block> MUSHROOM_FLOWERS = registerBlock("mushroom_flowers", new FlowersMushroomBlock(ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).noOcclusion().noCollission()));
    public static final Supplier<Block> TURQUOSUM_STILUS = registerBlock("turquosum_stilus", new TallFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).lightLevel(state -> 11).noOcclusion().noCollission()));
    public static final Supplier<Block> NOCTULICA = registerBlock("noctulica", new FlowerBlock(MobEffects.DARKNESS, 1000, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).lightLevel(state -> 12).noOcclusion().noCollission()));
    public static final Supplier<Block> SAPHIRA_FLORENS = registerBlock("saphira_florens", new TallFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().lightLevel(state -> 11).noCollission()));
    public static final Supplier<Block> PREHISTORIC_ROSE = registerBlock("prehistoric_rose", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PREHISTO_PINK_SCHROOM = registerBlock("prehisto_pink_schroom", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PREHISTURPLE_SCHROOM = registerBlock("prehisturple_schroom", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PREHISTO_BLUE_SCHROOM = registerBlock("prehisto_blue_schroom", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PREHISTO_GREEN_SCHROOM = registerBlock("prehisto_green_schroom", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> YELLOW_PERENNIAL = registerBlock("perennial_yellow", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PINK_PERENNIAL = registerBlock("perennial_pink", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> BLUE_PERENNIAL = registerBlock("perennial_blue", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> GREEN_PERENNIAL = registerBlock("perennial_green", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> LUMINESCENT_PERENNIAL = registerBlock("perennial_luminescent", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> ORANGE_PERENNIAL = registerBlock("perennial_orange", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PURPLE_PERENNIAL = registerBlock("perennial_purple", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> RED_QUINCE = registerBlock("quince_red", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> YELLOW_QUINCE = registerBlock("quince_yellow", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> TINY_LILAC = registerBlock("tiny_lilac", new TallFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> YELICE = registerBlock("yelice", new FlowerBlock(MobEffects.GLOWING, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> FLAMESTHYSIA = registerBlock("flamesthysia", new FlowerBlock(MobEffects.GLOWING, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> APAGANTHE = registerBlock("apaganthe", new FlowerBlock(MobEffects.GLOWING, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PINK_HEATER = registerBlock("pink_heater", new TallFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> WYSTERIA = registerBlock("wysteria", new FlowerBlock(MobEffects.GLOWING, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> BLUEBELL = registerBlock("bluebell", new FlowerBlock(MobEffects.GLOWING, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> VIPERIN = registerBlock("viperin", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> HIBISCUS = registerBlock("hibiscus", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PLATUM = registerBlock("platum", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).lightLevel(state -> 10).noOcclusion().noCollission()));
    public static final Supplier<Block> DIANTHUS = registerBlock("dianthus", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> CYCAS = registerBlock("cycas", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> ARUM = registerBlock("arum", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> HYDRANGEA = registerBlock("hydrangea", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> ANEMONE = registerBlock("anemone", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> JACYNTHE = registerBlock("jacynthe", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> PERVENCHE = registerBlock("pervenche", new TallFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> ACONIT = registerBlock("aconit", new TallFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission()));
    public static final Supplier<Block> RAPANGE_FLOWERS = registerBlock("rapange_flowers", new RapangeFlowers(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission().lightLevel(RapangeFlowers.getLuminanceSupplier())));
    public static final Supplier<Block> FLEUR_BERRIES = registerHiddenBlock("berries_fleur", new FleurBerries(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().lightLevel(state -> state.getValue(BlockStateProperties.AGE_3) * 4)));
    public static final Supplier<Block> BRIGHT_YELLOW_MUSHROOM = registerBlock("bright_yellow_mushroom", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission().lightLevel(state -> 10)));
    public static final Supplier<Block> BUSHY_YELLOW_MUSHROOM = registerBlock("bushy_yellow_mushrooms", new FlowerBlock(MobEffects.GLOWING, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().noCollission().lightLevel(state -> 7)));

    public static final Supplier<Block> PICK_BLUE = registerBlock("pick_blue", new PickBlue(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).noOcclusion().lightLevel(state -> 11)));



    //Grass
    public static final Supplier<Block> TINY_GRASS = registerBlock("tiny_grass", TallGrassBlockMixin.invokeCtor(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
    public static final Supplier<Block> BLUE_LUMINESCENT_GRASS = registerBlock("grass_blue_luminescent", TallGrassBlockMixin.invokeCtor(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).lightLevel(state -> 9)));
    public static final Supplier<Block> BLUE_LUMINESCENT_TALL_GRASS = registerBlock("grass_tall_blue_luminescent", new DoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).lightLevel(state -> 11)));

    //Vines
    public static final Supplier<Block> PINK_MUSHROOM_VINES = registerHiddenBlock("mushroom_vines_pink", new PinkMushroomVinesHeadBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY).noCollission()));
    public static final Supplier<Block> PINK_MUSHROOM_VINES_PLANT = registerHiddenBlock("mushroom_vines_pink_plant", new PinkMushroomVinesBodyBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY).noCollission()));
    public static final Supplier<Block> PINK_LUMINESCENT_BODY_VINES = registerHiddenBlock("mushroom_vines_pink_luminescent_body", new PinkLuminescentBodyVinesBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.HONEY_BLOCK).pushReaction(PushReaction.DESTROY).instabreak().lightLevel(state -> state.getValue(PinkLuminescentBodyVinesBlock.MANY_VINES) ? 0 : 15)));
    public static final Supplier<Block> PINK_LUMINESCENT_HEAD_VINES = registerHiddenBlock("mushroom_vines_pink_luminescent_head", new PinkLuminescentHeadVinesBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.HONEY_BLOCK).pushReaction(PushReaction.DESTROY).instabreak().lightLevel(state -> 3)));
    public static final Supplier<Block> CAERULEA_VOLUBILIS = registerHiddenBlock("caerulea_volubilis", new BlueLuminescentVines(BlockBehaviour.Properties.ofFullCopy(Blocks.TWISTING_VINES).lightLevel(state -> 12)));
    public static final Supplier<Block> BLUE_LUMINESCENT_VINES = registerBlock("vines_blue_luminescent", new RoofSimpleVines(BlockBehaviour.Properties.ofFullCopy(Blocks.VINE).noOcclusion().lightLevel(state -> 10)));

    //Leaves
    public static final Supplier<Block> BLUE_LUMINESCENT_LEAVES = registerBlock("leaves_blue_luminescent", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).lightLevel(state -> 10).noOcclusion()));
    public static final Supplier<Block> RED_COLORFUL_LEAVES = registerBlock("leaves_colorful_red", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()));
    public static final Supplier<Block> PINK_COLORFUL_LEAVES = registerBlock("leaves_colorful_pink", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()));
    public static final Supplier<Block> ORANGE_COLORFUL_LEAVES = registerBlock("leaves_colorful_orange", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()));
    public static final Supplier<Block> YELLOW_COLORFUL_LEAVES = registerBlock("leaves_colorful_yellow", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()));
    public static final Supplier<Block> GREEN_COLORFUL_LEAVES = registerBlock("leaves_colorful_green", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()));
    public static final Supplier<Block> BLUE_COLORFUL_LEAVES = registerBlock("leaves_colorful_blue", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()));
    public static final Supplier<Block> PURPLE_COLORFUL_LEAVES = registerBlock("leaves_colorful_purple", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()));
    public static final Supplier<Block> OAK_BERRIES_LEAVES = registerBlock("leaves_oak_berries", new BerriesLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).lightLevel(BerriesLeaves.getLuminanceSupplier())));
    public static final Supplier<Block> PELTOGYNE_LEAVES = registerBlock("leaves_peltogyne", new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()));


    //Light Blocks
    public static final Supplier<Block> RED_LANTERN = registerBlock("lantern_red", new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).lightLevel(state -> 15).noOcclusion()));
    public static final Supplier<Block> GREEN_LANTERN = registerBlock("lantern_green", new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).lightLevel(state -> 13).noOcclusion()));
    public static final Supplier<Block> GREEN_TORCH = registerHiddenBlock("torch_green", TorchBlockMixin.invokeCtor(ModParticles.GREENFIRE_PARTICLE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).lightLevel(state -> 12).noOcclusion()));
    public static final Supplier<Block> WALL_GREEN_TORCH = registerHiddenBlock("torch_wall_green", WallTorchBlockMixin.invokeCtor(ModParticles.GREENFIRE_PARTICLE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).lightLevel(state -> 12).noOcclusion()));
    public static final Supplier<Block> GREEN_CAMPFIRE = registerBlock("campfire_green", new CampfireBlock(true, 1, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).lightLevel(state -> 13).noOcclusion()));


    //Construction Blocks
    public static final Supplier<Block> LAVA_BLACKSTONE_BRICKS = registerBlock("blackstone_lava_bricks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).lightLevel(state -> 8)));
    public static final Supplier<Block> LAVA_BLACKSTONE_MEDIUM_BRICKS = registerBlock("blackstone_lava_medium_bricks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).lightLevel(state -> 8)));
    public static final Supplier<Block> LAVA_BLACKSTONE_TINY_BRICKS = registerBlock("blackstone_lava_tiny_bricks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).lightLevel(state -> 8)));
    public static final Supplier<Block> RHYOLITE_TILES = registerBlock("rhyolite_tiles", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).noOcclusion()));

    //Wood
    public static final Supplier<Block> BLUE_LUMINESCENT_LOG = registerBlock("log_blue_luminescent", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final Supplier<Block> PELTOGYNE_LOG = registerBlock("log_peltogyne", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final Supplier<Block> BLUE_LUMINESCENT_WOOD = registerBlock("wood_blue_luminescent", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final Supplier<Block> PELTOGYNE_WOOD = registerBlock("wood_peltogyne", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));

    public static final Supplier<Block> BLUE_LUMINESCENT_STRIPPED_LOG = registerBlock("log_stripped_blue_luminescent", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final Supplier<Block> PELTOGYNE_STRIPPED_LOG = registerBlock("log_stripped_peltogyne", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final Supplier<Block> BLUE_LUMINESCENT_STRIPPED_WOOD = registerBlock("wood_stripped_blue_luminescent", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Supplier<Block> PELTOGYNE_STRIPPED_WOOD = registerBlock("wood_stripped_peltogyne", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Supplier<Block> BLUE_LUMINESCENT_PLANKS = registerBlock("planks_blue_luminescent", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> PELTOGYNE_PLANKS = registerBlock("planks_peltogyne", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final Supplier<Block> BLUE_LUMINESCENT_TRAPDOOR = registerBlock("trapdoor_blue_luminescent", TrapDoorBlockMixin.invokeCtor(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final Supplier<Block> PELTOGYNE_TRAPDOOR = registerBlock("trapdoor_peltogyne", TrapDoorBlockMixin.invokeCtor(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

    public static final Supplier<Block> BLUE_LUMINESCENT_DOOR = registerBlock("door_blue_luminescent", DoorBlockMixin.invokeCtor(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final Supplier<Block> PELTOGYNE_DOOR = registerBlock("door_peltogyne", DoorBlockMixin.invokeCtor(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));

    public static final Supplier<Block> BLUE_LUMINESCENT_BUTTON = registerBlock("button_blue_luminescent", ButtonBlockMixin.invokeCtor(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final Supplier<Block> PELTOGYNE_BUTTON = registerBlock("button_peltogyne", ButtonBlockMixin.invokeCtor(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final Supplier<Block> BLUE_LUMINESCENT_PRESSURE_PLATE = registerBlock("pressure_plate_blue_luminescent", PressurePlateBlockMixin.invokeCtor(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final Supplier<Block> PELTOGYNE_PRESSURE_PLATE = registerBlock("pressure_plate_peltogyne", PressurePlateBlockMixin.invokeCtor(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));

    public static final Supplier<Block> BLUE_LUMINESCENT_FENCE = registerBlock("fence_blue_luminescent", new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final Supplier<Block> PELTOGYNE_FENCE = registerBlock("fence_peltogyne", new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));

    public static final Supplier<Block> BLUE_LUMINESCENT_STAIRS = registerBlock("stairs_blue_luminescent", StairBlockMixin.invokeCtor(BLUE_LUMINESCENT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).lightLevel(state -> 8)));
    public static final Supplier<Block> PELTOGYNE_STAIRS = registerBlock("stairs_peltogyne", StairBlockMixin.invokeCtor(PELTOGYNE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).lightLevel(state -> 8)));

    public static final Supplier<Block> BLUE_LUMINESCENT_SLAB = registerBlock("slab_blue_luminescent", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final Supplier<Block> PELTOGYNE_SLAB = registerBlock("slab_peltogyne", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));

    public static final Supplier<Block> BLUE_LUMINESCENT_FENCE_GATE = registerBlock("fence_gate_blue_luminescent", new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final Supplier<Block> PELTOGYNE_FENCE_GATE = registerBlock("fence_gate_peltogyne", new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

    public static final Supplier<Block> COLORFUL_TREE_SAPLING = registerBlock("sapling_colorful_tree", SaplingBlockMixin.invokeCtor(ModSaplings.COLORFUL_TREE_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<Block> BLUE_LUMINESCENT_SAPPLING = registerBlock("sappling_blue_luminescent", SaplingBlockMixin.invokeCtor(ModSaplings.BLUE_LUMINESCENT_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final Supplier<Block> OAK_BERRIES_SAPLING = registerBlock("sapling_oak_berries", SaplingBlockMixin.invokeCtor(ModSaplings.OAK_BERRIES_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).lightLevel(state -> 9)));
    public static final Supplier<Block> PELTOGYNE_SAPLING = registerBlock("sapling_peltogyne", SaplingBlockMixin.invokeCtor(ModSaplings.PELTOGYNE_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    //Crystal Blocks
    public static final Supplier<Block> PINK_CRYSTAL = registerHiddenBlock("crystal_pink", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER)));
    public static final Supplier<Block> BLUE_CRYSTAL = registerHiddenBlock("crystal_blue", new StraightCrystal(BlockBehaviour.Properties.of().forceSolidOn().noOcclusion().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).pushReaction(PushReaction.DESTROY).lightLevel(state -> 8)));
    public static final Supplier<Block> RED_CRYSTAL = registerHiddenBlock("crystal_red", new StraightCrystal(BlockBehaviour.Properties.of().forceSolidOn().noOcclusion().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).pushReaction(PushReaction.DESTROY).lightLevel(state -> 8)));
    public static final Supplier<Block> PINK_CRYSTAL_BLOCK = registerBlock("crystal_block_pink", new AmethystBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)/*.sound(ModBlockSoundGroup.PINK_CRYSTAL)*//*TODO fix*/));
    public static final Supplier<Block> WHITE_CRYSTAL = registerBlock("crystal_white", new SimpleCystal(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER)));

    public static final Supplier<Block> BLUE_CRYSTAL_CLUSTER = registerBlock("crystal_blue_1", new TallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER).lightLevel(state -> 11)));

    public static final Supplier<Block> RAW_AMBER_BLOCK = registerBlock("amber_block_raw", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final Supplier<Block> AMBER_MINERAL = registerBlock("amber_block_mineral", HalfTransparentBlockMixin.invokeCtor(BlockBehaviour.Properties.of().lightLevel(state -> 9).noOcclusion().strength(2.0f)));
    public static final Supplier<Block> AMBER_BLOCK = registerBlock("amber_block", new AmbreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
    public static final Supplier<Block> AMBER_BLOCK_SANDIFIED = registerBlock("amber_block_sandified", new SandifiedAmbreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE), ModBlocks.AMBER_BLOCK.get()));
    public static final Supplier<Block> AMBER_ORE = registerBlock("amber_ore", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE)));

    //Util Blocks
    public static final Supplier<Block> FORGE_BLOCK = registerBlock("forge_block", new ForgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL).noOcclusion()));

    //Idk
    public static final Supplier<Block> CLOUD_BLOCK = registerBlock("cloud_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK).strength(0.6f)));

    //dev
    public static final Supplier<Block> FEATURE_TESTER = registerBlock("feature_block", new FeatureTester(BlockBehaviour.Properties.of(), ModConfiguredFeatures.FEATURE_TESTER));


    /*-----------Potted Blocks-----------*/
    //Potted Mushrooms
    public static final Supplier<Block> POTTED_STERILE_BLUE_MUSHROOM = registerHiddenBlock("potted_sterile_blue_mushroom", new FlowerPotBlock(STERILE_BLUE_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_MUSHROOM_SMALL_BROWN = registerHiddenBlock("potted_mushroom_small_brown", new FlowerPotBlock(MUSHROOM_SMALL_BROWN.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_MUSHROOM_SMALL_RED = registerHiddenBlock("potted_mushroom_small_red", new FlowerPotBlock(MUSHROOM_SMALL_RED.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_MUSHROOM_DEATH_TRUMPET = registerHiddenBlock("potted_mushroom_death_trumpet", new FlowerPotBlock(MUSHROOM_DEATH_TRUMPET.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));

    //Potted Flowers
    public static final Supplier<Block> POTTED_GREEN_MUSHROOM = registerHiddenBlock("potted_green_mushroom", new FlowerPotBlock(GREEN_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_BLUE_MUSHROOM = registerHiddenBlock("potted_blue_mushroom", new FlowerPotBlock(BLUE_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PURPLE_MUSHROOM = registerHiddenBlock("potted_purple_mushroom", new FlowerPotBlock(PURPLE_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_BLUE_LUMINESCENT_MUSHROOM = registerHiddenBlock("potted_blue_luminescent_mushroom", new FlowerPotBlock(BLUE_LUMINESCENT_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion().lightLevel(state -> 5)));
    public static final Supplier<Block> POTTED_LUMINESCENT_PINK_MUSHROOM = registerHiddenBlock("potted_luminescent_pink_mushroom", new FlowerPotBlock(LUMINESCENT_PINK_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_ORANGE_MUSHROOM = registerHiddenBlock("potted_orange_mushroom", new FlowerPotBlock(ORANGE_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_YELLOW_MUSHROOM = registerHiddenBlock("potted_yellow_mushroom", new FlowerPotBlock(YELLOW_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_FERTILE_RED_MUSHROOM = registerHiddenBlock("potted_mushroom_fertile_red", new FlowerPotBlock(FERTILE_RED_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));

    public static final Supplier<Block> POTTED_OCULAE = registerHiddenBlock("potted_oculae", new FlowerPotBlock(OCULAE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).noOcclusion()));
    public static final Supplier<Block> POTTED_CYANUS_RUBENS = registerHiddenBlock("potted_cyanus_rubens", new FlowerPotBlock(CYANUS_RUBENS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_CYANEA = registerHiddenBlock("potted_cyanea", new FlowerPotBlock(CYANEA.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_SOL_OCCIDENTIS = registerHiddenBlock("potted_sol_occidentis", new FlowerPotBlock(SOL_OCCIDENTIS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_FUTIALI = registerHiddenBlock("potted_futiali", new FlowerPotBlock(FUTIALI.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_NOCTULICA = registerHiddenBlock("potted_noctulica", new FlowerPotBlock(NOCTULICA.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PREHISTORIC_ROSE = registerHiddenBlock("potted_prehistoric_rose", new FlowerPotBlock(PREHISTORIC_ROSE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PREHISTO_BLUE_SCHROOM = registerHiddenBlock("potted_prehisto_blue_schroom", new FlowerPotBlock(PREHISTO_BLUE_SCHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PREHISTO_PINK_SCHROOM = registerHiddenBlock("potted_prehisto_pink_schroom", new FlowerPotBlock(PREHISTO_PINK_SCHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PREHISTURPLE_SCHROOM = registerHiddenBlock("potted_prehisturple_schroom", new FlowerPotBlock(PREHISTURPLE_SCHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PREHISTO_GREEN_SCHROOM = registerHiddenBlock("potted_prehisto_green_schroom", new FlowerPotBlock(PREHISTO_GREEN_SCHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));

    public static final Supplier<Block> POTTED_YELLOW_PERENNIAL = registerHiddenBlock("potted_perennial_yellow", new FlowerPotBlock(YELLOW_PERENNIAL.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_GREEN_PERENNIAL = registerHiddenBlock("potted_perennial_green", new FlowerPotBlock(GREEN_PERENNIAL.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_ORANGE_PERENNIAL = registerHiddenBlock("potted_perennial_orange", new FlowerPotBlock(ORANGE_PERENNIAL.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_BLUE_PERENNIAL = registerHiddenBlock("potted_perennial_blue", new FlowerPotBlock(BLUE_PERENNIAL.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_LUMINESCENT_PERENNIAL = registerHiddenBlock("potted_perennial_luminescent", new FlowerPotBlock(LUMINESCENT_PERENNIAL.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PINK_PERENNIAL = registerHiddenBlock("potted_perennial_pink", new FlowerPotBlock(PINK_PERENNIAL.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));

    public static final Supplier<Block> POTTED_PURPLE_PERENNIAL = registerHiddenBlock("potted_perennial_purple", new FlowerPotBlock(PURPLE_PERENNIAL.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_RED_QUINCE = registerHiddenBlock("potted_quince_red", new FlowerPotBlock(RED_QUINCE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_YELLOW_QUINCE = registerHiddenBlock("potted_quince_yellow", new FlowerPotBlock(YELLOW_QUINCE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_YELICE = registerHiddenBlock("potted_yelice", new FlowerPotBlock(YELICE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_FLAMESTHYSIA = registerHiddenBlock("potted_flamesthysia", new FlowerPotBlock(FLAMESTHYSIA.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_APAGANTHE = registerHiddenBlock("potted_apaganthe", new FlowerPotBlock(APAGANTHE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_WYSTERIA = registerHiddenBlock("potted_wysteria", new FlowerPotBlock(WYSTERIA.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_BLUEBELL = registerHiddenBlock("potted_bluebell", new FlowerPotBlock(WYSTERIA.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_VIPERIN = registerHiddenBlock("potted_viperin", new FlowerPotBlock(VIPERIN.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_HIBISCUS = registerHiddenBlock("potted_hibiscus", new FlowerPotBlock(HIBISCUS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PLATUM = registerHiddenBlock("potted_platum", new FlowerPotBlock(PLATUM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_DIANTHUS = registerHiddenBlock("potted_dianthus", new FlowerPotBlock(DIANTHUS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_CYCAS = registerHiddenBlock("potted_cycas", new FlowerPotBlock(CYCAS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_ARUM = registerHiddenBlock("potted_arum", new FlowerPotBlock(ARUM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_HYDRANGEA = registerHiddenBlock("potted_hydrangea", new FlowerPotBlock(HYDRANGEA.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_ANEMONE = registerHiddenBlock("potted_anemone", new FlowerPotBlock(ANEMONE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_JACYNTHE = registerHiddenBlock("potted_jacynthe", new FlowerPotBlock(JACYNTHE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_BLUE_LUMINESCENT_SAPPLING = registerHiddenBlock("potted_blue_luminescent_sappling", new FlowerPotBlock(ModBlocks.BLUE_LUMINESCENT_SAPPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_COLORFUL_TREE_SAPLING = registerHiddenBlock(("potted_colorful_tree_sapling"), new FlowerPotBlock(ModBlocks.COLORFUL_TREE_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_PELTOGYNE_SAPLING = registerHiddenBlock(("potted_peltogyne_sapling"), new FlowerPotBlock(ModBlocks.PELTOGYNE_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));
    public static final Supplier<Block> POTTED_OAK_BERRIES_SAPLING = registerHiddenBlock("potted_oak_berries_sapling", new FlowerPotBlock(ModBlocks.OAK_BERRIES_LEAVES.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).noOcclusion()));

    public static final Supplier<Block> RED_CRYSTAL_BLOCK = registerBlock("crystal_block_red", HalfTransparentBlockMixin.invokeCtor(BlockBehaviour.Properties.of().forceSolidOn().noOcclusion()/*.sound(ModBlockSoundGroup.PINK_CRYSTAL)*//*TODO fix*/.lightLevel(state -> 12).strength(2.8f)));
    public static final Supplier<Block> BLUE_CRYSTAL_BLOCK = registerBlock("crystal_block_blue", HalfTransparentBlockMixin.invokeCtor(BlockBehaviour.Properties.ofFullCopy(ModBlocks.RED_CRYSTAL_BLOCK.get()).lightLevel(state -> 12)));
    public static final Supplier<Block> WHITE_CRYSTAL_BLOCK = registerBlock("crystal_block_white", HalfTransparentBlockMixin.invokeCtor(BlockBehaviour.Properties.ofFullCopy(ModBlocks.RED_CRYSTAL_BLOCK.get()).lightLevel(state -> 12)));


    private static Supplier<Block> registerBlock(String name, Block block) {
        Supplier<Block> supplier = BLOCK_HANDLER.register(name, block);
        registerBlockItem(name, block);

        return supplier;
    }

    private static Supplier<Item> registerBlockItem(String name, Block block) {
        BlockItem blockItem = new BlockItem(block, new Item.Properties());
        return ITEM_HANDLER.register(name, blockItem);
    }

    private static Supplier<Block> registerHiddenBlock(String id, Block block) {
        return BLOCK_HANDLER.register(id, block);
    }

    public static void registerModBlocks() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Blocks.");
    }
}
