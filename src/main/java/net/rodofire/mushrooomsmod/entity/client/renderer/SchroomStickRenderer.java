package net.rodofire.mushrooomsmod.entity.client.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.client.model.SchroomStickModel;
import net.rodofire.mushrooomsmod.entity.custom.SchroomStickEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SchroomStickRenderer extends GeoEntityRenderer<SchroomStickEntity> {
    public SchroomStickRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SchroomStickModel());
    }

    @Override
    public Identifier getTextureLocation(SchroomStickEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/entity/schroom_stick.png");
    }
}
