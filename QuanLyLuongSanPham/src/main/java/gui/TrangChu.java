package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Canvas;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TrangChu extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
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
	public TrangChu() {
		setLocationByPlatform(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setSize(new Dimension(0, 204));
		panel.setBounds(0, 0, 1440, 264);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\HOC_TAP\\Nam 3-HK1\\PTUD\\BaiTapLon\\dt.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(517, 22, 406, 225);
		panel.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(47, 35, 101, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_4);
		panel_1.setBounds(0, 264, 1440, 760);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnQuanLyNhanVien = new JButton("New button");
		btnQuanLyNhanVien.setActionCommand("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		btnQuanLyNhanVien.setBounds(49, 41, 407, 313);
		panel_1.add(btnQuanLyNhanVien);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(518, 41, 407, 313);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(980, 41, 407, 313);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(49, 406, 407, 313);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(518, 406, 407, 313);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("New button");
		btnNewButton_2_1_1.setBounds(980, 406, 407, 313);
		panel_1.add(btnNewButton_2_1_1);
	}
}
