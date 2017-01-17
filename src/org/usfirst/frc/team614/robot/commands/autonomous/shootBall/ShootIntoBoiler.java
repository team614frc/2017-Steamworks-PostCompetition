package org.usfirst.frc.team614.robot.commands.autonomous.shootBall;

import org.usfirst.frc.team614.robot.commands.autonomous.SpinShooterMotors;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Shoots the ball out of the shooter.
 */
public class ShootIntoBoiler extends CommandGroup {
    
    public ShootIntoBoiler() {
    	// begins revving shooter flywheels & feeder wheels
    	addSequential(new SpinShooterMotors(10));
    }
}
