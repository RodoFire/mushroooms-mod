package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.structure.NbtPlacer;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public class BushFeature extends Feature<NoneFeatureConfiguration> {

    public BushFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    //Simple Code to create a bush

    public boolean canGenerate(WorldGenLevel world, BlockPos pos, int large, int height) {
        for (int i = 0; i < large; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < large; k++) {
                    BlockState blockState = world.getBlockState(pos.offset(i, j, k));
                    if (blockState.isAir() || blockState.is(Blocks.SHORT_GRASS) || blockState.is(Blocks.TALL_GRASS))
                        continue;
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        if (world.isClientSide()) return false;
        BlockPos pos = context.origin();
        int capnumber = RandomSource.create().nextIntBetweenInclusive(1, 4);
        if (!canGenerate(world, pos, 5, 3)) return false;
        NbtPlacer bush = new NbtPlacer(world, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "bush/bush_" + capnumber));
        bush.place(pos);
        BlockState blockState = Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true);
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (world.getBlockState(pos.offset(i, j, k)).is(Blocks.BEDROCK))
                        world.setBlock(pos.offset(i, j, k), blockState, 1);
                    int a = 1;
                    boolean bl = false;
                    while (world.getBlockState(pos.offset(i, j - a, k)).isAir() || bl) {
                        world.setBlock(pos.offset(i, j - a, k), blockState, 1);
                        ++a;
                        if (a == 4) bl = true;
                    }
                }
            }
        }
        return true;
    }

}
