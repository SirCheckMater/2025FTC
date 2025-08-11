package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Configs;

public class Config {

    //drivetrain
    public final String backLeft = "backLeft";
    public final String frontLeft = "frontLeft";
    public final String backRight = "backRight";
    public final String frontRight = "frontRight";
    //-------------------------------------------------------------------------
    //Intake
    //-------------------------------------------------------------------------
    public final String clawServoName = "clawServo";
    public final String wristServoName = "wristServo";
    //intake SLIDES values
    public final double degreesMax = 85;
    public final double slidesStrokeLength = 21.25;//inches
    public final String HSlides = "HSlides";
    public final double encoderRes = 5281.1;
    //states SLIDES HORIZONTAL
    public final int PickupSlidesPose = 1;
    public final int RetractedSlidesPose = 0;
    //intake CLAW values
    public final double clawClose = 1;
    public final double clawOpen = 0;
    //intake WRIST values
    public final double pickupPose = 0;
    public final double travelPose = 0;
    public final double transferPose = 0;
    //-------------------------------------------------------------------------
    //Outtake
    //-------------------------------------------------------------------------
    public final String starboardServoName = "starboardServo";
    public final String portServoName = "portServo";
    //outtake states
    public final double OuttaketransferPose = 0.0;
    public final double OuttakescorePose = 0.0;
    public final double OuttaketravelPose = 0.0;
    public final double OuttakeinitPose = 0.0;
    //Vertical SLides
    public final String StarboardSlideName = "StarboardSlide";
    public final String PortSlideName = "PortSlide";
    public final int VerticalSlidesMaxExtension = 100;
    public final int VerticalSlidesToFloor = 0;
}
