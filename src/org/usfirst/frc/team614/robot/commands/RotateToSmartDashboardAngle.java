package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 	NAVX DEGREE ORIENTATION:
 * 			 0
 * 	    -45 \|/ +45
 * 	  -90  --X--  +90
 * 	   -135 /|\ +135
 *		  +/-180
 *  X is the robot. at +/-180, the left is -179.9999... and the right is +179.9999...
 * 
 */
public class RotateToSmartDashboardAngle extends Command {


	
    public RotateToSmartDashboardAngle() {
        // Use requires() here to declare subsystem dependencies
//         eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//		Robot.navX.reset();
//		Robot.navX.zeroYaw();

		Robot.drivetrain.setUsingPID(true);

		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.rightEncoder.reset();

        Robot.drivetrain.getController().setSetpoint(
        		SmartDashboard.getNumber("Drivetrain Rotation Target [Degrees (-180, +180)]", 0)
		);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.drivetrain.arcadeDrive(0.0, .7 * Robot.drivetrain.getRotateRate());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Robot isn't at the immediate start of command and may be stopped b/c it never even started
    	if(this.timeSinceInitialized() > .2) {
	    	// PID stuff is done, robot has been at target angle for a short time
	    	if(!Robot.navX.isMoving()) {
	    		return true;
	    	}
    	}	
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
