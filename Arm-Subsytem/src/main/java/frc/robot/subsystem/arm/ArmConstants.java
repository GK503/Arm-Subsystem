package frc.robot.subsystem.arm;

import edu.wpi.first.math.util.Units;

public class ArmConstants {
    public static final int CANID = 7;
    public static final double gearRatio = 2.0;
    public static final boolean isInverted = true;
    public static final int currentLimit = 35;
    public static final int voltageCompensation = 12;
    public static final double kP = 0.1;
    public static final double kI = 0.0;
    public static final double kD = 0.02;
    public static final double kS = 0.1;
    public static final double absoluteEncZeroOff = 0.1;
    public static final boolean absoluteEncInver = false;
    public static final double absoluteEncPosConver = Units.rotationsToDegrees(360)/gearRatio;
    public static final double velConverFac = Units.radiansToDegrees(Units.rotationsPerMinuteToRadiansPerSecond(360/60))/gearRatio;
}
