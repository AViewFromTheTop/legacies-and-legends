package net.legacy.legacies_and_legends.item.accessory;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.item.AccessoryItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class PurityNecklaceItem extends AccessoryItem {

    public PurityNecklaceItem(Properties settings) {
        super(settings);
    }

    @Override
    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (!player.getActiveEffects().isEmpty()) {
                player.removeAllEffects();
                damageAccessory(stack, slot, player, 1);
            }
        }
    }
}
