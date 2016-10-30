package net.ftc.tdt2845.robot;

import net.ftc.tdt2845.robot.subsystems.Shooter;

/**
 * Created by Dschi on 10/29/2016.
 */

public class ShootCommand implements Runnable{
    Shooter shooter = null;
    boolean threadKill;

    public ShootCommand(Shooter shooter){
        this.shooter = shooter;

    }

    public void killThread(){
        threadKill = true;
    }


    private void fire(){
        while (shooter.getShooter().getCurrentPosition() < 500 && !threadKill ){
            shooter.getShooter().setPower(1);

        }
        shooter.getShooter().setPower(0);
    }

    private void reset(){
        while ((shooter.getShooter().getCurrentPosition() >= 10  || !shooter.getStopButton().isPressed()) && !threadKill){
            shooter.getShooter().setPower(-.50);
            shooter.getShootingServo().setPosition(.85);
        }
        shooter.getShooter().setPower(0);
        shooter.getShootingServo().setPosition(.25);


    }

    @Override
    public void run() {
        fire();
        reset();


    }
}
