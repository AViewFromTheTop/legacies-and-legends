package net.legacy.legacies_and_legends.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

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

    }

    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {}

    public void everySecond(ItemStack stack, SlotReference slot, LivingEntity entity) {}

/*    public static final ResourceLocation TEMPT_RANGE_ID = LaLConstants.id("tempt_range");

    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, ResourceLocation resourceLocation) {
        var modifiers = super.getModifiers(stack, slot, entity, resourceLocation);
        if (stack.getItem() == LaLItems.AMULET_OF_ALLURE) {
            modifiers.put(Attributes.TEMPT_RANGE, new AttributeModifier(TEMPT_RANGE_ID, 10, AttributeModifier.Operation.ADD_VALUE));
        }
        return modifiers;
    }*/

}
