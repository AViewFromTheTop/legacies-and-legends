package net.legacy.legacies_and_legends.mixin;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "getHurtSound", at = @At(value = "TAIL"))
    private void cancelTabletUse(DamageSource damageSource, CallbackInfoReturnable<SoundEvent> info) {
        Player player = Player.class.cast(this);
        if (player.getUseItem().getTags().anyMatch(Predicate.isEqual(LaLItemTags.TABLETS))) {
            player.stopUsingItem();
        }
    }
}
