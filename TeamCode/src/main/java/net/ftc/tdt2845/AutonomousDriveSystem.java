package net.ftc.tdt2845;

import com.qualcomm.robotcore.hardware.HardwareMap;

import net.ftc.tdt2845.robot.subsystems.DriveSystem;

/**
 * Created by Claudia on 9/24/2016.
 */
public class AutonomousDriveSystem extends DriveSystem {
    public AutonomousDriveSystem(HardwareMap hardwareMap) {
        super(hardwareMap);
    }

    public double strafe(double pwr, double dist, double dirct){
        //Formula for autonomous
//        double WHEEL_DIAMETER = 2;
//        double GEAR_RATIO = 16 / 9; //output sprocket over driven sprocket
//        double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
//        double TICKS_PER_ROTATION = 1440;
//        double targetTick = ((distance / WHEEL_CIRCUMFERENCE) * TICKS_PER_ROTATION) / 2;





        double circumference = Math.PI * WHEEL_DIAMETER;
        double rotations = dist / circumference;
        double counts = rotations * ENCODER_CPR * GEAR_RATIO;

        //if dirct = 1 right
        //if dirct = 2 left

        //if the direction = 1 then the robot will strafe right at the speed of the set power, to the set distance
        if (dirct == 1) {
            frontLeft.setPower(pwr);
            frontRight.setPower(pwr);
            rearLeft.setPower(pwr * -1);
            rearRight.setPower(pwr * -1);
        }
        //if the direction = 2 then the robot will strafe left at the speed of the set power, to the set distance
        if (dirct == 2) {
            frontLeft.setPower(pwr * -1);
            frontRight.setPower(pwr * -1);
            rearLeft.setPower(pwr);
            rearRight.setPower(pwr);
        }

        //runs motors to set position reads current position and the target position
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + (int) counts);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + (int) counts);
        rearLeft.setTargetPosition(rearLeft.getCurrentPosition() + (int) counts);
        rearRight.setTargetPosition(rearRight.getCurrentPosition() + (int) counts);

        return counts;
    }


    //Moves forward by distance in inches and by the set power
    public double goForward(double dist, double pwr){
//        /*
//        frontLeft.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
//        frontRight.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
//        rearLeft.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
//        rearRight.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);*/
//
//        /*frontLeft.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
//        frontRight.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
//        rearRight.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
//        rearLeft.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);*/
//
//
//        /*frontRight.setTargetPosition((int) -counts);
//        frontLeft.setTargetPosition((int) counts);
//        rearLeft.setTargetPosition((int) counts);
//        rearRight.setTargetPosition((int) -counts);*/
//        /*frontLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
//          frontRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
//          rearLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
//          rearRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);*/

        double circumference = Math.PI * WHEEL_DIAMETER;
        double rotations = dist / circumference;
        double counts = rotations * ENCODER_CPR * GEAR_RATIO;

        //runs motors to set position reads current position and the target position
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + (int) counts);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + (int) counts);
        rearLeft.setTargetPosition(rearLeft.getCurrentPosition() + (int) counts);
        rearRight.setTargetPosition(rearRight.getCurrentPosition() + (int) counts);

        frontLeft.setPower(pwr);
        frontRight.setPower(pwr);
        rearLeft.setPower(pwr);
        rearRight.setPower(pwr);


        return counts;
    }
}
