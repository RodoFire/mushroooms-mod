package fr.rodofire.mushrooomsmod.world.features.placedfeatures;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.custom.SolidStatePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final PlacementModifier DEEPSLATE_LEVEL = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(8));
    public static final PlacementModifier STONE_LEVEL = HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.belowTop(-3));
    public static final PlacementModifier AIR_LEVEL = HeightRangePlacement.uniform(VerticalAnchor.belowTop(-3), VerticalAnchor.belowTop(3));
    public static final PlacementModifier CAVE_LEVEL = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.belowTop(-3));
    public static final PlacementModifier SOLID_STATE_CAVE = new SolidStatePlacementModifier();

    private static final PlacementModifier NOT_IN_SURFACE_WATER_MODIFIER = SurfaceWaterDepthFilter.forMaxDepth(0);

    private static ImmutableList.Builder<PlacementModifier> undergroundStoneLevelTreeModifiersBuilder(PlacementModifier countModifier) {
        return ((ImmutableList.Builder) ImmutableList.builder().add(countModifier)).add(InSquarePlacement.spread()).add(NOT_IN_SURFACE_WATER_MODIFIER).add(STONE_LEVEL).add(BiomeFilter.biome());
    }

    private static ImmutableList.Builder<PlacementModifier> undergroundDeepslateLevelTreeModifiersBuilder(PlacementModifier countModifier) {
        return ((ImmutableList.Builder) ImmutableList.builder().add(countModifier)).add(InSquarePlacement.spread()).add(NOT_IN_SURFACE_WATER_MODIFIER).add(DEEPSLATE_LEVEL).add(BiomeFilter.biome());
    }

    public static List<PlacementModifier> undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacementModifier modifier, Block block) {
        return (undergroundStoneLevelTreeModifiersBuilder(modifier).add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO)))).build();
    }

    public static List<PlacementModifier> undergroundDeepslateLevelTreeModifiersWithWouldSurvive(PlacementModifier modifier, Block block) {
        return (undergroundDeepslateLevelTreeModifiersBuilder(modifier)).add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO))).build();
    }
}
