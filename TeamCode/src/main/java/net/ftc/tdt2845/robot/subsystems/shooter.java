package net.ftc.tdt2845.robot.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Dschi on 10/22/2016.
 */

public class shooter {
    DcMotor shootingMotor;
    Servo shootingServo;
    HardwareMap hardwareMap=null;
    Telemetry telemetry=null;

    public shooter(HardwareMap hardwareMap, Telemetry telemetry){
        super();
        this.hardwareMap=hardwareMap;
        this.telemetry=telemetry;
        shootingServo.getPosition();
    }

}
