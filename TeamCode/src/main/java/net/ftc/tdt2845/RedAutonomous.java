package net.ftc.tdt2845;

/**
 * Created by Dschi on 10/5/2016.
 */



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import net.ftc.tdt2845.robot.TDTColorSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="RedAutonomous", group="Linear Opmode")
public class RedAutonomous extends LinearOpMode
{

    double right = 1;
    double left = 2;

    private ElapsedTime runtime = new ElapsedTime();

    public RedAutonomous(HardwareMap hardwareMap) {
    }

    @Override
    public void runOpMode() throws InterruptedException {

            //declare the variable for TDTColorSensor
        TDTColorSensor colorSensor = null;

        waitForStart();
        runtime.reset();
        AutonomousDriveSystem autonomousDriveSystem = new AutonomousDriveSystem(hardwareMap);

        autonomousDriveSystem.strafe(1, 10, right);
        autonomousDriveSystem.goForward(1, 10);
        colorSensor = new TDTColorSensor(hardwareMap, telemetry);
        while(! colorSensor.getRedBlue().equals("red")){
            //contact Chris Willingham about sleep thread
            Thread.sleep(1000);
        }
        //put in code to push button



    }


}

