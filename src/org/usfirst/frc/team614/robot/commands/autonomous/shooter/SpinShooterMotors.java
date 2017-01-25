package org.usfirst.frc.team614.robot.commands.autonomous.shooter;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Used for firing the shooter until the time runs out.
 */
public class SpinShooterMotors extends Command {
	private double time;
	
    public SpinShooterMotors(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.shooter);
		this.time = time;
    	this.setTimeout(this.time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.rev(SmartDashboard.getNumber("Shooter Speed", 0.0));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.shooter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	Robot.shooter.stop();
    }
}
