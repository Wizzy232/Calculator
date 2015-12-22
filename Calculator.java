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
	JPanel mainPane; //Where the output and buttons will stay
	JTextArea outPut; //Where the result will show
	JPanel buttonPanel; //Panel for the JButtons
	JButton clear; //Clear button;
	String[] buttonNames = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; //Contains the label that should show on all the number buttons
	String[] operationNames = {"+", "-", "/", "x"};//Contains the label that should show on all the operation buttons


	public static void main(String[] args) {
		
		Calculator gui = new Calculator();
		gui.go();

	}//end main method

	public void go(){

		GridLayout grid = new GridLayout(4, 4); //Grid layout for buttons
		grid.setVgap(1); //Set the vertical gap between the buttons
		grid.setHgap(2); //Set the horizonatal gap between the buttons
		buttonPanel = new JPanel(grid); //Set the layout manager for the button panel to grid layout

		for(int i = 0; i < buttonNames.length; i++){ //Loop to create the 10 buttons

			JButton button = new JButton(buttonNames[i]);
			buttonPanel.add(button);

		}//Close for loop

	}//end go method



}//end calculator class