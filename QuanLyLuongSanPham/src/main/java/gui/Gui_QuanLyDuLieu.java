package gui;


import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui_package.ChucNang;
import gui_package.CircleBtn;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Gui_QuanLyDuLieu extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JLabel lblMenu;
	private JLabel lblQLDL;
	private JPanel panelNgang;
	private JPanel panelSaoLuu;
	private RoundedPanel panelPhucHoi;
	private JPanel panelChucNang;
	private JLabel lblSaoLuu;
	private JLabel lblPhucHoi;
	private JTextField textFieldSaoLuu;
	private JLabel lblDuongDan;
	private JButton btnChonDuongDan;
	private CircleBtn btnSaoLuu;
	private RoundTextField textFieldPhucHoi;
	private JLabel lblDuongDan_1;
	private CircleBtn btnChonDuongDan2;
	private CircleBtn btnPhucHoi;
	private Gui_Menu pnMenu;
	private Rectangle temp;
	private Rectangle temp1;
	private Rectangle temp2;
	private JLabel lblChuDangXuat;
	private JLabel lblHinhDangXuat;
	private JLabel lblHinhNhanVien;
	private JLabel lblTenNhanVien;
	private JLabel lblGio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_QuanLyDuLieu frame = new Gui_QuanLyDuLieu();
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
	public Gui_QuanLyDuLieu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 1024);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 *  panel chứa menu
		 */
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(245	, 129, 25));
		panelMenu.setBounds(0, 0, 1424, 150);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
	
		lblMenu = new JLabel("Logo");
		lblMenu.setIcon(new ImageIcon("img\\menu.png"));
		lblMenu.setBounds(55, 36, 84, 83);
		panelMenu.add(lblMenu);
		
		lblQLDL = new JLabel("QUẢN LÝ DỮ LIỆU");
		lblQLDL.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLDL.setForeground(Color.WHITE);
		lblQLDL.setFont(new Font("Calibri", Font.BOLD, 60));
		lblQLDL.setBounds(324, 0, 800, 150);
		panelMenu.add(lblQLDL);
		
		/**
		 *  panel thanh ngang chia màn hình
		 *  
		 */
		
		panelNgang = new JPanel();
		panelNgang.setBounds(0, 150, 1424, 50);
		panelNgang.setLayout(null);
		panelNgang.setBackground(new Color(194, 93, 0));
		contentPane.add(panelNgang);
		
		
		/**
		 *  panel chức năng
		 *  
		 */
		
		panelChucNang = new JPanel();
		panelChucNang.setLayout(null);
		panelChucNang.setBackground(new Color(245, 129, 25));
		panelChucNang.setBounds(0, 0, 1424, 985);
		contentPane.add(panelChucNang);
		
		panelSaoLuu = new RoundedPanel();
		panelSaoLuu.setBackground(new Color(248, 198, 153));
		panelSaoLuu.setBounds(60, 266, 1320, 315);
		panelChucNang.add(panelSaoLuu);
		panelSaoLuu.setLayout(null);
		
		textFieldSaoLuu = new RoundTextField("",1000);
		textFieldSaoLuu.setBounds(301, 113, 720, 46);
		panelSaoLuu.add(textFieldSaoLuu);
		textFieldSaoLuu.setColumns(10);
		
		lblDuongDan = new JLabel("Chọn Đường Dẫn: ");
		lblDuongDan.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuongDan.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblDuongDan.setBounds(46, 113, 202, 46);
		panelSaoLuu.add(lblDuongDan);
		
		/**
		 * 
		 *  nút chọn đường dẫn sao lưu
		 * 
		 */
		
		btnChonDuongDan = new CircleBtn(". . .");
		btnChonDuongDan.setBackground(new Color(233, 180, 46));
		btnChonDuongDan.setBounds(1088, 113, 52, 46);
		panelSaoLuu.add(btnChonDuongDan);
		
		/**
		 *  
		 *  Nút sao lưu
		 *  
		 */
		
		btnSaoLuu = new CircleBtn("Sao Lưu");
		btnSaoLuu.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSaoLuu.setBackground(new Color(233, 180, 46));
		btnSaoLuu.setBounds(566, 205, 188, 54);
		btnSaoLuu.setFont(new Font("Calibri", Font.PLAIN, 30));
		panelSaoLuu.add(btnSaoLuu);
		
		/**
		 *  
		 *  panel phục hồi
		 *  
		 */
		
		panelPhucHoi = new RoundedPanel();
		panelPhucHoi.setLayout(null);
		panelPhucHoi.setBackground(new Color(248, 198, 153));
		panelPhucHoi.setBounds(60, 634, 1320, 315);
		panelChucNang.add(panelPhucHoi);
		
		lblDuongDan_1 = new JLabel("Chọn Tệp Tin: ");
		lblDuongDan_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuongDan_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblDuongDan_1.setBounds(52, 113, 202, 46);
		panelPhucHoi.add(lblDuongDan_1);
		
		textFieldPhucHoi = new RoundTextField("", 1000);
		textFieldPhucHoi.setBounds(301, 113, 720, 46);
		panelPhucHoi.add(textFieldPhucHoi);
		
		/**
		 * 
		 * Nút phục hồi
		 * 
		 */
		
		btnPhucHoi = new CircleBtn("Phục Hồi");
		btnPhucHoi.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPhucHoi.setBounds(573, 212, 188, 54);
		btnPhucHoi.setBackground(new Color(233, 180, 46));
		btnPhucHoi.setFont(new Font("Calibri", Font.PLAIN, 30));
		panelPhucHoi.add(btnPhucHoi);
		
		/**
		 * 
		 *  nút chọn đường dẫn phục hồi
		 * 
		 */
		
		btnChonDuongDan2 = new CircleBtn(". . .");
		btnChonDuongDan2.setBounds(1088, 113, 52, 46);
		btnChonDuongDan2.setBackground(new Color(233, 180, 46));
		btnChonDuongDan2.setBounds(1088, 113, 52, 46);
		panelPhucHoi.add(btnChonDuongDan2);
		
		
		
		/**
		 *  Label sao lưu và phục hồi
		 *  
		 *  
		 */
		
		lblSaoLuu = new JLabel("Sao Lưu");
		lblSaoLuu.setVerticalAlignment(SwingConstants.TOP);
		lblSaoLuu.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaoLuu.setForeground(Color.WHITE);
		lblSaoLuu.setFont(new Font("Calibri", Font.BOLD, 30));
		lblSaoLuu.setBounds(70, 234, 210, 28);
		panelChucNang.add(lblSaoLuu);
		
		lblPhucHoi = new JLabel("Phục Hồi");
		lblPhucHoi.setVerticalAlignment(SwingConstants.TOP);
		lblPhucHoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhucHoi.setForeground(Color.WHITE);
		lblPhucHoi.setFont(new Font("Calibri", Font.BOLD, 30));
		lblPhucHoi.setBounds(70, 602, 210, 28);
		panelChucNang.add(lblPhucHoi);
		
		/**
		 * Label chứa dòng chữ đăng xuất
		 */
		
		lblChuDangXuat = new JLabel("Đăng Xuất");
		lblChuDangXuat.setForeground(Color.WHITE);
		lblChuDangXuat.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblChuDangXuat.setHorizontalAlignment(SwingConstants.TRAILING);
		lblChuDangXuat.setBounds(1237, 65, 129, 36);
		panelMenu.add(lblChuDangXuat);
		
		/**
		 *label chứa hình nút đăng xuất
		 */
		lblHinhDangXuat = new JLabel("");
		lblHinhDangXuat.setIcon(new ImageIcon("img\\dangxuat.png"));
		lblHinhDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhDangXuat.setBounds(1376, 65, 25, 28);
		panelMenu.add(lblHinhDangXuat);
		
		
		
		/**
		 *label chứa hình nhân vien
		 * 
		 */
		lblHinhNhanVien = new JLabel("");
		lblHinhNhanVien.setIcon(new ImageIcon("img\\user1.png"));
		lblHinhNhanVien.setBounds(1355, 14, 46, 40);
		panelMenu.add(lblHinhNhanVien);
		
		lblTenNhanVien = new JLabel("Chinh");
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNhanVien.setForeground(Color.WHITE);
		lblTenNhanVien.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTenNhanVien.setBounds(1237, 18, 104, 36);
		panelMenu.add(lblTenNhanVien);
		
		/**
		 * Label giờ
		 */
		
		lblGio = new JLabel("12:00");
		lblGio.setForeground(Color.WHITE);
		lblGio.setHorizontalAlignment(SwingConstants.CENTER);
		lblGio.setFont(new Font("Arial", Font.PLAIN, 36));
		lblGio.setBounds(1290, 104, 111, 34);
//		ChucNang.setGio(lblGio);
		panelMenu.add(lblGio);
	
		
		temp = panelMenu.getBounds();
		temp1 = panelNgang.getBounds();
		temp2 = panelChucNang.getBounds();
		pnMenu = new Gui_Menu();
		
		/**
		 *  Sự kiện
		 * 
		 */
		lblMenu.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o.equals(lblMenu)) {
			if (panelMenu.getX() ==400) {
			  	this.remove(pnMenu);
		  		panelMenu.setBounds(temp); 
		  		panelNgang.setBounds(temp1);
		  		panelChucNang.setBounds(temp2);
		  }
		  else { 		
		  		panelMenu.setBounds(400, 0, 1440 - 400, panelMenu.getHeight());
	  			panelNgang.setBounds(400, panelNgang.getY(), 1440 - 400, panelNgang.getHeight()); 
	  			panelChucNang.setBounds(400, panelChucNang.getY(), 1440 - 400, panelChucNang.getHeight()); 
	  			getContentPane().add(pnMenu); 
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
}

