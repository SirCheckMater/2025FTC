package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Utilities.Config;

public class Outtake {
    private Servo starboard;
    private Servo port;
    Config config;
    private double targetPosition;
    private double integralSum;
    private DcMotor slides;
    private DcMotor slides2;
    private double Kp;
    private double Ki;
    private double Kd;
    private double lastError;
    private ElapsedTime timer = new ElapsedTime();

    /**
     * constructor that initializes everything
     */
    public Outtake(){
        config = new Config();
        //initialize servos
        port = hardwareMap.get(Servo.class, config.portServoName);
        starboard = hardwareMap.get(Servo.class, config.starboardServoName);
        //initialize slides
        slides = hardwareMap.get(DcMotor.class, config.StarboardSlideName);
        slides2 = hardwareMap.get(DcMotor.class, config.PortSlideName);
        slides2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slides.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //initialize PID variables
        integralSum = 0;
        Kp = 0.002;
        Ki = 0;
        Kd = 0;
        lastError = 0;
        targetPosition = 0;
    }

    public enum outtakeState{
        TRANSFER_4, EXTEND_5, SCORE_6, RELEASE_7
    }
    public void transfer_4(){

    }
    public void extend_5(){

    }
    public void score_6(){

    }
    public void release_7(){

    }

    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-
    //slide controlling code
    public void updateSlides(){
        double error = targetPosition - slides.getCurrentPosition();
        integralSum += error * timer.seconds();
        double derivitave = (error - lastError)/ timer.seconds();
        lastError = error;
        timer.reset();
        double output = (error*Kp)+(derivitave*Kd)+(integralSum*Ki);
        slides.setPower(output);
        slides2.setPower(output);
    }
    public void setSlidesTargetPosition(double pose){
        targetPosition = pose;
    }


}
