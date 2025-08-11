package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Configs.Config;
//intake subsystem class for the robot
public class Intake {
    //robot config
    private Config config;
    //claw + wrist declerations
    private Servo wrist;
    private Servo claw;
    //slide declerations
    DcMotor slides;
    //pid variables
    private double targetPosition;
    private double integralSum;
    private double Kp;
    private double Ki;
    private double Kd;
    private double lastError;
    private ElapsedTime timer = new ElapsedTime();
    private Intakestate intakeState;
    //constructor
    public Intake(){
        //create new instance of the configuration
        config = new Config();
        //new servo instances for the intake class

        //initialize the horizontal slides motor
        //slides = hardwareMap.get(DcMotor.class, config.HSlides);
        //slides.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //initialize variables used for the PID
        integralSum = 0;
        Kp = 0.002;
        Ki = 0;
        Kd = 0;
        lastError = 0;
        targetPosition = 0;
        //intakeState
    }
    //states for the intake
    private enum Intakestate {
        PICKUP_0, GRAB_1, RETRACT_2, TRANSFER_3, INIT, RELEASE,
    }
    //this state extends the slides, opens the claw, and puts the wrist in pickup position
    public void Pickup_0(){
        /*setHorizontalSlidesTargetPosition(config.PickupSlidesPose);
        updateSlides();
        wrist.setPosition(config.pickupPose);
        claw.setPosition(config.clawOpen);*/
        intakeState = Intakestate.PICKUP_0;
    }
    //this state closes the claw on a game element
    public void Grab_1(){
       // claw.setPosition(config.clawClose);
        intakeState = Intakestate.GRAB_1;
    }
    //this state retracts the slides back in and prepares for a transfer
    public void Retract_2(){
        /*wrist.setPosition(config.travelPose);
        setHorizontalSlidesTargetPosition(config.RetractedSlidesPose);
        updateSlides();*/
        intakeState = Intakestate.RETRACT_2;
    }
    //this state transfers the game element to the outtake
    public void Transfer_3(){
        //wrist.setPosition(config.transferPose);
        intakeState = Intakestate.TRANSFER_3;
    }


    //slide PID controllers
    /*public void setHorizontalSlidesTargetPosition(double target){
        if(targetPosition >= config.slidesStrokeLength){
            targetPosition = config.slidesStrokeLength;
        }
        else if(targetPosition <= 0){
            targetPosition = 0;
        }
        else{
            targetPosition = target;
        }
    }

    public void updateSlides(){
        double error = targetPosition - (slides.getCurrentPosition()/(config.encoderRes/config.slidesStrokeLength));
        integralSum += error * timer.seconds();
        double derivitave = (error - lastError)/ timer.seconds();
        lastError = error;
        timer.reset();
        double output = (error*Kp)+(derivitave*Kd)+(integralSum*Ki);
        slides.setPower(output);

    }*/

}
