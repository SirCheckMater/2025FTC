package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Configs;

public class Config {
//
    //drivetrain
    public final String backLeft = "backLeft";
    public final String frontLeft = "frontLeft";
    public final String backRight = "backRight";
    public final String frontRight = "frontRight";
    //-------------------------------------------------------------------------
    //Shotter class
    //-------------------------------------------------------------------------
    //flywheel stuff
    public final String MainFlywheelMotorName = "shooter";
    public final String BeltMotorName = "beltMotor";
    public final double BeltMotorPower = 0.5;
    public final int BeltMotorArtifactLength = 537;

    //feedingServo values and names
    public final String FeedingServoName = "feedingServo";
    public final double openValue = 1;
    public final double closedValue = 0;
    //intake values
    public final String IntakeMotorName = "intake";


    //pathing values
    public final double RedAllianceTargetX = 140;
    public final double RedAllianceTargetY = 140;
    public final double BlueAllianceTargetY = 140;
    public final double BlueAllianceTargetX = 4;
    public int maxRpm = 3000;

}
