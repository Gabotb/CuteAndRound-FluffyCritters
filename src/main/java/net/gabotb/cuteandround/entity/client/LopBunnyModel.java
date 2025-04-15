package net.gabotb.cuteandround.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.gabotb.cuteandround.entity.animations.ModAnimationDefinitions;
import net.gabotb.cuteandround.entity.custom.LopBunnyEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class LopBunnyModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "lopbunnymodel"), "main");
	private final ModelPart LopBunny;
	private final ModelPart Body;
	private final ModelPart Torso;
	private final ModelPart Cola;
	private final ModelPart Hands;
	private final ModelPart Mano1;
	private final ModelPart Mano2;
	private final ModelPart Head;
	private final ModelPart Orejas;
	private final ModelPart Oreja2;
	private final ModelPart Oreja1;
	private final ModelPart Boca;
	private final ModelPart Eyes;
	private final ModelPart Piernas;
	private final ModelPart Leg2;
	private final ModelPart Feet2;
	private final ModelPart Leg1;
	private final ModelPart Feet1;

	public LopBunnyModel(ModelPart root) {
		this.LopBunny = root.getChild("LopBunny");
		this.Body = LopBunny.getChild("Body");
		this.Torso = Body.getChild("Torso");
		this.Hands = Torso.getChild("Hands");
		this.Mano1 = Hands.getChild("Mano1");
		this.Head = Torso.getChild("Head");
		this.Mano2 = Hands.getChild("Mano2");
		this.Orejas = Head.getChild("Orejas");
		this.Boca = Head.getChild("Boca");
		this.Eyes = Head.getChild("Eyes");
		this.Piernas = Body.getChild("Piernas");
		this.Leg1 = Piernas.getChild("Leg1");
		this.Leg2 = Piernas.getChild("Leg2");
		this.Feet1 = Leg1.getChild("Feet1");
		this.Feet2 = Leg2.getChild("Feet2");
		this.Cola = Torso.getChild("Cola");
		this.Oreja1 = Orejas.getChild("Oreja1");
		this.Oreja2 = Orejas.getChild("Oreja2");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LopBunny = partdefinition.addOrReplaceChild("LopBunny", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = LopBunny.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -2.5F, 6.5F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.5F));

		PartDefinition Torso_r1 = Torso.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.5F, -8.5F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Cola = Torso.addOrReplaceChild("Cola", CubeListBuilder.create(), PartPose.offset(0.0F, -2.5F, -2.0F));

		PartDefinition Cola_r1 = Cola.addOrReplaceChild("Cola_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Hands = Torso.addOrReplaceChild("Hands", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, -7.0F));

		PartDefinition Mano1 = Hands.addOrReplaceChild("Mano1", CubeListBuilder.create().texOffs(18, 30).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, -0.5F));

		PartDefinition Mano2 = Hands.addOrReplaceChild("Mano2", CubeListBuilder.create().texOffs(26, 30).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, -0.5F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, -5.0F, -6.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -8.0F));

		PartDefinition Orejas = Head.addOrReplaceChild("Orejas", CubeListBuilder.create(), PartPose.offset(0.0F, -4.5F, -2.0F));

		PartDefinition Oreja2 = Orejas.addOrReplaceChild("Oreja2", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition Oreja2_r1 = Oreja2.addOrReplaceChild("Oreja2_r1", CubeListBuilder.create().texOffs(30, 4).addBox(0.0F, 0.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Oreja1 = Orejas.addOrReplaceChild("Oreja1", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition Oreja_r1 = Oreja1.addOrReplaceChild("Oreja_r1", CubeListBuilder.create().texOffs(12, 24).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Boca = Head.addOrReplaceChild("Boca", CubeListBuilder.create().texOffs(32, 14).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 40).addBox(-4.0F, -1.0F, -1.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 35).addBox(1.0F, -1.0F, -1.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

		PartDefinition Eyes = Head.addOrReplaceChild("Eyes", CubeListBuilder.create().texOffs(38, 23).addBox(-2.51F, -1.5F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 18).addBox(1.51F, -1.5F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -4.0F));

		PartDefinition Piernas = Body.addOrReplaceChild("Piernas", CubeListBuilder.create(), PartPose.offset(0.0F, -2.5F, -2.5F));

		PartDefinition Leg2 = Piernas.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(20, 14).addBox(0.0F, 0.0F, -5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 2.5F));

		PartDefinition Feet2 = Leg2.addOrReplaceChild("Feet2", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -0.5F, -3.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.5F, -2.5F));

		PartDefinition Leg1 = Piernas.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(20, 22).addBox(-2.0F, 0.0F, -5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 2.5F));

		PartDefinition Feet1 = Leg1.addOrReplaceChild("Feet1", CubeListBuilder.create().texOffs(30, 0).addBox(-1.0F, -0.5F, -3.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 4.5F, -2.5F));

		return LayerDefinition.create(meshdefinition, 45, 45);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
this.root().getAllParts().forEach(ModelPart::resetPose);
this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
this.animate(((LopBunnyEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LopBunny.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return LopBunny;
	}
}