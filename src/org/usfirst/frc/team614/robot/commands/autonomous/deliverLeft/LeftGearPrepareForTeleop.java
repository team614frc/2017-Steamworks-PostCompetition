package org.usfirst.frc.team614.robot.commands.autonomous.deliverLeft;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.commands.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftGearPrepareForTeleop extends CommandGroup {

    public LeftGearPrepareForTeleop() {
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

    	this.addSequential(new DriveStraightForADistance(-999, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	this.addSequential(new RotateToAngle(999)); // turns LEFT
    	this.addSequential (new DriveStraightForADistance(999, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	// Robot is now in middle of the field, on the "bottom" if looking at it from the bird's eye.
    	addSequential(new RotateToAngle(-999));
    	addSequential(new DriveStraightForADistance(999, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    }
}
