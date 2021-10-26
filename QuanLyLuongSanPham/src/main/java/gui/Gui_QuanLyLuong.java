package gui;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import gui_package.ChucNang;
import gui_package.CustomTab;
import gui_package.PnlTinhDoanhThu;
import gui_package.PnlTinhLuong;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Gui_QuanLyLuong extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	private JLabel lblGio;
	private JButton btnMenu;
	private JLabel lblIconUser;
	private JLabel lblIconDX;
	private JLabel lblDangXuat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_QuanLyLuong frame = new Gui_QuanLyLuong();
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
	public Gui_QuanLyLuong() {
		ChucNang.setDiChuyenGD(this);
		ChucNang.setTableAlternateRow();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 1024);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194, 93, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1424, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(242, 129, 25));

		JLabel lblChinh = new JLabel("QUẢN LÝ LƯƠNG");
		lblChinh.setForeground(Color.WHITE);
		lblChinh.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblChinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblChinh.setBounds(292, 34, 885, 74);
		panel.add(lblChinh);

		/**
		 * Tên người dùng
		 */
		JLabel lblTenTaiKhoan = new JLabel("Chinh");
		lblTenTaiKhoan.setForeground(Color.WHITE);
		lblTenTaiKhoan.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblTenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 36));
		lblTenTaiKhoan.setBounds(1246, 22, 90, 40);
		panel.add(lblTenTaiKhoan);

		lblIconUser = new JLabel("");
		Image imgUser = new ImageIcon("img\\user1.png").getImage();
		lblIconUser.setIcon(new ImageIcon(imgUser));
		lblIconUser.setBounds(1355, 22, 40, 40);
		panel.add(lblIconUser);

		/**
		 * Nút đăng xuất
		 */
		lblDangXuat = new JLabel("\u0110\u0103ng xu\u1EA5t");
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDangXuat.setBounds(1246, 67, 110, 24);
		panel.add(lblDangXuat);

		lblIconDX = new JLabel("");
		Image imgDX = new ImageIcon("img\\dangxuat.png").getImage();
		lblIconDX.setIcon(new ImageIcon(imgDX));
		lblIconDX.setBounds(1370, 67, 25, 25);
		panel.add(lblIconDX);

		/**
		 * giờ
		 */
		lblGio = new JLabel("12:00");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Arial", Font.PLAIN, 36));
		lblGio.setBounds(1305, 96, 90, 36);
		panel.add(lblGio);
		ChucNang.setGio(lblGio);

		/**
		 * tab
		 */
		UIManager.put("TabbedPane.selected", new Color(242, 129, 25));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 150, 1424, 835);
		tabbedPane.setBackground(new Color(194, 93, 0));

		contentPane.add(tabbedPane);

		tabbedPane.add("Tính lương", new PnlTinhLuong());
		tabbedPane.setTabComponentAt(0, new CustomTab(tabbedPane));

		tabbedPane.add("Tính doanh thu", new PnlTinhDoanhThu());
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
