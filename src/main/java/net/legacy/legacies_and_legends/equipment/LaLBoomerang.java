package net.legacy.legacies_and_legends.equipment;

import net.legacy.legacies_and_legends.entity.LaLThrownBoomerang;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class LaLBoomerang extends Item implements ProjectileItem {
    public static final int THROW_THRESHOLD_TIME = 12;
    public static final float THROW_DAMAGE = 7.0F;
    public static final float BASE_DAMAGE = THROW_DAMAGE / 2;
    public static final float PROJECTILE_SHOOT_POWER = 2F;

    public LaLBoomerang(Item.Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, BASE_DAMAGE, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.9F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(), 1.0F, 2);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
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
                float f = EnchantmentHelper.getTridentSpinAttackStrength(stack, player);
                if (f > 0.0F && !player.isInWaterOrRain()) {
                    return false;
                } else if (stack.nextDamageWillBreak()) {
                    return false;
                } else {
                    Holder<SoundEvent> holder = (Holder<SoundEvent>)EnchantmentHelper.pickHighestLevel(stack, EnchantmentEffectComponents.TRIDENT_SOUND)
                            .orElse(LaLSounds.BOOMERANG_THROW);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (level instanceof ServerLevel serverLevel) {
                        stack.hurtWithoutBreaking(1, player);
                        if (f == 0.0F) {
                            LaLThrownBoomerang thrownBoomerang = Projectile.spawnProjectileFromRotation(LaLThrownBoomerang::new, serverLevel, stack, player, 0.0F, PROJECTILE_SHOOT_POWER, 1.0F);
                            if (player.hasInfiniteMaterials()) {
                                thrownBoomerang.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            } else {
                                player.getInventory().removeItem(stack);
                            }

                            level.playSound(null, thrownBoomerang, holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                            return true;
                        }
                    }

                    if (f > 0.0F) {
                        float g = player.getYRot();
                        float h = player.getXRot();
                        float j = -Mth.sin(g * (float) (Math.PI / 180.0)) * Mth.cos(h * (float) (Math.PI / 180.0));
                        float k = -Mth.sin(h * (float) (Math.PI / 180.0));
                        float l = Mth.cos(g * (float) (Math.PI / 180.0)) * Mth.cos(h * (float) (Math.PI / 180.0));
                        float m = Mth.sqrt(j * j + k * k + l * l);
                        j *= f / m;
                        k *= f / m;
                        l *= f / m;
                        player.push((double)j, (double)k, (double)l);
                        player.startAutoSpinAttack(20, 8.0F, stack);
                        if (player.onGround()) {
                            float n = 1.1999999F;
                            player.move(MoverType.SELF, new Vec3(0.0, 1.1999999F, 0.0));
                        }

                        level.playSound(null, player, holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.nextDamageWillBreak()) {
            return InteractionResult.FAIL;
        } else if (EnchantmentHelper.getTridentSpinAttackStrength(itemStack, player) > 0.0F && !player.isInWaterOrRain()) {
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
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        LaLThrownBoomerang thrownBoomerang = new LaLThrownBoomerang(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1));
        thrownBoomerang.pickup = AbstractArrow.Pickup.ALLOWED;
        return thrownBoomerang;
    }

}

