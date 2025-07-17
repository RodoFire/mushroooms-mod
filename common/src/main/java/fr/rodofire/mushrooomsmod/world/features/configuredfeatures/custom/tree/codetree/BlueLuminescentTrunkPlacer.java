package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BlueLuminescentTrunkPlacer extends TrunkPlacer {
    public static final BlueLuminescentTrunkPlacer INSTANCE = new BlueLuminescentTrunkPlacer(6,6,6);
    public static final MapCodec<BlueLuminescentTrunkPlacer> CODEC = MapCodec.unit(() -> INSTANCE);
    public BlueLuminescentTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.BLUE_LUMINESCENT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {
        int realheight =random.nextIntBetweenInclusive(heightRandA, heightRandA + 4);
        List<FoliagePlacer.FoliageAttachment> list = new ArrayList<FoliagePlacer.FoliageAttachment>();

        generateColumn(world, replacer, random, startPos, config, realheight, 0);
        for (int i = 0; i <= realheight; ++i) {
            if (RandomSource.create().nextIntBetweenInclusive(0, realheight / 4) == 0) {
                list.add(generateColumn(world, replacer, random, startPos.offset(RandomSource.create().nextIntBetweenInclusive(-1, 1), 0,random.nextIntBetweenInclusive(-1, 1)), config, realheight, i));
            }
        }
        for (int i = 0; i <=random.nextIntBetweenInclusive(1, 4); ++i) {
            placeLog(world, replacer, random, startPos.offset(RandomSource.create().nextIntBetweenInclusive(-3, 3), realheight +random.nextIntBetweenInclusive(0, 2),random.nextIntBetweenInclusive(-3, 3)), config);
        }
        return list;
    }

    private FoliagePlacer.FoliageAttachment generateColumn(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, BlockPos startPos, TreeConfiguration config, int realheight, int start) {
        for (int i = start; i <= realheight; ++i) {
            placeLog(world, replacer, random, startPos.above(i), config);
        }
        return new FoliagePlacer.FoliageAttachment(startPos.above(realheight), 0, false);
    }


}
