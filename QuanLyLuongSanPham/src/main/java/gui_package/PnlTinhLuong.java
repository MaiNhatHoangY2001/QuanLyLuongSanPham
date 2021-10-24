package gui_package;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JMonthChooser;

public class PnlTinhLuong extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblTinhLuong;
	private JTextField txtSrc;
	private String[] colsname = { "Mã bảng lương", "Mức lương", "Hệ số lương", "Tiền sản phẩm", "Số ngày công" };
	private JComboBox<String> cboLoaiTep;
	private JButton btnSrc;
	private JButton btnIn;
	private JSpinner spinner;
	private JMonthChooser monthChooser;
	public PnlTinhLuong() {
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
		 * Bảng lương của các nhân viên trong tháng
		 */
		new DefaultTableModel(colsname, 0);
		tblTinhLuong = new JTable(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null } },
				colsname));
		tblTinhLuong.setRowMargin(5);
		tblTinhLuong.setRowHeight(30);
		tblTinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblTinhLuong.setToolTipText("Bảng lương của các nhân viên trong tháng");
		JTableHeader headerTable = tblTinhLuong.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon = new JScrollPane(tblTinhLuong);
		thanhCuon.setBounds(23, 60, 1380, 328);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon.setToolTipText("Bảng lương của các nhân viên trong tháng");
		add(thanhCuon);

		/**
		 * Thông tin nhân viên
		 */
		JPanel pnlNhanVien = new JPanel();
		pnlNhanVien.setLayout(null);
		pnlNhanVien.setBackground(new Color(248, 198, 153));
		pnlNhanVien.setBounds(23, 420, 676, 331);
		add(pnlNhanVien);

		JLabel lblThongTin = new JLabel("Thông tin nhân viên");
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblThongTin.setBounds(24, 11, 268, 42);
		pnlNhanVien.add(lblThongTin);

		JLabel lblAnh = new JLabel("");
		lblAnh.setIcon(new ImageIcon("src/main/resources/images/img_bill/user.PNG"));
		lblAnh.setBounds(47, 51, 190, 181);
		pnlNhanVien.add(lblAnh);

		JLabel lblTenNV = new JLabel("Hoang Van Chinh");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTenNV.setBounds(47, 259, 211, 42);
		pnlNhanVien.add(lblTenNV);

		JLabel lblMaNV = new JLabel("Mã Nhân viên: KH123");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMaNV.setBounds(268, 60, 345, 35);
		pnlNhanVien.add(lblMaNV);

		JLabel lblSDT = new JLabel("Số điện thoại: 0967127083");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSDT.setBounds(268, 125, 356, 35);
		pnlNhanVien.add(lblSDT);

		JLabel lblDiaChi = new JLabel("Địa chỉ: Đăk Nông");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setBounds(268, 191, 368, 35);
		pnlNhanVien.add(lblDiaChi);

		JLabel lblNgaySinh = new JLabel("Ngày sinh: 15/06/2001");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgaySinh.setBounds(268, 259, 356, 35);
		pnlNhanVien.add(lblNgaySinh);

		/**
		 * In
		 */
		JPanel pnlIn = new JPanel();
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

		cboLoaiTep = new JComboBox<String>();
		cboLoaiTep.setModel(new DefaultComboBoxModel<String>(new String[] { "Excel", "Notepad" }));

		cboLoaiTep.setForeground(Color.WHITE);
		cboLoaiTep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiTep.setBackground(new Color(233, 180, 46));
		cboLoaiTep.setBounds(213, 101, 275, 28);
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
	}
}
