//Calculator class

//Necessary libraries
import java.util.*; //For array list
import javax.swing.*; //For gui components
import java.awt.*; //For layout managers
import java.awt.event.*; //For event handling, firing of events

public class Calculator{

	//Define instance variables
	JFrame frame; //The calculator window
	JPanel framePanel; //Content pane of the frame
	JPanel mainPanel; //Where the output and buttons will stay
	JTextArea outPut; //Where the result will show
	JPanel buttonPanel; //Panel for the JButtons
	JButton clear; //Clear button;
	Label result; //Large label that show the result of an operation
	String[] buttonNames = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "/", "0", ".", "=", "x"}; //Contains the label that should show on all the buttons in the appropriate order
	
	public static void main(String[] args) {
		
		Calculator gui = new Calculator();
		gui.go();

	}//end main method

	public void go(){

		Font bigFont = new Font("sanserif", Font.BOLD, 100); //Create font to be used by components

		GridLayout grid = new GridLayout(4, 4); //Grid layout for buttons
		grid.setVgap(1); //Set the vertical gap between the buttons
		grid.setHgap(2); //Set the horizonatal gap between the buttons
		buttonPanel = new JPanel(grid); //Set the layout manager for the button panel to grid layout

		for(int i = 0; i < buttonNames.length; i++){ //Loop to create the 10 buttons

			JButton button = new JButton(buttonNames[i]);
			buttonPanel.add(button);
			//System.out.println("button added" + buttonNames[i]);       //Test for button creation

		}//Close for loop

		clear = new JButton("Clear"); //Instantiated the clear button so I can add it to the main panel

		BorderLayout layout = new BorderLayout(); //Layout manager for the main panel
		mainPanel = new JPanel(layout); //Instantiated main panel and added the new layout manager

		mainPanel.add(BorderLayout.CENTER, buttonPanel); //Adds the button panel to the center of the mainpanel
		mainPanel.add(BorderLayout.SOUTH, clear); //Adds the clear button to the south of the mainpanel

		outPut = new JTextArea(1, 20); //Makes the ouput area
		outPut.setEditable(false); //Disallows users from entering values directly into result

		result = new Label("0", result.RIGHT);//Set the initial text of label to 0 and align right
		result.setFont(bigFont);//Set the font of result to big font

		framePanel = new JPanel(); //instantiate the frame panel
		framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));//Set the layout manager for the frame panel

		framePanel.add(outPut); //Add the result screen to the frame panel
		framePanel.add(result);
		framePanel.add(mainPanel); //Add the main panel to the frame panel

		frame = new JFrame("Calculator"); //Instantiated the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set the JFrame close operation
		frame.setContentPane(framePanel); //Set the content pane of the JFrame

		frame.setSize(300, 500); ///Set the size
		frame.setVisible(true); //Made visible

	}//end go method



}//end calculator class