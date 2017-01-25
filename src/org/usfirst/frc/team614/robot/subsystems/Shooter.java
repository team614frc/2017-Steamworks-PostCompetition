package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.autonomous.shooter.ShooterDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Uses a feeder motor and a fire motor to shoot the balls.
 */
public class Shooter extends PIDSubsystem
{
	
	// The port the is not final.
//	VictorSP feederMotor = new VictorSP(RobotMap.shooterFeederMotor);
//	VictorSP fireMotor = new VictorSP(RobotMap.shooterFireMotor);
	CANTalon fireMotor = new CANTalon(RobotMap.shooterFireID);

//	private double feederSpeed, fireSpeed;
	
	public Shooter()
	{
		super("Shooter", 0.015, 0.001, 0.0);
		// .7 motor speed ~= 3833 RPM
		
		// sets PID parameters for firing motor
		fireMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder); // change to w/e encoder type we use
		
		fireMotor.changeControlMode(TalonControlMode.Speed);
		fireMotor.set(0.0);
		
		
		fireMotor.reverseSensor(true);
		fireMotor.configEncoderCodesPerRev(128);
		//fireMotor.setPosition(0);
		
		/* if using QuadEncoder:
		fireMotor.configEncoderCodesPerRev(XXX);
		 * if using AnalogEncoder or AnalogPot:
		fireMotor.configPotentiometerTurns(XXX);
		 */
        /* set the peak and nominal outputs, 12V means full */
        fireMotor.configNominalOutputVoltage(+0.0f, -0.0f);
        fireMotor.configPeakOutputVoltage(+12.0f, 0.0f);
        /* set closed loop gains in slot0 */
        fireMotor.setProfile(1);
        
        // PID TUNING PARAMETERS for FIRE MOTOR
        // see 12.4.2 of CAN Talon SRX Software Reference Manual
        fireMotor.setF(.1097);
        fireMotor.setP(.22);
        fireMotor.setI(0);
        fireMotor.setD(0);
        
//		setInputRange(0, 800000);
//        setAbsoluteTolerance(1000);

        enable();
        /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
        /* tuning of the Turn Controller's P, I and D coefficients.            */
        /* Typically, only the P value needs to be modified.                   */
        LiveWindow.addActuator("ShooterSystem", "ShooterSpeed", getPIDController());
	}

	// spins the flywheels out to shoot a wiffle ball
	public void rev(double speed)
	{
//		feederMotor.set(feederSpeed);
		fireMotor.changeControlMode(TalonControlMode.Speed);
		fireMotor.set(speed);
	}

	// stops the flywheels
	public void stop()
	{
//		feederMotor.set(0.0);
		fireMotor.set(0.0);
	}
	public CANTalon getFireMotor() {
		return fireMotor;
	}
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		 setDefaultCommand(new ShooterDrive());
	}

	protected double returnPIDInput() {
		return fireMotor.getSpeed();
	}

	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("OUTPUT", output);
		fireMotor.set(-output);
	}
	
//
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//	
//	public static CANTalon shooterMotor;
//	
//	public Shooter() {
//		shooterMotor = new CANTalon(RobotMap.shooterFireID);
//		shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//		
//		shooterMotor.changeControlMode(TalonControlMode.Speed);
//		shooterMotor.set(0.0);
//		
//		shooterMotor.reverseSensor(true);
//		shooterMotor.configEncoderCodesPerRev(128);
//		
//		shooterMotor.configNominalOutputVoltage(+0.0,  -0.0);
//		shooterMotor.configPeakOutputVoltage(+12.0, 0.0);
//		
//		shooterMotor.setProfile(1);
//		shooterMotor.setF(0.1097);
//		shooterMotor.setP(0.22);
//		shooterMotor.setI(0);
//		shooterMotor.setD(0);
//	}
//	
//	public void rev(double speed) {
//		shooterMotor.set(speed);
//	}
//
//	public CANTalon getShooterMotor() {
//		return shooterMotor;
//	}
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        setDefaultCommand(new ShooterDrive());
//    }
}
