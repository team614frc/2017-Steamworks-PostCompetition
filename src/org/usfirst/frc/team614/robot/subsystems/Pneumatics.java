package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.commands.pneumatics.CompressorControl;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

	public Compressor compressor;
	
	public DoubleSolenoid dropper;
//	public DoubleSolenoid squeezer;
	
	public Pneumatics() {
		compressor = new Compressor(0);
		
		dropper = new DoubleSolenoid(0, 1);
		dropper.set(Constants.pistonIn);
//		squeezer = new DoubleSolenoid(2, 3);
//		squeezer.set(Constants.pistonIn);
		
	}
    // extends piston
    public void extendDropper() {
    	dropper.set(Constants.pistonOut);
    }
//    public void extendSqueezer() {
//    	squeezer.set(Constants.pistonOut);
//    }
    // retracts piston
    public void retractDropper() {
    	dropper.set(Constants.pistonIn);
    }
//    public void retractSqueezer() {
//    	squeezer.set(Constants.pistonIn);
//    }
    // returns piston state, forward or reverse
    public DoubleSolenoid.Value getDropperState() {
		return dropper.get();
    }
//    public DoubleSolenoid.Value getSqueezerState() {
//		return squeezer.get();
//    }
    // sets piston state, forward or reverse
    public void setDropperState(DoubleSolenoid.Value newState) {
    	dropper.set(newState);
    }
//    public void setSqueezerState(DoubleSolenoid.Value newState) {
//    	squeezer.set(newState);
//    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CompressorControl());
    }
}
