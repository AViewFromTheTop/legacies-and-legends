package net.legacy.legacies_and_legends.equipment;

import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class WandItem extends Item {
    public BlockPos platformPos = new BlockPos(0,0,0);
    public BlockState replacedState = Blocks.AIR.defaultBlockState();
    public boolean initialized = false;

    public WandItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level.getBlockState(this.platformPos) == LaLBlocks.SAPPHIRE_PLATFORM.defaultBlockState() && level.getBlockState(this.platformPos) != level.getBlockState(player.blockPosition().below())) {
            level.scheduleTick(this.platformPos, level.getBlockState(this.platformPos).getBlock(), 5);
        }
        if (level.getBlockState(player.blockPosition().below()) == Blocks.AIR.defaultBlockState() || level.getBlockState(player.blockPosition().below()) == Blocks.CAVE_AIR.defaultBlockState()) {
            this.platformPos = player.blockPosition().below();
            this.replacedState = level.getBlockState(this.platformPos);
            level.setBlock(this.platformPos, LaLBlocks.SAPPHIRE_PLATFORM.defaultBlockState(), Block.UPDATE_ALL);
            if (player.getUsedItemHand() == InteractionHand.MAIN_HAND) {
                player.getUseItem().hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            }
            else if (player.getUsedItemHand() == InteractionHand.OFF_HAND) {
                player.getUseItem().hurtAndBreak(1, player, EquipmentSlot.OFFHAND);
            }
            player.getUseItem().applyComponents(DataComponentMap.builder()
                    .set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(false), List.of(), List.of()))
                    .build());
            if (!this.initialized) {
                this.initialized = true;
            }
            return InteractionResult.SUCCESS;
        }
        else {
            return InteractionResult.FAIL;
        }
    }

}
