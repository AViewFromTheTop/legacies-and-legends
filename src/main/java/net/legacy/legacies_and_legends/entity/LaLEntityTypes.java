package net.legacy.legacies_and_legends.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.equipment.LaLThrownBoomerang;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.NotNull;

public final class LaLEntityTypes {
    public static final EntityType<LaLThrownBoomerang> THROWN_BOOMERANG = register(
            "falling_leaves",
            EntityType.Builder.<LaLThrownBoomerang>of(LaLThrownBoomerang::new, MobCategory.MISC)
                    .sized(0F, 0F)
                    .clientTrackingRange(0)
                    .build(LaLConstants.string("thrown_boomerang"))
    );

    public static void init() {
    }

    @NotNull
    private static <E extends Entity, T extends EntityType<E>> T register(@NotNull String path, @NotNull T entityType) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, LaLConstants.id(path), entityType);
    }
}