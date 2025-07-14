package net.legacy.legacies_and_legends.mixin.entity;

import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.registry.LaLMobEffects;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.legacy.legacies_and_legends.tag.LaLEntityTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Projectile.class)
public abstract class ProjectileMixin {

    @Shadow private @Nullable Entity lastDeflectedBy;

    @Shadow public abstract @Nullable Entity getOwner();

    @Shadow public abstract boolean deflect(ProjectileDeflection deflection, @Nullable Entity entity, @Nullable Entity owner, boolean deflectedByPlayer);

    @Inject(method = "canHitEntity", at = @At(value = "HEAD"), cancellable = true)
    public void warpingTeleport(Entity target, CallbackInfoReturnable<Boolean> cir) {
            if (target instanceof Player player && player.hasEffect(LaLMobEffects.WARPING)) {
                double d = player.getX() + (player.getRandom().nextDouble() - 0.5) * (double) 16F;
                double e = Mth.clamp(player.getY() + (player.getRandom().nextDouble() - 0.5) * (double) 16F, player.level.getMinY(), (player.level.getMinY() + ((ServerLevel) player.level).getLogicalHeight() - 1));
                double f = player.getZ() + (player.getRandom().nextDouble() - 0.5) * (double) 16F;
                if (player.isPassenger()) {
                    player.stopRiding();
                }

                Vec3 vec3 = player.position();
                if (player.randomTeleport(d, e, f, true)) {
                    player.level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(player));
                }
                cir.setReturnValue(false);
            }
    }

    @Inject(method = "hitTargetOrDeflectSelf", at = @At(value = "HEAD"), cancellable = true)
    public void amuletOfDeflection(HitResult hitResult, CallbackInfoReturnable<ProjectileDeflection> cir) {
        Projectile projectile = Projectile.class.cast(this);
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHitResult = (EntityHitResult) hitResult;
            Entity entity = entityHitResult.getEntity();
            if (entity instanceof Player player && TrinketsApi.getTrinketComponent(player).isPresent() && TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.AMULET_OF_DEFLECTION)) {
                ProjectileDeflection projectileDeflection = ProjectileDeflection.MOMENTUM_DEFLECT;
                if (entity != this.lastDeflectedBy && this.deflect(projectileDeflection, entity, this.getOwner(), false)) {
                    this.lastDeflectedBy = entity;
                }
                if (!projectile.getType().is(LaLEntityTags.DAMAGELESS_PROJECTILES)) {
                    player.addTag("damaged_amulet_of_deflection");
                    player.addTag("amulet_repair_cooldown");
                    player.playSound(LaLSounds.BOOMERANG_RETURN);
                }
                cir.setReturnValue(projectileDeflection);
            }
        }
    }
}
