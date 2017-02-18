package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.gearholder.GearButtonChecker;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHolder extends Subsystem {

	public static DigitalInput gearButton;
	
	public GearHolder() {
		
    	gearButton = new DigitalInput(RobotMap.gearButton);
		
	}
	public boolean getIsPushed() { // true if open (hopefully?)
		return gearButton.get();
	}
    public void initDefaultCommand() {

    	setDefaultCommand(new GearButtonChecker());
    }
}

