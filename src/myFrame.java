import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class myFrame extends JFrame implements ActionListener {

	
	 //setting labels
    public JLabel numberOfDives = new JLabel("HOW MANY DIVES: ");
    public JLabel depthOfDive = new JLabel("DEPTH OF DIVE:    ");
    private JLabel timeEstimate = new JLabel("DIVE TIME ESTIMATE: ");
    
    // box for amount of dives
    private JTextField dives = new JTextField(10);
    
    // box for depth of dive 
    private JTextField depth = new JTextField(10);
    
    // box for time of dive
    private JTextField time = new JTextField(10);

    // Types of areas on display
    private JTextField number1 = new JTextField();
    private JTextField depth1 = new JTextField();
    private JTextField time1 = new JTextField();
    
    //button to calculate and result
    private JButton jbtnCalculate = new JButton("CALCULATE PRESSURE GROUP");
    
    
    //button for total rent
    private JLabel result1 = new JLabel("CURRENT PRESSURE GROUP: ");
    
    //panel setting with the corresponding variables
    private JPanel jpnlnumber = new JPanel();
    private JPanel jpnldepth = new JPanel();
    private JPanel jpnltime = new JPanel();
    private JPanel jpnlButton1 = new JPanel();
    private JPanel jpnlLabel1 = new JPanel();
    private JPanel Panel1 = new JPanel();
    



	myFrame() {
		
	
        super("Diving Logs");
        
        //adding frames for the variables
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	this.setLayout(null);
        this.setSize(450,350);
        this.setVisible(true);
 
        
        number1.add(dives);
        // connecting inputs of depth input field 
        depth1.add(depth);
        // connecting inputs of time input field
        time1.add(time);
       

        
        // adding all to the panel
        // number of dives
        jpnlnumber.add(numberOfDives);
        jpnlnumber.add(dives);
        
        //depth
        jpnldepth.add(depthOfDive);
        jpnldepth.add(depth);
        //time
        jpnltime.add(timeEstimate);
        jpnltime.add(time);
        //calculate button
        jpnlButton1.add(jbtnCalculate);
        //showing results
        jpnlLabel1.add(result1);

        
        Panel1.add(jpnlnumber);
        Panel1.add(jpnldepth);
        Panel1.add(jpnltime);
        Panel1.add(jpnlButton1);
        Panel1.add(jpnlLabel1);

        //adding panel
        add(Panel1);

        jbtnCalculate.addActionListener(this);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbtnCalculate) {
			System.out.println("hello");
			
			
			
			
			// text box inputs 
			String inputDivesString = dives.getText();
			String inputOfDepth = depth.getText();
   			String inputTimeString = time.getText();
   			
   			System.out.println(inputDivesString);
   			System.out.println(inputOfDepth);
   			System.out.println(inputTimeString);
   			
   			// change to integer
   			Integer inputDivesInteger = Integer.valueOf(inputDivesString);
   			System.out.println("3/4");
			//create new instance of the start dive class
			startDive newDive = new startDive(inputDivesInteger);
			System.out.println("3/6");
			// call all functions in the dive class
			newDive.diveDuration();
			System.out.println("3/8");
			
			
			// create new instance of the calculate the dive class
			calculateTheDive dive = new calculateTheDive(inputOfDepth, inputTimeString);
			dive.fullSetup();
			
			System.out.println("3/4");
			System.out.println(newDive);
			System.out.println("end");
		}
	}

}
