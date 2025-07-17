package fr.rodofire.mushrooomsmod;


import fr.rodofire.mushrooomsmod.hud.HammerHUDOverlayNeo;
import fr.rodofire.mushrooomsmod.platform.RegistriesKeeper;
import fr.rodofire.mushrooomsmod.platform.RegistryHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(MushrooomsModConstants.MOD_ID)
public class MushrooomsModNeoforge {

    public MushrooomsModNeoforge(IEventBus modEventBus) {
        // Enregistre tous les RegistryHandler dans le bon DeferredRegister
        for (RegistryHandler<?> rawHandler : RegistriesKeeper.registries) {
            registerGenericForge(rawHandler, modEventBus);
        }

        MushrooomsModConstants.LOGGER.info("Hello NeoForge world!");
        MushrooomsMod.initialize();
        HammerHUDOverlayNeo.register();
    }

    @SuppressWarnings("unchecked")
    private <T> void registerGenericForge(RegistryHandler<?> rawHandler, IEventBus modEventBus) {
        RegistryHandler<T> handler = (RegistryHandler<T>) rawHandler;

        DeferredRegister<T> deferred = DeferredRegister.create(
                handler.getType().key(),
                MushrooomsModConstants.MOD_ID
        );

        handler.getEntries().forEach(deferred::register);
        deferred.register(modEventBus);
        MushrooomsModConstants.LOGGER.info("|\t-Registering ${}.", handler.getType().key().registry().getPath());
    }
}