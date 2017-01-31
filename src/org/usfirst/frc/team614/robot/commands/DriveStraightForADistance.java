
package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Makes the drivetrain move at .5 speed for 1 second
 */
public class DriveStraightForADistance extends Command
{
	private double distance, speed /* ,time */;

	public DriveStraightForADistance(double distance, double speed)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		this.distance = distance;
		this.speed = speed;
		// this.time = time;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		
		//
		setTimeout(2.0);
		//
		
		Robot.navX.reset();
		Robot.navX.zeroYaw();

		Robot.drivetrain.setUsingPID(true);

		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.rightEncoder.reset();

        Robot.drivetrain.getController().setSetpoint(0f);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.drivetrain.arcadeDrive(speed, Robot.drivetrain.getRotateRate());
	}

	// Returns true once the distance travelled by the encoder is greater than
	// distance.
	// Unit conversions are done in Constants.
	// The size of the wheel MUST be changed in Constants if changed!
	protected boolean isFinished()
	{
		return isTimedOut();
//		 only tests left side... we're driving straight, so who cares.
//		if (Robot.drivetrain.leftEncoder.getDistance() >= distance / Constants.DRIVETRAIN_DISTANCE_PER_PULSE)
//		{
//			return true;
//		}
//
//		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.drivetrain.setUsingPID(false);
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.drivetrain.setUsingPID(false);
		Robot.drivetrain.stop();
	}
}
