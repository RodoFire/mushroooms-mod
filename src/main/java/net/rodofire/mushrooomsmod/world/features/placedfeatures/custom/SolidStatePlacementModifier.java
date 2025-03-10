package net.rodofire.mushrooomsmod.world.features.placedfeatures.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.FeaturePlacementContext;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.placementmodifier.ModPlacementModifierType;

import java.util.stream.Stream;

public class SolidStatePlacementModifier extends PlacementModifier {
    public static final SolidStatePlacementModifier INSTANCE = new SolidStatePlacementModifier();

    // Codec "Empty"
    public static final MapCodec<SolidStatePlacementModifier> CODEC = MapCodec.unit(() -> INSTANCE);


    public SolidStatePlacementModifier() {
    }

    @Override
    public Stream<BlockPos> getPositions(FeaturePlacementContext context, Random random, BlockPos pos) {
        StructureWorldAccess world = context.getWorld();
        boolean isAir = BlockPlaceUtil.verifyBlock(world, pos);
        if (!isAir)
            return Stream.of();

        BlockPos below = pos.up();
        BlockPos above = pos.down();

        if(world.getBlockState(below).isOpaqueFullCube() || world.getBlockState(above).isOpaqueFullCube())
            return Stream.of(pos);

        return Stream.of();
    }

    @Override
    public PlacementModifierType<?> getType() {
        return ModPlacementModifierType.SOLID_STATE;
    }
}
