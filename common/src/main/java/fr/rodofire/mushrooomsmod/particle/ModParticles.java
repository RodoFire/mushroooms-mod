package fr.rodofire.mushrooomsmod.particle;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.platform.Services;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public class ModParticles {
    public static final Supplier<SimpleParticleType> GREENFIRE_PARTICLE = register("greenfire_particle");
    public static final Supplier<SimpleParticleType> PINK_CRYSTAL_PARTICLE = register("pink_crystal_particle");
    public static final Supplier<SimpleParticleType> FORGE_PARTICLE = register("forge_particle");

    public static void registerParticles() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Particles");
    }

    private static Supplier<SimpleParticleType> register(String id){
        return Services.PLATFORM.registerParticle(id);
    }
}
