package org.usfirst.frc.team614.robot.commands.autonomous.shooter;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.OI;
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterDrive extends Command {

    public ShooterDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("ERROR", Robot.shooter.getFireMotor().getClosedLoopError());
    	Robot.shooter.getFireMotor().set(OI.driverGamepad.getAxis(Gamepad.rightStick_Y));
//    	Robot.shooter.getFireMotor().set(SmartDashboard.getNumber("Speed", 0));
//        Robot.shooter.getFireMotor().setForwardSoftLimit(SmartDashboard.getNumber("RPS", 3833/60.0));
//    	Robot.shooter.getFireMotor().set(SmartDashboard.getNumber("RPS", 3833/60.0));
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
