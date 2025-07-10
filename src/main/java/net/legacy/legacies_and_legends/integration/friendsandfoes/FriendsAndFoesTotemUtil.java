package net.legacy.legacies_and_legends.integration.friendsandfoes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class FriendsAndFoesTotemUtil {
    public static void playActivateAnimation(Entity entity, ParticleType<?> particleType) {
        Minecraft minecraftClient = Minecraft.getInstance();
        minecraftClient.particleEngine.createTrackingEmitter(entity, (ParticleOptions)particleType, 30);
        ClientLevel clientWorld = minecraftClient.level;
        if (clientWorld != null) {
            clientWorld.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.TOTEM_USE, entity.getSoundSource(), 1.0F, 1.0F, false);
        }
    }

    public static void playActivateAnimationOnly(ItemStack itemStack) {
        Minecraft minecraftClient = Minecraft.getInstance();

        minecraftClient.gameRenderer.displayItemActivation(itemStack.getItem().getDefaultInstance());
    }
}
