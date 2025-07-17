package fr.rodofire.mushrooomsmod.world.biome;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.config.MushrooomsConfig;
import fr.rodofire.mushrooomsmod.world.biome.overworld.ModCaveRegion;
import fr.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldRegion;
import fr.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldRegionSimplified;
import fr.rodofire.mushrooomsmod.world.biome.rules.ModOverWorldSurfaceRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class ModTerrablenderAPI  {
    public static int getCommonBiomesSpawnRate() {
        return MushrooomsConfig.getCommonBiomeSpawnRate();
    }

    public static int getCaveBiomesSpawnRate() {
        return MushrooomsConfig.getCavesBiomesSpawnRate();
    }

    public static void initTerraBlender() {
        if(!MushrooomsConfig.init){
            MushrooomsModConstants.LOGGER.info("-[Mushrooomsmod Config] Initializing :");
            MushrooomsConfig.initConfig();
        }
        MushrooomsModConstants.LOGGER.info("-[Mushrooomsmod - Terrablender] Initializing :");

        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "overworld"), getCommonBiomesSpawnRate()));
        MushrooomsModConstants.LOGGER.info("|\t-Registering Overworld common" );
        Regions.register(new ModCaveRegion(ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "overworld_caves"), getCaveBiomesSpawnRate()));
        MushrooomsModConstants.LOGGER.info("|\t-Registering Overworld caves" );
        Regions.register(new ModOverworldRegionSimplified(ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "overworld_simplified"), getCommonBiomesSpawnRate()));
        MushrooomsModConstants.LOGGER.info("|\t-Registering Overworld common - 2" );
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MushrooomsModConstants.MOD_ID, ModOverWorldSurfaceRules.makeRules());
    }
}
