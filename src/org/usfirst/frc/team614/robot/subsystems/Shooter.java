package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Uses a feeder motor and a fire motor to shoot the balls.
 */
public class Shooter extends Subsystem
{
	// The port the is not final.
//	VictorSP feederMotor = new VictorSP(RobotMap.shooterFeederMotor);
	VictorSP fireMotor = new VictorSP(RobotMap.shooterFireMotor);
//	CANTalon fireMotor = new CANTalon(RobotMap.shooterFireID);

//	private double feederSpeed, fireSpeed;
	
	public Shooter()
	{
//		// sets PID parameters for firing motor
//		fireMotor.setFeedbackDevice(FeedbackDevice.AnalogEncoder); // change to w/e encoder type we use
//		fireMotor.reverseSensor(false);
//		/* if using QuadEncoder:
//		fireMotor.configEncoderCodesPerRev(XXX);
//		 * if using AnalogEncoder or AnalogPot:
//		fireMotor.configPotentiometerTurns(XXX);
//		 */
//        /* set the peak and nominal outputs, 12V means full */
//        fireMotor.configNominalOutputVoltage(+0.0f, -0.0f);
//        fireMotor.configPeakOutputVoltage(+12.0f, 0.0f);
//        /* set closed loop gains in slot0 */
//        fireMotor.setProfile(0);
//        
//        // PID TUNING PARAMETERS for FIRE MOTOR
//        // see 12.4.2 of CAN Talon SRX Software Reference Manual
//        fireMotor.setF(0);
//        fireMotor.setP(0);
//        fireMotor.setI(0);
//        fireMotor.setD(0);

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
//	public CANTalon getFireMotor() {
//		return fireMotor;
//	}
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
