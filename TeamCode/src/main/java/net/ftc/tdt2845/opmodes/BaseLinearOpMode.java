package net.ftc.tdt2845.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import net.ftc.tdt2845.robot.ShootCommand;
import net.ftc.tdt2845.robot.TDTColorSensor;
import net.ftc.tdt2845.robot.TDTRobot;
import net.ftc.tdt2845.robot.subsystems.MecanumDriveSystem;

/**
 * Created by Dschi on 11/4/2016.
 */

public abstract class BaseLinearOpMode extends LinearOpMode {
    public ElapsedTime runtime = new ElapsedTime();
    public TDTRobot tdtRobot;
    public ShootCommand shootCommand;



    @Override
    public void runOpMode() throws InterruptedException {
        tdtRobot = new TDTRobot(this);
        shootCommand = new ShootCommand(tdtRobot.getShooter(), this);
        telemetry.addData("message", "before mecanum");
        telemetry.update();
        MecanumDriveSystem mecanumDriveSystem = new MecanumDriveSystem (this);


        //declare the variable for TDTColorSensor
        TDTColorSensor colorSensor = null;
        waitForStart();
        autonomousRun();
    }

    public abstract void autonomousRun();


}
