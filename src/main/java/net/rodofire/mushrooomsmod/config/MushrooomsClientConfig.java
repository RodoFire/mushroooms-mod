package net.rodofire.mushrooomsmod.config;

import net.rodofire.easierworldcreator.config.ModClientConfig;
import net.rodofire.mushrooomsmod.config.client.FastSurfaceRulesScreen;

public class MushrooomsClientConfig {
    public static final ModClientConfig CLIENT_CONFIG = new ModClientConfig(MushrooomsConfig.CONFIG);

    public static void init() {
        CLIENT_CONFIG.put("server", MushrooomsConfig.CONFIG.getCategory("server").getBools().get("fast_surface_rules"), new FastSurfaceRulesScreen());
    }

}
