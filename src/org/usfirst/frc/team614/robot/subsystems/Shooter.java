package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.autonomous.shooter.ShooterDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Uses a feeder motor and a fire motor to shoot the balls.
 */
public class Shooter extends Subsystem
{
	
	// The port the is not final.
//	VictorSP feederMotor = new VictorSP(RobotMap.shooterFeederMotor);
//	VictorSP fireMotor = new VictorSP(RobotMap.shooterFireMotor);
	CANTalon fireMotor = new CANTalon(RobotMap.shooterFireID);

//	private double feederSpeed, fireSpeed;
	
	public Shooter()
	{
		
		// .7 motor speed ~= 3833 RPM
		
		// sets PID parameters for firing motor
		fireMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder); // change to w/e encoder type we use
		fireMotor.reverseSensor(false);
		fireMotor.configEncoderCodesPerRev(128);
		/* if using QuadEncoder:
		fireMotor.configEncoderCodesPerRev(XXX);
		 * if using AnalogEncoder or AnalogPot:
		fireMotor.configPotentiometerTurns(XXX);
		 */
        /* set the peak and nominal outputs, 12V means full */
        fireMotor.configNominalOutputVoltage(+0.0f, -0.0f);
        fireMotor.configPeakOutputVoltage(+12.0f, 0.0f);
        /* set closed loop gains in slot0 */
//        fireMotor.setProfile(0);
//        fireMotor.changeControlMode(TalonControlMode.Speed);
//        fireMotor.set(63.8833333);
//        // PID TUNING PARAMETERS for FIRE MOTOR
//        // see 12.4.2 of CAN Talon SRX Software Reference Manual
//        fireMotor.setF(.109);
//        fireMotor.setP(5.0);
//        fireMotor.setI(.06);
//        fireMotor.setD(.6);
//
//        fireMotor.enable();

        
        
	}

	// spins the flywheels out to shoot a wiffle ball
	public void rev(double speed)
	{
//		feederMotor.set(feederSpeed);
		fireMotor.set(speed);
	}

	// stops the flywheels
	public void stop()
	{
//		feederMotor.set(0.0);
		fireMotor.set(0.0);
	}
	public CANTalon getFireMotor() {
		return fireMotor;
	}
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		 setDefaultCommand(new ShooterDrive());
	}
}
