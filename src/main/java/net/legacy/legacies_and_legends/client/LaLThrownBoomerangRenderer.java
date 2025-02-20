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
public class LaLThrownBoomerangRenderer extends EntityRenderer<LaLThrownBoomerang, LaLThrownBoomerangRenderState> {
    public static final ResourceLocation BOOMERANG_LOCATION = ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID,"textures/entity/boomerang.png");
    private final LaLBoomerangModel model;



    public LaLThrownBoomerangRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new LaLBoomerangModel(context.bakeLayer(LaLModelLayers.THROWN_BOOMERANG));
    }


    public void render(LaLThrownBoomerangRenderState thrownBoomerangRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(thrownBoomerangRenderState.yRot - 45));
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBuffer(multiBufferSource, this.model.renderType(BOOMERANG_LOCATION), false, thrownBoomerangRenderState.isFoil);
        this.model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(thrownBoomerangRenderState, poseStack, multiBufferSource, i);
    }


    public LaLThrownBoomerangRenderState createRenderState() {
        return new LaLThrownBoomerangRenderState();
    }

    public void extractRenderState(LaLThrownBoomerang thrownBoomerang, LaLThrownBoomerangRenderState thrownBoomerangRenderState, float f) {
        super.extractRenderState(thrownBoomerang, thrownBoomerangRenderState, f);
        thrownBoomerangRenderState.yRot = thrownBoomerang.getYRot(f);
        thrownBoomerangRenderState.xRot = thrownBoomerang.getXRot(f);
        thrownBoomerangRenderState.isFoil = thrownBoomerang.isFoil();
    }
}
