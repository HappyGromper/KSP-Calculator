package net.ftc.tdt2845;

/**
 * Created by Dschi on 10/5/2016.
 */



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import net.ftc.tdt2845.robot.TDTColorSensor;
import net.ftc.tdt2845.robot.subsystems.MecanumDriveSystem;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="RedAutonomous", group="Linear Opmode")
public class RedAutonomous extends LinearOpMode
{

    double right = 1;
    double left = 2;

    private ElapsedTime runtime = new ElapsedTime();

    public RedAutonomous(HardwareMap hardwareMap) {
    }

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("message", "before mecanum");
        telemetry.update();

        MecanumDriveSystem mecanumDriveSystem = new MecanumDriveSystem (this);
        //declare the variable for TDTColorSensor
        TDTColorSensor colorSensor = null;

        telemetry.addData("message", "before calibrate");
        telemetry.update();
        mecanumDriveSystem.calibrate();
        telemetry.addData("message", "after calibrate");
        telemetry.update();
        waitForStart();
        telemetry.addData("message", "after waitForStart");
        telemetry.update();
        runtime.reset();
        telemetry.addData("message", "after reset");
        telemetry.update();
        telemetry.addData("message", "after update");
        telemetry.update();

        //Strafing by Power, distance in inches, and direction(right or left)
//        autonomousDriveSystem.strafe(1, 10, right);

        //Moves forward by power and distance in inches
        mecanumDriveSystem.goForward(12, .5);
        telemetry.addData("message", "after goForward");
        telemetry.update();
        mecanumDriveSystem.turnRight(90);
        telemetry.addData("message", "after turnRight");
        telemetry.update();

        //Color sensor code thata ctivates once the color is ditected, //TODO Test code
//        colorSensor = new TDTColorSensor(hardwareMap, telemetry);
//        while(! colorSensor.getRedBlue().equals("red")){
//            //contact Chris Willingham about sleep thread
//            Thread.sleep(1000);
//        }
        //put in code to push button
    }

}

