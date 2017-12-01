package org.usfirst.frc.team5534.robot;

// Hello Andrea

public class Autonomous {
	
	public static double  AutonStartTime;
	public static double  StageStartTime;
	public static double  AutonFinalTime;
	
	public static double  AutonStartDistance;
	public static double  StageStartDistance;
	
	public static int     StageNumber;
	public static boolean StillWorking;
		
	// ===

	public static void Init() {
		AutonStartTime = System.currentTimeMillis();
		StageStartTime = AutonStartTime;
		Navigation.Reset();
		StageNumber = 0;
	}

	public static void LastStage() {
		Drivetrain.Stop();
		StillWorking = true;
	}
	
	// ===
	
	public static void Periodic() {
		StillWorking = false;

        switch (Chooser.autonSelected) {
        
	        case Chooser.autonLeftStation:
	            Station.LeftStation();
	            break;

	        case Chooser.autonCenterStation:
	            Station.CenterStation();
	            break;
	
	        case Chooser.autonRightStation:
	            Station.RightStation();
	            break;
	
	        case Chooser.autonCrossBaseline:
	            Station.CrossBaseline();
	            break;
	
	        case Chooser.autonTesting:
	        	Station.Testing();
	        	break;
	
	        default:
	            break;
			
		}

		if ( StillWorking == false ) { NextStage(); }

	}
	
	// ===

	public static void NextStage() {

		// DRIVE POWER
		Drivetrain.PowerD = 0;
		Drivetrain.PowerT = 0;

		// RESET STAGE DISTANCE AND TIME
		StageStartDistance = Navigation.GetDistance();
		StageStartTime     = System.currentTimeMillis();
		
		// NEXT STAGE
		StageNumber++;
	}
	
	
	public static double GetAutonDuration() {
		return ( System.currentTimeMillis() - AutonStartTime )/1000.0;
	}


	public static double GetStageDuration() {
		return ( System.currentTimeMillis() - StageStartTime )/1000.0;
	}
	

	public static double GetStageDistance() {
		return Navigation.GetDistance() - StageStartDistance;
	}

	// ===
	
	public static void WaitForDistance( double distance ) {
		if ( GetStageDistance() < distance ) { StillWorking = true; }
	}
	
	
	public static void WaitForDuration( double duration ) {
		if ( GetStageDuration() < duration ) { StillWorking = true; }
	}

	
//	public static boolean WaitForHeading( double tolerance ) {
//		if ( Drivetrain.TargetMin<-tolerance || Drivetrain.TargetMax>tolerance ) {
//			StillWorking = true;
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	
//
//	public static boolean WaitForTarget( double tolerance ) {
//		if ( Drivetrain.TargetMin<-tolerance || Drivetrain.TargetMax>tolerance ) {
//			StillWorking = true;
//			return true;
//		}
//		else {
//			return false;
//		}
//	
//	}
	
}
