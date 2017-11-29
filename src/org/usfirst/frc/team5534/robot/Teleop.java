package org.usfirst.frc.team5534.robot;

public class Teleop {


	public static void Init() {
		Navigation.Reset();
	}
	
	
	public static void Periodic() {

		

//		Drivetrain.PowerD = Pilot.GetThrust();
//		Drivetrain.PowerT = Pilot.GetTurn();
//		
//		if ( Pilot.GetButton( Button.Climber )) {
//			Climber.Ascend();
//		}
//		else {
//			Climber.Stop();
//		}
//		
//		
//		// ===
//		
//		
//		if ( Pilot.Xbox.getTriggerAxis( Hand.kLeft ) != 0 ) {
//			GearCollector.Lower();
//		}
//		else {
//			GearCollector.Raise();
//		}
//		
//		
//		if ( Pilot.Xbox.getTriggerAxis( Hand.kRight ) != 0 ) {
//			GearCollector.Drop();
//		}
//		else {
//			GearCollector.Grab();
//		}
		
		
		if ( Pilot.GetButton(1) ) {
			Navigation.Initialize();
			Autopilot.LastBearing = 0;
			Autonomous.StageNumber = 0;
			Drivetrain.PowerD = 0;
			Drivetrain.PowerT = 0;
		}

		else if ( Pilot.GetButton(2) ) {
			Drivetrain.TurnToHeading( 60 );
		}

		else if ( Pilot.GetButton(3) ) {
			Drivetrain.DriveToHeading( 24, 0 );
		}

		else if ( Pilot.GetButton(4) ) {
			Drivetrain.TurnToTarget();
		}

		else if ( Pilot.GetButton(5) ) {
			Autonomous.StillWorking = false;
			Station.Testing();
			if ( Autonomous.StillWorking == false ) { Autonomous.NextStage(); }
		}
		
		else if ( Pilot.GetButton(6) ) {
			if ( Navigation.GetRange() > 16 ) {
				Drivetrain.DriveToTarget( 20 );
			}
			else {
				Drivetrain.Stop();
			}
		}
		

		else {
			Climber.Stop();
			Drivetrain.PowerD = Pilot.GetThrust();
			Drivetrain.PowerT = Pilot.GetTurn();
		}

	}
		
	
}
