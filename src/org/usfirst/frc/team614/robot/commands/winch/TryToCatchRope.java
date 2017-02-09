package org.usfirst.frc.team614.robot.commands.winch;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TryToCatchRope extends Command {

    public TryToCatchRope() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winch.reset();
    	Robot.winch.set(Constants.WINCH_SPEED);
    	SmartDashboard.putBoolean("Winch is climbing", false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(this.timeSinceInitialized() > .5) {
	    	// motor is under strain, it caught the rope
	    	if(Robot.pdp.getCurrent(RobotMap.PDPWinchMotor) > Constants.WINCH_CURRENT_DRAW_AT_CATCHING_ROPE) {
	    		return true;
	    	}
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winch.reset(); // sets encoder to 0
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.winch.stop();
    	Robot.winch.reset(); // sets encoder to 0
    }
}
