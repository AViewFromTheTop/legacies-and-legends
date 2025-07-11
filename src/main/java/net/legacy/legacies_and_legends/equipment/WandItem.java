package net.legacy.legacies_and_legends.equipment;

import net.legacy.legacies_and_legends.block.SapphirePlatformBlock;
import net.legacy.legacies_and_legends.entity.impl.LalPlayerPlatformInterface;
import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class WandItem extends Item {

    public WandItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, @NotNull Player player, InteractionHand hand) {
        if (!(player instanceof LalPlayerPlatformInterface platformInterface)) return InteractionResult.PASS;

        ItemStack stack = player.getItemInHand(hand);

        Optional<GlobalPos> optionalLastPlatformPos = platformInterface.lal$getLastPlatformPos();
        if (optionalLastPlatformPos.isPresent()) {
            GlobalPos lastPlatformPos = optionalLastPlatformPos.get();
            if (lastPlatformPos.dimension().equals(level.dimension())) {
                BlockPos lastPlatformBlockPos = lastPlatformPos.pos();
                if (!player.onGround() || player.getOnPos() != lastPlatformBlockPos) {
                    level.scheduleTick(lastPlatformBlockPos, LaLBlocks.SAPPHIRE_PLATFORM, 5);
                } else {
                    return InteractionResult.FAIL;
                }
            }
        }

        Vec3 playerPos = player.position();
        BlockPos newPlatformPos = player.blockPosition();
        boolean useBottomSlab = false;
        if (playerPos.y() - newPlatformPos.getY() >= 0.5D && level.getBlockState(newPlatformPos).isAir()) {
            useBottomSlab = true;
        } else {
            newPlatformPos = newPlatformPos.below();
        }

        if (useBottomSlab || level.getBlockState(newPlatformPos).isAir()) {
            platformInterface.lal$setLastPlatformPos(level, newPlatformPos);
            level.setBlock(
                    newPlatformPos,
                    LaLBlocks.SAPPHIRE_PLATFORM.defaultBlockState().setValue(SapphirePlatformBlock.TYPE, useBottomSlab ? SlabType.BOTTOM : SlabType.TOP),
                    Block.UPDATE_ALL
            );

            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));

            // what is this lol
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(false), List.of(), List.of()))
                    .build()
            );

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }

}
