package org.usfirst.frc.team614.robot.commands.autonomous.deliverRightBlue;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightBlueGearPrepareForTeleop extends CommandGroup {

    public RightBlueGearPrepareForTeleop() {
    	
    	addSequential(new DriveForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(0, true)); // turns RIGHT
    	addSequential (new DriveForADistance(-1, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(90, true));
    	addSequential(new DriveForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	
    	
    }
}
