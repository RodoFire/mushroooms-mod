package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.config.MushrooomsConfig;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModCaveRegion;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldRegion;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldRegionSimplified;
import net.rodofire.mushrooomsmod.world.biome.rules.ModMaterialsRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    public static int getCommonBiomesSpawnRate() {
        return MushrooomsConfig.getCommonBiomeSpawnRate();
    }

    public static int getCaveBiomesSpawnRate() {
        return MushrooomsConfig.getCavesBiomesSpawnRate();
    }

    @Override
    public void onTerraBlenderInitialized() {
        if(!MushrooomsConfig.init){
            MushrooomsMod.LOGGER.info("-[Mushrooomsmod Config] Initializing :");
            MushrooomsConfig.initConfig();
        }
        Regions.register(new ModOverworldRegion(Identifier.of(MushrooomsMod.MOD_ID, "overworld"), getCommonBiomesSpawnRate()));
        Regions.register(new ModCaveRegion(Identifier.of(MushrooomsMod.MOD_ID, "overworld_caves"), getCaveBiomesSpawnRate()));
        Regions.register(new ModOverworldRegionSimplified(Identifier.of(MushrooomsMod.MOD_ID, "overworld_simplified"), 4));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MushrooomsMod.MOD_ID, ModMaterialsRules.makeRules());
    }
}
