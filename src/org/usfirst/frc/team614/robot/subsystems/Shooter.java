package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.autonomous.shooter.ShooterDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends PIDSubsystem {
	boolean usingPID = true;
	
	public Encoder shooterEncoder = new Encoder(RobotMap.shooterEncoderA, RobotMap.shooterEncoderB, false, Encoder.EncodingType.k4X);
	
	VictorSP shooterVictor = new VictorSP(RobotMap.shooterFireMotor);
	
	public Shooter() {
		super("Shooter", Constants.shooterP, Constants.shooterI, Constants.shooterD, Constants.shooterF);
//		
		shooterEncoder.setDistancePerPulse(Constants.SHOOTER_DISTANCE_PER_PULSE);
		shooterEncoder.reset();
//		enable();
	}
	
	public VictorSP getVictor() {
		return shooterVictor;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterDrive());
    }
    
    public void setUsingPID(boolean set) {
    	usingPID = set;
    }

	protected double returnPIDInput() {
		return shooterEncoder.getRate(); // Revs per Second
	}

	protected void usePIDOutput(double output) {
		if(usingPID) {
//			shooterVictor.pidWrite(output);
			SmartDashboard.putNumber("Shooter PID Output [XXX]", output);
//			shooterVictor.pidWrite(output);
//			shooterVictor.set(output / maxRevolutionsPerSecond); // does not work
//			shooterVictor.set
			// set speed to [ current rate ] / [ maximum possible rate ]
		} else {
			
		}
	}
}

