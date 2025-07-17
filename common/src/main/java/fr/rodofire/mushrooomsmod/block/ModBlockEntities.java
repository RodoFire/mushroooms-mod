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

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final Supplier<BlockEntityType<ForgeBE>> FORGE_BLOCK = register("forge_be", ForgeBE::new, ModBlocks.FORGE_BLOCK.get());

    public static final Supplier<BlockEntityType<BoostingMushroomBE>> BOOSTING_MUSHROOM = register("boosting_mushroom_be", BoostingMushroomBE::new, ModBlocks.MUSHROOM_BOOSTING.get());
    public static final Supplier<BlockEntityType<DangerousBoostingMushroomBE>> DANGEROUS_BOOSTING_MUSHROOM = register("dangerous_boosting_mushroom_be", DangerousBoostingMushroomBE::new, ModBlocks.DANGEROUS_MUSHROOM_BOOSTING.get());
    public static final Supplier<BlockEntityType<RapangeFlowersBE>> RAPANGE_FLOWERS_BLOCK = register("rapange_flowers_be", RapangeFlowersBE::new, ModBlocks.RAPANGE_FLOWERS.get());
    public static final Supplier<BlockEntityType<TallYellowMushroomsBE>> TALL_YELLOW_MUSHROOMS = register("tall_yellow_mushrooms", TallYellowMushroomsBE::new, ModBlocks.TALL_YELLOW_MUSHROOMS.get());


    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String id, BlockEntityType.BlockEntitySupplier<T> factory, Block... blocks) {
        //return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, id), BlockEntityType.Builder.of(factory, blocks));
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, id);
        return Services.PLATFORM.registerBlockEntity(id, BlockEntityType.Builder.of(factory, blocks).build(null));
    }


    public static void registerBlockEntities() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Block Entities");
    }

}
