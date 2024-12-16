package net.rodofire.mushrooomsmod.configs;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.rodofire.mushrooomsmod.MushrooomsMod;

//Done thanks to bsroleplay :https://github.com/B4nduty/bsroleplay-1.21
//b4nduty :  https://github.com/B4nduty
//licensed under CC0 - 1.0

@Config(name = MushrooomsMod.MOD_ID)
public class ModConfig extends PartitioningSerializer.GlobalData {


    @ConfigEntry.Category("server")
    @ConfigEntry.Gui.TransitiveObject()
    public ModServerConfig server = new ModServerConfig();


    @ConfigEntry.Category("client")
    @ConfigEntry.Gui.TransitiveObject()
    public ModClientConfig client = new ModClientConfig();


    @Config(name = MushrooomsMod.MOD_ID + "-server")
    public static final class ModServerConfig implements ConfigData {
        @ConfigEntry.Gui.RequiresRestart()
        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                spawn rate of common biomes, cannot be <= 0
                """)
        int commonbiomespawnrate = 4;

        @ConfigEntry.Gui.RequiresRestart()
        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                spawn rate of cave biomes, cannot be <= 0
                """)
        int cavebiomespawnrate = 4;


        public int getCommonBiomeSpawnRate() {
            return Math.max(1, commonbiomespawnrate);
        }

        public int getCaveBiomeSpawnRate() {
            return Math.max(1, cavebiomespawnrate);
        }
    }

    @Config(name = MushrooomsMod.MOD_ID + "-client")
    public static final class ModClientConfig implements ConfigData {

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                send message to player when joining game
                """)
        boolean betawarningmessage = true;

        public boolean getWarningMessage() {
            return betawarningmessage;
        }
    }
}
