package net.ftc.tdt2845.robot;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import net.ftc.tdt2845.robot.subsystems.Collector;

/**
 * Created by Dschi on 11/2/2016.
 */

public class DispenseCommand implements Runnable{
    Collector dispenser = null;
    boolean threadKill;

    public DispenseCommand(Collector dispenser){
        this.dispenser = dispenser;

    }

    public void killThread(){
        threadKill = true;
    }


    private void setDispenser(){
        dispenser.dispense(-1);

    }

    private void resetDispenser(){
        dispenser.dispense(-1);

    }

//    private void waitDispenser() throws InterruptedException {
//        dispenser.dispense();
//        wait(100000);
//    }

    @Override
    public void run() {
        setDispenser();
//        resetDispenser();


    }
}
