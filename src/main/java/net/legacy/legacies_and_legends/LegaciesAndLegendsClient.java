package net.legacy.legacies_and_legends;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.frozenblock.lib.sound.api.FlyBySoundHub;
import net.legacy.legacies_and_legends.client.LaLEntityRenderers;
import net.legacy.legacies_and_legends.client.LaLModelLayers;
import net.legacy.legacies_and_legends.entity.LaLEntityType;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.sounds.SoundSource;

@Environment(EnvType.CLIENT)
public final class LegaciesAndLegendsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LaLEntityRenderers.init();
        LaLModelLayers.init();
    }
}
