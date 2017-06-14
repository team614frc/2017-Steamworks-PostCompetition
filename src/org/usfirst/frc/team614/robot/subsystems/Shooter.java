package org.usfirst.frc.team614.robot.subsystems;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.OI;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.shooter.ShooterDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.StatusFrameRate;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Shooter extends Subsystem {

	public boolean isOnTarget = false;
	private boolean usingEncoder = true;
	private boolean shootingFromAirship = true; // true if robot is shooting from airship; false if robot is right up to the boiler
	
	
	public CANTalon talonMaster = new CANTalon(RobotMap.talonMaster);
	public CANTalon talonSlave = new CANTalon(RobotMap.talonSlave);
	public VictorSP victorAccelerator = new VictorSP(RobotMap.shooterFeederAccelerator);
	public VictorSP victorBelts = new VictorSP(RobotMap.shooterFeederBelts);
	
	public Shooter() {

		talonMaster.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);

		talonMaster.changeControlMode(TalonControlMode.Speed);
		
		talonMaster.setVoltageRampRate(36.0);
		talonMaster.setStatusFrameRateMs(StatusFrameRate.Feedback, 10);
		talonMaster.clearStickyFaults();

		talonMaster.reverseSensor(false);
		talonMaster.reverseOutput(true);

        talonMaster.setProfile(1);
        
        talonMaster.setP(Constants.shooterP);
        talonMaster.setI(Constants.shooterI);
        talonMaster.setD(Constants.shooterD);
        talonMaster.setF(Constants.shooterF);
        
		talonMaster.set(0.0);
		
        talonMaster.enable();
        
        
		talonSlave.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);

		talonSlave.changeControlMode(TalonControlMode.Speed);
		
		talonSlave.setVoltageRampRate(36.0);
		talonSlave.setStatusFrameRateMs(StatusFrameRate.Feedback, 10);
		talonSlave.clearStickyFaults();
		

        talonSlave.setProfile(1);
        
        talonSlave.setP(Constants.shooterP);
        talonSlave.setI(Constants.shooterI);
        talonSlave.setD(Constants.shooterD);
        talonSlave.setF(Constants.shooterF);
        
		talonSlave.set(0.0);
		
        talonSlave.enable();

		talonSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		talonSlave.set(talonMaster.getDeviceID());
		talonSlave.reverseOutput(true);
        
		victorAccelerator.set(0);
		victorBelts.set(0);
	}
	
	public void reset() {
//		talonMaster.reset();
//		talonSlave.reset();
	}
    public boolean getUsingEncoder() {
    	return usingEncoder;
    }
    public void setUsingEncoder(boolean set) {
    	usingEncoder = true;
    }
	public boolean getShootingFromAirship() {
		return shootingFromAirship;
	}
	public void revFeeder(double speed) {
		victorAccelerator.set(speed);
		victorBelts.set(speed);
	}
	public double getDistance() {
		return talonMaster.get();
	}
	public double getSpeed() {
		return talonMaster.getSpeed();
	}
	public double getError() {
		return talonMaster.getSpeed() - talonMaster.getSetpoint();
	}
	public double getSetpoint() {
		return talonMaster.getSetpoint();
	}
	public void set(double speed) {
		talonMaster.set(speed);
	}
	public void stop() {
		talonMaster.changeControlMode(TalonControlMode.PercentVbus);
		set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new ShooterDrive());
    }

}


