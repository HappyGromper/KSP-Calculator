package net.ftc.tdt2845;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Claudia on 9/24/2016.
 */
public class MecanumDriveSystem extends DriveSystem {
    public MecanumDriveSystem(HardwareMap hardwareMap) {
        super(hardwareMap);
    }
    public void adjustPower(Gamepad gamepad1) {

//        double speed = gamepad1.left_stick_y;
//        double rotation = gamepad1.left_stick_x * Math.PI;
//        double changeDirection = gamepad1.right_stick_x;

        double speed = gamepad1.left_stick_x;
        double rotation = gamepad1.left_stick_y * Math.PI;
        double changeDirection = gamepad1.right_stick_y;

        frontLeft.setPower((speed * Math.sin(rotation + Math.PI / 4)*.5) + changeDirection);
        frontRight.setPower((speed * Math.cos(rotation + Math.PI / 4)*.5) - changeDirection);
        rearLeft.setPower((speed * Math.sin(rotation + Math.PI / 4)*.5) + changeDirection);
        rearRight.setPower((speed * Math.cos(rotation + Math.PI / 4)*.5) - changeDirection);
    }

}

