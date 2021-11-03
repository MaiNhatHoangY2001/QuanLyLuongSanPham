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
	private JLabel lblLogo;
	private JLabel lblHD;
	private JLabel lblTK;
	private JLabel lblLT;
	private JLabel lblSP;
	private JPanel panelGiua;

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
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194	, 93, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelThongTinDN = new RoundedPanel();
		panelThongTinDN.setBackground(new Color(248, 198, 153));
		panelThongTinDN.setBounds(40, 346, 1124, 434);
		contentPane.add(panelThongTinDN);
		panelThongTinDN.setLayout(null);
		
		lblTaiKhoan = new JLabel("Tài Khoản:");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTaiKhoan.setForeground(Color.WHITE);
		lblTaiKhoan.setIconTextGap(-20);
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setBounds(33, 128, 125, 48);
		panelThongTinDN.add(lblTaiKhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(158, 126, 806, 50);
		panelThongTinDN.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(158, 225, 806, 50);
		panelThongTinDN.add(txtMatKhau);
		
		lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setIconTextGap(-20);
		lblMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatKhau.setBounds(38, 225, 122, 48);
		panelThongTinDN.add(lblMatKhau);
		
		btnDangNhap = new CircleBtn("Đăng Nhập");
		btnDangNhap.setBounds(158, 324, 204, 60);
		panelThongTinDN.add(btnDangNhap);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();	
				Gui_Chinh s = new Gui_Chinh();
				s.setVisible(true);
				
			}

		});
		btnDangNhap.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDangNhap.setBackground(new Color(233, 180, 46));
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnXoa = new CircleBtn("Xóa");
		btnXoa.setBounds(460, 324, 204, 60);
		panelThongTinDN.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTaiKhoan.setText("");
				txtMatKhau.setText("");
			}
		});
		btnXoa.setBackground(new Color(233, 180, 46));
		btnXoa.setFont(new Font("Calibri", Font.BOLD, 16));
		
		btnThoat = new CircleBtn("Thoát");
		btnThoat.setBounds(760, 324, 204, 60);
		panelThongTinDN.add(btnThoat);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Calibri", Font.BOLD, 16));
		btnThoat.setBorder(new LineBorder(new Color(1, 242, 233)));
		btnThoat.setBackground(new Color(233, 180, 46));
		
		lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setBounds(338, 38, 448, 61);
		panelThongTinDN.add(lblDangNhap);
		lblDangNhap.setForeground(Color.WHITE);
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Calibri", Font.BOLD, 46));
		
		lblTTTK = new JLabel("ỨNG DỤNG QUẢN LÝ CỬA HÀNG ĐIỆN THOẠI 17");
		lblTTTK.setFont(new Font("Calibri", Font.BOLD, 50));
		lblTTTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblTTTK.setForeground(Color.WHITE);
		lblTTTK.setBounds(0, 0, 1200, 92);
		contentPane.add(lblTTTK);
		
		panelGiua = new JPanel();
		panelGiua.setBackground(new Color(245	, 129, 25));
		panelGiua.setBounds(0, 92, 1200, 230);
		contentPane.add(panelGiua);
		panelGiua.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\img\\dt2.png"));
		lblLogo.setBounds(447, 5, 305, 222);
		panelGiua.add(lblLogo);
		
		lblTK = new JLabel("");
		lblTK.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\img\\tk.png"));
		lblTK.setBounds(250, 45, 138, 152);
		panelGiua.add(lblTK);
		
		lblHD = new JLabel("");
		lblHD.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\img\\l.png"));
		lblHD.setBounds(59, 45, 138, 152);
		panelGiua.add(lblHD);
		
		lblLT = new JLabel("");
		lblLT.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\img\\database.png"));
		lblLT.setBounds(814, 45, 138, 152);
		panelGiua.add(lblLT);
		
		lblSP = new JLabel("");
		lblSP.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\img\\sp.png"));
		lblSP.setBounds(1018, 45, 138, 152);
		panelGiua.add(lblSP);
	}
	private void close() {
		// TODO Auto-generated method stub
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
