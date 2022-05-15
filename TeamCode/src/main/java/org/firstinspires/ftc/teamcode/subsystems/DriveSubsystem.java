package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.utils.IMUSingleton;

public class DriveSubsystem extends SubsystemBase {
    private final MecanumDrive drive;

    public DriveSubsystem(HardwareMap hardwareMap){
        final Motor leftFront = new Motor(hardwareMap, "LF");
        final Motor rightFront = new Motor(hardwareMap, "RF");
        final Motor leftRear = new Motor(hardwareMap, "LR");
        final Motor rightRear = new Motor(hardwareMap, "RR");

        drive = new MecanumDrive(true, leftFront, rightFront, leftRear, rightRear);
    }

    public void robotCentricDrive(double leftX, double leftY, double rightX){
        drive.driveRobotCentric(leftX, leftY, rightX);
    }

    public void fieldCentricDrive(double leftX, double leftY, double rightX){
        drive.driveFieldCentric(leftX, leftY, rightX, IMUSingleton.getFirstGyroAngle());
    }
}
