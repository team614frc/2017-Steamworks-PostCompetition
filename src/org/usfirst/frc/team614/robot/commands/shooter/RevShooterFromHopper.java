package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RevShooterFromHopper extends Command {

	
    public RevShooterFromHopper() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.shooter.setEnabled(true, false);
//    	Robot.shooterServo.setAngle(0.0);
//    	Robot.shooter.setGoalRPS(30.5);
//    	Robot.shooter.setGoalRPS(42.0);
		Robot.shooter.talonMaster.changeControlMode(TalonControlMode.Speed);
    	Robot.shooter.talonMaster.set(0);
//    	SmartDashboard.getNumber("Shooter CAN Talon Setpoint", 10));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.shooter.talonMaster.changeControlMode(TalonControlMode.Speed);
    	Robot.shooter.set(SmartDashboard.getNumber("Shooter CAN Talon Setpoint", 0));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stop();
//    	Robot.shooter.setEnabled(false, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.stop();
//    	Robot.shooter.setEnabled(false, false);
    }
}
