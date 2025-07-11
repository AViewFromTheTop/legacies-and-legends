package net.legacy.legacies_and_legends.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;

import java.util.List;
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

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltipDisplay, consumer, tooltipFlag);
        if (Screen.hasShiftDown()) consumer.accept(Component.translatable(itemStack.getItemName().getString() + ".desc").withStyle(ChatFormatting.DARK_GRAY));
    }
}
