package frc.robot.subsystem.arm.armio;

import org.littletonrobotics.junction.AutoLog;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;


public interface ArmIO {
    public record ArmIOData(
        boolean isConnected,
        Angle posistion,
        AngularVelocity velocity,
        Voltage appliedVol,
        Current current,
        Temperature temp
    ){}

    @AutoLog
    public class ArmIOInputs {
        public ArmIOData armIOData;

    }
    void updateInputs(ArmIOInputs inputs);

    void runPercentPower(double percentpower);

    void runVoltage(Voltage voltage);

    void runPosition(Angle position);

    void stop();

    void setClosedLoopSlot(int slot);

    void setPID(double kP, double kI, double kD);

    void setkS(double kS);

    void setBrakeMode(boolean isBrake);

    void reset(int CANID, MotorType motorType);
}

