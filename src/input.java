import javax.swing.*;

public class input {
    
	
    public static int inputChecker(String input, int min, int max) {
       
       System.out.println(input); 
       // turn our string into an integer
       int userInput = Integer.parseInt(input);
            
       		// check to see if it is in the correct range
            if (userInput >= min && userInput <= max) {
 
            } else {
            	// if not then tell user 
            	JOptionPane.showMessageDialog(null, "Please input no more than 4 dives");
                System.out.println("more than 4 dives");
            }

        return userInput;
    }
    
}