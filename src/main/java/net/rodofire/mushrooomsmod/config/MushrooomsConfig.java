package net.rodofire.mushrooomsmod.config;

import net.rodofire.easierworldcreator.config.ConfigCategory;
import net.rodofire.easierworldcreator.config.ModConfig;
import net.rodofire.easierworldcreator.config.objects.IntegerConfigObject;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class MushrooomsConfig {
    public static ModConfig CONFIG = new ModConfig(MushrooomsMod.MOD_ID);
    public static ConfigCategory SERVER = new ConfigCategory("server");
    public static ConfigCategory CLIENT = new ConfigCategory("client");
    public static boolean init = false;

    public static void initConfig() {
        MushrooomsMod.LOGGER.info("|\t-Registering Config" );
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

        CONFIG.addCategories(SERVER);
        CONFIG.addCategories(CLIENT);

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
}
