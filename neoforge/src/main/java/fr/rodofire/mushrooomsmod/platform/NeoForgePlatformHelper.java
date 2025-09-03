package fr.rodofire.mushrooomsmod.platform;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.platform.services.IPlatformHelper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Supplier;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public Supplier<CreativeModeTab> createCreativeTab(String name, Supplier<ItemStack> icon, List<Supplier<Item>> items) {
        return () -> Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, name, CreativeModeTab.builder()
                .title(Component.translatable("itemgroup.mushroooms"))
                .icon(icon)
                .displayItems((context, entries) -> {
                    items.forEach(itemSupplier -> entries.accept(itemSupplier.get()));
                })
                .withSearchBar()
                .build());
    }

    private static final Map<ResourceKey<?>, DeferredRegister<?>> TO_REGISTER = new LinkedHashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public <T> Supplier<T> register(Registry<T> registry, Supplier<T> toRegister, String id) {
        ResourceKey<? extends Registry<T>> key = registry.key();

        DeferredRegister<T> typedRegister = (DeferredRegister<T>) TO_REGISTER.computeIfAbsent(
                key,
                k -> DeferredRegister.create(key.location(), MushrooomsModConstants.MOD_ID)
        );

        return typedRegister.register(id, toRegister);
    }

    private static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, MushrooomsModConstants.MOD_ID);

    @Override
    public Supplier<SimpleParticleType> registerParticle(String id) {
        return PARTICLES.register(id, () -> new SimpleParticleType(true));
    }

    @Override
    public void registerBiomeModfication(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, ResourceKey<Biome>... biome) {

    }

    @Override
    public <T extends A, A extends Entity> void registerEntityRenderer(Supplier<EntityType<T> >entityType, EntityRendererProvider<A> rendererFactory) {
        EntityRenderers.register(entityType.get(), rendererFactory);
    }

    @Override
    public <T extends LivingEntity> void registerEntityAtributes(Supplier<EntityType<T>> entityType, AttributeSupplier.Builder attributes) {

    }

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MushrooomsModConstants.MOD_ID);

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> build) {
        return BLOCK_ENTITIES.register(id, build);
    }

    @Override
    public void registerBiomeModfication(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, TagKey<Biome>[] biomes) {
       /* BiomeModifications.addFeature(
                context -> Arrays.stream(biomes).anyMatch(context::hasTag),
                step,
                placedFeature
        );*/
    }

    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MushrooomsModConstants.MOD_ID);

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, Supplier<EntityType<T>> ro) {
        return ENTITIES.register(name, ro);
    }

    public static void registerAll(IEventBus bus) {
        TO_REGISTER.values().forEach(reg -> reg.register(bus));
        BLOCK_ENTITIES.register(bus);
        ENTITIES.register(bus);
        PARTICLES.register(bus);
    }

}