package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Spark;

public class Climber {

	public static Spark ClimbMotor = new Spark( Ports.PWM_ClimbMotor );

	
	public static void Ascend() {
		ClimbMotor.set( Preferences.ClimbSpeed );
	}
	
	
	public static void Stop() {
		ClimbMotor.set( 0.00 );
	}

}
