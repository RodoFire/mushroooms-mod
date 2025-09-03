package fr.rodofire.mushrooomsmod.block;

import com.mojang.datafixers.types.Type;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.block.entity.*;
import fr.rodofire.mushrooomsmod.platform.Services;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Arrays;
import java.util.function.Supplier;

public class ModBlockEntities {

    // IMPORTANT: passer les suppliers de blocks, pas .get()
    public static final Supplier<BlockEntityType<ForgeBE>> FORGE_BLOCK =
            register("forge_be", ForgeBE::new, ModBlocks.FORGE_BLOCK);

    public static final Supplier<BlockEntityType<BoostingMushroomBE>> BOOSTING_MUSHROOM =
            register("boosting_mushroom_be", BoostingMushroomBE::new, ModBlocks.MUSHROOM_BOOSTING);
    public static final Supplier<BlockEntityType<DangerousBoostingMushroomBE>> DANGEROUS_BOOSTING_MUSHROOM =
            register("dangerous_boosting_mushroom_be", DangerousBoostingMushroomBE::new, ModBlocks.DANGEROUS_MUSHROOM_BOOSTING);
    public static final Supplier<BlockEntityType<RapangeFlowersBE>> RAPANGE_FLOWERS_BLOCK =
            register("rapange_flowers_be", RapangeFlowersBE::new, ModBlocks.RAPANGE_FLOWERS);
    public static final Supplier<BlockEntityType<TallYellowMushroomsBE>> TALL_YELLOW_MUSHROOMS =
            register("tall_yellow_mushrooms", TallYellowMushroomsBE::new, ModBlocks.TALL_YELLOW_MUSHROOMS);

    // Accepte des Supplier de Block et ne les résout qu'au moment de l'enregistrement
    @SafeVarargs
    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(
            String id,
            BlockEntityType.BlockEntitySupplier<T> factory,
            Supplier<? extends Block>... blocksSuppliers
    ) {
        // Si vous avez besoin du type DataFixer pour la compat:
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, id);

        // Différer la construction jusqu'à la phase d'enregistrement
        return Services.PLATFORM.registerBlockEntity(id, () -> {
            Block[] blocks = Arrays.stream(blocksSuppliers)
                    .map(Supplier::get) // résolu maintenant, une fois les registres liés
                    .toArray(Block[]::new);
            return BlockEntityType.Builder.of(factory, blocks).build(type);
        });
    }

    public static void registerBlockEntities() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Block Entities");
    }
}
