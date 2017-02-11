package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.RotateToVisionTarget;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * drives forward, turns to the left, and delivers gear to the right lift.
 */
public class DeliverLeftRedGearToLift extends CommandGroup {

    public DeliverLeftRedGearToLift() {
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
//    	addSequential(new DoNothing());
    	addSequential(new DriveStraightForADistance(1, Constants.DRIVETRAIN_AUTONOMOUS_SPEED)); // temp until distance is known
//    	addSequential(new DriveStraight(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToVisionTarget(true, true, true));
//    	addSequential(new RotateToAngle(-45));
//    	addSequential(new DriveUntilStopped(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	
//    	addParallel(new Shoot(true));

    	// wait until button on gear holder is no longer pressed;
    	// wait about a second for gear to be lifted out of holder;
//    	addSequential(new LeftRedGearPrepareForTeleop());
    	
    }
}
