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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

import gui_package.CircleBtn;
import gui_package.RoundedPanel;
import model.TaiKhoan;
import services.DangNhapService;

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
	protected JButton btnDangNhap;
	private JButton btnThoat;
	private JLabel lblTaiKhoan;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	private JLabel lblMatKhau;
	private JLabel lbTieuDe;
	private CircleBtn btnXoa;
	private JPanel panelNgang;
	private JLabel lblHD;
	private JLabel lblDB;
	private JLabel lblTK;
	private JLabel lblLuong;
	private DangNhapService dangNhapService = new DangNhapService();
	private Gui_Chinh chinh = new Gui_Chinh();

	/**
	 * Create the frame.
	 */
	public Gui_DangNhap() {
		setIconImage(new ImageIcon("img/logo.png").getImage());
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
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 129, 25));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\img\\dt2.png"));
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(440, 79, 320, 224);
		contentPane.add(lblLogo);

		panelThongTinDN = new RoundedPanel();
		panelThongTinDN.setBackground(new Color(248, 198, 153));
		panelThongTinDN.setBounds(40, 336, 1124, 434);
		contentPane.add(panelThongTinDN);
		panelThongTinDN.setLayout(null);

		lblTaiKhoan = new JLabel("Tài Khoản:");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTaiKhoan.setForeground(Color.WHITE);
		lblTaiKhoan.setIconTextGap(-20);
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTaiKhoan.setBounds(30, 124, 109, 50);
		panelThongTinDN.add(lblTaiKhoan);

		txtTaiKhoan = new JTextField("NV19020001");
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTaiKhoan.setBounds(149, 124, 827, 50);
		panelThongTinDN.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(149, 224, 827, 50);
		panelThongTinDN.add(txtMatKhau);

		lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setIconTextGap(-20);
		lblMatKhau.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMatKhau.setBounds(20, 232, 119, 35);
		panelThongTinDN.add(lblMatKhau);

		btnDangNhap = new CircleBtn("Đăng Nhập");
		btnDangNhap.setBounds(149, 320, 204, 60);
		panelThongTinDN.add(btnDangNhap);

		btnDangNhap.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDangNhap.setBackground(new Color(233, 180, 46));
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0)));

		btnXoa = new CircleBtn("Xóa");
		btnXoa.setBounds(460, 320, 204, 60);
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
		btnThoat.setBounds(772, 320, 204, 60);
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
		lblDangNhap.setBounds(460, 37, 206, 61);
		panelThongTinDN.add(lblDangNhap);
		lblDangNhap.setForeground(Color.WHITE);
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Calibri", Font.BOLD, 40));

		lbTieuDe = new JLabel("ỨNG DỤNG QUẢN LÝ CỬA HÀNG ĐIỆN THOẠI 17");
		lbTieuDe.setVerticalAlignment(SwingConstants.BOTTOM);
		lbTieuDe.setFont(new Font("Calibri", Font.BOLD, 48));
		lbTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbTieuDe.setForeground(Color.WHITE);
		lbTieuDe.setBounds(0, 0, 1200, 75);
		contentPane.add(lbTieuDe);

		panelNgang = new JPanel();
		panelNgang.setBounds(0, 75, 1200, 230);
		panelNgang.setBackground(new Color(194, 93, 0));
		contentPane.add(panelNgang);
		panelNgang.setLayout(null);

		lblHD = new JLabel("");
		lblHD.setIcon(new ImageIcon("img\\l.png"));
		lblHD.setBounds(41, 43, 148, 154);
		panelNgang.add(lblHD);
		lblHD.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHD.setHorizontalAlignment(SwingConstants.CENTER);

		lblTK = new JLabel("");
		lblTK.setIcon(new ImageIcon("img\\tk.png"));
		lblTK.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblTK.setBounds(237, 43, 148, 154);
		panelNgang.add(lblTK);

		lblDB = new JLabel("");
		lblDB.setIcon(new ImageIcon("img\\database.png"));
		lblDB.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDB.setHorizontalAlignment(SwingConstants.CENTER);
		lblDB.setBounds(812, 43, 148, 154);
		panelNgang.add(lblDB);

		lblLuong = new JLabel("");
		lblLuong.setIcon(new ImageIcon("img\\sp.png"));
		lblLuong.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuong.setBounds(1012, 43, 148, 154);
		panelNgang.add(lblLuong);

		btnDangNhap.addActionListener(e -> {
			String ten = txtTaiKhoan.getText().trim();
			String mk = txtMatKhau.getText().trim();
			TaiKhoan taiKhoan = dangNhapService.geTaiKhoan(ten);
			if (!(KiemTraRongText(txtTaiKhoan))) {
				if(taiKhoan != null)
					if (mk.equals(taiKhoan.getMatKhau())) {
						chinh.setTaiKhoan(taiKhoan);
						chinh.setVisible(true);
						this.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(this, "Mật khẩu không chính xác");
					}
				else {
					JOptionPane.showMessageDialog(this, "Sai tên tài khoản");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Tên tài khoản không được bỏ trống");
			}
		});

	}

	public static void main(String[] args) {
		getInstance().setVisible(true);
	}
	public static Gui_DangNhap getInstance() {
		return new Gui_DangNhap();
	}
	public boolean KiemTraRongText(JTextField txt) {
		return txt.getText().equals("") ? true : false;
	}
}
