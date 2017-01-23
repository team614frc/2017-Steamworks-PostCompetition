package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


public class Winch extends Subsystem {
	CANTalon test = new CANTalon(RobotMap.winchMotor);
	
	public Winch() {
		//nothing here just yet
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void spinMotor(double speed) {
	  test.set(speed);
	}
	public void stopMotor() {
	  test.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

