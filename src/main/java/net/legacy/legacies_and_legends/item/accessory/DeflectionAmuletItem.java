package net.legacy.legacies_and_legends.item.accessory;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.entity.impl.LaLPlayerDamageInterface;
import net.legacy.legacies_and_legends.item.AmuletItem;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DeflectionAmuletItem extends AmuletItem {

    @Override
    public Item getItem() {
        return LaLItems.AMULET_OF_DEFLECTION;
    }

    @Override
    public int repairTicksFrequency() {
        return 20;
    }

    @Override
    public int repairCooldownTicksFrequency() {
        return 200;
    }

    public DeflectionAmuletItem(Properties settings) {
        super(settings);
    }

    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && player.getTags().contains("damaged_amulet_of_deflection")) {
                damageAccessory(stack, slot, player, 10);
                player.removeTag("damaged_amulet_of_deflection");
            }
        }

    @Override
    public void resetData(LivingEntity entity) {
        if (entity instanceof Player player) {
            player.removeTag("damaged_amulet_of_deflection");
            player.removeTag("amulet_repair_cooldown");
            player.removeTag("repaired_amulet");
            repairTicks = 0;
        }
    }
}