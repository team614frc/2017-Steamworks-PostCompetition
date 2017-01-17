package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.pneumatics.ControlCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

	public Compressor compressor;
	private DoubleSolenoid piston;
	
	public Pneumatics() {
		compressor = new Compressor(0);
		piston = new DoubleSolenoid(0, 1);
		piston.set(RobotMap.pistonIn);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ControlCompressor());
    }
}

