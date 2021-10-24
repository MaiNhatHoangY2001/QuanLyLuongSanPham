package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import gui_package.ChucNang;
import gui_package.CustomTab;

public class Gui_ThongKeThuChi extends JFrame {

	private JPanel contentPane;
	private JLabel lblGio;
	private JLabel lblNguoiSuDung;
	private JTabbedPane tabbedPane;
	private JButton btnMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_ThongKeThuChi frame = new Gui_ThongKeThuChi();
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
	public Gui_ThongKeThuChi() {
		ChucNang.setDiChuyenGD(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 1024);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194, 93, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1424, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(242, 129, 25));

		JLabel lblChinh = new JLabel("THỐNG KÊ THU CHI");
		lblChinh.setForeground(Color.WHITE);
		lblChinh.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblChinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblChinh.setBounds(292, 34, 885, 74);
		panel.add(lblChinh);
		/**
		 * lblGio
		 */
		lblGio = new JLabel("12:00");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblGio.setBounds(1320, 83, 94, 35);
		panel.add(lblGio);
		
		ChucNang.setGio(lblGio);
		
		/**
		 * user login
		 */
		lblNguoiSuDung = new JLabel("Chinh");
		lblNguoiSuDung.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNguoiSuDung.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNguoiSuDung.setToolTipText("Đã đăng nhập");
		lblNguoiSuDung.setForeground(Color.WHITE);
		lblNguoiSuDung.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNguoiSuDung.setBounds(1229, 27, 136, 45);
		panel.add(lblNguoiSuDung);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(
				"src/main/resources/images/img_bill/uerlogin.PNG"));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_5.setBounds(1372, 27, 52, 45);
		panel.add(lblNewLabel_5);

		/**
		 * tab
		 */
		UIManager.put("TabbedPane.selected", new Color(242, 129, 25));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 150, 1424, 835);
		tabbedPane.setBackground(new Color(194, 93, 0));

		contentPane.add(tabbedPane);
		
		tabbedPane.add("Thống kê thu", new Gui_ThongKeThu());
		tabbedPane.setTabComponentAt(0, new CustomTab(tabbedPane));

		tabbedPane.add("Thống kê chi", new Gui_TinhDoanhThu());
		tabbedPane.setTabComponentAt(1, new CustomTab(tabbedPane));
		
		
		
		
		/**
		 * menu
		 */
		btnMenu = new JButton("");
		btnMenu.setToolTipText("Mở/Đóng menu");
		btnMenu.setBorder(null);
		btnMenu.setIcon(new ImageIcon("src/main/resources/images/img_bill/menu.PNG"));
		btnMenu.setBounds(27, 27, 72, 83);
		btnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnMenu);
			
		JPanel pnMenu = new Gui_Menu();
		Rectangle temp = panel.getBounds();
		Rectangle temp1 = tabbedPane.getBounds();
		
		btnMenu.addActionListener(e -> {

			if (panel.getX() == 400) {

				this.remove(pnMenu);
				panel.setBounds(temp);
				tabbedPane.setBounds(temp1);

			} else {
				panel.setBounds(400, 0, 1440 - 400, panel.getHeight());
				tabbedPane.setBounds(400, tabbedPane.getY(), 1440 - 400, tabbedPane.getHeight());
				add(pnMenu);
			}
		});
	}

}
