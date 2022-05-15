package org.firstinspires.ftc.teamcode.commands.ElevationCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import org.firstinspires.ftc.teamcode.subsystems.Elevation.ElevationPositions;
import org.firstinspires.ftc.teamcode.subsystems.Elevation.ElevationSubsystem;

public class ZeroElevatorCommand extends CommandBase {
    ElevationSubsystem elevationSubsystem;

    public ZeroElevatorCommand(ElevationSubsystem elevationSubsystem){
        this.elevationSubsystem = elevationSubsystem;

        addRequirements(this.elevationSubsystem);
    }

    @Override
    public void initialize(){
        elevationSubsystem.closeOuttakeServo();
        elevationSubsystem.setElevationMotorTargetPosition(ElevationPositions.INTAKE.getMotorPosition());
    }

    @Override
    public void execute(){
        elevationSubsystem.updateElevationPosition();
    }

    @Override
    public boolean isFinished(){
        return elevationSubsystem.isMotorAtTargetPosition();
    }
}
