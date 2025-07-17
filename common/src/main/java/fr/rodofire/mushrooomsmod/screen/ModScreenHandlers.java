package fr.rodofire.mushrooomsmod.screen;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public class ModScreenHandlers {
    /*public static final MenuType<ForgeScreenHandler> FORGE_SCREEN_HANDLER =
            Registry.register(BuiltInRegistries.MENU, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "forge_screen_handler"),
                    new MenuType<>(ForgeScreenHandler::new, FeatureFlags.VANILLA_SET/*ForgeScreenHandler.PACKET_CODEC));*/
    //public static final ExtendedScreenHandlerType<ForgeScreenHandler> OVEN =     new ForgeScreenHandler(syncId, inventory, data) -> ..., ForgeScreenHandler.PACKET_CODEC);

    public static void registerScreenHandler() {
        MushrooomsModConstants.LOGGER.info("Registering Screen Handlers for " + MushrooomsModConstants.MOD_ID);
    }


}
