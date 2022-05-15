package org.firstinspires.ftc.teamcode.commands.DriveCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class FieldCentricDriveCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;

    private final DoubleSupplier leftY;
    private final DoubleSupplier leftX;
    private final DoubleSupplier rightX;

    public FieldCentricDriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier leftY, DoubleSupplier leftX, DoubleSupplier rightX){
        this.driveSubsystem = driveSubsystem;

        this.leftY = leftY;
        this.leftX = leftX;
        this.rightX = rightX;

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute(){
        driveSubsystem.fieldCentricDrive(leftX.getAsDouble(), leftY.getAsDouble(), rightX.getAsDouble());
    }
}
