package org.usfirst.frc.team614.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightForLift extends Command {

    public DriveStraightForLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// begin reading vision processing;
    	// get to the point such that there is a gettable value that is the reflected tape's distance
    				// from the camera

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// update visiond data?
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    //  return (if the distance is ~equal to the distance of the camera is from the front of the robot)
    }

    // Called once after isFinished returns true
    protected void end() {
    	//stop
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//stop
    }
}
