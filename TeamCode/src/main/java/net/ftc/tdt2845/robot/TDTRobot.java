package net.ftc.tdt2845.robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import net.ftc.tdt2845.robot.subsystems.MecanumDriveSystem;

/**
 * Created by chris on 10/10/16.
 */

public class TDTRobot {
    private MecanumDriveSystem drivetrain;


    public TDTRobot(OpMode opMode){
        drivetrain = new MecanumDriveSystem(opMode.hardwareMap);

    }

    public MecanumDriveSystem getDrivetrain() {
        return drivetrain;
    }
}
