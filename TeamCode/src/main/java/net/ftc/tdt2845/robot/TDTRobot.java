package net.ftc.tdt2845.robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import net.ftc.tdt2845.robot.subsystems.MecanumDriveSystem;
import net.ftc.tdt2845.robot.subsystems.Shooter;

/**
 * Created by chris on 10/10/16.
 */

public class TDTRobot {
    private MecanumDriveSystem drivetrain;
    private Shooter shooter;
    private Collector collector;


    public TDTRobot(OpMode opMode){
        drivetrain = new MecanumDriveSystem(opMode);
        shooter = new Shooter(opMode.hardwareMap, opMode.telemetry);
        collector = new Collector(opMode.hardwareMap, opMode.telemetry);
    }

    public MecanumDriveSystem getDrivetrain() {
        return drivetrain;
    }

    public Shooter getShooter() {
        return shooter;
    }

    public Collector getCollector(){
        return collector;
    }
}
