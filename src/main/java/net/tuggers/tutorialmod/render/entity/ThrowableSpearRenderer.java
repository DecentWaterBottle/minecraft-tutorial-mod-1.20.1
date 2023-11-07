package net.tuggers.tutorialmod.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.tuggers.tutorialmod.TutorialMod;
import net.tuggers.tutorialmod.entity.client.ModModelLayers;
import net.tuggers.tutorialmod.item.custom.ThrowableSpearEntity;

// FROM MrCrayFish
//public class ThrowableSpearRenderer<T extends ThrowableSpearEntity> extends EntityRenderer<T>
public class ThrowableSpearRenderer extends EntityRenderer<ThrowableSpearEntity>
{

//    public static final ResourceLocation texture = new ResourceLocation("textures/entity/projectiles/arrow.png");

    public static final ResourceLocation SPEAR_LOCATION = new ResourceLocation(
            TutorialMod.MOD_ID, "textures/item/base_spear_texture.png");
    private final SpearStoneModel model;

    public ThrowableSpearRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SpearStoneModel(pContext.bakeLayer(ModModelLayers.THROWABLE_SPEAR_LAYER));
    }

    public void render(ThrowableSpearEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

        float degrees = pEntity.getRotationAnimation(pPartialTicks);

        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F - degrees));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render( pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);


    }

//    public void render(ThrowableSpearEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
//
//        float degrees = entityIn.getRotationAnimation(partialTicks);
//
//            float amplitude = 0.25F;
//            float offsetX = amplitude*(Mth.sin((float) Math.toRadians(degrees)));
//            float offsetY = amplitude*(1-Mth.cos((float) Math.toRadians(degrees)));
//            matrixStackIn.pushPose();
//
//            matrixStackIn.rotateAround(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 270.0F));
//            matrixStackIn.translate(offsetX, offsetY, 0.0F);
//            matrixStackIn.scale(1.5F, 1.5F, 1.5F);
//
//            matrixStackIn.rotateAround(Vector3f.ZP.rotationDegrees(degrees));
//
//            int count = entityIn.getItemStack().getCount();
//
//            Minecraft.getInstance().getItemRenderer().render(entityIn.getItem(), ItemCameraTransforms.TransformType.GROUND, packedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
//
//            if(count > 32) {
//                matrixStackIn.translate(0.05F, 0.05F, 0.05F);
//                Minecraft.getInstance().getItemRenderer().renderItem(entityIn.getItem(), ItemCameraTransforms.TransformType.GROUND, packedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
//            }
//
//            matrixStackIn.pop();
//    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(ThrowableSpearEntity pEntity) {
        return SPEAR_LOCATION;
    }


//    public ThrowableSpearRenderer(EntityRendererProvider.Context pContext) {
//        super(pContext);
//    }


//    @Override
//    public ResourceLocation getTextureLocation(ThrowableSpearEntity pEntity) {
//        return new ResourceLocation("textures/entity/projectiles/arrow.png");
////        return new ResourceLocation(TutorialMod.MOD_ID, "textures/item/diamond_sword.png");
//    }

////    private final ItemRenderer itemRenderer;
//    public static final ResourceLocation texture = new ResourceLocation(TutorialMod.MOD_ID, "textures/item/diamond_sword.png");
//    public static final RenderType render_type = RenderType.entityCutoutNoCull(texture);
//
//    public ThrowableSpearRenderer(EntityRendererProvider.Context context)
//    {
//        super(context);
////        this.itemRenderer = context.getItemRenderer();
////        super(pContext, new RhinoModel<>(pContext.bakeLayer(ModModelLayers.RHINO_LAYER)), 2f);
//    }
//
//    @Nullable
//    @Override
//    public ResourceLocation getTextureLocation(ThrowableSpearEntity entity)
//    {
//        return new ResourceLocation(TutorialMod.MOD_ID, "textures/item/diamond_sword.png");
//    }
//
//    @Override
//    public void render(ThrowableSpearEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light)
//    {
//        poseStack.pushPose();
////
//////        /* Makes the grenade face in the direction of travel */
//////        poseStack.mulPose(Axis.YP.rotationDegrees(180F));
//////        poseStack.mulPose(Axis.YP.rotationDegrees(entityYaw));
//////
//////        /* Offsets to the center of the grenade before applying rotation */
//////        float rotation = entity.prevRotation + (entity.rotation - entity.prevRotation) * partialTicks;
//////        poseStack.translate(0, 0.15, 0);
//////        poseStack.mulPose(Axis.XP.rotationDegrees(-rotation));
//////        poseStack.translate(0, -0.15, 0);
////
////        poseStack.translate(0.0, 0.5, 0.0);
//////        VertexConsumer vertexConsumer = renderTypeBuffer.getBuffer(this.itemRenderer.)
////
//////        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemDisplayContext.FIXED, light, OverlayTexture.NO_OVERLAY, poseStack, renderTypeBuffer, entity.level(), 0);
////        Minecraft.getInstance().getItemRenderer().renderItem(entity.getItem(), ItemCameraTransforms.TransformType.NONE, light, OverlayTexture.NO_OVERLAY, poseStack, renderTypeBuffer);
////        Minecraft.getInstance().getEntityRenderDispatcher().render(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F,
////                poseStack, renderTypeBuffer, light);
////
//        poseStack.popPose();
////
//        super.render(entity, entityYaw, partialTicks, poseStack, renderTypeBuffer, light);
//    }

}
