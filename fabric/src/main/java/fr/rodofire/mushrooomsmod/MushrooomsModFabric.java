package fr.rodofire.mushrooomsmod;

import net.fabricmc.api.ModInitializer;

public class MushrooomsModFabric implements ModInitializer {
    static boolean initialized = false;

    @Override
    public void onInitialize() {
        MushrooomsModConstants.LOGGER.info("Hello Fabric world!");
    }

    public static void initializeFabric() {
        if(initialized) return;

        initialized = true;
        MushrooomsMod.initialize();
    }
}
