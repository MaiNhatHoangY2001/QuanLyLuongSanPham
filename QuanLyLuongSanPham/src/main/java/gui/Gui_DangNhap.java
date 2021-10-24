package gui;


import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
public class Gui_DangNhap extends JFrame {

	private JPanel contentPane;
	private int xClicked;
	private int yClicked;
	private JLabel lblLogo;
	private JLabel lblDangNhap;
	private JPanel panelThongTinDN;
	private JButton btnDangNhap;
	private JButton btnHuyBo;
	private JLabel lblTaiKhoan;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	private JLabel lblMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_DangNhap frame = new Gui_DangNhap();
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
	public Gui_DangNhap() {
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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245	, 129, 25));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\img\\dtNho.png"));
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(0, 0, 72, 44);
		contentPane.add(lblLogo);
		
		lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setForeground(Color.WHITE);
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Calibri", Font.BOLD, 36));
		lblDangNhap.setBounds(115, 28, 206, 61);
		contentPane.add(lblDangNhap);
		
		panelThongTinDN = new JPanel();
		panelThongTinDN.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Th\u00F4ng Tin T\u00E0i Kho\u1EA3n", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(255, 255, 255)));
		panelThongTinDN.setBackground(new Color(248, 198, 153));
		panelThongTinDN.setBounds(26, 87, 389, 164);
		contentPane.add(panelThongTinDN);
		panelThongTinDN.setLayout(null);
		
		lblTaiKhoan = new JLabel("Tài Khoản:");
		lblTaiKhoan.setIconTextGap(-20);
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblTaiKhoan.setBounds(20, 36, 345, 35);
		panelThongTinDN.add(lblTaiKhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(85, 38, 282, 30);
		panelThongTinDN.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(85, 100, 282, 30);
		panelThongTinDN.add(txtMatKhau);
		
		lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setIconTextGap(-20);
		lblMatKhau.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatKhau.setBounds(20, 98, 345, 35);
		panelThongTinDN.add(lblMatKhau);
		
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBackground(new Color(233, 180, 46));
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDangNhap.setBounds(76, 268, 120, 47);
		contentPane.add(btnDangNhap);
		
		btnHuyBo = new JButton("Hủy Bỏ");
		btnHuyBo.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(252, 268, 120, 47);
		contentPane.add(btnHuyBo);
	}
}
