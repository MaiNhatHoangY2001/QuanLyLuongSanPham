package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import jiconfont.swing.IconFontSwing;

import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Gui_QuanLyHoaDon extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_QuanLyHoaDon frame = new Gui_QuanLyHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_QuanLyHoaDon() {
		setMinimumSize(new Dimension(1440, 1024));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1440, 120);
		getContentPane().add(panel);
		panel.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 27, 52, 45);
		panel.add(menuBar);
		
		IconFontSwing.register(FontAwesome.getIconFont());
		Icon iconMenu = IconFontSwing.buildIcon(FontAwesome.TASKS,40,Color.WHITE);
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(iconMenu);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		mnNewMenu.add(lblNewLabel);
	}
}
