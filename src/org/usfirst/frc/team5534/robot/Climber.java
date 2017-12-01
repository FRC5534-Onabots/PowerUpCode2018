package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Spark;

public class Climber {

	public static Spark ClimbMotor = new Spark( Ports.PWM_ClimbMotor );

	
	public static double Power = 0;

	
	public static void Init() {
		Power = 0;
	}
	
	
	public static void Periodic() {
		ClimbMotor.set( Power );
	}

		
	public static void Ascend() {
		Power = Preferences.ClimbSpeed;
	}
	
	
	public static void Stop() {
		Power = 0;
	}

}
