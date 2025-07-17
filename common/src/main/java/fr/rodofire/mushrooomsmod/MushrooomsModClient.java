package fr.rodofire.mushrooomsmod;

import fr.rodofire.mushrooomsmod.client.blocks.ModBlockEntityRenderFactory;
import fr.rodofire.mushrooomsmod.client.blocks.ModBlockRenderType;
import fr.rodofire.mushrooomsmod.client.colors.ModColor;
import fr.rodofire.mushrooomsmod.client.entity.ModEntitiesRenderRegistry;
import fr.rodofire.mushrooomsmod.client.hud.HammerHUDOverlay;
import fr.rodofire.mushrooomsmod.config.MushrooomsClientConfig;
import fr.rodofire.mushrooomsmod.networking.ModNetwork;
import fr.rodofire.mushrooomsmod.particle.ModParticles;
import fr.rodofire.mushrooomsmod.particle.custom.GreenfireParticle;

public class MushrooomsModClient  {

    public static void initializeClient() {
        MushrooomsModConstants.LOGGER.info("[MushrooomsmodMod] Client Initialization");
        ModNetwork.registerS2CPackets();

        //colors
        ModColor.createBlockColors();
        ModColor.createItemColors();

        //Blocks
        ModBlockRenderType.createCutoutBlocks();
        ModBlockRenderType.createTransludentBlocks();

        //Entity
        ModEntitiesRenderRegistry.registerEntities();

        //Block Entity
        ModBlockEntityRenderFactory.registerBlockEntities();


        //Particle


        MushrooomsClientConfig.init();
    }

}
