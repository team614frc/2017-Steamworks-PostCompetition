package org.usfirst.frc.team614.robot.commands.autonomous.deliverRight;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * based on vision, rotates to the left for the right gear lift
 * 
 * TODO: negate rotation speed if wrong direction
 */
public class TurnLeftForGearLift extends Command {
	
	double angle;
	boolean targetFound;
	
    public TurnLeftForGearLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	angle = -999;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// begin reading vision processing;
    	// get to the point such that there is a gettable value that is the reflected tape's angle from the camera

		Robot.navX.reset();
		Robot.navX.zeroYaw();

		Robot.drivetrain.setUsingPID(true);


//        Robot.drivetrain.getController().setSetpoint(
//        		SmartDashboard.getNumber("Drivetrain Angle Target [Degrees (-180, +180)]", 0)
//		);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	angle = Robot.cameraTable.getNumber("angle", 999);
    	targetFound = Robot.cameraTable.getBoolean("targetFound", false);
    	
    	SmartDashboard.putNumber("Vision Target angle", angle);
    	SmartDashboard.putBoolean("Vision Target found", targetFound);
    	
    	if(targetFound == false) {
    		Robot.drivetrain.arcadeDrive(0, -.5);

    	} else {
	    	Robot.drivetrain.getController().setSetpoint(angle);
	    	Robot.drivetrain.arcadeDrive(0, Robot.drivetrain.getRotateRate());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
    	// DriveUntilVisionTargetIsClose
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
