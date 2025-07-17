package fr.rodofire.mushrooomsmod.world.features.placedfeatures.custom;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.placementmodifier.ModPlacementModifierType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.stream.Stream;

public class SolidStatePlacementModifier extends PlacementModifier {
    public static final SolidStatePlacementModifier INSTANCE = new SolidStatePlacementModifier();

    // Codec "Empty"
    public static final MapCodec<SolidStatePlacementModifier> CODEC = MapCodec.unit(() -> INSTANCE);


    public SolidStatePlacementModifier() {
    }

    @Override
    public Stream<BlockPos> getPositions(PlacementContext context, RandomSource random, BlockPos pos) {
        WorldGenLevel world = context.getLevel();
        boolean isAir = BlockPlaceUtil.verifyBlock(world, pos);
        if (!isAir)
            return Stream.of();

        BlockPos below = pos.above();
        BlockPos above = pos.below();

        if(world.getBlockState(below).isSolidRender(world, below) || world.getBlockState(above).isSolidRender(world, above))
            return Stream.of(pos);

        return Stream.of();
    }

    @Override
    public PlacementModifierType<?> type() {
        return ModPlacementModifierType.SOLID_STATE;
    }
}
