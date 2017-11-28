package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	@Override
	public void robotInit() {
		Vision.Initialize();
	}

	@Override
	public void robotPeriodic()      {
		Drivetrain.DriveByPower( Drivetrain.PowerD, Drivetrain.PowerT );
		Dashboard.Update();
		Monitor.Write();
	}


	@Override
	public void disabledInit()       {
		Monitor.Close();
	}

	@Override
	public void disabledPeriodic()   {}


	@Override
	public void autonomousInit()     {
		Autonomous.Init();
	}
	
	@Override
	public void autonomousPeriodic() { Autonomous.Periodic(); }


	@Override
	public void teleopInit()         {
		Teleop.Init();
		Monitor.Open();
	}

	@Override
	public void teleopPeriodic()     { Teleop.Periodic();     }
	
	
	@Override
	public void testInit()           {}
	
	@Override
	public void testPeriodic()       {}
	
}
