package org.usfirst.frc.team614.robot.commands.winch;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimbRopeUsingAmperage extends Command {

    public ClimbRopeUsingAmperage() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winch.spinWinch(Constants.WINCH_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	/* Print current draw to smart dashboard & update max current draw */
        if(SmartDashboard.getNumber("MAX Winch Current Draw", 0) < Robot.pdp.getCurrent(RobotMap.PDPWinchMotor)) {
        	SmartDashboard.putNumber("MAX Winch Current Draw", Robot.pdp.getCurrent(RobotMap.PDPWinchMotor));
        }
        SmartDashboard.putNumber("Winch Current Draw", Robot.pdp.getCurrent(RobotMap.PDPWinchMotor));
        
        
        
    }

    // Make this return true when the winch is at the top (motor stalls -> higher current draw)
    protected boolean isFinished() {
    	if(SmartDashboard.getNumber("Winch Current Draw", 0) > Constants.WINCH_CURRENT_DRAW_AT_MAX_HEIGHT) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winch.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.winch.stop();
    }
}
