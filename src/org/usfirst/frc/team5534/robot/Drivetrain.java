package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Spark;

public class Drivetrain {

	public static Spark MotorLF = new Spark( Ports.PWM_DriveMotor_LF );
	public static Spark MotorLR = new Spark( Ports.PWM_DriveMotor_LR );
	public static Spark MotorRF = new Spark( Ports.PWM_DriveMotor_RF );
	public static Spark MotorRR = new Spark( Ports.PWM_DriveMotor_RR );

	public static double PowerL = 0;
	public static double PowerR = 0;

	public static double PowerD = 0;
	public static double PowerT = 0;
	
	public static double LastD = 0;
	public static double LastT = 0;
	
	
	public static void Init() {
		MotorRF.setInverted( true );
		MotorRR.setInverted( true );
		
		PowerL = 0; PowerR = 0;
		PowerD = 0; PowerT = 0;
	}
	
	
	public static void Periodic() {
		Autopilot.ResetHeading( Navigation.GetHeading() );
		
		MotorLF.set( PowerL ); MotorLR.set( PowerL );
		MotorRF.set( PowerR ); MotorRR.set( PowerR );		
	}
	
	
	public static void DriveByArcade( double D, double T ) {
		PowerL = D + T;
		PowerR = D - T;

	}

	
	public static void DriveByTank( double L, double R ) {
		PowerL = L;
		PowerR = R;
	}

	
	public static void Stop() {
		PowerD = 0; LastD = 0;
		PowerT = 0; LastT = 0;
	}

}
