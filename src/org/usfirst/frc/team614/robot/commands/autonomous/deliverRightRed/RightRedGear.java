package org.usfirst.frc.team614.robot.commands.autonomous.deliverRightRed;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.DeliverGear;
import org.usfirst.frc.team614.robot.commands.WaitUntilGearButtonIsUnpressed;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightForADistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightRedGear extends CommandGroup {

    public RightRedGear() {
    	addSequential(new DriveStraightForADistance(-114, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new DeliverGear(true, false));
    	
    	// wait until button on gear holder is no longer pressed;
    	addSequential(new WaitUntilGearButtonIsUnpressed());
    	
    	addSequential(new RightRedGearPrepareForTeleop());
    }
}
