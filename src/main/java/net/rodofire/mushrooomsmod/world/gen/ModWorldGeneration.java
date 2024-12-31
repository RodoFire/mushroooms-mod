package net.rodofire.mushrooomsmod.world.gen;

import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModWorldGeneration {
    public static void registerModWorldGen() {
        MushrooomsMod.LOGGER.info("|\t-Registering World Generation");
        ModPlantsGeneration.generateFlowers();
        ModPlantsGeneration.generateVines();
        ModTreeGeneration.generateTrees();

        ModEntityGeneration.addSpawn();
        ModEntityGeneration.spawnRestriction();

        ModOreGeneration.generateOres();

    }
}
