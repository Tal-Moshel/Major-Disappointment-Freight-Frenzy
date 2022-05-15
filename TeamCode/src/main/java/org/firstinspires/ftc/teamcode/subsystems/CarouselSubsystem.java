package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class CarouselSubsystem extends SubsystemBase {
    MotorEx motor;

    private final double max_velocity = 3000;

    public CarouselSubsystem(HardwareMap hardwareMap){
        motor = new MotorEx(hardwareMap, "Carousel");
        motor.setRunMode(Motor.RunMode.VelocityControl);
        motor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        motor.setVeloCoefficients(1, 0, 0);
    }

    public void spin(double input){
        double _target_velo = max_velocity * input;
        motor.setVelocity(_target_velo);
    }
}
