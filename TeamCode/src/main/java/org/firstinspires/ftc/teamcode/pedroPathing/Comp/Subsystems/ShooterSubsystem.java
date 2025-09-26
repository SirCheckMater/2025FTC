package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.sun.tools.javac.tree.DCTree;

import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Configs.Config;

public class ShooterSubsystem {
    private Config config;
    private DcMotorEx highSpeedFlywheel;
    private double flywheelMaxPower;
    private double ticksPerRev = 311.4;//103.8 originally 1620rpm motor, but 3x gear ratio
    //used for speed calculations
    private double tps = 0;
    private ElapsedTime timer;
    private double lastPosition;
    private double difference;
    Servo feedingServo;
    public ShooterSubsystem(HardwareMap hardwareMap, double maxPower, DcMotorEx shooter){
        highSpeedFlywheel = shooter;
        highSpeedFlywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        highSpeedFlywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheelMaxPower = maxPower;
        timer = new ElapsedTime();
        feedingServo = hardwareMap.get(Servo.class, config.FeedingServoName);
    }

    /**
     * this function gets the current rpm of the flywheel
     * @returns the speed in rotations per minute
     */
    public double getFlywheelRpm(){
        timer.reset();
        lastPosition = highSpeedFlywheel.getCurrentPosition();
        difference = highSpeedFlywheel.getCurrentPosition()-lastPosition;
        tps = (difference/timer.seconds());
        return 60*(tps/ticksPerRev);
    }

    /**
     * this functions sets the speed to the max power
     */
    public void setSpeedToMaxPower(){
        highSpeedFlywheel.setPower(1);
    }
    /**
     * sets the flywheel to a custom speed
     * @param rpm is the speed you wish to set the flywheel to
     */
    public void speedUpFlywheel(double rpm){
        highSpeedFlywheel.setVelocity(rpm/60*311.4);
    }
    //SERVO STUFFFS
    //-------------------------------
    public void servoFeedArtifact(){
        feedingServo.setPosition(config.FeedArtifactValue);
    }
    public void servoResetPosition(){
        feedingServo.setPosition(config.ReloadPosition);
    }





}
