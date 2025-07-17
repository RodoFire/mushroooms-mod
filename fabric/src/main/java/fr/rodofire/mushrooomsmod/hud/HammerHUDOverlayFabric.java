package fr.rodofire.mushrooomsmod.hud;

import fr.rodofire.mushrooomsmod.client.hud.HammerHUDOverlay;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;

public class HammerHUDOverlayFabric implements HudRenderCallback {
    public static void register(){

    }

    @Override
    public void onHudRender(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        HammerHUDOverlay.onHudRender(guiGraphics, deltaTracker);
    }
}
