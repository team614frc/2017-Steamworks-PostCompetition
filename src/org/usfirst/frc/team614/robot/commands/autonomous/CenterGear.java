package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightForADistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterGear extends CommandGroup {

    public CenterGear() {
    	addSequential(new DriveStraightForADistance(114, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    }
}
