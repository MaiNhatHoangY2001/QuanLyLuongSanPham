package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * A custom JTextField with rounded corners.
 */
public class RoundTextField extends JTextField {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public RoundTextField(String text, int columns) {
		super(text, columns);
		setOpaque(false);
		setBorder(new RoundBorder());
	}

	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		super.paintComponent(g);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("RoundTextField");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new RoundTextField("One", 20));
		contentPane.add(new RoundTextField("Two", 20));
		contentPane.add(new RoundTextField("Three", 20));

		frame.setVisible(true);
	}

}

class RoundBorder extends AbstractBorder {
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Color oldColor = g.getColor();

		g.setColor(Color.black);
		g.drawRoundRect(x, y, width - 1, height - 1, 20, 20);

		g.setColor(oldColor);
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(4, 4, 4, 4);
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		insets.left = insets.top = insets.right = insets.bottom = 4;
		return insets;
	}

}
