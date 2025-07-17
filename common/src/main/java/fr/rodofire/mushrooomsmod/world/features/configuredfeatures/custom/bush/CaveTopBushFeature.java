package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CaveTopBushFeature extends Feature<NoneFeatureConfiguration> {
    public CaveTopBushFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos mutablePos = context.origin();
        BlockPos basePos = context.origin();
        RandomSource random = context.random();

        boolean canPlace = false;
        for (int i = 0; i < 30; i++) {
            if (world.getBlockState(mutablePos.above()).isSolidRender(world, mutablePos.above()) && world.getBlockState(mutablePos).isAir()) {
                canPlace = true;
                break;
            }
            mutablePos = basePos.offset(random.nextIntBetweenInclusive(-9, 9), random.nextIntBetweenInclusive(-15, 15), random.nextIntBetweenInclusive(-9, 9));
        }
        if (!canPlace)
            return false;

        BlockState[] blocks = new BlockState[]{
                Blocks.AZALEA_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true),
                Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true),
                Blocks.JUNGLE_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true),
                Blocks.OAK_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true)
        };

        blocks = Arrays.stream(blocks).parallel().filter(block -> random.nextFloat() < 0.6f).toArray(BlockState[]::new);
        if (blocks.length == 0) {
            blocks = new BlockState[]{
                    Blocks.JUNGLE_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true)
            };
        }
        Vec3i[] directions = new Vec3i[]{
                new Vec3i(1, 0, 0),
                new Vec3i(1, 0, 1),
                new Vec3i(0, 0, 1),
                new Vec3i(-1, 0, 1),
                new Vec3i(-1, 0, 0),
                new Vec3i(-1, 0, -1),
                new Vec3i(0, 0, -1)
        };
        BlockPos currentPos = mutablePos;
        int height = random.nextIntBetweenInclusive(5, 15);
        int maxDownHeight = height;
        for (int i = 0; i < height; ++i) {
            BlockPos below = mutablePos.below();

            // 8% de chance de se décaler latéralement / de se décaller si le block en dessous n'est pas un bloc d'air.
            if (!world.getBlockState(below).isAir() || random.nextFloat() < 0.1f) {
                maxDownHeight = i;
                shuffleDirections(directions, random);

                boolean moved = false;
                for (Vec3i direction : directions) {
                    BlockPos offsetPos = below.offset(direction);
                    if (world.getBlockState(offsetPos).isAir()) {
                        below = offsetPos; // Nouvelle position
                        moved = true;
                        break;
                    }
                }
                if (!moved) {
                    break; // Si aucune direction n'était disponible, on arrête
                }
            }

            // Placer la liane
            world.setBlock(below, blocks[blocks.length == 1 ? 0 : random.nextInt(blocks.length - 1)], 3);
            mutablePos = below; // Continuer la descente
        }
        Map<BlockPos, Integer> sideHeights = new HashMap<>();

        for (int i = 1; i <= random.nextIntBetweenInclusive(2, 3); i++) {
            for (int x = -i; x <= i; x++) {
                for (int z = -i; z <= i; z++) {
                    if (MathUtil.absDistance(x, z) == i) {
                        if (i == 1) {
                            sideHeights.put(currentPos.offset(x, 0, z), maxDownHeight <= 1 ? 0 : random.nextIntBetweenInclusive((maxDownHeight - 1) / 3, maxDownHeight - 1));
                        } else {
                            int maxHeight;
                            if (x != 0 && z != 0) {
                                maxHeight = Math.min(
                                        sideHeights.get(currentPos.offset(x < 0 ? x + 1 : x - 1, 0, z)),
                                        sideHeights.get(currentPos.offset(x, 0, z < 0 ? z + 1 : z - 1))
                                ) - 1;
                            } else if (x != 0) {
                                maxHeight = sideHeights.get(currentPos.offset(x < 0 ? x + 1 : x - 1, 0, 0));
                            } else {
                                maxHeight = sideHeights.get(currentPos.offset(0, 0, z < 0 ? z + 1 : z - 1));
                            }
                            sideHeights.put(currentPos.offset(x, 0, z), random.nextIntBetweenInclusive(0, maxHeight <= 1 ? 0 : maxHeight - 1));
                        }
                    }
                }
            }
        }

        for (Map.Entry<BlockPos, Integer> entry : sideHeights.entrySet()) {
            boolean shouldPlace = entry.getValue() <= 0;
            if (!shouldPlace) {
                for (int i = 0; i < entry.getValue(); i++) {
                    BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), entry.getKey().below(i), blocks[blocks.length == 1 ? 0 : random.nextInt(blocks.length - 1)]);
                }
                int randomHeight = random.nextIntBetweenInclusive(5, 10);

                //in the ase where the top goes up, to avoid having a weird looking bush, we get add some on top
                for (int i = 0; i < randomHeight && !shouldPlace; i++) {
                    shouldPlace = !BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), entry.getKey().above(i), blocks[blocks.length == 1 ? 0 : random.nextInt(blocks.length - 1)]);
                }
            }

        }


        return true;
    }

    void shuffleDirections(Vec3i[] directions, RandomSource random) {
        for (int i = directions.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Vec3i temp = directions[i];
            directions[i] = directions[j];
            directions[j] = temp;
        }
    }
}
