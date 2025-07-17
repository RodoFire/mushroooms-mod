package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.structure.NbtPlacer;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.MushrooomsMod;


public class CustomRedFertileMushroom extends Feature<NoneFeatureConfiguration> {
    RandomSource random;

    public CustomRedFertileMushroom(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(WorldGenLevel world, BlockPos pos, int large, int height, Rotation rotation) {
        int a = 0;
        int b = 0;
        if (rotation == Rotation.NONE || rotation == Rotation.CLOCKWISE_90) b = -large;
        if (rotation == Rotation.COUNTERCLOCKWISE_90 || rotation == Rotation.CLOCKWISE_180) a = -large;
        for (int i = a; i <= large + a; ++i) {
            for (int j = 1; j < height; ++j) {
                for (int k = b; k <= large + b; ++k) {
                    BlockState blockState = world.getBlockState(pos.offset(i, j, k));
                    if (blockState.isAir() || blockState.is(BlockTags.LEAVES) || blockState.is(BlockTags.FLOWERS))
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
        BlockPos pos = context.origin();
        this.random = context.random();
        int mushroom = getMushroom();
        int large = getLarge(mushroom);
        int height = getHeight(mushroom);
        Rotation rotation = getBlockRotation();
        Vec3i offset = getOffset(mushroom, rotation);

        if (!world.getBlockState(pos.below()).isSolidRender(world, pos.below())) {
            return false;
        }

        if (!canGenerate(world, pos.offset(offset), large, height, rotation)) return false;

        placeMushroom(world, pos.offset(offset), mushroom, rotation);
        return true;
    }

    //return the large of the structure
    public int getLarge(int mushroom) {
        return switch (mushroom) {
            case 1, 2, 3, 4 -> 3;
            case 5, 6, 7 -> 4;
            case 8 -> 5;
            case 9, 10 -> 7;
            case 11, 12 -> 11;
            case 13 -> 6;
            default -> 2;
        };
    }

    //return offset due to random rotation
    public Vec3i getOffset(int mushroom, Rotation rotation) {
        return switch (rotation) {
            case NONE -> switch (mushroom) {
                case 1, 2, 3, 5, 13 -> new Vec3i(-1, 0, -1);
                case 4, 6 -> new Vec3i(-2, 0, -1);
                case 7 -> new Vec3i(-2, 0, -2);
                case 8 -> new Vec3i(-3, 0, -1);
                case 9 -> new Vec3i(-4, 0, -2);
                case 10 -> new Vec3i(-3, 0, -3);
                case 11, 12 -> new Vec3i(-5, 0, -5);
                default -> new Vec3i(0, 0, 0);
            };
            case CLOCKWISE_90 -> switch (mushroom) {
                case 1, 2, 3, 5, 13 -> new Vec3i(1, 0, -1);
                case 4, 6 -> new Vec3i(1, 0, -2);
                case 7 -> new Vec3i(1, 0, -2);
                case 8 -> new Vec3i(1, 0, -3);
                case 9 -> new Vec3i(2, 0, -4);
                case 10 -> new Vec3i(3, 0, -3);
                case 11, 12 -> new Vec3i(5, 0, -5);
                default -> new Vec3i(0, 0, 0);
            };
            case CLOCKWISE_180 -> switch (mushroom) {
                case 1, 2, 3, 5, 13 -> new Vec3i(1, 0, 1);
                case 4, 6 -> new Vec3i(2, 0, 1);
                case 7 -> new Vec3i(3, 0, 1);
                case 8 -> new Vec3i(3, 0, 1);
                case 9 -> new Vec3i(4, 0, 2);
                case 10 -> new Vec3i(3, 0, 3);
                case 11,12 -> new Vec3i(5, 0, 5);
                default -> new Vec3i(0, 0, 0);
            };
            default -> switch (mushroom) {
                case 1, 2, 3, 5, 13 -> new Vec3i(-1, 0, 1);
                case 4, 6 -> new Vec3i(-1, 0, 2);
                case 7 -> new Vec3i(-1, 0, 2);
                case 8 -> new Vec3i(-1, 0, 3);
                case 9 -> new Vec3i(-2, 0, 4);
                case 10 -> new Vec3i(-3, 0, 3);
                case 11, 12 -> new Vec3i(-5, 0, 5);
                default -> new Vec3i(0, 0, 0);
            };
        };
    }

        public int getHeight(int mushroom) {
        return switch (mushroom) {
            case 1 -> 3;
            case 2, 3, 11, 12 -> 5;
            case 4, 5 -> 7;
            case 6, 7 -> 6;
            case 8, 13 -> 8;
            case 9 -> 9;
            default -> 11;
        };
    }

    //return wich mushroom wiil be placed
    public int getMushroom() {
        int rand = random.nextIntBetweenInclusive(0, 120);
        if (rand < 14) return 0;
        if (rand < 26) return 1;
        if (rand < 38) return 2;
        if (rand < 51) return 3;
        if (rand < 59) return 4;
        if (rand < 76) return 5;
        if (rand < 82) return 6;
        if (rand < 89) return 7;
        if (rand < 94) return 8;
        if (rand < 96) return 9;
        if(rand<100) return 10;
        if(rand<107) return 11;
        if(rand<114) return 12;
        return 13;
    }

    public void placeMushroom(WorldGenLevel world, BlockPos pos, int mushroom, Rotation rotation) {
        if (!world.isClientSide()) {
            NbtPlacer structuremushroom = new NbtPlacer(world, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "red_mushroom/red_mushroom_" + mushroom));
            structuremushroom.place(1.0f, pos, new BlockPos(0,0,0), Mirror.NONE, rotation, true);
        }
    }

    //return random rotation
    public Rotation getBlockRotation() {
        return switch (random.nextIntBetweenInclusive(0, 3)) {
            case 1 -> Rotation.CLOCKWISE_90;
            case 2 -> Rotation.COUNTERCLOCKWISE_90;
            case 3 -> Rotation.CLOCKWISE_180;
            default -> Rotation.NONE;
        };
    }
}
