package net.ftc.tdt2845;

/**
 * Created by Dschi on 10/5/2016.
 */



import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="RedAutonomous", group="Linear Opmode")
public class RedAutonomous extends AutonomousDriveSystem
{

    double right = 1;
    double left = 2;

    private ElapsedTime runtime = new ElapsedTime();

    public RedAutonomous(HardwareMap hardwareMap) {
        super(hardwareMap);
    }

    public void init() {
    }

    public void init_loop() {
    }

    public void start() {
        runtime.reset();
        strafe(1, 10, right);
        goForward(1, 10);

    }

    public void stop() {
    }

}

