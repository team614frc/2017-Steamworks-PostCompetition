package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.RotateToSmartDashboardAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * drives forward, turns to the left, and delivers gear to the right lift.
 */
public class DeliverRightGearToLift extends CommandGroup {

    public DeliverRightGearToLift() {
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

    	addSequential(new DriveStraightForADistance(999, Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
//    	addSequential(new DriveStraight(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
//    	addSequential(new TurnLeftForGearLift());
    	addSequential(new RotateToSmartDashboardAngle());
    	addSequential(new DriveUntilStopped(Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	
    }
}
