package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DemoCustomTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FrmQuanLyLuong customJTabbedPane;

	/** JPanel contain a JLabel */
	public DemoCustomTab(FrmQuanLyLuong customJTabbedPane) {
		this.customJTabbedPane = customJTabbedPane;
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 2, 2, 2));
		setPreferredSize(new Dimension(300, 50));
		setOpaque(false);

		addLabel();

	}

	private void addLabel() {
		JLabel label = new JLabel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			/** set text for JLabel, it will title of tab */
			public String getText() {
				int index = customJTabbedPane.tabbedPane.indexOfTabComponent(DemoCustomTab.this);
				if (index != -1) {
					return customJTabbedPane.tabbedPane.getTitleAt(index);
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