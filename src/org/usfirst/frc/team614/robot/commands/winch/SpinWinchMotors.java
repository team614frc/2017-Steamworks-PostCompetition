package org.usfirst.frc.team614.robot.commands.winch;

<<<<<<< HEAD
//import org.usfirst.frc.team614.robot.Constants;
=======
import org.usfirst.frc.team614.robot.Constants;
>>>>>>> origin/master
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class SpinWinchMotors extends Command {

	private double height;
	private double speed;
	
    public SpinWinchMotors(double height, double speed) {
    	requires(Robot.winch); 
    	
    	this.height = height;    	
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.navX.isConnected()) {
    		Robot.navX.reset();
    		Robot.navX.zeroYaw();
    		Robot.printNavxData();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.winch.spinMotor(SmartDashboard.getNumber("Winch Motor Speed", 0.0));
        //Robot.winch.spinMotor(speed, Robot.winch.getRotateRate());
    	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
<<<<<<< HEAD
    	if(Robot.navX.isMoving() == true) {
=======
    	if(Robot.navX.getRawGyroZ()<= this.height) {
>>>>>>> origin/master
    	   return true;  		
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winch.stopMotor();
<<<<<<< HEAD
    
=======
>>>>>>> origin/master
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.winch.stopMotor();
    }
}
