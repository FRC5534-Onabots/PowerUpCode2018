package org.usfirst.frc.team5534.robot;

public class Station {

	
	public static void LeftStation() {
		
	}
	
	
	public static void CenterStation() {
		
	}
	
	
	public static void RightStation() {
		
	}
	
	
	public static void CrossBaseline() {
		
	}
	
	
	public static void DoNothing() {
		
	}
	 
	
	public static void Testing() {
		switch (Autonomous.StageNumber) {

			case 0:
				Navigation.Reset();
				break;
		
			case 1:
				Autopilot.DriveForwardToDistance(20, 18*12);
				break;

			case 2:
				Drivetrain.TurnToHeading( 90 );
				break;
				
			default:
				Autonomous.LastStage();
				break;
		}
				
	}
	 
}
