package net.legacy.legacies_and_legends.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class LaLBoomerangModel<T extends Entity> extends EntityModel {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID,"textures/entity/boomerang.png");

    public LaLBoomerangModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition partDefinition2 = partDefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -24.0F, 1.0F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        partDefinition2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 4).addBox(-9.0F, -24.0F, -1.0F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 3.0F, 0.0F, -1.5708F, 0.0F));
        return LayerDefinition.create(meshDefinition, 32, 32);
    }

}

