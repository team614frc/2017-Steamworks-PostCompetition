package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * based on vision, rotates to the left for the right gear lift
 * 
 * TODO: negate rotation speed if wrong direction
 */
public class RotateToVisionTarget extends Command {
	

	boolean usingGearCamera = false;
	boolean shouldRotateIfNoVision = false;
	boolean rotationDirection = false;	// left for false, right for true
										// used if the robot loses sight of its vision target
	boolean hitTarget = false;
	
	double angle = 0;
	double distance = 0;
	boolean targetFound = false;
	
    public RotateToVisionTarget(boolean usingGearCamera, boolean shouldRotateIfNoVision, boolean rotationDirection) { // third argument is ignored if the second argument is false.
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);

    	this.rotationDirection = rotationDirection;
    	this.shouldRotateIfNoVision = shouldRotateIfNoVision;
    	this.usingGearCamera = usingGearCamera;
    	
    	hitTarget = false;
    	angle = 0;
    	distance = 0;
    	this.usingGearCamera = usingGearCamera;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

//		Robot.navX.reset();
//		Robot.navX.zeroYaw();

		Robot.drivetrain.setUsingTurnPID(true);
		Robot.drivetrain.getTurnController().setSetpoint(Robot.navX.getAngle());

		Robot.shooter.isOnTarget = false;
		
    	angle = Robot.shooterCamera.getNumber("angle", 0);
    	targetFound = Robot.shooterCamera.getBoolean("targetFound", false);
//    	distance = Robot.shooterCamera.getNumber("distance", 0);
		Robot.drivetrain.getTurnController().setSetpoint(Robot.navX.getYaw() + angle + Constants.SHOOTER_CAMERA_OFFSET);

		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.cameraIsActive) {
//	    	if(usingGearCamera) { // using front gear camera
////		    	angle = Robot.gearCamera.getNumber("angle", 0);
////		    	targetFound = Robot.gearCamera.getBoolean("targetFound", false);
////		    	distance = Robot.gearCamera.getNumber("distance", 0);
//	    	} else { // using shooter camera
		    	angle = Robot.shooterCamera.getNumber("angle", 0);
		    	targetFound = Robot.shooterCamera.getBoolean("targetFound", false);
//		    	distance = Robot.shooterCamera.getNumber("distance", 0);
//	    	}
//	    	targetFound = true;
	    	
	    	if(shouldRotateIfNoVision == true && targetFound == false) { // vision target not yet seen and the robot should act on this
//	    		if(rotationDirection) { // spin right
//	    			Robot.drivetrain.getTurnController().setSetpoint(179.9);
//	    		} else { // spin left
//	    			Robot.drivetrain.getTurnController().setSetpoint(-179.9);
//	    		}
	    	}
	    	else if(targetFound) { // vision target seen
	    		// stores target rotation direction in case the robot loses vision target
//	    		if(angle > 0) // rotate right
//	    			rotationDirection = true;
//	    		else // rotate left
//	    			rotationDirection = false;
	    		
	    		// continuously update the target angle for rotating
//	    		if(usingGearCamera) { // gear camera
//	    			Robot.drivetrain.getTurnController().setSetpoint(angle);
//	    		} else { // shooter/ camera
//	    			Robot.drivetrain.getTurnController().setSetpoint(angle + Constants.SHOOTER_CAMERA_OFFSET);
//	    		}
    		}
	    	if(angle > -5 && angle < 5) {
	    		hitTarget = true;
	    	} else {
    			if(!hitTarget) {
    				Robot.drivetrain.getTurnController().setSetpoint(angle + Constants.SHOOTER_CAMERA_OFFSET);
    			}
	    	}
	    	Robot.drivetrain.arcadeDrive(0, .7 * Robot.drivetrain.getPIDRotateRate());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!Robot.cameraIsActive)
    		return true;
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
    	Robot.drivetrain.setUsingTurnPID(false);
    	// DriveUntilVisionTargetIsClose
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.setUsingTurnPID(false);
    	Robot.drivetrain.stop();
    }
}
