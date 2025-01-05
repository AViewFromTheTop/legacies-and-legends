package net.legacy.legacies_and_legends;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

public final class LegaciesFuelRegistry {
    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(LegaciesItems.WOODEN_BUCKET, 300);
            builder.add(LegaciesItems.COAL_BUCKET, 19200);
            builder.add(LegaciesItems.CHARCOAL_BUCKET, 19200);
        });
    }
}
