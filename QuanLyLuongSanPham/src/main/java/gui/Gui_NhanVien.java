package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhanVienDao;
import gui_package.ChucNang;
import gui_package.CircleBtn;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Cursor;

public class Gui_NhanVien extends JFrame implements ActionListener, MouseListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlCentent;
	private JPanel pnlChucNang;
	private JPanel pnlTimKiem;
	private JPanel pnlHeader;
	private JPanel pnlNgang;

	private JLabel lblMenu;
	private JLabel lblDangXuat;
	private JLabel lblGio;
	private JLabel lblNewLabel;
	private JLabel lblIconUser;
	private JLabel lblIconDX;
	private JLabel lblTimKiem;

	private DefaultTableModel model;
	private JTable tblNhanVien;

	private JTextField txtTiemKiem;

	private JButton btnThem;
	private JButton btnSua;
	private JButton btnTimKiem;
	private JButton btnXoa;

	private JComboBox<String> cmbTimKiem;

	private Gui_Menu pnMenu;
	private Rectangle temp;
	private Rectangle temp2;
	private Rectangle temp3;
	private NhanVienDao daoNV;
	private List<NhanVien> listNV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_NhanVien frame = new Gui_NhanVien();
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
	public Gui_NhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		
		/**
		 * Phần đầu
		 */
		// BackGround Header
		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1424, 150);
		contentPane.add(pnlHeader);
		pnlHeader.setLayout(null);

		// Tiêu đề chính
		JLabel lblTitile = new JLabel("QU\u1EA2N L\u00DD NH\u00C2N VI\u00CAN");
		lblTitile.setForeground(Color.WHITE);
		lblTitile.setFont(new Font("Arial", Font.BOLD, 60));
		lblTitile.setBounds(406, 43, 612, 73);
		pnlHeader.add(lblTitile);

		// Tài khoảng
		JLabel lblTenTaiKhoang = new JLabel("Chinh");
		lblTenTaiKhoang.setForeground(Color.WHITE);
		lblTenTaiKhoang.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblTenTaiKhoang.setFont(new Font("Arial", Font.PLAIN, 36));
		lblTenTaiKhoang.setBounds(1246, 22, 90, 40);
		lblTenTaiKhoang.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlHeader.add(lblTenTaiKhoang);

		lblIconUser = new JLabel("");
		Image imgUser = new ImageIcon("img\\user1.png").getImage();
		lblIconUser.setIcon(new ImageIcon(imgUser));
		lblIconUser.setBounds(1355, 22, 40, 40);
		lblIconUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlHeader.add(lblIconUser);

		// Đăng xuất
		lblDangXuat = new JLabel("\u0110\u0103ng xu\u1EA5t");
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
		lblGio = new JLabel("12:00");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Arial", Font.PLAIN, 36));
		lblGio.setBounds(1305, 96, 90, 36);
		pnlHeader.add(lblGio);
		ChucNang.setDiChuyenGD(this);
		ChucNang.setGio(lblGio);

		// Menu
		lblMenu = new JLabel("");
		Image imgMenu = new ImageIcon("img\\menu3.png").getImage();
		lblMenu.setIcon(new ImageIcon(imgMenu));
		lblMenu.setBounds(31, 43, 70, 64);
		lblMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlHeader.add(lblMenu);

		// Đường ngang cách giữa Header và Content
		pnlNgang = new JPanel();
		pnlNgang.setBackground(new Color(194, 93, 0));
		pnlNgang.setBounds(0, 150, 1424, 50);
		contentPane.add(pnlNgang);

		/**
		 * Nội dung chính
		 */

		pnlCentent = new JPanel();
		pnlCentent.setBounds(0, 200, 1424, 785);
		pnlCentent.setBackground(new Color(242, 129, 25));
		contentPane.add(pnlCentent);
		pnlCentent.setLayout(null);

		/*
		 * Phần Bảnh Nhân Viên
		 */
		// modelTable
		String header[] = { "MSNV", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "SĐT", "Chức Vụ", "Email" };
		model = new DefaultTableModel(header, 50);

		// table
		tblNhanVien = new JTable(model);
		tblNhanVien.setRowMargin(5);
		tblNhanVien.setRowHeight(30);
		tblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));

		// Tiêu để của bảng
		JTableHeader headerTable = tblNhanVien.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 22));
		headerTable.setBackground(new Color(248, 198, 153));

		// Thanh cuộn
		JScrollPane thanhCuon = new JScrollPane(tblNhanVien);
		thanhCuon.setBounds(31, 11, 1365, 536);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlCentent.add(thanhCuon);

		/*
		 * Phần chức năng
		 */
		// Background Chức năng
		pnlChucNang = new RoundedPanel();
		pnlChucNang.setBackground(new Color(248, 198, 153));
		pnlChucNang.setBounds(31, 589, 629, 174);
		pnlCentent.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		// Nút Xóa
		btnXoa = new CircleBtn("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXoa.setBackground(new Color(233, 180, 46));
		btnXoa.setBounds(235, 56, 157, 62);
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlChucNang.add(btnXoa);

		// Nút thêm
		btnThem = new CircleBtn("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setBackground(new Color(233, 180, 46));
		btnThem.setBounds(39, 56, 157, 62);
		btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlChucNang.add(btnThem);

		// Nút sửa
		btnSua = new CircleBtn("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSua.setBackground(new Color(233, 180, 46));
		btnSua.setBounds(431, 56, 157, 62);
		btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlChucNang.add(btnSua);

		// title Chưc năng
		lblNewLabel = new JLabel("Chức Năng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(54, 558, 117, 29);
		pnlCentent.add(lblNewLabel);

		/*
		 * Phần tìm kiếm
		 */
		// Background tìm kiếm
		pnlTimKiem = new RoundedPanel();
		pnlTimKiem.setBackground(new Color(248, 198, 153));
		pnlTimKiem.setBounds(670, 589, 726, 174);
		pnlCentent.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		// Combobox loại
		String str[] = { "Tìm kiếm theo tên nhân viên", "Tìm kiếm theo năm sinh" };
		cmbTimKiem = new JComboBox<String>(str);
		cmbTimKiem.setBackground(new Color(233, 180, 46));
		cmbTimKiem.setForeground(Color.WHITE);
		cmbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbTimKiem.setBounds(50, 33, 628, 41);
		pnlTimKiem.add(cmbTimKiem);

		// Textfield Tìm Kiếm
		txtTiemKiem = new RoundTextField("", 1000);
		txtTiemKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTiemKiem.setBounds(50, 101, 477, 48);
		pnlTimKiem.add(txtTiemKiem);
		txtTiemKiem.setColumns(10);

		// Nút Tìm kiếm
		btnTimKiem = new CircleBtn("Tìm kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimKiem.setBackground(new Color(233, 180, 46));
		btnTimKiem.setBounds(543, 101, 135, 48);
		btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlTimKiem.add(btnTimKiem);

		lblTimKiem = new JLabel("Tìm Kiếm");
		lblTimKiem.setForeground(Color.WHITE);
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTimKiem.setBounds(694, 558, 105, 29);
		pnlCentent.add(lblTimKiem);

		pnMenu = new Gui_Menu();
		temp = pnlHeader.getBounds();
		temp2 = pnlNgang.getBounds();
		temp3 = pnlCentent.getBounds();

		/**
		 * Các sự kiện
		 */
		lblMenu.addMouseListener(this);
		lblDangXuat.addMouseListener(this);
		lblIconDX.addMouseListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		addWindowListener(this);
		
		/**
		 * 	Kết nối DAO và thực hiện các thao tác
		 */
//		daoNV = new NhanVienDao();
//		listNV = daoNV.getAllNhanVien();
//		
//		// Thêm dữ liệu vào bảng Nhân viên
//		themThongTinNhanVienVaoBang(listNV);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblIconDX) || o.equals(lblDangXuat)) { // Hiển thị From đăng nhập
			new Gui_DangNhap().setVisible(true);
		} else if (o.equals(lblMenu)) { // Hiển thị Menu
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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) // Hiển thị From Thêm nhân viên
			new Gui_ThemNhanVien().setVisible(true);

		else if (o.equals(btnSua)) // Hiển thị From Sửa thông tin nhân viên
			new Gui_SuaNhanVien().setVisible(true);
	}
	
	/*
	 * Xác nhận thoát
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không", "Thông báo thoát",
				JOptionPane.YES_NO_OPTION);
		if (tl == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	/**
	 * Thêm tất cả nhân viên vào bảng 
	 * @param listNV2
	 */
	private void themThongTinNhanVienVaoBang(List<NhanVien> list) {
		ChucNang.clearDataTable(model);
		//isGioiTinh chưa tạo
//		for (NhanVien nv : list) {
//	String n[] = {nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh() + "", nv.isGioiTinh() == true ? "Nam":"Nữ", nv.getsDT(), nv.gettrangThaiLamViec() == true ? "Đang làm" : "Đã nghĩ", nv.getEmail()};
//			model.addRow(n);
//		}
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
	public void windowOpened(WindowEvent e) {

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

}
