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
        ENCHANTED_BEETROOT = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).alwaysEdible().build();
        ENCHANTED_BEETROOT_SOUP = (new FoodProperties.Builder()).nutrition(9).saturationModifier(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 300, 2), 1.0F).effect(new MobEffectInstance(MobEffects.SATURATION, 10, 0), 1.0F).alwaysEdible().usingConvertsTo(Items.BOWL).build();
    }
}