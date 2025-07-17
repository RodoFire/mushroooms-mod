package fr.rodofire.mushrooomsmod.world.structures;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import fr.rodofire.mushrooomsmod.util.ModTags;
import fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.GiantYellowMushroomStructure;
import fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.PurpleMushroomStructure;
import fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.YellowMushroomStructure;

public class ModStructures {
    public static void bootstrap(BootstrapContext<Structure> structureRegisterable) {
        HolderGetter<Biome> biomeLookup = structureRegisterable.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> poolLookup = structureRegisterable.lookup(Registries.TEMPLATE_POOL);

        structureRegisterable.register(
                ModStructureKey.YELLOW_MUSHROOM,
                new YellowMushroomStructure(
                        new Structure.StructureSettings.Builder(
                                biomeLookup.getOrThrow(ModTags.Biomes.HAS_YELLOW_MUSHROOM))
                                .generationStep(GenerationStep.Decoration.VEGETAL_DECORATION)
                                .build()
                )
        );

        structureRegisterable.register(
                ModStructureKey.GIANT_YELLOW_MUSHROOM,
                new GiantYellowMushroomStructure(
                        new Structure.StructureSettings.Builder(
                                biomeLookup.getOrThrow(ModTags.Biomes.HAS_GIANT_YELLOW_MUSHROOM))
                                .generationStep(GenerationStep.Decoration.VEGETAL_DECORATION)
                                .build()
                )
        );

        structureRegisterable.register(
                ModStructureKey.PURPLE_MUSHROOM,
                new PurpleMushroomStructure(
                        new Structure.StructureSettings.Builder(
                                biomeLookup.getOrThrow(ModTags.Biomes.HAS_PURPLE_MUSHROOM))
                                .generationStep(GenerationStep.Decoration.VEGETAL_DECORATION)
                                .build()
                )
        );
    }
}
