package fr.rodofire.mushrooomsmod;

import fr.rodofire.mushrooomsmod.block.BlockUtils;
import fr.rodofire.mushrooomsmod.block.ModBlockEntities;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.config.MushrooomsConfig;
import fr.rodofire.mushrooomsmod.effect.ModStatusEffects;
import fr.rodofire.mushrooomsmod.entity.ModEntities;
import fr.rodofire.mushrooomsmod.entity.ModEntitiesAttribute;
import fr.rodofire.mushrooomsmod.item.ModItemGroup;
import fr.rodofire.mushrooomsmod.item.ModItems;
import fr.rodofire.mushrooomsmod.networking.ModNetwork;
import fr.rodofire.mushrooomsmod.particle.ModParticles;
import fr.rodofire.mushrooomsmod.recipe.ModRecipes;
import fr.rodofire.mushrooomsmod.sound.ModSounds;
import fr.rodofire.mushrooomsmod.util.ModLootTableModifier;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.ModFeatures;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModDecoratorTypes;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.placementmodifier.ModPlacementModifierType;
import fr.rodofire.mushrooomsmod.world.gen.ModWorldGeneration;
import fr.rodofire.mushrooomsmod.world.structures.ModStructureKey;
import fr.rodofire.mushrooomsmod.world.structures.ModStructurePieceType;
import fr.rodofire.mushrooomsmod.world.structures.ModStructureTypes;

public class MushrooomsMod {

    private static boolean initialized = false;

    public static void initialize() {

        if(initialized) return;

        initialized = true;
        MushrooomsModConstants.LOGGER.info("[MushrooomsMod] Initializing :");
        MushrooomsModConstants.LOGGER.info("-[Config] Initializing :");
        MushrooomsConfig.initConfig();

        MushrooomsModConstants.LOGGER.info("-[Blocks] Initializing :");
        //blocks
        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();

        BlockUtils.registerStripable();
        BlockUtils.registerFlammable();

        MushrooomsModConstants.LOGGER.info("-[Items] Initializing :");
        //items
        ModItems.registerModItems();
        ModItemGroup.registerItemGroup();

        MushrooomsModConstants.LOGGER.info("-[Entities] Initializing :");
        //entities
        ModEntities.registerModENtities();
        ModEntities.spawnRestriction();
        ModEntitiesAttribute.registerAttributes();

        MushrooomsModConstants.LOGGER.info("-[World-Gen] Initializing :");
        //world-gen
        ModTrunkPlacerTypes.registerTrunkPlacers();
        ModFoliagePlacerTypes.registerFoliagePlacers();
        ModDecoratorTypes.registerDecorators();
        ModWorldGeneration.registerModWorldGen();
        ModFeatures.registerFeatures();
        ModPlacementModifierType.registerPlacementModifiers();

        MushrooomsModConstants.LOGGER.info("-[Structures] Initializing :");
        ModStructureTypes.registerStructureTypes();
        ModStructurePieceType.registerStructurePiecesType();
        ModStructureKey.registerStructureKeys();


        MushrooomsModConstants.LOGGER.info("-[Misc] Initializing :");
        ModParticles.registerParticles();
        ModStatusEffects.registerEffects();

        ModSounds.registerModSound();


        ModLootTableModifier.modifyLootTable();

        ModRecipes.registerRecipes();

        ModNetwork.registerC2SPackets();


        MushrooomsModConstants.LOGGER.info("[MushrooomsMod] Started!");
    }
}