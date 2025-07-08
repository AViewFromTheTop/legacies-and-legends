package net.legacy.legacies_and_legends.item.impl;

import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Items;

public class TotemUtil {
    public static void playTeleportationTotemAnimation(Entity entity) {
        if (ParticleTypes.TOTEM_OF_UNDYING.getOverrideLimiter()) return;
        Minecraft minecraftClient = Minecraft.getInstance();
        minecraftClient.particleEngine.createTrackingEmitter(entity, ParticleTypes.TOTEM_OF_UNDYING, 30);

        ClientLevel clientWorld = minecraftClient.level;

        if (clientWorld != null) {
            clientWorld.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.TOTEM_USE, entity.getSoundSource(), 1.0f, 1.0f, false);
        }

        if (entity == minecraftClient.player) {
            minecraftClient.gameRenderer.displayItemActivation(LaLItems.TOTEM_OF_TELEPORTATION.getDefaultInstance());
        }
    }

    public static void playVengeanceTotemAnimation(Entity entity) {
        if (ParticleTypes.TOTEM_OF_UNDYING.getOverrideLimiter()) return;
        Minecraft minecraftClient = Minecraft.getInstance();
        minecraftClient.particleEngine.createTrackingEmitter(entity, ParticleTypes.TOTEM_OF_UNDYING, 30);

        ClientLevel clientWorld = minecraftClient.level;

        if (clientWorld != null) {
            clientWorld.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.TOTEM_USE, entity.getSoundSource(), 1.0f, 1.0f, false);
        }

        if (entity == minecraftClient.player) {
            minecraftClient.gameRenderer.displayItemActivation(LaLItems.TOTEM_OF_VENGEANCE.getDefaultInstance());
        }
    }

    public static void playUndyingTotemAnimation(Entity entity) {
        if (ParticleTypes.TOTEM_OF_UNDYING.getOverrideLimiter()) return;
        Minecraft minecraftClient = Minecraft.getInstance();
        minecraftClient.particleEngine.createTrackingEmitter(entity, ParticleTypes.TOTEM_OF_UNDYING, 30);

        ClientLevel clientWorld = minecraftClient.level;

        if (clientWorld != null) {
            clientWorld.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.TOTEM_USE, entity.getSoundSource(), 1.0f, 1.0f, false);
        }

        if (entity == minecraftClient.player) {
            minecraftClient.gameRenderer.displayItemActivation(Items.TOTEM_OF_UNDYING.getDefaultInstance());
        }
    }
}
