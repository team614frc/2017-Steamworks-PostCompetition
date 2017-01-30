package org.usfirst.frc.team614.robot.commands.pneumatics;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutomaticCompressorControl extends Command {

    public AutomaticCompressorControl() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.pneumatics.compressor.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.pneumatics.compressor.enabled()) {
	    	if(DriverStation.getInstance().getBatteryVoltage() < 9.5) {
	    		Robot.pneumatics.compressor.stop(); // disables compressor
	    	}
    	} else { // the compressor is disabled; the voltage was < 9.5 last time it checked
	    	if(DriverStation.getInstance().getBatteryVoltage() > 10.5) {
	    		Robot.pneumatics.compressor.start();
	    	}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pneumatics.compressor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.pneumatics.compressor.stop();
    }
}
