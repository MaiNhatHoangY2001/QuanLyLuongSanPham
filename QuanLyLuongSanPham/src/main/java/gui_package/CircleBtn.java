package gui_package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class CircleBtn extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CircleBtn(String text) {
		super(text);

		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);

		setContentAreaFilled(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(new Color(231, 193,96));
			setForeground(Color.BLACK);
		} else {
			g.setColor(getBackground());
			setForeground(Color.WHITE);
		}
		g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20, 20);

		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(new Color(233, 180, 46));
		g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20, 20);
	}
}