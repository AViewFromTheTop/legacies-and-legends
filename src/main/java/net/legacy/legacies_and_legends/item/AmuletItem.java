package net.legacy.legacies_and_legends.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AmuletItem extends AccessoryItem implements Trinket {

    public int repairTicks = 0;
    public int repairTicksFrequency() {
        return 20;
    }

    public AmuletItem(Properties settings) {
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

        if (entity instanceof Player player) {
            if (player.getTags().contains("should_damage_amulet")) shouldDamageAmulet(stack, slot, entity);
            else {
                repairTicks = repairTicks + 1;
                if (repairTicks >= repairTicksFrequency()) {
                    repairTicks = 0;
                    repairAccessory(stack, slot, player, 1);
                }
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        amuletInventoryTick(stack, level, entity, slot);
        repairTicks = repairTicks + 1;
        if (repairTicks >= repairTicksFrequency()) {
            repairTicks = 0;
            stack.setDamageValue(stack.getDamageValue() - 1);
            if (stack.getDamageValue() <= 0) stack.setDamageValue(0);
        }
    }

    public void amuletInventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {}

    public void shouldDamageAmulet(ItemStack stack, SlotReference slot, LivingEntity entity) {
        repairTicks = 0;
    }
}
