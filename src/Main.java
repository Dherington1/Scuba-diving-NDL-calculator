//import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import com.sun.jdi.event.ThreadDeathEvent;

public class Main {
	
	
	public static void main(String[] args)  {

	// calls the starting program
       diverStater();
			
	}
	
	
	public static void diverStater()  {
		
		// starts the whole program 
		startDive dive = new startDive();
		dive.diveDuration();
		
		// this calls our results in the console
        System.out.println(dive.toString());

	}

}


