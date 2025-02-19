package net.legacy.legacies_and_legends.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.legacy.legacies_and_legends.entity.LaLEntityType;

@Environment(EnvType.CLIENT)
public class LaLEntityRenderers {
    public static void init () {
        EntityRendererRegistry.register(LaLEntityType.THROWN_BOOMERANG, LaLThrownBoomerangRenderer::new);
    }
}
