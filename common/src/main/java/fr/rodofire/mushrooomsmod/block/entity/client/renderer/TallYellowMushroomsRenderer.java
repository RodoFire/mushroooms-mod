package fr.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import fr.rodofire.mushrooomsmod.block.entity.TallYellowMushroomsBE;
import fr.rodofire.mushrooomsmod.block.entity.client.model.TallYellowMushroomModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TallYellowMushroomsRenderer extends GeoBlockRenderer<TallYellowMushroomsBE> {
    public TallYellowMushroomsRenderer(BlockEntityRendererProvider.Context context) {
        super(new TallYellowMushroomModel());
    }
}
