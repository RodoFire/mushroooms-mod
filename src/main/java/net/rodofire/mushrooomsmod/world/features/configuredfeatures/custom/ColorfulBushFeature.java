package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import me.emafire003.dev.structureplacerapi.StructurePlacerAPI;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.util.ModTags;

public class ColorfulBushFeature extends Feature<DefaultFeatureConfig> {
    public ColorfulBushFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(StructureWorldAccess world, BlockPos pos, int large, int height, BlockRotation rotation) {
        int a = 0;
        int b = 0;
        if (rotation == BlockRotation.CLOCKWISE_180 || rotation == BlockRotation.CLOCKWISE_90) a = -large;
        if (rotation == BlockRotation.COUNTERCLOCKWISE_90 || rotation == BlockRotation.CLOCKWISE_180) b = -large;
        for (int i = a; i < large - a; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = b; k < large - b; k++) {
                    BlockState blockState = world.getBlockState(pos.add(i, j, k));
                    if (j == 0 && world.getBlockState(pos.add(i, -1, k)) == Blocks.WATER.getDefaultState())
                        return false;
                    if (blockState.isAir() || blockState.isOf(Blocks.GRASS) || blockState.isOf(Blocks.TALL_GRASS))
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
        BlockRotation rotation = getRanodomBlockRotation();

        if (!canGenerate(world, pos, 3, 2, rotation)) return false;
        StructurePlacerAPI bush = new StructurePlacerAPI(world, new Identifier(MushrooomsMod.MOD_ID, "bush/bush_" + capnumber), pos, rotation);
        bush.loadStructure();
        BlockState blockState = getLeaveBlock().with(LeavesBlock.PERSISTENT, true);
        int a = 0;
        int b = 0;
        if (rotation == BlockRotation.CLOCKWISE_180 || rotation == BlockRotation.COUNTERCLOCKWISE_90) b = -5;
        if (rotation == BlockRotation.CLOCKWISE_90 || rotation == BlockRotation.CLOCKWISE_180) a = -5;
        for (int i = a; i < 5 - a; ++i) {
            for (int j = 0; j < 3; j++) {
                for (int k = b; k < 5 - b; k++) {
                    if (world.getBlockState(pos.add(i, j, k)).isOf(Blocks.BEDROCK)) {
                        world.setBlockState(pos.add(i, j, k), blockState, 1);
                        boolean bl = true;
                        int v = 1;
                        BlockState blockState2 = world.getBlockState(pos.add(i, j - v, k));
                        while ((blockState2.isAir() || blockState2.isIn(BlockTags.FLOWERS) || blockState2.isIn(ModTags.Blocks.GRASS)) && bl) {
                            world.setBlockState(pos.add(i, j - v, k), blockState, 1);
                            ++v;
                            if (v == 4 - Math.abs(2 - k) || v == 4 - Math.abs(2 - i)) bl = false;
                            blockState2 = world.getBlockState(pos.add(i, j - v, k));
                        }
                    }
                }
            }
        }
        return true;
    }

    private BlockState getLeaveBlock() {
        int random = Random.create().nextBetween(0, 6);
        return switch (random) {
            case 0 -> ModBlocks.BLUE_COLORFUL_LEAVES.getDefaultState();
            case 1 -> ModBlocks.RED_COLORFUL_LEAVES.getDefaultState();
            case 2 -> ModBlocks.YELLOW_COLORFUL_LEAVES.getDefaultState();
            case 3 -> ModBlocks.GREEN_COLORFUL_LEAVES.getDefaultState();
            case 4 -> ModBlocks.ORANGE_COLORFUL_LEAVES.getDefaultState();
            case 5 -> ModBlocks.PURPLE_COLORFUL_LEAVES.getDefaultState();
            default -> ModBlocks.PINK_COLORFUL_LEAVES.getDefaultState();
        };
    }

    public static BlockRotation getRanodomBlockRotation() {
        int random = Random.create().nextBetween(0, 3);
        return switch (random) {
            case 1 -> BlockRotation.CLOCKWISE_90;
            case 2 -> BlockRotation.CLOCKWISE_180;
            case 3 -> BlockRotation.COUNTERCLOCKWISE_90;
            default -> BlockRotation.NONE;
        };
    }

}
