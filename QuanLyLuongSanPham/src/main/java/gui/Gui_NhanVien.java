package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import gui_package.CircleBtn;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class Gui_NhanVien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbliconMenu;
	private JLabel lblDangXuat;
	private JLabel lblGio;
	private JPanel pnlCentent;
	private DefaultTableModel model;
	private JPanel pnlChucNang;
	private JLabel lblNewLabel;
	private JTable tblNhanVien;
	private JPanel pnlTimKiem;
	private JLabel lblNewLabel_1;
	private JButton btnThem;
	private JButton btnSua;
	private JTextField txtTiemKiem;
	private JButton btnSua_1;
	private JComboBox comboBox;
	private JButton btnXoa;
	private JLabel lblIconUser;
	private JLabel lblIconDX;

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

		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1424, 150);
		contentPane.add(pnlHeader);
		pnlHeader.setLayout(null);

		JLabel lblTitile = new JLabel("QU\u1EA2N L\u00DD NH\u00C2N VI\u00CAN");
		lblTitile.setForeground(Color.WHITE);
		lblTitile.setFont(new Font("Arial", Font.BOLD, 60));
		lblTitile.setBounds(406, 43, 612, 73);
		pnlHeader.add(lblTitile);

		JLabel lblTenTaiKhoang = new JLabel("Chinh");
		lblTenTaiKhoang.setForeground(Color.WHITE);
		lblTenTaiKhoang.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblTenTaiKhoang.setFont(new Font("Arial", Font.PLAIN, 36));
		lblTenTaiKhoang.setBounds(1246, 22, 90, 40);
		pnlHeader.add(lblTenTaiKhoang);

		lblDangXuat = new JLabel("\u0110\u0103ng xu\u1EA5t");
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDangXuat.setBounds(1246, 67, 110, 24);
		pnlHeader.add(lblDangXuat);

		lblGio = new JLabel("12:00");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Arial", Font.PLAIN, 36));
		lblGio.setBounds(1305, 96, 90, 36);
		pnlHeader.add(lblGio);
		
		JLabel lblIconMenu = new JLabel("");
		Image imgMenu = new ImageIcon("img\\menu3.png").getImage();
		lblIconMenu.setIcon(new ImageIcon(imgMenu));
		lblIconMenu.setBounds(31, 43, 70, 64);
		pnlHeader.add(lblIconMenu);
		
		lblIconUser = new JLabel("");
		Image imgUser = new ImageIcon("img\\user1.png").getImage();
		lblIconUser.setIcon(new ImageIcon(imgUser));
		lblIconUser.setBounds(1355, 22, 40, 40);
		pnlHeader.add(lblIconUser);
		
		lblIconDX = new JLabel("");
		Image imgDX = new ImageIcon("img\\dangxuat.png").getImage();
		lblIconDX.setIcon(new ImageIcon(imgDX));
		lblIconDX.setBounds(1370, 67, 25, 25);
		pnlHeader.add(lblIconDX);

		JPanel pnlNgang = new JPanel();
		pnlNgang.setBackground(new Color(194, 93, 0));
		pnlNgang.setBounds(0, 150, 1424, 50);
		contentPane.add(pnlNgang);

		pnlCentent = new JPanel();
		pnlCentent.setBounds(0, 200, 1424, 785);
		pnlCentent.setBackground(new Color(242, 129, 25));
		contentPane.add(pnlCentent);
		pnlCentent.setLayout(null);

		String header[] = { "Mã Nhân viên", "Tên Nhân Viên", "Địa Chỉ", "SĐT", "Chức vụ", "Email", "Ngày Sinh" };
		model = new DefaultTableModel(header, 0);
		tblNhanVien = new JTable(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Nh\u00E2n vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "\u0110\u1ECBa Ch\u1EC9",
						"S\u0110T", "Ch\u1EE9c v\u1EE5", "Email", "Ng\u00E0y Sinh" }));
		tblNhanVien.setRowMargin(5);
		tblNhanVien.setRowHeight(30);
		tblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JTableHeader headerTable = tblNhanVien.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon = new JScrollPane(tblNhanVien);
		thanhCuon.setBounds(31, 11, 1365, 536);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlCentent.add(thanhCuon);

		pnlChucNang = new RoundedPanel();
		pnlChucNang.setBackground(new Color(248, 198, 153));
		pnlChucNang.setBounds(31, 589, 629, 174);
		pnlCentent.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		btnXoa = new CircleBtn("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXoa.setBackground(new Color(233, 180, 46));
		btnXoa.setBounds(235, 56, 157, 62);
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlChucNang.add(btnXoa);

		btnThem = new CircleBtn("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setBackground(new Color(233, 180, 46));
		btnThem.setBounds(39, 56, 157, 62);
		btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlChucNang.add(btnThem);

		btnSua = new CircleBtn("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSua.setBackground(new Color(233, 180, 46));
		btnSua.setBounds(431, 56, 157, 62);
		btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlChucNang.add(btnSua);

		lblNewLabel = new JLabel("Chức Năng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(54, 558, 117, 29);
		pnlCentent.add(lblNewLabel);

		pnlTimKiem = new RoundedPanel();
		pnlTimKiem.setBackground(new Color(248, 198, 153));
		pnlTimKiem.setBounds(670, 589, 726, 174);
		pnlCentent.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		String str[] = { "Tìm kiếm theo tên nhân viên", "Tìm kiếm theo năm sinh"};
		comboBox = new JComboBox(str);
		comboBox.setBackground(new Color(233, 180, 46));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(50, 33, 628, 41);
		pnlTimKiem.add(comboBox);

		txtTiemKiem = new RoundTextField("", 1000);
		txtTiemKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTiemKiem.setBounds(50, 101, 477, 48);
		pnlTimKiem.add(txtTiemKiem);
		txtTiemKiem.setColumns(10);

		btnSua_1 = new CircleBtn("Sửa");
		btnSua_1.setForeground(Color.WHITE);
		btnSua_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua_1.setBackground(new Color(233, 180, 46));
		btnSua_1.setBounds(543, 101, 135, 48);
		btnSua_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlTimKiem.add(btnSua_1);

		lblNewLabel_1 = new JLabel("Tìm Kiếm");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(694, 558, 105, 29);
		pnlCentent.add(lblNewLabel_1);

	}

}
