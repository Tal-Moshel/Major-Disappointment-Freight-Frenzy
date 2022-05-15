package org.firstinspires.ftc.teamcode.OpMode;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import org.firstinspires.ftc.teamcode.commands.IntakeCommands.IntakeReverseCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommands.ManualIntakeCommand;
import org.firstinspires.ftc.teamcode.subsystems.Intake.IntakeSide;

public class RedTeleOp extends TeleOpSideless{

    @Override
    public Button setIntakeButton() {
        return new GamepadButton(driverGamepad, GamepadKeys.Button.X)
                .whenHeld(() -> {
                    if(currentHub == HUB.ALLIANCE){
                        CommandScheduler.getInstance().schedule(new ManualIntakeCommand(intakeSubsystem, IntakeSide.RIGHT));
                    }else {
                        CommandScheduler.getInstance().schedule(new ManualIntakeCommand(intakeSubsystem, IntakeSide.LEFT));
                    }
                    return null;
                })
                .whenReleased(() -> {
                    if(currentHub == HUB.ALLIANCE){
                        CommandScheduler.getInstance().schedule(new IntakeReverseCommand(intakeSubsystem, IntakeSide.RIGHT));
                    }else {
                        CommandScheduler.getInstance().schedule(new IntakeReverseCommand(intakeSubsystem, IntakeSide.LEFT));
                    }
                    return null;
                });
    }

    @Override
    public IntakeSide setIntakeSide() {
        return IntakeSide.RIGHT;
    }
}
