package org.usfirst.frc.team5534.robot;

public class DriverDefault {


	public static void Init() {
		
	}

		
	public static void Periodic() {
		
		double PowerD = DriveByArcade.GetThrust();
		double PowerT = DriveByArcade.GetTurn();;
		Drivetrain.DriveByArcade( PowerD,  PowerT );

	}


}
