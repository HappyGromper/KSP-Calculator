package net.ftc.tdt2845.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Dschi on 10/29/2016.
 */

public class Collector {
    private DcMotor collector;
    private Servo collectorServo;



    public Collector (HardwareMap hardwareMap, Telemetry telemetry) {
        super();
        collectorServo = hardwareMap.servo.get("collectorServo");
        collector = hardwareMap.dcMotor.get("collector'");
    }

    public void collectorIntake(double collectorPower, double servoPosition){
        collector.setPower(collectorPower);
        collectorServo.setPosition(servoPosition);
    }

    public void collectorIntake(Gamepad gamepad2){
        collector.setPower(gamepad2.left_trigger);
        if (gamepad2.left_bumper){
            collector.setPower(-1);
        }
        if (gamepad2.right_bumper){
            collectorServo.setPosition(1);
        }
    }




}
