package fr.rodofire.mushrooomsmod.world.noises;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public class ModNoises {
    //No idea for the name
    public static final ResourceKey<NormalNoise.NoiseParameters> EMMENTAL_NOISE = registerKey("emmental_noise");
    public static final ResourceKey<NormalNoise.NoiseParameters> INTERMEDIATE_NOISE = registerKey("intermediate_noise");
    public static final ResourceKey<NormalNoise.NoiseParameters> PATCH_NOISE = registerKey("patch_noise");
    public static final ResourceKey<NormalNoise.NoiseParameters> SIMPLIFIED_SURFACE = registerKey("simplified_surface");


    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context){
        register(context, EMMENTAL_NOISE, -1, 1.0d);
        register(context, INTERMEDIATE_NOISE, -2, 1.0d);
        register(context, PATCH_NOISE, -4, 1.0d);
        register(context, SIMPLIFIED_SURFACE, -6, 1.0d);
    }

    private static ResourceKey<NormalNoise.NoiseParameters> registerKey(String name){
        return ResourceKey.create(Registries.NOISE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name));
    }

    private static void register(BootstrapContext<NormalNoise.NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key, int firstoctave, double firstamplitude, double... octaves){
        context.register(key, new NormalNoise.NoiseParameters(firstoctave, firstamplitude, octaves));
    }
}
