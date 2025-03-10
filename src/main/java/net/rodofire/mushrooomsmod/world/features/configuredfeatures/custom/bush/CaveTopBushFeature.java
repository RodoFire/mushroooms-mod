package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CaveTopBushFeature extends Feature<DefaultFeatureConfig> {
    public CaveTopBushFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos mutablePos = context.getOrigin();
        BlockPos basePos = context.getOrigin();
        Random random = context.getRandom();

        boolean canPlace = false;
        for (int i = 0; i < 30; i++) {
            if (world.getBlockState(mutablePos.up()).isOpaqueFullCube() && world.getBlockState(mutablePos).isAir()) {
                canPlace = true;
                break;
            }
            mutablePos = basePos.add(random.nextBetween(-9, 9), random.nextBetween(-15, 15), random.nextBetween(-9, 9));
        }
        if (!canPlace)
            return false;

        BlockState[] blocks = new BlockState[]{
                Blocks.AZALEA_LEAVES.getDefaultState().with(Properties.PERSISTENT, true),
                Blocks.FLOWERING_AZALEA_LEAVES.getDefaultState().with(Properties.PERSISTENT, true),
                Blocks.JUNGLE_LEAVES.getDefaultState().with(Properties.PERSISTENT, true),
                Blocks.OAK_LEAVES.getDefaultState().with(Properties.PERSISTENT, true)
        };

        blocks = Arrays.stream(blocks).parallel().filter(block -> random.nextFloat() < 0.6f).toArray(BlockState[]::new);
        if (blocks.length == 0) {
            blocks = new BlockState[]{
                    Blocks.JUNGLE_LEAVES.getDefaultState().with(Properties.PERSISTENT, true)
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
        int height = random.nextBetween(5, 15);
        int maxDownHeight = height;
        for (int i = 0; i < height; ++i) {
            BlockPos below = mutablePos.down();

            // 8% de chance de se décaler latéralement / de se décaller si le block en dessous n'est pas un bloc d'air.
            if (!world.getBlockState(below).isAir() || random.nextFloat() < 0.1f) {
                maxDownHeight = i;
                shuffleDirections(directions, random);

                boolean moved = false;
                for (Vec3i direction : directions) {
                    BlockPos offsetPos = below.add(direction);
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
            world.setBlockState(below, blocks[blocks.length == 1 ? 0 : random.nextInt(blocks.length - 1)], 3);
            mutablePos = below; // Continuer la descente
        }
        Map<BlockPos, Integer> sideHeights = new HashMap<>();

        for (int i = 1; i <= random.nextBetween(2, 3); i++) {
            for (int x = -i; x <= i; x++) {
                for (int z = -i; z <= i; z++) {
                    if (MathUtil.absDistance(x, z) == i) {
                        if (i == 1) {
                            sideHeights.put(currentPos.add(x, 0, z), maxDownHeight <= 1 ? 0 : random.nextBetween((maxDownHeight - 1) / 3, maxDownHeight - 1));
                        } else {
                            int maxHeight;
                            if (x != 0 && z != 0) {
                                maxHeight = Math.min(
                                        sideHeights.get(currentPos.add(x < 0 ? x + 1 : x - 1, 0, z)),
                                        sideHeights.get(currentPos.add(x, 0, z < 0 ? z + 1 : z - 1))
                                ) - 1;
                            } else if (x != 0) {
                                maxHeight = sideHeights.get(currentPos.add(x < 0 ? x + 1 : x - 1, 0, 0));
                            } else {
                                maxHeight = sideHeights.get(currentPos.add(0, 0, z < 0 ? z + 1 : z - 1));
                            }
                            sideHeights.put(currentPos.add(x, 0, z), random.nextBetween(0, maxHeight <= 1 ? 0 : maxHeight - 1));
                        }
                    }
                }
            }
        }

        for (Map.Entry<BlockPos, Integer> entry : sideHeights.entrySet()) {
            boolean shouldPlace = entry.getValue() <= 0;
            if (!shouldPlace) {
                for (int i = 0; i < entry.getValue(); i++) {
                    BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), entry.getKey().down(i), blocks[blocks.length == 1 ? 0 : random.nextInt(blocks.length - 1)]);
                }
                int randomHeight = random.nextBetween(5, 10);

                //in the ase where the top goes up, to avoid having a weird looking bush, we get add some on top
                for (int i = 0; i < randomHeight && !shouldPlace; i++) {
                    shouldPlace = !BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), entry.getKey().up(i), blocks[blocks.length == 1 ? 0 : random.nextInt(blocks.length - 1)]);
                }
            }

        }


        return true;
    }

    void shuffleDirections(Vec3i[] directions, Random random) {
        for (int i = directions.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Vec3i temp = directions[i];
            directions[i] = directions[j];
            directions[j] = temp;
        }
    }
}
