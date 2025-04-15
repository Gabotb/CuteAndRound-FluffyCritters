package net.gabotb.cuteandround.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.gabotb.cuteandround.CuteAndRound;
import net.gabotb.cuteandround.entity.custom.LopBunnyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LopBunnyRenderer extends MobRenderer<LopBunnyEntity, LopBunnyModel<LopBunnyEntity>> {
    public LopBunnyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LopBunnyModel<>(pContext.bakeLayer(ModModelLayers.LOP_BUNNY_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(LopBunnyEntity lopBunnyEntity) {
        return new ResourceLocation(CuteAndRound.MOD_ID, "textures/entity/lop_bunny.png");
    }

    @Override
    public void render(LopBunnyEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.6f,0.6f,0.6f);
        }


        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
