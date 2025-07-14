package com.hello_there.rotp_cream.client.render.entity.stand;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class CreamModelBlockbench extends EntityModel<Entity> {
    private final ModelRenderer head;
    private final ModelRenderer heado;
    private final ModelRenderer horns;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer mask;
    private final ModelRenderer head_r1;
    private final ModelRenderer head_r2;
    private final ModelRenderer head_r3;
    private final ModelRenderer head_r4;
    private final ModelRenderer maskEnd;
    private final ModelRenderer head_r5;
    private final ModelRenderer maskEnd2;
    private final ModelRenderer head_r6;
    private final ModelRenderer head_r7;
    private final ModelRenderer head_r8;
    private final ModelRenderer jawUp;
    private final ModelRenderer jaw;
    private final ModelRenderer body;
    private final ModelRenderer upperPart;
    private final ModelRenderer leftArm;
    private final ModelRenderer leftArmJoint;
    private final ModelRenderer leftForeArm;
    private final ModelRenderer rightArm;
    private final ModelRenderer rightArmJoint;
    private final ModelRenderer rightForeArm;
    private final ModelRenderer torso;
    private final ModelRenderer torso_r1;
    private final ModelRenderer torso2;
    private final ModelRenderer rightLeg;
    private final ModelRenderer rightLegJoint;
    private final ModelRenderer rightLowerLeg;
    private final ModelRenderer leftLeg;
    private final ModelRenderer leftLegJoint;
    private final ModelRenderer leftLowerLeg;

    public CreamModelBlockbench() {
        texWidth = 128;
        texHeight = 128;

        head = new ModelRenderer(this);
        head.setPos(0.0F, -2.4167F, -0.2633F);


        heado = new ModelRenderer(this);
        heado.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(heado);
        heado.texOffs(58, 77).addBox(-4.0F, -5.8333F, -3.9867F, 8.0F, 6.0F, 8.0F, 0.0F, false);
        heado.texOffs(25, 48).addBox(-4.0F, 0.1667F, 0.0233F, 8.0F, 3.0F, 4.0F, 0.0F, false);

        horns = new ModelRenderer(this);
        horns.setPos(4.7F, -13.0833F, 0.0133F);
        head.addChild(horns);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(-10.3227F, 7.808F, -0.5F);
        horns.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -1.5272F);
        cube_r1.texOffs(0, 21).addBox(-0.75F, -0.1F, -0.25F, 1.0F, 0.5F, 0.5F, 0.0F, true);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(-9.4F, 9.6F, 0.0F);
        horns.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.0873F);
        cube_r2.texOffs(0, 18).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);
        cube_r2.texOffs(0, 16).addBox(-3.5F, -0.75F, -0.75F, 1.5F, 0.5F, 0.5F, 0.0F, true);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.9227F, 7.808F, -0.5F);
        horns.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 1.5272F);
        cube_r3.texOffs(0, 29).addBox(-0.25F, -0.1F, -0.25F, 1.0F, 0.5F, 0.5F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(0.0F, 9.6F, 0.0F);
        horns.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, -0.0873F);
        cube_r4.texOffs(0, 27).addBox(2.0F, -0.75F, -0.75F, 1.5F, 0.5F, 0.5F, 0.0F, false);
        cube_r4.texOffs(0, 23).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        mask = new ModelRenderer(this);
        mask.setPos(0.0F, -0.2333F, 1.3826F);
        head.addChild(mask);
        mask.texOffs(54, 29).addBox(-4.5F, -0.65F, -5.6192F, 1.0F, 1.0F, 8.5F, 0.0F, false);
        mask.texOffs(77, 42).addBox(3.5F, 0.35F, -5.1192F, 1.0F, 1.0F, 8.0F, 0.0F, true);
        mask.texOffs(54, 42).addBox(-4.5F, 0.35F, -5.1192F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        mask.texOffs(55, 54).addBox(-5.0F, 0.85F, -4.6192F, 1.0F, 1.0F, 7.5F, 0.0F, false);
        mask.texOffs(77, 54).addBox(4.0F, 0.85F, -4.6192F, 1.0F, 1.0F, 7.5F, 0.0F, true);
        mask.texOffs(76, 17).addBox(3.4F, -1.6F, -5.6192F, 1.0F, 1.0F, 8.5F, 0.0F, true);
        mask.texOffs(54, 17).addBox(-4.4F, -1.6F, -5.6192F, 1.0F, 1.0F, 8.5F, 0.0F, false);
        mask.texOffs(76, 29).addBox(3.5F, -0.65F, -5.6192F, 1.0F, 1.0F, 8.5F, 0.0F, true);
        mask.texOffs(57, 0).addBox(-4.25F, -5.85F, -5.6192F, 8.5F, 6.0F, 8.5F, 0.0F, false);

        head_r1 = new ModelRenderer(this);
        head_r1.setPos(-0.5F, -1.6F, 2.4808F);
        mask.addChild(head_r1);
        setRotationAngle(head_r1, 0.0F, 1.5708F, 0.0F);
        head_r1.texOffs(106, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 1.0F, 8.5F, 0.0F, false);

        head_r2 = new ModelRenderer(this);
        head_r2.setPos(0.25F, 1.3F, 2.6808F);
        mask.addChild(head_r2);
        setRotationAngle(head_r2, 0.0F, -1.5708F, 0.0F);
        head_r2.texOffs(106, 24).addBox(-0.5F, -0.95F, -4.25F, 1.0F, 1.0F, 9.0F, 0.0F, true);

        head_r3 = new ModelRenderer(this);
        head_r3.setPos(0.25F, 0.3F, 2.5808F);
        mask.addChild(head_r3);
        setRotationAngle(head_r3, 0.0F, -1.5708F, 0.0F);
        head_r3.texOffs(106, 11).addBox(-0.5F, -0.95F, -4.25F, 1.0F, 1.0F, 9.0F, 0.0F, true);

        head_r4 = new ModelRenderer(this);
        head_r4.setPos(0.0F, 1.85F, 2.8308F);
        mask.addChild(head_r4);
        setRotationAngle(head_r4, 0.0F, -1.5708F, 0.0F);
        head_r4.texOffs(107, 36).addBox(0.0F, -1.0F, -4.75F, 0.5F, 1.0F, 9.5F, 0.0F, true);

        maskEnd = new ModelRenderer(this);
        maskEnd.setPos(0.5F, 3.15F, 2.7808F);
        mask.addChild(maskEnd);
        maskEnd.texOffs(61, 64).addBox(4.15F, -1.3F, -1.4F, 0.5F, 1.0F, 1.5F, 0.0F, true);
        maskEnd.texOffs(84, 64).addBox(-5.65F, -1.3F, -1.4F, 0.5F, 1.0F, 1.5F, 0.0F, false);

        head_r5 = new ModelRenderer(this);
        head_r5.setPos(-0.25F, -0.3F, 0.1F);
        maskEnd.addChild(head_r5);
        setRotationAngle(head_r5, 0.0F, -1.5708F, 0.0F);
        head_r5.texOffs(107, 51).addBox(0.0F, -1.0F, -4.75F, 0.5F, 1.0F, 10.0F, 0.0F, true);

        maskEnd2 = new ModelRenderer(this);
        maskEnd2.setPos(0.0F, 0.7F, 0.2F);
        maskEnd.addChild(maskEnd2);


        head_r6 = new ModelRenderer(this);
        head_r6.setPos(-1.55F, -0.25F, -1.0F);
        maskEnd2.addChild(head_r6);
        setRotationAngle(head_r6, 0.0F, 1.5708F, 0.0F);
        head_r6.texOffs(84, 70).addBox(-1.0F, -1.0F, -4.25F, 1.0F, 1.0F, 0.5F, 0.0F, false);

        head_r7 = new ModelRenderer(this);
        head_r7.setPos(0.55F, -0.25F, -1.0F);
        maskEnd2.addChild(head_r7);
        setRotationAngle(head_r7, 0.0F, -1.5708F, 0.0F);
        head_r7.texOffs(62, 70).addBox(0.0F, -1.0F, -4.25F, 1.0F, 1.0F, 0.5F, 0.0F, true);

        head_r8 = new ModelRenderer(this);
        head_r8.setPos(-0.25F, 0.0F, 0.0F);
        maskEnd2.addChild(head_r8);
        setRotationAngle(head_r8, 0.0F, -1.5708F, 0.0F);
        head_r8.texOffs(107, 65).addBox(0.0F, -1.0F, -4.75F, 0.5F, 1.0F, 10.0F, 0.0F, true);

        jawUp = new ModelRenderer(this);
        jawUp.setPos(0.0F, 1.6667F, -0.9867F);
        head.addChild(jawUp);
        jawUp.texOffs(0, 48).addBox(-4.0F, -1.5F, -3.05F, 8.0F, 2.0F, 4.0F, 0.0F, false);

        jaw = new ModelRenderer(this);
        jaw.setPos(0.0F, 1.6667F, -0.9867F);
        head.addChild(jaw);
        jaw.texOffs(32, 0).addBox(-4.0F, -1.5F, -3.0F, 8.0F, 3.0F, 4.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);


        upperPart = new ModelRenderer(this);
        upperPart.setPos(0.0F, 12.0F, 0.0F);
        body.addChild(upperPart);


        leftArm = new ModelRenderer(this);
        leftArm.setPos(6.0F, -10.0F, 0.0F);
        upperPart.addChild(leftArm);
        leftArm.texOffs(32, 97).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        leftArm.texOffs(30, 97).addBox(-0.25F, 3.5F, 1.6F, 0.5F, 0.5F, 2.0F, 0.0F, false);
        leftArm.texOffs(32, 109).addBox(-1.75F, -2.35F, -2.25F, 4.0F, 3.0F, 4.5F, 0.0F, false);

        leftArmJoint = new ModelRenderer(this);
        leftArmJoint.setPos(0.0F, 4.0F, 0.0F);
        leftArm.addChild(leftArmJoint);
        leftArmJoint.texOffs(34, 89).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, true);

        leftForeArm = new ModelRenderer(this);
        leftForeArm.setPos(0.0F, 4.0F, 0.0F);
        leftArm.addChild(leftForeArm);
        leftForeArm.texOffs(0, 62).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, true);
        leftForeArm.texOffs(47, 114).addBox(-2.25F, 1.6F, -2.25F, 4.5F, 2.0F, 4.5F, -0.001F, true);
        leftForeArm.texOffs(35, 82).addBox(0.65F, 3.05F, -1.6F, 2.0F, 3.0F, 3.0F, -0.6F, true);

        rightArm = new ModelRenderer(this);
        rightArm.setPos(-6.0F, -10.0F, 0.0F);
        upperPart.addChild(rightArm);
        rightArm.texOffs(0, 97).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        rightArm.texOffs(0, 109).addBox(-2.25F, -2.35F, -2.25F, 4.0F, 3.0F, 4.5F, 0.0F, true);
        rightArm.texOffs(13, 97).addBox(-0.25F, 3.5F, 1.6F, 0.5F, 0.5F, 2.0F, 0.0F, true);

        rightArmJoint = new ModelRenderer(this);
        rightArmJoint.setPos(0.0F, 4.0F, 0.0F);
        rightArm.addChild(rightArmJoint);
        rightArmJoint.texOffs(2, 89).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

        rightForeArm = new ModelRenderer(this);
        rightForeArm.setPos(0.0F, 4.0F, 0.0F);
        rightArm.addChild(rightForeArm);
        rightForeArm.texOffs(29, 62).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
        rightForeArm.texOffs(3, 82).addBox(-2.65F, 3.05F, -1.6F, 2.0F, 3.0F, 3.0F, -0.6F, false);
        rightForeArm.texOffs(16, 114).addBox(-2.25F, 1.6F, -2.25F, 4.5F, 2.0F, 4.5F, -0.001F, false);

        torso = new ModelRenderer(this);
        torso.setPos(0.0F, -12.0F, 0.0F);
        upperPart.addChild(torso);
        torso.texOffs(37, 9).addBox(-4.0F, 0.8F, 2.0F, 8.0F, 3.5F, 0.5F, 0.0F, false);
        torso.texOffs(10, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);
        torso.texOffs(0, 35).addBox(-2.5F, 5.0F, -2.3F, 5.0F, 3.0F, 1.0F, 0.0F, false);

        torso_r1 = new ModelRenderer(this);
        torso_r1.setPos(0.0F, 3.4F, -2.15F);
        torso.addChild(torso_r1);
        setRotationAngle(torso_r1, -0.0436F, 0.0F, 0.0F);
        torso_r1.texOffs(10, 29).addBox(-4.0F, -2.5F, -0.25F, 8.0F, 4.5F, 0.5F, 0.0F, false);

        torso2 = new ModelRenderer(this);
        torso2.setPos(0.0F, 7.75F, -0.9F);
        torso.addChild(torso2);
        torso2.texOffs(0, 40).addBox(-2.5F, 0.25F, -1.4F, 5.0F, 3.0F, 1.0F, 0.0F, false);
        torso2.texOffs(15, 36).addBox(-4.0F, 0.25F, -1.1F, 8.0F, 4.0F, 4.0F, 0.0F, false);

        rightLeg = new ModelRenderer(this);
        rightLeg.setPos(-2.0F, 4.25F, 0.9F);
        torso2.addChild(rightLeg);
        rightLeg.texOffs(64, 108).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        rightLeg.texOffs(81, 117).addBox(-2.5F, -0.25F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

        rightLegJoint = new ModelRenderer(this);
        rightLegJoint.setPos(0.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightLegJoint);
        rightLegJoint.texOffs(64, 102).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
        rightLegJoint.texOffs(67, 97).addBox(-1.0F, -1.25F, -2.5F, 2.0F, 2.0F, 1.0F, -0.1F, false);

        rightLowerLeg = new ModelRenderer(this);
        rightLowerLeg.setPos(0.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightLowerLeg);
        rightLowerLeg.texOffs(64, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setPos(2.0F, 4.25F, 0.9F);
        torso2.addChild(leftLeg);
        leftLeg.texOffs(96, 108).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        leftLeg.texOffs(89, 117).addBox(1.5F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        leftLegJoint = new ModelRenderer(this);
        leftLegJoint.setPos(0.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftLegJoint);
        leftLegJoint.texOffs(96, 102).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, true);
        leftLegJoint.texOffs(99, 97).addBox(-1.0F, -1.25F, -2.5F, 2.0F, 2.0F, 1.0F, -0.1F, true);

        leftLowerLeg = new ModelRenderer(this);
        leftLowerLeg.setPos(0.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftLowerLeg);
        leftLowerLeg.texOffs(96, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
    }


    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
