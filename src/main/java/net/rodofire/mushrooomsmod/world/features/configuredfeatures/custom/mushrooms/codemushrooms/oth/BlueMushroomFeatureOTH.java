package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.easierworldcreator.blockdata.StructurePlacementRuleManager;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockListManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.blockdata.sorter.BlockSorter;
import net.rodofire.easierworldcreator.maths.FastMaths;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.shape.block.placer.animator.StructurePlaceAnimator;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.easierworldcreator.util.LongPosHelper;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.CustomBlueMushroom;

import java.util.*;

public class BlueMushroomFeatureOTH extends CustomBlueMushroom {
    public BlueMushroomFeatureOTH(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    /**
     * méthode pour générer un large cap de champignon bleu dans un cas animé. On calcule les coordonnées d'un cylindre auquel on ajoute du bruit et on place le cylindre
     */
    @Override
    public void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxlarge, BlockState state, int large, int height, BlockList blockLists, int yOffset) {
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.06f);

        SphereGen sphere = new SphereGen(pos, large);
        sphere.setRotator(
                new Rotator(pos,
                        0,
                        MathUtil.getRandomOpposite() * (random.nextBetween(0, 20) + random.nextBetween(0, 10)),
                        random.nextBetween(0, 360)
                )
        );
        sphere.setRadiusY(height);

        BlockLayer layer = new BlockLayer(new LayerPlacer(LayerPlacer.PlacingType.RANDOM),
                List.of(ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.getDefaultState()), List.of((short) 3, (short) 1)
        );
        StructurePlacementRuleManager tuler = new StructurePlacementRuleManager();
        tuler.addTagKey(BlockTags.FLOWERS);
        layer.setRuler(tuler);

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE,
                new BlockLayerManager(layer)
        );


        Map<ChunkPos, LongOpenHashSet> posList = sphere.getShapeCoordinates();


        ///on ajoute du bruit
        //éviter de calculer trop de buit
        Long2FloatOpenHashMap noiseMap = new Long2FloatOpenHashMap(posList.size());
        //les nouvelles positions
        Map<ChunkPos, LongOpenHashSet> newPos = new HashMap<>();
        for (Map.Entry<ChunkPos, LongOpenHashSet> set : posList.entrySet()) {
            LongOpenHashSet posSet = new LongOpenHashSet();
            for (long pos1 : set.getValue()) {
                long noise2d = (((long) LongPosHelper.decodeX(pos1) & 0xFFFF) << 32) | (LongPosHelper.decodeZ(pos1) & 0xFFFF);
                noiseMap.computeIfAbsent(noise2d, (value) -> noise.GetNoise(value >> 32, value & 0xFFFF));
                float a = noiseMap.get(noise2d);
                posSet.add(LongPosHelper.up(pos1, (int) (3 * a)));
            }
            if (!posSet.isEmpty())
                newPos.put(set.getKey(), posSet);
        }
        ///on initialise l'animator
        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT);
        sorter.setCenterPoint(pos.down(yOffset));

        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, sorter, StructurePlaceAnimator.AnimatorTime.LINEAR_TICKS);
        animator.setBounds(new Pair<>(10, 130));

        ///on collecte la blockList du truenk et du cap, et on place
        BlockListManager manager = new BlockListManager();
        manager.put(blockLists);

        manager.put(layerManager.get(newPos));
        animator.place(manager);
    }

    @Override
    public BlockList generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.5f);

        List<BlockPos> posList = new ArrayList<>();

        float c3 = (float) 360 / height;
        for (float j = 1; j <= maxlarge; ++j) {
            float c1 = (j + (j * minlarge / maxlarge)) / 2;
            float c2 = (j - (j * minlarge / maxlarge)) / 2;

            for (int u = 0; u <= height; u++) {

                float a = c1 + c2 * FastMaths.getFastCos(u * c3);

                for (float v = 0; v <= 360; v += 45 / j) {

                    int x = (int) (a * FastMaths.getFastCos(v));
                    int z = (int) (a * FastMaths.getFastSin(v));
                    mutable.set(pos, x, u, z);
                    float t = 4 * noise.GetNoise(mutable.getX(), mutable.getZ());
                    if (u == 0) {
                        for (int i = 0; i < Math.abs(t) * 4 + 3; i++) {
                            posList.add(mutable.down(i));
                        }
                    }
                    if (t < 1) {
                        posList.add(mutable.down());
                    } else {
                        posList.add(mutable);
                        if (t > 1) {
                            posList.add(mutable.up());
                        }
                    }

                }
            }
        }
        return new BlockList(trunk, posList);
    }
}
