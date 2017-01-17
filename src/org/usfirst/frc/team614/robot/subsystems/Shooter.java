package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Uses a feeder motor and a fire motor to shoot the balls.
 */
public class Shooter extends Subsystem
{
	// The port the is not final.
	VictorSP feederMotor = new VictorSP(RobotMap.shooterFeederMotor);
	TalonSRX fireMotor = new TalonSRX(RobotMap.shooterFireMotor);

//	private double feederSpeed, fireSpeed;
	
	public Shooter()
	{
//		this.feederSpeed = feederSpeed;
//		this.fireSpeed = fireSpeed;
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

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
