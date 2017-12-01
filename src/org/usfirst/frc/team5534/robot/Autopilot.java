package org.usfirst.frc.team5534.robot;

public class Autopilot {
	
	public static double LastBearing = 0;
	
	
	public static void ResetHeading( double targetHeading ) {
		LastBearing = targetHeading;
	}


	public static void DriveForwardToDistance( double targetSpeed, double targetDistance ) {
		Pilot.DriveToHeading( targetSpeed, LastBearing );
		Stage.WaitForForwardDistance( targetDistance );
	}

	
	public static void DriveReverseToDistance( double targetSpeed, double targetDistance ) {
		Pilot.DriveToHeading( -targetSpeed, LastBearing );
		Stage.WaitForReverseDistance( targetDistance );
	}

	
	public static void DriveToSurface( double targetSpeed, double targetDistance ) {
		if ( Navigation.GetRange() > targetDistance ) {

//			Drivetrain.DriveToHeading( targetSpeed, LastBearing );
			Stage.StillWorking = true;

		} else { Drivetrain.Stop(); }
	}
	
	
	public static void DriveToTarget( double targetSpeed, double targetDistance ) {
		if ( Navigation.GetRange() < targetDistance ) {

//			Drivetrain.DriveToTarget( targetSpeed );
			Stage.StillWorking = true;
			
		} else { Drivetrain.Stop(); }
	}


//	public static void TurnToHeading( double targetHeading, double tolerance ) {
//		if ( Autonomous.WaitForTarget( tolerance ) ) {
//
//			Autonomous.StillWorking = true;
//			
//		} else { Drivetrain.Stop(); LastBearing = targetHeading; }
//	}
	
	
//	public static void TurnToTarget( double tolerance ) {

		// How do we know if the target is in sight since we would
		// never quit adjusting?
		// 1. Check Score, Speed
		
		// 
		
//		if () {
//			Autonomous.StillWorking = true;
//		} else { Drivetrain.Stop(); LastBearing = Navigation.GetHeading(); }
//	}
	
}
