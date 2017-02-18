
package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Makes the robot drive straight for a distance in inches
 * the angle is the angle the robot drives straight to, relative to where the robot started.
 * it is expected that the robot is already close to the target absolute angle, as excess rotation
 * 		will make the encoders sad.
 */
public class DriveStraightForADistanceAtAbsoluteAngle extends Command
{
	private double distance, speed, angle;
//	private boolean done = false;

	public DriveStraightForADistanceAtAbsoluteAngle(double distance, double speed, double angle)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		this.distance = distance; // in units of inches (ideally)
		this.speed = speed;
		this.angle = angle;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		
		Robot.drivetrain.setUsingTurnPID(true);
		Robot.drivetrain.setUsingDistancePID(true);

		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.rightEncoder.reset();

        Robot.drivetrain.getTurnController().setSetpoint(angle);
        Robot.drivetrain.getDistanceController().setSetpoint(distance);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		
//		if (Robot.drivetrain.rightEncoder.getDistance() > distance) {
//			
//			Robot.drivetrain.arcadeDrive(-speed, 0);
//			if(done == false) {
//				setTimeout(this.timeSinceInitialized() + .3);
//				done = true;
//			}
//		if(Robot.navX.isMoving())
//		} else {

			Robot.drivetrain.arcadeDrive(Robot.drivetrain.getPIDSpeed(), Robot.drivetrain.getPIDRotateRate());
//		}
		
		
	}

	// Returns true once the distance travelled by the encoder is greater than
	// distance.
	// Unit conversions are done in Constants.
	// The size of the wheel MUST be changed in Constants if changed!
	protected boolean isFinished()
	{

    	// Robot isn't at the immediate start of command and may be stopped b/c it never even started
    	if(this.timeSinceInitialized() > .2) {
	    	// PID stuff is done
	    	if(!Robot.navX.isMoving()) {
	    		return true;
	    	}
    	}	
		return false; 
//		 only tests right side... we're driving straight, so who cares.
//		if (Robot.drivetrain.rightEncoder.getDistance() > distance) {
//			
//			Robot.drivetrain.arcadeDrive(-1, 0);
//			setTimeout(this.timeSinceInitialized() + .1);
//			return true;
//		}
//		if(done)
//			return isTimedOut();
//		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.drivetrain.setUsingTurnPID(false);
		Robot.drivetrain.setUsingDistancePID(false);
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.drivetrain.setUsingTurnPID(false);
		Robot.drivetrain.setUsingDistancePID(false);
		Robot.drivetrain.stop();
	}
}
