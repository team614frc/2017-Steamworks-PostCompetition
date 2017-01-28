package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.drivetrain.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem implements PIDOutput {
    
	public RobotDrive drivetrain;
	public Encoder leftEncoder;
	public Encoder rightEncoder;
	
	PIDController turnController;
    private double rotateToAngleRate;
    private boolean usingPID;
    
    /* The following PID Controller coefficients will need to be tuned */
    /* to match the dynamics of your drive system.  Note that the      */
    /* SmartDashboard in Test mode has support for helping you tune    */
    /* controllers by displaying a form where you can enter new P, I,  */
    /* and D constants and test the mechanism.                         */
    

    static final double kToleranceDegrees = 2.0f;
	
	// VictorSP motor controllers
//	VictorSP leftMotor = new VictorSP(RobotMap.drivetrainLeftMotor);
//	VictorSP rightMotor = new VictorSP(RobotMap.drivetrainRightMotor);

	VictorSP leftMotorA = new VictorSP(0);
	VictorSP rightMotorA = new VictorSP(1);
	VictorSP leftMotorB = new VictorSP(2);
	VictorSP rightMotorB = new VictorSP(3);
	
	public Drivetrain() {
		
		usingPID = false;
		drivetrain = new RobotDrive(leftMotorA, leftMotorB, rightMotorA, rightMotorB);
		leftEncoder = new Encoder(RobotMap.drivetrainLeftEncoderA, RobotMap.drivetrainLeftEncoderB, false, Encoder.EncodingType.k4X);
		rightEncoder = new Encoder(RobotMap.drivetrainRightEncoderA, RobotMap.drivetrainRightEncoderB, false, Encoder.EncodingType.k4X);

		leftEncoder.setDistancePerPulse(Constants.DRIVETRAIN_DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(Constants.DRIVETRAIN_DISTANCE_PER_PULSE);
		
		turnController = new PIDController(
				Constants.drivetrainP,
				Constants.drivetrainI,
				Constants.drivetrainD,
				Constants.drivetrainF,
				Robot.navX, this
		);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);

        /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
        /* tuning of the Turn Controller's P, I and D coefficients.            */
        /* Typically, only the P value needs to be modified.                   */
        LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
        
	}
	
    // Set the default command that constantly runs here.
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
    public void arcadeDrive(double moveValue, double rotateValue) {
    	drivetrain.arcadeDrive(moveValue, -rotateValue);
    }
    public void stop() {
    	drivetrain.arcadeDrive(0, 0);
    }
	public void setUsingPID(boolean set) {
		usingPID = set;
		if(set == true) {
			turnController.enable();
		} else {
			turnController.disable();
		}
	}
	public boolean getUsingPID() {
		return usingPID;
	}
	public double getRotateRate() {
		return rotateToAngleRate;
	}
	public PIDController getController() {
		return turnController;
	}

	public void pidWrite(double output) {
		rotateToAngleRate = output;
	}
}

