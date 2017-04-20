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
public class Shooter extends Subsystem implements PIDOutput {

	public CANTalon talon = new CANTalon(0);
	
	public boolean isOnTarget = false;
	private boolean isEnabled = false;
	private boolean usingEncoder = true;
	private boolean shootingFromAirship = true; // true if robot is shooting from airship; false if robot is right up to the boiler
	private double goalRPS = 0;
	private double tolerance = 0.0;
	private double PIDspeed = 0.0;
	private double speed = Constants.SHOOTER_PERCENT;
	
	private PIDController velocityController;
	
	private Encoder shooterEncoder = new Encoder(RobotMap.shooterEncoderA, RobotMap.shooterEncoderB, false, Encoder.EncodingType.k4X);
	
	VictorSP shooterMotor = new VictorSP(RobotMap.shooterFireMotor);
	
	public Shooter() {
		
		talon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);

		talon.reverseSensor(true);
		
		talon.changeControlMode(TalonControlMode.Speed);
		
		talon.setVoltageRampRate(36.0);
		talon.setStatusFrameRateMs(StatusFrameRate.Feedback, 10);
		talon.clearStickyFaults();
		
		
		
		
		talon.reverseSensor(true);
//		talon.configEncoderCodesPerRev(128);

        talon.setProfile(1);
        
        // PID TUNING PARAMETERS for FIRE MOTOR
        // see 12.4.2 of CAN Talon SRX Software Reference Manual
        talon.setF(.0404);
        talon.setP(.45);
        talon.setI(0);
        talon.setD(0);
//        talon.setPID(.22, 0, 0, .1093, (int) (1023/.22), 0, 0);
		talon.set(0.0);
//		setInputRange(0, 800000);
//      setAbsoluteTolerance(1000);

        talon.enable();
        /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
        /* tuning of the Turn Controller's P, I and D coefficients.            */
        /* Typically, only the P value needs to be modified.                   */
        LiveWindow.addActuator("ShooterSystem", "ShooterSpeed", talon);
		
		
		velocityController = new PIDController(
				Constants.shooterP,
				Constants.shooterI,
				Constants.shooterD,
				Constants.shooterF,
				shooterEncoder, this
		);

        velocityController.setInputRange(0.0,  60.0);
        velocityController.setOutputRange(-1.0, 1.0);
		
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
    public boolean getUsingEncoder() {
    	return usingEncoder;
    }
    public void setUsingEncoder(boolean set) {
    	usingEncoder = true;
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
    public double getPIDspeed() {
    	return PIDspeed;
    }
    public PIDController getVelocityController() {
    	return velocityController;
    }
	public VictorSP getMotor() {
		return shooterMotor;
	}

	public void set(double speed) {
		shooterMotor.set(speed);
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getSpeed() {
		return speed;
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
    	if(set){
    		velocityController.enable();
    	} else {
    		velocityController.setSetpoint(0);
    		stop();
    		velocityController.disable();
    	}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterDrive());
    }

	public void pidWrite(double output) {
		PIDspeed = output;
	}
}


