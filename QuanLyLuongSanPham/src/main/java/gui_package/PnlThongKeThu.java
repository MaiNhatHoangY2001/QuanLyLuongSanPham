package gui_package;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JMonthChooser;

public class PnlThongKeThu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblTienThu, tblSanPham;
	private JTextField txtSrc;
	private String[] colsnameTK = { "Ngày", "Số tiền điện thoại bán được", "Số tiền phụ kiện bán được", "Tổng tiền" };
	private String[] colsnameLK = { "Tên sản phẩm", "Số lượng" };
	private JComboBox<String> cboLoaiTep;
	private JButton btnSrc;
	private JButton btnIn;
	private JScrollPane scrTienThu, scrSanPham;
	private JSpinner spinner;
	private JMonthChooser monthChooser;

	public PnlThongKeThu() {
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		/**
		 * Chọn ngày để hiện thông tin (tháng/năm)
		 */
		monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 20));
		monthChooser.setBounds(1160, 5, 140, 40);
		add(monthChooser);

		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setBounds(1316, 5, 59, 40);
		add(spinner);

		/**
		 * Bảng thống kê số tiền đã thu được tại cửa hàng
		 */
		scrTienThu = new JScrollPane();
		scrTienThu.setToolTipText(
				"Bảng thống kê số tiền đã thu được tại cửa hàng theo ngày (chọn 1 ngày để biết chi tiết sản phẩm)");
		scrTienThu.setBounds(23, 60, 1380, 181);
		scrTienThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(scrTienThu);

		tblTienThu = new JTable();
		tblTienThu.setToolTipText(
				"Bảng thống kê số tiền đã thu được tại cửa hàng theo ngày (chọn 1 ngày để biết chi tiết sản phẩm)");
		tblTienThu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tblTienThu.setRowHeight(52);
		tblTienThu
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
						colsnameTK));
		scrTienThu.setViewportView(tblTienThu);

		/**
		 * Bảng liệt kê sản phẩm của 1 ngày được chọn trong bảng trên
		 */
		scrSanPham = new JScrollPane();
		scrSanPham.setToolTipText("Bảng liệt kê sản phẩm của 1 ngày được chọn trong bảng trên");
		scrSanPham.setBounds(23, 265, 640, 480);
		scrSanPham.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(scrSanPham);

		tblSanPham = new JTable();
		tblSanPham.setToolTipText("Bảng liệt kê sản phẩm của 1 ngày được chọn trong bảng trên");
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tblSanPham.setRowHeight(52);
		tblSanPham.setModel(new DefaultTableModel(new Object[][] { { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null } }, colsnameLK));
		scrSanPham.setViewportView(tblSanPham);

	}
}
