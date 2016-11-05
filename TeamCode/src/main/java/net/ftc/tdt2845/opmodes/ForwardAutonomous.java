package net.ftc.tdt2845.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import net.ftc.tdt2845.robot.subsystems.MecanumDriveSystem;

/**
 * Created by Dschi on 11/4/2016.
 */

@Autonomous(name="Forward Autonomous", group="Linear Opmode")
public class ForwardAutonomous extends BaseLinearOpMode{
    @Override
    public void autonomousRun() {

        tdtRobot.getDrivetrain().goForward(12, 1);
    }
}
