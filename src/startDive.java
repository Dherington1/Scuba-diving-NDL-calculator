import java.util.ArrayList;
import javax.swing.*;

public class startDive {	
 
	// variables
    private int numberOfDives;
    private ArrayList<calculateTheDive> amountOfDives;
    private boolean limitOfDecompression;

   // sets our decompression boolean to false 
    public startDive() {
        this.limitOfDecompression = false;
        
    }
   
   
    // calls functions in the class 
    public void diveDuration () {
    	
    	howManyDives();
    	startingDive();
    	
    }
    

    
	// function for how many dives
    private void howManyDives(){
    	
    	// our input from user is saved in instruction
    	String dives = JOptionPane.showInputDialog("How many dives do you want to track? ");
    	// runs our input through input class to make sure it is a correct input 
    	// then saves it into this classes number of dives variable 
        this.numberOfDives = input.inputChecker(dives, 1, 4);
        
      
    }

    
    // create the dive situation
    private void startingDive(){
    	
        amountOfDives = new ArrayList<calculateTheDive>();
        char beginningPressure = 0;
        
        // to go through out number of dives given by user
        for(int i = 1 ; i < numberOfDives ; i++) {
        	// create new integration of the dive class
            calculateTheDive newDive = new calculateTheDive(beginningPressure, i);
            // call all functions in the dive class
            newDive.startCalculationTheDive();
            newDive.surfaceTime();
           
            // putting our getSurfaceInterval results into timeOnSurface
            int timeOnSurface = newDive.SurfaceTime();
            // using our previous initiated variable to run through the fullConversion function
            char pressure = surfaceTime.fullConversion(newDive.endPressure(), timeOnSurface);
            beginningPressure = pressure;
            this.limitOfDecompression = newDive.decompressionLimit();
            // adding to dives
            amountOfDives.add(newDive);
            
            // if decompression is reached stop
            if (limitOfDecompression) {
                return;
            }
        }
        	// running our previous results through the calculate the dive to give class those values 
            calculateTheDive perviousDive = new calculateTheDive(beginningPressure, amountOfDives.size() + 1);
            perviousDive.startCalculationTheDive();
            amountOfDives.add(perviousDive);
            
    }
    
    
    @Override
    public String toString(){
    	
    	// this creates a string that we print back to the user at the end 
        String results = "\t\t\t number of dives: " + numberOfDives + "\n";
        for (calculateTheDive dive : amountOfDives){
            results += dive.toString() + "\n";
        }
        
        return results;
    }

	
}









