package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Configs;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems.Outtake;
@TeleOp
public class SlidesTester extends OpMode {
    Outtake slides;
    @Override
    public void init() {
        slides = new Outtake(hardwareMap);
    }

    @Override
    public void loop() {
        slides.setPower(gamepad1.right_stick_y);
    }
}
