package fr.rodofire.mushrooomsmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import fr.rodofire.mushrooomsmod.item.ModFoodComponents;
import fr.rodofire.mushrooomsmod.item.ModItems;
import fr.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;

import java.util.List;

public class SchroomSoup extends Item {
    protected final ResourceKey<Biome> biome;
    protected final MobEffectInstance effects;

    public SchroomSoup(Properties setting, ResourceKey<Biome> biome, MobEffectInstance effects) {
        super(setting);
        this.biome = biome;
        this.effects = effects;
    }

    public void applyeffect(Level world, LivingEntity user, ItemStack stack) {
        if (user.eat(world, stack, ModFoodComponents.BLUE_LUMINESCENT_SCHROOM_SOUP).is(ModItems.LUMINESCENT_SCHROOM_SOUP.get())) {
            if (world.getBiome(user.blockPosition()).unwrapKey().get().equals(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE)) {
                user.addEffect(effects);
            }
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        ItemStack itemStack = super.finishUsingItem(stack, world, user);
        applyeffect(world, user, stack);
        if (user instanceof Player && ((Player) user).getAbilities().instabuild) {
            return itemStack;
        }
        return new ItemStack(Items.BOWL);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        tooltip.add(Component.translatable("tooltip.mushrooomsmod.schroom_soup.description"));
        super.appendHoverText(stack, context, tooltip, type);
    }
}
