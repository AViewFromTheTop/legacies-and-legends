package net.legacy.legacies_and_legends.item.accessory;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.item.AccessoryItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

public class ProtectionNecklaceItem extends AccessoryItem {

    public ProtectionNecklaceItem(Properties settings) {
        super(settings);
    }

    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, ResourceLocation resourceLocation) {
        var modifiers = super.getModifiers(stack, slot, entity, resourceLocation);
            modifiers.put(Attributes.ARMOR, new AttributeModifier(LaLConstants.id("armor"), 1, AttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }
}
