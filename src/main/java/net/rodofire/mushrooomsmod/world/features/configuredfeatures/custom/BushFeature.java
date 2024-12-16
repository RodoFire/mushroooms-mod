package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.structure.NbtPlacer;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class BushFeature extends Feature<DefaultFeatureConfig> {

    public BushFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    //Simple Code to create a bush

    public boolean canGenerate(StructureWorldAccess world, BlockPos pos, int large, int height) {
        for (int i = 0; i < large; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < large; k++) {
                    BlockState blockState = world.getBlockState(pos.add(i, j, k));
                    if (blockState.isAir() || blockState.isOf(Blocks.SHORT_GRASS) || blockState.isOf(Blocks.TALL_GRASS))
                        continue;
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        if (world.isClient()) return false;
        BlockPos pos = context.getOrigin();
        int capnumber = Random.create().nextBetween(1, 4);
        if (!canGenerate(world, pos, 5, 3)) return false;
        NbtPlacer bush = new NbtPlacer(world, Identifier.of(MushrooomsMod.MOD_ID, "bush/bush_" + capnumber));
        bush.place(pos);
        BlockState blockState = Blocks.OAK_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true);
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (world.getBlockState(pos.add(i, j, k)).isOf(Blocks.BEDROCK))
                        world.setBlockState(pos.add(i, j, k), blockState, 1);
                    int a = 1;
                    boolean bl = false;
                    while (world.getBlockState(pos.add(i, j - a, k)).isAir() || bl) {
                        world.setBlockState(pos.add(i, j - a, k), blockState, 1);
                        ++a;
                        if (a == 4) bl = true;
                    }
                }
            }
        }
        return true;
    }

}
