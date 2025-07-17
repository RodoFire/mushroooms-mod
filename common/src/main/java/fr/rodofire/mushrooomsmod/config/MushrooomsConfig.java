package fr.rodofire.mushrooomsmod.config;

import fr.rodofire.ewc.config.ConfigCategory;
import fr.rodofire.ewc.config.ModConfig;
import fr.rodofire.ewc.config.objects.BooleanConfigObject;
import fr.rodofire.ewc.config.objects.IntegerConfigObject;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;

public class MushrooomsConfig {
    public static ModConfig CONFIG = new ModConfig(MushrooomsModConstants.MOD_ID);
    public static ConfigCategory SERVER = new ConfigCategory("server");
    public static ConfigCategory CLIENT = new ConfigCategory("client");
    public static boolean init = false;

    public static void initConfig() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Config" );
        BooleanConfigObject bool = new BooleanConfigObject(false, "reduce surface rules performance impact by limiting the rules quality", "fast_surface_rules");
        bool.requireRestart = true;
        SERVER.addBoolean(bool);


        IntegerConfigObject int1 = new IntegerConfigObject(
                4,
                1,
                Integer.MAX_VALUE,
                "common_biome_spawn_rate",
                "the default biome spawn rate, default is 4, high values means that the mod biomes will be more present and other biomes will be rarer"
        );
        int1.requireRestart = true;

        IntegerConfigObject int2 = new IntegerConfigObject(
                4,
                1,
                Integer.MAX_VALUE,
                "cave_biome_spawn_rate",
                "the caves biome spawn rate, default is 4, high values means that the mod biomes will be more present and other biomes will be rarer"
        );
        int2.requireRestart = true;

        SERVER.addInt(int1);
        SERVER.addInt(int2);

        CLIENT.addBoolean("beta_warning_message", "send warning chat message upon world join", true);

        CONFIG.addCategories(CLIENT);
        CONFIG.addCategories(SERVER);

        CONFIG.init();
        init = true;
    }

    public static boolean clientWarnMessage() {
        return CONFIG.getCategory("client").getBools().get("beta_warning_message").getActualValue();
    }

    public static int getCommonBiomeSpawnRate() {
        return CONFIG.getCategory("server").getInts().get("common_biome_spawn_rate").getActualValue();
    }

    public static int getCavesBiomesSpawnRate() {
        return CONFIG.getCategory("server").getInts().get("cave_biome_spawn_rate").getActualValue();
    }

    public static boolean getFastSurfaceRules() {
        return CONFIG.getCategory("server").getBools().get("fast_surface_rules").getActualValue();
    }
}
