package net.ftc.tdt2845.opmodes;

/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;


import com.qualcomm.robotcore.hardware.DcMotor;

import net.ftc.tdt2845.ServoTest;
import net.ftc.tdt2845.robot.TDTRobot;
import net.ftc.tdt2845.robot.subsystems.MecanumDriveSystem;
import net.ftc.tdt2845.robot.subsystems.Shooter;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
@TeleOp(name="MecanumTeleOp", group="Opmode")  // @Autonomous(...) is the other common choice
//@Disabled
//TODO make LinearOpMode into Opmode
public class MecanumTeleOp extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    TDTRobot tdtRobot;
//    MecanumDriveSystem mecanumDriveSystem = null;
    Shooter shooter = null;
//    ServoTest servoTest = null;

//    ColorSensor colSensor;
//    DeviceInterfaceModule dim;
//    static final int LED_CHANNEL = 0;
// DcMotor leftMotor = null;
// DcMotor rightMotor = null;

    /* Declare OpMode members. */

//    @Override
//    public void runOpMode() throws InterruptedException {
//
//
//        MecanumDriveSystem mecanumDriveSystem = new MecanumDriveSystem(hardwareMap);
//        telemetry.addData("Status", "Initialized");
//        telemetry.update();
//
//
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//        runtime.reset();
//
//        // run until the end of the match (driver presses STOP)
//        while (opModeIsActive()) {
//
//telemetry.addData("Status", "Run Time: " + runtime.toString());
//    telemetry.update();
//    mecanumDriveSystem.adjustPower(gamepad1);
//
//            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
//        }
//    }

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        tdtRobot = new TDTRobot(this);
        shooter = new Shooter(hardwareMap, telemetry);
//        servoTest = new ServoTest(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        //Make sure to have any and all telementry calls above the telemetry.update();
        shooter.shootPos();
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        shooter.getMotor();
        telemetry.update();
        tdtRobot.getDrivetrain().adjustPower(gamepad1);
        shooter.ShootSystem(gamepad1);

    }
}
