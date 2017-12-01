package org.usfirst.frc.team5534.robot;

public class Autonomous {
	
	
	public static void Init() {
		Chooser.GetSelected();
		Stage.Init();
	}
	
	
	public static void Periodic() {
		Stage.Reset();

        switch (Chooser.autonSelected) {
        
	        case Chooser.autonLeftStation:
	            Station.LeftStation();
	            break;

	        case Chooser.autonCenterStation:
	            Station.CenterStation();
	            break;
	
	        case Chooser.autonRightStation:
	            Station.RightStation();
	            break;
	
	        case Chooser.autonCrossBaseline:
	            Station.CrossBaseline();
	            break;
	
	        case Chooser.autonTesting:
	        	Station.Testing();
	        	break;
	
	        default:
	            break;
			
		}

		Stage.Next();

	}
		
}
