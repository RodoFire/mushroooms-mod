package fr.rodofire.mushrooomsmod.client.entity;

import fr.rodofire.mushrooomsmod.entity.ModEntities;
import fr.rodofire.mushrooomsmod.entity.client.renderer.*;
import fr.rodofire.mushrooomsmod.entity.custom.LockedInventoryArmorStand;
import fr.rodofire.mushrooomsmod.platform.Services;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ModEntitiesRenderRegistry {

    public static void registerEntities() {
        registerMonsters();
        registerAnimals();
        registerGolems();
        registerMisc();
    }

    public static void registerMonsters() {
        Services.PLATFORM.registerEntityRenderer(ModEntities.CRYSTAL_CREEPER, CrystalCreeperRenderer::new);
    }

    public static void registerAnimals() {
        Services.PLATFORM.registerEntityRenderer(ModEntities.GROKI, GrokiRenderer::new);
        Services.PLATFORM.registerEntityRenderer(ModEntities.BOLETE_COW, BoleteCowRenderer::new);
        Services.PLATFORM.registerEntityRenderer(ModEntities.PLOTI, PlotiRenderer::new);
        Services.PLATFORM.registerEntityRenderer(ModEntities.SCHROOM_STICK, SchroomStickRenderer::new);
        Services.PLATFORM.registerEntityRenderer(ModEntities.SQUIRREL, SquirrelRenderer::new);
    }

    public static void registerMisc(){
        Services.PLATFORM.registerEntityRenderer(ModEntities.INVENTORY_ARMOR_STAND_ENTITY, InventoryArmorStandRenderer::new);
        Services.PLATFORM.registerEntityRenderer(ModEntities.LOCKED_INVENTORY_ARMOR_STAND, InventoryArmorStandRenderer::new);
    }

    public static void registerGolems(){
        Services.PLATFORM.registerEntityRenderer(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
    }

}
