package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * based on vision, rotates to the left for the right gear lift
 * 
 * TODO: negate rotation speed if wrong direction
 */
public class RotateToVisionTarget extends Command {
	

	boolean usingFrontCamera = false;
	boolean shouldRotateAtAll = true;
	boolean shouldRotateIfNoVision = false;
	boolean rotationDirection = false; // left for false, right for true
	
	double angle = 0;
	double distance = 0;
	boolean targetFound = false;
	
    public RotateToVisionTarget(boolean usingFrontCamera, boolean shouldRotateAtAll, boolean shouldRotateIfNoVision, boolean rotationDirection) { // third argument is ignored if the second argument is false.
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	this.shouldRotateAtAll = shouldRotateAtAll;
    	this.rotationDirection = rotationDirection;
    	this.shouldRotateIfNoVision = shouldRotateIfNoVision;
    	this.usingFrontCamera = usingFrontCamera;
    	
    	angle = 0;
    	distance = 0;
    	this.usingFrontCamera = usingFrontCamera;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

//		Robot.navX.reset();
//		Robot.navX.zeroYaw();

		Robot.drivetrain.setUsingPID(true);
		Robot.drivetrain.getController().setSetpoint(Robot.navX.getYaw());

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
if(shouldRotateAtAll) {
    	if(usingFrontCamera) { // using front gear camera
	    	angle = Robot.gearCamera.getNumber("angle", 0);
	    	targetFound = Robot.gearCamera.getBoolean("targetFound", false);
	    	distance = Robot.gearCamera.getNumber("distance", 0);
    	} else { // using shooter camera
	    	angle = Robot.shooterCamera.getNumber("angle", 0);
	    	targetFound = Robot.shooterCamera.getBoolean("targetFound", false);
	    	distance = Robot.shooterCamera.getNumber("distance", 0);
    	}
//    	targetFound = true;
    	
    	if(shouldRotateIfNoVision == true && targetFound == false) { // vision target not yet seen and the robot should act on this
    		if(rotationDirection) { // spin right
    			Robot.drivetrain.getController().setSetpoint(179.9);
    		} else { // spin left
    			Robot.drivetrain.getController().setSetpoint(-179.9);
    		}
    	}
    	else if(targetFound) { // vision target seen
	    	Robot.drivetrain.getController().setSetpoint(angle);
    	}
//    	
    	Robot.drivetrain.arcadeDrive(0, .7 * Robot.drivetrain.getRotateRate());
    }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!shouldRotateAtAll) {
    		return true;
    	}
    	// PID stuff is done, robot is at target angle
    	// Robot isn't at the immediate start of command and may be stopped b/c it never even started
    	if(this.timeSinceInitialized() > .2) {
	    	// PID stuff is done, robot is at target angle
	    	if(!Robot.navX.isMoving())
	    		return true;  	
    	}	
		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setUsingPID(false);
    	// DriveUntilVisionTargetIsClose
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.setUsingPID(false);
    	Robot.drivetrain.stop();
    }
}
