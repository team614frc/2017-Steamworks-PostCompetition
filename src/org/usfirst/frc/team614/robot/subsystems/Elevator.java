package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private VictorSP elevatorMotor = new VictorSP(RobotMap.elevatorMotor);
	
	public Elevator() {
		
	}
	
	public void set(double speed) {
		elevatorMotor.set(speed);
	}
	public void stop() {
		elevatorMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

