package net.ftc.tdt2845.robot.subsystems;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotorController;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Dschi on 10/22/2016.
 */

public class Shooter {
    private TouchSensor stopButton;
    private DcMotor shootingMotor;
    private Servo shootingServo;
    private HardwareMap hardwareMap=null;
    private Telemetry telemetry=null;
//    double motorPos = shootingMotor.getCurrentPosition();
    int shootPosition = 0;
//    double reloadPosition;

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        super();
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        shootingServo = hardwareMap.servo.get("shootingServo");
        shootingMotor = hardwareMap.dcMotor.get("shootingMotor");
        stopButton = hardwareMap.touchSensor.get("stop button");
        shootingMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shootingServo.setPosition(.25);
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

    public void ShootSystem(Gamepad gamepad1) {
        shootingServo.getPosition();
        shootingServo.setPosition(.25);
        if (gamepad1.a) {

            while (shootingMotor.getCurrentPosition() < 300 ){
                shootingMotor.setPower(.5);
            }
            if (shootingMotor.getCurrentPosition() >= 300 ){
                shootingMotor.setPower(0);
            }

            if (shootingMotor.getCurrentPosition() >= 300 ){
                shootingServo.setPosition(.85);

            } if (shootingMotor.getCurrentPosition() >= 300 && shootingServo.getPosition() == .85){
                shootingMotor.setPower(-.5);

            } if (shootingMotor.getCurrentPosition() <= -200){
                shootingMotor.setPower(0);
            }


//
//        }
//
//
//        if (gamepad1.a){
//            shootingMotor.setTargetPosition(300);
//
//
//        }
//        if (shootingMotor.getCurrentPosition() == 300 && gamepad1.b) {
//            shootingServo.setPosition(.85);
//            shootingMotor.setTargetPosition(-200);
//        }
//        if (shootingMotor.getCurrentPosition() == -200 && gamepad1.y) {
//            shootingServo.setPosition(.25);
//        }


        }
    }

    public void getMotor(){
        shootingMotor.getCurrentPosition();
        telemetry.addData("Shooter Pos:", shootingMotor.getCurrentPosition());
//        shootingMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //-200 is lowest point from prime shooting position
        //300 is a good height to set for the finish rotation

    }

    public void reload(Gamepad gamepad1) {
        shootingServo.getPosition();
        if (gamepad1.a){
        shootingServo.setPosition(.85);
        }
//        else {
//            shootingServo.setPosition(.5);
//        }
    }
    public void shootPos() {
        shootingServo.getPosition();

        if (shootingServo.getPosition() != .25) {
            shootingServo.setPosition(.25);
        }
    }

    public DcMotor getShooter(){
        return shootingMotor;

    }
    public Servo getShootingServo(){
        return  shootingServo;
    }

    public TouchSensor getStopButton() {
        return stopButton;
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


