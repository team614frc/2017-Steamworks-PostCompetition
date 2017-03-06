package org.usfirst.frc.team614.robot.commands.gearholder;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearButtonChecker extends Command {

	boolean wasPressedLastIteration = true;
	double timeGearButtonWasLastTogggled = 0;
	
    public GearButtonChecker() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
//    	requires(Robot.gearHolder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        // whenever the gear button is toggled, rumble the controller.
        SmartDashboard.putBoolean("Gear is in Holder", Robot.gearHolder.getIsPushed());
        if(!wasPressedLastIteration) { // last iteration, button was open
        	if(Robot.gearHolder.getIsPushed()) { // now, button is closed
        		timeGearButtonWasLastTogggled = timeSinceInitialized();
//        		if(timeSinceInitialized() > timeGearButtonWasLastTogggled + 2) {
	        		Command rumble = new RumbleController(true);
	        		rumble.start();
	        		wasPressedLastIteration = true;
//        		}
        	}
        } else {
        	if(!Robot.gearHolder.getIsPushed()) { // this iteration, open
        		timeGearButtonWasLastTogggled = timeSinceInitialized();
//        		if(timeSinceInitialized() > timeGearButtonWasLastTogggled + 2) {
	        		Command rumble = new RumbleController(false);
	        		rumble.start();
	        		wasPressedLastIteration = false;
//        		}
        	}
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
