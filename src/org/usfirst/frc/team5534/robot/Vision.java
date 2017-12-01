package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.cscore.UsbCamera;

public class Vision {

    public static UsbCamera PilotCamera;

    public static void Init() {
	    PilotCamera = CameraServer.getInstance().startAutomaticCapture();
	    PilotCamera.setFPS(30);
    }

    
    public static void Periodic() {
    	
    }
   
    
    public static double TargetScore;
    public static double TargetX;
    public static double TargetY;


    public static NetworkTable VisionNetworkTable = NetworkTable.getTable("Vision");


    public static double GetTargetScore() {
    	return VisionNetworkTable.getNumber("Score", 0 );
    }
    
    
    public static double GetTargetX() {
    	return VisionNetworkTable.getNumber("X", 0 ) - Preferences.CameraCenterX;
    }
    
    
    public static double GetTargetY() {
    	return VisionNetworkTable.getNumber("Y", 0 ) - Preferences.CameraCenterY;
    }
    
}
