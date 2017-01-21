package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * From the LEFT gear lift, drives backwards for a short distance, turn to the left until navx yaw = 0 (which is set at the beginning of the game)
 */
public class PrepareForTeleop extends Command {
	
	private double distance, speed /* ,time */;
    
	public PrepareForTeleop(double distance, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.drivetrain);
		this.distance = distance;
		this.speed = speed;
		// this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navX.reset(); //not sure if we actually should reset the navx here
		Robot.navX.zeroYaw();
		Robot.printNavxData();

		Robot.drivetrain.getController().enable();
		Robot.drivetrain.setUsingPID(true);

		Robot.resetEncoder();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
