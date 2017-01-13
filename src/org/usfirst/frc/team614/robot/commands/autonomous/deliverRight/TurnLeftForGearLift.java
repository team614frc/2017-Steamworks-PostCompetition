package org.usfirst.frc.team614.robot.commands.autonomous.deliverRight;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * based on vision, rotates to the left for the right gear lift
 */
public class TurnLeftForGearLift extends Command {

    public TurnLeftForGearLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// begin reading vision processing;
    	// get to the point such that there is a gettable value that is the reflected tape's offset from the camera
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// refresh vision data?
    	Robot.drivetrain.arcadeDrive(0, .5);
//    	Robot.drivetrain.arcadeDrive(0, -.5);  // negate if it rotates backwards
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
     // return (if offset is really small; the robot's momentum would carry it a little, bring it exactly onto
        			// the lift, perhaps.)
    }

    // Called once after isFinished returns true
    protected void end() {
    	// DriveUntilVisionTargetIsClose
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//stop moving
    }
}
