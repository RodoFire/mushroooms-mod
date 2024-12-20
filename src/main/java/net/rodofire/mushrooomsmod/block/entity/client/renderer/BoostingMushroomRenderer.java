package net.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.block.entity.BoostingMushroomBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.client.model.BoostingMushroomModel;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BoostingMushroomRenderer extends GeoBlockRenderer<BoostingMushroomBlockEntity> {
    public BoostingMushroomRenderer(BlockEntityRendererFactory.Context context) {
        super(new BoostingMushroomModel());
    }
}
