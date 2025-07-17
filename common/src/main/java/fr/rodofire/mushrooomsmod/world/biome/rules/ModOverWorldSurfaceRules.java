package fr.rodofire.mushrooomsmod.world.biome.rules;

import fr.rodofire.ewc.world.gen.surfacebuilder.ExtendedSurfaceRules;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.config.MushrooomsConfig;
import fr.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import fr.rodofire.mushrooomsmod.world.noises.ModNoises;

import java.util.function.Supplier;

public class ModOverWorldSurfaceRules {
    private static final boolean FAST_RULES = MushrooomsConfig.getFastSurfaceRules();

    private static final ResourceLocation rockyId = ResourceLocation.parse("rocky_cave");
    private static final ResourceLocation mushroomShireId = ResourceLocation.parse("mushroom_shire");
    //Dirt Related
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource ROOTED_DIRT = makeStateRule(Blocks.ROOTED_DIRT);
    private static final SurfaceRules.RuleSource MOSS = makeStateRule(Blocks.MOSS_BLOCK);

    //Stone Related
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
    private static final SurfaceRules.RuleSource MOSSY_COBBLESTONE = makeStateRule(Blocks.MOSSY_COBBLESTONE);
    private static final SurfaceRules.RuleSource TUFF = makeStateRule(Blocks.TUFF);
    private static final SurfaceRules.RuleSource ANDESITE = makeStateRule(Blocks.ANDESITE);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource COBBLED_DEEPSLATE = makeStateRule(Blocks.COBBLED_DEEPSLATE);
    private static final SurfaceRules.RuleSource PURPLE_MUSHROOM_BLOCK = makeStateRule(ModBlocks.PURPLE_MUSHROOM_BLOCK);
    private static final SurfaceRules.RuleSource GREEN_MUSHROOM_BLOCK = makeStateRule(ModBlocks.GREEN_MUSHROOM_BLOCK);
    private static final SurfaceRules.RuleSource BLUE_LUMINESCENT_DEEPSLATE = makeStateRule(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE);
    private static final SurfaceRules.RuleSource PURPLE_SCHROOM_DEEPSLATE = makeStateRule(ModBlocks.PURPLE_SCHROOM_DEESLATE);


    //rules related
    private static final SurfaceRules.ConditionSource DEEPSLATE_LEVEL = SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8));
    private static final SurfaceRules.ConditionSource STONE_CAVE_LEVEL = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 1);
    private static final SurfaceRules.ConditionSource ABOVE_TOP = SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(-2), 0);
    private static final SurfaceRules.ConditionSource BELOW_TOP = SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(10), 1));
    private static final SurfaceRules.ConditionSource ABOVE_WATER = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
    private static final SurfaceRules.ConditionSource IS_AT_OR_ABOVE_WATER = SurfaceRules.waterBlockCheck(-1, 0);

    public static SurfaceRules.RuleSource makeRules() {
        if (FAST_RULES) {
            return sequence(
                    /*----- Overworld -----*/
                    /*--- Caves ---*/
                    createBlueLuminescentCaveRule(),
                    createPurpleSchroomCaveRule(),
                    createFastVanillaSchroomCaveRule(),
                    createForestCaveRule(),
                    createFastRockyCaveRules(),
                    createFastMossyCaveRules(),

                    /*--- Surface ---*/
                    createMushroomShireRule(),
                    createMysticMushroGroveRule(),
                    createFastSakuraForestRule()
            );
        }
        return sequence(
                /*----- Overworld -----*/
                /*--- Caves ---*/
                createBlueLuminescentCaveRule(),
                createPurpleSchroomCaveRule(),
                createVanillaSchroomCaveRule(),
                createForestCaveRule(),
                createRockyCaveRules(),
                createMossyCaveRules(),

                /*--- Surface ---*/
                createMushroomShireRule(),
                createMysticMushroGroveRule(),
                createGoldenMycoShroomRule(),
                createSakuraForestRule()
        );
    }

    /* --------------- Overworld --------------*/
    /* ---------- Caves ---------*/
    private static SurfaceRules.RuleSource createBlueLuminescentCaveRule() {
        SurfaceRules.RuleSource bluedeepslate = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, BLUE_LUMINESCENT_DEEPSLATE), DEEPSLATE);

        return condition(SurfaceRules.isBiome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                condition(DEEPSLATE_LEVEL, bluedeepslate));
    }

    private static SurfaceRules.RuleSource createPurpleSchroomCaveRule() {
        SurfaceRules.RuleSource purpledeepslate = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, PURPLE_SCHROOM_DEEPSLATE), DEEPSLATE);

        return condition(SurfaceRules.isBiome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                condition(DEEPSLATE_LEVEL, purpledeepslate));
    }

    private static SurfaceRules.RuleSource createVanillaSchroomCaveRule() {
        SurfaceRules.RuleSource dirtfloor = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 3, CaveSurface.FLOOR), DIRT);

        return sequence(condition(SurfaceRules.isBiome(ModOverworldBiomes.VANILLA_SHROOM_CAVE), sequence(
                condition(BELOW_TOP, sequence(
                        condition(STONE_CAVE_LEVEL, sequence(
                                condition(SurfaceRules.ON_FLOOR, sequence(
                                        condition(emmentalNoiseAbove(0.25d), ROOTED_DIRT),
                                        condition(emmentalNoiseAbove(-0.25d), MYCELIUM),
                                        COARSE_DIRT)
                                ),
                                dirtfloor,
                                condition(SurfaceRules.ON_CEILING,
                                        sequence(
                                                condition(emmentalNoiseAbove(0d), DIRT),
                                                condition(emmentalNoiseAbove(-0.2d), ROOTED_DIRT),
                                                condition(emmentalNoiseAbove(-0.4d), COARSE_DIRT)
                                        )
                                ))
                        )
                ))
        )));
    }

    private static SurfaceRules.RuleSource createFastVanillaSchroomCaveRule() {
        SurfaceRules.RuleSource dirtfloor = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 3, CaveSurface.FLOOR), DIRT);

        return sequence(condition(SurfaceRules.isBiome(ModOverworldBiomes.VANILLA_SHROOM_CAVE), sequence(
                condition(BELOW_TOP, sequence(
                        condition(STONE_CAVE_LEVEL, sequence(
                                condition(SurfaceRules.ON_FLOOR, MYCELIUM),
                                dirtfloor,
                                condition(SurfaceRules.ON_CEILING, DIRT)
                        ))
                ))
        )));
    }

    private static SurfaceRules.RuleSource createForestCaveRule() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.FOREST_CAVE),
                condition(BELOW_TOP, condition(STONE_CAVE_LEVEL, sequence(condition(SurfaceRules.ON_FLOOR, GRASS_BLOCK),
                        condition(SurfaceRules.DEEP_UNDER_FLOOR, DIRT), condition(SurfaceRules.ON_CEILING, DIRT)))));
    }


    /* ---------- Surface ---------*/
    private static SurfaceRules.RuleSource createMushroomShireRule() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.MUSHROOM_SHIRE),
                condition(ABOVE_WATER,
                        sequence(
                                condition(SurfaceRules.ON_FLOOR,
                                        sequence(
                                                condition(simplifiedSurfaceNoiseAbove(0.05), MYCELIUM),
                                                condition(simplifiedSurfaceNoiseAbove(-0.05),
                                                        sequence(
                                                                condition(ExtendedSurfaceRules.random(mushroomShireId, 0.5f), MYCELIUM),
                                                                condition(ExtendedSurfaceRules.random(mushroomShireId, 0.75f), ROOTED_DIRT),
                                                                COARSE_DIRT
                                                        )),
                                                MYCELIUM
                                        )),
                                condition(SurfaceRules.DEEP_UNDER_FLOOR,
                                        DIRT
                                )
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource createMysticMushroGroveRule() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.MYSTIC_MUSHROGROVE),
                condition(ABOVE_WATER,
                        sequence(
                                condition(SurfaceRules.ON_FLOOR,
                                        sequence(
                                                condition(vanillaPatchNoiseAbove(0.14), MYCELIUM),
                                                condition(vanillaPatchNoiseAbove(0.10),
                                                        sequence(
                                                                condition(ExtendedSurfaceRules.random(mushroomShireId, 0.5f), ROOTED_DIRT),
                                                                COARSE_DIRT
                                                        )),
                                                condition(vanillaPatchNoiseAbove(-0.10), GRASS_BLOCK),
                                                condition(vanillaPatchNoiseAbove(-0.14),
                                                        sequence(
                                                                condition(ExtendedSurfaceRules.random(mushroomShireId, 0.5f), ROOTED_DIRT),
                                                                COARSE_DIRT
                                                        )),
                                                MYCELIUM
                                        )),
                                condition(SurfaceRules.DEEP_UNDER_FLOOR,
                                        DIRT
                                )
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource createGoldenMycoShroomRule() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.GOLDEN_MYCOSHROOM),
                condition(ABOVE_WATER,
                        sequence(
                                condition(SurfaceRules.ON_FLOOR,
                                        sequence(
                                                condition(simplifiedSurfaceNoiseAbove(0.05), MYCELIUM),
                                                condition(simplifiedSurfaceNoiseAbove(-0.05),
                                                        sequence(
                                                                condition(ExtendedSurfaceRules.random(mushroomShireId, 0.5f), MYCELIUM),
                                                                condition(ExtendedSurfaceRules.random(mushroomShireId, 0.75f), ROOTED_DIRT),
                                                                COARSE_DIRT
                                                        )),
                                                MYCELIUM
                                        )),
                                condition(SurfaceRules.DEEP_UNDER_FLOOR,
                                        DIRT
                                )
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource createFastRockyCaveRules() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.ROCKY_CAVE),
                sequence(
                        condition(ExtendedSurfaceRules.random(rockyId, 0.24f), COBBLESTONE),
                        sequence(
                                condition(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(-25), VerticalAnchor.absolute(-20)), DEEPSLATE),
                                STONE
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource createRockyCaveRules() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.ROCKY_CAVE),
                sequence(
                        condition(ExtendedSurfaceRules.random(rockyId, 0.24f), COBBLESTONE),
                        condition(ExtendedSurfaceRules.random(rockyId, 0.34f), TUFF),
                        condition(ExtendedSurfaceRules.random(rockyId, 0.52f), ANDESITE),
                        condition(ExtendedSurfaceRules.random(rockyId, 0.90f), sequence(
                                condition(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(-25), VerticalAnchor.absolute(-20)), sequence(
                                        condition(ExtendedSurfaceRules.random(ResourceLocation.parse("deepslate"), 0.3f), DEEPSLATE),
                                        COBBLED_DEEPSLATE)),
                                STONE)),
                        MOSSY_COBBLESTONE
                )
        );
    }

    private static SurfaceRules.RuleSource createFastMossyCaveRules() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.MOSSY_CAVE),
                sequence(
                        condition(SurfaceRules.ON_FLOOR, sequence(
                                condition(patchNoiseAbove(0.1f),
                                        sequence(
                                                condition(ExtendedSurfaceRules.random(rockyId, 0.24f), COBBLESTONE),
                                                STONE)),

                                condition(patchNoiseAbove(-0.1f), MOSS))
                        ),
                        condition(ExtendedSurfaceRules.random(rockyId, 0.24f), COBBLESTONE),
                        STONE
                )
        );
    }

    private static SurfaceRules.RuleSource createMossyCaveRules() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.MOSSY_CAVE),
                sequence(
                        condition(SurfaceRules.ON_FLOOR, sequence(
                                condition(patchNoiseAbove(0.1f),
                                        sequence(
                                                condition(ExtendedSurfaceRules.random(rockyId, 0.24f), COBBLESTONE),
                                                condition(ExtendedSurfaceRules.random(rockyId, 0.62f), STONE),
                                                condition(ExtendedSurfaceRules.random(rockyId, 0.72f), TUFF),
                                                condition(ExtendedSurfaceRules.random(rockyId, 0.90f), ANDESITE),
                                                MOSSY_COBBLESTONE)),
                                condition(patchNoiseAbove(-0.1f),
                                        sequence(
                                                condition(ExtendedSurfaceRules.random(rockyId, 0.7f), MOSS),
                                                GRASS_BLOCK)

                                ))/*,
                                condition(ExtendedSurfaceRules.random(rockyId, 0.24f), COBBLESTONE),
                                condition(ExtendedSurfaceRules.random(rockyId, 0.62f), STONE),
                                condition(ExtendedSurfaceRules.random(rockyId, 0.72f), TUFF),
                                condition(ExtendedSurfaceRules.random(rockyId, 0.90f), ANDESITE),
                                MOSSY_COBBLESTONE)*/
                        ),
                        condition(ExtendedSurfaceRules.random(rockyId, 0.24f), COBBLESTONE),
                        condition(ExtendedSurfaceRules.random(rockyId, 0.62f), STONE),
                        condition(ExtendedSurfaceRules.random(rockyId, 0.72f), TUFF),
                        condition(ExtendedSurfaceRules.random(rockyId, 0.90f), ANDESITE),
                        MOSSY_COBBLESTONE
                )
        );
    }

    private static SurfaceRules.RuleSource createSakuraForestRule() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.SAKURA_FOREST),
                sequence(condition(IS_AT_OR_ABOVE_WATER, sequence(
                                condition(SurfaceRules.ON_FLOOR, sequence(
                                        condition(patchNoiseAbove(0.15d), GRASS_BLOCK),
                                        condition(patchNoiseAbove(-0.16d), sequence(
                                                condition(emmentalNoiseAbove(0.4d), COBBLESTONE),
                                                condition(emmentalNoiseAbove(-0.4d), STONE),
                                                MOSSY_COBBLESTONE)),
                                        GRASS_BLOCK)))),

                        condition(SurfaceRules.ON_FLOOR, sequence(
                                condition(patchNoiseAbove(0.15d), DIRT),
                                condition(patchNoiseAbove(-0.16d), sequence(
                                        condition(emmentalNoiseAbove(0.4d), COBBLESTONE),
                                        condition(emmentalNoiseAbove(-0.4d), STONE),
                                        MOSSY_COBBLESTONE)),
                                DIRT))

                ));
    }

    private static SurfaceRules.RuleSource createFastSakuraForestRule() {
        return condition(SurfaceRules.isBiome(ModOverworldBiomes.SAKURA_FOREST),
                sequence(
                        condition(IS_AT_OR_ABOVE_WATER, sequence(
                                condition(SurfaceRules.ON_FLOOR,
                                        sequence(
                                                condition(patchNoiseAbove(0.15d), GRASS_BLOCK),
                                                condition(patchNoiseAbove(-0.16d), STONE),
                                                GRASS_BLOCK))
                        )),
                        condition(SurfaceRules.ON_FLOOR, sequence(
                                condition(patchNoiseAbove(0.15d), DIRT),
                                condition(patchNoiseAbove(-0.16d), STONE),
                                DIRT
                        ))
                )
        );
    }


    /*--------------- Util ---------------*/
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.RuleSource makeStateRule(Supplier<Block> block) {
        return SurfaceRules.state(block.get().defaultBlockState());

    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double min) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, min / 8.5d, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource emmentalNoiseAbove(double min) {
        return SurfaceRules.noiseCondition(ModNoises.EMMENTAL_NOISE, min, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource patchNoiseAbove(double min) {
        return SurfaceRules.noiseCondition(ModNoises.PATCH_NOISE, min, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource vanillaPatchNoiseAbove(double min) {
        return SurfaceRules.noiseCondition(Noises.PATCH, min, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource intermediateNoiseAbove(double min) {
        return SurfaceRules.noiseCondition(ModNoises.INTERMEDIATE_NOISE, min, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource simplifiedSurfaceNoiseAbove(double min) {
        return SurfaceRules.noiseCondition(ModNoises.SIMPLIFIED_SURFACE, min, Double.MAX_VALUE);
    }

    //Methods for better readability
    private static SurfaceRules.RuleSource condition(SurfaceRules.ConditionSource condition, SurfaceRules.RuleSource rule) {
        return SurfaceRules.ifTrue(condition, rule);
    }

    private static SurfaceRules.RuleSource sequence(SurfaceRules.RuleSource... rules) {
        return SurfaceRules.sequence(rules);
    }
}
