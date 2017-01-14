package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeliverCenterGear extends Command {

    public DeliverCenterGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }
   

    // Called just before this Command runs the first time
    protected void initialize() {
    Robot.resetEncoder();
    	
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    Robot.encoder.getDistance();
    
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.encoder != null){
        	Robot.encoder.getDistance();}
     
        	
        }
        	
    

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
