package net.rodofire.mushrooomsmod.world.noises;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModNoises {
    //No idea for the name
    public static final RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> EMMENTAL_NOISE = registerKey("emmental_noise");
    public static final RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> INTERMEDIATE_NOISE = registerKey("intermediate_noise");
    public static final RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> PATCH_NOISE = registerKey("patch_noise");


    public static void bootstrap(Registerable<DoublePerlinNoiseSampler.NoiseParameters> context){
        register(context, EMMENTAL_NOISE, -1, 1.0d);
        register(context, INTERMEDIATE_NOISE, -2, 1.0d);
        register(context, PATCH_NOISE, -4, 1.0d);
    }

    private static RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> registerKey(String name){
        return RegistryKey.of(RegistryKeys.NOISE_PARAMETERS, new Identifier(MushrooomsMod.MOD_ID, name));
    }

    private static void register(Registerable<DoublePerlinNoiseSampler.NoiseParameters> context, RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> key, int firstoctave, double firstamplitude, double... octaves){
        context.register(key, new DoublePerlinNoiseSampler.NoiseParameters(firstoctave, firstamplitude, octaves));
    }
}
