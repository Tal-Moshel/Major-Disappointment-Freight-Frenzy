package org.firstinspires.ftc.teamcode.subsystems.Elevation;

public enum ElevationPositions {
    INTAKE(0),
    LOW(500),
    MIDDLE(1000),
    TOP(1500);

    private final int motorPosition;

    ElevationPositions(int motorPosition) {
        this.motorPosition = motorPosition;
    }

    public int getMotorPosition() {
        return this.motorPosition;
    }
}

