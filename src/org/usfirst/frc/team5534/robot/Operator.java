package org.usfirst.frc.team5534.robot;

import java.util.*;
import edu.wpi.first.wpilibj.Joystick;

public class Operator {

	
	public static Joystick TankStickL;
	public static Joystick TankStickR;

	
	public static int Number = 0;	
	public static String[] Names = {
		"Steensma",
		"Galvez",
		"Madison",
		"Adair"
	};
	


	public static void Init() {
		Navigation.Reset();
	}
	
	
	public static void Periodic() {

		switch(Number) {
		
			case 0:
				DriverSteensma.Periodic();
				break;
		
			default:
				DriverDefault.Periodic();
				break;
		}

	}
		
	
}
