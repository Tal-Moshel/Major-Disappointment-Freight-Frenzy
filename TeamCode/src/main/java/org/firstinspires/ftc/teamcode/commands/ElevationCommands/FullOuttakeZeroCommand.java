package org.firstinspires.ftc.teamcode.commands.ElevationCommands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import org.firstinspires.ftc.teamcode.subsystems.Elevation.ElevationPositions;
import org.firstinspires.ftc.teamcode.subsystems.Elevation.ElevationSubsystem;

public class FullOuttakeZeroCommand extends SequentialCommandGroup {
    private final int waitTime = 800;

    public FullOuttakeZeroCommand(ElevationSubsystem elevationSubsystem, ElevationPositions positions){
        //TODO: if creates problem might want to add addRequirements()
        addRequirements(elevationSubsystem);

        addCommands(
                new OuttakeCommand(elevationSubsystem, positions),
                new WaitCommand(waitTime),
                new ZeroElevatorCommand(elevationSubsystem)
        );
    }
}
