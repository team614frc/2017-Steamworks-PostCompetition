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
	PIDController distanceController;

    private double PIDrotateToAngleRate;
    private double PIDdistanceSpeed;
    
    private boolean usingTurnPID;
    private boolean usingDistancePID;
    
    /* The following PID Controller coefficients will need to be tuned */
    /* to match the dynamics of your drive system.  Note that the      */
    /* SmartDashboard in Test mode has support for helping you tune    */
    /* controllers by displaying a form where you can enter new P, I,  */
    /* and D constants and test the mechanism.                         */
    

    static final double turnTolerance = 0.1f;
    static final double distanceTolerance = 0.1f;
	
	// VictorSP motor controllers
//	VictorSP leftMotor = new VictorSP(RobotMap.drivetrainLeftMotor);
//	VictorSP rightMotor = new VictorSP(RobotMap.drivetrainRightMotor);

	VictorSP leftMotorA = new VictorSP(RobotMap.drivetrainLeftMotorA);
	VictorSP leftMotorB = new VictorSP(RobotMap.drivetrainLeftMotorB);
	VictorSP rightMotorA = new VictorSP(RobotMap.drivetrainRightMotorA);
	VictorSP rightMotorB = new VictorSP(RobotMap.drivetrainRightMotorB);
	
	public Drivetrain() {
		
		usingTurnPID = false;
		usingDistancePID = false;
		drivetrain = new RobotDrive(leftMotorA, leftMotorB, rightMotorA, rightMotorB);
		leftEncoder = new Encoder(RobotMap.drivetrainLeftEncoderA, RobotMap.drivetrainLeftEncoderB, false, Encoder.EncodingType.k4X);
		rightEncoder = new Encoder(RobotMap.drivetrainRightEncoderA, RobotMap.drivetrainRightEncoderB, false, Encoder.EncodingType.k4X);

		leftEncoder.setDistancePerPulse(Constants.DRIVETRAIN_DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(Constants.DRIVETRAIN_DISTANCE_PER_PULSE);
		
		turnController = new PIDController(
				Constants.drivetrainRotationP,
				Constants.drivetrainRotationI,
				Constants.drivetrainRotationD,
				Constants.drivetrainRotationF,
				Robot.navX, this
		);
		distanceController = new PIDController(
				Constants.drivetrainDistanceP,
				Constants.drivetrainDistanceI,
				Constants.drivetrainDistanceD,
				Constants.drivetrainDistanceF,
				rightEncoder, this
		);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(turnTolerance);
        turnController.setContinuous(true);
        
        distanceController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(distanceTolerance);

        /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
        /* tuning of the Turn Controller's P, I and D coefficients.            */
        /* Typically, only the P value needs to be modified.                   */
        LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
        LiveWindow.addActuator("DriveSystem", "DistanceController", distanceController);
        
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
    public void setDistancePerPulse(double dpp) {

		leftEncoder.setDistancePerPulse(dpp);
		rightEncoder.setDistancePerPulse(dpp);
    }
    public void reset() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
	public void setUsingTurnPID(boolean set) {
		usingTurnPID = true;
		if(set == true) {
			turnController.enable();
		} else {
			turnController.disable();
		}
	}
	public void setUsingDistancePID(boolean set) {
		usingDistancePID = true;
		if(set == true) {
			distanceController.enable();
		} else {
			distanceController.disable();
		}
	}
	public boolean getUsingTurnPID() {
		return usingTurnPID;
	}
	public boolean getUsingDistancePID() {
		return usingTurnPID;
	}
	public double getPIDRotateRate() {
		return PIDrotateToAngleRate;
	}
	public double getPIDSpeed() {
		return PIDdistanceSpeed;
	}
	public PIDController getTurnController() {
		return turnController;
	}
	public PIDController getDistanceController() {
		return distanceController;
	}

	public void pidWrite(double output) {
		if(usingTurnPID)
			PIDrotateToAngleRate = output;
		if(usingDistancePID)
			PIDdistanceSpeed = output;
	}
}

