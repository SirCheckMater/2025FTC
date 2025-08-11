package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Configs.Config;
//outtake subsystem class for the robot
public class Outtake {
    //servos
    private Servo starboard;
    private Servo port;
    //motors
    private DcMotor slides;
    private DcMotor slides2;
    //robot constants
    Config config;
    //PID
    private double targetPosition;
    private double integralSum;
    private double Kp;
    private double Ki;
    private double Kd;
    private double lastError;
    private ElapsedTime timer = new ElapsedTime();
    //states
    outtakeState state;

    /**
     * constructor, initializes servos, motors, and PID variables
     * /*port = hardwareMap.get(Servo.class, config.portServoName);
     *         starboard = hardwareMap.get(Servo.class, config.starboardServoName);
     *         //initialize slides
     *         slides = hardwareMap.get(DcMotor.class, config.StarboardSlideName);
     *         slides2 = hardwareMap.get(DcMotor.class, config.PortSlideName);
     *         slides2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
     *         slides.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);*/

    public Outtake(){
        config = new Config();
        //initialize servos

        //initialize PID variables
        integralSum = 0;
        Kp = 0.002;
        Ki = 0;
        Kd = 0;
        lastError = 0;
        targetPosition = 0;

    }


    public enum outtakeState{
        TRANSFER_4, EXTEND_5, SCORE_6, RELEASE_7, FINISH_8
    }
    //this state is the state for transfering a game element
    public void transfer_4(){

        state = outtakeState.TRANSFER_4;
    }
    //this state is step 5 and solely extends the slides
    public void extend_5(){
        //slides.setTargetPosition(config.VerticalSlidesMaxExtension);
        //updateSlides();
        state = outtakeState.EXTEND_5;
    }
    //this state scores the game element
    public void score_6(){
        state = outtakeState.SCORE_6;
    }
    //this state releases the game element from the claw/outtake
    public void release_7(){
        state = outtakeState.RELEASE_7;
    }
    public void toFloor_8(){
        state = outtakeState.FINISH_8;
    }

    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-
    //slide controlling code

    /**
     * updates the position of the slides by using a PID controller
     */
    /*public void updateSlides(){
        double error = targetPosition - slides.getCurrentPosition();
        integralSum += error * timer.seconds();
        double derivitave = (error - lastError)/ timer.seconds();
        lastError = error;
        timer.reset();
        double output = (error*Kp)+(derivitave*Kd)+(integralSum*Ki);
        slides.setPower(output);
        slides2.setPower(output);
    }

    /**
     * sets the target position of the slides in inches
     * @param pose is the new target position
     */
    /*
    public void setSlidesTargetPosition(double pose){
        targetPosition = pose;
    }*/


}
