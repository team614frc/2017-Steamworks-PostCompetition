package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.commands.hopper.RevHopper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Shoot extends CommandGroup {

    public Shoot(boolean shootingFromAirship) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	if(shootingFromAirship) {
    		addParallel(new RevShooterFromAirship());
    	} else {
    		addParallel(new RevShooterFromBoiler());
    	}
    	//    	 wait until shooter is up to speed...
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
