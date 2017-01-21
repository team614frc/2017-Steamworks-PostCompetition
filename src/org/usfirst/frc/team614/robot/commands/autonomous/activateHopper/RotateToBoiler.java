package org.usfirst.frc.team614.robot.commands.autonomous.activateHopper;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class RotateToBoiler extends Command {

	private double testSpeed;	
	private double testRotation;
	
    public RotateToBoiler(double testSpeed, double testRotation) {
    	requires(Robot.drivetrain);
    	
    	this.testSpeed = testSpeed;
    	this.testRotation = testRotation;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.navX.isConnected()) {
    		Robot.navX.reset();
    		Robot.navX.zeroYaw();
    		Robot.printNavxData();
    		
    		Robot.drivetrain.getController().enable();
    		Robot.drivetrain.setUsingPID(true);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //TBD
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//TBD
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
