package org.usfirst.frc.team5534.robot;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Monitor {

	
	public static PrintWriter pw          = null;
	public static File        file        = new File("/home/lvuser/data.txt");
	public static long        initialTime = 0;


	public static void Open() {
		file.delete();
		initialTime = System.currentTimeMillis();
		try { pw = new PrintWriter( file ); } catch (IOException ioe) {}
	}


	public static void Close() {
		if ( pw != null ) {	
			pw.close();
			pw = null;
		}
	}
	
	// TM	time
	// LM	left motor power
	// RM	right motor power
	// RF	range finder
	// B1	button 1
	// B2	button 2
	// B3	button 3
	// B4	button 4
	// B5	button 5
	// B6	button 6
	// JY	thrust
	// JT	twist
	// JX	turn
	// TH	throttle
	// CM	climb power
	// RE	right encoder
	// GH	gyroscope heading
	// TX	target x
	// TS	target score
	
	public static void Write() {
		if ( pw != null ) {
			pw.print( (System.currentTimeMillis()-initialTime)/1000.0+" " );

			pw.print( Navigation.GetRange()+" " );
			pw.print( Vision.GetTargetX()+" " );
			pw.print( Navigation.GetHeading()+" " );
			pw.print( "\n" );
		}
	}
	
}
