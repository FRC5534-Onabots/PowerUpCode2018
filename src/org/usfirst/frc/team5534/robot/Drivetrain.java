package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Spark;

public class Drivetrain {

	public static Spark DriveMotorLF = new Spark( Ports.PWM_DriveMotor_LF );
	public static Spark DriveMotorLR = new Spark( Ports.PWM_DriveMotor_LR );
	public static Spark DriveMotorRF = new Spark( Ports.PWM_DriveMotor_RF );
	public static Spark DriveMotorRR = new Spark( Ports.PWM_DriveMotor_RR );

	public static double DrivePowerL;
	public static double DrivePowerR;

	public static double PowerD = 0;
	public static double PowerT = 0;
	
	
	public static void DriveByPower( double drivePower, double turnPower ) {
		DrivePowerL = +( drivePower + turnPower );
		DrivePowerR = -( drivePower - turnPower );

		DriveMotorLF.set( DrivePowerL ); DriveMotorLR.set( DrivePowerL );
		DriveMotorRF.set( DrivePowerR ); DriveMotorRR.set( DrivePowerR );
	}


	public static void Stop() {
		PowerD = 0;
		PowerT = 0;
	}

	
	public static void DriveToTarget( double targetSpeed ) {

		double DriveSpeedError = targetSpeed - Navigation.GetDriveSpeed();

		if ( targetSpeed > 0 ) { PowerD = Math.max( PowerD,  0.18 ); }
		if ( targetSpeed < 0 ) { PowerD = Math.min( PowerD, -0.18 ); }

		PowerD = Math.max( PowerD, 0.18 );
		PowerD += DriveSpeedError * 0.0001;

		double NewHeading = Navigation.GetHeading() + Vision.GetTargetX() / 14;
		double NextSpeed  = Navigation.GetDelta( NewHeading ); 

		NextSpeed = Math.min( NextSpeed,  20 );
		NextSpeed = Math.max( NextSpeed, -20 );

		double SpeedError = NextSpeed - Navigation.GetTurnSpeed();

		PowerT += SpeedError * 0.0002;

	}
	
	
	public static void TurnToTarget() {
		
		PowerD = 0;
		
		double CurrentHeading = Navigation.GetHeading();
		
		double NewHeading = CurrentHeading + Vision.GetTargetX() / 14;
		
		TurnToHeading( NewHeading );
		
	}
			
	
	public static void TurnToHeading( double TargetHeading ) {

		Autopilot.LastBearing = TargetHeading;
		
		double NextSpeed = Navigation.GetDelta( TargetHeading );

		NextSpeed = Math.min( NextSpeed,  36 );
		NextSpeed = Math.max( NextSpeed, -36 );

		double SpeedError = NextSpeed - Navigation.GetTurnSpeed();

		if ( NextSpeed < 0 ) { PowerT = Math.min( PowerT, -0.18 ); }
		if ( NextSpeed > 0 ) { PowerT = Math.max( PowerT, +0.18 ); }
		
		PowerD = 0; PowerT += SpeedError*0.0002;

	}

	
	public static void DriveToHeading( double TargetSpeed, double TargetBearing) {

		double DeltaDriveSpeed = TargetSpeed - Navigation.GetDriveSpeed();

		if ( TargetSpeed > 0 ) { PowerD = Math.max( PowerD,  0.18 ); }
		if ( TargetSpeed < 0 ) { PowerD = Math.min( PowerD, -0.18 ); }
	
		if ( DeltaDriveSpeed > 0 ) { PowerD += 0.0005; }
		if ( DeltaDriveSpeed < 0 ) { PowerD -= 0.0005; }

		double DeltaTurnAngle = Navigation.GetDelta( TargetBearing );

		PowerT = DeltaTurnAngle * 0.002;
		
	}


	public static void TurnAtSpeed( double targetSpeed ) {
		
		double delta = targetSpeed - Navigation.GetTurnSpeed();
		
		if ( targetSpeed > 0 ) { PowerT = Math.max( DriveMotorLF.get(),  0.18 ); };
		if ( targetSpeed < 0 ) { PowerT = Math.min( DriveMotorLF.get(), -0.18 ); };

		PowerD = 0; PowerT += delta * 0.0005;

	}

}
