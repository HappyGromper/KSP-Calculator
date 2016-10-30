package net.ftc.tdt2845.robot.subsystems;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
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
    static final private double TRANSLATIONAL_POWER_FACTOR = 0.5;
    static final private double ROTATIONAL_POWER_FACTOR = 0.5;

    // constant variable to check for THRESHOLD for joystick x, y values
    static final private double THRESHOLD = 0.2;
    HardwareMap hardwareMap = null; // will be set in OpModeManager.runActiveOpMode
    protected ModernRoboticsI2cGyro gyro;
    protected LinearOpMode linearOpMode;

    public final static int ENCODER_CPR = 1120;
    public final static double GEAR_RATIO = 1;
    public final static double WHEEL_DIAMETER = 4.0;

    public DriveSystem(OpMode opMode) {
        this.linearOpMode = (LinearOpMode) opMode;
        hardwareMap = opMode.hardwareMap;
        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyro");

       frontLeft = hardwareMap.dcMotor.get("fMotorL");
       frontRight = hardwareMap.dcMotor.get("fMotorR");
       rearLeft = hardwareMap.dcMotor.get("rMotorL");
       rearRight = hardwareMap.dcMotor.get("rMotorR");

    }

}