package fr.rodofire.mushrooomsmod.datagen;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class ModWorldGenerator extends FabricDynamicRegistryProvider {


    public ModWorldGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return MushrooomsModConstants.MOD_ID;
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        entries.addAll(provider.lookupOrThrow(Registries.BIOME));
        entries.addAll(provider.lookupOrThrow(Registries.CONFIGURED_FEATURE));
        entries.addAll(provider.lookupOrThrow(Registries.PLACED_FEATURE));
        entries.addAll(provider.lookupOrThrow(Registries.STRUCTURE));
        entries.addAll(provider.lookupOrThrow(Registries.NOISE));
    }
}
