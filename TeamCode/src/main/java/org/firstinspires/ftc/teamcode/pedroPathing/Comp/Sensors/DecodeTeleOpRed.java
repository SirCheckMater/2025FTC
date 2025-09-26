package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Sensors;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Configs.Config;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems.ShooterSubsystem;

public class DecodeTeleOpRed extends OpMode {
    public final double [] LaunchPose1 = {0,18,40,1};//x,y,heading,speed
    public final double [] LaunchPose2 = {16,48,25,1};//x,y,heading,speed
    MecanumDrivetrain drivetrain;
    DcMotorEx shooter;
    OdoPods pods = new OdoPods(hardwareMap,drivetrain);
    int state = 0;
    ShooterSubsystem flywheel;
    Config config;

    void setLaunchPose(@NonNull double [] LaunchPose){
        pods.holdPosition(LaunchPose[0],LaunchPose[1],LaunchPose[2],LaunchPose[3]);
    }

    @Override
    public void init() {
        config = new Config();
        shooter = hardwareMap.get(DcMotorEx.class, config.MainFlywheelMotorName);
        drivetrain = new MecanumDrivetrain(1, hardwareMap);
        flywheel = new ShooterSubsystem(hardwareMap, 1, shooter);
    }

    @Override
    public void loop() {
        //these set the robot to the desired launch positions
        if(gamepad1.a){
            switch(state){
                case 0:{
                    setLaunchPose(LaunchPose1);
                    if(gamepad1.right_bumper){
                        state = 1;
                        break;
                    }
                }
                case 1:{
                    flywheel.speedUpFlywheel(2800);
                    if(gamepad1.right_bumper){
                        state = 2;
                        break;
                    }

                }
                case 2:{
                    flywheel.servoFeedArtifact();
                    //go back and shoot another
                    if(gamepad1.left_bumper){
                        state = 1;
                        break;
                    }
                    //and break out of the state
                    else if(gamepad1.right_bumper && gamepad1.left_bumper){
                        break;
                    }

                }
            }
        }
        if(gamepad1.b){
            switch(state){
                case 0:{
                    setLaunchPose(LaunchPose2);
                    if(gamepad1.right_bumper){
                        state = 1;
                        break;
                    }
                }
                case 1:{
                    //change for position
                    flywheel.speedUpFlywheel(2800);
                    if(gamepad1.right_bumper){
                        state = 2;
                        break;
                    }

                }
                case 2:{
                    flywheel.servoFeedArtifact();
                    //go back and shoot another
                    if(gamepad1.left_bumper){
                        state = 1;
                        break;
                    }
                    //and break out of the state
                    else if(gamepad1.right_bumper && gamepad1.left_bumper){
                        break;
                    }

                }
            }

        }

        //test this
        drivetrain.drive(-gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);


    }
}
