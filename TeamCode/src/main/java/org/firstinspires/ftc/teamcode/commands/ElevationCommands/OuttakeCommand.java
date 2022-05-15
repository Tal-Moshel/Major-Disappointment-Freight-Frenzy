package org.firstinspires.ftc.teamcode.commands.ElevationCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import org.firstinspires.ftc.teamcode.subsystems.Elevation.ElevationPositions;
import org.firstinspires.ftc.teamcode.subsystems.Elevation.ElevationSubsystem;

public class OuttakeCommand extends CommandBase {
    ElevationSubsystem elevationSubsystem;
    ElevationPositions positions;

    public OuttakeCommand(ElevationSubsystem elevationSubsystem, ElevationPositions positions){
        this.elevationSubsystem = elevationSubsystem;
        this.positions = positions;

        addRequirements(this.elevationSubsystem);
    }

    @Override
    public void initialize(){
        elevationSubsystem.setElevationMotorTargetPosition(positions.getMotorPosition());
    }

    @Override
    public void execute(){
        elevationSubsystem.updateElevationPosition();
    }

    @Override
    public void end(boolean isInterrupted){
        if(!isInterrupted){
            elevationSubsystem.openOuttakeServo();
        }
    }

    @Override
    public boolean isFinished(){
        return elevationSubsystem.isMotorAtTargetPosition();
    }
}
