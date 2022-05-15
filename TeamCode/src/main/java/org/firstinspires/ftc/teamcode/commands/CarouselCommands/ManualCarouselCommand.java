package org.firstinspires.ftc.teamcode.commands.CarouselCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.CarouselSubsystem;

import java.util.function.DoubleSupplier;

public class ManualCarouselCommand extends CommandBase {
    private final CarouselSubsystem carouselSubsystem;
    private final DoubleSupplier power;

    public ManualCarouselCommand(CarouselSubsystem _carouselSubsystem, DoubleSupplier _power){
        this.carouselSubsystem = _carouselSubsystem;
        this.power = _power;

        addRequirements(this.carouselSubsystem);
    }

    @Override
    public void execute(){
        carouselSubsystem.spin(power.getAsDouble());
    }
}
