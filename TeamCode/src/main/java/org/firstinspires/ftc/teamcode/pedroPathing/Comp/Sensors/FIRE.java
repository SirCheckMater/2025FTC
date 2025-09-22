package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Sensors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.sun.tools.javac.tree.DCTree;

import java.util.Timer;
@TeleOp
public class FIRE extends OpMode {
    DcMotor shooter;
    public double ticksPerRev;
    public ElapsedTime timer;
    public double rpm;
    public double lastPosition;
    public double difference;
    public double time;
    public double power;
    public double tps;
    public Gamepad currentGamepad1 = new Gamepad();
    public Gamepad previousGamepad1 = new Gamepad();
    @Override
    public void init() {
        ticksPerRev = 103.8;
        timer = new ElapsedTime();
        timer.milliseconds();
        shooter = hardwareMap.get( DcMotor.class,"shooter");
        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rpm = 0;
        power = 1;
    }

    @Override
    public void loop() {
        previousGamepad1.copy(currentGamepad1);
        currentGamepad1.copy(gamepad1);
        timer.reset();
        lastPosition = shooter.getCurrentPosition();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shooter.setPower(power);
        difference = shooter.getCurrentPosition()-lastPosition;
        time = timer.seconds();
        tps = (difference/time);
        rpm = 60*(tps/ticksPerRev);
        if(currentGamepad1.dpad_down && !previousGamepad1.dpad_down){
            power -= 0.05;
        }
        if(currentGamepad1.dpad_up && !previousGamepad1.dpad_up){
            power += 0.05;
        }
        telemetry.addData("power", power);
        telemetry.addData("rpm", rpm);
        telemetry.update();

    }
}
