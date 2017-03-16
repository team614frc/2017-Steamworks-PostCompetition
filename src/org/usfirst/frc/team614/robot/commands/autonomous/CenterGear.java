package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.DeliverGear;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterGear extends CommandGroup {

    public CenterGear() {
    	addSequential(new DeliverGear(false, false, true));
    }
}
