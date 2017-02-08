package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UpdatePIDs extends Command {

    public UpdatePIDs() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.drivetrain.getController().setPID(
//				SmartDashboard.getNumber("Drivetrain P", 0),
//				SmartDashboard.getNumber("Drivetrain I", 0),
//				SmartDashboard.getNumber("Drivetrain D", 0),
//				SmartDashboard.getNumber("Drivetrain F", 0)
//		);
    	
//    	Robot.shooter.getPIDController().setPID(
//				SmartDashboard.getNumber("Shooter P", 0),
//				SmartDashboard.getNumber("Shooter I", 0),
//				SmartDashboard.getNumber("Shooter D", 0),
//				SmartDashboard.getNumber("Shooter F", 0)
//		);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
