package net.legacy.legacies_and_legends.mixin.integration.friendsandfoes;

import com.faboslav.friendsandfoes.common.item.TotemItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(TotemItem.class)
public abstract class FriendsAndFoesTotemItemMixin {

    @Inject(method = "appendHoverText", at = @At(value = "HEAD"), cancellable = true)
    private void totemShiftDescription(ItemStack itemStack, Item.TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, Consumer<Component> consumer, TooltipFlag tooltipFlag, CallbackInfo ci) {
        if (!Screen.hasShiftDown()) ci.cancel();
    }
}
