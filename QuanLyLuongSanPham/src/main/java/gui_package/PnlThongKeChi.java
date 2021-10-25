package gui_package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PnlThongKeChi extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tblTienThu, tblSanPham;
	private JTextField txtSrc;
	private String[] colsnameTK = { "Tháng", "Số tiền nhập hàng", "Lương nhân viên", "Khác", "Tổng tiền" };
	private String[] colsnameLK = { "Các khoản chi", "Số tiền" };
	private JComboBox<String> cboLoaiTep;
	private JButton btnSrc;
	private JButton btnIn;
	private JSpinner spinner;
	private JComboBox<String> cboTimKiemBox;
	private JPanel pnlTimKiem;
	private JTextField txtTimKiem;
	private JButton btnTimKiem;
	private JLabel lblNewLabel;
	
	public PnlThongKeChi() {
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		/**
		 * Chọn ngày để hiện thông tin (tháng/năm)
		 */

		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setBounds(1316, 5, 59, 40);
		add(spinner);

		/**
		 * Bảng thống kê số tiền đã chi ra tại cửa hàng
		 */
		new DefaultTableModel(colsnameTK, 0);
		tblTienThu = new JTable(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
								{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
								{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
								{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, },
						colsnameTK));
		tblTienThu.setRowMargin(5);
		tblTienThu.setRowHeight(30);
		tblTienThu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblTienThu.setToolTipText(
				"Bảng thống kê số tiền đã chi ra tại cửa hàng theo ngày (chọn 1 ngày để biết chi tiết sản phẩm)");
		JTableHeader headerTable1 = tblTienThu.getTableHeader();
		headerTable1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable1.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon1 = new JScrollPane(tblTienThu);
		thanhCuon1.setBounds(23, 60, 1380, 181);
		thanhCuon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon1.setToolTipText(
				"Bảng thống kê số tiền đã thu được tại cửa hàng theo ngày (chọn 1 ngày để biết chi tiết sản phẩm)");
		add(thanhCuon1);

		/**
		 * Bảng liệt kê các khoản chi của 1 ngày được chọn trong bảng trên
		 */
		new DefaultTableModel(colsnameLK, 0);
		tblSanPham = new JTable(new DefaultTableModel(new Object[][] { { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null } }, colsnameLK));
		tblSanPham.setRowMargin(5);
		tblSanPham.setRowHeight(30);
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblSanPham.setToolTipText("Bảng liệt kê các khoản chi của 1 ngày được chọn trong bảng trên");
		JTableHeader headerTable2 = tblSanPham.getTableHeader();
		headerTable2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable2.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon2 = new JScrollPane(tblSanPham);
		thanhCuon2.setBounds(23, 265, 640, 480);
		thanhCuon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon2.setToolTipText("Bảng liệt kê các khoản chi của 1 ngày được chọn trong bảng trên");
		add(thanhCuon2);

		/**
		 * Tìm kiếm theo thống kê
		 */
		pnlTimKiem = new RoundedPanel();
		pnlTimKiem.setBackground(new Color(248, 198, 153));
		pnlTimKiem.setBounds(673, 299, 726, 174);
		pnlTimKiem.setLayout(null);
		add(pnlTimKiem);

		String str[] = { "Tìm kiếm theo tháng", "Tìm kiếm dữ liệu lớn hơn tổng tiền",
				"Tìm kiếm dữ liệu nhỏ hơn tổng tiền" };
		cboTimKiemBox = new JComboBox<String>(str);
		cboTimKiemBox.setBackground(new Color(233, 180, 46));
		cboTimKiemBox.setForeground(Color.WHITE);
		cboTimKiemBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiemBox.setBounds(175, 41, 496, 41);
		pnlTimKiem.add(cboTimKiemBox);

		txtTimKiem = new RoundTextField("", 1000);
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(175, 104, 358, 43);
		txtTimKiem.setToolTipText("Nhập dữ liệu để tìm kiếm");
		pnlTimKiem.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnTimKiem = new CircleBtn("Tìm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimKiem.setBackground(new Color(233, 180, 46));
		btnTimKiem.setBounds(543, 101, 135, 48);
		btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlTimKiem.add(btnTimKiem);
		
		JLabel lblLoiTmKim = new JLabel("Loại tìm kiếm: ");
		lblLoiTmKim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoiTmKim.setBounds(31, 41, 134, 44);
		pnlTimKiem.add(lblLoiTmKim);
		
		JLabel lblLoaiTep_2 = new JLabel("Tìm kiếm:");
		lblLoaiTep_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiTep_2.setBounds(31, 103, 134, 44);
		pnlTimKiem.add(lblLoaiTep_2);

		JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(692, 266, 105, 29);
		add(lblNewLabel_1);
		/**
		 * In
		 */
		JPanel pnlIn = new RoundedPanel();
		pnlIn.setLayout(null);
		pnlIn.setBackground(new Color(248, 198, 153));
		pnlIn.setBounds(673, 530, 726, 215);
		add(pnlIn);

		btnIn = new CircleBtn("In");
		btnIn.setForeground(Color.WHITE);
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIn.setBackground(new Color(233, 180, 46));
		btnIn.setBounds(262, 251, 177, 44);
		btnIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlIn.add(btnIn);

		cboLoaiTep = new JComboBox<String>();
		cboLoaiTep.setModel(new DefaultComboBoxModel<String>(new String[] { "Excel", "Notepad" }));

		cboLoaiTep.setForeground(Color.WHITE);
		cboLoaiTep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiTep.setBackground(new Color(233, 180, 46));
		cboLoaiTep.setBounds(178, 57, 496, 41);
		pnlIn.add(cboLoaiTep);

		JLabel lblLoaiTep = new JLabel("Loại tệp tin: ");
		lblLoaiTep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiTep.setBounds(31, 55, 134, 44);
		pnlIn.add(lblLoaiTep);

		JLabel lblURL = new JLabel("Đường dẫn: ");
		lblURL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblURL.setBounds(31, 119, 134, 44);
		pnlIn.add(lblURL);

		txtSrc = new RoundTextField("", 1000);
		txtSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSrc.setBounds(178, 120, 435, 43);
		pnlIn.add(txtSrc);
		txtSrc.setColumns(10);

		btnSrc = new CircleBtn("...");
		btnSrc.setForeground(Color.WHITE);
		btnSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSrc.setBackground(new Color(233, 180, 46));
		btnSrc.setBounds(623, 119, 51, 44);
		btnSrc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlIn.add(btnSrc);
		
		lblNewLabel = new JLabel("In");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(692, 500, 105, 29);
		add(lblNewLabel);
	}
}
