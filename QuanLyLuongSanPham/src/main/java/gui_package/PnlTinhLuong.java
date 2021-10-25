package gui_package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import dao.BangLuongDao;
import dao.NhanVienDao;
import model.BangLuong;
import model.NhanVien;

public class PnlTinhLuong extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblTinhLuong;
	private JTextField txtSrc;
	private String[] colsname = { "Mã nhân viên", "Tên nhân viên", "Mức lương", "Hệ số lương", "Tổng tiền sản phẩm",
			"Số ngày công", "Tiền lương" };
	private JComboBox cboLoaiTep;
	private JButton btnSrc;
	private JButton btnIn;
	private JYearChooser spnYear;
	private JMonthChooser cboMonth;
	private String[] colsnameLK = { "Tên sản phẩm", "Số lượng", "Thành tiền" };
	private JTable tblSanPham;
	private DefaultTableModel modelTinhLuong, modelSanPham;

	public PnlTinhLuong() {
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		/**
		 * Chọn ngày để hiện thông tin (tháng/năm)
		 */
		cboMonth = new JMonthChooser();
		cboMonth.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMonth.setBounds(1160, 5, 140, 40);
		add(cboMonth);

		spnYear = new JYearChooser();
		spnYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnYear.setBounds(1316, 5, 65, 40);
		add(spnYear);

		/**
		 * Bảng lương của các nhân viên trong tháng (cột số ngày công có thể chỉnh sửa)
		 */
		new DefaultTableModel(colsname, 0);
		tblTinhLuong = new JTable(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null } },
				colsname)) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col) {
				switch (col) {
				case 5:
					return true;
				default:
					return false;
				}
			}
		};
		tblTinhLuong.setRowMargin(5);
		tblTinhLuong.setRowHeight(30);
		tblTinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblTinhLuong.setToolTipText("Bảng lương của các nhân viên trong tháng (cột số ngày công có thể chỉnh sửa)");
		JTableHeader headerTable = tblTinhLuong.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon = new JScrollPane(tblTinhLuong);
		thanhCuon.setBounds(23, 60, 1380, 328);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon.setToolTipText("Bảng lương của các nhân viên trong tháng (cột số ngày công có thể chỉnh sửa)");

		TableColumn column = tblTinhLuong.getColumnModel().getColumn(5);
		column.setCellRenderer(new CustomTable(new Color(255, 232, 210), Color.BLACK));

		add(thanhCuon);

		/**
		 * Bảng liệt kê sản phẩm của 1 nhân viên bán hàng được chọn trong bảng trên (nếu
		 * là nhân viên hành chánh thì sẽ trống)
		 */

		new DefaultTableModel(colsnameLK, 0);
		tblSanPham = new JTable(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
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

		tblSanPham.setRowMargin(5);
		tblSanPham.setRowHeight(30);
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblSanPham.setToolTipText(
				"Bảng liệt kê sản phẩm của 1 nhân viên bán hàng được chọn trong bảng trên (nếu là nhân viên hành chánh thì sẽ trống)");
		JTableHeader headerTable2 = tblSanPham.getTableHeader();
		headerTable2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable2.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon2 = new JScrollPane(tblSanPham);
		thanhCuon2.setEnabled(false);
		thanhCuon2.setBounds(23, 420, 676, 331);
		thanhCuon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon2.setToolTipText(
				"Bảng liệt kê sản phẩm của của 1 nhân viên bán hàng được chọn trong bảng trên (nếu là nhân viên hành chánh thì sẽ trống)");
		modelTinhLuong = (DefaultTableModel) tblTinhLuong.getModel();
		add(thanhCuon2);
		/**
		 * In
		 */
		JPanel pnlIn = new RoundedPanel();
		pnlIn.setLayout(null);
		pnlIn.setBackground(new Color(248, 198, 153));
		pnlIn.setBounds(790, 420, 608, 331);
		add(pnlIn);

		btnIn = new CircleBtn("In");
		btnIn.setForeground(Color.WHITE);
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIn.setBackground(new Color(233, 180, 46));
		btnIn.setBounds(262, 251, 177, 44);
		btnIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlIn.add(btnIn);

		cboLoaiTep = new JComboBox();
		cboLoaiTep.setModel(new DefaultComboBoxModel(new String[] { "Excel", "Notepad" }));

		cboLoaiTep.setForeground(Color.WHITE);
		cboLoaiTep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiTep.setBackground(new Color(233, 180, 46));
		cboLoaiTep.setBounds(178, 94, 400, 41);
		pnlIn.add(cboLoaiTep);

		JLabel lblLoaiTep = new JLabel("Loại tệp tin: ");
		lblLoaiTep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiTep.setBounds(34, 92, 134, 44);
		pnlIn.add(lblLoaiTep);

		JLabel lblInBangLuong = new JLabel("In bảng lương");
		lblInBangLuong.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInBangLuong.setBounds(24, 11, 268, 42);
		pnlIn.add(lblInBangLuong);

		JLabel lblURL = new JLabel("Đường dẫn: ");
		lblURL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblURL.setBounds(34, 161, 134, 44);
		pnlIn.add(lblURL);

		txtSrc = new RoundTextField("", 1000);
		txtSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSrc.setBounds(178, 163, 345, 43);
		pnlIn.add(txtSrc);
		txtSrc.setColumns(10);

		btnSrc = new CircleBtn("...");
		btnSrc.setForeground(Color.WHITE);
		btnSrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSrc.setBackground(new Color(233, 180, 46));
		btnSrc.setBounds(533, 161, 51, 44);
		btnSrc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlIn.add(btnSrc);

		/**
		 * Đổ dữ liệu vào table
		 */

		setDataTableBangLuong(cboMonth.getMonth(), spnYear.getYear());

		/**
		 * sự kiện cboMonth
		 */
		cboMonth.addPropertyChangeListener("month", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {

				setDataTableBangLuong((Integer)evt.getNewValue() + 1, spnYear.getYear());
			}
		});
	}

	/**
	 * Đổ dữ liệu vào table bảng lương
	 */
	public void setDataTableBangLuong(int month, int year) {
		ChucNang.clearDateTable(modelTinhLuong);
		BangLuongDao bangLuongDao = new BangLuongDao();
		NhanVienDao nhanVienDao = new NhanVienDao();

		List<NhanVien> listNhanVien = new ArrayList<>();
		List<BangLuong> listBangLuong = new ArrayList<>();

		listNhanVien = nhanVienDao.getAllNhanVien();

		for (NhanVien nhanVien : listNhanVien) {
			BangLuong bangLuong = bangLuongDao.getBangLuongTheoMaNhanVien(nhanVien.getMaNhanVien(), year, month);

			if (bangLuong != null) {
				modelTinhLuong.addRow(new Object[] { nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(),
						bangLuong.getMucLuong(), bangLuong.getHeSoLuong(), bangLuong.getTienSanPham(),
						bangLuong.getSoNgayCong(), bangLuong.tinhLuong() });
			}
		}
		ChucNang.addNullDataTable(modelTinhLuong);
	}

}
