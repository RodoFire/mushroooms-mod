package net.rodofire.mushrooomsmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.text.Text;
import net.rodofire.mushrooomsmod.block.BlockUtils;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.config.MushrooomsConfig;
import net.rodofire.mushrooomsmod.effect.ModStatusEffects;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.ModEntitiesAttribute;
import net.rodofire.mushrooomsmod.item.ModItemGroup;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.networking.ModNetwork;
import net.rodofire.mushrooomsmod.particle.ModParticles;
import net.rodofire.mushrooomsmod.recipe.ModRecipes;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import net.rodofire.mushrooomsmod.util.ModLootTableModifier;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModFeatures;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModDecoratorTypes;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;
import net.rodofire.mushrooomsmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class MushrooomsMod implements ModInitializer {

    public static final String MOD_ID = "mushrooomsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static MushrooomsConfig CONFIG;

    @Override
    public void onInitialize() {
        LOGGER.info("[MushrooomsMod] Initializing :");
        LOGGER.info("-[Config] Initializing :");
        MushrooomsConfig.initConfig();

        LOGGER.info("-[Blocks] Initializing :");
        //blocks
        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();

        BlockUtils.registerStripable();
        BlockUtils.registerFlammable();

        LOGGER.info("-[Items] Initializing :");
        //items
        ModItems.registerModItems();
        ModItemGroup.registerItemGroup();
        GeckoLib.initialize();

        LOGGER.info("-[Entities] Initializing :");
        //entities
        ModEntities.registerModENtities();
        ModEntities.spawnRestriction();
        ModEntitiesAttribute.registerAttributes();

        LOGGER.info("-[World-Gen] Initializing :");
        //world-gen
        ModTrunkPlacerTypes.registerTrunkPlacers();
        ModFoliagePlacerTypes.registerFoliagePlacers();
        ModDecoratorTypes.registerDecorators();
        ModWorldGeneration.registerModWorldGen();
        ModFeatures.registerFeatures();


        LOGGER.info("-[Misc] Initializing :");
        ModParticles.registerParticles();
        ModStatusEffects.registerEffects();

        ModSounds.registerModSound();


        ModLootTableModifier.modifyLootTable();

        ModRecipes.registerRecipes();

        ModNetwork.registerC2SPackets();


        LOGGER.info("[MushrooomsMod] Started!");
    }
}