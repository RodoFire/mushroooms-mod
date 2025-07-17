package fr.rodofire.mushrooomsmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
    public static final FoodProperties BAGUETTE = new FoodProperties.Builder().nutrition(8).saturationModifier(1.1f).build();
    public static final FoodProperties BLUE_LUMINESCENT_SCHROOM_SOUP = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final FoodProperties YELLOW_BERRIES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).alwaysEdible().fast().effect(new MobEffectInstance(MobEffects.CONFUSION, 250), 0.2f).build();
    public static final FoodProperties COOKED_YELLOW_BERRIES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).alwaysEdible().fast().build();
}
