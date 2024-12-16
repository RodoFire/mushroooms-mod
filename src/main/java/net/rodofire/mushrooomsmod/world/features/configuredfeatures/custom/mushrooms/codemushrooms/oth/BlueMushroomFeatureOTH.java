package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockListUtil;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.DefaultBlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.comparator.DefaultBlockListComparator;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.blockdata.sorter.BlockSorter;
import net.rodofire.easierworldcreator.maths.FastMaths;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.placer.blocks.animator.StructurePlaceAnimator;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapePlaceType;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
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
    public void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxlarge, BlockState state, int large, int height, DefaultBlockList blockLists, int yOffset) {
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.06f);

        SphereGen sphere = new SphereGen(world, pos, AbstractBlockShapeBase.PlaceMoment.ANIMATED_OTHER, large);
        sphere.setRadiusY(height);
        sphere.setZRotation(MathUtil.getRandomOpposite() * (random.nextBetween(0, 20) + random.nextBetween(0, 10)));
        sphere.setSecondYRotation(random.nextBetween(0, 360));
        BlockLayer layer = new BlockLayer(List.of(ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState(),ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.getDefaultState()), List.of((short)3,(short)1));
        sphere.setBlockLayer(new BlockLayerComparator(layer));
        sphere.setLayerPlace(AbstractBlockShapePlaceType.LayerPlace.RANDOM);
        List<Set<BlockPos>> posList = sphere.getBlockPos();

        ///on ajoute du bruit
        //éviter de calculer trop de buit
        Map<Pair<Integer, Integer>, Float> offset = new HashMap<>();
        //les nouvelles positions
        List<Set<BlockPos>> newPosList = new ArrayList<>();
        int index = 0;
        for (Set<BlockPos> set : posList) {
            newPosList.add(new HashSet<>());
            for (BlockPos pos1 : set) {
                Pair<Integer, Integer> plan = new Pair<>(pos1.getX(), pos1.getZ());
                offset.computeIfAbsent(plan, k -> noise.GetNoise(pos1.getX(), pos1.getZ()));
                float a = offset.get(plan);
                newPosList.get(index).add(pos1.add(new BlockPos(0, (int) (3 * a), 0)));
            }
            index++;
        }
        ///on initialise l'animator
        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT);
        sorter.setCenterPoint(pos.down(yOffset));

        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, sorter, StructurePlaceAnimator.AnimatorTime.LINEAR_TICKS);
        animator.setBounds(new Pair<>(10, 130));

        ///on collecte la blockList du truenk et du cap, et on place
        DefaultBlockListComparator comparator = new DefaultBlockListComparator();
        comparator.put(blockLists);
        comparator.put(BlockListUtil.unDivideBlockList(sphere.getBlockListWithVerification(sphere.getBlockPos())));
        animator.placeFromBlockList(comparator);
    }

    @Override
    public DefaultBlockList generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
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
                        for (int i = 0; i < t * 4 + 1; i++) {
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
        return new DefaultBlockList(posList, trunk);
    }
}
