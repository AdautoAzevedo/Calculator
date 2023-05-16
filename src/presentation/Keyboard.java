package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import business_layer.Memory;
import business_layer.Operations;




public class Keyboard extends JPanel {
	
	private Operations op;
	private Display display;
	private double num1;
	private double num2;
	private String operation;
	private ActionListener operationButtonListener;
	private ActionListener equalsButtonListener;
	private ActionListener numsButtonListener;
	private Memory memory;
	
	public Keyboard(Display display, Memory memory) {
		setLayout(new GridLayout(4, 4));
		setBackground(Color.lightGray);
		this.display = display;
		this.memory = memory;
		
		add(createButton("7", Color.GRAY));
		add(createButton("8", Color.GRAY));
		add(createButton("9", Color.GRAY));
		add(createOperationButton("+", Color.darkGray));
		
		add(createButton("4", Color.GRAY));
		add(createButton("5", Color.GRAY));
		add(createButton("6", Color.GRAY));
		add(createOperationButton("-", Color.darkGray));
		
		add(createButton("1", Color.GRAY));
		add(createButton("2", Color.GRAY));
		add(createButton("3", Color.GRAY));
		add(createOperationButton("*", Color.darkGray));
		
		add(createButton("0", Color.GRAY));
		add(createOperationButton("/", Color.darkGray));
		add(createButton(".", Color.darkGray));
		add(createEqualButton("=", Color.darkGray));
	}
	
	public Button createButton(String text, Color color) {
		Button b = new Button(text, color);
		setUpButtonListeners(text);
		b.addActionListener(numsButtonListener);
		return b;
	}
	
	public Button createOperationButton(String text, Color color) {
		Button button = new Button(text, color);
		setUpButtonListeners(text);
		button.addActionListener(operationButtonListener);
		return button;
	}
	
	public Button createEqualButton(String text, Color color) {
		Button button = new Button(text, color);	
		button.addActionListener(equalsButtonListener);
		return button;
	}
	
	//This set the actions for each action listener 
	public void setUpButtonListeners(String text) {
		operationButtonListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			operation = text;
			num1 = Double.parseDouble(memory.getNumbers());
			cleanDisplay();
			}
		};
		
		equalsButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num2 = Double.parseDouble(memory.getNumbers());
				handleOp();			
			}
		};
		
		numsButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				memory.setNumber(b.getText());
				display.setLabel(memory.getNumbers());
			}
		};
		
	}
	
	//This function clean the display and reset the array of number for receive the next number  
	public void cleanDisplay() {
		display.setLabel("");
		memory.resetArray();
	}
	
	//This will instantiate the Operations class and display the result when receives it
	public void handleOp() {
		op = new Operations(num1, operation, num2);
		display.setLabel(String.valueOf(op.getResult()));
	}
}


