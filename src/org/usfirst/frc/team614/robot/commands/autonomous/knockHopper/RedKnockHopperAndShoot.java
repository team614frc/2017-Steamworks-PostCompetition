package org.usfirst.frc.team614.robot.commands.autonomous.knockHopper;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.RotateToVisionTarget;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.shooter.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedKnockHopperAndShoot extends CommandGroup {

    public RedKnockHopperAndShoot() {
    	addSequential(new DriveForADistance(-20, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToAngle(-45, true));
    	addSequential(new DriveForADistance(-80, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToAngle(0, true));
    	addSequential(new DriveForADistance(-56, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	
    	addParallel(new Shoot(false, false, false, false, false));
    	
    	addParallel(new RotateToAngle(13, true));
    	/*
    	addSequential(new DriveStraightForADistance(-118, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToAngle(90, true));
//    	addSequential(new DriveStraightForADistance(62, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new DriveUntilStopped(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToAngle(15, true));
//    	addSequential(new DriveStraightForADistance(-12, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
//    	addSequential(new RotateToVisionTarget(false, true, true));
//    	addSequential(new DriveUntilStopped(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	*/
    	
    	
    	
    }
}
