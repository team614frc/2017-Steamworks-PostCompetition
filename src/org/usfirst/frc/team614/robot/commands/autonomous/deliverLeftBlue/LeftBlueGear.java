package org.usfirst.frc.team614.robot.commands.autonomous.deliverLeftBlue;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.DeliverGear;
import org.usfirst.frc.team614.robot.commands.WaitUntilGearButtonIsUnpressed;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftBlueGear extends CommandGroup {

    public LeftBlueGear() {
    	addSequential(new DriveForADistance(-114, -Constants.DRIVETRAIN_AUTONOMOUS_SPEED));
    	addSequential(new DeliverGear(true, true));
    	
    	// wait until button on gear holder is no longer pressed;
    	addSequential(new WaitUntilGearButtonIsUnpressed());
    	
    	addSequential(new LeftBlueGearPrepareForTeleop());
    }
}
