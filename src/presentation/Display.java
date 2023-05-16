package presentation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import business_layer.Memory;

public class Display extends JPanel  {
	private JLabel label;
	private Memory memory;
	public Display() {
		label = new JLabel();
		label.setBackground(Color.BLACK);
		label.setFont(new Font("arial", Font.BOLD, 40));
		setBackground(Color.GRAY);
		add(label);
	}
	
	public void setLabel(String text) {
		label.setText(text);
	}
}
