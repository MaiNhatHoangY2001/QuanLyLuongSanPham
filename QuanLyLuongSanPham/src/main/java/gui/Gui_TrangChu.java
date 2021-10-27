package gui;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.Gui_DangNhap;
import gui_package.ChucNang;
import gui_package.CircleBtn;

public class Gui_TrangChu extends JFrame implements MouseListener {

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
	private JLabel lblHinhDangXuat;
	private JLabel lblMenu;
	private JLabel lblGio;
	private JLabel lblChuDangXuat;
	private JPanel panelMenu;
	private Gui_Menu pnMenu;
	private Rectangle temp;
	private Rectangle temp1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_TrangChu frame = new Gui_TrangChu();
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
	public Gui_TrangChu() {
		ChucNang.setDiChuyenGD(this);
//		setUndecorated(true);
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 1057);
		setLocationRelativeTo(null);
		
		/**
		 * Content pane bự chứa tất cả 
		 */	
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Menu
		 */
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(245, 129, 25));
		panelMenu.setSize(new Dimension(0, 204));
		panelMenu.setBounds(0, 0, 1440, 264);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		/**
		 * Label chứa logo cửa hàng
		 */
		lblChuaLogo = new JLabel("");
		lblChuaLogo.setIcon(new ImageIcon("img\\dt2.png"));
		lblChuaLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblChuaLogo.setBounds(517, 22, 406, 225);
		panelMenu.add(lblChuaLogo);
		
		/**
		 * Label chứa hình người dùng
		 */
		
		lblTaiKhoan = new JLabel("");
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setIcon(new ImageIcon("img\\user.png"));
		lblTaiKhoan.setBounds(1352, 22, 50, 50);
		panelMenu.add(lblTaiKhoan);
		
		/**
		 *label chứa hình nút đăng xuất
		 */
		lblHinhDangXuat = new JLabel("");
		lblHinhDangXuat.setIcon(new ImageIcon("img\\dangxuat.png"));
		lblHinhDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhDangXuat.setBounds(1370, 83, 25, 28);
		panelMenu.add(lblHinhDangXuat);
		
		/**
		 * Label chứa nút menu 
		 */
		lblMenu.setIcon(new ImageIcon("img\\menu.png"));

		lblMenu = new JLabel("");
		
		
		/**
		 * Label giờ
		 */
		
		lblGio = new JLabel("12:00");
		lblGio.setForeground(Color.WHITE);
		lblGio.setHorizontalAlignment(SwingConstants.CENTER);
		lblGio.setFont(new Font("Arial", Font.PLAIN, 36));
		lblGio.setBounds(1298, 129, 111, 34);
		ChucNang.setGio(lblGio);
		panelMenu.add(lblGio);
		
		
		
		panelNutBam.setBackground(Color.WHITE);
		panelNutBam.setBounds(0, 264, 1440, 760);
		contentPane.add(panelNutBam);
		panelNutBam.setLayout(null);

		btnQuanLyNhanVien = new CircleBtn("Quản Lý Nhân Viên");
		btnQuanLyNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLyNhanVien.setIcon(new ImageIcon("img\\nv.png"));
		btnQuanLyNhanVien.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLyNhanVien.setForeground(Color.WHITE);
		btnQuanLyNhanVien.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLyNhanVien.setBackground(new Color(245, 129, 25));
		btnQuanLyNhanVien.setBounds(49, 41, 407, 313);
		panelNutBam.add(btnQuanLyNhanVien);

		btnQuanLyHoaDon = new CircleBtn("Quản Lý Hóa Đơn");
		btnQuanLyHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLyHoaDon.setIcon(new ImageIcon("img\\hd.png"));
		btnQuanLyHoaDon.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLyHoaDon.setForeground(Color.WHITE);
		btnQuanLyHoaDon.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLyHoaDon.setBackground(new Color(245, 129, 25));
		btnQuanLyHoaDon.setBounds(518, 41, 407, 313);
		panelNutBam.add(btnQuanLyHoaDon);

		btnQuanLyLuong = new CircleBtn("Quản Lý Lương");
		btnQuanLyLuong.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLyLuong.setIcon(new ImageIcon("img\\l.png"));
		btnQuanLyLuong.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLyLuong.setForeground(Color.WHITE);
		btnQuanLyLuong.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLyLuong.setBackground(new Color(245, 129, 25));
		btnQuanLyLuong.setBounds(980, 41, 407, 313);
		panelNutBam.add(btnQuanLyLuong);

		btnQuanLySanPham = new CircleBtn("Quản Lý Sản Phẩm");
		btnQuanLySanPham.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLySanPham.setIcon(new ImageIcon("img\\sp.png"));
		btnQuanLySanPham.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLySanPham.setForeground(Color.WHITE);
		btnQuanLySanPham.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLySanPham.setBackground(new Color(245, 129, 25));
		btnQuanLySanPham.setBounds(518, 406, 407, 313);
		panelNutBam.add(btnQuanLySanPham);

		btnQuanLyDuLieu = new CircleBtn("Quản Lý Dữ Liệu");
		btnQuanLyDuLieu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuanLyDuLieu.setIcon(new ImageIcon("img\\database.png"));
		btnQuanLyDuLieu.setVerticalTextPosition(SwingConstants.TOP);
		btnQuanLyDuLieu.setForeground(Color.WHITE);
		btnQuanLyDuLieu.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnQuanLyDuLieu.setBackground(new Color(245, 129, 25));
		btnQuanLyDuLieu.setBounds(980, 406, 407, 313);
		panelNutBam.add(btnQuanLyDuLieu);

		btnThongKeThuChi = new CircleBtn("Thống Kê Thu Chi");
		btnThongKeThuChi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnThongKeThuChi.setIcon(new ImageIcon("img\\tk.png"));
		btnThongKeThuChi.setVerticalTextPosition(SwingConstants.TOP);
		btnThongKeThuChi.setForeground(Color.WHITE);
		btnThongKeThuChi.setFont(new Font("Calibri", Font.PLAIN, 36));
		btnThongKeThuChi.setBackground(new Color(245, 129, 25));
		btnThongKeThuChi.setBounds(49, 406, 407, 313);
		panelNutBam.add(btnThongKeThuChi);
		
		 
		/**
		 * Label chứa nút menu 
		 */
		lblMenu = new JLabel("");
		pnMenu = new Gui_Menu();
		temp = panelMenu.getBounds();
		temp1 = panelNutBam.getBounds(); 
		
		lblMenu.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\img\\menu.png"));
		lblMenu.setBounds(55, 36, 84, 83);
		panelMenu.add(lblMenu);
		
		/**
		 * Label chứa dòng chữ đăng xuất
		 */
		
		lblChuDangXuat = new JLabel("Đăng Xuất");
		lblChuDangXuat.setForeground(Color.WHITE);
		lblChuDangXuat.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblChuDangXuat.setHorizontalAlignment(SwingConstants.TRAILING);
		lblChuDangXuat.setBounds(1231, 83, 129, 36);
		panelMenu.add(lblChuDangXuat);
		
		/**
		 *  Sự kiện
		 */
		lblMenu.addMouseListener(this);
		lblChuDangXuat.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o.equals(lblMenu)) {
			if (panelMenu.getX() ==400) {
			  	this.remove(pnMenu);
		  		panelMenu.setBounds(temp); 
		  		panelNutBam.setBounds(temp1);
		  }
		  else { 		
		  		panelMenu.setBounds(400, 0, 1440 - 400, panelMenu.getHeight());
	  			panelNutBam.setBounds(400, panelNutBam.getY(), 1440 - 400, panelNutBam.getHeight()); 
	  			add(pnMenu); 
	  		} 
	  	}
		else if(o.equals(lblChuDangXuat)){
			//close();
			Gui_DangNhap s = new Gui_DangNhap();
			s.setLocationRelativeTo(null);
			s.setVisible(true);	
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Phương thức close
	 */
	private void close() {
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
