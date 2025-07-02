package net.legacy.legacies_and_legends.mixin;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "actuallyHurt", at = @At(value = "TAIL"))
    private void cancelTabletUse(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (player.getUseItem().is(LaLItemTags.TABLETS)) player.stopUsingItem();
    }
}
