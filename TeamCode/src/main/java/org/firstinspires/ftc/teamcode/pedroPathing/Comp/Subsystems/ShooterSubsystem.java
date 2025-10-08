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
    private DcMotor intake;
    private double flywheelMaxPower;

    private double ticksPerRev = 311.4;//103.8 originally 1620rpm motor, but 3x gear ratio
    //used for speed calculations
    private double tps = 0;
    private ElapsedTime timer;
    private double lastPosition;
    private double difference;
    Servo feedingServo;
    public DcMotor beltDriver;

    /**
     * default constructor
     * @param hardwareMap is passing hardwareMap to configure
     * @param maxPower is the max power of the flywheel
     */
    public ShooterSubsystem(HardwareMap hardwareMap, double maxPower){
        highSpeedFlywheel = hardwareMap.get(DcMotorEx.class, config.MainFlywheelMotorName);
        highSpeedFlywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        highSpeedFlywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        beltDriver = hardwareMap.get(DcMotor.class, config.BeltMotorName);
        beltDriver.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        beltDriver.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        flywheelMaxPower = maxPower;
        timer = new ElapsedTime();
        feedingServo = hardwareMap.get(Servo.class, config.FeedingServoName);
        intake = hardwareMap.get(DcMotor.class, config.IntakeMotorName);
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
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
        return 60*(tps/ticksPerRev*3);
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
        highSpeedFlywheel.setVelocity((rpm/180)*(311.4));
    }
    //SERVO STUFFFS
    //-------------------------------
    public void setGateClosed(){
        feedingServo.setPosition(config.closedValue);
    }
    public void setGateOpen(){
        feedingServo.setPosition(config.openValue);
    }
    //BELT MOTOR thingies
    //TODO check direction
    public void spinBeltContinuously(){
        beltDriver.setPower(config.BeltMotorPower);
    }
    public void stopBelt(){
        beltDriver.setPower(0);
    }
    public void beltPassArtifactToFlywheel(){
        beltDriver.setTargetPosition(beltDriver.getCurrentPosition() + config.BeltMotorArtifactLength);
        beltDriver.setPower(config.BeltMotorPower);
    }








}
