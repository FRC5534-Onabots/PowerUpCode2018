package org.usfirst.frc.team5534.robot;

public class Pilot {

	public static double LastD;
	public static double LastT;

	public static double Bearing;
	
	public static void DriveToTarget( double targetSpeed ) {

		double DriveSpeedError = targetSpeed - Navigation.GetDriveSpeed();

		if ( targetSpeed > 0 ) { LastD = Math.max( LastD,  0.18 ); }
		if ( targetSpeed < 0 ) { LastD = Math.min( LastD, -0.18 ); }

		LastD = Math.max( LastD, 0.18 );
		LastD += DriveSpeedError * 0.0001;

		double NewHeading = Navigation.GetHeading() + Vision.GetTargetX() / 14;
		double NextSpeed  = Navigation.GetDelta( NewHeading ); 

		NextSpeed = Math.min( NextSpeed,  20 );
		NextSpeed = Math.max( NextSpeed, -20 );

		double SpeedError = NextSpeed - Navigation.GetTurnSpeed();

		LastT += SpeedError * 0.0002;
		
		Drivetrain.DriveByArcade( LastD, LastT );

	}
	
	
	public static void TurnToTarget() {
		
		double CurrentHeading = Navigation.GetHeading();
		
		double NewHeading = CurrentHeading + Vision.GetTargetX() / 14;
		
		TurnToHeading( NewHeading );
		
	}
			
	
	public static void TurnToHeading( double TargetHeading ) {

		Bearing = TargetHeading;
		
		double NextSpeed = Navigation.GetDelta( TargetHeading );

		NextSpeed = Math.min( NextSpeed,  36 );
		NextSpeed = Math.max( NextSpeed, -36 );

		double SpeedError = NextSpeed - Navigation.GetTurnSpeed();

		if ( NextSpeed < 0 ) { LastT = Math.min( LastT, -0.18 ); }
		if ( NextSpeed > 0 ) { LastT = Math.max( LastT, +0.18 ); }
		
		LastT += SpeedError * 0.0002;
		
		Drivetrain.DriveByArcade( 0.00,  LastT );

	}

	
	public static void DriveToHeading( double TargetSpeed, double TargetBearing) {

		double DeltaDriveSpeed = TargetSpeed - Navigation.GetDriveSpeed();

		if ( TargetSpeed > 0 ) { LastD = Math.max( LastD,  0.18 ); }
		if ( TargetSpeed < 0 ) { LastD = Math.min( LastD, -0.18 ); }
	
		if ( DeltaDriveSpeed > 0 ) { LastD += 0.0005; }
		if ( DeltaDriveSpeed < 0 ) { LastD -= 0.0005; }

		double DeltaTurnAngle = Navigation.GetDelta( TargetBearing );

		LastT = DeltaTurnAngle * 0.002;
		
		Drivetrain.DriveByArcade( LastD, LastT );
		
	}


	public static void TurnAtSpeed( double targetSpeed ) {
		
		double delta = targetSpeed - Navigation.GetTurnSpeed();
		
		if ( targetSpeed > 0 ) { LastT = Math.max( LastT,  0.18 ); };
		if ( targetSpeed < 0 ) { LastT = Math.min( LastT, -0.18 ); };

		LastT += delta * 0.0005;
		
		Drivetrain.DriveByArcade( 0.00,  LastT );

	}
	
}

