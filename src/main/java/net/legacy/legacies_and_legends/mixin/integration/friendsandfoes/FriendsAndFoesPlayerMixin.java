package net.legacy.legacies_and_legends.mixin.integration.friendsandfoes;

import com.faboslav.friendsandfoes.common.init.FriendsAndFoesItems;
import com.faboslav.friendsandfoes.common.init.FriendsAndFoesParticleTypes;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.integration.FriendsAndFoesTotemUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class FriendsAndFoesPlayerMixin {

    @Inject(method = "actuallyHurt", at = @At(value = "TAIL"))
    private void activateTotem(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()) && player.getHealth() <= player.getMaxHealth() / 2) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.freezeEntities(player, level);
                FriendsAndFoesTotemUtil.playActivateAnimation(player, FriendsAndFoesParticleTypes.TOTEM_OF_FREEZING.get());
                FriendsAndFoesTotemUtil.playActivateAnimationOnly(FriendsAndFoesItems.TOTEM_OF_FREEZING.get().getDefaultInstance());
                player.addTag("used_totem");
            }
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()) && player.getHealth() <= player.getMaxHealth() / 2) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.createIllusions(player, level);
                com.faboslav.friendsandfoes.common.util.TotemUtil.playActivateAnimation(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get().getDefaultInstance(), player, FriendsAndFoesParticleTypes.TOTEM_OF_ILLUSION.get());
                FriendsAndFoesTotemUtil.playActivateAnimation(player, FriendsAndFoesParticleTypes.TOTEM_OF_ILLUSION.get());
                FriendsAndFoesTotemUtil.playActivateAnimationOnly(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get().getDefaultInstance());
                player.addTag("used_totem");
            }
        }
    }
}
