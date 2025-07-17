package fr.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import fr.rodofire.mushrooomsmod.block.entity.BoostingMushroomBE;
import fr.rodofire.mushrooomsmod.block.entity.client.model.BoostingMushroomModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BoostingMushroomRenderer extends GeoBlockRenderer<BoostingMushroomBE> {
    public BoostingMushroomRenderer(BlockEntityRendererProvider.Context context) {
        super(new BoostingMushroomModel());
    }
}
