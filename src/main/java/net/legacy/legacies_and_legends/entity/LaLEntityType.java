package net.legacy.legacies_and_legends.entity;


import net.frozenblock.lib.mobcategory.api.FrozenMobCategories;
import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public final class LaLEntityType {
    public static final @NotNull EntityType<LaLThrownBoomerang> THROWN_BOOMERANG = register(
            "boomerang",
            EntityType.Builder.of(LaLThrownBoomerang::new, FrozenMobCategories.getCategory(LaLConstants.MOD_ID, "boomerang"))
                    .sized(0.5F, 0.5F)
    );

    public static void init(){}

    private static <T extends Entity> @NotNull EntityType<T> register(String string, EntityType.Builder<Entity> builder) {
        ResourceKey<EntityType<?>> resourceKey = ResourceKey.create(Registries.ENTITY_TYPE, LaLConstants.id(string));
        return (EntityType<T>) Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceKey, builder.build(resourceKey));
    }
}