package org.usfirst.frc.team614.robot.commands.autonomous.shooter;

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

	private double targetSpeed = 0;
	
    public ShooterDrive() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	/* print encoder value */
    	SmartDashboard.putNumber("Shooter Encoder Distance", Robot.shooter.getShooterMotor().getEncPosition());

    	/* print PID Error*/
    	SmartDashboard.putNumber("Shooter PID Error", Robot.shooter.getShooterMotor().getError());
    	
    	/* USE PID Speed mode */
    	targetSpeed = OI.driverGamepad.getAxis(Gamepad.rightStick_Y) * SmartDashboard.getNumber("RPM", 0.0); /* 1500 RPM in either direction */
    	Robot.shooter.getShooterMotor().changeControlMode(TalonControlMode.Speed);
    	Robot.shooter.getShooterMotor().set(targetSpeed); /* 1500 RPM in either direction */
    	
    	/* USE Right Stick Y control */
//    	Robot.shooter.getShooterMotor().changeControlMode(TalonControlMode.PercentVbus);
//    	Robot.shooter.getShooterMotor().set(OI.driverGamepad.getAxis(Gamepad.rightStick_Y)); /* 1500 RPM in either direction */
    	
    	/* USE VictorSP motor movement */
//    	Robot.shooter.getVictor().set(SmartDashboard.getNumber("Speed", 0.0));
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
