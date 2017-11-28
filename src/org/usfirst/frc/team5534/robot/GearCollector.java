package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class GearCollector {

	public static DoubleSolenoid GearGrabber = new DoubleSolenoid(
			Ports.PCM_GearGrabber[0],
			Ports.PCM_GearGrabber[1]);
	
	
	public static DoubleSolenoid GearLifter = new DoubleSolenoid(
			Ports.PCM_GearLifter[0],
			Ports.PCM_GearLifter[1]);
	
	
	public static void Grab() { GearGrabber.set( DoubleSolenoid.Value.kForward ); }

	
	public static void Drop() { GearGrabber.set( DoubleSolenoid.Value.kReverse ); }

	
	public static void Raise() { GearLifter.set( DoubleSolenoid.Value.kForward ); }

	
	public static void Lower() { GearLifter.set( DoubleSolenoid.Value.kForward ); }	
	
}
