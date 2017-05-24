package org.usfirst.frc.team614.robot;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.commands.drivetrain.FlippyThingButton;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToVisionTarget;
import org.usfirst.frc.team614.robot.commands.pneumatics.ActivateGearHolder;
import org.usfirst.frc.team614.robot.commands.pneumatics.TogglePiston;
import org.usfirst.frc.team614.robot.commands.shooter.ChangeSpeedBy10Percent;
import org.usfirst.frc.team614.robot.commands.shooter.Shoot;
import org.usfirst.frc.team614.robot.commands.winch.CatchAndClimbRope;
import org.usfirst.frc.team614.robot.commands.winch.ReverseWinch;
import org.usfirst.frc.team614.robot.commands.winch.StopWinch;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	// X-Box controller(s)
	public static final Gamepad driverGamepad = new Gamepad(0);
	public static final Gamepad operatorGamepad = new Gamepad(1);

	
//	private static final Button revFeeder = new JoystickButton(driverGamepad, Gamepad.button_L_Shoulder);

	private static final Button toggleDropper = new JoystickButton(driverGamepad, Gamepad.button_A);
//	private static final Button toggleSqueezer = new JoystickButton(driverGamepad, Gamepad.button_B);
	private static final Button activateGearHolder = new JoystickButton(driverGamepad, Gamepad.button_L_Shoulder);
	private static final Button flippyThing = new JoystickButton(driverGamepad, Gamepad.button_R_Shoulder);

	private static final Button TESTING_VISION_ROTATION = new JoystickButton(driverGamepad, Gamepad.button_X);
	private static final Button TESTING_RINGLIGHT_TOGGLE = new JoystickButton(driverGamepad, Gamepad.button_Y);
	
	private static final Button tryToClimbRope = new JoystickButton(operatorGamepad, Gamepad.button_R_Shoulder);
	private static final Button stopClimber = new JoystickButton(operatorGamepad, Gamepad.button_L_Shoulder);
	private static final Button reverseClimber = new JoystickButton(operatorGamepad, Gamepad.button_Back);
	
	private static final Button staticRevShooterFromBoiler = new JoystickButton(operatorGamepad, Gamepad.button_B);
	private static final Button staticRevShooterFromAirship = new JoystickButton(operatorGamepad, Gamepad.button_A);
//	private static final Button increaseShooterSpeed = new JoystickButton(operatorGamepad, Gamepad.button_Y);
//	private static final Button decreaseShooterSpeed = new JoystickButton(operatorGamepad, Gamepad.button_A);

//	private static final Button deliverGear = new JoystickButton(driverGamepad, Gamepad.button_A);

	// Binding of Commands
	public OI() {
		TESTING_VISION_ROTATION.whileHeld(new RotateToVisionTarget(false, true, true));
		TESTING_RINGLIGHT_TOGGLE.whenPressed(new TogglePiston(true));
		
		tryToClimbRope.whenPressed(new CatchAndClimbRope());
		stopClimber.whenPressed(new StopWinch());
		reverseClimber.whileHeld(new ReverseWinch());
		
		activateGearHolder.whileHeld(new ActivateGearHolder(true));
//		revFeeder.whileHeld(new RevFeeder());

		toggleDropper.whenPressed(new TogglePiston(true));
//		toggleSqueezer.whenPressed(new TogglePiston(false));
		
//		staticRevShooterFromBoiler.whileHeld(new Shoot(true, false, false, false, false));
		staticRevShooterFromAirship.whileHeld(new Shoot(true, true, false, false, false));
//		increaseShooterSpeed.whenPressed(new ChangeSpeedBy10Percent(true));
//		decreaseShooterSpeed.whenPressed(new ChangeSpeedBy10Percent(false));
		flippyThing.whenPressed(new FlippyThingButton());
		
	}
}

