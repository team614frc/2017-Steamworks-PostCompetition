package org.usfirst.frc.team614.robot.commands.autonomous.deliverRightBlue;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.DeliverGear;
import org.usfirst.frc.team614.robot.commands.WaitUntilGearButtonIsUnpressed;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.shooter.Shoot;
import org.usfirst.frc.team614.robot.commands.shooter.WaitUntilAllBallsAreShot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightBlueGear extends CommandGroup {

    public RightBlueGear() {
    	addSequential(new DriveStraightForADistance(-114, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new DeliverGear(true, false));
    	
    	// wait until button on gear holder is no longer pressed;
    	addSequential(new WaitUntilGearButtonIsUnpressed());
    	// turn to boiler and shoot
    	addSequential(new Shoot(true, true, true, false));
    	// wait until all balls are shot
    	addSequential(new WaitUntilAllBallsAreShot());
    	addSequential(new RightBlueGearPrepareForTeleop());
    }
}
