package net.legacy.legacies_and_legends.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;
import java.util.Random;

public class EvasionAccessoryItem extends AccessoryItem implements Trinket {

    public int secondsElapsed = 0;

    public EvasionAccessoryItem(Properties settings) {
        super(settings);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && stack.is(LaLItems.RING_OF_EVASION)) {
            if (player.getTags().contains("infinite_invisibility")) player.removeEffect(MobEffects.INVISIBILITY);
            if (player.getTags().contains("infinite_speed")) player.removeEffect(MobEffects.SPEED);
        }
    }

    @Override
    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_EVASION)) {
            if (player.isShiftKeyDown() && !player.hasEffect(MobEffects.INVISIBILITY)) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, MobEffectInstance.INFINITE_DURATION));
                player.addTag("infinite_invisibility");
            }
            else if (!player.isShiftKeyDown() && player.getTags().contains("infinite_invisibility")) {
                player.removeEffect(MobEffects.INVISIBILITY);
                player.removeTag("infinite_invisibility");
            }
            if (player.isShiftKeyDown() && !player.hasEffect(MobEffects.SPEED)) {
                player.addEffect(new MobEffectInstance(MobEffects.SPEED, MobEffectInstance.INFINITE_DURATION));
                player.addTag("infinite_speed");
            }
            else if (!player.isShiftKeyDown() && player.getTags().contains("infinite_speed")) {
                player.removeEffect(MobEffects.SPEED);
                player.removeTag("infinite_speed");
            }
        }
    }

    @Override
    public void everySecond(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player) {
            ItemStack trinketStack = TrinketsApi.getTrinketComponent(player).get().getEquipped(LaLItems.RING_OF_EVASION).get(slot.index()).getB();
            if (player.isShiftKeyDown() && new Random().nextInt(10) >= 9 && (player.getTags().contains("infinite_invisibility") || player.getTags().contains("infinite_speed"))) {
                if (trinketStack.is(LaLItems.RING_OF_EVASION)) {
                    trinketStack.setDamageValue(trinketStack.getDamageValue() + 1);
                }
            }
            if (trinketStack.getDamageValue() >= trinketStack.getMaxDamage())
                slot.inventory().removeItem(slot.index(), 1);
        }
    }
}
