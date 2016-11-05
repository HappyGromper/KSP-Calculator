package net.ftc.tdt2845.opmodes;

/**
 * Created by Dschi on 10/5/2016.
 */



import android.util.Log;

import net.ftc.tdt2845.robot.ShootCommand;
import net.ftc.tdt2845.robot.TDTRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import net.ftc.tdt2845.robot.TDTColorSensor;
import net.ftc.tdt2845.robot.subsystems.MecanumDriveSystem;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="RedAutonomous", group="Linear Opmode")
public class RedAutonomous extends LinearOpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    TDTRobot tdtRobot;
    ShootCommand shootCommand;


    @Override
    public void runOpMode() throws InterruptedException {
        tdtRobot = new TDTRobot(this);
        shootCommand = new ShootCommand(tdtRobot.getShooter(), this);
        //declare the variable for TDTColorSensor
        TDTColorSensor colorSensor = null;
        tdtRobot.getShooter().getShootingServo().setDirection(Servo.Direction.REVERSE);
        tdtRobot.getShooter().getShootingServo().setPosition(.85);
        tdtRobot.getCollector().dispense(0);
        tdtRobot.getDrivetrain().calibrate();
        waitForStart();

//        Thread thread = new Thread(shootCommand);
//        thread.start();


        shootCommand.run();


        tdtRobot.getCollector().dispense(.25);
        sleep(2000);

        shootCommand.run();

        tdtRobot.getCollector().dispense(0);

        tdtRobot.getDrivetrain().turnRight(81);
        tdtRobot.getDrivetrain().goForward(30, .5);
//        tdtRobot.getDrivetrain().goForward(24, .1);

//        mecanumDriveSystem.goForward(12, .5);



//       Color sensor code that activates once the color is detected.
//        colorSensor = new TDTColorSensor(hardwareMap, telemetry);
//        while(! colorSensor.getRedBlue().equals("red")){
//            //contact Chris Willingham about sleep thread
//            Thread.sleep(1000);
//        }
        while(opModeIsActive()){
            idle();
        }
//        shootCommand.killThread();
        //put in code to push button
    }

}

