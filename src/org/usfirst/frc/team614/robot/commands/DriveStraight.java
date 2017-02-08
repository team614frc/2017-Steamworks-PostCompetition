package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command {
	
	double speed;
	
    public DriveStraight(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

		Robot.drivetrain.setUsingPID(true);

        Robot.drivetrain.getController().setSetpoint(Robot.navX.getYaw());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(speed, Robot.drivetrain.getRotateRate());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
