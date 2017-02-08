package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

	// Change these when you shuffle PWM cables around
	// DIO
	public static final int drivetrainLeftEncoderA = 0;
	public static final int drivetrainLeftEncoderB = 1;
	public static final int drivetrainRightEncoderA = 2;
	public static final int drivetrainRightEncoderB = 3;
	public static final int shooterEncoderA = 4;
	public static final int shooterEncoderB = 5;
	public static final int winchEncoderA = 6;
	public static final int winchEncoderB = 7;
	
	// Motor Controller Ports (PWM)
	public static final int drivetrainLeftMotorA = 0;
	public static final int drivetrainLeftMotorB = 1;
	public static final int drivetrainRightMotorA = 2;
	public static final int drivetrainRightMotorB = 3;

	public static final int winchMotorA = 4;
	public static final int winchMotorB = 5;
	
	public static final int shooterFireMotor = 6;
	
	public static final int elevatorMotor = 7;
	
	public static final int hopperMotor = 8;

	// Power Distribution Board
	public static final int PDPWinchMotor = 0; // we think it's zero
	
	// Pneumatics
	public static final DoubleSolenoid.Value pistonOut = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value pistonIn = DoubleSolenoid.Value.kReverse;

}
