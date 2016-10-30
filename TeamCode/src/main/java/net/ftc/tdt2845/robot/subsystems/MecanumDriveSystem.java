package net.ftc.tdt2845.robot.subsystems;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Arko Ghosh on 10/02/2016.
 */
public class MecanumDriveSystem extends DriveSystem {
    // constant variable to manipulate the power equally for all drive motors
    static final private double TRANSLATIONAL_POWER_FACTOR = 1;
    static final private double ROTATIONAL_POWER_FACTOR = 0.5;

    // constant variable to check for THRESHOLD for joystick x, y values
    static final private double THRESHOLD = 0.2;
    public MecanumDriveSystem(OpMode opMode) {
        super(opMode);

    }
    public void adjustPower(Gamepad gamepad1) {


        // Note: y values are reversed to align with forward direction

        // y for forward and backward motion; and for diagonal motion (in conjunction with x)
        double y = gamepad1.left_stick_y * TRANSLATIONAL_POWER_FACTOR;
        // x for right and left motion; and for diagonal motion (in conjunction with y)
        double x = gamepad1.right_stick_x * TRANSLATIONAL_POWER_FACTOR;
        // for rotation
        double rotation = gamepad1.left_stick_x * ROTATIONAL_POWER_FACTOR;

        // for curve (in conjunction with y)
//        double y2 = gamepad1.right_stick_y * TRANSLATIONAL_POWER_FACTOR;

        // in following logic, check for THRESHOLD is necessary
        // to avoid unintended push or pull of joystick by driver

        // go forward or backward
        if( Math.abs(y) > THRESHOLD && Math.abs(x)<= THRESHOLD)
        {
            // left joystick is pushed forward or pulled backward only (i.e. y only, no x)
            // right joystick is not used
            // y positive (i.e. left joystick pushed forward away from driver) means forward motion
            // y negative (i.e. left joystick pushed backward towards driver)means backward motion
            frontLeft.setPower(-y);
            frontRight.setPower(y);
            rearLeft.setPower(-y);
            rearRight.setPower(y);
        }
        // go left or right
        else if( Math.abs(x) > THRESHOLD && Math.abs(y)<= THRESHOLD)
        {
            // right joystick is pushed right or left only (i.e. x only, no y)
            // left joystick is not used
            // x positive (i.e. right joystick pushed righ
            // t) means right motion
            // x negative (i.e. right joystick pushed left) means left motion
            frontLeft.setPower(x);
            frontRight.setPower(x);
            rearLeft.setPower(-x);
            rearRight.setPower(-x);
        }
        // rotate
        else if( Math.abs(rotation) > THRESHOLD )
        {
            // left joystick is pushed left or right only(i.e. x only, no y)
            // right joystick is not used
            // rotation positive (i.e. left joystick pushed right) means clockwise rotation
            // rotation negative (i.e. left joystick pushed left) means counter clockwise motion
            frontLeft.setPower(rotation);
            frontRight.setPower(rotation);
            rearLeft.setPower(rotation);
            rearRight.setPower(rotation);
        }
        // go diagonal - forward right, forward left, backward right, backward left
        else if( Math.abs(y) > THRESHOLD && Math.abs(x) > THRESHOLD) {
            // left joystick is pushed forward or pulled backward only (i.e. y only, no x)

            // and r,ight joystick is pushed right or left only (i.e. x only, no y)
            if (y < 0 && x > 0) {
                // forward right
                frontLeft.setPower(-y);
                frontRight.setPower(0);
                rearLeft.setPower(0);
                rearRight.setPower(y);
            } else if (y < 0 && x < 0) {
                // forward left
                frontLeft.setPower(0);
                frontRight.setPower(y);
                rearLeft.setPower(-y);
                rearRight.setPower(0);
            } else if (y > 0 && x > 0) {
                // backward right
                frontLeft.setPower(0);
                frontRight.setPower(y);
                rearLeft.setPower(-y);
                rearRight.setPower(0);
            } else if (y >  0 && x < 0) {
                // backward left
                frontLeft.setPower(-y);
                frontRight.setPower(0);
                rearLeft.setPower(0);
                rearRight.setPower(y);
            }
            else
            {
              stop();
            }
        }
        // go in curve
//        else if( Math.abs(y) > THRESHOLD && Math.abs(y2) > THRESHOLD)
//        {
//            // ensure both y and y2 values have the same sign
//            // (pushed the same direction) to avoid rotational turn above
//            if ((y > 0 && y2 >0 ) || (y < 0 && y2 < 0))
//            {
//                frontLeft.setPower(-y);
//                frontRight.setPower(y2);
//                rearLeft.setPower(-y);
//                rearRight.setPower(y2);
//            }
//            else
//            {
//              stop();
//            }
//        }
        else
        {
          stop();
        }
        // TODO: Implement lateral arc, if needed by the team
    }

    public void goForward(double distance, double power)  {
        double WHEEL_DIAMETER = 4;
        //double GEAR_RATIO = 16 / 9; //output sprocket over driven sprocket
        double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
        double TICKS_PER_ROTATION = 1440;
        double TICKS_PER_INCH = TICKS_PER_ROTATION/WHEEL_CIRCUMFERENCE;
        double targetTick = distance*TICKS_PER_INCH;//((distance / WHEEL_CIRCUMFERENCE) * TICKS_PER_ROTATION);
        double targetPosition = frontLeft.getCurrentPosition() + targetTick;

        start(power);
        while (!getLinearOpMode().isStopRequested() && frontLeft.getCurrentPosition() < targetPosition)  {
            //getLinearOpMode().sleep(50);
            getLinearOpMode().idle();
        }
        stop();
    }
    public void turnRight (int degrees){
        int currentHeading = gyro.getHeading();
        int targetHeading = currentHeading+degrees;
        frontLeft.setPower(1);
        rearLeft.setPower(1);
        frontRight.setPower(-1);
        rearRight.setPower(-1);

        while (gyro.getHeading() < targetHeading){
            getLinearOpMode().sleep(1);
            getLinearOpMode().idle();
        }
        stop();

    }
    public void calibrate(){
        gyro.calibrate();

        // make sure the gyro is calibrated.
        while (!getLinearOpMode().isStopRequested() && gyro.isCalibrating())  {
            getLinearOpMode().sleep(50);
            getLinearOpMode().idle();
        }
    }

    private void stop()
    {
      frontLeft.setPower(0);
      frontRight.setPower(0);
      rearLeft.setPower(0);
      rearRight.setPower(0);
    }
	
	private void start(double power)
    {
      frontLeft.setPower(power);
      frontRight.setPower(-power);
      rearLeft.setPower(power);
      rearRight.setPower(-power);
    }

}
