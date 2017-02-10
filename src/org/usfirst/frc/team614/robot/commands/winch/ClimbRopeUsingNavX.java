package org.usfirst.frc.team614.robot.commands.winch;

//import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ClimbRopeUsingNavX extends Command {

	private double height;
	private double speed;
	
    public ClimbRopeUsingNavX(double height, double speed) {
    	requires(Robot.winch); 
    	
    	this.height = height;    	
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.navX.isConnected()) {
    		Robot.navX.reset();
    		Robot.navX.zeroYaw();
    	}
        Robot.winch.set(SmartDashboard.getNumber("Winch Motor Speed", 0.0));
    }

    // Called repeatedly(Every 20ms) to spin the Winch 
    protected void execute() {
	}

    // Make this return true when navX senses the robot not moving (or when it has reached a certain height)
    protected boolean isFinished() {
    	
    	if(Robot.winch.shouldBeStopped()) {
    		return true;
    	}
    	
    	if(!Robot.navX.isMoving())
	     return true;  		
    	else         
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
