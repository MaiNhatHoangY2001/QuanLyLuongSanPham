package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import gui_package.ChucNang;
import gui_package.CircleBtn;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class Gui_SanPham extends JFrame implements ActionListener, MouseListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTable table;
	private DefaultTableModel model;

	private JTextField txtTimKiem;

	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;

	private JComboBox<String> cmbTimKiem;

	private JLabel lblIconDX;
	private JLabel lblDangXuat;
	private JPanel pnlHeader;
	private JPanel pnlNgang;
	private JPanel pnlCentent;
	private JLabel lblIconMenu;

	private Gui_Menu pnMenu;
	private Rectangle temp;
	private Rectangle temp2;
	private Rectangle temp3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_SanPham frame = new Gui_SanPham();
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
	public Gui_SanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		/**
		 * 	Phần đầu
		 */
		// Background header
		pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1424, 150);
		contentPane.add(pnlHeader);

		// Tiểu đề 
		JLabel lblTitile = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblTitile.setForeground(Color.WHITE);
		lblTitile.setFont(new Font("Arial", Font.BOLD, 60));
		lblTitile.setBounds(411, 38, 601, 73);
		pnlHeader.add(lblTitile);

		// Tài khoảng nhân viên
		JLabel lblTenTaiKhoang = new JLabel("Chinh");
		lblTenTaiKhoang.setForeground(Color.WHITE);
		lblTenTaiKhoang.setFont(new Font("Arial", Font.PLAIN, 36));
		lblTenTaiKhoang.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblTenTaiKhoang.setBounds(1246, 22, 90, 40);
		pnlHeader.add(lblTenTaiKhoang);
		
		JLabel lblIconUser = new JLabel("");
		Image imgUser = new ImageIcon("img\\user1.png").getImage();
		lblIconUser.setIcon(new ImageIcon(imgUser));
		lblIconUser.setBounds(1355, 22, 40, 40);
		pnlHeader.add(lblIconUser);

		// Đăng nhập
		lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDangXuat.setBounds(1246, 67, 110, 24);
		lblDangXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlHeader.add(lblDangXuat);
		
		lblIconDX = new JLabel("");
		Image imgDX = new ImageIcon("img\\dangxuat.png").getImage();
		lblIconDX.setIcon(new ImageIcon(imgDX));
		lblIconDX.setBounds(1370, 67, 25, 25);
		lblIconDX.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlHeader.add(lblIconDX);

		// Giờ
		JLabel lblGio = new JLabel("12:00");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Arial", Font.PLAIN, 36));
		lblGio.setBounds(1305, 96, 90, 36);
		pnlHeader.add(lblGio);
		ChucNang.setDiChuyenGD(this);
		ChucNang.setGio(lblGio);

		// Menu
		lblIconMenu = new JLabel("");
		Image imgMenu = new ImageIcon("img\\menu3.png").getImage();
		lblIconMenu.setIcon(new ImageIcon(imgMenu));
		lblIconMenu.setBounds(31, 43, 70, 64);
		lblIconMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlHeader.add(lblIconMenu);

		// Thanh ngang chia phần Header và phần Content
		pnlNgang = new JPanel();
		pnlNgang.setBounds(0, 150, 1424, 50);
		contentPane.add(pnlNgang);
		pnlNgang.setBackground(new Color(194, 93, 0));

		/**
		 * Phần Content
		 */
		// Banckground Content
		pnlCentent = new JPanel();
		pnlCentent.setLayout(null);
		pnlCentent.setBackground(new Color(242, 129, 25));
		pnlCentent.setBounds(0, 200, 1424, 785);
		contentPane.add(pnlCentent);

		/*
		 * Tabel
		 */
		// Thanh cuộn
		JScrollPane thanhCuon = new JScrollPane((Component) null);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon.setBounds(32, 11, 1365, 536);
		pnlCentent.add(thanhCuon);

		// modeltable
		String header[] = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Thành", "Nhà Cung Cấp", "Loại", "Nhà Sản Xuất" };
		model = new DefaultTableModel(header, 50);
		
		//table
		table = new JTable(model);
		table.setRowMargin(5);
		table.setRowHeight(30);
		JTableHeader headerTable = table.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		thanhCuon.setViewportView(table);

		/*
		 * 	Các nút chức năng
		 */
		// Title chức năng
		JLabel lblNewLabel = new JLabel("Chức Năng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(62, 558, 123, 31);
		pnlCentent.add(lblNewLabel);
		
		// Background Chức năng
		JPanel pnlChucNang = new RoundedPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBackground(new Color(248, 198, 153));
		pnlChucNang.setBounds(33, 588, 479, 174);
		pnlCentent.add(pnlChucNang);

		// Nút Xóa
		btnXoa = new CircleBtn("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXoa.setBackground(new Color(233, 180, 46));
		btnXoa.setBounds(55, 56, 157, 62);
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlChucNang.add(btnXoa);

		// Nút Sửa
		btnSua = new CircleBtn("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSua.setBackground(new Color(233, 180, 46));
		btnSua.setBounds(267, 56, 157, 62);
		btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlChucNang.add(btnSua);

		/*
		 * 	Phần tìm kiếm 
		 */
		// Title tìm kiếm
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setForeground(Color.WHITE);
		lblTmKim.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTmKim.setBounds(561, 558, 123, 31);
		pnlCentent.add(lblTmKim);
		
		// Background tìm kiếm 
		JPanel pnlTimKiem = new RoundedPanel();
		pnlTimKiem.setBounds(522, 588, 875, 174);
		pnlCentent.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBackground(new Color(248, 198, 153));

		// Combobox tìm kiếm 
		cmbTimKiem = new JComboBox<String>();
		cmbTimKiem.setModel(
				new DefaultComboBoxModel(new String[] { "Tìm kiếm theo mã sản phẩm", "Tìm kiếm theo tên sản phẩm" }));
		cmbTimKiem.setForeground(Color.WHITE);
		cmbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbTimKiem.setBackground(new Color(233, 180, 46));
		cmbTimKiem.setBounds(100, 29, 675, 41);
		pnlTimKiem.add(cmbTimKiem);

		// Jtextfield tìm kiếm 
		txtTimKiem = new RoundTextField("", 1000);
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(100, 99, 462, 46);
		pnlTimKiem.add(txtTimKiem);

		// Nút tìm kiếm 
		btnTimKiem = new CircleBtn("Tìm Kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnTimKiem.setBackground(new Color(233, 180, 46));
		btnTimKiem.setBounds(587, 99, 188, 46);
		btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlTimKiem.add(btnTimKiem);

		pnMenu = new Gui_Menu();
		temp = pnlHeader.getBounds();
		temp2 = pnlNgang.getBounds();
		temp3 = pnlCentent.getBounds();

		/**
		 * 	Thêm sự kiện
		 */
		lblIconMenu.addMouseListener(this);
		lblDangXuat.addMouseListener(this);
		lblIconDX.addMouseListener(this);
		btnSua.addActionListener(this);
		addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	/**
	 *	 Xác nhận thoát
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không", "Thông báo thoát",
				JOptionPane.YES_NO_OPTION);
		if (tl == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblIconDX) || o.equals(lblDangXuat)) { // Hiển thị From đăng nhập
			new Gui_DangNhap().setVisible(true);
		} else if (o.equals(lblIconMenu)) { // Hiển thị Menu
			if (pnlHeader.getX() == 400) {
				this.remove(pnMenu);
				pnlHeader.setBounds(temp);
				pnlNgang.setBounds(temp2);
				pnlCentent.setBounds(temp3);
			} else {
				pnlHeader.setBounds(400, 0, 1440 - 400, pnlHeader.getHeight());
				pnlNgang.setBounds(400, pnlNgang.getY(), 1440 - 400, pnlNgang.getHeight());
				pnlCentent.setBounds(400, pnlCentent.getY(), 1440 - 400, pnlCentent.getHeight());
				add(pnMenu);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnSua)) {
			new Gui_SuaThongTinSanPham().setVisible(true);
		}
	}

}
