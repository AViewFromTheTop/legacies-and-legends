package net.legacy.legacies_and_legends.equipment;

import com.google.common.collect.BiMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CleavingBattleAxeItem extends Item {

    public CleavingBattleAxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public void postHurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0), attacker);
    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();
        if (playerHasBlockingItemUseIntent(context)) {
            return InteractionResult.PASS;
        } else {
            Optional<BlockState> optional = this.evaluateNewBlockState(level, blockPos, player, level.getBlockState(blockPos));
            if (optional.isEmpty()) {
                return InteractionResult.PASS;
            } else {
                ItemStack itemStack = context.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
                }

                level.setBlock(blockPos, (BlockState)optional.get(), 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, (BlockState)optional.get()));
                if (player != null) {
                    itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                }

                return InteractionResult.SUCCESS;
            }
        }
    }

    private static boolean playerHasBlockingItemUseIntent(UseOnContext context) {
        Player player = context.getPlayer();
        return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().has(DataComponents.BLOCKS_ATTACKS) && !player.isSecondaryUseActive();
    }

    private Optional<BlockState> evaluateNewBlockState(Level level, BlockPos pos, @Nullable Player player, BlockState state) {
        Optional<BlockState> optional = this.getStripped(state);
        if (optional.isPresent()) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional2 = WeatheringCopper.getPrevious(state);
            if (optional2.isPresent()) {
                level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, pos, 0);
                return optional2;
            } else {
                Optional<BlockState> optional3 = Optional.ofNullable((Block)((BiMap) HoneycombItem.WAX_OFF_BY_BLOCK.get()).get(state.getBlock())).map((block) -> {
                    return block.withPropertiesOf(state);
                });
                if (optional3.isPresent()) {
                    level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.levelEvent(player, 3004, pos, 0);
                    return optional3;
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    private Optional<BlockState> getStripped(BlockState unstrippedState) {
        return Optional.ofNullable((Block)AxeItem.STRIPPABLES.get(unstrippedState.getBlock())).map((block) -> {
            return (BlockState)block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, (Direction.Axis)unstrippedState.getValue(RotatedPillarBlock.AXIS));
        });
    }
}
