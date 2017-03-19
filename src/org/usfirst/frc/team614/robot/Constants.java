package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

// Constant values used throughout the project

public class Constants {
	
	// Drivetrain
	public static final double drivetrainRotationP = 0.1;
	public static final double drivetrainRotationI = 0;
	public static final double drivetrainRotationD = 0.12;
	public static final double drivetrainRotationF = 0;
	public static final double drivetrainDistanceP = 0.05;
	public static final double drivetrainDistanceI = 0;
	public static final double drivetrainDistanceD = 0.0;
	public static final double drivetrainDistanceF = 0;
	public static final double DRIVETRAIN_WHEEL_DIAMETER = 4;
	public static final double DRIVETRAIN_AUTONOMOUS_SPEED = 1.0; // more of a multiplier tbh
	public static final double DRIVETRAIN_ENCODER_PULSES_PER_REV = 220.0;//250.0;
	// each "distance" unit is 1 inch.
	public static final double DRIVETRAIN_DISTANCE_PER_PULSE = (Constants.DRIVETRAIN_WHEEL_DIAMETER * Math.PI) / Constants.DRIVETRAIN_ENCODER_PULSES_PER_REV;
//	public static final double DRIVETRAIN_DISTANCE_PER_PULSE = 1 / DRIVETRAIN_ENCODER_PULSES_PER_REV;

	// Shooter

	public static final double shooterP = 0.3;
	public static final double shooterI = 0.0;
	public static final double shooterD = 0.0;
	public static final double shooterF = 0.0;
	public static final double SHOOTER_ENCODER_COUNTS_PER_REV = 1024.0;
	public static final double SHOOTER_PERCENT = .7;
	public static final double SHOOTER_RPS= 32;
	public static final double SHOOTER_BANG_MIN = .6;
	public static final double SHOOTER_BANG_MAX = .85;
	public static final double SHOOTER_DISTANCE_PER_PULSE = 1 / SHOOTER_ENCODER_COUNTS_PER_REV;
	
	// Winch
	public static final double WINCH_SPEED = 1.0;
	public static final double WINCH_ENCODER_REVOLUTIONS_TO_TOP = 5.5 / 2;
	public static final double WINCH_CURRENT_DRAW_AT_MAX_HEIGHT = 20; // must be adjusted as new weights are added
	public static final double WINCH_CURRENT_DRAW_AT_CATCHING_ROPE = 12.0; // must be adjusted as new weights are added
	public static final double WINCH_ENCODER_COUNTS_PER_REV = 1024; // must be changed
	public static final double WINCH_ENCODER_DISTANCE_PER_PULSE = 1 / WINCH_ENCODER_COUNTS_PER_REV;
	
	// GearFeeder
	public static final double FEEDER_SPEED = .7;
	
	// Hopper
	public static final double HOPPER_SPEED = -1.0;
	
	// Pneumatics
	public static final DoubleSolenoid.Value pistonOut = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value pistonIn = DoubleSolenoid.Value.kReverse;
	
}
