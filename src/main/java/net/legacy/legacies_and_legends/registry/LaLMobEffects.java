package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class LaLMobEffects {
    public static final Holder<MobEffect> FREEZING = register(
            "freezing",
            new MobEffect(MobEffectCategory.HARMFUL, 7720931)
    );
    public static final Holder<MobEffect> AMPLIFYING = register(
            "amplifying", (
            new MobEffect(MobEffectCategory.BENEFICIAL, 7720931))
                    .addAttributeModifier(Attributes.JUMP_STRENGTH, LaLConstants.id("effect.jump_boost"), 1.0F, AttributeModifier.Operation.ADD_VALUE)
    );
    public static final Holder<MobEffect> DESTABILIZING = register(
            "destabilizing", (
                    new MobEffect(MobEffectCategory.NEUTRAL, 12624973))
                    .addAttributeModifier(Attributes.GRAVITY, LaLConstants.id("effect.gravity"), 0.08F, AttributeModifier.Operation.ADD_VALUE)
    );

    public static void init() {
    }

    private static Holder<MobEffect> register(String path, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, path), effect);
    }
}
