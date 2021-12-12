import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class calculateTheDive {
	
	private int diveDepth;
	private int diveAmount;
    private int diveTime;
    private char beginningPressure;
    private char endPressure;
    private int[] changedTimesArray;
    private int[] timesArray;
    
    private int leftNitroTime;
    private boolean decompressionLimit;
    private String decompressWarning = "The decompression limit has been reached!";
    private boolean safety;
    private String safetyWarning = "Safety stop required!";
    private int surfaceTime;
    String depthInstructions;
    String timeIntstruction;

    // getting data from other classes
    calculateTheDive(int diveAmount){
        this.diveAmount = diveAmount;
        safety = false;
        decompressionLimit = false;
        this.surfaceTime = -1;
    }
    
    // getting data from other classes
    calculateTheDive(char startingPressureGroup, int diveAmount){
        this.beginningPressure = startingPressureGroup;
        this.diveAmount = diveAmount;
        this.safety = false;
        this.decompressionLimit = false;
        this.surfaceTime = -1;
    }

    // returns our pressure
    public char endPressure(){
        return endPressure;
    }

    // returns out surfaceTime
    public int SurfaceTime(){
        return this.surfaceTime;
    }

    // returns our decompression limit
    public boolean decompressionLimit(){
        return decompressionLimit;
    }
    
    // calling all functions in this class
    public void startCalculationTheDive(){
    	
        Depth();
        depthTimeArray();
        DiveTime();
        PressureCalculation();
        divingLimitCheck();
        
    }
    
    // ask for planned depth of dive 
    private void Depth(){
    	
        String depth = JOptionPane.showInputDialog("How deep would you like to go in feet for dive #" + this.diveAmount + ": ");
        this.diveDepth = input.inputChecker(depth,1, 140);
    }

    
    private void depthTimeArray(){
    	
        int roundedDepth = tableForDepth.roundedDepth(this.diveDepth);
        int[] depthTime = tableForDepth.currentDepthime(roundedDepth);
        
        // if our pressure isnt 0 
        if(beginningPressure != 0){
        	// calculate the left nitrogen
            this.leftNitroTime = tableForDepth.nitroTime(beginningPressure, depthTime);
            // then change our array position
            this.changedTimesArray = tableForDepth.depthTimeWithoutNitro(this.leftNitroTime, depthTime);
            
        }
        this.timesArray = depthTime;
    }

    // asking for how long the dive will last 
    private void DiveTime(){
    	String question = "How long will this dive be: ";
    	String diveLength = JOptionPane.showInputDialog("How long will this dive be: ");
    	
    	
        if(beginningPressure != 0) {
        	question += " (Up to " + changedTimesArray[changedTimesArray.length - 1] + ")";
            this.diveTime = input.inputChecker(diveLength, 1, changedTimesArray[changedTimesArray.length-1]);


        }else {
        	question += " (Up to " + timesArray[timesArray.length - 1] + ")";
            this.diveTime = input.inputChecker(diveLength, 1, timesArray[timesArray.length - 1]);
        }
    }

    // calculates the pressure based off the time and left over nitrogen 
    private void PressureCalculation(){
    	// add the t2 variables together 
        int nitroTime = this.diveTime + this.leftNitroTime;
        // round them to a number on the RDL
        int diveTimerounded = tableForDepth.roundTheTime(nitroTime, this.timesArray);
        this.endPressure = tableForDepth.currentPressure(diveTimerounded, this.timesArray);
        
    }

    // checking to see if diving to certain depth is safe
    private void divingLimitCheck(){
    	
        if (this.diveDepth > 90){
        	
            this.safety = true;
            JOptionPane.showMessageDialog(null, this.safetyWarning);
            
        }else if(this.diveTime > timesArray[timesArray.length - 5]){
        	
            this.safety = true;
            JOptionPane.showMessageDialog(null, this.decompressWarning);
            
        }
        
        // checking out decompression safety
        if(this.diveTime > timesArray[timesArray.length-2]){
        	
            decompressionLimit = true;
            JOptionPane.showMessageDialog(null, this.decompressWarning);
        }
        
    }

    // getting our surface time input 
    public void surfaceTime(){
    	
        String surfaceTime = JOptionPane.showInputDialog( "How long will you be on the surface before your next dive: ");
        this.surfaceTime = input.inputChecker(surfaceTime, 0, 900);
        
    }

    
    
    @Override
    public String toString(){
    	
    	// creates our out put to the user
        String results = "\t\tDive Number " + this.diveAmount +"\n";
        results +="Dive Depth: " + this.diveDepth + " feet.\n";
        results += "Time at depth: " + this.diveTime + " minutes\n";
        
        
        // determining the beginning pressure 
        if(this.beginningPressure != 0) {
            results += "Starting pressure group: " + beginningPressure + "     \n";
        }else{
            results += "Starting pressure group = n/a \n";
        }
        
        //
        results += "Ending pressure group: " + this.endPressure + "      \n";

        
        if(safety){
            results += "\n" + safetyWarning +"\t\t";
        }
        
        // adds our decompression if there
        if(decompressionLimit){
            results += decompressWarning;
        }
        
        
        if(this.surfaceTime != -1){
            results += "\nSurface Time before next dive: " + this.surfaceTime + " minutes  \n";
        }
        
        
        // adding out max depth message if the dive amount is 2 or 3
        if(diveAmount == 2 || diveAmount == 3 || diveAmount == 4) {
        	
        	// for a - h
        	if (
        			this.endPressure == 'A' || this.endPressure == 'B' || this.endPressure == 'C'|| 
        			this.endPressure == 'E' || this.endPressure == 'F' || this.endPressure == 'G'|| 
        			this.endPressure == 'H'
        		) 
        	{
       		 results += "Max depth is 130";
        	}
        	
        	// for I - K
        	else if (this.endPressure == 'I' || this.endPressure == 'J' || this.endPressure == 'K' ) 
        	{
       		 results += "Max depth is 120";
        	}
        	// for L and M
        	else if (this.endPressure == 'L' || this.endPressure == 'M') 
        	{
       		 results += "Max depth is 110";
        	}
        	// for N and O
        	else if (this.endPressure == 'N' || this.endPressure == 'O') 
        	{
       		 results += "Max depth is 100";
        	}
        	// for P and Q
        	else if (this.endPressure == 'P' || this.endPressure == 'Q') 
        	{
       		 results += "Max depth is 90";
        	}
        	// for R
        	else if (this.endPressure == 'R') {
       		 results += "Max depth is 80";
        	}
        	// for S and T
        	else if (this.endPressure == 'S' || this.endPressure == 'T') 
        	{
       		 results += "Max depth is 60";
        	}	
        	// for P and Q
	    	else if (this.endPressure == 'P' || this.endPressure == 'Q') 
	    	{
	   		 results += "Max depth is 90";
	    	}
	    	// for R
	    	else if (this.endPressure == 'R') {
	   		 results += "Max depth is 80";
	    	}
	    	// for S and T
	    	else if (this.endPressure == 'S' || this.endPressure == 'T') 
	    	{
	   		 results += "Max depth is 70";
	    	}
	    	// for U - W
	    	else if (this.endPressure == 'U' || this.endPressure == 'V' || this.endPressure == 'W')
	    	{
	   		 results += "Max depth is 60";
	    	}
	    	// for X
	    	else if (this.endPressure == 'X') 
	    	{
	   		 results += "Max depth is 50";
	    	}
	    	// for Y and Z
	    	else if (this.endPressure == 'Y' || this.endPressure == 'Z')
	    	{
	   		 results += "Max depth is 40";
	    	}
	        	
        }	
        
        
     // create a JFrame
        JFrame frame = new JFrame();

        // this packs all of our information into the pane to be then called in main 
        JOptionPane.showMessageDialog(frame,
            results,
            // our title
            "Diving Results",
            JOptionPane.INFORMATION_MESSAGE);
    	
        
        return results;
       

    }

}
