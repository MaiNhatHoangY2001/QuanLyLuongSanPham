package gui;

import java.awt.event.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

import gui_package.CircleBtn;
import gui_package.RoundedPanel;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_DangNhap extends JFrame {

	private JPanel contentPane;
	private int xClicked;
	private int yClicked;
	private JLabel lblLogo;
	private JLabel lblDangNhap;
	private JPanel panelThongTinDN;
	private JButton btnDangNhap;
	private JButton btnThoat;
	private JLabel lblTaiKhoan;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	private JLabel lblMatKhau;
	private JLabel lblTTTK;
	private CircleBtn btnXoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_DangNhap frame = new Gui_DangNhap();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		setBounds(100, 100, 440, 345);
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
		lblDangNhap.setBounds(114, 22, 206, 61);
		contentPane.add(lblDangNhap);
		
		panelThongTinDN = new RoundedPanel();
		panelThongTinDN.setBackground(new Color(248, 198, 153));
		panelThongTinDN.setBounds(26, 94, 389, 164);
		contentPane.add(panelThongTinDN);
		panelThongTinDN.setLayout(null);
		
		lblTaiKhoan = new JLabel("Tài Khoản:");
		lblTaiKhoan.setIconTextGap(-20);
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblTaiKhoan.setBounds(20, 30, 345, 35);
		panelThongTinDN.add(lblTaiKhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(85, 32, 282, 30);
		panelThongTinDN.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(85, 92, 282, 30);
		panelThongTinDN.add(txtMatKhau);
		
		lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setIconTextGap(-20);
		lblMatKhau.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatKhau.setBounds(20, 90, 345, 35);
		panelThongTinDN.add(lblMatKhau);
		
		btnDangNhap = new CircleBtn("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();	
				Gui_TrangChu s = new Gui_TrangChu();
				s.setVisible(true);
				
			}

		});
		btnDangNhap.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDangNhap.setBackground(new Color(233, 180, 46));
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDangNhap.setBounds(62, 275, 90, 45);
		contentPane.add(btnDangNhap);
		
		btnThoat = new CircleBtn("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Calibri", Font.BOLD, 16));
		btnThoat.setBorder(new LineBorder(new Color(1, 242, 233)));
		btnThoat.setBackground(new Color(233, 180, 46));
		btnThoat.setBounds(306, 275, 90, 45);
		contentPane.add(btnThoat);
		
		lblTTTK = new JLabel("Thông Tin Tài Khoản");
		lblTTTK.setFont(new Font("Calibri", Font.BOLD, 12));
		lblTTTK.setHorizontalAlignment(SwingConstants.LEFT);
		lblTTTK.setForeground(Color.WHITE);
		lblTTTK.setBounds(38, 69, 157, 30);
		contentPane.add(lblTTTK);
		
		btnXoa = new CircleBtn("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTaiKhoan.setText("");
				txtMatKhau.setText("");
			}
		});
		btnXoa.setBackground(new Color(233, 180, 46));
		btnXoa.setFont(new Font("Calibri", Font.BOLD, 16));
		btnXoa.setBounds(183, 275, 90, 45);
		contentPane.add(btnXoa);
	}
	private void close() {
		// TODO Auto-generated method stub
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	

}
