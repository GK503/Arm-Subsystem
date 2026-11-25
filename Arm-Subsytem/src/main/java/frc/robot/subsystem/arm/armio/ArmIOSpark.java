package frc.robot.subsystem.arm.armio;

import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Voltage;

import frc.robot.subsystem.arm.ArmConstants;

public class ArmIOSpark implements ArmIO {

    private SparkMax motor;
    private SparkAbsoluteEncoder encoder;
    private SparkMaxConfig sparkMaxConfig;

    public ArmIOSpark(int CANID, MotorType motorType) {
        motor = new SparkMax(CANID, motorType);
        encoder = motor.getAbsoluteEncoder();
        sparkMaxConfig = new SparkMaxConfig();
        sparkMaxConfig.closedLoop.pid(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD, ClosedLoopSlot.kSlot0);
        sparkMaxConfig.idleMode(IdleMode.kBrake);
        sparkMaxConfig.inverted(ArmConstants.isInverted);
        sparkMaxConfig.voltageCompensation(ArmConstants.voltageCompensation);
        sparkMaxConfig.absoluteEncoder.zeroOffset(ArmConstants.absoluteEncZeroOff).positionConversionFactor(ArmConstants.absoluteEncPosConver).velocityConversionFactor(ArmConstants.velConverFac);
        motor.configure(sparkMaxConfig, SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        

        // make signals
        sparkMaxConfig.signals
            .appliedOutputPeriodMs(20)
            .outputCurrentPeriodMs(100)
            .busVoltagePeriodMs(100)
            .faultsAlwaysOn(true)
            .faultsPeriodMs(1000)
            .iAccumulationAlwaysOn(true)
            .motorTemperaturePeriodMs(1000)
            .primaryEncoderPositionAlwaysOn(true)
            .primaryEncoderPositionPeriodMs(20)
            .primaryEncoderVelocityAlwaysOn(true)
            .primaryEncoderVelocityPeriodMs(20)
            .warningsAlwaysOn(true)
            .warningsPeriodMs(1000);
        }

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.armIOData = new ArmIOData(
            // TODO  IDK HOW TO GET THIS
            false,
            encoder.getPosition(),
            encoder.getVelocity(),
            motor.getBusVoltage(),
            motor.getOutputCurrent(),
            motor.getMotorTemperature());
    }

    @Override
    public void runPercentPower(double percentpower) {
        
    }

    @Override
    public void runVoltage(double voltage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runVoltage'");
    }

    @Override
    public void runPosition(double position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runPosition'");
    }

    @Override
    public void stop() {
        motor.stopMotor();
    }

    @Override
    public void setClosedLoopSlot(int slot) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setClosedLoopSlot'");
    }

    @Override
    public void setPID(double kP, double kI, double kD) {
        sparkMaxConfig.closedLoop.pid(kP, kI, kD);
        motor.configure(sparkMaxConfig, SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void setkS(double kS) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setkS'");
    }

    @Override
    public void setBrakeMode(boolean isBrake) {
        if (isBrake == true) {
            sparkMaxConfig.idleMode(IdleMode.kBrake);
        } else {
            sparkMaxConfig.idleMode(IdleMode.kCoast);
        }
        motor.configure(sparkMaxConfig, SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void reset(int CANID, MotorType motorType) {
        motor.stopMotor();
        motor = new SparkMax(CANID, motorType);
        encoder = motor.getAbsoluteEncoder();
        sparkMaxConfig = new SparkMaxConfig();
        sparkMaxConfig.closedLoop.pid(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD, ClosedLoopSlot.kSlot0);
        sparkMaxConfig.idleMode(IdleMode.kBrake);
        sparkMaxConfig.inverted(ArmConstants.isInverted);
        sparkMaxConfig.voltageCompensation(ArmConstants.voltageCompensation);
        sparkMaxConfig.absoluteEncoder.zeroOffset(ArmConstants.absoluteEncZeroOff).positionConversionFactor(ArmConstants.absoluteEncPosConver).velocityConversionFactor(ArmConstants.velConverFac);
        motor.configure(sparkMaxConfig, SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        

        // make signals
        sparkMaxConfig.signals
            .appliedOutputPeriodMs(20)
            .outputCurrentPeriodMs(100)
            .busVoltagePeriodMs(100)
            .faultsAlwaysOn(true)
            .faultsPeriodMs(1000)
            .iAccumulationAlwaysOn(true)
            .motorTemperaturePeriodMs(1000)
            .primaryEncoderPositionAlwaysOn(true)
            .primaryEncoderPositionPeriodMs(20)
            .primaryEncoderVelocityAlwaysOn(true)
            .primaryEncoderVelocityPeriodMs(20)
            .warningsAlwaysOn(true)
            .warningsPeriodMs(1000);
    }
    
}
