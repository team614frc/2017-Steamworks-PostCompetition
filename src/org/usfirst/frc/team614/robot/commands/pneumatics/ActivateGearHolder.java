package org.usfirst.frc.team614.robot.commands.pneumatics;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivateGearHolder extends Command {

	boolean autonomous;
	
    public ActivateGearHolder(boolean autonomous) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumatics);
    	this.autonomous = autonomous;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// open holder
		Robot.pneumatics.setDropperState(Constants.pistonOut);
		if(autonomous)
			setTimeout(3);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(autonomous)
    		return isTimedOut();
    	else
        	// when button is released
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// close holder
		Robot.pneumatics.setDropperState(Constants.pistonIn);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	// close holder
		Robot.pneumatics.setDropperState(Constants.pistonIn);

    }
}
