package net.ftc.tdt2845.robot;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import net.ftc.tdt2845.robot.subsystems.Shooter;

/**
 * Created by Dschi on 10/29/2016.
 */

public class ShootCommand implements Runnable {
    private final OpMode opMode;
    Shooter shooter = null;
    boolean threadKill;


    public ShootCommand(Shooter shooter, OpMode opMode) {
        this.shooter = shooter;
        this.opMode = opMode;

    }

    public void killThread() {
        threadKill = true;
    }


    private void fire() {
        shooter.getShootingServo().setPosition(.85);
//        long targetTime = System.currentTimeMillis() + 2000;
        Log.d("ShootCommand", "fire start");
        while (shooter.getShooter().getCurrentPosition() < 500 && !threadKill /*&& System.currentTimeMillis() < targetTime*/) {
            shooter.getShooter().setPower(1);
            Log.d("ShootCommand", "fire loop");
            if(opMode instanceof LinearOpMode){
                //((LinearOpMode) opMode).idle();
                if (!((LinearOpMode) opMode).opModeIsActive()){
                    break;
                }
            }
            Log.d("ShootCommand", "FIRE FINISHED");

        }
        shooter.getShooter().setPower(0);
    }
    private void reset() {
//        long targetTime = System.currentTimeMillis() + 2000;
        shooter.getShootingServo().setPosition(.25);
        Log.d("ShootCommand", "begin reset");
        while (((shooter.getShooter().getCurrentPosition() >= 10 || !shooter.getStopButton().isPressed()) && !threadKill) /*&& System.currentTimeMillis() < targetTime*/) {
//            shooter.getShootingServo().setPosition(.25);
            shooter.getShooter().setPower(-.50);
            Log.d("ShootCommand", "reset loop");
            if(opMode instanceof LinearOpMode){
                //((LinearOpMode) opMode).idle();
                if (!((LinearOpMode) opMode).opModeIsActive()){
                    break;
                }
            }
        }
        Log.d("ShootCommand", "finished resetting");
        shooter.getShooter().setPower(0);


        shooter.getShootingServo().setPosition(.85);

//        while (shooter.getShooter().getCurrentPosition() <= 10 && shooter.getStopButton().isPressed()){
//            shooter.getShootingServo().setPosition(.25);
//        }
       }


    @Override
    public void run() {
        fire();
        reset();
    }
}
