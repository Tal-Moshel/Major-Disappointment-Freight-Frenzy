package org.firstinspires.ftc.teamcode.OpMode;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import org.firstinspires.ftc.teamcode.commands.CarouselCommands.ManualCarouselCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.FieldCentricDriveCommand;
import org.firstinspires.ftc.teamcode.commands.ElevationCommands.OuttakeCommand;
import org.firstinspires.ftc.teamcode.commands.ElevationCommands.ZeroElevatorCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommands.IntakeReverseCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommands.ManualIntakeCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommands.StopIntakeCommand;
import org.firstinspires.ftc.teamcode.subsystems.Elevation.ElevationPositions;
import org.firstinspires.ftc.teamcode.subsystems.Intake.IntakeSide;

public abstract class TeleOpSideless extends MajorOpMode{
    public IntakeSide intakeSide = setIntakeSide();
    public HUB currentHub = HUB.ALLIANCE;

    @Override
    public void run() {
        //<editor-fold desc="Driver">
        driveSubsystem.setDefaultCommand(new FieldCentricDriveCommand(
                driveSubsystem, () -> driverGamepad.getLeftY(), () -> driverGamepad.getLeftX(), () -> driverGamepad.getRightX()
        ));


        new GamepadButton(driverGamepad, GamepadKeys.Button.X)
                .whenPressed(() -> {
                    if(currentHub == HUB.ALLIANCE){
                        currentHub = HUB.SHARED;
                    } else if(currentHub == HUB.SHARED){
                        currentHub = HUB.ALLIANCE;
                    }
                });

        setIntakeButton();

        new GamepadButton(driverGamepad, GamepadKeys.Button.B)
                .whenPressed(new StopIntakeCommand(intakeSubsystem));
        //</editor-fold>

        //<editor-fold desc="Operator">
        carouselSubsystem.setDefaultCommand(new ManualCarouselCommand(
                carouselSubsystem, () -> operatorGamepad.getLeftX()
        ));

        //Elevation controls
        new GamepadButton(operatorGamepad, GamepadKeys.Button.B)
                .whenPressed(
                        new ParallelCommandGroup(
                                new StopIntakeCommand(intakeSubsystem),
                                new OuttakeCommand(elevationSubsystem, ElevationPositions.LOW)
                        )
                );
        new GamepadButton(operatorGamepad, GamepadKeys.Button.Y)
                .whenPressed(
                        new ParallelCommandGroup(
                                new StopIntakeCommand(intakeSubsystem),
                                new OuttakeCommand(elevationSubsystem, ElevationPositions.MIDDLE)
                        )
                );
        new GamepadButton(operatorGamepad, GamepadKeys.Button.X)
                .whenPressed(
                        new ParallelCommandGroup(
                                new StopIntakeCommand(intakeSubsystem),
                                new OuttakeCommand(elevationSubsystem, ElevationPositions.TOP)
                        )
                );
        new GamepadButton(operatorGamepad, GamepadKeys.Button.A)
                .whenPressed(
                        new ParallelCommandGroup(
                                new StopIntakeCommand(intakeSubsystem),
                                new ZeroElevatorCommand(elevationSubsystem)
                        )
                );
        //</editor-fold>

        register(driveSubsystem);
        register(carouselSubsystem);
    }

    public abstract Button setIntakeButton();
    public abstract IntakeSide setIntakeSide();
}
