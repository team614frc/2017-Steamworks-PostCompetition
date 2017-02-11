package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.shooter.ShooterDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private boolean isEnabled = false;
	private boolean shootingFromAirship = true; // true if robot is shooting from airship; false if robot is right up to the boiler
	private double goalRPS = 0;
	private double tolerance = 0.0;
	
	private Encoder shooterEncoder = new Encoder(RobotMap.shooterEncoderA, RobotMap.shooterEncoderB, false, Encoder.EncodingType.k4X);
	
	VictorSP shooterMotor = new VictorSP(RobotMap.shooterFireMotor);
	
	public Shooter() {
		
		shooterMotor.setSafetyEnabled(false);
		
		shooterEncoder.setDistancePerPulse(Constants.SHOOTER_DISTANCE_PER_PULSE);
		shooterEncoder.reset();
	}
	
	
	public void reset() {
		shooterEncoder.reset();
	}
    public boolean isEnabled() {
    	return isEnabled;
    }
	public boolean getShootingFromAirship() {
		return shootingFromAirship;
	}
	public double getDistance() {
		return shooterEncoder.getDistance();
	}
	public double getRate() {
		return shooterEncoder.getRate();
	}
	public void setTolerance(Double t) {
		tolerance = t;
	}
	public double getTolerance() { 
		return tolerance;
	}
    public double getGoalRPS() {
    	return goalRPS;
    }
    public double getError()
    {
        return Math.abs(goalRPS - shooterEncoder.getRate());
    }
	public VictorSP getMotor() {
		return shooterMotor;
	}
	
	public void set(double speed) {
		shooterMotor.set(speed);
	}
	public void stop() {
		set(0);
	}
    public void setGoalRPS(double RPS) {
    	goalRPS = RPS;
    }
    
    public void setEnabled(boolean set, boolean shootingFromAirship) {
    	isEnabled = set;
    	this.shootingFromAirship = shootingFromAirship;
    	if(!set) {
    		shooterMotor.set(0);
    	}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterDrive());
    }


}

