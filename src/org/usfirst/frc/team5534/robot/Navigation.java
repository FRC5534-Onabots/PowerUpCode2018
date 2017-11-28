package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;

public class Navigation {

	public static ADXRS450_Gyro Gyroscope = new ADXRS450_Gyro();

	public static Encoder DriveEncoderR = new Encoder(
			Ports.DIO_DriveEncoderR[0],
			Ports.DIO_DriveEncoderR[1],
			true); // Reverse direction on right side

	public static Ultrasonic Sonar = new Ultrasonic(
			Ports.DIO_RangeFinder[0],
			Ports.DIO_RangeFinder[1]);
	
	// ===
	
	public static void Initialize() {
		DriveEncoderR.setDistancePerPulse(0.009523);
		DriveEncoderR.reset();
		Sonar.setAutomaticMode(true);
		Gyroscope.calibrate();
		Gyroscope.reset();
	}

	
	public static void Reset() {
		DriveEncoderR.setDistancePerPulse(0.009523);
		DriveEncoderR.reset();
		Sonar.setAutomaticMode(true);
		Gyroscope.reset();
	}
	
	// ===
	
	public static double GetDistance() {
		return DriveEncoderR.getDistance();
	}

	
	public static double GetDelta( double targetHeading ) {
		return ( targetHeading - Gyroscope.getAngle() + 180 ) % 360 - 180;
	}

	
	public static double GetDriveSpeed() {
		return DriveEncoderR.getRate();
	}
	

	public static double GetHeading() {
		return Gyroscope.getAngle();
	}
	
	
	public static double GetRange() {
		return Sonar.getRangeInches();
	}
	
	
	public static double GetTurnSpeed() {
		return Gyroscope.getRate();
	}
	
}
