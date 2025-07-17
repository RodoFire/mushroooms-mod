package fr.rodofire.mushrooomsmod.hud;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.client.hud.HammerHUDOverlay;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = MushrooomsModConstants.MOD_ID, value = Dist.CLIENT)
public class HammerHUDOverlayNeo {
    public static void register() {

    }

    @SubscribeEvent
    public static void onRenderGui(net.neoforged.neoforge.client.event.RenderGuiEvent.Post event) {
        HammerHUDOverlay.onHudRender(event.getGuiGraphics(), event.getPartialTick());
    }

}
