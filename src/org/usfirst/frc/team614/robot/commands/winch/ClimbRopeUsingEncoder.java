package org.usfirst.frc.team614.robot.commands.winch;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimbRopeUsingEncoder extends Command {

    public ClimbRopeUsingEncoder() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winch.spinWinch(Constants.WINCH_SPEED);
    	SmartDashboard.putBoolean("Winch is climbing", true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	/* Print encoder distance to smart dashboard */
        
        
        
    }

    // Make this return true when the winch is at the top (motor stalls -> higher current draw)
    protected boolean isFinished() {
    	if(Robot.winch.getEncoderRevolutions() > Constants.WINCH_ENCODER_REVOLUTIONS_TO_TOP) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winch.stop();
    	SmartDashboard.putBoolean("Winch is climbing", false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.winch.stop();
    	SmartDashboard.putBoolean("Winch is climbing", false);
    }
}
