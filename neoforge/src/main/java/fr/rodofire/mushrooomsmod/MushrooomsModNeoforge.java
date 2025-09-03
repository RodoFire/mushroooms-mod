package fr.rodofire.mushrooomsmod;

import fr.rodofire.MushrooomsModDeffered;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import fr.rodofire.mushrooomsmod.platform.NeoForgePlatformHelper;

@Mod(MushrooomsModConstants.MOD_ID)
public class MushrooomsModNeoforge {

    public MushrooomsModNeoforge(IEventBus modEventBus) {
        MushrooomsModConstants.LOGGER.info("Hello NeoForge world!");
        // Enregistrez toutes vos DeferredRegister ici

        // Inscrire le listener de setup, puis faire le travail en différé
        modEventBus.addListener(this::onCommonSetup);
        MushrooomsMod.initialize();
        NeoForgePlatformHelper.registerAll(modEventBus);
        MushrooomsModDeffered.deffer();
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        // Ici ok pour de l'init post-enregistrement (réseaux, compat, etc.)
        event.enqueueWork(() -> {

        });
    }
}