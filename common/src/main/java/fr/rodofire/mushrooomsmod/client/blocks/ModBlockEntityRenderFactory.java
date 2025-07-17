package fr.rodofire.mushrooomsmod.client.blocks;

import fr.rodofire.mushrooomsmod.block.ModBlockEntities;
import fr.rodofire.mushrooomsmod.block.entity.client.renderer.*;
import fr.rodofire.mushrooomsmod.mixin.client.renderer.blockentity.BlockEntityRendererInvoker;

public class ModBlockEntityRenderFactory {
    public static void registerBlockEntities() {
        BlockEntityRendererInvoker.register(ModBlockEntities.FORGE_BLOCK.get(), ForgeBlockEntityRenderer::new);
        BlockEntityRendererInvoker.register(ModBlockEntities.BOOSTING_MUSHROOM.get(), BoostingMushroomRenderer::new);
        BlockEntityRendererInvoker.register(ModBlockEntities.DANGEROUS_BOOSTING_MUSHROOM.get(), DangerousBoostingMushroomRenderer::new);
        BlockEntityRendererInvoker.register(ModBlockEntities.RAPANGE_FLOWERS_BLOCK.get(), RapangeFlowerRenderer::new);
        BlockEntityRendererInvoker.register(ModBlockEntities.TALL_YELLOW_MUSHROOMS.get(), TallYellowMushroomsRenderer::new);
    }
}
