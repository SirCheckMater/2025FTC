package org.firstinspires.ftc.teamcode.pedroPathing.Comp.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.drivetrain;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Subsystems.Outtake;

// This is our main Teleop Class. It uses x, y ,z classes and calls into a, b, c functions, etc.
// It inherits capabilites from dfg
// It depends on Pedropath, etc.
public class TeleOp extends OpMode {
    // move this to inside intake

    // move this to inside outake

    drivetrain chassis;

    Intake intake;

    Outtake outtake;
    public int state;
    @Override
    public void init() {
        //TODO check motor direction
        state = 0;
        intake = new Intake();
        outtake = new Outtake();
    }
    @Override
    public void loop() {
        if(gamepad1.a) {
            switch (state) {
                case 0:
                    intake.Pickup_0();
                    while (!gamepad1.right_bumper) {
                        //basically just wait for button press
                    }
                    state = 1;
                    break;
                case 1:
                    intake.Grab_1();
                    while (!gamepad1.right_bumper) {

                    }
                    state = 2;
                    break;
                case 2:
                    intake.Transfer_3();
                    outtake.transfer_4();
                    while (!gamepad1.right_bumper) {

                    }
                    state = 3;
                    break;
                case 3:
                    outtake.extend_5();

                    while (!gamepad1.right_bumper) {

                    }
                    state = 5;
                    break;
                case 4:
                    outtake.score_6();
                    while (!gamepad1.right_bumper) {

                    }
                    state = 6;
                    break;
                case 5:
                    outtake.release_7();
                    while (!gamepad1.right_bumper) {

                    }
                    break;
            }
        }

        chassis.navigate(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }

}
