package net.ftc.tdt2845.robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import net.ftc.tdt2845.robot.subsystems.MecanumDriveSystem;

/**
 * Created by chris on 10/10/16.
 */

public class TDTRobot {
    public MecanumDriveSystem drivetrain;

    public TDTRobot(OpMode opMode){
        drivetrain = new MecanumDriveSystem(opMode.hardwareMap);
    }
}
