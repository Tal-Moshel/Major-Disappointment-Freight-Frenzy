package org.firstinspires.ftc.teamcode.subsystems.Elevation;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ElevationSubsystem extends SubsystemBase {
    private final DcMotorEx elevationMotor;
    private final Servo outtakeServo;

    private final PIDFController pidfController;

    public ElevationSubsystem(HardwareMap hardwareMap){
        elevationMotor = hardwareMap.get(DcMotorEx.class, "Elevation Motor");
        elevationMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        elevationMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        pidfController = new PIDFController(1, 0, 0, 0);
        pidfController.setTolerance(20);

        outtakeServo = hardwareMap.get(Servo.class, "Outtake Servo");
        outtakeServo.setPosition(0);
    }

    public boolean isMotorAtTargetPosition(){
        return pidfController.atSetPoint();
    }

    public void openOuttakeServo(){
        outtakeServo.setPosition(1);
    }
    public void closeOuttakeServo(){
        outtakeServo.setPosition(0);
    }

    public void setElevationMotorTargetPosition(int position){
        pidfController.setSetPoint(position);
    }

    public void updateElevationPosition(){
        double power = pidfController.calculate(elevationMotor.getCurrentPosition());
        elevationMotor.setPower(power);
    }
}
