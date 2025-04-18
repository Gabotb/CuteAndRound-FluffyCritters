package net.gabotb.cuteandround.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.gabotb.cuteandround.entity.custom.LopBunnyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LopBunnyRenderer extends MobRenderer<LopBunnyEntity, LopBunnyModel<LopBunnyEntity>> {
    public LopBunnyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LopBunnyModel(pContext.bakeLayer(ModModelLayers.LOP_BUNNY_LAYER)), 0.5F);
    }

    public ResourceLocation getTextureLocation(LopBunnyEntity lopBunnyEntity) {
        return new ResourceLocation("cuteandround", "textures/entity/lop_bunny.png");
    }

    public void render(LopBunnyEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.6F, 0.6F, 0.6F);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}