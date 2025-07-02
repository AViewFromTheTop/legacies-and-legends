package net.legacy.legacies_and_legends.equipment;

import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.TeleportTransition;

public class RecallTabletItem extends Item {
    public RecallTabletItem(Settings settings) {
        super((Properties) settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity player) {
        if (!(level instanceof ServerLevel)) {
            return stack;
        }

        ServerPlayer serverPlayer = (ServerPlayer) player;

        serverPlayer.teleport(serverPlayer.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING));
        level.playSound(null, serverPlayer.blockPosition(), LaLSounds.TABLET_TELEPORT, SoundSource.PLAYERS, 0.6f, 1f);

        if (serverPlayer.gameMode.getGameModeForPlayer().isCreative()) {
            return stack;
        }
        else {
            return ItemStack.EMPTY;
        }
    }
    
}