package fr.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import fr.rodofire.mushrooomsmod.block.entity.DangerousBoostingMushroomBE;
import fr.rodofire.mushrooomsmod.block.entity.client.model.DangerousBoostingMushroomModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DangerousBoostingMushroomRenderer extends GeoBlockRenderer<DangerousBoostingMushroomBE> {

    public DangerousBoostingMushroomRenderer(BlockEntityRendererProvider.Context context) {
        super(new DangerousBoostingMushroomModel());
    }
}
