package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import gui_package.ChucNang;
import gui_package.RoundedPanel;

import java.awt.Font;


public class Gui_QuanLyTaiKhoan extends JPanel {
	private String[] colsnameLK = { "Tên Nhân Viên", "Tên Tài Khoản", "Mật Khẩu" };
	private DefaultTableModel modelTaiKhoan;
	private JPanel panel;
	private JLabel lblQLTK;
	private JLabel lblNgay;
	private JLabel lblGio;
	private JLabel lblLogoNV;
	private JPanel panelXoa;
	private JPanel panelTable;
	private JPanel panelThem;
	private JTable tblTaiKhoan;
	private JScrollPane scrollPane;
	private JPanel panelThongTin;


	public Gui_QuanLyTaiKhoan() {
		setSize(1600, 1046);
		setBackground(new Color(194, 93, 0));
		setLayout(null);
		/**
		 * Phần Trên chứa thanh menu và thanh bar ngang
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(242, 129, 25));
		panel.setBounds(0, 0, 1600, 100);
		add(panel);

		lblQLTK = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblQLTK.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblQLTK.setForeground(Color.WHITE);
		lblQLTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLTK.setBounds(499, 0, 601, 100);
		panel.add(lblQLTK);

		lblNgay = new JLabel("New label");
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setBounds(0, 16, 233, 33);
		panel.add(lblNgay);

		lblGio = new JLabel("New label");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(0, 50, 201, 42);
		panel.add(lblGio);

		ChucNang.setGio(lblGio, lblNgay);

		lblLogoNV = new JLabel("Chinh");
		lblLogoNV.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLogoNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogoNV.setForeground(Color.WHITE);
		lblLogoNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogoNV.setBounds(1393, 10, 192, 45);
		panel.add(lblLogoNV);

		/**
		 * Phần dưới chứa bảng
		 */
		panelTable = new JPanel();
		panelTable.setBackground(new Color(242, 129, 25));
		panelTable.setBounds(0, 173, 1600, 873);
		add(panelTable);
		panelTable.setLayout(null);

		panelThem = new JPanel();
		panelThem.setLayout(null);
		panelThem.setBounds(975, 20, 625, 415);
		panelTable.add(panelThem);
		
		new DefaultTableModel(colsnameLK, 0);
		
		tblTaiKhoan = new JTable(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null } }, colsnameLK)) {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int col) {
			switch (col) {
			default:
				return false;
			}
		}
	};
	tblTaiKhoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	tblTaiKhoan.setRowMargin(5);
	tblTaiKhoan.setRowHeight(30);
	tblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 24));
	
	JTableHeader headerTable2 = tblTaiKhoan.getTableHeader();
	headerTable2.setFont(new Font("Tahoma", Font.PLAIN, 24));
	headerTable2.setBackground(new Color(248, 198, 153));
	JScrollPane thanhCuon2 = new JScrollPane(tblTaiKhoan);
	thanhCuon2.setEnabled(false);
	thanhCuon2.setBounds(0, 20, 955, 500);
	thanhCuon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
	panelTable.add(thanhCuon2);
	
	JLabel lblThongTinTK = new JLabel("Thông Tin Tài Khoản");
	lblThongTinTK.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblThongTinTK.setForeground(Color.WHITE);
	lblThongTinTK.setBounds(0, 0, 366, 22);
	panelTable.add(lblThongTinTK);
	
	modelTaiKhoan = (DefaultTableModel) tblTaiKhoan.getModel();
	
	panelXoa = new JPanel();
	panelXoa.setBounds(975, 458, 625, 415);
	panelTable.add(panelXoa);
	panelXoa.setLayout(null);
	
	panelThongTin = new RoundedPanel();
	panelThongTin.setBounds(0, 541, 955, 332);
	panelThongTin.setBackground(new Color(248, 198, 153));
	panelTable.add(panelThongTin);
	panelThongTin.setLayout(null);

	}
}
