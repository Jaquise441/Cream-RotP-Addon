package com.hello_there.rotp_cream.client.render.entity.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPoseTransitionMultiple;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.hello_there.rotp_cream.action.CreamChomp;
import com.hello_there.rotp_cream.action.CreamVoidBall;
import com.hello_there.rotp_cream.entity.CreamEntity;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.bb.BlockbenchStandModelHelper;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import net.minecraft.client.renderer.model.ModelRenderer;


// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class CreamModel extends HumanoidStandModel<CreamEntity> {

    private final ModelRenderer torso2;

    private final ModelRenderer jaw;

    public CreamModel() {
        super();

        jaw = new ModelRenderer(this);
        jaw.setPos(0.0F, 1.6667F, -0.9867F);
        head.addChild(jaw);
        jaw.texOffs(32, 0).addBox(-4.0F, -1.5F, -3.0F, 8.0F, 3.0F, 4.0F, 0.0F, false);

        torso2 = new ModelRenderer(this);
        torso2.setPos(0.0F, 7.75F, -0.9F);
        torso.addChild(torso2);
        torso2.texOffs(0, 40).addBox(-2.5F, 0.25F, -1.4F, 5.0F, 3.0F, 1.0F, 0.0F, false);
        torso2.texOffs(15, 36).addBox(-4.0F, 0.25F, -1.1F, 8.0F, 4.0F, 4.0F, 0.0F, false);



        BlockbenchStandModelHelper.fillFromBlockbenchExport(new CreamModelBlockbench(), this);
    }

    @Override
    protected RotationAngle[][] initSummonPoseRotations() {
        return new RotationAngle[][] {
                new RotationAngle[] {
                        RotationAngle.fromDegrees(head, 0.0F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(jaw, -15F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(body, 7.5F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(torso, 0F, 0F, 0F),
                        RotationAngle.fromDegrees(torso2, 0F, 0F, 0F),
                        RotationAngle.fromDegrees(leftArm, -31.8803F, 6.6782F, -61.9094F),
                        RotationAngle.fromDegrees(rightArm, -29.4084F, -6.2127F, 61.6318F),
                        RotationAngle.fromDegrees(leftForeArm, -87.2218F, 22.9234F, 126.2405F),
                        RotationAngle.fromDegrees(rightForeArm, -90F, -30F, -125F),
                        RotationAngle.fromDegrees(leftLeg, 0.0F, 0.0F, -7.5F),
                        RotationAngle.fromDegrees(rightLeg, -12.5F, 0.0F, 7.5F),
                        RotationAngle.fromDegrees(leftLowerLeg, 35F, -2.5F, 0.0F),
                        RotationAngle.fromDegrees(rightLowerLeg, 27.5F, 5.0F, 0.0F),
                },
                new RotationAngle[] {
                        RotationAngle.fromDegrees(head, -12.5F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(jaw, 52.5F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(body, 0.0F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(torso, -17.5F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(torso2, -122.5F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(leftArm, 0.0F, 0.0F, -17.5F),
                        RotationAngle.fromDegrees(rightArm, 0.0F, 0.0F, 17.5F),
                        RotationAngle.fromDegrees(leftForeArm, -93.178F, -32.3612F, 95.9224F),
                        RotationAngle.fromDegrees(rightForeArm, -91.5918F, 32.4653F, -92.9635F),
                        RotationAngle.fromDegrees(leftLeg, -69.8413F, 7.0453F, 2.5782F),
                        RotationAngle.fromDegrees(rightLeg, -69.8413F, -7.0453F, -2.5782F),
                        RotationAngle.fromDegrees(leftLowerLeg, -35F, 0.0F, 0.0F),
                        RotationAngle.fromDegrees(rightLowerLeg, -35F, 0.0F, 0.0F),
                }
        };
    }

    protected void initActionPoses() {
        ModelPose<CreamEntity> chomp_windup1 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(jaw, 0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso2, -17.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -2.5F, 0.0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, 0.0F, 0.0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -25F, 0.0F, 5F),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0.0F, -5F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, -14.9588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.8974F, -2.8654F, 4.0992F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.9825F, 0.8548F, -2.3494F),
        });

        ModelPose<CreamEntity> chomp_windup2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(jaw, 0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, -12.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso2, -5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -1.874F, -79.9734F, -93.1617F),
                RotationAngle.fromDegrees(rightArm, 0.0F, 62.5F, 97.5F),
                RotationAngle.fromDegrees(leftForeArm, -25F, 0.0F, 5F),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0.0F, -5F),
                RotationAngle.fromDegrees(leftLeg, 0.25F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, 5.0412F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.8974F, -2.8654F, 4.0992F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.9825F, 0.8548F, -2.3494F),
        });

        ModelPose<CreamEntity> chomp1 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 17.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(jaw, 75F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 32.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso2, -22.5, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -89.9666F, -7.212F, -4.5774F),
                RotationAngle.fromDegrees(rightArm, -89.4332F, 11.0686F, 13.3448F),
                RotationAngle.fromDegrees(leftForeArm, -25F, 0.0F, 5F),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0.0F, -5F),
                RotationAngle.fromDegrees(leftLeg, -39.75F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, -42.4588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 72.4F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 84.9825F, 0.8548F, -2.3494F)
        });

        ModelPose<CreamEntity> chomp2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 6.07F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(jaw, 0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 32.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso2, -40, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -47.4666F, -7.212F, -4.5774F),
                RotationAngle.fromDegrees(rightArm, -41.9332F, 11.0686F, 13.3448F),
                RotationAngle.fromDegrees(leftForeArm, -70F, 0.0F, 5F),
                RotationAngle.fromDegrees(rightForeArm, -85F, 0.0F, -5F),
                RotationAngle.fromDegrees(leftLeg, -39.75F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, -42.4588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 109.8974, -2.8654F, 4.0992F),
                RotationAngle.fromDegrees(rightLowerLeg, 84.9825F, 0.8548F, -2.3494F)
        });

        ModelPose<CreamEntity> chomp3 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 12.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(jaw, -12.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 32.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso2, -40, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -47.4666F, -7.212F, -4.5774F),
                RotationAngle.fromDegrees(rightArm, -41.9332F, 11.0686F, 13.3448F),
                RotationAngle.fromDegrees(leftForeArm, -70F, 0.0F, 5F),
                RotationAngle.fromDegrees(rightForeArm, -85F, 0.0F, -5F),
                RotationAngle.fromDegrees(leftLeg, -39.75F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, -42.4588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 109.8974F, -2.8654F, 4.0992F),
                RotationAngle.fromDegrees(rightLowerLeg, 84.9825F, 0.8548F, -2.3494F),
        });

        actionAnim.put(CreamChomp.CHOMP, new PosedActionAnimation.Builder<CreamEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, chomp_windup1)
                        .addPose(1.04F, chomp_windup2)
                        .build(chomp1))
                .addPose(StandEntityAction.Phase.PERFORM, new ModelPoseTransitionMultiple.Builder<>(chomp1)
                        .addPose(0.25F, chomp1)
                        .addPose(0.5F, chomp2)
                        .addPose(0.54F, chomp3)
                        .build(idlePose))
                .build(idlePose));

        ModelPose<CreamEntity> void1 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(jaw, 0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso2, -17.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -2.5F, 0.0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, 0.0F, 0.0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -25F, 0.0F, 5F),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0.0F, -5F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, -14.9588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.8974F, -2.8654F, 4.0992F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.9825F, 0.8548F, -2.3494F),
        });

        ModelPose<CreamEntity> void2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -37.5F, 0F, 0F),
                RotationAngle.fromDegrees(jaw, 77.5F, 0F, 0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0F, 0F),
                RotationAngle.fromDegrees(torso, -37.5F, 0F, 0F),
                RotationAngle.fromDegrees(torso2, -57.5F, 0F, 0F),
                RotationAngle.fromDegrees(leftArm, -2.5F, 0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, 0F, 0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -25F, 0F, 5F),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0F, -5F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -27.46F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> void3 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.5F, 0F, 0F),
                RotationAngle.fromDegrees(jaw, 87.5F, 0F, 0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0F, 0F),
                RotationAngle.fromDegrees(torso, -43.33F, 0F, 0F),
                RotationAngle.fromDegrees(torso2, -97.5F, 0F, 0F),
                RotationAngle.fromDegrees(leftArm, -40.68F, 0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, -40.91F, 0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -29.28F, 1.4F, 8.03F),
                RotationAngle.fromDegrees(rightForeArm, -28.98F, -5.53F, -12.31F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -39.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> void4 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.5F, 0F, 0F),
                RotationAngle.fromDegrees(jaw, 87.5F, 0F, 0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0F, 0F),
                RotationAngle.fromDegrees(torso, -48.19F, 0F, 0F),
                RotationAngle.fromDegrees(torso2, -101.67F, 0F, 0F),
                RotationAngle.fromDegrees(leftArm, -72.5F, 0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, -75F, 0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -32.85F, 2.56F, 10.56F),
                RotationAngle.fromDegrees(rightForeArm, -30.21F, -10.14F, -18.4F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -50.38F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> void5 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.5F, 0F, 0F),
                RotationAngle.fromDegrees(jaw, 87.5F, 0F, 0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0F, 0F),
                RotationAngle.fromDegrees(torso, -49.16F, 0F, 0F),
                RotationAngle.fromDegrees(torso2, -102.5F, 0F, 0F),
                RotationAngle.fromDegrees(leftArm, -77.29F, 0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, -81.07F, 0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -33.56F, 2.79F, 11.06F),
                RotationAngle.fromDegrees(rightForeArm, -30.46F, -11.06F, -19.62F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -52.4588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> void6 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.5F, 0F, 0F),
                RotationAngle.fromDegrees(jaw, 87.5F, 0F, 0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0F, 0F),
                RotationAngle.fromDegrees(torso, -55F, 0F, 0F),
                RotationAngle.fromDegrees(torso2, -107.5F, 0F, 0F),
                RotationAngle.fromDegrees(leftArm, -106.04F, 0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, -117.5F, 0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -37.84F, 4.19F, 14.1F),
                RotationAngle.fromDegrees(rightForeArm, -31.93F, -16.59F, -26.92F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -64.9588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -74.9257F, -6.3942F,-4.2956F),
        });

        ModelPose<CreamEntity> void7 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.5F, 0F, 0F),
                RotationAngle.fromDegrees(jaw, 87.5F, 0F, 0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0F, 0F),
                RotationAngle.fromDegrees(torso, -55F, 0F, 0F),
                RotationAngle.fromDegrees(torso2, -107.5F, 0F, 0F),
                RotationAngle.fromDegrees(leftArm, -130F, 0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, -128.21F, 0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -41.4F, 5.35F, 16.63F),
                RotationAngle.fromDegrees(rightForeArm, -33.16F, -21.19F, -33.01F),
                RotationAngle.fromDegrees(leftLeg, -77.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -64.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -74.93F, -6.39F,-4.3F),
        });

        ModelPose<CreamEntity> void8 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.5F, 0F, 0F),
                RotationAngle.fromDegrees(jaw, 87.5F, 0F, 0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0F, 0F),
                RotationAngle.fromDegrees(torso, -55F, 0F, 0F),
                RotationAngle.fromDegrees(torso2, -107.5F, 0F, 0F),
                RotationAngle.fromDegrees(leftArm, -130F, 0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, -132.5F, 0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -42.82F, 5.81F, 17.64F),
                RotationAngle.fromDegrees(rightForeArm, -33.6518F, -23.0357F, -35.4473F),
                RotationAngle.fromDegrees(leftLeg, -77.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -64.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, -3.85F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -74.93F, -6.39F,-4.3F),
        });

        ModelPose<CreamEntity> void9 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.5F, 0F, 0F),
                RotationAngle.fromDegrees(jaw, 87.5F, 0F, 0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0F, 0F),
                RotationAngle.fromDegrees(torso, -55F, 0F, 0F),
                RotationAngle.fromDegrees(torso2, -107.5F, 0F, 0F),
                RotationAngle.fromDegrees(leftArm, -130F, 0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, -132.5F, 0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -44.2477F, 6.2797F, 18.6497F),
                RotationAngle.fromDegrees(rightForeArm, -33.65F, -23.04F, -35.45F),
                RotationAngle.fromDegrees(leftLeg, -77.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -64.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, -42.6F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -74.93F, -6.39F,-4.3F),
        });

        actionAnim.put(CreamVoidBall.VOID_BALL, new PosedActionAnimation.Builder<CreamEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, void1)
                        .addPose(0.25F, void2)
                        .addPose(0.5F, void3)
                        .addPose(0.71F, void4)
                        .addPose(0.75F, void5)
                        .addPose(1.0F, void6)
                        .addPose(1.21F, void7)
                        .addPose(1.29F, void8)
                        .addPose(1.38F, void9)
                        .build(void9))
                .addPose(StandEntityAction.Phase.PERFORM, new ModelPoseTransitionMultiple.Builder<>(void9)
                        .addPose(0.5F, void9)
                        .build(idlePose))
                .build(idlePose));



        super.initActionPoses();
    }


    @Override
    public void prepareMobModel(CreamEntity entity, float walkAnimPos, float walkAnimSpeed, float partialTick) {
        super.prepareMobModel(entity, walkAnimPos, walkAnimSpeed, partialTick);
    }




    @Override // TODO idle pose
    protected ModelPose<CreamEntity> initIdlePose() {
        return new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso2, -17.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -2.5F, 0.0F, -12.5F),
                RotationAngle.fromDegrees(rightArm, 0.0F, 0.0F, 10F),
                RotationAngle.fromDegrees(leftForeArm, -25F, 0.0F, 5F),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0.0F, -5F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, -14.9588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.8974F, -2.8654F, 4.0992F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.9825F, 0.8548F, -2.3494F),
        });
    }

    @Override
    protected ModelPose<CreamEntity> initIdlePose2Loop() {
        return new ModelPose<>(new RotationAngle[]{
                RotationAngle.fromDegrees(jaw, -27.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(body, 20F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, -2.5F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso2, -15F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -2.4976F, 0.109F, -10.0024F),
                RotationAngle.fromDegrees(rightArm, 0.0F, 0.0F, 7.5F),
                RotationAngle.fromDegrees(leftForeArm, -21.9811F, -0.9363F, 2.6818F),
                RotationAngle.fromDegrees(rightForeArm, -27.4777F, 1.1541F, -2.7822F),
                RotationAngle.fromDegrees(leftLeg, -14.7984F, -2.7382F, -8.5777F),
                RotationAngle.fromDegrees(rightLeg, -12.4753F, 0.8642F, 3.9008F),
                RotationAngle.fromDegrees(leftLowerLeg, 32.3801F, -3.2241F, 4.4615F),
                RotationAngle.fromDegrees(rightLowerLeg, 17.4768F, 1.1083F, -2.7914F),
        });
    }

}