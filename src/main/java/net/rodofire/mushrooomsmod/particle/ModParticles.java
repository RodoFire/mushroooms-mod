package net.rodofire.mushrooomsmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModParticles {
    public static final DefaultParticleType GREENFIRE_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType PINK_CRYSTAL_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType FORGE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        MushrooomsMod.LOGGER.info("|\t-Registering Particles");
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MushrooomsMod.MOD_ID, "greenfire_particle"),
                GREENFIRE_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MushrooomsMod.MOD_ID, "pink_crystal_particle"),
                PINK_CRYSTAL_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MushrooomsMod.MOD_ID, "forge_particle"),
                FORGE_PARTICLE);
    }
}
