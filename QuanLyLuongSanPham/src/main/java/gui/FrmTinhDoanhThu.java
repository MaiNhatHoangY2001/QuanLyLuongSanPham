package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JMonthChooser;

public class FrmTinhDoanhThu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrTKChi;
	private JTable tblTKChi, tblTKThu;
	private String[] colsnameTKChi = { "STT", "Nhập sản phẩm", "Lương Nhân Viên", "Khác" };
	private JScrollPane scrTKThu;
	private String[] colsnameTKThu = { "Ngày", "Số Lượng Hóa Đơn", "Tổng Tiền hóa đơn trong ngày" };
	private JTextField txtChi;
	private JTextField txtThu;
	private JTextField txtLoiNhuan;

	public FrmTinhDoanhThu() {
		setBackground(new Color(242, 129, 25));
		setLayout(null);
		/**
		 * Chọn ngày để hiện thông tin (tháng/năm)
		 */
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 20));
		monthChooser.setBounds(1160, 5, 140, 40);
		add(monthChooser);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setBounds(1316, 5, 59, 40);
		add(spinner);

		/**
		 * Bảng tiền chi
		 */
		JLabel lblTableChi = new JLabel("Tiền chi");
		lblTableChi.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTableChi.setBounds(23, 20, 268, 42);
		add(lblTableChi);

		scrTKChi = new JScrollPane();
		scrTKChi.setToolTipText("Bảng thống kê những khoản tiền chi  trong tháng");
		scrTKChi.setBounds(23, 70, 668, 465);
		scrTKChi.setFont(new Font("Tahoma", Font.PLAIN, 34));
		add(scrTKChi);

		tblTKChi = new JTable();
		tblTKChi.setToolTipText("Bảng thống kê những khoản tiền đã chi trong tháng");
		tblTKChi.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tblTKChi.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tblTKChi.setRowHeight(52);
		tblTKChi.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				colsnameTKChi));
		scrTKChi.setViewportView(tblTKChi);

		/**
		 * Bảng tiền thu
		 */
		JLabel lblTableThu = new JLabel("Tiền thu");
		lblTableThu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTableThu.setBounds(741, 20, 268, 42);
		add(lblTableThu);

		scrTKThu = new JScrollPane();
		scrTKThu.setToolTipText("Bảng thống kê những khoản tiền đã chi tại cửa hàng ");
		scrTKThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrTKThu.setBounds(741, 70, 668, 465);
		add(scrTKThu);

		tblTKThu = new JTable();
		tblTKThu.setToolTipText("Bảng thống kê những khoản tiền thu được tại cửa hàng trong tháng");
		tblTKThu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tblTKThu.setRowHeight(52);
		tblTKThu.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null, null }, { null, null, null }, { null, null, null },
				{ null, null, null, null }, { null, null, null }, }, colsnameTKThu));
		scrTKThu.setViewportView(tblTKThu);

		/**
		 * Thông tin thu, chi và tổng tiền
		 */

		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("Bảng tổng tiền trong ngày");
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(248, 198, 153));
		panel_4.setBounds(22, 570, 1384, 181);
		add(panel_4);

		JLabel lblChi = new JLabel("Tổng tiền chi:");
		lblChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChi.setBounds(28, 35, 176, 49);
		panel_4.add(lblChi);

		txtChi = new JTextField();
		txtChi.setToolTipText("Số tiền đã chi ra trong tháng");
		txtChi.setBounds(17, 81, 380, 47);
		panel_4.add(txtChi);
		txtChi.setColumns(10);

		txtThu = new JTextField();
		txtThu.setToolTipText("Số tiền thu được trong tháng");
		txtThu.setColumns(10);
		txtThu.setBounds(497, 81, 380, 47);
		panel_4.add(txtThu);

		JLabel lblThu = new JLabel("Tổng tiền thu:");
		lblThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThu.setBounds(504, 35, 176, 49);
		panel_4.add(lblThu);

		txtLoiNhuan = new JTextField();
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
