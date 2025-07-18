package fr.rodofire.mushrooomsmod.platform;

import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.platform.services.IPlatformHelper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public <T> Supplier<T> register(Registry<T> registry, Supplier<T> toRegister, String id) {
        return DeferredRegister.create(registry.key().location(), MushrooomsModConstants.MOD_ID).register(id, toRegister);
    }

    @Override
    public Supplier<SimpleParticleType> registerParticle(String id) {
        return null;
    }

    @Override
    public void registerBiomeModfication(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, ResourceKey<Biome>... biome) {

    }

    @Override
    public <T extends Entity> void registerEntityRenderer(EntityType<? extends T> entityType, EntityRendererProvider<T> rendererFactory) {

    }

    @Override
    public void registerEntityAtributes(EntityType<? extends LivingEntity> entityType, AttributeSupplier.Builder attributes) {

    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, BlockEntityType<T> build) {
        return null;
    }

    @Override
    public void registerBiomeModfication(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, TagKey<Biome>[] biome) {

    }

}