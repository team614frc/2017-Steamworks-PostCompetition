package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Winch extends Subsystem {
	
	VictorSP winchMotor = new VictorSP(RobotMap.winchMotor);
	public Encoder winchEncoder = new Encoder(RobotMap.winchEncoderA, RobotMap.winchEncoderB, false, Encoder.EncodingType.k4X);
	
	public Winch() {
		
		winchEncoder.setDistancePerPulse(Constants.WINCH_DISTANCE_PER_PULSE);
		winchEncoder.reset();
	
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void spinWinch(double speed) {
		winchMotor.set(speed);
	}
	public void stop() {
		winchMotor.set(0.0);
	}
	public void reset() {
		winchEncoder.reset();
	}
	public double getEncoderRevolutions() {
		return winchEncoder.getDistance();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new WinchDrive());
    }
}

