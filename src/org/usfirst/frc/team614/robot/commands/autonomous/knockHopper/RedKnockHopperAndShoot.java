package org.usfirst.frc.team614.robot.commands.autonomous.knockHopper;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.RotateToVisionTarget;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.shooter.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedKnockHopperAndShoot extends CommandGroup {

    public RedKnockHopperAndShoot() {
    	addSequential(new DriveStraightForADistance(-1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToAngle(90, true));
    	addSequential(new DriveUntilStopped(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new DriveStraightForADistance(-1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToAngle(0, true));
    	addSequential(new DriveStraightForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToVisionTarget(false, true, true));
    	addSequential(new DriveUntilStopped(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	
    	addSequential(new Shoot(false, false, false, false));
    	
    	
    	
    }
}
