package org.firstinspires.ftc.teamcode.pedroPathing.Comp.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.drivetrain;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Sensors.OdoPods;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems.MecanumDrivetrain;
@Config
@Autonomous
public class Auto extends OpMode {
    private MecanumDrivetrain drive;
    private OdoPods pods;
    public static double nextx = 0;
    public static double nexty = 0;
    public static double nextheading = 0;
    public static double nextspeed = 1;
    public static int AutoState = 0;
    @Override
    public void init() {
        drive = new MecanumDrivetrain(1, hardwareMap);
        AutoState = 0;
        pods = new OdoPods(hardwareMap, drive);
        pods.setPosition(0,0,0);
        telemetry.addData("x:", pods.getX());
        telemetry.addData("y:", pods.getY());
        telemetry.addData("heading:", pods.getHeading());
        telemetry.update();


    }
    void driveToPosition(double x, double y, double nextheading, double speed){
        if(pods.holdPosition(nextx,nexty,nextheading,nextspeed)){
            telemetry.addData("driving, state: ", AutoState);
        }
    }
    @Override
    public void loop() {
        pods.update();
        telemetry.addData("x:", pods.getX());
        telemetry.addData("y:", pods.getY());
        telemetry.addData("heading:", pods.getHeading());
        telemetry.addData("velocity:", pods.getVelocity());
        telemetry.update();
        switch(AutoState){

            case 0:
                nexty = 15;
                driveToPosition(nextx,nexty,nextheading,nextspeed);
                nextheading = 90;
                driveToPosition(nextx,nexty,nextheading,nextspeed);
                AutoState = 1;
                break;
            case 1:
                nextx = 15;
                driveToPosition(nextx,nexty,nextheading,nextspeed);
                nextheading = 90;
                driveToPosition(nextx,nexty,nextheading,nextspeed);
                AutoState = 2;
                break;
            /*case 2:
                nexty = 15;
                driveToPosition(nextx,nexty,nextheading,nextspeed);
                nextheading = 90;
                driveToPosition(nextx,nexty,nextheading,nextspeed);
                AutoState = 3;
                break;
            case 3:
                nexty = 15;
                driveToPosition(nextx,nexty,nextheading,nextspeed);
                nextheading = 90;
                driveToPosition(nextx,nexty,nextheading,nextspeed);
                break;*/
        }







            }


    }