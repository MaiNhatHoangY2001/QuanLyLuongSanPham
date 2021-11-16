package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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

import gui_package.ChucNang;
import gui_package.CustomTable;
import gui_package.RoundedPanel;
import model.BangLuong;
import model.ChiTietHoaDonBan;
import model.NhanVien;
import services.QuanLyLuongService;

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
	protected JPanel pnlHead;
	private JLabel lblNewLabel;

	private JLabel lblNgay;
	private JLabel lblGio;
	private JTextField txtTimKiem;
	private JMonthChooser cboMonth;
	private JYearChooser spnYear;
	private JPanel panel_2;
	private JLabel lblTenNhanVien;
	private JLabel lblMaNhanVien;
	private JLabel lblSdt;
	private JLabel lblNgaySinh;
	private JLabel lblBangLuong;
	private JLabel lblSanPham;
	private JLabel lblNhanVien;
	private JButton btnTao;
	private JButton btnHienTai;
	private JButton btnXuatFile;
	private int oldValue;
	private JComboBox<String> cboTimKiem;
	// Format tiền theo VND
	private NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
	private JButton btnXoaRong;
	private JButton btnTim;
	private JTextField txtTrang;
	private JLabel lblChucVu;

	public Gui_QuanLyLuong() {
		setSize(1600, 1046);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		pnlHead = new JPanel();
		pnlHead.setBounds(0, 0, 1600, 92);
		pnlHead.setLayout(null);
		pnlHead.setBackground(new Color(242, 129, 25));
		add(pnlHead);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 89, 1600, 72);
		panel_1_1.setPreferredSize(new Dimension(1600, 72));
		panel_1_1.setBackground(new Color(194, 93, 0));
		add(panel_1_1);
		panel_1_1.setLayout(null);

		lblNewLabel = new JLabel("QUẢN LÝ LƯƠNG");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(491, 0, 531, 92);
		pnlHead.add(lblNewLabel);

		/**
		 * set Ngày giờ
		 */
		lblNgay = new JLabel("New label");
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setBounds(0, 16, 233, 33);
		pnlHead.add(lblNgay);

		lblGio = new JLabel("New label");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(0, 50, 201, 42);
		pnlHead.add(lblGio);

		ChucNang.setGio(lblGio, lblNgay);

		/**
		 * 
		 * sự kiện cboMonth và spnYear
		 */
		cboMonth = new JMonthChooser();
		cboMonth.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMonth.setLocale(new Locale("vi"));
		cboMonth.setBounds(542, 14, 137, 47);
		panel_1_1.add(cboMonth);

		spnYear = new JYearChooser();
		spnYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnYear.setBounds(675, 14, 65, 47);
		panel_1_1.add(spnYear);

		cboMonth.addPropertyChangeListener("month", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				setDataTableBangLuong((Integer) evt.getNewValue() + 1, spnYear.getYear());

				Boolean bool = cboMonth.getMonth() + 1 == LocalDate.now().getMonthValue() ? true : false;
				btnTao.setEnabled(bool);
				txtTrang.setText("1");
				clearThongTinNhanVien();
				ChucNang.clearDataTable(modelSanPham);
				ChucNang.addNullDataTable(modelSanPham);
			}
		});
		spnYear.addPropertyChangeListener("year", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setDataTableBangLuong(cboMonth.getMonth() + 1, (Integer) evt.getNewValue());

				Boolean bool = spnYear.getYear() == LocalDate.now().getYear() ? true : false;
				btnTao.setEnabled(bool);
				txtTrang.setText("1");
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

		btnXuatFile = new JButton("");
		btnXuatFile.setToolTipText("Xuất file bảng lương trong tháng");
		btnXuatFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXuatFile.setIcon(new ImageIcon("img\\icons8-file-24.png"));
		btnXuatFile.setFocusPainted(false);
		btnXuatFile.setBorderPainted(false);
		btnXuatFile.setBackground(new Color(233, 180, 46));
		btnXuatFile.setBounds(1533, 14, 44, 47);
		panel_1_1.add(btnXuatFile);
		// Sự kiện
		btnXuatFile.addActionListener(e -> {
			new Gui_XuatFile(cboMonth.getMonth() + 1, spnYear.getYear()).setVisible(true);
		});

		/**
		 * Bảng lương của các nhân viên trong tháng (cột số ngày công có thể chỉnh sửa)
		 */
		lblBangLuong = new JLabel("Thông tin bảng lương");
		lblBangLuong.setBounds(10, 172, 268, 24);
		lblBangLuong.setForeground(Color.WHITE);
		lblBangLuong.setFont(new Font("Arial", Font.PLAIN, 24));
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
		thanhCuon.setBounds(0, 205, 1574, 334);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon.setToolTipText("Bảng lương của các nhân viên trong tháng (cột số ngày công có thể chỉnh sửa)");

		TableColumn column = tblTinhLuong.getColumnModel().getColumn(5);
		column.setCellRenderer(new CustomTable(new Color(255, 232, 210), Color.BLACK));

		add(thanhCuon);
		modelTinhLuong = (DefaultTableModel) tblTinhLuong.getModel();

		// Căn chữ của cột sang phải
		int[] listCanPhaiTblLuong = { 2, 3, 4, 6 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblLuong, tblTinhLuong);
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

							QuanLyLuongService bangLuongDao = new QuanLyLuongService();
							System.out.println(bangLuongDao.updateSoNgayCong(maNhanVien, month, year, newValue));

							setDataTableBangLuong(month, year);
						}
					}
				} else {

				}
			}
		});
		// Phân trang cho table Lương
		txtTrang = new JTextField();
		txtTrang.setBounds(720, 550, 63, 50);
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setEditable(false);
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtTrang);
		txtTrang.setColumns(10);

		JButton btnPre = new JButton("<");
		btnPre.setToolTipText("Về danh sách trước");
		btnPre.setBounds(660, 550, 50, 50);
		btnPre.setBackground(new Color(233, 180, 46));
		btnPre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPre.setForeground(Color.WHITE);
		btnPre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPre.setFocusPainted(false);
		btnPre.setBorderPainted(false);
		add(btnPre);
		btnPre.addActionListener(e -> {
			int trang = Integer.parseInt(txtTrang.getText());
			trang = trang == 1 ? 1 : trang - 1;
			txtTrang.setText(Integer.toString(trang));
			setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
			System.out.println(trang);
		});

		JButton btnFor = new JButton(">");
		btnFor.setToolTipText("Về danh sách sau");
		btnFor.setBounds(793, 550, 50, 50);
		btnFor.setBackground(new Color(233, 180, 46));
		btnFor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFor.setForeground(Color.WHITE);
		btnFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFor.setFocusPainted(false);
		btnFor.setBorderPainted(false);
		btnFor.addActionListener(e -> {
			int trang = Integer.parseInt(txtTrang.getText());
			int cuoi = (int) Math.ceil(
					(new QuanLyLuongService().getAllBangLuong(cboMonth.getMonth() + 1, spnYear.getYear()).size() + 1)
							/ 10.0);
			trang = trang == cuoi ? cuoi : trang + 1;
			txtTrang.setText(Integer.toString(trang));
			setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
		});
		add(btnFor);

		JButton btnCuoi = new JButton(">>");
		btnCuoi.setToolTipText("Về cuối danh sách");
		btnCuoi.setBounds(853, 550, 76, 50);
		btnCuoi.setBackground(new Color(233, 180, 46));
		btnCuoi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCuoi.setForeground(Color.WHITE);
		btnCuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCuoi.setFocusPainted(false);
		btnCuoi.setBorderPainted(false);
		btnCuoi.addActionListener(e -> {
			int cuoi = (int) Math.ceil(
					(new QuanLyLuongService().getAllBangLuong(cboMonth.getMonth() + 1, spnYear.getYear()).size() + 1)
							/ 10.0);
			txtTrang.setText(Integer.toString(cuoi));
			setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
		});
		add(btnCuoi);

		JButton btnDau = new JButton("<<");
		btnDau.setToolTipText("Về đầu danh sách");
		btnDau.setBounds(574, 550, 76, 50);
		btnDau.setBackground(new Color(233, 180, 46));
		btnDau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDau.setFocusPainted(false);
		btnDau.setBorderPainted(false);
		btnDau.addActionListener(e -> {
			txtTrang.setText(Integer.toString(1));
			setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
		});
		add(btnDau);

		// Đổ dữ liệu vào bảng lương
		if (cboMonth != null && spnYear != null) {
			setDataTableBangLuong(cboMonth.getMonth() + 1, spnYear.getYear());
		}

		/**
		 * Bảng liệt kê sản phẩm của 1 nhân viên bán hàng được chọn trong bảng trên (nếu
		 * là nhân viên hành chánh thì sẽ trống)
		 */
		lblSanPham = new JLabel("Thông tin sản phẩm");
		lblSanPham.setBounds(10, 603, 268, 24);
		lblSanPham.setForeground(Color.WHITE);
		lblSanPham.setFont(new Font("Arial", Font.PLAIN, 24));
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
		thanhCuon2.setBounds(0, 638, 884, 357);
		thanhCuon2.setEnabled(false);
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
		lblNhanVien.setBounds(908, 611, 268, 24);
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Arial", Font.PLAIN, 24));
		add(lblNhanVien);

		panel_2 = new RoundedPanel();
		panel_2.setBounds(894, 638, 680, 357);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(248, 198, 153));
		panel_2.setToolTipText("Thông tin nhân viên sau khi chọn ở bảng tổng hợp bảng lương của nhân viên");
		add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("");

		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/images/img_bill/user.PNG"));
		lblNewLabel_2.setBounds(47, 54, 190, 181);
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

		lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgaySinh.setBounds(268, 200, 356, 35);
		panel_2.add(lblNgaySinh);

		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChucVu.setBounds(268, 266, 356, 35);
		panel_2.add(lblChucVu);

	}

	/**
	 * Đổ dữ liệu vào table bảng lương
	 * 
	 * @param month
	 * @param year
	 */
	public void setDataTableBangLuong(int month, int year) {
		ChucNang.clearDataTable(modelTinhLuong);

		QuanLyLuongService banLuongService = new QuanLyLuongService();

		List<NhanVien> listNhanVien = new ArrayList<>();

		int trangTable = Integer.parseInt(txtTrang.getText()) - 1;
		listNhanVien = banLuongService.get10NhanVienTheoKhoang(trangTable * 10, month, year);

		if (!listNhanVien.isEmpty()) {
			for (NhanVien nhanVien : listNhanVien) {
				BangLuong bangLuong = banLuongService.getBangLuongTheoMaNhanVien(nhanVien.getMaNhanVien(), year, month);
				if (bangLuong != null) {
					modelTinhLuong.addRow(new Object[] { nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(),
							vnFormat.format(nhanVien.getMucLuong()), bangLuong.getHeSoLuong(),
							vnFormat.format(bangLuong.getTienSanPham()), bangLuong.getSoNgayCong(),
							vnFormat.format(bangLuong.tinhLuong()) });
				}
			}
		}

		if (tblTinhLuong.getRowCount() == 0) {
			ChucNang.addNullDataTable(modelTinhLuong);
		}
	}

	/**
	 * Đổ dữ liệu vào table sản phẩm
	 * 
	 * @param month
	 * @param year
	 */
	public void setDataTableSanPham(Object maNhanVien, int month, int year) {
		ChucNang.clearDataTable(modelSanPham);
		QuanLyLuongService quanLyLuongService = new QuanLyLuongService();
		if (maNhanVien != null) {
			List<ChiTietHoaDonBan> list = quanLyLuongService.getChiTietTheoMaNV(maNhanVien.toString(), month, year);
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
	public void setDataPanelThongTinNV(Object maNhanVien, double heSoLuong) {
		QuanLyLuongService quanLyLuongService = new QuanLyLuongService();
		NhanVien nhanVien = new NhanVien();
		if (maNhanVien != null) {
			nhanVien = quanLyLuongService.getNhanVien(maNhanVien.toString());
			lblTenNhanVien.setText(nhanVien.getTenNhanVien());
			lblMaNhanVien.setText("Mã Nhân viên: " + nhanVien.getMaNhanVien());
			lblSdt.setText("Số điện thoại: " + nhanVien.getsDT());
			lblNgaySinh
					.setText("Ngày sinh: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(nhanVien.getNgaySinh()));
			lblChucVu.setText("Chức vụ: " + (heSoLuong == 2 ? "Nhân viên hành chánh" : "Nhân viên bán hàng"));
		} else {
			clearThongTinNhanVien();
		}
	}

	public void clearThongTinNhanVien() {
		lblTenNhanVien.setText("");
		lblMaNhanVien.setText("Mã Nhân viên:");
		lblSdt.setText("Số điện thoại:");
		lblNgaySinh.setText("Ngày sinh:");
		lblChucVu.setText("Chức vụ: ");
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

		QuanLyLuongService quanLyLuongService = new QuanLyLuongService();

		List<NhanVien> nhanViens = quanLyLuongService.getAllNhanVien();

		int month = cboMonth.getMonth() + 1;
		int year = spnYear.getYear();

		for (NhanVien nhanVien : nhanViens) {
			if (nhanVien.gettrangThaiLamViec()) {
				Double tienSanPham = quanLyLuongService.getTienSanPham(nhanVien.getMaNhanVien(), month, year);
				Double heSoLuong = (double) (quanLyLuongService.kiemTraNhanVien(nhanVien.getMaNhanVien()) ? 2 : 1);
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

				quanLyLuongService.themBangLuong(bangLuong);
			}
		}
		ChucNang.clearDataTable(modelTinhLuong);
		setDataTableBangLuong(month, year);

	}

	public void eventTaoBangLuong() {
		if (tblTinhLuong.getValueAt(0, 0) != null) {
			int rs = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn tạo lại bảng lương không?\n(Lưu ý: những bảng hiện có trong tháng này sẽ bị xóa)",
					"Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (rs == JOptionPane.YES_OPTION) {
				new QuanLyLuongService().deleteAllBangLuongInTime(cboMonth.getMonth() + 1, spnYear.getYear());
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
		QuanLyLuongService quanLyLuongService = new QuanLyLuongService();
		List<NhanVien> listNhanVien = new ArrayList<>();
		List<Object[]> list = new ArrayList<>();
		Object[] item = new Object[colLen];

		switch (selectedIndex) {
		case 0: {
			clearAllData();
			listNhanVien = quanLyLuongService.getNhanVienTheoMaVaThoiGian(txtTim, cboMonth.getMonth() + 1,
					spnYear.getYear());
			if (!listNhanVien.isEmpty()) {
				for (NhanVien nhanVien : listNhanVien) {

					BangLuong bangLuong = quanLyLuongService.getBangLuongTheoMaNhanVien(nhanVien.getMaNhanVien(),
							spnYear.getYear(), cboMonth.getMonth() + 1);
					if (bangLuong != null) {
						modelTinhLuong.addRow(new Object[] { nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(),
								vnFormat.format(nhanVien.getMucLuong()), bangLuong.getHeSoLuong(),
								vnFormat.format(bangLuong.getTienSanPham()), bangLuong.getSoNgayCong(),
								vnFormat.format(bangLuong.tinhLuong()) });
					}
				}
			}

			txtTrang.setText("1");
			if (tblTinhLuong.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy theo dữ liệu");
			}
			break;
		}

		case 1: {
			clearAllData();
			listNhanVien = quanLyLuongService.getNhanVienTheoTenVaThoiGian(txtTim, cboMonth.getMonth() + 1,
					spnYear.getYear());
			if (!listNhanVien.isEmpty()) {
				for (NhanVien nhanVien : listNhanVien) {

					BangLuong bangLuong = quanLyLuongService.getBangLuongTheoMaNhanVien(nhanVien.getMaNhanVien(),
							spnYear.getYear(), cboMonth.getMonth() + 1);
					if (bangLuong != null) {
						modelTinhLuong.addRow(new Object[] { nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(),
								vnFormat.format(nhanVien.getMucLuong()), bangLuong.getHeSoLuong(),
								vnFormat.format(bangLuong.getTienSanPham()), bangLuong.getSoNgayCong(),
								vnFormat.format(bangLuong.tinhLuong()) });
					}
				}
			}

			txtTrang.setText("1");
			if (tblTinhLuong.getRowCount() == 0) {
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
		Object heSoLuong = modelTinhLuong.getValueAt(tblTinhLuong.getSelectedRow(), 3);
		setDataTableSanPham(maNhanVien, cboMonth.getMonth() + 1, spnYear.getYear());
		setDataPanelThongTinNV(maNhanVien, (double) heSoLuong);
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
