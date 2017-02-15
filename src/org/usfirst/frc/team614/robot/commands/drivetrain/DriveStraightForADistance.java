
package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Makes the drivetrain move at .5 speed for 1 second
 */
public class DriveStraightForADistance extends Command
{
	private double distance, speed /* ,time */;
	private boolean done = false;

	public DriveStraightForADistance(double distance, double speed)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		this.distance = distance; // in units of inches (ideally)
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		
//		Robot.navX.reset();
//		Robot.navX.zeroYaw();

		Robot.drivetrain.setUsingPID(true);

		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.rightEncoder.reset();

        Robot.drivetrain.getController().setSetpoint(Robot.navX.getYaw());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		
		if (Robot.drivetrain.rightEncoder.getDistance() > distance) {
			
			Robot.drivetrain.arcadeDrive(-speed, 0);
			if(done == false) {
				setTimeout(this.timeSinceInitialized() + .3);
				done = true;
			}
		} else {

			Robot.drivetrain.arcadeDrive(speed, Robot.drivetrain.getRotateRate());
		}
		
		
	}

	// Returns true once the distance travelled by the encoder is greater than
	// distance.
	// Unit conversions are done in Constants.
	// The size of the wheel MUST be changed in Constants if changed!
	protected boolean isFinished()
	{
//		 only tests right side... we're driving straight, so who cares.
//		if (Robot.drivetrain.rightEncoder.getDistance() > distance) {
//			
//			Robot.drivetrain.arcadeDrive(-1, 0);
//			setTimeout(this.timeSinceInitialized() + .1);
//			return true;
//		}
		if(done)
			return isTimedOut();
		return false;
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
