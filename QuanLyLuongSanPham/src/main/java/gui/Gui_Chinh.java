package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import gui_package.PnlTinhDoanhThu;
import gui_package.PnlTinhLuong;

import java.awt.Point;

public class Gui_Chinh extends JFrame implements ActionListener{
	private final JButton btnNewButton = new JButton("New button");
	private JPanel pnlChange;
	private JButton btnQuanLyTaiKhoan;
	private JButton btnThoat;
	private JButton btnQuanLySanPham;
	private JButton btnThongKe;
	private JButton btnQuanLyLuong;
	private JButton btnQuanLyHoaDon;
	private JButton btnQuanLyNhanVien;
	private CardLayout cardLayout;
	private JPanel panel_2;
	private JPanel panel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Chinh frame = new Gui_Chinh();
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
	public Gui_Chinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920, 1046);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 129,25));
		panel.setBounds(0, 0, 320, 1029);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/dt-navbar.png"));
		lblNewLabel.setBounds(95, 21, 174, 104);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CỬA HÀNG ĐIỆN THOẠI 17");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(9, 147, 294, 27);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 200, 320, 807);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("img\\thoat.png"));
		btnThoat.setBounds(0, 690, 320, 115);
		panel_1.add(btnThoat);
		btnThoat.setIconTextGap(10);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThoat.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnThoat.setBackground(new Color(242, 129,25));
		
		btnQuanLyTaiKhoan = new JButton("Quản lý tài khoản");
		btnQuanLyTaiKhoan.setIcon(new ImageIcon("img\\taikhoan.png"));
		btnQuanLyTaiKhoan.setBounds(0, 575, 320, 115);
		panel_1.add(btnQuanLyTaiKhoan);
		btnQuanLyTaiKhoan.setIconTextGap(10);
		btnQuanLyTaiKhoan.setForeground(Color.WHITE);
		btnQuanLyTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyTaiKhoan.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyTaiKhoan.setBackground(new Color(242, 129,25));
		
		btnQuanLySanPham = new JButton("Quản lý sản phẩm");
		btnQuanLySanPham.setIcon(new ImageIcon("img\\sanpham.png"));
		btnQuanLySanPham.setBounds(0, 460, 320, 115);
		panel_1.add(btnQuanLySanPham);
		btnQuanLySanPham.setIconTextGap(10);
		btnQuanLySanPham.setForeground(Color.WHITE);
		btnQuanLySanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLySanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLySanPham.setBackground(new Color(242, 129,25));
		
		btnThongKe = new JButton("Thống kê thu chi");
		btnThongKe.setIcon(new ImageIcon("img\\thongke.png"));
		btnThongKe.setBounds(0, 345, 320, 115);
		panel_1.add(btnThongKe);
		btnThongKe.setIconTextGap(0);
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThongKe.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnThongKe.setBackground(new Color(242, 129,25));
		
		btnQuanLyLuong = new JButton("Quản lý lương");
		btnQuanLyLuong.setIcon(new ImageIcon("img\\luong.png"));
		btnQuanLyLuong.setBounds(0, 230, 320, 115);
		panel_1.add(btnQuanLyLuong);
		btnQuanLyLuong.setIconTextGap(10);
		btnQuanLyLuong.setForeground(Color.WHITE);
		btnQuanLyLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyLuong.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyLuong.setBackground(new Color(242, 129,25));
		
		btnQuanLyHoaDon = new JButton("Quản lý hóa đơn");
		btnQuanLyHoaDon.setIcon(new ImageIcon("img\\hoadon.png"));
		btnQuanLyHoaDon.setBounds(0, 115, 320, 115);
		panel_1.add(btnQuanLyHoaDon);
		btnQuanLyHoaDon.setIconTextGap(10);
		btnQuanLyHoaDon.setForeground(Color.WHITE);
		btnQuanLyHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyHoaDon.setBackground(new Color(242, 129,25));
		btnQuanLyHoaDon.setAlignmentX(1.0f);
		
		btnQuanLyNhanVien = new JButton("Quản lý nhân viên");
		btnQuanLyNhanVien.setIconTextGap(10);
		btnQuanLyNhanVien.setIcon(new ImageIcon("img\\nv.png"));
		btnQuanLyNhanVien.setBounds(0, 0, 320, 115);
		panel_1.add(btnQuanLyNhanVien);
		btnQuanLyNhanVien.setForeground(Color.WHITE);
		btnQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuanLyNhanVien.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanLyNhanVien.setBackground(new Color(242, 129,25));
		
		btnQuanLyHoaDon.addActionListener(this);
		btnQuanLyLuong.addActionListener(this);
		btnQuanLyNhanVien.addActionListener(this);
		btnQuanLySanPham.addActionListener(this);
		btnQuanLyTaiKhoan.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnThoat.addActionListener(this);
		
		
		pnlChange = new JPanel();
		pnlChange.setBounds(320, 0, 1584, 1007);
		getContentPane().add(pnlChange);
		pnlChange.setLayout(new CardLayout(0, 0));
		
		cardLayout = (CardLayout) pnlChange.getLayout();
		

//		pnlChange.add(new test(), "btnQuanLyHoaDon");
		pnlChange.add(new PnlTinhLuong(), "btnQuanLyLuong");
//		pnlChange.add(new test(), "btnQuanLyNhanVien");
//		pnlChange.add(new test(), "btnQuanLySanPham");
//		pnlChange.add(new test(), "btnQuanLyTaiKhoan");
		pnlChange.add(new PnlTinhDoanhThu(), "btnThongKe");
//		pnlChange.add(new test(), "btnThoat");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object key = e.getSource();
		if (key == btnQuanLyHoaDon) 
			cardLayout.show(pnlChange, "btnQuanLyHoaDon");
		else if (key == btnQuanLyLuong) 
			cardLayout.show(pnlChange, "btnQuanLyLuong");
		else if (key == btnQuanLyNhanVien) 
			cardLayout.show(pnlChange, "btnQuanLyNhanVien");
		else if (key == btnQuanLySanPham) 
			cardLayout.show(pnlChange, "btnQuanLySanPham");
		else if (key == btnQuanLyTaiKhoan) 
			cardLayout.show(pnlChange, "btnQuanLyTaiKhoan");
		else if (key == btnThoat) 
			cardLayout.show(pnlChange, "btnThoat");
		else if (key == btnThongKe) 
			cardLayout.show(pnlChange, "btnThongKe");
	}
	
}
