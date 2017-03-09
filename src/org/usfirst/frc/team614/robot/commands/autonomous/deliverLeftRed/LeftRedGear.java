package org.usfirst.frc.team614.robot.commands.autonomous.deliverLeftRed;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.DeliverGear;
import org.usfirst.frc.team614.robot.commands.WaitUntilGearButtonIsUnpressed;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.shooter.Shoot;
import org.usfirst.frc.team614.robot.commands.shooter.WaitUntilAllBallsAreShot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftRedGear extends CommandGroup {

    public LeftRedGear() {
//    	addSequential(new DriveStraightForADistance(-90, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new DriveForADistance(-100, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new RotateToAngle(45, true));
    	addSequential(new DeliverGear(true, true));
    	
    	// wait until button on gear holder is no longer pressed;
//    	addSequential(new WaitUntilGearButtonIsUnpressed());
    	// turn to boiler and shoot
    	addSequential(new Shoot(false, true, true, true, false));
//    	addSequential(new LeftRedGearPrepareForTeleop());
    }
}
