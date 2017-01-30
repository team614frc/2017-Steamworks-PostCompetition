package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * [DEPRECATED]
 * 
 * 
 * 	NAVX DEGREE ORIENTATION:
 * 			 0
 * 	    -45 \|/ +45
 * 	  -90  --X--  +90
 * 	   -135 /|\ +135
 *		  +/-180
 *  X is the robot. at +/-180, the left is -179.9999... and the right is +179.9999...
 * 
 */
public class RotateToAngle extends Command {
	private double angle;
	private double speed;
	private boolean direction; // left = true; right = false;
	
    public RotateToAngle(boolean direction, double angle, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	this.direction = direction;
    	this.angle=angle;
    	this.speed=speed;
    }

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.navX.isConnected()) {

			Robot.drivetrain.getController().enable();
			Robot.drivetrain.setUsingPID(true);
		}
	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (direction) //go left?
    	{
    		Robot.drivetrain.arcadeDrive(0,1);	
    	}
    	else  //go right?
    	{
    		Robot.drivetrain.arcadeDrive(0,-1); // can the second argument even be negative?
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	/*use navX.getYaw() to calculate when the robot is at the intended angle (returns true)
    	 * the current angle +  the intended angle = the angle relative to the navX that the robot turns to.
    	 * [-179f, 179f]
    	 *use modulus maybe? 
    	 * 
    	 * 
    	 */
    	
    	if (Robot.navX.getYaw() % 180 <= angle + 2 && Robot.navX.getYaw() % 180 >= angle - 2) //unfinished
    	{
    		return true;
    	}
    	else	
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setUsingPID(false);
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.setUsingPID(false);
    	Robot.drivetrain.stop();
    }
}
