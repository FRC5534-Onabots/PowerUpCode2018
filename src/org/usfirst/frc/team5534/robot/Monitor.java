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
	
	
	public static void Write() {
		if ( pw != null ) {
			// pw.print( (System.currentTimeMillis()-initialTime)/1000.0+" " );
	
			pw.print( Navigation.GetRange()+" " );
			pw.print( Vision.GetTargetX()+" " );
			pw.print( Navigation.GetHeading()+" " );
			pw.print( "\n" );
		}
	}
	
}
