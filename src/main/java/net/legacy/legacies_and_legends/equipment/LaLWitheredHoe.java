package net.legacy.legacies_and_legends.equipment;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LaLWitheredHoe extends DiggerItem {
    protected static final Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> TILLABLES = Maps.<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>>newHashMap(
            ImmutableMap.of(
                    Blocks.WARPED_NYLIUM,
                    Pair.of(HoeItem::onlyIfAirAbove, changeIntoState(Blocks.NETHERRACK.defaultBlockState())),
                    Blocks.CRIMSON_NYLIUM,
                    Pair.of(HoeItem::onlyIfAirAbove, changeIntoState(Blocks.NETHERRACK.defaultBlockState())),
                    Blocks.NETHERRACK,
                    Pair.of(HoeItem::onlyIfAirAbove, changeIntoState(Blocks.SOUL_SOIL.defaultBlockState())),
                    Blocks.SOUL_SOIL,
                    Pair.of(HoeItem::onlyIfAirAbove, changeIntoState(Blocks.SOUL_SAND.defaultBlockState()))
            )
    );

    public LaLWitheredHoe(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(material, BlockTags.MINEABLE_WITH_HOE, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = (Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>)TILLABLES.get(
                level.getBlockState(blockPos).getBlock()
        );
        if (pair == null) {
            return InteractionResult.PASS;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(context)) {
                Player player = context.getPlayer();
                level.playSound(player, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide) {
                    consumer.accept(context);
                    if (player != null) {
                        context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }

                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    public static Consumer<UseOnContext> changeIntoState(BlockState state) {
        return useOnContext -> {
            useOnContext.getLevel().setBlock(useOnContext.getClickedPos(), state, 11);
            useOnContext.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, useOnContext.getClickedPos(), GameEvent.Context.of(useOnContext.getPlayer(), state));
        };
    }

    public static Consumer<UseOnContext> changeIntoStateAndDropItem(BlockState state, ItemLike itemToDrop) {
        return useOnContext -> {
            useOnContext.getLevel().setBlock(useOnContext.getClickedPos(), state, 11);
            useOnContext.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, useOnContext.getClickedPos(), GameEvent.Context.of(useOnContext.getPlayer(), state));
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(itemToDrop));
        };
    }

    public static boolean onlyIfAirAbove(UseOnContext context) {
        return context.getClickedFace() != Direction.DOWN && context.getLevel().getBlockState(context.getClickedPos().above()).isAir();
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0), attacker);
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }
}
