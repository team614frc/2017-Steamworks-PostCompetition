package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DeliverGear extends CommandGroup {

    public DeliverGear(boolean shouldRotateIfNoVision, boolean rotationDirection) {
    	
    	addSequential(new RotateToVisionTarget(true, shouldRotateIfNoVision, rotationDirection));
    	addSequential(new DriveUntilStopped(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    }
}
