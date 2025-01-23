package net.rodofire.mushrooomsmod.config;

import net.rodofire.easierworldcreator.config.ModClientConfig;
import net.rodofire.easierworldcreator.config.client.ConfigScreen;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class MushrooomsClientConfig {
    public static final ModClientConfig CLIENT_CONFIG = new ModClientConfig(MushrooomsConfig.CONFIG);

    public static void init() {
        System.out.println(CLIENT_CONFIG.getConfig());
        ConfigScreen.putModId(MushrooomsMod.MOD_ID, CLIENT_CONFIG);
    }

}
