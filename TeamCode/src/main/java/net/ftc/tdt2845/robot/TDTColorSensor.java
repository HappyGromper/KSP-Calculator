package net.ftc.tdt2845.robot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Dschi on 10/15/2016.
 */

public class TDTColorSensor {
    HardwareMap hardwareMap=null;
    Telemetry telemetry=null;
    ColorSensor colorSensor;

    public TDTColorSensor(HardwareMap hardwareMap, Telemetry telemetry) {
        super();
        this.hardwareMap=hardwareMap;
        this.telemetry=telemetry;
        colorSensor = hardwareMap.colorSensor.get("sensor_color");
        colorSensor.enableLed(true);
    }
    public String getRedBlue(){
        String color=null;
        int red = colorSensor.red();
        int blue = colorSensor.blue();
        int green = colorSensor.green();
        telemetry.addData("Clear", colorSensor.alpha());
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue ", colorSensor.blue());

        if (red > 0){
            color = "red";
        }
        else if (blue > 0){
            color="blue";
        }
        else {
            color= "neither";
        }
        return color;
    }
}
