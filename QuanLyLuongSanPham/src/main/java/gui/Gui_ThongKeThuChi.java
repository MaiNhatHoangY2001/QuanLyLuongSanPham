package gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import gui_package.ChucNang;
import gui_package.CustomTab;
import gui_package.CustomTable;
import gui_package.PnlThongKeChi;
import gui_package.PnlThongKeThu;
import model.BangLuong;
import model.NhanVien;
import services.QuanLyLuongService;
import services.ThongKeService;

public class Gui_ThongKeThuChi extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblGio;
	private JLabel lblIconUser;
	private JLabel lblIconDX;
	private JLabel lblNgay;
	private JLabel lblTenDN;
	private JMonthChooser cboMonth;
	private JYearChooser spnYear;
	private JComboBox<String> cboTimKiem;
	private JTextField txtTimKiem;
	private JButton btnTim;
	private JButton btnXoaRong;
	private JButton btnIn;
	private JButton btnHienTai;
	private String[] colsname = { "Tháng", "Tổng Tiền bán sản phẩm", "Tiền nhập sản phẩm", "Tiền Lương nhân viên",
			"Tổng Tiền Thu", "Lợi nhuận" };
	private JTable tblThongKe;
	private DefaultTableModel modelThongKe;
	// Format tiền theo VND
	private NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));

	/**
	 * Create the frame.
	 */
	public Gui_ThongKeThuChi() {
		setSize(1600, 1046);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(242, 129, 25));
		panel.setBounds(0, 0, 1600, 92);
		add(panel);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setPreferredSize(new Dimension(1600, 72));
		panel_1_1.setBackground(new Color(194, 93, 0));
		panel_1_1.setBounds(0, 89, 1600, 72);
		add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ THU CHI");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(491, 0, 531, 92);
		panel.add(lblNewLabel);

		/**
		 * set Ngày giờ
		 */
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

		/**
		 * Tên đăng nhập
		 */
		lblTenDN = new JLabel("Chinh");
		lblTenDN.setHorizontalTextPosition(SwingConstants.LEFT);
		lblTenDN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenDN.setForeground(Color.WHITE);
		lblTenDN.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTenDN.setBounds(1459, 11, 73, 33);
		panel.add(lblTenDN);

		lblIconUser = new JLabel("");
		Image imgUser = new ImageIcon("img\\user1.png").getImage();
		lblIconUser.setIcon(new ImageIcon(imgUser));
		lblIconUser.setBounds(1539, 11, 40, 40);
		panel.add(lblIconUser);

		/**
		 * Đăng xuất
		 */
		JLabel lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDangXuat.setBounds(1419, 55, 110, 24);
		panel.add(lblDangXuat);

		lblIconDX = new JLabel("");
		Image imgDX = new ImageIcon("img\\dangxuat.png").getImage();
		lblIconDX.setIcon(new ImageIcon(imgDX));
		lblIconDX.setBounds(1539, 54, 25, 25);
		panel.add(lblIconDX);

		/**
		 * 
		 * sự kiện cboMonth và spnYear
		 */

		spnYear = new JYearChooser();
		spnYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnYear.setBounds(628, 14, 112, 47);
		panel_1_1.add(spnYear);

//		spnYear.addPropertyChangeListener("year", new PropertyChangeListener() {
//
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				setDataTableBangLuong(cboMonth.getMonth() + 1, (Integer) evt.getNewValue());
//
//				Boolean bool = spnYear.getYear() <= LocalDate.now().getYear() ? true : false;
//				btnTao.setEnabled(bool);
//
//				clearThongTinNhanVien();
//				ChucNang.clearDataTable(modelSanPham);
//				ChucNang.addNullDataTable(modelSanPham);
//			}
//		});

		/**
		 * Chức năng tìm kiếm
		 */
		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setFocusTraversalKeysEnabled(false);
		cboTimKiem.getEditor().setItem("test");
		cboTimKiem.setName("Loại tìm kiếm");
		cboTimKiem.setBounds(1327, 14, 185, 47);
		cboTimKiem.setToolTipText("Loại tìm kiếm");
		cboTimKiem.setForeground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboTimKiem.setBackground(new Color(233, 180, 46));
		cboTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] { "Tìm theo mã", "Tìm theo tên" }));
		cboTimKiem.setSelectedIndex(-1);
		// sự kiện cbo
		cboTimKiem.addActionListener(e -> {
			if (!txtTimKiem.getText().equals("")) {
				btnTim.setEnabled(true);
			}
		});
		panel_1_1.add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setToolTipText("Nhập thông tin tìm kiếm");
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(1000, 14, 220, 47);
		txtTimKiem.setColumns(10);
		panel_1_1.add(txtTimKiem);
		// sự kiên txt
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				change();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				change();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				change();
			}

			public void change() {
				btnXoaRong.setEnabled(true);
				if (cboTimKiem.getSelectedIndex() != -1) {
					btnTim.setEnabled(true);
				}
				if (txtTimKiem.getText().equals("")) {
					btnTim.setEnabled(false);
//					clearAllData();
//					setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
					btnXoaRong.setEnabled(false);
				}
			}
		});

		btnTim = new JButton("");
		btnTim.setToolTipText("Nút tìm kiếm (kết quả xuất hiện ở bảng lương)");
		btnTim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTim.setFocusPainted(false);
		btnTim.setBorderPainted(false);
		btnTim.setBackground(new Color(233, 180, 46));
		btnTim.setIcon(new ImageIcon("img\\icons8-search-24.png"));
		btnTim.setBounds(1273, 14, 44, 47);
		btnTim.setEnabled(false);
		panel_1_1.add(btnTim);
		// sự kiện btn
		// btnTim.addActionListener(e -> eventTimKiem());

		// set Phím enter
		txtTimKiem.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "pressed");
		txtTimKiem.getActionMap().put("pressed", new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				btnTim.doClick();
			}
		});

		btnXoaRong = new JButton("");
		btnXoaRong.setToolTipText("Xóa rỗng và tắt tìm kiếm");
		btnXoaRong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoaRong.setIcon(new ImageIcon("img\\icons8-delete-30.png"));
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaRong.setFocusPainted(false);
		btnXoaRong.setBorderPainted(false);
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(1219, 14, 44, 47);
		panel_1_1.add(btnXoaRong);
		btnXoaRong.setEnabled(false);
		btnXoaRong.addActionListener(e -> {
			txtTimKiem.setText("");
			ChucNang.clearDataTable(modelThongKe);
//			setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
		});
		btnHienTai = new JButton("Hiện tại");
		btnHienTai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHienTai.setForeground(Color.WHITE);
		btnHienTai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHienTai.setFocusPainted(false);
		btnHienTai.setBorderPainted(false);
		btnHienTai.setBackground(new Color(233, 180, 46));
		btnHienTai.setBounds(750, 14, 112, 47);
		panel_1_1.add(btnHienTai);
		btnHienTai.addActionListener(e -> {
			spnYear.setYear(LocalDate.now().getYear());
		});

		btnIn = new JButton("");
		btnIn.setToolTipText("In bảng lương trong tháng");
		btnIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIn.setIcon(new ImageIcon("img\\icons8-print-24.png"));
		btnIn.setFocusPainted(false);
		btnIn.setBorderPainted(false);
		btnIn.setBackground(new Color(233, 180, 46));
		btnIn.setBounds(1533, 14, 44, 47);
		panel_1_1.add(btnIn);
		// Sự kiện
		btnIn.addActionListener(e -> {
			new Gui_In().setVisible(true);
		});

		/**
		 * Thống kê dữ liệu trong tháng
		 */
		new DefaultTableModel(colsname, 0);
		tblThongKe = new JTable(new DefaultTableModel(
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
					if (modelThongKe.getValueAt(row, col) != null) {
						return true;
					}
					return false;
				default:
					return false;
				}
			}
		};
		tblThongKe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblThongKe.setRowMargin(5);
		tblThongKe.setRowHeight(30);
		tblThongKe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblThongKe.setToolTipText("Thống kê dữ liệu trong tháng");
		JTableHeader headerTable = tblThongKe.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon = new JScrollPane(tblThongKe);
		thanhCuon.setBounds(0, 570, 1584, 440);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon.setToolTipText("Thống kê dữ liệu trong tháng");

		add(thanhCuon);
		modelThongKe = (DefaultTableModel) tblThongKe.getModel();

		// Căn chữ của cột sang phải
		int[] listCanPhaiTblThongKe = { 1, 2, 3, 4, 5 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblThongKe, tblThongKe);

		// Căn chữ của cột sang giua
		int[] listCanGiuaTblThongKe = { 0 };
		ChucNang.setCenterAlignmentTable(listCanGiuaTblThongKe, tblThongKe);

		// Đổ dữ liệu vào bảng lương
		if (spnYear != null) {
			setDataTableThongKe(spnYear.getYear());
		}
	}

	/**
	 * Đổ dữ liệu vào table bảng lương
	 * 
	 * @param month
	 * @param year
	 */
	public void setDataTableThongKe(int year) {
		ChucNang.clearDataTable(modelThongKe);

		ThongKeService thongKeService = new ThongKeService();

		for (int i = 1; i <= 12; i++) {
			int month = i;
			double tongTienDaBan = thongKeService.getThanhTienTheoThoiGian(month, year);

			modelThongKe.addRow(new Object[] { month, vnFormat.format(tongTienDaBan) });
		}
	}

}
