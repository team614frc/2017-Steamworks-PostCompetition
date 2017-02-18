package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.commands.RotateToVisionTarget;
import org.usfirst.frc.team614.robot.commands.hopper.RevHopper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Shoot extends CommandGroup {

    public Shoot(boolean shootingFromAirship, boolean shouldRotateAtAll, boolean shouldRotateIfNoVision, boolean rotationDirection) {

//    	 rev shooter
    	if(shootingFromAirship) {
    		addParallel(new RevShooterFromAirship());
    	} else {
    		addParallel(new RevShooterFromBoiler());
    	}
    	
    	// line up to boiler
    	// if in autonomous, rotate left or right if vision target isn't on screen
    	// if in teleop, don't rotate if no vision targeting is recieved; default left/right rotation is ignored.
    	// if camera is broken, don't rotate at all
    	if(shouldRotateAtAll) {
    		addSequential(new RotateToVisionTarget(false, shouldRotateIfNoVision, rotationDirection)); // on blue side => rotate right and vice versa
    	}
    	// wait until shooter is up to speed...
    	addSequential(new WaitUntilShooterIsAtTargetSpeed());
//    	feed balls into shooter...
    	addSequential(new RevHopper());
    	//    	 manually wait until all balls are shot
    }
    protected void end() {
    	Robot.hopper.stop();
    	Robot.shooter.setEnabled(false, false);
    }
    protected void interrupted() {
    	Robot.hopper.stop();
    	Robot.shooter.setEnabled(false, false);
    }
}
