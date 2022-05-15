package org.firstinspires.ftc.teamcode.subsystems.Intake;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem extends SubsystemBase {
    MotorEx redSideIntakeMotor;
    MotorEx blueSideIntakeMotor;

    private final int intakeVelocity = 1500;
    private final int outtakeVelocity = -1500;

    public IntakeSubsystem(HardwareMap hardwareMap){
        redSideIntakeMotor = new MotorEx(hardwareMap, "Intake Red");
        redSideIntakeMotor.setRunMode(Motor.RunMode.VelocityControl);
        redSideIntakeMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        blueSideIntakeMotor = new MotorEx(hardwareMap, "Intake Blue");
        blueSideIntakeMotor.setRunMode(Motor.RunMode.VelocityControl);
        blueSideIntakeMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    //Red side
    public void intakeRedSide(){
        redSideIntakeMotor.setVelocity(intakeVelocity);
    }
    public void outtakeRedSide(){
        redSideIntakeMotor.setVelocity(outtakeVelocity);
    }

    //Blue side
    public void intakeBlueSide(){
        blueSideIntakeMotor.setVelocity(intakeVelocity);
    }
    public void outtakeBlueSide(){
        blueSideIntakeMotor.setVelocity(outtakeVelocity);
    }

    public void stopIntake(){
        redSideIntakeMotor.set(0);
        blueSideIntakeMotor.set(0);
    }
}
