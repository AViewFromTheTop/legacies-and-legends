package net.legacy.legacies_and_legends.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.entity.LaLThrownBoomerang;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.state.ThrownTridentRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class LaLThrownBoomerangRenderer extends EntityRenderer<LaLThrownBoomerang, ThrownTridentRenderState> {
    public static final ResourceLocation BOOMERANG_LOCATION = ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID,"textures/entity/boomerang.png");
    private final LaLBoomerangModel model;



    public LaLThrownBoomerangRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new LaLBoomerangModel(context.bakeLayer(LaLModelLayers.THROWN_BOOMERANG));
    }

    public void render(ThrownTridentRenderState thrownTridentRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(thrownTridentRenderState.yRot - 45));
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBuffer(multiBufferSource, this.model.renderType(BOOMERANG_LOCATION), false, thrownTridentRenderState.isFoil);
        this.model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(thrownTridentRenderState, poseStack, multiBufferSource, i);
    }

    public ThrownTridentRenderState createRenderState() {
        return new ThrownTridentRenderState();
    }

    public void extractRenderState(LaLThrownBoomerang thrownBoomerang, ThrownTridentRenderState thrownTridentRenderState, float f) {
        super.extractRenderState(thrownBoomerang, thrownTridentRenderState, f);
        thrownTridentRenderState.yRot = thrownBoomerang.getYRot(f);
        thrownTridentRenderState.xRot = thrownBoomerang.getXRot(f);
        thrownTridentRenderState.isFoil = thrownBoomerang.isFoil();
    }
}
