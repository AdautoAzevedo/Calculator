package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import business_layer.Memory;

public class MainScreen extends JFrame{
	public MainScreen() {
		organizer();
		setSize(300,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void organizer() {
		setLayout(new BorderLayout());
		Display display = new Display();
		Memory memory = new Memory();
		
		display.setPreferredSize(new Dimension(200,60));		
		add(display, BorderLayout.NORTH);
		
		Keyboard keyboard = new Keyboard(display, memory);
		add(keyboard, BorderLayout.CENTER);
	}
}
