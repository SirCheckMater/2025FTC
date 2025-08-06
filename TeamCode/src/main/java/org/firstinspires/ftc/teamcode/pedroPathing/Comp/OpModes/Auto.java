package org.firstinspires.ftc.teamcode.pedroPathing.Comp.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.drivetrain;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Sensors.OdoPods;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems.MecanumDrivetrain;

@Autonomous
public class Auto extends OpMode {
    private MecanumDrivetrain drive;
    private OdoPods pods;

    public enum autoState{
        INIT, PICKUP, SCORE
    }
    int AutoState;
    @Override
    public void init() {
        drive = new MecanumDrivetrain(1);
        AutoState = 0;
        pods = new OdoPods(hardwareMap, drive);
        pods.setPosition(0,0,0);
        telemetry.addData("x:", pods.getX());
        telemetry.addData("y:", pods.getY());
        telemetry.addData("heading:", pods.getHeading());
        telemetry.update();
    }

    @Override
    public void loop() {
        //pods.update();
        telemetry.addData("x:", pods.getX());
        telemetry.addData("y:", pods.getY());
        telemetry.addData("heading:", pods.getHeading());
        telemetry.addData("velocity:", pods.getVelocity());
        telemetry.update();


            if(gamepad1.a) {

                pods.goToPosition(15,0,0,0,0,0,1);


                //pods.update();
                telemetry.addData("going", "");
                telemetry.update();
            }




            }


    }