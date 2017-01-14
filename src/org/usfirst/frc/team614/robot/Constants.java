package org.usfirst.frc.team614.robot;

// Constant values used throughout the project

public class Constants {
	// Drivetrain
	public static final double DRIVETRAIN_WHEEL_DIAMETER = 4;
	public static final double DRIVETRAIN_ENCODER_PULSES_PER_REV = 256.0;
	public static final double DISTANCE_PER_PULSE = (Constants.DRIVETRAIN_WHEEL_DIAMETER * Math.PI) / Constants.DRIVETRAIN_ENCODER_PULSES_PER_REV;
}
