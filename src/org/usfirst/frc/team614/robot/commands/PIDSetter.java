package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDSetter extends Command {

    public PIDSetter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.shooter.getFireMotor().setF(SmartDashboard.getNumber("F", 0));
//    	Robot.shooter.getFireMotor().setP(SmartDashboard.getNumber("P", 0));
//    	Robot.shooter.getFireMotor().setI(SmartDashboard.getNumber("I", 0));
//    	Robot.shooter.getFireMotor().setD(SmartDashboard.getNumber("D", 0));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
