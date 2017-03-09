package org.usfirst.frc.team614.robot.commands.autonomous.deliverLeftBlue;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftBlueGearPrepareForTeleop extends CommandGroup {

    public LeftBlueGearPrepareForTeleop() {

    	addSequential(new DriveForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(0 ,true)); // turns LEFT
    	addSequential (new DriveForADistance(-1, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(90, true));
    	addSequential(new DriveForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    }
    
}
