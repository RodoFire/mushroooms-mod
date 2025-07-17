package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

public abstract class CustomRedHugeMushroom extends Feature<ModMushroomFeatureConfig> {
    public CustomRedHugeMushroom(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ModMushroomFeatureConfig> context) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        BlockPos blockPos = context.origin();
        WorldGenLevel structureWorldAccess = context.level();
        RandomSource random = context.random();

        int large;
        int height = random.nextIntBetweenInclusive(5, 9);

        ModMushroomFeatureConfig modMushroomFeatureConfig = context.config();

        if (height < 7) large = random.nextIntBetweenInclusive(1, 2);
        else large = random.nextIntBetweenInclusive(2, 3);

        Integer[] coordinates = trunkPlace(blockPos, large, mutable, structureWorldAccess, modMushroomFeatureConfig, random);

        if (coordinates.length == 1) return false;

        capPlacer(blockPos, large, mutable, structureWorldAccess, modMushroomFeatureConfig, coordinates, random);
        return true;
    }

    protected abstract Integer[] trunkPlace(BlockPos start, int large, BlockPos.MutableBlockPos mutable, LevelAccessor world, ModMushroomFeatureConfig config, RandomSource random);

    protected abstract boolean capPlacer(BlockPos start, int large, BlockPos.MutableBlockPos mutable, LevelAccessor world, ModMushroomFeatureConfig config, Integer[] coordinates, RandomSource random);
}
