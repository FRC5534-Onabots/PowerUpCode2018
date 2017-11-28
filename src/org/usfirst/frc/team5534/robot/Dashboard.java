package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

	// The dashboard package communicates with the SmartDashboard on the Driver Station.
	// An alternative would by to run a Python script on the DriverStation that communicates
	// with the robot using NetworkTables.
	
    public static NetworkTable DashboardNetworkTable = NetworkTable.getTable("Dashboard");


	public static void Double( String key, double value ) {
		SmartDashboard.putNumber( key, value );
		DashboardNetworkTable.putNumber( key, value );
	}
	

	public static void Update() {

		// MOTOR POWER
		Double("L Power",  Drivetrain.DrivePowerL     );
		Double("R Power",  Drivetrain.DrivePowerR     );

		// MOTOR SPEED
		Double("Thurst",   Navigation.GetDriveSpeed() );
		Double("Speed",    Navigation.GetDriveSpeed() );
		Double("Distance", Navigation.GetDistance()   );

		double testing = DashboardNetworkTable.getNumber("Testing");
		Double("Testing", testing );
		
		// GYROSCOPE
		Double("Heading",  Navigation.GetHeading()    );

		// SONAR
		Double("Ranger",   Navigation.GetRange()      );
				
		// VISION
		Double("Score",    Vision.GetTargetScore()    );
		Double("X",        Vision.GetTargetX()        );
		Double("Y",        Vision.GetTargetY()        );	    

	}
	
}
