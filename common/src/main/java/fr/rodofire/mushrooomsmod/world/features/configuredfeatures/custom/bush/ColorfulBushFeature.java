package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.structure.NbtPlacer;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.util.ModTags;

public class ColorfulBushFeature extends Feature<NoneFeatureConfiguration> {
    public ColorfulBushFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(WorldGenLevel world, BlockPos pos, int large, int height, Rotation rotation) {
        int a = 0;
        int b = 0;
        if (rotation == Rotation.CLOCKWISE_180 || rotation == Rotation.CLOCKWISE_90) a = -large;
        if (rotation == Rotation.COUNTERCLOCKWISE_90 || rotation == Rotation.CLOCKWISE_180) b = -large;
        for (int i = a; i < large - a; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = b; k < large - b; k++) {
                    BlockState blockState = world.getBlockState(pos.offset(i, j, k));
                    if (j == 0 && world.getBlockState(pos.offset(i, -1, k)) == Blocks.WATER.defaultBlockState())
                        return false;
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
        Rotation rotation = getRanodomBlockRotation();

        if (!canGenerate(world, pos, 3, 2, rotation)) return false;
        NbtPlacer bush = new NbtPlacer(world, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "bush/bush_" + capnumber));
        bush.place(pos);
        BlockState blockState = getLeaveBlock().setValue(LeavesBlock.PERSISTENT, true);
        int a = 0;
        int b = 0;
        if (rotation == Rotation.CLOCKWISE_180 || rotation == Rotation.COUNTERCLOCKWISE_90) b = -5;
        if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.CLOCKWISE_180) a = -5;
        for (int i = a; i < 5 - a; ++i) {
            for (int j = 0; j < 3; j++) {
                for (int k = b; k < 5 - b; k++) {
                    if (world.getBlockState(pos.offset(i, j, k)).is(Blocks.BEDROCK)) {
                        world.setBlock(pos.offset(i, j, k), blockState, 1);
                        boolean bl = true;
                        int v = 1;
                        BlockState blockState2 = world.getBlockState(pos.offset(i, j - v, k));
                        while ((blockState2.isAir() || blockState2.is(BlockTags.FLOWERS) || blockState2.is(ModTags.Blocks.GRASS)) && bl) {
                            world.setBlock(pos.offset(i, j - v, k), blockState, 1);
                            ++v;
                            if (v == 4 - Math.abs(2 - k) || v == 4 - Math.abs(2 - i)) bl = false;
                            blockState2 = world.getBlockState(pos.offset(i, j - v, k));
                        }
                    }
                }
            }
        }
        return true;
    }

    private BlockState getLeaveBlock() {
        int random = RandomSource.create().nextIntBetweenInclusive(0, 6);
        return switch (random) {
            case 0 -> ModBlocks.BLUE_COLORFUL_LEAVES.get().defaultBlockState();
            case 1 -> ModBlocks.RED_COLORFUL_LEAVES.get().defaultBlockState();
            case 2 -> ModBlocks.YELLOW_COLORFUL_LEAVES.get().defaultBlockState();
            case 3 -> ModBlocks.GREEN_COLORFUL_LEAVES.get().defaultBlockState();
            case 4 -> ModBlocks.ORANGE_COLORFUL_LEAVES.get().defaultBlockState();
            case 5 -> ModBlocks.PURPLE_COLORFUL_LEAVES.get().defaultBlockState();
            default -> ModBlocks.PINK_COLORFUL_LEAVES.get().defaultBlockState();
        };
    }

    public static Rotation getRanodomBlockRotation() {
        int random = RandomSource.create().nextIntBetweenInclusive(0, 3);
        return switch (random) {
            case 1 -> Rotation.CLOCKWISE_90;
            case 2 -> Rotation.CLOCKWISE_180;
            case 3 -> Rotation.COUNTERCLOCKWISE_90;
            default -> Rotation.NONE;
        };
    }

}
