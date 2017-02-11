package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Winch extends Subsystem {

	VictorSP winchMotorA = new VictorSP(RobotMap.winchMotorA);
	VictorSP winchMotorB = new VictorSP(RobotMap.winchMotorB);
	private Encoder winchEncoder = new Encoder(RobotMap.winchEncoderA, RobotMap.winchEncoderB, true, Encoder.EncodingType.k4X);
	
	private boolean shouldBeStopped;
	
	public Winch() {
		
		winchEncoder.setDistancePerPulse(Constants.WINCH_ENCODER_DISTANCE_PER_PULSE);
		winchEncoder.reset();
	
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void set(double speed) {
		shouldBeStopped = false;
		winchMotorA.set(speed);
		winchMotorB.set(speed);
	}
	public void stop() {
		shouldBeStopped = true;
		winchMotorA.set(0.0);
		winchMotorB.set(0.0);
	}
	public void reset() {
		winchEncoder.reset();
	}
	public double getEncoderRevolutions() {
		return winchEncoder.getDistance();
	}
	public double getRate() {
		return winchEncoder.getRate();
	}
	public boolean shouldBeStopped() {
		return shouldBeStopped;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new WinchDrive());
    }
}

