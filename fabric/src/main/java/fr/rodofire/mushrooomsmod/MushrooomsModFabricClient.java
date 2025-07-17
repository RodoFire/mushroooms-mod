package fr.rodofire.mushrooomsmod;

import fr.rodofire.mushrooomsmod.hud.HammerHUDOverlayFabric;
import fr.rodofire.mushrooomsmod.particle.ModParticles;
import fr.rodofire.mushrooomsmod.particle.custom.GreenfireParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class MushrooomsModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MushrooomsModClient.initializeClient();
        HudRenderCallback.EVENT.register(new HammerHUDOverlayFabric());
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREENFIRE_PARTICLE.get(), GreenfireParticle.Factory::new);
    }
}
