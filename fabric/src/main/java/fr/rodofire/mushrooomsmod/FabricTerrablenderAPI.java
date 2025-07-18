package fr.rodofire.mushrooomsmod;

import fr.rodofire.mushrooomsmod.world.biome.ModTerrablenderAPI;
import terrablender.api.TerraBlenderApi;

public class FabricTerrablenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        MushrooomsModFabric.initializeFabric();
        ModTerrablenderAPI.initTerraBlender();
    }
}
