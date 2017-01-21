package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateToAngle extends Command {
	private double angle;
	private double speed;
	private boolean direction; // left = true; right = false;
	
    public RotateToAngle(boolean direction, double angle, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	this.direction = direction;
    	this.angle=angle;
    	this.speed=speed;
    }

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.navX.isConnected()) {

			Robot.printNavxData();

			Robot.drivetrain.getController().enable();
			Robot.drivetrain.setUsingPID(true);
		}
	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(0,1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	
    	if (Robot.navX.getYaw() % 360 <= angle + 2 && Robot.navX.getYaw() % 360 >= angle - 2) //unfinished
    	{
    		return true;
    	}
    	else	
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
