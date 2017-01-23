package org.usfirst.frc.team614.robot.commands.autonomous.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Shoots the ball out of the shooter.
 */
public class ShootIntoRedBoiler extends CommandGroup {
    
    public ShootIntoRedBoiler() {
    	// begins revving shooter flywheels & feeder wheels
    	addSequential(new SpinShooterMotors(10));
    }
}
