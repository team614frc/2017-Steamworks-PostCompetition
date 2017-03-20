package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.pneumatics.ActivateGearHolder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DeliverGear extends CommandGroup {

    public DeliverGear(boolean shouldRotateIfNoVision, boolean rotationDirection, boolean autonomous) {
    	
    	addSequential(new DriveUntilStopped(-.8, 4));
    	
    	addParallel(new ActivateGearHolder(autonomous));
    	addSequential(new Wait(.5));
    	addSequential(new DriveForADistance(-96, -.6));
//    	addSequential(new RotateToAngle(-90, true));
    }
}
