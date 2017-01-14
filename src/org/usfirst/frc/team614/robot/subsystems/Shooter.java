package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Uses two flywheels and a piston to shoot a ball.ylo
 */
public class Shooter extends Subsystem
{
	// The port the is not final.
	VictorSP motor = new VictorSP(RobotMap.shooterLeftMotor);

	public Shooter()
	{
		
	}

	// spins the flywheels out to shoot a wiffle ball
	public void rev()
	{
		motor.set(1.0);
	}

	// stops the flywheels
	public void stop()
	{
		motor.set(0.0);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
