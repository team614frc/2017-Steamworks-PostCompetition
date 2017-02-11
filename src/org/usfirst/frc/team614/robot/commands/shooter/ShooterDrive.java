package org.usfirst.frc.team614.robot.commands.shooter;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.OI;
import org.usfirst.frc.team614.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterDrive extends Command {

	
    public ShooterDrive() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	if(Robot.shooter.isEnabled()) {
    		
        	Robot.shooter.setGoalRPS(SmartDashboard.getNumber("Shooter Target Speed (Revs per Sec)", 0));
        	
        	if(Robot.shooter.getShootingFromAirship()) {
		    	
//	        	Robot.shooter.setGoalRPS(60.0);
				
				if(Robot.shooter.getRate() <= Robot.shooter.getGoalRPS() - Robot.shooter.getTolerance()) {
					Robot.shooter.set(SmartDashboard.getNumber("Shooter Bang Max", .8));
				} else if (Robot.shooter.getRate() >= Robot.shooter.getGoalRPS() + Robot.shooter.getTolerance()){
					Robot.shooter.set(SmartDashboard.getNumber("Shooter Bang Min", .6));
				}

        	} else { // robot is shooting right next to boiler
        			Robot.shooter.stop();
//	        	Robot.shooter.setGoalRPS(XXX);
//				
//				if(Robot.shooter.getRate() <= Robot.shooter.getGoalRPS() - Robot.shooter.getTolerance()) {
//					Robot.shooter.set(SmartDashboard.getNumber("Shooter Bang Max", XXX));
//				} else if (Robot.shooter.getRate() >= Robot.shooter.getGoalRPS() + Robot.shooter.getTolerance()){
//					Robot.shooter.set(SmartDashboard.getNumber("Shooter Bang Min", XXX));
//				}
        	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
