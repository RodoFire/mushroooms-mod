package net.rodofire.mushrooomsmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.BoostingMushroomBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.DangerousBoostingMushroomBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.ForgeBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.RapangeFlowersBlockEntity;

import java.util.Set;

public class ModBlockEntities {
    public static void registerBlockEntities() {
        MushrooomsMod.LOGGER.info("Registering Block Entities");
        BlockEntityType.CAMPFIRE.addSupportedBlock(ModBlocks.GREEN_CAMPFIRE);
    }
    public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MushrooomsMod.MOD_ID, "forge_be")
            , FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, ModBlocks.FORGE_BLOCK).build());

    public static final BlockEntityType<BoostingMushroomBlockEntity> BOOSTING_MUSHROOM_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MushrooomsMod.MOD_ID, "boosting_mushroom_be")
            , FabricBlockEntityTypeBuilder.create(BoostingMushroomBlockEntity::new, ModBlocks.MUSHROOM_BOOSTING).build());

    public static final BlockEntityType<DangerousBoostingMushroomBlockEntity> DANGEROUS_BOOSTING_MUSHROOM_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MushrooomsMod.MOD_ID, "dangerous_boosting_mushroom_be")
            , FabricBlockEntityTypeBuilder.create(DangerousBoostingMushroomBlockEntity::new, ModBlocks.DANGEROUS_MUSHROOM_BOOSTING).build());

    public static final BlockEntityType<RapangeFlowersBlockEntity> RAPANGE_FLOWERS_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MushrooomsMod.MOD_ID, "rapange_flowers_be")
            , FabricBlockEntityTypeBuilder.create(RapangeFlowersBlockEntity::new, ModBlocks.RAPANGE_FLOWERS).build());



}
