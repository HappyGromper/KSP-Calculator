package net.ftc.tdt2845;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Claudia on 9/24/2016.
 */
public class AutonomousDriveSystem extends DriveSystem {
    public AutonomousDriveSystem(HardwareMap hardwareMap) {
        super(hardwareMap);
    }
    public double adjustDrivePowers(double dist, double pwr){
        /*
        frontLeft.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        frontRight.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rearLeft.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rearRight.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);*/

        /*frontLeft.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        frontRight.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rearRight.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rearLeft.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);*/

        double circumference = Math.PI * diameter;
        double rotations = dist / circumference;
        double counts = rotations * ENCODER_CPR * GEAR_RATIO;

        /*frontRight.setTargetPosition((int) -counts);
        frontLeft.setTargetPosition((int) counts);
        rearLeft.setTargetPosition((int) counts);
        rearRight.setTargetPosition((int) -counts);*/



        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + (int) counts);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + (int) counts);
        rearLeft.setTargetPosition(rearLeft.getCurrentPosition() + (int) counts);
        rearRight.setTargetPosition(rearRight.getCurrentPosition() + (int) counts);

        frontLeft.setPower(pwr);
        frontRight.setPower(pwr);
        rearLeft.setPower(pwr);
        rearRight.setPower(pwr);

        /*frontLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        frontRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        rearLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        rearRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);*/

        return counts;
    }
}
