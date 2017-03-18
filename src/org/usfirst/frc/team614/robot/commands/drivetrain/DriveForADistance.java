
package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Makes the drivetrain drive straight for a distance in inches
 */
public class DriveForADistance extends Command
{
	private double distance, speed;

	public DriveForADistance(double distance, double speed)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		this.distance = distance; // in units of inches (ideally)
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		

//		Robot.drivetrain.setUsingTurnPID(true);
		Robot.drivetrain.setUsingDistancePID(true);

		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.rightEncoder.reset();

//        Robot.drivetrain.getTurnController().setSetpoint(Robot.navX.getYaw());
//        Robot.drivetrain.getDistanceController().setSetpoint(SmartDashboard.getNumber("Drivetrain Target Distance", 0));
        Robot.drivetrain.getDistanceController().setSetpoint(distance);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.drivetrain.arcadeDrive(speed * Robot.drivetrain.getPIDSpeed(), 0);
//		Robot.drivetrain.arcadeDrive(speed * Robot.drivetrain.getPIDSpeed(), .7 * Robot.drivetrain.getPIDRotateRate());
//		Robot.drivetrain.arcadeDrive(.7 * Robot.drivetrain.getPIDSpeed(), .7 * Robot.drivetrain.getPIDRotateRate());
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
//	    	if(!Robot.navX.isMoving()) {
//	    		return true;
//	    	}


    		if(Robot.drivetrain.rightEncoder.getRate() < 2.5 && Robot.drivetrain.rightEncoder.getRate() > -2.5) {
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
//		Robot.drivetrain.setUsingTurnPID(false);
		Robot.drivetrain.setUsingDistancePID(false);
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
//		Robot.drivetrain.setUsingTurnPID(false);
		Robot.drivetrain.setUsingDistancePID(false);
		Robot.drivetrain.stop();
	}
}
