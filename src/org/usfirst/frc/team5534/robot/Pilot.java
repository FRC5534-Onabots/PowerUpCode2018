package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Pilot {

	public static Joystick DriveStick = new Joystick( Ports.USB_ArcadeStick );
	
	
	public static double GetThrottle() {
		return DriveStick.getThrottle();
	}
	
	
	public static double GetThrust() {
		return -DriveStick.getY();
	}
	
	
	public static double GetTurn() {
		return DriveStick.getX() / 3;
	}

	
	public static double GetTwist() {
		return DriveStick.getTwist() / 3;
	}
	

	public static boolean GetButton( int button ) {
		return DriveStick.getRawButton( button );
	}

	public static XboxController Xbox = new XboxController( Ports.USB_Xbox );
	
}

