package org.usfirst.frc.team614.robot;

// Constant values used throughout the project

public class Constants {
	
	// Drivetrain
	public static final double drivetrainP = 0.05;
	public static final double drivetrainI = 0;
	public static final double drivetrainD = 0.12;
	public static final double drivetrainF = 0;
	public static final double DRIVETRAIN_WHEEL_DIAMETER = 4;
	public static final double DRIVETRAIN_AUTONOMOUS_SPEED = .5;
	public static final double DRIVETRAIN_ENCODER_PULSES_PER_REV = 250.0;
//	public static final double DRIVETRAIN_DISTANCE_PER_PULSE = (Constants.DRIVETRAIN_WHEEL_DIAMETER * Math.PI) / Constants.DRIVETRAIN_ENCODER_PULSES_PER_REV;
	public static final double DRIVETRAIN_DISTANCE_PER_PULSE = 1 / DRIVETRAIN_ENCODER_PULSES_PER_REV;

	// Shooter
	public static final double SHOOTER_ENCODER_COUNTS_PER_REV = 1024.0;
	public static final double SHOOTER_DISTANCE_PER_PULSE = 1 / SHOOTER_ENCODER_COUNTS_PER_REV;
	
	// Winch
	public static final double WINCH_SPEED = .4;
	public static final double WINCH_ENCODER_REVOLUTIONS_TO_TOP = 100;
	public static final double WINCH_CURRENT_DRAW_AT_MAX_HEIGHT = 60.0; // must be adjusted as new weights are added
	public static final double WINCH_CURRENT_DRAW_AT_CATCHING_ROPE = 10.0; // must be adjusted as new weights are added
	public static final double WINCH_ENCODER_COUNTS_PER_REV = 1024; // must be changed
	public static final double WINCH_ENCODER_DISTANCE_PER_PULSE = 1 / WINCH_ENCODER_COUNTS_PER_REV;
	
	// Elevator
	public static final double ELEVATOR_SPEED = .7;
	
	// Hopper
	public static final double HOPPER_SPEED = .5;
}
