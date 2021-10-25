package gui_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class CustomTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** JPanel contain a JLabel */
	public CustomTab(JTabbedPane tabbedPane) {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 2, 2, 2));
		setPreferredSize(new Dimension(300, 50));
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addLabel(tabbedPane);
	}

	public void addLabel(JTabbedPane tabbedPane) {
		JLabel label = new JLabel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			/** set text for JLabel, it will title of tab */
			public String getText() {
				int index = tabbedPane.indexOfTabComponent(CustomTab.this);
				if (index != -1) {
					return tabbedPane.getTitleAt(index);
				}
				return null;
			}
		};
		/** add more space between the label and the button */
		label.setBorder(new EmptyBorder(0, 0, 0, 10));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setForeground(Color.WHITE);
		add(label, BorderLayout.CENTER);
	}

}