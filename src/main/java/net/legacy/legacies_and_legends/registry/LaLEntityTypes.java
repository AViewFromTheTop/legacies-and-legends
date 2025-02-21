package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.entity.BoomerangProjectile;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.jetbrains.annotations.NotNull;

public final class LaLEntityTypes {
    public static final @NotNull EntityType<BoomerangProjectile> BOOMERANG = register(
            "boomerang",
            EntityType.Builder.<BoomerangProjectile>of(BoomerangProjectile::new, MobCategory.MISC)
                    .sized(0.5F, 0.25F)
                    .clientTrackingRange(64)
                    .updateInterval(10)
    );

    public static void init() {
    }

    private static <T extends Entity> @NotNull EntityType<T> register(String string, EntityType.@NotNull Builder<T> builder) {
        ResourceKey<EntityType<?>> resourceKey = ResourceKey.create(Registries.ENTITY_TYPE, LaLConstants.id(string));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceKey, builder.build(resourceKey));
    }
}