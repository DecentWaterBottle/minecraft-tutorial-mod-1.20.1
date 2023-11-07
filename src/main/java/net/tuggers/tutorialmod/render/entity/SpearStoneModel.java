package net.tuggers.tutorialmod.render.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class SpearStoneModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "spear_stone_converted"), "main");
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart pommel;

    public SpearStoneModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.pommel = root.getChild("pommel");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition guard = head.addOrReplaceChild("guard", CubeListBuilder.create().texOffs(5, 2).addBox(-1.5F, -18.5F, -0.4F, 3.0F, 0.15F, 0.8F, new CubeDeformation(0.0F))
                .texOffs(6, 6).addBox(-1.25F, -18.4F, -0.25F, 2.5F, 0.15F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(7, 8).addBox(-1.0F, -18.3F, -0.25F, 2.0F, 0.15F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-0.75F, -18.2F, -0.25F, 1.5F, 0.15F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(14, 14).addBox(-0.5F, -18.05F, -0.25F, 1.0F, 0.15F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition blade = head.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(14, 14).addBox(-0.25F, -19.65F, -0.1F, 0.5F, 1.4F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(15, 10).addBox(-0.75F, -19.9F, -0.1F, 1.5F, 0.25F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(5, 6).mirror().addBox(-1.0F, -20.1F, -0.2F, 2.0F, 0.25F, 0.4F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(6, 3).mirror().addBox(-1.4F, -20.3F, -0.2F, 2.8F, 0.25F, 0.4F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(7, 6).mirror().addBox(-1.3F, -20.55F, -0.2F, 2.6F, 0.25F, 0.4F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(8, 9).mirror().addBox(-1.2F, -20.8F, -0.1F, 2.4F, 0.25F, 0.2F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(9, 11).mirror().addBox(-1.1F, -21.05F, -0.1F, 2.2F, 0.25F, 0.2F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(10, 2).mirror().addBox(-1.0F, -21.3F, -0.1F, 2.0F, 0.25F, 0.2F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 5).mirror().addBox(-0.9F, -21.55F, -0.1F, 1.8F, 0.25F, 0.2F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(12, 12).mirror().addBox(-0.8F, -21.8F, -0.1F, 1.6F, 0.25F, 0.2F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(12, 13).addBox(-0.7F, -22.05F, -0.1F, 1.4F, 0.25F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(15, 2).addBox(-0.6F, -22.3F, -0.1F, 1.2F, 0.25F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(16, 16).addBox(-0.5F, -22.55F, -0.1F, 1.0F, 0.25F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(16, 16).addBox(-0.4F, -22.8F, -0.1F, 0.8F, 0.25F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(16, 16).addBox(-0.3F, -23.05F, -0.1F, 0.6F, 0.25F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(16, 16).addBox(-0.1F, -23.55F, -0.1F, 0.2F, 0.25F, 0.2F, new CubeDeformation(0.0F))
                .texOffs(17, 3).addBox(-0.2F, -23.3F, -0.1F, 0.4F, 0.25F, 0.2F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 9).addBox(-0.3F, -17.9F, -0.25F, 0.6F, 23.9F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition pommel = partdefinition.addOrReplaceChild("pommel", CubeListBuilder.create().texOffs(11, 13).addBox(-0.65F, 6.0F, -0.65F, 1.3F, 0.5F, 1.3F, new CubeDeformation(0.0F))
                .texOffs(7, 9).addBox(-0.5F, 6.25F, -0.5F, 1.0F, 0.75F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).addBox(-0.4F, 6.75F, -0.4F, 0.8F, 0.75F, 0.8F, new CubeDeformation(0.0F))
                .texOffs(14, 14).addBox(-0.3F, 7.25F, -0.3F, 0.6F, 0.75F, 0.6F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        pommel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}