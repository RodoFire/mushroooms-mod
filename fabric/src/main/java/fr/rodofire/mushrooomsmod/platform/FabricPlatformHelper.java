package fr.rodofire.mushrooomsmod.platform;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.platform.services.IPlatformHelper;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Supplier<CreativeModeTab> createCreativeTab(String name, Supplier<ItemStack> icon, List<Supplier<Item>> items) {
        CreativeModeTab tab = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name), FabricItemGroup.builder().title(Component.translatable("itemgroup.mushroooms"))
                .icon(icon)
                .displayItems((entry, context) -> items.forEach(itemSupplier -> context.accept(itemSupplier.get())))
                .build());
        return () -> tab;
    }

    @Override
    public <T> Supplier<T> register(T toRegister, String id, Registry<T> registry) {
        return () -> Registry.register(registry, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, id), toRegister);
    }


    @Override
    public Supplier<SimpleParticleType> registerParticle(String id) {
        return () -> Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, id), FabricParticleTypes.simple());
    }

    @Override
    public void registerBiomeModfication(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, ResourceKey<Biome>... biome) {
        Arrays.stream(biome).forEach(biomeResourceKey -> {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(biome), step, placedFeature);
        });
    }

    @Override
    public <T extends Entity> void registerEntityRenderer(EntityType<? extends T> entityType, EntityRendererProvider<T> rendererFactory) {
        EntityRendererRegistry.register(entityType, rendererFactory);
    }

    @Override
    public void registerEntityAtributes(EntityType<? extends LivingEntity> entityType, AttributeSupplier.Builder attributes) {
        FabricDefaultAttributeRegistry.register(entityType, attributes);
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, BlockEntityType<T> build) {
        BlockEntityType<T> type = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, id),
                build
        );
        return () -> type;
    }

    @Override
    public void registerBiomeModfication(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, TagKey<Biome>[] biome) {
        Arrays.stream(biome).forEach(biomeTagKey -> {
            BiomeModifications.addFeature(BiomeSelectors.tag(biomeTagKey), step, placedFeature);
        });
    }
}
