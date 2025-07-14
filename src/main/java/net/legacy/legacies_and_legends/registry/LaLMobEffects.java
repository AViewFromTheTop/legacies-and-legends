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
    public static final Holder<MobEffect> INSTABILITY = register(
            "instability", (
                    new MobEffect(MobEffectCategory.NEUTRAL, 7901340)
                            .addAttributeModifier(Attributes.MAX_ABSORPTION, ResourceLocation.withDefaultNamespace("effect.absorption"), 2.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.withDefaultNamespace("effect.weakness"), -2.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.GRAVITY, LaLConstants.id("effect.gravity"), 0.08, AttributeModifier.Operation.ADD_VALUE)
            )
    );
    public static final Holder<MobEffect> WARPING = register(
            "warping",
                    new MobEffect(MobEffectCategory.NEUTRAL, 9337599)
    );

    public static void init() {
    }

    private static Holder<MobEffect> register(String path, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, path), effect);
    }
}
