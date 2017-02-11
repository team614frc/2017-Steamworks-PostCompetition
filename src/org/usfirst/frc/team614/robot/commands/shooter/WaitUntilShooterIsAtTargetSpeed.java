package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WaitUntilShooterIsAtTargetSpeed extends Command {
	
	double timeSinceHitTarget = 0.0;
	boolean isOnTarget = false;
	
    public WaitUntilShooterIsAtTargetSpeed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	setTimeout(4);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SmartDashboard.putBoolean("Target Speeded", false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!isOnTarget) { // robot was not on target last iteration
	    	isOnTarget = Robot.shooter.getRate() > Robot.shooter.getGoalRPS() - Robot.shooter.getTolerance();
	    	if(isOnTarget) { // if robot was not on target but now is on target
		    	setTimeout(.5);
	    	}
    	} else { // robot was on target last iteration
	    	isOnTarget = Robot.shooter.getRate() > Robot.shooter.getGoalRPS() - Robot.shooter.getTolerance();
	    	if(!isOnTarget) { // robot is no longer at target, so reset timeout
	    		setTimeout(.5);
	    	} // else { // robot was on target last iteration and still is; do nothing.
	    	//}
    	}	    		SmartDashboard.putBoolean("Target Speeded", isTimedOut());

        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
