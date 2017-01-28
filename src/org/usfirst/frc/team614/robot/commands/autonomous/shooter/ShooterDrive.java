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
//    	SmartDashboard.putNumber("Shooter Encoder Distance", Robot.shooter.shooterEncoder.getDistance());
//    	SmartDashboard.putNumber("Shooter Encoder Count", Robot.shooter.shooterEncoder.getRaw());
//    	/* print encoder rate */
//    	SmartDashboard.putNumber("Shooter Encoder Rate", Robot.shooter.shooterEncoder.getRate());
//		if(SmartDashboard.getNumber(
//				"Shooter Encoder MAX Rate", 0) < Robot.shooter.shooterEncoder.getRate())
//				SmartDashboard.putNumber("Shooter Encoder MAX Rate", Robot.shooter.shooterEncoder.getRate());
//
//    	/* print PID Error*/
//    	SmartDashboard.putNumber("Shooter PID Error", Robot.shooter.getPIDController().getError());
    	
    	/* USE SmartDasboard control for PID*/
//    	Robot.shooter.setSetpoint(
//    			SmartDashboard.getNumber("Shooter PID Target RPM", 1500)// / 60.0 // RPM / 60 = RPS
//		); /* 1500 RPM in either direction */
    	
    	/* USE SmartDasboard control for VOLTAGE SPEED*/
//    	Robot.shooter.getVictor().set(
//    			SmartDashboard.getNumber("Shooter non-PID Target %", 0.7) // / 5600
//		); /* 1500 RPM in either direction */
//    	Robot.shooter.setUsingPID(false);

    	/* USE Right Stick Y control */
//    	Robot.shooter.setSetpoint(OI.driverGamepad.getAxis(Gamepad.rightStick_Y)); /* 1500 RPM in either direction */
    	
    	/* SET PID control */
//    	Robot.shooter.getPIDController().setPID(
//    			SmartDashboard.getNumber("Shooter P", 0),
//    			SmartDashboard.getNumber("Shooter I", 0),
//    			SmartDashboard.getNumber("Shooter D", 0),
//    			/*SmartDashboard.getNumber("Shooter Target % Speed", 0) * 1023 /*/
//    			(SmartDashboard.getNumber("Shooter F", 0))
//		);
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
