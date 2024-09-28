package net.rodofire.mushrooomsmod.world.biome.rules;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import net.rodofire.mushrooomsmod.world.noises.ModNoises;

public class ModMaterialsRules {
    //Dirt Related
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final MaterialRules.MaterialRule COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final MaterialRules.MaterialRule ROOTED_DIRT = makeStateRule(Blocks.ROOTED_DIRT);

    //Stone Related
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
    private static final MaterialRules.MaterialRule MOSSY_COBBLESTONE = makeStateRule(Blocks.MOSSY_COBBLESTONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule PURPLE_MUSHROOM_BLOCK = makeStateRule(ModBlocks.PURPLE_MUSHROOM_BLOCK);
    private static final MaterialRules.MaterialRule GREEN_MUSHROOM_BLOCK = makeStateRule(ModBlocks.GREEN_MUSHROOM_BLOCK);
    private static final MaterialRules.MaterialRule BLUE_LUMINESCENT_DEEPSLATE = makeStateRule(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE);
    private static final MaterialRules.MaterialRule PURPLE_SCHROOM_DEEPSLATE = makeStateRule(ModBlocks.PURPLE_SCHROOM_DEESLATE);


    //rules related
    private static final MaterialRules.MaterialCondition DEEPSLATE_LEVEL = MaterialRules.verticalGradient("deepslate", YOffset.fixed(0), YOffset.fixed(8));
    private static final MaterialRules.MaterialCondition STONE_CAVE_LEVEL = MaterialRules.aboveY(YOffset.fixed(0), 1);
    private static final MaterialRules.MaterialCondition ABOVE_TOP = MaterialRules.aboveY(YOffset.belowTop(-2), 0);
    private static final MaterialRules.MaterialCondition BELOW_TOP = MaterialRules.not(MaterialRules.aboveY(YOffset.belowTop(10), 1));
    private static final MaterialRules.MaterialCondition ABOVE_WATER = MaterialRules.aboveY(YOffset.fixed(60), 0);
    private static final MaterialRules.MaterialCondition IS_AT_OR_ABOVE_WATER = MaterialRules.water(-1, 0);

    public static MaterialRules.MaterialRule makeRules() {
        return sequence(
                /*----- Overworld -----*/
                /*--- Caves ---*/
                createBlueLuminescentCaveRule(),
                createPurpleSchroomCaveRule(),
                createVanillaSchroomCaveRule(),
                createForestCaveRule(),

                /*--- Surface ---*/
                createSchroomIsland1Rule(),
                createSchroomIsland2Rule(),
                createMagicalPlainRule()
        );
    }

    /* --------------- Overworld --------------*/
    /* ---------- Caves ---------*/
    private static MaterialRules.MaterialRule createBlueLuminescentCaveRule() {
        MaterialRules.MaterialRule bluedeepslate = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, BLUE_LUMINESCENT_DEEPSLATE), DEEPSLATE);

        return condition(MaterialRules.biome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                condition(DEEPSLATE_LEVEL, bluedeepslate));
    }

    private static MaterialRules.MaterialRule createPurpleSchroomCaveRule() {
        MaterialRules.MaterialRule purpledeepslate = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, PURPLE_SCHROOM_DEEPSLATE), DEEPSLATE);

        return condition(MaterialRules.biome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                condition(DEEPSLATE_LEVEL, purpledeepslate));
    }

    private static MaterialRules.MaterialRule createVanillaSchroomCaveRule() {
        MaterialRules.MaterialRule dirtfloor = MaterialRules.condition(MaterialRules.stoneDepth(0, true, 3, VerticalSurfaceType.FLOOR), DIRT);

        return sequence(condition(MaterialRules.biome(ModOverworldBiomes.VANILLA_SHROOM_CAVE),
                sequence(condition(BELOW_TOP, sequence(condition(STONE_CAVE_LEVEL,
                        sequence(condition(MaterialRules.STONE_DEPTH_FLOOR,
                                        sequence(condition(emmentalNoiseAbove(0.25d), ROOTED_DIRT), condition(emmentalNoiseAbove(-0.25d), MYCELIUM), COARSE_DIRT)), dirtfloor,
                                sequence(condition(MaterialRules.STONE_DEPTH_CEILING,
                                        sequence(condition(emmentalNoiseAbove(0d), DIRT), condition(emmentalNoiseAbove(-0.2d), ROOTED_DIRT), condition(emmentalNoiseAbove(-0.4d), COARSE_DIRT)))))))))));
    }

    private static MaterialRules.MaterialRule createForestCaveRule() {
        return condition(MaterialRules.biome(ModOverworldBiomes.FOREST_CAVE),
                condition(BELOW_TOP, condition(STONE_CAVE_LEVEL, sequence(condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK),
                        condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, DIRT), condition(MaterialRules.STONE_DEPTH_CEILING, DIRT)))));
    }


    /* ---------- Surface ---------*/
    private static MaterialRules.MaterialRule createSchroomIsland1Rule() {
        return condition(MaterialRules.biome(ModOverworldBiomes.SHROOM_ISLAND1),
                condition(ABOVE_WATER, sequence(condition(MaterialRules.STONE_DEPTH_FLOOR, MYCELIUM), condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, DIRT))));
    }

    private static MaterialRules.MaterialRule createSchroomIsland2Rule() {
        return condition(MaterialRules.biome(ModOverworldBiomes.SHROOM_ISLAND1),
                condition(ABOVE_WATER, sequence(condition(MaterialRules.STONE_DEPTH_FLOOR, MYCELIUM), condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, DIRT))));
    }

    private static MaterialRules.MaterialRule createMagicalPlainRule() {
        return condition(MaterialRules.biome(ModOverworldBiomes.SAKURA_FOREST),
                sequence(condition(IS_AT_OR_ABOVE_WATER, sequence(
                                condition(MaterialRules.STONE_DEPTH_FLOOR, sequence(
                                        condition(patchNoiseAbove(0.15d), GRASS_BLOCK),
                                        condition(patchNoiseAbove(-0.16d), sequence(
                                                condition(emmentalNoiseAbove(0.4d), COBBLESTONE),
                                                condition(emmentalNoiseAbove(-0.4d), STONE),
                                                MOSSY_COBBLESTONE)),
                                        GRASS_BLOCK)))),

                        condition(MaterialRules.STONE_DEPTH_FLOOR, sequence(
                                condition(patchNoiseAbove(0.15d), DIRT),
                                condition(patchNoiseAbove(-0.16d), sequence(
                                        condition(emmentalNoiseAbove(0.4d), COBBLESTONE),
                                        condition(emmentalNoiseAbove(-0.4d), STONE),
                                        MOSSY_COBBLESTONE)),
                                DIRT))

                ));
    }


    /*--------------- Util ---------------*/
    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

    private static MaterialRules.MaterialCondition surfaceNoiseAbove(double min) {
        return MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, min / 8.5d, Double.MAX_VALUE);
    }

    private static MaterialRules.MaterialCondition emmentalNoiseAbove(double min) {
        return MaterialRules.noiseThreshold(ModNoises.EMMENTAL_NOISE, min, Double.MAX_VALUE);
    }

    private static MaterialRules.MaterialCondition patchNoiseAbove(double min) {
        return MaterialRules.noiseThreshold(ModNoises.PATCH_NOISE, min, Double.MAX_VALUE);
    }

    //Methods for better readability
    private static MaterialRules.MaterialRule condition(MaterialRules.MaterialCondition condition, MaterialRules.MaterialRule rule) {
        return MaterialRules.condition(condition, rule);
    }

    private static MaterialRules.MaterialRule sequence(MaterialRules.MaterialRule... rules) {
        return MaterialRules.sequence(rules);
    }
}
