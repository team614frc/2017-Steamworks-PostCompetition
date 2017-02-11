package org.usfirst.frc.team614.robot.commands.autonomous.deliverLeftRed;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftRedGearPrepareForTeleop extends CommandGroup {

    public LeftRedGearPrepareForTeleop() {

    	addSequential(new DriveStraightForADistance(-1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(-45)); // turns LEFT
    	addSequential (new DriveStraightForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	// Robot is now in middle of the field, on the "bottom" if looking at it from the bird's eye.
    	addSequential(new RotateToAngle(-90));
    	addSequential(new DriveStraightForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    }
    
}
