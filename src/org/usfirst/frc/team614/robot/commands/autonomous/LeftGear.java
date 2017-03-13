package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.DeliverGear;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftGear extends CommandGroup {

    public LeftGear() {
    	addSequential(new DriveForADistance(-125, -.5));
    	addSequential(new RotateToAngle(45, true));

    	addSequential(new DeliverGear(false, false));
    	
    }
}
