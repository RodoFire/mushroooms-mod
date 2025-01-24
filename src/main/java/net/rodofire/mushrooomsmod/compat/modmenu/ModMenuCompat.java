package net.rodofire.mushrooomsmod.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.rodofire.mushrooomsmod.config.client.MushrooomsConfigScreen;

public class ModMenuCompat implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return MushrooomsConfigScreen::new;
    }

}
