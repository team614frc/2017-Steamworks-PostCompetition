package org.usfirst.frc.team614.robot.commands.winch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CatchAndClimbRope extends CommandGroup {

    public CatchAndClimbRope() {

    	addSequential(new TryToCatchRope());
    	addSequential(new ClimbRopeUsingEncoder());
    	
    }
}
