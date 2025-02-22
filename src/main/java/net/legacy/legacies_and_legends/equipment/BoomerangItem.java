package net.legacy.legacies_and_legends.equipment;

import net.legacy.legacies_and_legends.entity.BoomerangProjectile;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BoomerangItem extends Item implements ProjectileItem {
    public static final int THROW_THRESHOLD_TIME = 10;
    public static final float THROW_DAMAGE = 7F;
    public static final float BASE_DAMAGE = THROW_DAMAGE / 2;
    public static final float PROJECTILE_SHOOT_POWER = 2F;

    public BoomerangItem(Item.Properties properties) {
        super(properties);
    }

    public static @NotNull ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, BASE_DAMAGE, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -1.8F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Contract(" -> new")
    public static @NotNull Tool createToolProperties() {
        return new Tool(List.of(), 1F, 2);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, @NotNull Player player) {
        return !player.isCreative();
    }

    @Override
    public @NotNull ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.SPEAR;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack, entity) - timeLeft;
            if (i < THROW_THRESHOLD_TIME) {
                return false;
            } else {
               if (stack.nextDamageWillBreak()) {
                    return false;
               } else {
                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (level instanceof ServerLevel serverLevel) {
                        stack.hurtWithoutBreaking(1, player);
                        BoomerangProjectile thrownBoomerang = Projectile.spawnProjectileFromRotation(
                                BoomerangProjectile::new,
                                serverLevel,
                                stack,
                                player,
                                0F,
                                PROJECTILE_SHOOT_POWER,
                                1F
                        );
                        if (player.hasInfiniteMaterials()) {
                            thrownBoomerang.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        } else {
                            player.getInventory().removeItem(stack);
                        }

                        level.playSound(null, thrownBoomerang, LaLSounds.BOOMERANG_THROW, SoundSource.PLAYERS, 1F, 1F);
                        return true;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public @NotNull InteractionResult use(Level level, @NotNull Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.nextDamageWillBreak()) {
            return InteractionResult.FAIL;
        } else {
            player.startUsingItem(hand);
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public void postHurtEnemy(@NotNull ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public @NotNull Projectile asProjectile(Level level, @NotNull Position pos, @NotNull ItemStack stack, Direction direction) {
        BoomerangProjectile thrownBoomerang = new BoomerangProjectile(level, pos.x(), pos.y(), pos.z(), stack);
        thrownBoomerang.pickup = AbstractArrow.Pickup.ALLOWED;
        return thrownBoomerang;
    }

}

