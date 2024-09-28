package net.rodofire.mushrooomsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.rodofire.mushrooomsmod.client.blocks.ModBlockEntityRenderFactory;
import net.rodofire.mushrooomsmod.client.blocks.ModBlockRenderType;
import net.rodofire.mushrooomsmod.client.colors.ModColor;
import net.rodofire.mushrooomsmod.client.entity.ModEntitiesRenderRegistry;
import net.rodofire.mushrooomsmod.client.hud.HammerHUDOverlay;
import net.rodofire.mushrooomsmod.networking.ModNetwork;
import net.rodofire.mushrooomsmod.particle.ModParticles;
import net.rodofire.mushrooomsmod.particle.custom.GreenfireParticle;

public class MushrooomsModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModNetwork.registerS2CPackets();

        //colors
        ModColor.createBlockColors();
        ModColor.createItemColors();

        HudRenderCallback.EVENT.register(new HammerHUDOverlay());

        //Blocks
        ModBlockRenderType.createCutoutBlocks();
        ModBlockRenderType.createTransludentBlocks();

        //Entity
        ModEntitiesRenderRegistry.registerEntities();

        //Block Entity
        ModBlockEntityRenderFactory.registerBlockEntities();


        //Particle
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREENFIRE_PARTICLE, GreenfireParticle.Factory::new);
    }

}
