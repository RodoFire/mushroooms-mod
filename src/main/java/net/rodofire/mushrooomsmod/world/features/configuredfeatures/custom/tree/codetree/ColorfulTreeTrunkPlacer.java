package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.rodofire.easierworldcreator.util.MathUtil;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;

public class ColorfulTreeTrunkPlacer extends TrunkPlacer {
    public static final Codec<ColorfulTreeTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance -> fillTrunkPlacerFields(objectInstance).apply(objectInstance, ColorfulTreeTrunkPlacer::new));

    public ColorfulTreeTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.COLORFUL_TREE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        BlockState state = config.trunkProvider.get(random, startPos);
        BlockPos.Mutable pos = new BlockPos.Mutable();
        pos.set(startPos);


        for (int i = 0; i < height; ++i) {
            if (MathUtil.getRandomBoolean(0.4f)) {
                pos.move(Random.create().nextBetween(-1, 1), 0, Random.create().nextBetween(-1, 1));
                getAndSetState(world, replacer, random, pos.up(i - 1), config);
            }
            getAndSetState(world, replacer, random, pos.up(i), config);
        }
        return List.of(new FoliagePlacer.TreeNode(pos.up(height), 0, false));
    }
}
