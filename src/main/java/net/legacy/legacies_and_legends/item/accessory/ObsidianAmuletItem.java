package net.legacy.legacies_and_legends.item.accessory;

import dev.emi.trinkets.api.SlotReference;
import net.legacy.legacies_and_legends.item.AmuletItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class ObsidianAmuletItem extends AmuletItem {

    @Override
    public int repairTicksFrequency() {
        return 20;
    }

    public int damageTicks = 0;
    public int damageTicksFrequency() {
        return 20;
    }

    public int secondsElapsed = 0;

    public ObsidianAmuletItem(Properties settings) {
        super(settings);
    }

    @Override
    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player) {
            if ((player.isInLava() || player.isOnFire()) && (!player.hasEffect(MobEffects.FIRE_RESISTANCE) || player.getTags().contains("infinite_fire_resistance"))) {
                if (stack.getDamageValue() != stack.getMaxDamage()) player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, MobEffectInstance.INFINITE_DURATION));
                if (player.getRemainingFireTicks() > 1) player.setRemainingFireTicks(1);
                player.addTag("infinite_fire_resistance");
                player.addTag("should_damage_amulet");
            }
            else resetData(player);
        }
    }

    @Override
    public void shouldDamageAmulet(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player) {
            repairTicks = 0;
            damageTicks = damageTicks + 1;
            if (damageTicks >= damageTicksFrequency() && player.isInLava()) {
                damageTicks = 0;
                damageAccessory(stack, slot, player, 1);
            }
            else if (damageTicks >= damageTicksFrequency() * 2 && !player.isInLava() && player.isOnFire()) {
                damageTicks = 0;
                damageAccessory(stack, slot, player, 1);
            }
            else damageTicks = 0;
        }
    }

    @Override
    public void resetData(LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            if (player.getTags().contains("infinite_fire_resistance")) player.removeEffect(MobEffects.FIRE_RESISTANCE);
            player.removeTag("infinite_fire_resistance");
            player.removeTag("should_damage_amulet");
        }
    }

    @Override
    public void everySecond(ItemStack stack, SlotReference slot, LivingEntity entity) {
        secondsElapsed = secondsElapsed + 1;
        if (secondsElapsed >= 3) {
            if (entity instanceof Player player && stack.getDamageValue() != stack.getMaxDamage() && stack.getDamageValue() != stack.getMaxDamage()) {
                if ((player.isInLava() || player.isOnFire()) && player.getTags().contains("infinite_fire_resistance") && !player.fireImmune()) {
                    if (player.isInLava()) player.playSound(SoundEvents.LAVA_EXTINGUISH);
                    else if (player.isOnFire() || player.getInBlockState().is(Blocks.FIRE))
                        player.playSound(SoundEvents.FIRE_EXTINGUISH);
                }
            }
            secondsElapsed = 0;
        }
    }
}