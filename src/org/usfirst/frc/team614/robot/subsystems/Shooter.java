package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.commands.autonomous.shooter.ShooterDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterDrive());
    }
}

