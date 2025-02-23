package net.legacy.legacies_and_legends.enchantment;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.*;

public class LaLMobEffects {
    public static final Holder<MobEffect> FREEZING = register(
            "freezing",
            new MobEffect(MobEffectCategory.HARMFUL, 3402751)
    );

    public static void init() {
    }

    private static Holder<MobEffect> register(String path, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, path), effect);
    }
}
