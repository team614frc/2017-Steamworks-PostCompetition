package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.DeliverGear;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardAndTurnRight extends CommandGroup {

    public DriveForwardAndTurnRight() {
    	addSequential(new DriveForADistance(-100, .5));
    	addSequential(new RotateToAngle(45, true));
    	
    }
}
