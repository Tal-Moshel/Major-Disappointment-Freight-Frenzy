package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.Intake.IntakeSide;
import org.firstinspires.ftc.teamcode.subsystems.Intake.IntakeSubsystem;

public class ManualIntakeCommand extends CommandBase {
    IntakeSubsystem intakeSubsystem;
    IntakeSide intakeSide;

    public ManualIntakeCommand(IntakeSubsystem intakeSubsystem, IntakeSide intakeSide){
        this.intakeSubsystem = intakeSubsystem;
        this.intakeSide = intakeSide;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute(){
        if(intakeSide == IntakeSide.LEFT){
            intakeSubsystem.intakeBlueSide();
        }
        else if(intakeSide == IntakeSide.RIGHT){
            intakeSubsystem.intakeRedSide();
        }
    }
}
