package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.autonomous.shooter.ShooterDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	public VictorSP shooterVictor = new VictorSP(RobotMap.shooterFireMotor);
	CANTalon shooterMotor = new CANTalon(1);
	
	public Shooter() {

		shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterMotor.reverseSensor(false);
		shooterMotor.configEncoderCodesPerRev(128); // if using FeedbackDevice.QuadEncoder
		
        /* set the peak and nominal outputs, 12V means full */
		shooterMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotor.configPeakOutputVoltage(+12.0f, 0.0f);
        /* set closed loop gains in slot0 */
		shooterMotor.setProfile(1); // just trust me on this?
		shooterMotor.setF(0.1097);
		shooterMotor.setP(0.22);
		shooterMotor.setI(0); 
		shooterMotor.setD(0);
		
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public CANTalon getShooterMotor() {
		return shooterMotor;
	}
	public VictorSP getVictor() {
		return shooterVictor;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterDrive());
    }
}

