
package org.usfirst.frc.team614.robot;

import org.usfirst.frc.team614.robot.commands.DoNothing;
import org.usfirst.frc.team614.robot.commands.RumbleController;
import org.usfirst.frc.team614.robot.commands.ToggleVisionRotation;
import org.usfirst.frc.team614.robot.commands.autonomous.deliverLeftRed.LeftRedGear;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraight;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightAtSmartDashboardSpeed;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.ResetDrivetrainEncoder;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.navx.ZeroNavxYaw;
import org.usfirst.frc.team614.robot.commands.shooter.ResetShooterEncoder;
import org.usfirst.frc.team614.robot.subsystems.Drivetrain;
import org.usfirst.frc.team614.robot.subsystems.Elevator;
import org.usfirst.frc.team614.robot.subsystems.Hopper;
import org.usfirst.frc.team614.robot.subsystems.Shooter;
import org.usfirst.frc.team614.robot.subsystems.Winch;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static AHRS navX;
	public static Drivetrain drivetrain;
	public static Shooter shooter;
	public static Winch winch;
	public static Elevator elevator;
	public static Hopper hopper;
	
	public static Servo shooterServo;
	
	public static boolean cameraIsActive;
	
	public static boolean gearButtonIsPressed;
	public static DigitalInput gearButton;
	
	public static PowerDistributionPanel pdp;
	public static NetworkTable gearCamera;
	public static NetworkTable shooterCamera;
	public static OI oi;
	
    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        try {
            /* Begins communication with NavX.                                     */
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
            navX = new AHRS(SPI.Port.kMXP,(byte)200);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
    	drivetrain = new Drivetrain();
    	shooter = new Shooter();
    	winch = new Winch();
    	elevator = new Elevator();
    	hopper = new Hopper();
    	
    	shooterServo = new Servo(RobotMap.shooterServo);
    	
    	cameraIsActive= true;
    	
    	gearButton = new DigitalInput(RobotMap.gearButton);
    	gearButtonIsPressed = true;
    	
    	pdp = new PowerDistributionPanel();
		oi = new OI();
		
    	NetworkTable.setServerMode();
    	NetworkTable.setTeam(614);
    	NetworkTable.initialize();
    	gearCamera = NetworkTable.getTable("gearCamera");
    	shooterCamera = NetworkTable.getTable("shooterCamera");
    	
		
        chooser = new SendableChooser();
        chooser.addDefault("Drive Straight Forever", new DriveStraight(.5));
        chooser.addObject("Drive Straight For a Little Bit", new DriveStraightForADistance(1, .5));
        chooser.addObject("Deliver Red Left Gear", new LeftRedGear());
        chooser.addObject("Do Nothing", new DoNothing());
//        SmartDashboard.putData("Autonomous", chooser);
        
        
//        SmartDashboard.putData("Run At Full Speed", new ShooterDrive());
//        SmartDashboard.putData("Drive Straight", chooser);
//        
//        SmartDashboard.putData("Update PID Values", new UpdatePIDs());

        SmartDashboard.putData("Click Here if Camera is Dead! (Or again if camera is back up)", new ToggleVisionRotation());
        SmartDashboard.putData("Zero Yaw", new ZeroNavxYaw());
        SmartDashboard.putData("Deliver Red Left Gear", new LeftRedGear());
//        SmartDashboard.putData("Rumble Left", new RumbleController(false));
//        SmartDashboard.putData("Rumble Right", new RumbleController(true));

        SmartDashboard.putBoolean("Camera is Active", cameraIsActive);
        SmartDashboard.putBoolean("Gear is in Holder", gearButton.get());
    	SmartDashboard.putNumber("Gear Camera Angle", 0);
    	SmartDashboard.putBoolean("Gear Camera Found", false);
    	SmartDashboard.putNumber("Shooter Camera Angle", 0);
    	SmartDashboard.putBoolean("Shooter Camera Found", false);
    	
//        SmartDashboard.putNumber("Drivetrain P", Constants.drivetrainP);
//        SmartDashboard.putNumber("Drivetrain I", Constants.drivetrainI);
//        SmartDashboard.putNumber("Drivetrain D", Constants.drivetrainD);
//        SmartDashboard.putNumber("Drivetrain F", Constants.drivetrainF);
        SmartDashboard.putNumber("Drivetrain Speed", Constants.DRIVETRAIN_AUTONOMOUS_SPEED);
        SmartDashboard.putNumber("Drivetrain left Encoder Distance (???)", 0);
        SmartDashboard.putNumber("Drivetrain right Encoder Distance (???)", 0);
        SmartDashboard.putNumber("Drivetrain Rotation Target (Degrees (-180, +180))", 0);

        SmartDashboard.putData("Drivetrain Reset Encoder", new ResetDrivetrainEncoder());
        SmartDashboard.putData("Drivetrain Drive", new DriveStraightAtSmartDashboardSpeed());
        SmartDashboard.putData("Drivetrain Drive for 4 Feet", new DriveStraightForADistance(48, .5));
        SmartDashboard.putData("Rotate To Absolute Angle", new RotateToAngle(90, true));
        SmartDashboard.putData("Rotate To Relative Angle", new RotateToAngle(90, false));


//        SmartDashboard.putNumber("Shooter P", Constants.shooterP);
//        SmartDashboard.putNumber("Shooter I", Constants.shooterI);
//        SmartDashboard.putNumber("Shooter D", Constants.shooterD);
//        SmartDashboard.putNumber("Shooter F", Constants.shooterF);
//        SmartDashboard.putNumber("Shooter Target (Revs/Sec)", 0);
//        SmartDashboard.putNumber("Shooter PID Target (XXX)", 0);
//        SmartDashboard.putNumber("Shooter PID Output (XXX)", 0);
//        SmartDashboard.putNumber("Shooter PID Error", 0);
//        SmartDashboard.putNumber("Shooter Encoder Count (Revs*4096)", 0);
        SmartDashboard.putNumber("Shooter Encoder Distance (Revs)", 0);
        SmartDashboard.putNumber("Shooter Encoder Rate (Revs per Sec)", 0);
		SmartDashboard.putNumber("Shooter Encoder MAX Rate (Revs per Sec)", 0);
		SmartDashboard.putNumber("Shooter Bang Bang Error", 0);
		SmartDashboard.putNumber("Shooter Bang Min", Constants.SHOOTER_BANG_MIN);
		SmartDashboard.putNumber("Shooter Bang Max", Constants.SHOOTER_BANG_MAX);
        SmartDashboard.putNumber("Shooter Target Speed (Revs per Sec)", Constants.SHOOTER_RPS);
        SmartDashboard.putNumber("Shooter Tolerance", 0);
        SmartDashboard.putNumber("Shooter Servo Angle for Airship", 0);
        SmartDashboard.putNumber("Shooter Servo Angle for Boiler", 0);

        SmartDashboard.putData("Shooter Reset Encoder", new ResetShooterEncoder());
        
        SmartDashboard.putNumber("Hopper Speed", Constants.HOPPER_SPEED);
        																																																																																																																			//		SmartDashboard.putNumber("Winch PD ID", RobotMap.PDPWinchMotor);
		SmartDashboard.putNumber("Winch Current Draw (Amps)", 0);
		SmartDashboard.putNumber("MAX Winch Current Draw (Amps)", 0);
        SmartDashboard.putNumber("Winch Encoder Distance (Revs)", 0);
        SmartDashboard.putNumber("Winch Encoder Rate (Revs per Sec)", 0);

		printNavXData();
		
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	
    	cameraIsActive = true;
    	
    	// resets NavX and disables the PID controller.
    	Robot.navX.reset();
    	Robot.winch.reset();
    	drivetrain.setUsingTurnPID(false);
    	drivetrain.setUsingDistancePID(false);
    	shooter.reset();
    	shooter.setEnabled(false, false);
    	drivetrain.reset();
//    	Robot.shooter.getPIDController().disable();
//    	Robot.shooter.getPIDController().reset();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
//    	shooter.enable();
    	Robot.navX.reset();
        autonomousCommand = (Command) chooser.getSelected();
        
		String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
			case "Drive Straight Forever": {
				autonomousCommand = new DriveStraight(.5);
				break;
			}
			case "Drive Straight For a Little Bit": {
				autonomousCommand = new DriveStraightForADistance(1, .5);
				break;
			}
			case "Deliver Red Left Gear": {
				autonomousCommand = new LeftRedGear();
				break;
			}
			default: {
				autonomousCommand = new DoNothing();
				break;
			}
		}
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
//    	shooter.enable();
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        printNavXData();

        // whenever the gear button is toggled, rumble the controller.
        SmartDashboard.putBoolean("Gear is in Holder", gearButton.get());
        if(!gearButtonIsPressed) { // last iteration, button was open
        	if(gearButton.get()) { // now, button is closed
        		Command rumble = new RumbleController(true);
        		rumble.start();
        		gearButtonIsPressed = true;
        	}
        } else {
        	if(!gearButton.get()) { // open
        		Command rumble = new RumbleController(false);
        		rumble.start();
        		gearButtonIsPressed = false;
        	}
        }
        
        // encoder distances
        
        
        SmartDashboard.putNumber("Drivetrain left Encoder Distance (???)", drivetrain.leftEncoder.getDistance());
        SmartDashboard.putNumber("Drivetrain right Encoder Distance (???)", drivetrain.rightEncoder.getDistance());

        SmartDashboard.putNumber("Drivetrain left Encoder Count (???)", drivetrain.leftEncoder.getRaw());
        SmartDashboard.putNumber("Drivetrain right Encoder Count (???)", drivetrain.rightEncoder.getRaw());
        
    	// winch
        if(SmartDashboard.getNumber("MAX Winch Current Draw (Amps)", 0) < Robot.pdp.getCurrent(RobotMap.PDPWinchMotor)) {
        	SmartDashboard.putNumber("MAX Winch Current Draw (Amps)", Robot.pdp.getCurrent(RobotMap.PDPWinchMotor));
        }
        SmartDashboard.putNumber("Winch Current Draw (Amps)", Robot.pdp.getCurrent(RobotMap.PDPWinchMotor));
        SmartDashboard.putNumber("Winch Encoder Distance (Revs)", Robot.winch.getEncoderRevolutions());
        SmartDashboard.putNumber("Winch Encoder Rate (Revs per Sec)", Robot.winch.getRate());
        
        
        // shooter
        shooter.setTolerance(SmartDashboard.getNumber("Shooter Tolerance", 0));
        SmartDashboard.putNumber("Shooter Encoder Distance (Revs)", shooter.getDistance());
//        SmartDashboard.putNumber("Shooter Encoder Count (Revs*4096)", shooter.shooterEncoder.getRaw());
        SmartDashboard.putNumber("Shooter Encoder Rate (Revs per Sec)", shooter.getRate());
		if(SmartDashboard.getNumber("Shooter Encoder MAX Rate (Revs per Sec)", 0) < shooter.getRate()) {
	        SmartDashboard.putNumber("Shooter Encoder MAX Rate (Revs per Sec)", shooter.getRate());
		}
		SmartDashboard.putNumber("Shooter Bang Bang Error", shooter.getError()); 
		SmartDashboard.putNumber("Shooter Servo Angle", shooterServo.getAngle());
		
		
        // vision
		SmartDashboard.putBoolean("Camera is Active", cameraIsActive);
    	SmartDashboard.putNumber(
    			"Gear Camera Angle",
    			gearCamera.getNumber("angle", 0)
		);
    	SmartDashboard.putNumber(
    			"Gear Camera Distance",
    			gearCamera.getNumber("distance", 0)
		);
    	SmartDashboard.putBoolean(
    			"Gear Camera Found",
    			gearCamera.getBoolean("targetFound", false)
		);
    	SmartDashboard.putNumber(
    			"Shooter Camera Angle",
    			shooterCamera.getNumber("angle", 0)
		);
    	SmartDashboard.putNumber(
    			"Shooter Camera Distance",
    			shooterCamera.getNumber("distance", 0)
		);
    	SmartDashboard.putBoolean(
    			"Shooter Camera Found",
    			shooterCamera.getBoolean("targetFound", false)
		);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    public static void printNavXData() {
		double start_time = Timer.getFPGATimestamp();
	    Timer.delay(0.020);		/* wait for one motor update time period (50Hz)     */
	
	    /* Calculate/display effective update rate in hz */
	    double delta_time = Timer.getFPGATimestamp() - start_time;
	    double update_count = navX.getUpdateCount();
	    if ( update_count > 0 ) {
	    	double avg_updates_per_sec = delta_time / update_count;
	    	if ( avg_updates_per_sec > 0.0 ) {
//	    		SmartDashboard.putNumber("EffUpdateRateHz", 1.0 / avg_updates_per_sec);
	    	}
	    }
	    
	    /* Display 6-axis Processed Angle Data                                      */
	//        SmartDashboard.putData("     ");
	    SmartDashboard.putBoolean(  "NavX Connected",        navX.isConnected());
	    SmartDashboard.putBoolean(  "NavX IsCalibrating",    navX.isCalibrating());
	    SmartDashboard.putNumber(   "Yaw",              navX.getYaw());
	    SmartDashboard.putNumber(   "Pitch",            navX.getPitch());
	    SmartDashboard.putNumber(   "Roll",             navX.getRoll());
	    
	    /* Display tilt-corrected, Magnetometer-based heading (requires             */
	    /* magnetometer calibration to be useful)                                   */
	    
//	    SmartDashboard.putNumber(   "NavX CompassHeading",   navX.getCompassHeading());
	    
	    /* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
//	    SmartDashboard.putNumber(   "NavX FusedHeading",     navX.getFusedHeading());
	
	    /* These functions are compatible w/the WPI Gyro Class, providing a simple  */
	    /* path for upgrading from the Kit-of-Parts gyro to the navx MXP            */
	    
	    SmartDashboard.putNumber(   "NavX Total Angle",         navX.getAngle());
//	    SmartDashboard.putNumber(   "NavX YawRateDPS",       navX.getRate());
	
	    /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
	    
	    SmartDashboard.putNumber(   "Accel_X",          navX.getWorldLinearAccelX());
	    SmartDashboard.putNumber(   "Accel_Y",          navX.getWorldLinearAccelY());
	    SmartDashboard.putBoolean(  "IsMoving",         navX.isMoving());
	    SmartDashboard.putBoolean(  "IsRotating",       navX.isRotating());
	
	    /* Display estimates of velocity/displacement.  Note that these values are  */
	    /* not expected to be accurate enough for estimating robot position on a    */
	    /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
	    /* of these errors due to single (velocity) integration and especially      */
	    /* double (displacement) integration.                                       */
	    
//	    SmartDashboard.putNumber(   "Velocity_X",           navX.getVelocityX());
//	    SmartDashboard.putNumber(   "Velocity_Y",           navX.getVelocityY());
//	    SmartDashboard.putNumber(   "Displacement_X",       navX.getDisplacementX());
//	    SmartDashboard.putNumber(   "Displacement_Y",       navX.getDisplacementY());
	    
	    /* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
	    /* NOTE:  These values are not normally necessary, but are made available   */
	    /* for advanced users.  Before using this data, please consider whether     */
	    /* the processed data (see above) will suit your needs.                     */
	    
//	    SmartDashboard.putNumber(   "RawGyro_X",            navX.getRawGyroX());
//	    SmartDashboard.putNumber(   "RawGyro_Y",            navX.getRawGyroY());
//	    SmartDashboard.putNumber(   "RawGyro_Z",            navX.getRawGyroZ());
//	    SmartDashboard.putNumber(   "RawAccel_X",           navX.getRawAccelX());
//	    SmartDashboard.putNumber(   "RawAccel_Y",           navX.getRawAccelY());
//	    SmartDashboard.putNumber(   "RawAccel_Z",           navX.getRawAccelZ());
//	    SmartDashboard.putNumber(   "RawMag_X",             navX.getRawMagX());
//	    SmartDashboard.putNumber(   "RawMag_Y",             navX.getRawMagY());
//	    SmartDashboard.putNumber(   "RawMag_Z",             navX.getRawMagZ());
//	    SmartDashboard.putNumber(   "IMU_Temp_C",           navX.getTempC());
	    
	    /* Omnimount Yaw Axis Information                                           */
	    /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
//	    AHRS.BoardYawAxis yaw_axis = navX.getBoardYawAxis();
//	    SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
//	    SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
	    
	    /* Sensor Board Information                                                 */
//	    SmartDashboard.putString(   "FirmwareVersion",      navX.getFirmwareVersion());
	    
	    /* Quaternion Data                                                          */
	    /* Quaternions are fascinating, and are the most compact representation of  */
	    /* orientation data.  All of the Yaw, Pitch and Roll Values can be derived  */
	    /* from the Quaternions.  If interested in motion processing, knowledge of  */
	    /* Quaternions is highly recommended.                                       */
//	    SmartDashboard.putNumber(   "QuaternionW",          navX.getQuaternionW());
//	    SmartDashboard.putNumber(   "QuaternionX",          navX.getQuaternionX());
//	    SmartDashboard.putNumber(   "QuaternionY",          navX.getQuaternionY());
//	    SmartDashboard.putNumber(   "QuaternionZ",          navX.getQuaternionZ());
	    
	    /* Sensor Data Timestamp */
//	    SmartDashboard.putNumber(   "SensorTimestamp",		navX.getLastSensorTimestamp());
	    
	    /* Connectivity Debugging Support                                           */
//	    SmartDashboard.putNumber(   "IMU_Byte_Count",       navX.getByteCount());
//	    SmartDashboard.putNumber(   "IMU_Update_Count",     navX.getUpdateCount());
    }
}
