package net.ftc.tdt2845;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

/**
 * Adding a comment
 */
public abstract class DriveSystem {
    DcMotor frontLeft   = null;
    DcMotor frontRight  = null;
    DcMotor rearLeft    = null;
    DcMotor rearRight   = null;

    HardwareMap hardwareMap = null; // will be set in OpModeManager.runActiveOpMode

    final static int ENCODER_CPR = 1120;
    final static double GEAR_RATIO = 1;
    final static double diameter = 4.0;

    public DriveSystem(HardwareMap hardwareMap) {

       frontLeft = hardwareMap.dcMotor.get("fMotorL");
       frontRight = hardwareMap.dcMotor.get("fMotorR");
       rearLeft = hardwareMap.dcMotor.get("rMotorL");
       rearRight = hardwareMap.dcMotor.get("rMotorR");

    }

}