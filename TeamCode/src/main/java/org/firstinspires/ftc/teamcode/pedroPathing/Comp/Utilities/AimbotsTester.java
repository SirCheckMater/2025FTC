package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Utilities;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Sensors.OdoPods;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems.MecanumDrivetrain;
@TeleOp

public class AimbotsTester extends OpMode {
    MecanumDrivetrain drivetrain;
    OdoPods pods;
    public Aimbots aimBots;
    @Override
    public void init() {
        drivetrain = new MecanumDrivetrain(1, hardwareMap);
        pods = new OdoPods(hardwareMap, drivetrain);
        pods.setPosition(72,72,0);
        aimBots = new Aimbots(true, pods);;
    }

    @Override
    public void loop() {
        telemetry.addData("x", pods.getX());
        telemetry.addData("y",pods.getY());
        telemetry.addData("h",pods.getHeading());
        telemetry.addData("ideal h", aimBots.getIdealRobotAngle());
        telemetry.update();
        pods.update();

        if(gamepad1.a){
            if(pods.holdPosition(pods.getX(),pods.getY(),aimBots.getIdealRobotAngle(),1)){
                pods.update();
            }
        }
        drivetrain.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }
}
