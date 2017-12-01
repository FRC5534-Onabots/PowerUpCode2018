package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Collector {

//	public static DoubleSolenoid GearGrabber = new DoubleSolenoid(
//			Ports.PCM_GearGrabber[0],
//			Ports.PCM_GearGrabber[1]);
//	
//	
//	public static DoubleSolenoid GearLifter = new DoubleSolenoid(
//			Ports.PCM_GearLifter[0],
//			Ports.PCM_GearLifter[1]);
	
	
	public static Value GrabState; // = DoubleSolenoid.Value.kForward;
	public static Value LiftState; // = DoubleSolenoid.Value.kForward;
	
	public static void Init() {
//		Grab();
//		Raise();
	}

	
	public static void Periodic() {
//		GearGrabber.set( GrabState );
//		GearLifter.set( LiftState );
	}

	
	public static void Grab()  { GrabState = DoubleSolenoid.Value.kForward; }
	
	public static void Drop()  { GrabState = DoubleSolenoid.Value.kReverse; }

	public static void Raise() { LiftState = DoubleSolenoid.Value.kForward; }

	public static void Lower() { LiftState = DoubleSolenoid.Value.kForward; }	
	
}
