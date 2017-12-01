package org.usfirst.frc.team5534.robot;

public class Stage {

	public static double  AutonStartTime;
	public static double  AutonFinalTime;

	public static double  StageStartTime;
	public static double  StageStartDistance;
	
	public static int     Number;
	public static boolean StillWorking;
	
	
	public static void Init() {
		Drivetrain.Stop();
		AutonStartTime = System.currentTimeMillis();
		StageStartTime = AutonStartTime;
		Number = 0;
	}

	
	public static void Next() {
		if ( StillWorking == false ) {
			Drivetrain.Stop();
			StageStartDistance = Navigation.GetDistance();
			StageStartTime     = System.currentTimeMillis();
			Number++;
		}
	}
	

	public static void Reset() {
		Drivetrain.Stop();
		StillWorking = false;
	}
	
		
	public static void Last() {
		Climber.Stop();
		Drivetrain.Stop();
		StillWorking = true;
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

	
	public static boolean WaitForForwardDistance( double distance ) {
		if ( GetStageDistance() < distance )
		{ StillWorking = true; return false; }
		else { Drivetrain.Stop(); return true; }
	}
	
	
	public static boolean WaitForReverseDistance( double distance ) {
		if ( GetStageDistance() > -distance )
		{ StillWorking = true; return false; }
		else { Drivetrain.Stop(); return true; }
	}
	
	
	public static boolean WaitForDuration( double duration ) {
		if ( GetStageDuration() < duration )
		{ StillWorking = true; return false; }
		else { return true; }
	}


//	public static boolean WaitForHeading( double targetHeading, double tolerance ) {
//		if ( Math.abs(Navigation.GetDelta(targetHeading)) < tolerance ) { return true; }
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
