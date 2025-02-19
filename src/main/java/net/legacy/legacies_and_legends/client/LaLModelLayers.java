package net.legacy.legacies_and_legends.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.entity.LaLEntityType;
import net.minecraft.client.model.geom.ModelLayerLocation;

@Environment(EnvType.CLIENT)
public final class LaLModelLayers {
    public static final ModelLayerLocation THROWN_BOOMERANG = new ModelLayerLocation(LaLConstants.id("boomerang"), "main");

    public static void init() {
        EntityRendererRegistry.register(LaLEntityType.THROWN_BOOMERANG, LaLThrownBoomerangRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(THROWN_BOOMERANG, LaLBoomerangModel::createLayer);

    }
}
