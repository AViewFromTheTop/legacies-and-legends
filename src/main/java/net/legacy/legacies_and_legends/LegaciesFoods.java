package net.legacy.legacies_and_legends;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class LegaciesFoods {
    public static final FoodProperties ENCHANTED_BEETROOT;
    public static final FoodProperties ENCHANTED_BEETROOT_SOUP;

    public LegaciesFoods() {
    }

    static {
        ENCHANTED_BEETROOT = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2F).alwaysEdible().build();
        ENCHANTED_BEETROOT_SOUP = (new FoodProperties.Builder()).nutrition(9).saturationModifier(1.2F).alwaysEdible().build();
    }
}