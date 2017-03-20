package org.usfirst.frc.team614.robot.commands.shooter;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.Constants;
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
//        	Robot.shooter.getVelocityController().setSetpoint(SmartDashboard.getNumber("Shooter Target Speed (Revs per Sec)", 0));
        	
        	
//        	if(Robot.shooter.getShootingFromAirship()) { // gear position
//            	Robot.shooter.setGoalRPS(SmartDashboard.getNumber("Shooter Target Speed (Revs per Sec)", 0));
//            	
//        	} else { // hopper positon
//            	Robot.shooter.setGoalRPS(31.0);
//
//        	}
//    		if(Robot.shooter.getUsingEncoder()) {
//    		if(Robot.shooter.getRate() == 0) {
//    			 // encoder is dead or hasnt started shooting yet
//    			Robot.shooter.set(
//    					Robot.shooter.getSpeed()
//				);
//    		} else {
				if(Robot.shooter.getRate() <= Robot.shooter.getGoalRPS() - Robot.shooter.getTolerance()) {
					Robot.shooter.set(Constants.SHOOTER_BANG_MAX);
				} else if (Robot.shooter.getRate() >= Robot.shooter.getGoalRPS() + Robot.shooter.getTolerance()){
					Robot.shooter.set(Constants.SHOOTER_BANG_MIN);
				}
//    		}
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
