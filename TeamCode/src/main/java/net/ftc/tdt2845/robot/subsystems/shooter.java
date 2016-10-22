package net.ftc.tdt2845.robot.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Dschi on 10/22/2016.
 */

public class Shooter {
    DcMotor shootingMotor;
    Servo shootingServo;
    HardwareMap hardwareMap=null;
    Telemetry telemetry=null;
    double shootPosition = 0;
//    double reloadPosition;

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        super();
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        shootingServo = hardwareMap.servo.get("shootingServo");
        if (shootingServo == null){
            telemetry.addData("shooting servo null", "null");
            telemetry.update();
        }

    }

    public void getShooterPosition (){
        shootingServo.getPosition();
        telemetry.addData("Position", shootingServo.getPosition());
        telemetry.update();
    }

    public void reload(Gamepad gamepad1) {
        shootingServo.getPosition();
        if (gamepad1.a){
        shootingServo.setPosition(.85);
        }
    }
    public void shoot(Gamepad gamepad1) {
        shootingServo.getPosition();
        if (gamepad1.b){
            shootingServo.setPosition(.25);
        }
    }
//
//    }
//
//    public void reset(){
//        shootingServo.getPosition();
//        while (shootingServo.getPosition() != reloadPosition){
//            //TURN SERVO
//
        }


