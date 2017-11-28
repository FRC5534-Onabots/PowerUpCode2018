package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class Chooser {

	public static final String autonDoNothing     = "Do Nothing";
	public static final String autonLeftStation   = "Left Station";
	public static final String autonCenterStation = "Center Station";
	public static final String autonRightStation  = "Right Station";
	public static final String autonCrossBaseline = "Cross Baseline";
	public static final String autonTesting       = "Testing";

	public static String autonSelected = autonTesting;


	public static AnalogInput autonChooser = new AnalogInput(
		Ports.AIO_AutonPotent );

    public static void GetSelected() {
    	
    	double voltage = autonChooser.getVoltage() / 5.00 * 100;
    	
    	if ( voltage < 10 ) { autonSelected = autonDoNothing;    }
    	
    	else if ( voltage < 30 ) { autonSelected = autonLeftStation;   }
    	
    	else if ( voltage < 50 ) { autonSelected = autonCenterStation; }
    	
    	else if ( voltage < 70 ) { autonSelected = autonRightStation;  }
    	
    	else if ( voltage < 90 ) { autonSelected = autonCrossBaseline; }
    	
    	else { autonSelected = autonTesting; }
    	
    	SmartDashboard.putNumber("VOLTAGE",  autonChooser.getVoltage() );
    	
    }
    
}
