package org.usfirst.frc.team614.robot.commands.autonomous.deliverRightRed;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightRedGearPrepareForTeleop extends CommandGroup {

    public RightRedGearPrepareForTeleop() {
    	
    	addSequential(new DriveStraightForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(45)); // turns RIGHT
    	addSequential (new DriveStraightForADistance(-1, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(-90));
    	addSequential(new DriveStraightForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	
    	
    }
}
