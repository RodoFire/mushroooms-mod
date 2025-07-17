package fr.rodofire.mushrooomsmod.sound;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static SoundEvent LA_MARSEILLAISE_DISC = registerSoundEvent("la_marseillaise_disc");
    public static SoundEvent HYMEN_URSS = registerSoundEvent("hymne_urss");

    //Crystal
    public static SoundEvent PINK_CRYSTAL_BREAK = registerSoundEvent("crystal_pink_break");
    public static SoundEvent PINK_CRYSTAL_STEP = registerSoundEvent("crystal_pink_step");
    public static SoundEvent PINK_CRYSTAL_PLACE = registerSoundEvent("crystal_pink_place");
    public static SoundEvent PINK_CRYSTAL_HIT = registerSoundEvent("crystal_pink_hit");
    public static SoundEvent PINK_CRYSTAL_FALL = registerSoundEvent("crystal_pink_fall");

    public static SoundEvent STONE_DESTROYED = registerSoundEvent("stone_destroyed");

    public static SoundEvent BOOST_MUSHROOM = registerSoundEvent("boost_mushroom");

    private static SoundEvent registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerModSound() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Sounds");
    }
}
