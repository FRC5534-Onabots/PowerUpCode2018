package org.usfirst.frc.team5534.robot;

public class DriverSteensma {

	
	public static void Init() {
		
	}
	
	
	public static void Periodic() {
		
		double PowerD = DriveByArcade.GetThrust();
		double PowerT = DriveByArcade.GetTurn() / 3;
		Drivetrain.DriveByArcade( PowerD,  PowerT );
				
	}
	
}
