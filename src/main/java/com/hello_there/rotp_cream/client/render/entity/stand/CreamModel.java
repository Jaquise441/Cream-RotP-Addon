package com.hello_there.rotp_cream.client.render.entity.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPoseTransitionMultiple;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.hello_there.rotp_cream.action.*;
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
                RotationAngle.fromDegrees(head, 5, 0, 0),
                RotationAngle.fromDegrees(jaw, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -2.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, 0, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -25, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, -14.9588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.8974F, -2.8654F, 4.0992F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.9825F, 0.8548F, -2.3494F),
        });

        ModelPose<CreamEntity> void2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 5, 0, 0),
                RotationAngle.fromDegrees(jaw, 5, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -10, 0, 0),
                RotationAngle.fromDegrees(torso2, -92.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -42.77F, 24.02F, 6.26F),
                RotationAngle.fromDegrees(rightArm, -60, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -23.5F, 6.1F, 18.81F),
                RotationAngle.fromDegrees(rightForeArm, -6.07F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 7.75F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -24.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> void3 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -7.5F, 0, 0),
                RotationAngle.fromDegrees(jaw, 26.67F, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -11.67F, 0, 0),
                RotationAngle.fromDegrees(torso2, -100, 0, 0),
                RotationAngle.fromDegrees(leftArm, -49.4763246755F, 28.0243206737F, 9.3815068184F),
                RotationAngle.fromDegrees(rightArm, -70, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -23.25F, 7.12F, 21.11F),
                RotationAngle.fromDegrees(rightForeArm, -2.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 11.92F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -26.63F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> void4 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -32.5F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -15, 0, 0),
                RotationAngle.fromDegrees(torso2, -115, 0, 0),
                RotationAngle.fromDegrees(leftArm, -61.9763246755F, 28.0243206737F, 9.3815068184F),
                RotationAngle.fromDegrees(rightArm, -70, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -22.75F, 9.15F, 25.71F),
                RotationAngle.fromDegrees(rightForeArm, -2.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 20.249977093F, -2.993175786F, -9.545887227F),
                RotationAngle.fromDegrees(rightLeg, -29.958757414F, 1.080064451F, 4.877364405F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.982471517F, 0.854810779F,-2.349405907F),
        });

        ModelPose<CreamEntity> void5 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -40.36F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -20, 0, 0),
                RotationAngle.fromDegrees(torso2, -120, 0, 0),
                RotationAngle.fromDegrees(leftArm, 8.9449648361F, 33.1862060354F, 5.5209891509F),
                RotationAngle.fromDegrees(rightArm, -125, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -21.9905448885F, 12.1990816906F, 32.6211303474F),
                RotationAngle.fromDegrees(rightForeArm, -2.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -10.42F, -0.52F, -7.85F),
                RotationAngle.fromDegrees(rightLeg, -42.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -60.017528483F, 0.854810779F,-2.349405907F),
        });

        ModelPose<CreamEntity> void6 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.14F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -4.4763246755F, 28.0243206737F, 9.3815068184F),
                RotationAngle.fromDegrees(rightArm, -125, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -5.49F, 12.2F, 32.62F),
                RotationAngle.fromDegrees(rightForeArm, -24.7738488387F, -11.2919969462F, -58.8144395412F),
                RotationAngle.fromDegrees(leftLeg, -63.9170337977F, 3.1987889231F, -5.3141321308F),
                RotationAngle.fromDegrees(rightLeg, -62.458757414F, 1.080064451F, 4.877364405F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.517528483F, 0.854810779F,-2.349405907F),
        });

        ModelPose<CreamEntity> void7 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -60, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -126.7479391172F, -24.1496917392F, 15.4433823797F),
                RotationAngle.fromDegrees(rightArm, -139.8F, -13.97F, 16.34F),
                RotationAngle.fromDegrees(leftForeArm, 5.5094551115F, 12.1990816906F, 32.6211303474F),
                RotationAngle.fromDegrees(rightForeArm, -2.0460326737F, -1.355143973F, -38.4761809699F),
                RotationAngle.fromDegrees(leftLeg, -63.9170337977F, 3.1987889231F, -5.3141321308F),
                RotationAngle.fromDegrees(rightLeg, -62.46F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.52F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> void8 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -25, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -125.3482719634F, 19.3295190701F, -14.7562642181F),
                RotationAngle.fromDegrees(rightArm, -152.1326922696F, -25.6103002005F, 21.6316488629F),
                RotationAngle.fromDegrees(leftForeArm, -32.4987469312F, 22.2329520757F, 47.6600652637F),
                RotationAngle.fromDegrees(rightForeArm, -2.05F, -1.36F, -38.48F),
                RotationAngle.fromDegrees(leftLeg, -63.9170337977F, 3.1987889231F, -5.3141321308F),
                RotationAngle.fromDegrees(rightLeg, -62.46F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, -70.102567825F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.52F, 0.85F,-2.35F),
        });

        actionAnim.put(CreamVoidBall.VOID_BALL, new PosedActionAnimation.Builder<CreamEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, void1)
                        .addPose(0.1F, void2)
                        .addPose(0.25F, void3)
                        .addPose(0.4F, void4)
                        .addPose(0.55F, void5)
                        .addPose(0.7F, void6)
                        .addPose(0.85F, void7)
                        .build(void8))
                .addPose(StandEntityAction.Phase.PERFORM, new ModelPoseTransitionMultiple.Builder<>(void8)
                        .addPose(1.0F, void8)
                        .build(idlePose))
                .build(idlePose));

        ModelPose<CreamEntity> semivoid1 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 5, 0, 0),
                RotationAngle.fromDegrees(jaw, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -2.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, 0, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -25, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.9932F, -9.5459F),
                RotationAngle.fromDegrees(rightLeg, -14.9588F, 1.0801F, 4.8774F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.8974F, -2.8654F, 4.0992F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.9825F, 0.8548F, -2.3494F),
        });

        ModelPose<CreamEntity> semivoid2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 5, 0, 0),
                RotationAngle.fromDegrees(jaw, 5, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -9.17, 0, 0),
                RotationAngle.fromDegrees(torso2,    -92.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -39.41F, 22.02F, 4.69F),
                RotationAngle.fromDegrees(rightArm, -55, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -23.62F, 5.59F, 17.66F),
                RotationAngle.fromDegrees(rightForeArm, -7.86F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 5.67F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -24.13F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> semivoid3 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 5, 0, 0),
                RotationAngle.fromDegrees(jaw, 14.29, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -10, 0, 0),
                RotationAngle.fromDegrees(torso2,    -95.71F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -42.77F, 24.02F, 6.25F),
                RotationAngle.fromDegrees(rightArm, -60, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -23.49F, 6.1F, 18.81F),
                RotationAngle.fromDegrees(rightForeArm, -6.07F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 7.75F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -24.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> semivoid4 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -7.5F, 0, 0),
                RotationAngle.fromDegrees(jaw, 32.86F, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -11.67F, 0, 0),
                RotationAngle.fromDegrees(torso2,    -102.14F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -49.4763246755F, 28.0243206737F, 9.3815068184F),
                RotationAngle.fromDegrees(rightArm, -70, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -23.24F, 7.12F, 21.11F),
                RotationAngle.fromDegrees(rightForeArm, -2.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 11.92F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -26.63F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> semivoid5 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -32.5F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -15, 0, 0),
                RotationAngle.fromDegrees(torso2, -115, 0, 0),
                RotationAngle.fromDegrees(leftArm, -49.4763246755F, 28.0243206737F, 9.3815068184F),
                RotationAngle.fromDegrees(rightArm, -70, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -22.74F, 9.15F, 25.71F),
                RotationAngle.fromDegrees(rightForeArm, -2.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 20.249977093F, -2.993175786F, -9.545887227F),
                RotationAngle.fromDegrees(rightLeg, -29.958757414F, 1.080064451F, 4.877364405F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.982471517F, 0.854810779F,-2.349405907F),
        });

        ModelPose<CreamEntity> semivoid6 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -40.36F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -20, 0, 0),
                RotationAngle.fromDegrees(torso2, -120, 0, 0),
                RotationAngle.fromDegrees(leftArm, 20.5236753245F, 28.0243206737F, 9.3815068184F),
                RotationAngle.fromDegrees(rightArm, -125, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -21.9905448885F, 12.1990816906F, 32.6211303474F),
                RotationAngle.fromDegrees(rightForeArm, -2.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -10.42F, -0.52F, -7.85F),
                RotationAngle.fromDegrees(rightLeg, -42.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -60.017528483F, 0.854810779F,-2.349405907F),
        });

        ModelPose<CreamEntity> semivoid7 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -52.14F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -4.4763246755F, 28.0243206737F, 9.3815068184F),
                RotationAngle.fromDegrees(rightArm, -125, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -5.49F, 12.2F, 32.62F),
                RotationAngle.fromDegrees(rightForeArm, -2.0460326737F, -1.355143973, -38.4761809699),
                RotationAngle.fromDegrees(leftLeg, -56.4170337977F, 3.1987889231F, -5.3141321308F),
                RotationAngle.fromDegrees(rightLeg, -62.458757414F, 1.080064451F, 4.877364405F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.517528483F, 0.854810779F,-2.349405907F),
        });

        ModelPose<CreamEntity> semivoid8 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -56.07F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -65.61F, 1.94F, 12.41F),
                RotationAngle.fromDegrees(rightArm, -88.57F, 3.32F, 17.63F),
                RotationAngle.fromDegrees(leftForeArm, 0.01F, 12.2F, 32.62F),
                RotationAngle.fromDegrees(rightForeArm, -2.05F, -1.36F, -38.48F),
                RotationAngle.fromDegrees(leftLeg, -56.42F, 3.2F, -5.31F),
                RotationAngle.fromDegrees(rightLeg, -62.46F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.897432175F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.52F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> semivoid9 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -60F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -126.7479391172F, -24.1496917392F, 15.4433823797F),
                RotationAngle.fromDegrees(rightArm, -27.8608243674F, 8.8604170595F, 30.3453170883F),
                RotationAngle.fromDegrees(leftForeArm, 5.5094551115F, 12.1990816906F, 32.6211303474F),
                RotationAngle.fromDegrees(rightForeArm, -2.0460326737F, -1.355143973F, -38.4761809699F),
                RotationAngle.fromDegrees(leftLeg, -56.42F, 3.2F, -5.31F),
                RotationAngle.fromDegrees(rightLeg, -62.46F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.897432175F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.52F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> semivoid10 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -42.26F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -125.35F, 19.33F, -14.76F),
                RotationAngle.fromDegrees(rightArm, -27.86F, 8.86F, 30.35F),
                RotationAngle.fromDegrees(leftForeArm, -32.4987469312F, 22.2329520757F, 47.6600652637F),
                RotationAngle.fromDegrees(rightForeArm, -2.05F, -1.36F, -38.48F),
                RotationAngle.fromDegrees(leftLeg, -56.42F, 3.2F, -5.31F),
                RotationAngle.fromDegrees(rightLeg, -62.46F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, -70.102567825F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.52F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> semivoid11 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 2.5F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 42.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -17.75F, -4.01F, -36.1F),
                RotationAngle.fromDegrees(rightArm, -27.86F, 8.86F, 30.35F),
                RotationAngle.fromDegrees(leftForeArm, -38.03F, 7.63F, 26.58F),
                RotationAngle.fromDegrees(rightForeArm, -2.05F, -1.36F, -38.48F),
                RotationAngle.fromDegrees(leftLeg, -56.42F, 3.2F, -5.31F),
                RotationAngle.fromDegrees(rightLeg, -62.46F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, -70.1F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.52F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> semivoid12 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 2.5F, 0, 0),
                RotationAngle.fromDegrees(jaw, 70, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 42.5F, 0, 0),
                RotationAngle.fromDegrees(torso, -27.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, -127.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -17.75F, -4.01F, -36.1F),
                RotationAngle.fromDegrees(rightArm, -27.86F, 8.86F, 30.35F),
                RotationAngle.fromDegrees(leftForeArm, -38.03F, 7.63F, 26.58F),
                RotationAngle.fromDegrees(rightForeArm, -2.05F, -1.36F, -38.48F),
                RotationAngle.fromDegrees(leftLeg, -56.42F, 3.2F, -5.31F),
                RotationAngle.fromDegrees(rightLeg, -62.46F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, -70.1F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, -62.52F, 0.85F,-2.35F),
        });

        actionAnim.put(CreamSemiVoidState.SEMI_VOID_STATE, new PosedActionAnimation.Builder<CreamEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, semivoid1)
                        .addPose(0.23F, semivoid2)
                        .addPose(0.25F, semivoid3)
                        .addPose(0.29F, semivoid4)
                        .addPose(0.37F, semivoid5)
                        .addPose(0.5F, semivoid6)
                        .addPose(0.69F, semivoid7)
                        .addPose(0.75F, semivoid8)
                        .addPose(0.81F, semivoid9)
                        .addPose(0.91F, semivoid10)
                        .build(semivoid11))
                .addPose(StandEntityAction.Phase.PERFORM, new ModelPoseTransitionMultiple.Builder<>(semivoid11)
                        .addPose(1.0F, semivoid11)
                        .build(semivoid12))
                .addPose(StandEntityAction.Phase.RECOVERY, new ModelPoseTransitionMultiple.Builder<>(semivoid12)
                        .addPose(1.2F, semivoid12)
                        .build(idlePose))
                .build(idlePose));

        ModelPose<CreamEntity> chop1 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 5, 0, 0),
                RotationAngle.fromDegrees(jaw, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -12.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, 2.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -2.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, 0, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -25, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -17.250022907F, -2.993175786F, -9.545887227F),
                RotationAngle.fromDegrees(rightLeg, -14.958757414F, 1.080064451F, 4.877364405F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.897432175F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.982471517F, 0.854810779F, -2.349405907F),
        });

        ModelPose<CreamEntity> chop2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 4.981069394, -0.435230002, 4.981069394),
                RotationAngle.fromDegrees(jaw, 17.5, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.07F, 5.13F, 5.42F),
                RotationAngle.fromDegrees(torso, -12.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, 2.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, 17.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, -150.94, 17.75, -65.63),
                RotationAngle.fromDegrees(leftForeArm, -56.67F, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -32.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -16.91F, -4.46F, -14.34F),
                RotationAngle.fromDegrees(rightLeg, -23.3F, -0.28F, 0.07F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 34.95F, 1.42F,-3.92F),
        });

        ModelPose<CreamEntity> chop3 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -2.503316462F, 4.54585194F, 5.416023987F),
                RotationAngle.fromDegrees(jaw, -10F, 0.08, -0.62),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.109231496F, 7.69037773F, 8.124097164F),
                RotationAngle.fromDegrees(torso, -12.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, 2.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, 27.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, -226.415472323, 26.631285179, -103.447087404),
                RotationAngle.fromDegrees(leftForeArm, -72.5F, 0, 5F),
                RotationAngle.fromDegrees(rightForeArm, -35F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -16.736337329F, -5.187998687F, -16.736337329F),
                RotationAngle.fromDegrees(rightLeg, -27.470840299F, -0.964030787F, -2.337441627F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 42.429896065F, 1.708184055F,-4.699856912F),
        });

        ModelPose<CreamEntity> chop4 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 1.24F, 3.3F, 5.31F),
                RotationAngle.fromDegrees(jaw, 5, 0.2F, -1.55F),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.24F, 0.65F, 5.53F),
                RotationAngle.fromDegrees(torso, -12.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, 2.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, 27.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, -231.415472323, 26.631285179, -103.447087404),
                RotationAngle.fromDegrees(leftForeArm, -72.5F, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -37.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -15.49F, -5.19F, -16.74F),
                RotationAngle.fromDegrees(rightLeg, -27.47F, -0.96F, -2.34F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.897432175F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, 42.43F, 1.71F,-4.7F),
        });

        ModelPose<CreamEntity> chop5 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 4.984139915F, 2.055325762F, 5.19820722F),
                RotationAngle.fromDegrees(jaw, 19.992942811F, 0.32621371F, -2.478638943F),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.37F, -6.4F, 2.94F),
                RotationAngle.fromDegrees(torso, -12.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, 2.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, 27.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, -158.66F, 12.07F, -55.46F),
                RotationAngle.fromDegrees(leftForeArm, -72.5F, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -40F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -14.24F, -5.19F, -16.74F),
                RotationAngle.fromDegrees(rightLeg, -27.47F, -0.96F, -2.34F),
                RotationAngle.fromDegrees(leftLowerLeg, 32.4F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 42.43F, 1.71F,-4.7F),
        });

        ModelPose<CreamEntity> chop6 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 4.981069394F, -0.435230002F, 4.981069394F),
                RotationAngle.fromDegrees(jaw, 37.49F, 0.33F, -2.48F),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.506748984F, -13.443661949F, 0.349429776F),
                RotationAngle.fromDegrees(torso, -12.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, 2.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, 27.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, -85.911816978, -2.4974377, -7.474683943),
                RotationAngle.fromDegrees(leftForeArm, -72.5F, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -17.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -13.41F, -5.19F, -16.74F),
                RotationAngle.fromDegrees(rightLeg, -27.47F, -0.96F, -2.34F),
                RotationAngle.fromDegrees(leftLowerLeg, 30.73F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 42.43F, 1.71F,-4.7F),
        });

        ModelPose<CreamEntity> chop7 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 4.98F, -0.44F, 4.98F),
                RotationAngle.fromDegrees(jaw, 37.49F, 0.33F, -2.48F),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.51F, -13.44F, 0.35F),
                RotationAngle.fromDegrees(torso, -12.5F, 0, 0),
                RotationAngle.fromDegrees(torso2, 2.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, 27.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, -85.911816978, -2.4974377, -7.474683943),
                RotationAngle.fromDegrees(leftForeArm, -72.5F, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -10F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -11.736337329F, -5.187998687F, -16.736337329F),
                RotationAngle.fromDegrees(rightLeg, -27.47F, -0.96F, -2.34F),
                RotationAngle.fromDegrees(leftLowerLeg, 27.397432175F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, 42.43F, 1.71F,-4.7F),
        });

        actionAnim.put(CreamChop.CHOP, new PosedActionAnimation.Builder<CreamEntity>()
                .addPose(StandEntityAction.Phase.WINDUP, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, chop1)
                        .addPose(0.17F, chop2)
                        .addPose(0.25F, chop3)
                        .addPose(0.38F, chop4)
                        .addPose(0.5F, chop5)
                        .build(chop6))
                .addPose(StandEntityAction.Phase.RECOVERY, new ModelPoseTransitionMultiple.Builder<>(chop6)
                        .addPose(0.58F, chop6)
                        .addPose(0.71F, chop7)
                        .build(idlePose))
                .build(idlePose));

        ModelPose<CreamEntity> hc1 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -121.8827858067F, -60.9818177519F, 104.6467504225F),
                RotationAngle.fromDegrees(rightArm, -114.4130137326F, 65.9064341992F, -92.6070550352F),
                RotationAngle.fromDegrees(leftForeArm, -25, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -17.250022907F, -2.993175786F, -9.545887227F),
                RotationAngle.fromDegrees(rightLeg, -14.958757414F, 1.080064451F, 4.877364405F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.897432175F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.982471517F, 0.854810779F, -2.349405907F),
        });

        ModelPose<CreamEntity> hc2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 30, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 5, 0, 0),
                RotationAngle.fromDegrees(torso, -10F, 0, 0),
                RotationAngle.fromDegrees(torso2, 7.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -269.9515134526F, -32.6774219989F, 212.9475195667F),
                RotationAngle.fromDegrees(rightArm, -263.7863236454F, 26.6900411229F, -222.7933866546F),
                RotationAngle.fromDegrees(leftForeArm, 0.4988112728F, 2.891325709F, 104.9748232128F),
                RotationAngle.fromDegrees(rightForeArm, -0.6574561971F, 1.4951135732F, -117.4318981137F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -14.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> hc3 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 30, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, -10F, 0, 0),
                RotationAngle.fromDegrees(torso2, -10F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -192.17F, -29.95F, 100.76F),
                RotationAngle.fromDegrees(rightArm, -193.1F, 26.83F, -102.31F),
                RotationAngle.fromDegrees(leftForeArm, -11.79F, -5.75F, 80.58F),
                RotationAngle.fromDegrees(rightForeArm, -9.06F, 9.69F, -83.53F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -14.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> hc4 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 30, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 35, 0, 0),
                RotationAngle.fromDegrees(torso, -10F, 0, 0),
                RotationAngle.fromDegrees(torso2, -27.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -114.3809397964F, -27.2164336798F, -11.42591408F),
                RotationAngle.fromDegrees(rightArm, -122.4113448204F, 26.9734243306F, 18.1807128634F),
                RotationAngle.fromDegrees(leftForeArm, -24.0726223738F, -14.3832150385F, 56.1920320254F),
                RotationAngle.fromDegrees(rightForeArm, -17.4561690942F, 17.8869199432F, -49.6315025784F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -14.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> hc5 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 30, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 35, 0, 0),
                RotationAngle.fromDegrees(torso, -10F, 0, 0),
                RotationAngle.fromDegrees(torso2, -27.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -114.3809397964F, -27.2164336798F, -11.42591408F),
                RotationAngle.fromDegrees(rightArm, -122.4113448204F, 26.9734243306F, 18.1807128634F),
                RotationAngle.fromDegrees(leftForeArm, -24.0726223738F, -14.3832150385F, 56.1920320254F),
                RotationAngle.fromDegrees(rightForeArm, -17.4561690942F, 17.8869199432F, -49.6315025784F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -14.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        actionAnim.put(CreamDoublePunchFinisher.HEADCRUSH, new PosedActionAnimation.Builder<CreamEntity>()
                .addPose(StandEntityAction.Phase.WINDUP, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, hc1)
                        .addPose(0.5F, hc2)
                        .addPose(0.63F, hc3)
                        .build(hc4))
                .addPose(StandEntityAction.Phase.PERFORM, new ModelPoseTransitionMultiple.Builder<>(hc4)
                        .addPose(0.75F, hc4)
                        .build(hc5))
                .addPose(StandEntityAction.Phase.RECOVERY, new ModelPoseTransitionMultiple.Builder<>(hc5)
                        .addPose(0.95F, hc5)
                        .build(idlePose))
                .build(idlePose));

        ModelPose<CreamEntity> fc1 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -24.330185558F, -1.2122505227F, -20.2303367808F),
                RotationAngle.fromDegrees(rightArm, -21.8229099019F, 0.4378552702F, 23.6546860411F),
                RotationAngle.fromDegrees(leftForeArm, -25, 0, 5),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, -17.250022907F, -2.993175786F, -9.545887227F),
                RotationAngle.fromDegrees(rightLeg, -14.958757414F, 1.080064451F, 4.877364405F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.897432175F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.982471517F, 0.854810779F, -2.349405907F),
        });

        ModelPose<CreamEntity> fc2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, -5, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 6.25, 0, 0),
                RotationAngle.fromDegrees(torso, 1.67F, 0, 0),
                RotationAngle.fromDegrees(torso2, -2.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -124.95F, -16.06F, 20.83F),
                RotationAngle.fromDegrees(rightArm, -125.87F, 12.81F, -24.08F),
                RotationAngle.fromDegrees(leftForeArm, -11.27F, 7.12F, 14.06F),
                RotationAngle.fromDegrees(rightForeArm, -15, -6.51F, -10.97F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -14.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> fc3 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, -10, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5, 0, 0),
                RotationAngle.fromDegrees(torso, 3.34F, 0, 0),
                RotationAngle.fromDegrees(torso2, 12.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -225.5675289857F, -30.9049923835F, 61.8960993736F),
                RotationAngle.fromDegrees(rightArm, -229.9183546819F, 25.1912102456F, -71.8235787723F),
                RotationAngle.fromDegrees(leftForeArm, 2.4597977257F, 14.2352069369F, 23.1208740621F),
                RotationAngle.fromDegrees(rightForeArm, -2.5052418285F, -13.0293874215F, -16.9463831303F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -14.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> fc4 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 7.5, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, -7.5, 0, 0),
                RotationAngle.fromDegrees(torso, 4.17F, 0, 0),
                RotationAngle.fromDegrees(torso2, 12.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -151.76F, -4.4F, 17.89F),
                RotationAngle.fromDegrees(rightArm, -150.07F, 3.97F, -27.54F),
                RotationAngle.fromDegrees(leftForeArm, 7.69F, 25.42F, 24.94F),
                RotationAngle.fromDegrees(rightForeArm, 2.04F, -30.77F, -22.2F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -14.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> fc5 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 25, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 25, 0, 0),
                RotationAngle.fromDegrees(torso, 5, 0, 0),
                RotationAngle.fromDegrees(torso2, -42.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -77.9536348736F, 22.1018290733F, -26.1086967456F),
                RotationAngle.fromDegrees(rightArm, -70.2168995497F, -17.2497296834F, 16.7421650105F),
                RotationAngle.fromDegrees(leftForeArm, 12.9269065563F, 36.6086603491F, 26.7639697486F),
                RotationAngle.fromDegrees(rightForeArm, 6.5792118809F, -48.5063953979F, -27.4572951406F),
                RotationAngle.fromDegrees(leftLeg, -17.25F, -2.99F, -9.55F),
                RotationAngle.fromDegrees(rightLeg, -14.96F, 1.08F, 4.88F),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        actionAnim.put(CreamDoubleClawFinisher.FINISHERCLAW, new PosedActionAnimation.Builder<CreamEntity>()
                .addPose(StandEntityAction.Phase.WINDUP, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, fc1)
                        .addPose(0.25F, fc2)
                        .addPose(0.5F, fc3)
                        .addPose(0.63F, fc4)
                        .build(fc5))
                .addPose(StandEntityAction.Phase.RECOVERY, new ModelPoseTransitionMultiple.Builder<>(fc5)
                        .addPose(0.75F, fc5)
                        .build(idlePose))
                .build(idlePose));

        ModelPose<CreamEntity> hec1 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -2.5F, 0, -12.5F),
                RotationAngle.fromDegrees(rightArm, 0, 0, 10),
                RotationAngle.fromDegrees(leftForeArm, -34.614316654F, 41.928306247F, -19.759477671F),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 0, 0, 0),
                RotationAngle.fromDegrees(rightLeg, 0, 0, 0),
                RotationAngle.fromDegrees(leftLowerLeg, 34.897432175F, -2.865437863F, 4.099180656F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.982471517F, 0.854810779F, -2.349405907F),
        });

        ModelPose<CreamEntity> hec2 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 10, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.22F, 4.69F, 1.74F),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -15.79F, -1.29F, -13.91F),
                RotationAngle.fromDegrees(rightArm, -68.53F, 29.98F, -15.01F),
                RotationAngle.fromDegrees(leftForeArm, -34.61F, 41.93F, -19.76F),
                RotationAngle.fromDegrees(rightForeArm, -25, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 0, 0, 0),
                RotationAngle.fromDegrees(rightLeg, 0, 0, 0),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> hec3 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 18.75F, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.41F, 8.8F, 3.27F),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -27.42F, -2.41F, -15.14F),
                RotationAngle.fromDegrees(rightArm, -128.494969945F, 56.22038843F, -36.895887893F),
                RotationAngle.fromDegrees(leftForeArm, -34.61F, 41.93F, -19.76F),
                RotationAngle.fromDegrees(rightForeArm, -22.81F, 0, -5F),
                RotationAngle.fromDegrees(leftLeg, 0, 0, 0),
                RotationAngle.fromDegrees(rightLeg, 0, 0, 0),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> hec4 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 26.25F, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.57F, 12.32F, 4.58F),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -37.391212146F, -3.375617728F, -16.190660194F),
                RotationAngle.fromDegrees(rightArm, -178.57F, 64.9F, -48.22F),
                RotationAngle.fromDegrees(leftForeArm, -34.61F, 41.93F, -19.76F),
                RotationAngle.fromDegrees(rightForeArm, -20.94F, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 0, 0, 0),
                RotationAngle.fromDegrees(rightLeg, 0, 0, 0),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> hec5 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 30, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 20.646896487F, 14.076095422F, 5.236189386F),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -17.5F, 0, 0),
                RotationAngle.fromDegrees(leftArm, -37.391212146F, -3.375617728F, -16.190660194F),
                RotationAngle.fromDegrees(rightArm, -196.100114162F, 69.246889552F, -53.882486951F),
                RotationAngle.fromDegrees(leftForeArm, -34.614316654F, 41.928306247F, -19.759477671F),
                RotationAngle.fromDegrees(rightForeArm, -20, 0, -5),
                RotationAngle.fromDegrees(leftLeg, 0, 0, 0),
                RotationAngle.fromDegrees(rightLeg, 0, 0, 0),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        ModelPose<CreamEntity> hec6 = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(jaw, 10, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(body, 28.146896487F, -14.076095422F, -5.236189386F),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(torso2, -25F, 0, 0),
                RotationAngle.fromDegrees(leftArm, 42.281664684F, -6.75122323F, -12.487121738F),
                RotationAngle.fromDegrees(rightArm, -48.930937679F, -45.413762096F, 9.320747306F),
                RotationAngle.fromDegrees(leftForeArm, -67.114316654F, 41.928306247F, -19.759477671F),
                RotationAngle.fromDegrees(rightForeArm, -29.071427475F, -45.475670238F, 11.302234081F),
                RotationAngle.fromDegrees(leftLeg, 0, 0, 0),
                RotationAngle.fromDegrees(rightLeg, 0, 0, 0),
                RotationAngle.fromDegrees(leftLowerLeg, 34.9F, -2.87F, 4.1F),
                RotationAngle.fromDegrees(rightLowerLeg, 19.98F, 0.85F,-2.35F),
        });

        actionAnim.put(CreamHeavyClaw.HEAVYCLAW, new PosedActionAnimation.Builder<CreamEntity>()
                .addPose(StandEntityAction.Phase.WINDUP, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, hec1)
                        .addPose(0.33F, hec2)
                        .addPose(0.63F, hec3)
                        .addPose(0.88F, hec4)
                        .addPose(1.0F, hec5)
                        .build(hec6))
                .addPose(StandEntityAction.Phase.PERFORM, new ModelPoseTransitionMultiple.Builder<>(hec6)
                        .addPose(1.21F, hec6)
                        .build(idlePose))
                .build(idlePose));

        super.initActionPoses();
    }

    @Override
    public void prepareMobModel(CreamEntity entity, float walkAnimPos, float walkAnimSpeed, float partialTick) {
        super.prepareMobModel(entity, walkAnimPos, walkAnimSpeed, partialTick);
    }

    @Override
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