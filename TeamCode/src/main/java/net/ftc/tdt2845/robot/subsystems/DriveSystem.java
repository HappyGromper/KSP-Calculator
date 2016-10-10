package net.ftc.tdt2845.robot.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Adding a comment
 */
public abstract class DriveSystem {
    protected DcMotor frontLeft   = null;
    protected DcMotor frontRight  = null;
    protected DcMotor rearLeft    = null;
    protected DcMotor rearRight   = null;

    HardwareMap hardwareMap = null; // will be set in OpModeManager.runActiveOpMode

    public final static int ENCODER_CPR = 1120;
    public final static double GEAR_RATIO = 1;
    public final static double WHEEL_DIAMETER = 4.0;

    public DriveSystem(HardwareMap hardwareMap) {

       frontLeft = hardwareMap.dcMotor.get("fMotorL");
       frontRight = hardwareMap.dcMotor.get("fMotorR");
       rearLeft = hardwareMap.dcMotor.get("rMotorL");
       rearRight = hardwareMap.dcMotor.get("rMotorR");

    }

}