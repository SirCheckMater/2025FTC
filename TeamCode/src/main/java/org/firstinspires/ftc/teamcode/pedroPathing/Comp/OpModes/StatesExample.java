package org.firstinspires.ftc.teamcode.pedroPathing.Comp.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Config
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class StatesExample extends OpMode {
    public static int AutoState;
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        telemetry.addData("AutoState", AutoState);
        telemetry.update();
        switch(AutoState){
            case 0:
                telemetry.addData("AutoState", AutoState);
                telemetry.update();
                //put code here
                if(gamepad1.a){
                    AutoState = 1;
                    break;
                }
            case 1:
                //put code here
                telemetry.addData("AutoState", AutoState);
                telemetry.update();
                //if a is pressed go to the next state
                if(gamepad1.a){
                    AutoState = 2;
                    break;
                }
                //if b is pressed go back to the previous state
                else if(gamepad1.b){
                    AutoState = 1;
                    break;
                }
            case 2:
                //put code here
                telemetry.addData("AutoState", AutoState);
                telemetry.update();
                //if a is pressed go to the next state
                if(gamepad1.a){
                    AutoState = 3;
                    break;
                }
                //if b is pressed go back to the previous state
                else if(gamepad1.b){
                    AutoState = 2;
                    break;
                }

        }
    }
}
