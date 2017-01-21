package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.commands.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftGearPrepareGroup extends CommandGroup {

    public LeftGearPrepareGroup() {
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
    	
    	this.addSequential(new DriveStraightForADistance(-10, 10)); //temporary values
    	//this.addSequential (Robot.drivetrain.arcadeDrive(0, 1)); //rotate right to when navx yaw =0
    	this.addSequential(new RotateToAngle(true, 0, 1));//speed and angle not final, turns LEFT
    	
    	this.addSequential (new DriveStraightForADistance(10, 10)); //temporary values
    	
    }
}
