package net.rodofire.mushrooomsmod.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.rodofire.mushrooomsmod.config.client.MushrooomsConfigScreen;

public class ModMenuCompat implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return MushrooomsConfigScreen::new;
    }

}
