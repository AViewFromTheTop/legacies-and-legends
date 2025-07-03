package net.legacy.legacies_and_legends.entity.impl;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.world.level.Level;

import java.util.Optional;

public interface LaLPlayerPlatformInterface {
    void lal$setLastPlatformPos(Level level, BlockPos pos);
    void lal$eraseLastPlatformPos();
    Optional<GlobalPos> lal$getLastPlatformPos();
}
