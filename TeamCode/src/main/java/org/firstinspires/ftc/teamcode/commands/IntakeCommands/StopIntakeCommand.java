package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.Intake.IntakeSide;
import org.firstinspires.ftc.teamcode.subsystems.Intake.IntakeSubsystem;

public class StopIntakeCommand extends CommandBase {
    IntakeSubsystem intakeSubsystem;

    public StopIntakeCommand(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute(){
        intakeSubsystem.stopIntake();
    }
}
