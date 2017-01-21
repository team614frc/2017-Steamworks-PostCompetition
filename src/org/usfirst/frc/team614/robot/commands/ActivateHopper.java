package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.commands.autonomous.activateHopper.RotateToBoiler;
import org.usfirst.frc.team614.robot.commands.autonomous.shooter.ShootIntoBoiler;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class ActivateHopper extends CommandGroup {

    public ActivateHopper() {
    	//begins to drive straight for a distance of 9.5 at a speed of 0.5    	
    	addSequential(new DriveStraightForADistance(2.375, 0.5));
    	//begins to rotate the robot at a TBD speed and rotation to the boiler
    	addSequential(new RotateToBoiler(0.0, 0.0));
    	//begins to drive straight for a TBD distance and speed
    	addSequential(new DriveStraightForADistance(0.0, 0.0));
    	//begins to shoot fuel cells into the high goal of the boiler
    	addSequential(new ShootIntoBoiler());
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
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
    }
}
