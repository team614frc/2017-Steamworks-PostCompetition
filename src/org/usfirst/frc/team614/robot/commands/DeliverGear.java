package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DeliverGear extends CommandGroup {

    public DeliverGear(boolean shouldRotateIfNoVision, boolean rotationDirection) {
//    	addSequential(new RotateToVisionTarget(true, shouldRotateIfNoVision, rotationDirection));
    	addSequential(new DriveUntilStopped(-.5));
//    	addSequential(new DriveStraightAtSmartDashboardSpeed());
    }
}
