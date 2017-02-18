package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WaitUntilGearButtonIsUnpressed extends Command {

	boolean gearHasBeenReleased = false;
	
    public WaitUntilGearButtonIsUnpressed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putBoolean("Gear Is Considered Safely Out", false);
    	setTimeout(10); // if somehow nothing happens for 20 seconds, quit the command
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.gearButton.get()) { // if button is open (released, gear is no longer on holder)
    		if(!gearHasBeenReleased) { // this is the first iteration of the command since the gear left
    			setTimeout(1.0); 
        		gearHasBeenReleased = true;
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("Gear Is Considered Safely Out", true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
