package net.legacy.legacies_and_legends.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SapphirePlatformBlock extends SlabBlock {

    public SapphirePlatformBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void tick(BlockState state, @NotNull ServerLevel level, BlockPos pos, RandomSource random) {
        level.destroyBlock(pos, false);
    }
}
