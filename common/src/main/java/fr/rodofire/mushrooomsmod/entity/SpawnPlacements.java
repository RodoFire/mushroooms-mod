package fr.rodofire.mushrooomsmod.entity;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.entity.custom.*;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;

public class SpawnPlacements {

    public static void spawnRestriction() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Spawn Restrictions.");
        // ATTENTION: appeler ceci seulement pendant le CommonSetup (enqueueWork)
        net.minecraft.world.entity.SpawnPlacements.register(ModEntities.CRYSTAL_GOLEM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrystalGolemEntity::checkMobSpawnRules);
        net.minecraft.world.entity.SpawnPlacements.register(ModEntities.CRYSTAL_CREEPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, net.minecraft.world.entity.monster.Monster::checkMonsterSpawnRules);

        net.minecraft.world.entity.SpawnPlacements.register(ModEntities.PLOTI.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PlotiEntity::checkAnimalSpawnRules);
        net.minecraft.world.entity.SpawnPlacements.register(ModEntities.SCHROOM_STICK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SchroomStickEntity::checkAnimalSpawnRules);
        net.minecraft.world.entity.SpawnPlacements.register(ModEntities.BOLETE_COW.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BoleteCowEntity::checkAnimalSpawnRules);
        net.minecraft.world.entity.SpawnPlacements.register(ModEntities.SQUIRREL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SquirrelEntity::checkAnimalSpawnRules);
    }
}
