package net.ftc.tdt2845.robot.subsystems;

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
        collectorServo = hardwareMap.servo.get("collectorServo");
        collectorServo.setDirection(Servo.Direction.REVERSE);
        collector = hardwareMap.dcMotor.get("collector");
    }

    public void collectorIntake(double collectorPower, double servoPosition){
        collector.setPower(collectorPower);
        collectorServo.setPosition(servoPosition);
    }
    public void dispense(double pos){
//        collectorServo.setDirection(-);
        collectorServo.setPosition(pos);

    }
    public void collectorIntake(Gamepad gamepad2){
        collector.setPower(gamepad2.left_stick_y);

//        collector.setPower(gamepad2.left_trigger);
//        collector.setPower(gamepad2.right_trigger*-1);


//        while (gamepad2.right_bumper == true){
//            collectorServo.setPosition(1);
//        }
    }




}
