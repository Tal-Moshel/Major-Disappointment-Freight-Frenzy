package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IMUSingleton {
    private IMUSingleton instance;

    public static BNO055IMU imu;

    public IMUSingleton(HardwareMap hardwareMap){
        if(this.instance == null){
            imu = hardwareMap.get(BNO055IMU.class, "imu");

            BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
            parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;

            /*
                TODO try this on bot, SHOULD improve gyro accuracy
                and save battery by not using accelerometer
            */

            //parameters.accelPowerMode = BNO055IMU.AccelPowerMode.SUSPEND;
            //parameters.gyroPowerMode = BNO055IMU.GyroPowerMode.FAST;

            imu.initialize(parameters);
            while (!imu.isGyroCalibrated());
        }
    }

    public static double getFirstGyroAngle(){
        return imu.getAngularOrientation().firstAngle;
    }
}
