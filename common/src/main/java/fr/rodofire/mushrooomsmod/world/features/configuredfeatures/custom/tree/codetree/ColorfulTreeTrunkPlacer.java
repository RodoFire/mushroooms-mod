package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.rodofire.ewc.maths.MathUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;

public class ColorfulTreeTrunkPlacer extends TrunkPlacer {
    public static final ColorfulTreeTrunkPlacer INSTANCE = new ColorfulTreeTrunkPlacer(6, 6, 6);
    public static final MapCodec<ColorfulTreeTrunkPlacer> CODEC = MapCodec.unit(() -> INSTANCE);

    public ColorfulTreeTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.COLORFUL_TREE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {
        BlockState state = config.trunkProvider.getState(random, startPos);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        pos.set(startPos);


        for (int i = 0; i < height; ++i) {
            if (MathUtil.getRandomBoolean(random, 0.4f)) {
                pos.move(random.nextIntBetweenInclusive(-1, 1), 0, random.nextIntBetweenInclusive(-1, 1));
                placeLog(world, replacer, random, pos.above(i - 1), config);
            }
            placeLog(world, replacer, random, pos.above(i), config);
        }
        return List.of(new FoliagePlacer.FoliageAttachment(pos.above(height), 0, false));
    }
}
