package net.rodofire.mushrooomsmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

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
        Identifier id = new Identifier(MushrooomsMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSound() {
        MushrooomsMod.LOGGER.info("|\t-Registering Sounds");
    }
}
