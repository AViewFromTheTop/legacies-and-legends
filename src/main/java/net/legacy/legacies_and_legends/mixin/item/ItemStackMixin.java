package net.legacy.legacies_and_legends.mixin.item;

import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;
import java.util.random.RandomGenerator;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow public abstract Item getItem();

    @Shadow public abstract void applyComponents(DataComponentMap components);

    @Shadow public abstract boolean is(TagKey<Item> tag);

    @Inject(at = @At("HEAD"), method = "finishUsingItem")
    private void useTablet(Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
        if (this.is(LaLItemTags.TABLETS)) {
            if (new Random().nextInt(5) >= 1) {
                this.applyComponents(DataComponentMap.builder()
                        .set(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStack(LaLItems.TABLET)))
                        .build()
                );
            }
        }
    }
}