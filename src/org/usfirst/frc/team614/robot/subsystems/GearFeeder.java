package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearFeeder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private VictorSP feederMotor = new VictorSP(RobotMap.feederMotor);
	
	public GearFeeder() {
		
	}
	
	public void set(double speed) {
		feederMotor.set(speed);
	}
	public void stop() {
		feederMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

