package net.legacy.legacies_and_legends.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class AccessoryItem extends TrinketItem implements Trinket {

    public int secondTicks = 0;

    public AccessoryItem(Properties settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        everyTick(stack, slot, entity);
        secondTicks = secondTicks + 1;
        if (secondTicks >= 20) {
            secondTicks = 0;
            everySecond(stack, slot, entity);
        }

        if (entity instanceof Player player && player.getTags().contains("damaged_accessory")) {
            damageAccessory(stack, slot, player, 1);
            player.removeTag("damaged_accessory");
        }
    }

    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {}

    public void everySecond(ItemStack stack, SlotReference slot, LivingEntity entity) {}

    public void damageAccessory(ItemStack stack, SlotReference slot, Player player, int amount) {
        if (player.isCreative()) return;
        ItemStack accessoryItem = getAccessory(stack, slot, player);
        accessoryItem.setDamageValue(accessoryItem.getDamageValue() + amount);
        if (accessoryItem.getDamageValue() >= accessoryItem.getMaxDamage()) {
            resetData(player);
            slot.inventory().removeItem(slot.index(), amount);
        }
    }

    public static void repairAccessory(ItemStack stack, SlotReference slot, Player player, int amount) {
        ItemStack accessoryItem = getAccessory(stack, slot, player);
        accessoryItem.setDamageValue(accessoryItem.getDamageValue() - amount);
        if (accessoryItem.getDamageValue() <= 0) accessoryItem.setDamageValue(0);
    }

    @Override
    public void onBreak(ItemStack stack, SlotReference slot, LivingEntity entity) {
        resetData(entity);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        resetData(entity);
    }

    public void resetData(LivingEntity entity) {}

    public static ItemStack getAccessory(ItemStack stack, SlotReference slot, Player player) {
        return TrinketsApi.getTrinketComponent(player).get().getEquipped(stack.getItem()).get(slot.index()).getB();
    }
}
