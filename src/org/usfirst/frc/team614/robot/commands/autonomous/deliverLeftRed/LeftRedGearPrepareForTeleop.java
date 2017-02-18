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

    	addSequential(new DriveStraightForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(0, true)); // turns LEFT
    	addSequential (new DriveStraightForADistance(-1, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(-90, true));
    	addSequential(new DriveStraightForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    }
    
}
