package net.legacy.legacies_and_legends.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.registry.LaLEntityTypes;
import net.minecraft.client.model.geom.ModelLayerLocation;

@Environment(EnvType.CLIENT)
public final class LaLModelLayers {
    public static final ModelLayerLocation BOOMERANG = new ModelLayerLocation(LaLConstants.id("boomerang"), "main");

    public static void init() {
        EntityRendererRegistry.register(LaLEntityTypes.BOOMERANG, BoomerangRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(BOOMERANG, BoomerangModel::createBodyLayer);

    }
}
