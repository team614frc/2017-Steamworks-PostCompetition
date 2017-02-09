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
    	
    	addSequential(new DriveStraightForADistance(-999, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	addSequential(new RotateToAngle(999)); // turns RIGHT
    	addSequential (new DriveStraightForADistance(999, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); //temporary values
    	// Robot is now in middle of the field, on the "top" if looking at it from the bird's eye.
    	addSequential(new RotateToAngle(-999));
    	addSequential(new DriveStraightForADistance(999, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	
    	
    }
}
