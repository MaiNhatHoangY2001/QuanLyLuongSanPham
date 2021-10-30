package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import dao.BangLuongDao;
import dao.ChiTietHoaDonBanDao;
import dao.NhanVienDao;
import gui_package.ChucNang;
import gui_package.CustomTable;
import gui_package.RoundedPanel;
import model.BangLuong;
import model.ChiTietHoaDonBan;
import model.NhanVien;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionEvent;

public class Gui_QuanLyLuong extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblTinhLuong;
	private String[] colsname = { "Mã nhân viên", "Tên nhân viên", "Mức lương", "Hệ số lương", "Tổng tiền sản phẩm",
			"Số ngày công", "Tiền lương" };
	private String[] colsnameLK = { "Tên sản phẩm", "Số lượng", "Thành tiền" };
	private JTable tblSanPham;
	private DefaultTableModel modelTinhLuong, modelSanPham;

	private static final int CURRENT_DAY = LocalDateTime.now().getDayOfMonth();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblTenDN;
	private JLabel lblNgay;
	private JLabel lblGio;
	private JTextField txtTimKiem;
	private JMonthChooser cboMonth;
	private JYearChooser spnYear;
	private JLabel lblIconDX;
	private JLabel lblIconUser;
	private JPanel panel_2;
	private JLabel lblTenNhanVien;
	private JLabel lblMaNhanVien;
	private JLabel lblSdt;
	private JLabel lblDiaChi;
	private JLabel lblNgaySinh;
	private JLabel lblBangLuong;
	private JLabel lblSanPham;
	private JLabel lblNhanVien;
	private JButton btnTao;
	private JButton btnHienTai;
	private JButton btnIn;
	private int oldValue;
	private JComboBox<String> cboTimKiem;
	// Format tiền theo VND
	private NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
	private JButton btnXoaRong;
	private JButton btnTim;

	public Gui_QuanLyLuong() {
		setSize(1600, 1046);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		panel = new JPanel();
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

		lblNewLabel = new JLabel("QUẢN LÝ LƯƠNG");
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
		cboMonth = new JMonthChooser();
		cboMonth.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMonth.setBounds(525, 14, 140, 47);
		panel_1_1.add(cboMonth);

		spnYear = new JYearChooser();
		spnYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnYear.setBounds(675, 14, 65, 47);
		panel_1_1.add(spnYear);

		cboMonth.addPropertyChangeListener("month", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				setDataTableBangLuong((Integer) evt.getNewValue() + 1, spnYear.getYear());

				Boolean bool = cboMonth.getMonth() + 1 <= LocalDate.now().getMonthValue() ? true : false;
				btnTao.setEnabled(bool);

				clearThongTinNhanVien();
				ChucNang.clearDataTable(modelSanPham);
				ChucNang.addNullDataTable(modelSanPham);
			}
		});
		spnYear.addPropertyChangeListener("year", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setDataTableBangLuong(cboMonth.getMonth() + 1, (Integer) evt.getNewValue());

				Boolean bool = spnYear.getYear() <= LocalDate.now().getYear() ? true : false;
				btnTao.setEnabled(bool);

				clearThongTinNhanVien();
				ChucNang.clearDataTable(modelSanPham);
				ChucNang.addNullDataTable(modelSanPham);
			}
		});

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
					clearAllData();
					setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
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
		btnTim.addActionListener(e -> eventTimKiem());

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
			clearAllData();
			setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
		});

		/**
		 * thêm bảng lương, nút cho thời gian về hiện tại và nút in
		 */
		btnTao = new JButton("Tạo bảng lương");
		btnTao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTao.setFocusPainted(false);
		btnTao.setBorderPainted(false);
		btnTao.setForeground(Color.WHITE);
		btnTao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTao.setBackground(new Color(233, 180, 46));
		btnTao.setBounds(10, 14, 185, 47);
		panel_1_1.add(btnTao);
		btnTao.addActionListener(e -> eventTaoBangLuong());

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
			cboMonth.setMonth(LocalDate.now().getMonthValue() - 1);
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
		//Sự kiện
		btnIn.addActionListener(e -> {
			new Gui_In().setVisible(true);
		});
		
		/**
		 * Bảng lương của các nhân viên trong tháng (cột số ngày công có thể chỉnh sửa)
		 */
		lblBangLuong = new JLabel("Thông tin bảng lương");
		lblBangLuong.setForeground(Color.WHITE);
		lblBangLuong.setFont(new Font("Arial", Font.PLAIN, 24));
		lblBangLuong.setBounds(10, 172, 268, 24);
		add(lblBangLuong);

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
					if (modelTinhLuong.getValueAt(row, col) != null) {
						return true;
					}
					return false;
				default:
					return false;
				}
			}
		};
		tblTinhLuong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTinhLuong.setRowMargin(5);
		tblTinhLuong.setRowHeight(30);
		tblTinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblTinhLuong.setToolTipText("Bảng lương của các nhân viên trong tháng (cột số ngày công có thể chỉnh sửa)");
		JTableHeader headerTable = tblTinhLuong.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon = new JScrollPane(tblTinhLuong);
		thanhCuon.setBounds(0, 205, 1574, 426);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon.setToolTipText("Bảng lương của các nhân viên trong tháng (cột số ngày công có thể chỉnh sửa)");

		TableColumn column = tblTinhLuong.getColumnModel().getColumn(5);
		column.setCellRenderer(new CustomTable(new Color(255, 232, 210), Color.BLACK));

		add(thanhCuon);
		modelTinhLuong = (DefaultTableModel) tblTinhLuong.getModel();

		// Căn chữ của cột sang phải
		int[] listCanPhaiTblLuong = { 2, 3, 4, 6 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblLuong, tblTinhLuong);

		// Đổ dữ liệu vào bảng lương
		if (cboMonth != null && spnYear != null) {
			setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
		}

		// Sự kiện thay đổi số ngày công của bảng lương
		tblTinhLuong.addPropertyChangeListener("tableCellEditor", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() == null) {

					int colEdit = tblTinhLuong.getEditingColumn();
					int rowEdit = tblTinhLuong.getEditingRow();
					if (colEdit != -1 && rowEdit != -1) {
						int newValue = Integer.parseInt(modelTinhLuong.getValueAt(rowEdit, colEdit).toString());
						if (oldValue != newValue) {
							String maNhanVien = modelTinhLuong.getValueAt(rowEdit, 0).toString();
							int month = cboMonth.getMonth() + 1;
							int year = spnYear.getYear();

							BangLuongDao bangLuongDao = new BangLuongDao();
							System.out.println(bangLuongDao.updateSoNgayCong(maNhanVien, month, year, newValue));

							setDataTableBangLuong(month, year);
						}
					}
				} else {

				}
			}
		});

		/**
		 * Bảng liệt kê sản phẩm của 1 nhân viên bán hàng được chọn trong bảng trên (nếu
		 * là nhân viên hành chánh thì sẽ trống)
		 */
		lblSanPham = new JLabel("Thông tin sản phẩm");
		lblSanPham.setForeground(Color.WHITE);
		lblSanPham.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSanPham.setBounds(10, 642, 268, 24);
		add(lblSanPham);

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
		tblSanPham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
		thanhCuon2.setBounds(0, 674, 983, 321);
		thanhCuon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon2.setToolTipText(
				"Bảng liệt kê sản phẩm của của 1 nhân viên bán hàng được chọn trong bảng trên (nếu là nhân viên hành chánh thì sẽ trống)");

		add(thanhCuon2);
		modelSanPham = (DefaultTableModel) tblSanPham.getModel();

		// Căn phải cột của bảng sản phẩm
		int[] listCanPhaiTblSanPham = { 2 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblSanPham, tblSanPham);
		// Căn giữa cột của bảng sản phẩm
		int[] listCanGiuaTblSanPham = { 1 };
		ChucNang.setCenterAlignmentTable(listCanGiuaTblSanPham, tblSanPham);
		tblTinhLuong.addMouseListener(this);

		/**
		 * Thông tin nhân viên
		 */
		lblNhanVien = new JLabel("Thông tin nhân viên");
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNhanVien.setBounds(1017, 642, 268, 24);
		add(lblNhanVien);

		panel_2 = new RoundedPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(248, 198, 153));
		panel_2.setBounds(1004, 674, 570, 321);
		panel_2.setToolTipText("Thông tin nhân viên sau khi chọn ở bảng tổng hợp bảng lương của nhân viên");
		add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("");

		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/images/img_bill/user.PNG"));
		lblNewLabel_2.setBounds(47, 51, 190, 181);
		panel_2.add(lblNewLabel_2);

		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTenNhanVien.setBounds(47, 259, 211, 42);
		panel_2.add(lblTenNhanVien);

		lblMaNhanVien = new JLabel("Mã Nhân viên:");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMaNhanVien.setBounds(268, 60, 345, 35);
		panel_2.add(lblMaNhanVien);

		lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSdt.setBounds(268, 125, 356, 35);
		panel_2.add(lblSdt);

		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setBounds(268, 191, 368, 35);
		panel_2.add(lblDiaChi);

		lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgaySinh.setBounds(268, 259, 356, 35);
		panel_2.add(lblNgaySinh);

	}

	/**
	 * Đổ dữ liệu vào table bảng lương
	 * 
	 * @param month
	 * @param year
	 */
	public void setDataTableBangLuong(int month, int year) {
		ChucNang.clearDataTable(modelTinhLuong);

		BangLuongDao bangLuongDao = new BangLuongDao();
		NhanVienDao nhanVienDao = new NhanVienDao();

		List<NhanVien> listNhanVien = new ArrayList<>();

		listNhanVien = nhanVienDao.getAllNhanVien();

		for (NhanVien nhanVien : listNhanVien) {
			BangLuong bangLuong = bangLuongDao.getBangLuongTheoMaNhanVien(nhanVien.getMaNhanVien(), year, month);
			if (bangLuong != null) {
				modelTinhLuong.addRow(new Object[] { nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(),
						vnFormat.format(nhanVien.getMucLuong()), bangLuong.getHeSoLuong(),
						vnFormat.format(bangLuong.getTienSanPham()), bangLuong.getSoNgayCong(),
						vnFormat.format(bangLuong.tinhLuong()) });
			}
		}
		ChucNang.addNullDataTable(modelTinhLuong);
	}

	/**
	 * Đổ dữ liệu vào table sản phẩm
	 * 
	 * @param month
	 * @param year
	 */
	public void setDataTableSanPham(Object maNhanVien, int month, int year) {
		ChucNang.clearDataTable(modelSanPham);
		ChiTietHoaDonBanDao chiTietHoaDonBanDao = new ChiTietHoaDonBanDao();
		if (maNhanVien != null) {
			List<ChiTietHoaDonBan> list = chiTietHoaDonBanDao.getChiTietTheoMaNV(maNhanVien.toString(), month, year);
			for (ChiTietHoaDonBan chiTietHoaDonBan : list) {
				modelSanPham.addRow(new Object[] { chiTietHoaDonBan.getSanPham().getTenSanPham(),
						chiTietHoaDonBan.getSoLuong(), vnFormat.format(chiTietHoaDonBan.tinhTongTien()) });
			}

		}

		ChucNang.addNullDataTable(modelSanPham);
	}

	/**
	 * Đổ dữ liệu vào panel khi chọn ở bảng lương
	 * 
	 * @param maNhanVien
	 */
	public void setDataPanelThongTinNV(Object maNhanVien) {
		NhanVienDao nhanVienDao = new NhanVienDao();
		NhanVien nhanVien = new NhanVien();
		if (maNhanVien != null) {
			nhanVien = nhanVienDao.getNhanVien(maNhanVien.toString());
			lblTenNhanVien.setText(nhanVien.getTenNhanVien());
			lblMaNhanVien.setText("Mã Nhân viên: " + nhanVien.getMaNhanVien());
			lblSdt.setText("Số điện thoại: " + nhanVien.getsDT());
			lblDiaChi.setText("Địa chỉ: " + nhanVien.getDiaChi());
			lblNgaySinh
					.setText("Ngày sinh: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(nhanVien.getNgaySinh()));
		} else {
			clearThongTinNhanVien();
		}
	}

	public void clearThongTinNhanVien() {
		lblTenNhanVien.setText("");
		lblMaNhanVien.setText("Mã Nhân viên:");
		lblSdt.setText("Số điện thoại:");
		lblDiaChi.setText("Địa chỉ:");
		lblNgaySinh.setText("Ngày sinh:");
	}

	/**
	 * tạo bảng lương mức lương: 100.000 thời gian: ngày hiện tại hệ số lương: Nhân
	 * viên bán hàng: 0.5 Nhân viên hành chính: 2 tiền sản phẩm: tổng thành tiền hóa
	 * đơn bán hàng * 10% (nếu là nhân viên hình chính thì 0) Số ngày công: lấy ngày
	 * hiện tại
	 * 
	 * @return
	 */
	public void themBangLuong() {

		BangLuongDao bangLuongDao = new BangLuongDao();
		NhanVienDao nhanVienDao = new NhanVienDao();

		List<NhanVien> nhanViens = nhanVienDao.getAllNhanVien();

		int month = cboMonth.getMonth() + 1;
		int year = spnYear.getYear();

		for (NhanVien nhanVien : nhanViens) {
			if (nhanVien.gettrangThaiLamViec()) {
				Double tienSanPham = bangLuongDao.getTienSanPham(nhanVien.getMaNhanVien(), month, year);
				Double heSoLuong = (double) (tienSanPham == 0 ? 2 : 1);
				LocalDate thoiGian;
				int soNgayCong;
				if (month == LocalDate.now().getMonthValue() && year == LocalDate.now().getYear()) {
					thoiGian = LocalDate.now();
					soNgayCong = CURRENT_DAY;
				} else {
					thoiGian = LocalDate.of(year, month, 26);
					soNgayCong = CURRENT_DAY >= 26 ? 26 : CURRENT_DAY;
				}

				BangLuong bangLuong = new BangLuong(thoiGian, heSoLuong, tienSanPham, soNgayCong);
				bangLuong.setNhanVien(nhanVien);

				bangLuongDao.themBangLuong(bangLuong);
			}
		}
		ChucNang.clearDataTable(modelTinhLuong);
		setDataTableBangLuong(month, year);

	}

	public void eventTaoBangLuong() {
		if (modelTinhLuong.getValueAt(0, 0) != null) {
			int rs = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn tạo lại bảng lương không?\n(Lưu ý: những bảng hiện có trong tháng này sẽ bị xóa)",
					"Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (rs == JOptionPane.YES_OPTION) {
				new BangLuongDao().deleteAllBangLuongInTime(cboMonth.getMonth() + 1, spnYear.getYear());
				themBangLuong();
			}
		} else
			themBangLuong();

	}

	/**
	 * Tìm kiếm bảng lương
	 */
	public void eventTimKiem() {
		int selectedIndex = cboTimKiem.getSelectedIndex();
		String txtTim = txtTimKiem.getText().trim();
		int rowLen = tblTinhLuong.getRowCount();
		int colLen = tblTinhLuong.getColumnCount();

		List<Object[]> list = new ArrayList<>();
		Object[] item = new Object[colLen];

		switch (selectedIndex) {
		case 0: {
			for (int i = 0; i < rowLen; i++) {
				Object maNV = modelTinhLuong.getValueAt(i, 0);
				if (maNV == null)
					break;
				if (maNV.toString().equals(txtTim)) {
					for (int j = 0; j < colLen; j++) {
						item[j] = tblTinhLuong.getValueAt(i, j);
					}
					break;
				}
			}

			clearAllData();
			modelTinhLuong.addRow(item);
			if (item[0] == null) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy theo dữ liệu");
			}
			break;
		}

		case 1: {
			for (int i = 0; i < rowLen; i++) {
				Object tenNV = modelTinhLuong.getValueAt(i, 1);
				if (tenNV == null)
					break;
				if (tenNV.toString().equals(txtTim)) {
					for (int j = 0; j < colLen; j++) {
						item[j] = tblTinhLuong.getValueAt(i, j);
					}
					list.add(item);
				}
			}
			clearAllData();
			for (Object[] i : list) {
				modelTinhLuong.addRow(i);
			}
			if (list.size() == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy theo dữ liệu");
			}
			break;
		}
		}

	}

	/**
	 * Giúp xóa sạch dữ liệu ở các bảng
	 */
	public void clearAllData() {
		ChucNang.clearDataTable(modelTinhLuong);
		ChucNang.clearDataTable(modelSanPham);
		ChucNang.addNullDataTable(modelSanPham);
		clearThongTinNhanVien();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (modelTinhLuong.getValueAt(tblTinhLuong.getSelectedRow(), 5) != null) {
			oldValue = Integer.parseInt(modelTinhLuong.getValueAt(tblTinhLuong.getSelectedRow(), 5).toString());
		}
		// Lấy mã nhân viên từ bảng tính lương đang chọn
		Object maNhanVien = modelTinhLuong.getValueAt(tblTinhLuong.getSelectedRow(), 0);
		setDataTableSanPham(maNhanVien, cboMonth.getMonth() + 1, spnYear.getYear());
		setDataPanelThongTinNV(maNhanVien);
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

}
