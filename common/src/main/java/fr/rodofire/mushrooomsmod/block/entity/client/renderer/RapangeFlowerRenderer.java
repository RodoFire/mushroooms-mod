package fr.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import fr.rodofire.mushrooomsmod.block.entity.RapangeFlowersBE;
import fr.rodofire.mushrooomsmod.block.entity.client.model.RapangeFlowerModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class RapangeFlowerRenderer extends GeoBlockRenderer<RapangeFlowersBE> {

    public RapangeFlowerRenderer(BlockEntityRendererProvider.Context context) {
        super(new RapangeFlowerModel());
    }
}
