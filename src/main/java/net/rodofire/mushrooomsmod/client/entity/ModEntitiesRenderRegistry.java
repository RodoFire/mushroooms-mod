package net.rodofire.mushrooomsmod.client.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.client.renderer.*;

public class ModEntitiesRenderRegistry {
    public static void registerEntities() {
        EntityRendererRegistry.register(ModEntities.GROKI, GrokiRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOLETE_COW, BoleteCowRenderer::new);
        EntityRendererRegistry.register(ModEntities.PLOTI, PlotiRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_CREEPER, CrystalCreeperRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        //EntityRendererRegistry.register(ModEntities.SCHROOM_STICK, SchroomStickRenderer::new);
        EntityRendererRegistry.register(ModEntities.INVENTORY_ARMOR_STAND_ENTITY, InventoryArmorStandRenderer::new);
        EntityRendererRegistry.register(ModEntities.LOCKED_INVENTORY_ARMOR_STAND, InventoryArmorStandRenderer::new);
        //EntityRendererRegistry.register(ModEntities.MOSQUITO_ENTITY, MosquitoRenderer::new);
    }
}
