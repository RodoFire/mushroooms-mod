package fr.rodofire;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.entity.ModEntitiesAttribute;
import fr.rodofire.mushrooomsmod.entity.SpawnPlacements;

public class MushrooomsModDeffered {

    public static void deffer(){
        MushrooomsModConstants.LOGGER.info("[MushrooomsMod] Deffered Initialization :");
        SpawnPlacements.spawnRestriction();
        ModEntitiesAttribute.registerAttributes();

    }
}
