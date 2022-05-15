package org.firstinspires.ftc.teamcode.OpMode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.subsystems.CarouselSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Elevation.ElevationSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Intake.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.utils.IMUSingleton;

public abstract class MajorOpMode extends CommandOpMode {
    GamepadEx driverGamepad;
    GamepadEx operatorGamepad;

    DriveSubsystem driveSubsystem;
    IntakeSubsystem intakeSubsystem;
    ElevationSubsystem elevationSubsystem;
    CarouselSubsystem carouselSubsystem;

    @Override
    public void initialize() {
        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);

        //Todo: perfect this
        new IMUSingleton(hardwareMap);

        driveSubsystem = new DriveSubsystem(hardwareMap);
        intakeSubsystem = new IntakeSubsystem(hardwareMap);
        elevationSubsystem = new ElevationSubsystem(hardwareMap);
        carouselSubsystem = new CarouselSubsystem(hardwareMap);

        run();
    }

    public abstract void run();
}
