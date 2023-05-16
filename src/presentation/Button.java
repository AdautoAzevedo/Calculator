
package presentation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Button extends JButton {

	public Button (String text, Color color) {
		setText(text);
		setOpaque(true);
		setBackground(color);
		setFont(new Font("arial", Font.PLAIN, 20));
	}
}
