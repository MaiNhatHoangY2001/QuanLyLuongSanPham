package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TrangChu extends JFrame {

	private JPanel contentPane;
	private final JPanel panelNutBam = new JPanel();
	private JButton btnQuanLyNhanVien;
	private JButton btnQuanLyHoaDon;
	private JButton btnQuanLyLuong;
	private JButton btnQuanLySanPham;
	private JButton btnThongKeThuChi;
	private JButton btnQuanLyDuLieu;
	private JLabel lblTaiKhoan;
	private JLabel lblChuaLogo;
	private JLabel lblDangXuat;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnTrangChu;
	private int xClicked;
	private int yClicked;

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
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xClicked = e.getX();
				yClicked = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xClicked, y - yClicked);
			}
		});
//		setUndecorated(true);
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 1057);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(245, 129, 25));
		panelMenu.setSize(new Dimension(0, 204));
		panelMenu.setBounds(0, 0, 1440, 264);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		lblChuaLogo = new JLabel("");
		lblChuaLogo.setIcon(new ImageIcon("img\\dt2.png"));
		lblChuaLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblChuaLogo.setBounds(517, 22, 406, 225);
		panelMenu.add(lblChuaLogo);

		lblTaiKhoan = new JLabel("");
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setIcon(new ImageIcon("img\\user.png"));
		lblTaiKhoan.setBounds(1352, 22, 50, 50);
		panelMenu.add(lblTaiKhoan);

		lblDangXuat = new JLabel("");
		lblDangXuat.setIcon(new ImageIcon("img\\dangxuat.png"));
		lblDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangXuat.setBounds(1370, 83, 25, 25);
		panelMenu.add(lblDangXuat);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setFont(new Font("Calibri", Font.PLAIN, 24));
		menuBar.setBounds(27, 22, 88, 80);
		panelMenu.add(menuBar);

		mnNewMenu = new JMenu("");
		mnNewMenu.setAlignmentY(0.0f);
		mnNewMenu.setMargin(new Insets(0, 0, 0, 0));
		mnNewMenu.setIconTextGap(0);
		mnNewMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
		mnNewMenu.setIcon(new ImageIcon("img\\menu.png"));
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);

		mnTrangChu = new JMenu("Trang Chủ");
		mnTrangChu.setContentAreaFilled(false);
		mnTrangChu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnTrangChu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnTrangChu.setFont(new Font("Calibri", Font.PLAIN, 24));
		mnTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		mnTrangChu.setAlignmentY(Component.TOP_ALIGNMENT);
		mnTrangChu.setAlignmentX(Component.LEFT_ALIGNMENT);
		mnNewMenu.add(mnTrangChu);
		panelNutBam.setBounds(0, 264, 1440, 760);
		contentPane.add(panelNutBam);
		panelNutBam.setLayout(null);

		btnQuanLyNhanVien = new JButton("Quản Lý Nhân Viên");
		btnQuanLyNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLyNhanVien.setIcon(new ImageIcon("img\\nv.png"));
		btnQuanLyNhanVien.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLyNhanVien.setForeground(Color.WHITE);
		btnQuanLyNhanVien.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLyNhanVien.setBackground(new Color(245, 129, 25));
		btnQuanLyNhanVien.setBounds(49, 41, 407, 313);
		panelNutBam.add(btnQuanLyNhanVien);

		btnQuanLyHoaDon = new JButton("Quản Lý Hóa Đơn");
		btnQuanLyHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLyHoaDon.setIcon(new ImageIcon("img\\hd.png"));
		btnQuanLyHoaDon.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLyHoaDon.setForeground(Color.WHITE);
		btnQuanLyHoaDon.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLyHoaDon.setBackground(new Color(245, 129, 25));
		btnQuanLyHoaDon.setBounds(518, 41, 407, 313);
		panelNutBam.add(btnQuanLyHoaDon);

		btnQuanLyLuong = new JButton("Quản Lý Lương");
		btnQuanLyLuong.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLyLuong.setIcon(new ImageIcon("img\\l.png"));
		btnQuanLyLuong.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLyLuong.setForeground(Color.WHITE);
		btnQuanLyLuong.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLyLuong.setBackground(new Color(245, 129, 25));
		btnQuanLyLuong.setBounds(980, 41, 407, 313);
		panelNutBam.add(btnQuanLyLuong);

		btnQuanLySanPham = new JButton("Quản Lý Sản Phẩm");
		btnQuanLySanPham.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLySanPham.setIcon(new ImageIcon("img\\sp.png"));
		btnQuanLySanPham.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLySanPham.setForeground(Color.WHITE);
		btnQuanLySanPham.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLySanPham.setBackground(new Color(245, 129, 25));
		btnQuanLySanPham.setBounds(518, 406, 407, 313);
		panelNutBam.add(btnQuanLySanPham);

		btnQuanLyDuLieu = new JButton("Quản Lý Dữ Liệu");
		btnQuanLyDuLieu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLyDuLieu.setIcon(new ImageIcon("img\\database.png"));
		btnQuanLyDuLieu.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLyDuLieu.setForeground(Color.WHITE);
		btnQuanLyDuLieu.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLyDuLieu.setBackground(new Color(245, 129, 25));
		btnQuanLyDuLieu.setBounds(980, 406, 407, 313);
		panelNutBam.add(btnQuanLyDuLieu);

		btnThongKeThuChi = new JButton("Thống Kê Thu Chi");
		btnThongKeThuChi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnThongKeThuChi.setIcon(new ImageIcon("img\\tk.png"));
		btnThongKeThuChi.setVerticalTextPosition(SwingConstants.TOP);
		btnThongKeThuChi.setForeground(Color.WHITE);
		btnThongKeThuChi.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnThongKeThuChi.setBackground(new Color(245, 129, 25));
		btnThongKeThuChi.setBounds(49, 406, 407, 313);
		panelNutBam.add(btnThongKeThuChi);

	}
}
