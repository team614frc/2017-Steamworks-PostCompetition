package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.DeliverGear;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToVisionTarget;
import org.usfirst.frc.team614.robot.commands.shooter.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedCenterGearAndShoot extends CommandGroup {

    public RedCenterGearAndShoot() {
    	addSequential(new DeliverGear(false, false, true));
    	
    	addSequential(new RotateToAngle(90, true));
    	
    	addParallel(new Shoot(false, true, true, false, false));
    }
}
