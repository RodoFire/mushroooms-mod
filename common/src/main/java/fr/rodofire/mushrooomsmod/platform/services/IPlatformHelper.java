package fr.rodofire.mushrooomsmod.platform.services;

import fr.rodofire.mushrooomsmod.entity.custom.GrokiEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.function.Supplier;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

    /**
     * Gets the name of the environment type as a string.
     *
     * @return The name of the environment type.
     */
    default String getEnvironmentName() {

        return isDevelopmentEnvironment() ? "development" : "production";
    }


    Supplier<CreativeModeTab> createCreativeTab(String name, Supplier<ItemStack> icon, List<Supplier<Item>> items);

    <T> Supplier<T> register(Registry<T> registry, Supplier<T> toRegister, String id);

    Supplier<SimpleParticleType> registerParticle(String id);

    void registerBiomeModfication( GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, ResourceKey<Biome> ... biome);

    <T extends Entity> void registerEntityRenderer(EntityType<? extends T> entityType, EntityRendererProvider<T> rendererFactory);

    void registerEntityAtributes(EntityType<? extends LivingEntity> entityType, AttributeSupplier.Builder attributes);

    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, BlockEntityType<T> build);

    void registerBiomeModfication(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, TagKey<Biome>[] biome);
}