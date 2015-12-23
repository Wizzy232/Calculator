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
	String message = ""; //contains the text to display to the user when the user clicks a button
	String digit = ""; //Contains each number just before the operator is clicked
	double number; //Contains the number the digit is transformed to after an operator is clicked on
	double total; //Contains the result to be displayed as final answer
	ArrayList<Double> numbers = new ArrayList<Double>(); //Contains the numbers the user has clicked on
	ArrayList<Integer> operators = new ArrayList<Integer>(); //Contains all the operation that should be performed on the number
	final int ADDITION = 1; //Int code for addition
	final int SUBTRACTION = 2; //Int code for subtraction
	final int DIVISION = 3; //Int code for division
	final int MULTIPLICATION = 4; //Int code for multiplication
	final int EQAULS = 5; //Int code for equals to

	
	public static void main(String[] args) {
		
		Calculator gui = new Calculator();
		gui.go();

	}//end main method

	public void go(){

		Font bigFont = new Font("sanserif", Font.BOLD, 50); //Create font to be used by components

		GridLayout grid = new GridLayout(4, 4); //Grid layout for buttons
		grid.setVgap(1); //Set the vertical gap bemtween the buttons
		grid.setHgap(2); //Set the horizonatal gap between the buttons
		buttonPanel = new JPanel(grid); //Set the layout manager for the button panel to grid layout

		for(int i = 0; i < buttonNames.length; i++){ //Loop to create the 10 buttons

			JButton button = new JButton(buttonNames[i]);//Creates new buttons with the names in the button names array
			button.setBackground(new Color(255, 255, 255));//Set the background color of the buttons to white
			setListener(button, buttonNames[i]); //Set the action listener based on the type of button
			buttonPanel.add(button);//Add the buttons to be button panel which has a grid layout gui
			//System.out.println("button added" + buttonNames[i]);       //Test for button creation

		}//Close for loop

		clear = new JButton("Clear"); //Instantiated the clear button so I can add it to the main panel
		clear.setBackground(new Color(255, 255, 255)); //Sets the background color of the clear button to white
		clear.addActionListener(new clearListener()); //add an action listener for the clear button

		BorderLayout layout = new BorderLayout(); //Layout manager for the main panel
		mainPanel = new JPanel(layout); //Instantiated main panel and added the new layout manager

		mainPanel.add(BorderLayout.CENTER, buttonPanel); //Adds the button panel to the center of the mainpanel
		mainPanel.add(BorderLayout.SOUTH, clear); //Adds the clear button to the south of the mainpanel

		outPut = new JTextArea(1, 20); //Makes the ouput area
		outPut.setEditable(false); //Disallows users from entering values directly into result

		Color backgroundColor = new Color(255, 255, 255); //Stores the color white to background color

		result = new Label("0", result.RIGHT);//Set the initial text of label to 0 and align right
		result.setFont(bigFont);//Set the font of result to big font
		result.setBackground(backgroundColor);//Sets the color of the label to whites

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

	public class numberListener implements ActionListener{ //Event listener for the numbers 0 through 9

		public void actionPerformed(ActionEvent event){ //Method that is fired when anynumber from 0 to 9 is clicked

			//System.out.println("I am " + event.getActionCommand() + " and I am a number"); //Test to see if the listener goes to the right button
			message = message + event.getActionCommand(); //Set the message to be displayed on the screen to equal the button pressed
			outPut.setText(message); //Set the output to equal message
			digit = digit + event.getActionCommand(); //Stores the number pressed into the digit

		}//close action performed method for number listener

	}//close number listener inner class

	public class operatorListener implements ActionListener{ //Event listener for the four basic arithemetic operators

		public void actionPerformed(ActionEvent event){ //Method that is fired when any of the operators are called

			//System.out.println("I am " + event.getActionCommand() + " and I am an operator"); //Test to see if the listener goes to the right operator
			message = message + " " + event.getActionCommand() + " ";//Set the message to be displayed on the screen
			outPut.setText(message); //Display the message on the screen
			number = Double.parseDouble(digit);//Get the value for calculation from digit
			digit = "";//Initializies digit to empty
			//System.out.println("The digit to work with is " + number); //Test to check if the digit was gotten

			if(event.getActionCommand().equals("+")){//if statement to check if the operation is addition
				
				//System.out.println("Here");
				numbers.add(number); //Adds the number to the array list of numbers
				operators.add(1); //Adds the operation to the array list of operators
				//System.out.println("added " + number + " to numbers and " + event.getActionCommand() + " to operators");

			}//Close if block

			else if(event.getActionCommand().equals("-")){//else if statement to check if the operation is subtraction

				numbers.add(number); //Adds the number to the array list of numbers
				operators.add(SUBTRACTION); //Adds the operation to the array list of operators
				//System.out.println("added " + number + " to numbers and " + event.getActionCommand() + " to operators");

			} //close else if block

			else if(event.getActionCommand().equals("/")){//else if statement to check if the operation is division 

				numbers.add(number); //Adds the number to the array list of numbers
				operators.add(DIVISION); //Adds the operation to the array list of operators
				//System.out.println("added " + number + " to numbers and " + event.getActionCommand() + " to operators");

			} //Close else if block

			else if(event.getActionCommand().equals("x")){//else if statement to check if the operation is multiplication 

				numbers.add(number); //Adds the number to the array list of numbers
				operators.add(MULTIPLICATION); //Adds the operation to the array list of operators
				//System.out.println("added " + number + " to numbers and " + event.getActionCommand() + " to operators");

			}//end of else if block

			else{ //else block

				System.out.println("Invalid operator");

			} //end of else block

		} //Close action performed method for the operator listener

	} //close operator listener inner class

	public class resultListener implements ActionListener{ //Event listener for the equal to button

		public void actionPerformed(ActionEvent event){ //Method that is fired when the equal to button is fired

			//System.out.println("I am " + event.getActionCommand() + " and I am a result finder"); //Test to see if the listener goes to the equal to button
			//printArray(operators, numbers); //Test to check if the numbers and operators are in the right array

			number = Double.parseDouble(digit);//Get the value for calculation from digit
			digit = "";//Initializies digit to empty
			numbers.add(number);
			double ans = compute(operators, numbers);
			result.setText("" + ans);

		} //Close action performed method for the result listener

	} //close result listener inner class

	public class clearListener implements ActionListener{//Event listener for the clear button

		public void actionPerformed(ActionEvent event){//Method that is fired the the clear button is clicked

			//System.out.println("I am " + event.getActionCommand()); //Test to see if the listener goes to the clear button		
			message = ""; //assigns message to empty
			digit = ""; //assigns digit to empty
			outPut.setText(message); //Clears all the message on the ouput screen
			result.setText("0"); //assigns total to empty
			//number = 0; //resets number to zero

		} //close action performed method for clear listener

	} //close clear listener inner class


	public boolean isIn(String[] stringArray, String name){ //Method to check if a string is in an array of strings

		boolean result = false;

		for(int i = 0; i < stringArray.length; i++){

			if(stringArray[i].equals(name)){

				result = true;

			}

		}

		return result;

	}

	public void setListener(JButton buttons, String name){ //Method to set the action listener of a button based on its name

		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."};
		String[] operators = {"+", "-", "/", "x"};
		String[] equals = {"="};

		if(isIn(numbers, name)){

			buttons.addActionListener(new numberListener());

		}

		else if(isIn(operators, name)){

			buttons.addActionListener(new operatorListener());

		}

		else if(isIn(equals, name)){

			buttons.addActionListener(new resultListener());

		}

	}

	/*public void printArray(ArrayList<Integer> num, ArrayList<Double> values){

		for(int i = 0; i < num.size(); i++){

			System.out.println(num.get(i));

		}

		for(int i = 0; i < values.size(); i++){

			System.out.println(values.get(i));

		}

	}*/

	public double compute(ArrayList<Integer> op, ArrayList<Double> val){//Method to perform calculations on the number in an array with the operations

		total = val.get(0); //assigns the first value to total
		for(int i = 1; i <= op.size(); i++){ //For loop to compute all the values in the array with the given operation

			if(op.get(i - 1) == ADDITION){//If block to check if operation is addition

				total = total + val.get(i);

			} //close if block

			else if(op.get(i - 1) == SUBTRACTION){ //If block to check if operation is subtraction

				total = total - val.get(i);

			} // close if block

			else if(op.get(i - 1) == DIVISION){ //If block to check if operation is division

				total = total / val.get(i);

			} // close if block

			else if(op.get(i - 1) == MULTIPLICATION){ //If block to check if operation is multiplication

				total = total * val.get(i);

			} //close if block

			else{

				System.out.println("Calculation parameters are wrong");

			}

		} // close loop

		return total;

	}// Close method



}//end calculator class