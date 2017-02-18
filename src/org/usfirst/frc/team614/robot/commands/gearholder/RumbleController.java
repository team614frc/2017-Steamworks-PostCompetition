package org.usfirst.frc.team614.robot.commands.gearholder;

import org.usfirst.frc.team614.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RumbleController extends Command {
	
	boolean rightSide;
	
    public RumbleController(boolean rightSide) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.rightSide = rightSide;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(rightSide)
    		OI.driverGamepad.setRumble(RumbleType.kRightRumble, 1);
    	else
    		OI.driverGamepad.setRumble(RumbleType.kLeftRumble, 1);
    	setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(rightSide)
    		OI.driverGamepad.setRumble(RumbleType.kRightRumble, 0);
    	else
    		OI.driverGamepad.setRumble(RumbleType.kLeftRumble, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	if(rightSide)
    		OI.driverGamepad.setRumble(RumbleType.kRightRumble, 0);
    	else
    		OI.driverGamepad.setRumble(RumbleType.kLeftRumble, 0);
    }
}
