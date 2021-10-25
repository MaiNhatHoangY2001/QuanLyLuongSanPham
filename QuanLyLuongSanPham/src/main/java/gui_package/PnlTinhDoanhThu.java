package gui_package;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class PnlTinhDoanhThu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblTKChi, tblTKThu;
	private String[] colsnameTKChi = { "STT", "Sản phẩm", "Lương NV", "Khác" };
	private String[] colsnameTKThu = { "Ngày", "Số Lượng Hóa Đơn", "Thành tiền" };
	private JTextField txtChi;
	private JTextField txtThu;
	private JTextField txtLoiNhuan;
	private JMonthChooser cboMonth;
	private JYearChooser spnYear;

	public PnlTinhDoanhThu() {
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
		 * Bảng tiền chi
		 */
		JLabel lblTableChi = new JLabel("Tiền chi");
		lblTableChi.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTableChi.setBounds(23, 20, 268, 42);
		add(lblTableChi);

		new DefaultTableModel(colsnameTKChi, 0);
		tblTKChi = new JTable(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null } }, colsnameTKChi)){

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
		tblTKChi.setRowMargin(5);
		tblTKChi.setRowHeight(30);
		tblTKChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblTKChi.setToolTipText("Bảng thống kê những khoản tiền đã chi trong tháng");
		JTableHeader headerTable1 = tblTKChi.getTableHeader();
		headerTable1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		headerTable1.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon1 = new JScrollPane(tblTKChi);
		thanhCuon1.setBounds(23, 70, 668, 465);
		thanhCuon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon1.setToolTipText("Bảng thống kê những khoản tiền đã chi trong tháng");
		add(thanhCuon1);

		/**
		 * Bảng tiền thu
		 */
		JLabel lblTableThu = new JLabel("Tiền thu");
		lblTableThu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTableThu.setBounds(741, 20, 268, 42);
		add(lblTableThu);

		new DefaultTableModel(colsnameTKThu, 0);
		tblTKThu = new JTable(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null } }, colsnameTKThu)){

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
		tblTKThu.setRowMargin(5);
		tblTKThu.setRowHeight(30);
		tblTKThu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblTKThu.setToolTipText("Bảng thống kê những khoản tiền thu được tại cửa hàng trong tháng");
		JTableHeader headerTable2 = tblTKThu.getTableHeader();
		headerTable2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		headerTable2.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon2 = new JScrollPane(tblTKThu);
		thanhCuon2.setBounds(741, 70, 668, 465);
		thanhCuon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon2.setToolTipText("Bảng thống kê những khoản tiền thu được tại cửa hàng trong tháng");
		add(thanhCuon2);

		/**
		 * Thông tin thu, chi và tổng tiền
		 */

		JPanel panel_4 = new RoundedPanel();
		panel_4.setToolTipText("Bảng tổng tiền trong ngày");
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(248, 198, 153));
		panel_4.setBounds(22, 570, 1384, 181);
		add(panel_4);

		JLabel lblChi = new JLabel("Tổng tiền chi:");
		lblChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChi.setBounds(28, 35, 176, 49);
		panel_4.add(lblChi);

		txtChi = new RoundTextField("", 1000);
		txtChi.setToolTipText("Số tiền đã chi ra trong tháng");
		txtChi.setBounds(17, 81, 380, 47);
		panel_4.add(txtChi);
		txtChi.setColumns(10);

		txtThu = new RoundTextField("", 1000);
		txtThu.setToolTipText("Số tiền thu được trong tháng");
		txtThu.setColumns(10);
		txtThu.setBounds(497, 81, 380, 47);
		panel_4.add(txtThu);

		JLabel lblThu = new JLabel("Tổng tiền thu:");
		lblThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThu.setBounds(504, 35, 176, 49);
		panel_4.add(lblThu);

		txtLoiNhuan = new RoundTextField("", 1000);;
		txtLoiNhuan.setToolTipText("Lợi nhuận của cửa hàng");
		txtLoiNhuan.setColumns(10);
		txtLoiNhuan.setBounds(977, 81, 380, 47);
		panel_4.add(txtLoiNhuan);

		JLabel lblLoiNhuan = new JLabel("Lợi nhuận thực: ");
		lblLoiNhuan.setToolTipText("");
		lblLoiNhuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoiNhuan.setBounds(984, 35, 176, 49);
		panel_4.add(lblLoiNhuan);

	}
}
