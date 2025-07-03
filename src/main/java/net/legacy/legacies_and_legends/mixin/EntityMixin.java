package net.legacy.legacies_and_legends.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.legacy.legacies_and_legends.entity.impl.LaLPlayerPlatformInterface;
import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.TeleportTransition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Entity.class)
public abstract class EntityMixin {

	@Shadow public abstract boolean addTag(String tag);

	@Inject(
			method = "teleport",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/entity/Entity;teleportCrossDimension(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/level/portal/TeleportTransition;)Lnet/minecraft/world/entity/Entity;"
			)
	)
	public void removePlatformOnDimensionChange(
			TeleportTransition dimensionTransition,
			CallbackInfoReturnable<Entity> info,
			@Local(ordinal = 0) ServerLevel level
	) {
		if (!(Entity.class.cast(this) instanceof LaLPlayerPlatformInterface platformInterface)) return;

		Optional<GlobalPos> globalPos = platformInterface.lal$getLastPlatformPos();
		if (globalPos.isEmpty()) return;

		GlobalPos lastPlatformPos = globalPos.get();
		if (!lastPlatformPos.dimension().equals(level.dimension())) return;
		level.scheduleTick(lastPlatformPos.pos(), LaLBlocks.WAND_PLATFORM, 5);

		if (Entity.class.cast(this) instanceof Player player) {
			player.removeTag("legacies_and_legends:wand_platform_summoned");
		}
	}

	@Inject(method = "remove", at = @At("HEAD"))
	public void removePlatformOnRemove(Entity.RemovalReason reason, CallbackInfo info) {
		if (!(Entity.class.cast(this) instanceof LaLPlayerPlatformInterface platformInterface)) return;

		Optional<GlobalPos> globalPos = platformInterface.lal$getLastPlatformPos();
		if (globalPos.isEmpty()) return;

		GlobalPos lastPlatformPos = globalPos.get();
		Level level = Entity.class.cast(this).level();
		if (!lastPlatformPos.dimension().equals(level.dimension())) return;
		level.scheduleTick(lastPlatformPos.pos(), LaLBlocks.WAND_PLATFORM, 5);

		if (Entity.class.cast(this) instanceof Player player) {
			player.removeTag("legacies_and_legends:wand_platform_summoned");
		}
	}

}
