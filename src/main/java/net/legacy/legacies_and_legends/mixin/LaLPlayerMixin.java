package net.legacy.legacies_and_legends.mixin;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(Player.class)
public abstract class LaLPlayerMixin extends LivingEntity {
    protected LaLPlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "getHurtSound", at = @At(value = "TAIL"))
    private void cancelTabletUse(DamageSource damageSource, CallbackInfoReturnable<SoundEvent> cir) {
        if (this.getUseItem().getTags().anyMatch(Predicate.isEqual(LaLItemTags.TABLETS))) {
                this.stopUsingItem();
        }
    }
}
