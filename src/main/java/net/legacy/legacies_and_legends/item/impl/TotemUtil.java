package net.legacy.legacies_and_legends.item.impl;

import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TotemUtil {
    public static void playTotemAnimation(ItemStack itemStack, Entity entity) {
        Minecraft minecraftClient = Minecraft.getInstance();
        minecraftClient.particleEngine.createTrackingEmitter(entity, ParticleTypes.TOTEM_OF_UNDYING, 30);

        ClientLevel clientWorld = minecraftClient.level;

        if (clientWorld != null) {
            clientWorld.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.TOTEM_USE, entity.getSoundSource(), 1.0f, 1.0f, false);
        }

        minecraftClient.gameRenderer.displayItemActivation(itemStack);
    }
}
