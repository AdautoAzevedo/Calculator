package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

import business_layer.Memory;
import business_layer.Operations;


public class Keyboard extends JPanel {
	
	private Operations op;
	private Display display;
	private Memory memory;
	
	public Keyboard(Display display, Memory memory) {
		setLayout(new GridLayout(4, 4));
		setBackground(Color.lightGray);
		this.display = display;
		this.memory = memory;
		
		addActionButtons();
	}

	private void addActionButtons() {
		addNumberButtons();
		addOperationButtons();
		addEqualButton();
	}

	private void addNumberButtons() {
		for (int i = 9; i >= 0; i--) {
			String buttonText = String.valueOf(i);
			add(createButton((buttonText), Color.GRAY));
		}
		add(createButton(".", Color.darkGray));
	}

	private void addOperationButtons() {
		String[] operations = {"+", "-", "*", "/"};
		for (String op : operations) {
			add(createButton(op, Color.darkGray));
		}
	}

	private void addEqualButton() {
		add(createEqualButton("=", Color.darkGray));
	}
	
	public Button createButton(String text, Color color) {
		Button button = new Button(text, color);
		button.addActionListener(e -> {
			memory.appendNumber(text);
			display.setLabel(memory.getNumbers());
		});
		return button;
	}
	
	
	public Button createEqualButton(String text, Color color) {
		Button button = new Button(text, color);	
		button.addActionListener(e -> {
			handleOp();
		});
		return button;
	}
	
	
	//This function clean the display and reset the array of number for receive the next number  
	public void cleanDisplay() {
		display.setLabel("");
		memory.resetArray();
	}
	
	//This will instantiate the Operations class and display the result when receives it
	public void handleOp() {

		String expression = memory.getNumbers();
		String[] parts = expression.split("[\\+\\-\\*\\/]");

		if (parts.length != 2) {
			throw new IllegalArgumentException("Invalid expression: "+ expression);
		}

		double num1 = Double.parseDouble(parts[0]);
		String operation = expression.replaceAll("[\\d.]", "");
		double num2 = Double.parseDouble(parts[1]); // Get the second number
		
		// Check if the operation is valid
		if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
			double result = Operations.calculate(num1, operation, num2);
			display.setLabel(String.valueOf(result)); // Display the result
			memory.appendNumber(String.valueOf(result)); // Store result for further operations
		} else {
			throw new IllegalArgumentException("Invalid operation: " + operation);
		}
	}
	
	
}


