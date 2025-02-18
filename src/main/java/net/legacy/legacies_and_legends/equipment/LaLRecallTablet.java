package net.legacy.legacies_and_legends.equipment;

import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.TeleportTransition;

public class LaLRecallTablet extends Item {
    public LaLRecallTablet(Settings settings) {
        super((Properties) settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity player) {
        if (!(level instanceof ServerLevel)) {
            return stack;
        }

        ServerPlayer serverPlayer = (ServerPlayer) player;
        ServerLevel targetLevel = serverPlayer.server.getLevel(serverPlayer.getRespawnDimension());

        if (serverPlayer.level() != targetLevel) {
            serverPlayer.sendSystemMessage(Component.translatable(LaLConstants.MOD_ID + "tablet_of_recall.invalid_dimension"), false);
            return stack;
        }

        serverPlayer.teleport(serverPlayer.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING));
        targetLevel.playSound(null, serverPlayer.blockPosition(), LaLSounds.TABLET_TELEPORT, SoundSource.PLAYERS, 0.6f, 1f);

        if (serverPlayer.gameMode.getGameModeForPlayer().isCreative()) {
            return stack;
        }
        else {
            return ItemStack.EMPTY;
        }
    }


}