package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import gui_package.ChucNang;
import gui_package.CircleBtn;
import gui_package.RoundTextField;
import model.NhanVien;
import model.SanPham;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.SanPhamDao;

public class Gui_QuanLySanPham extends JPanel implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTImKiem;
	private JTextField txtTongSoSP;

	private JPanel pnlHeader;
	private JPanel pnlContent;

	private JLabel lblNgay;
	private JLabel lblGio;
	private JLabel lblTitleHeader;
	private JLabel lblUser;
	private JLabel lblDangXuat;
	private JLabel lblThongTinSP;
	private JLabel lblTongSoSP;

	private JButton btnSuaNV;
	private JButton btnXoa;
	private JButton btnTimKiem;
	private JButton btnLamMoi;

	private JComboBox cmbLoaiTimKiem;

	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	private NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private SanPhamDao daoSP;
	private List<SanPham> listSP;

	/**
	 * Create the panel.
	 */
	public Gui_QuanLySanPham() {
		setSize(1600, 1046);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		/*
		 * Phan: Header
		 */
		// Background header
		pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1600, 100);
		add(pnlHeader);

		// Jlable Title Header
		lblTitleHeader = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblTitleHeader.setForeground(Color.WHITE);
		lblTitleHeader.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblTitleHeader.setBounds(519, 11, 535, 78);
		pnlHeader.add(lblTitleHeader);

		// Jlable Date
		lblNgay = new JLabel("17/10/2021");
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setBounds(10, 24, 122, 29);
		pnlHeader.add(lblNgay);

		// Jlable Time
		lblGio = new JLabel("7:27:50");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(10, 57, 81, 29);
		pnlHeader.add(lblGio);
		ChucNang.setGio(lblGio, lblNgay); // Setup run time

		// JLable User Name
		lblUser = new JLabel("Chinh");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUser.setBounds(1383, 14, 81, 29);
		pnlHeader.add(lblUser);
		// Jlable User Icon

		// JLable Logout
		lblDangXuat = new JLabel("Đăng Xuất");
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDangXuat.setBounds(1383, 57, 112, 29);
		pnlHeader.add(lblDangXuat);
		// JLable Icon Logout

		/*
		 * Phan: Chuc Nang
		 */
		// Background Chuc Nang
		JPanel pnlNgang = new JPanel();
		pnlNgang.setLayout(null);
		pnlNgang.setBackground(new Color(194, 93, 0));
		pnlNgang.setBounds(0, 100, 1600, 80);
		add(pnlNgang);

//		// JButton Them Nhan Vien
//		btnThemNV = new CircleBtn("S");
//		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
//		btnThemNV.setBackground(new Color(233, 180, 46));
//		btnThemNV.setBounds(10, 15, 150, 50);
//		btnThemNV.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		pnlNgang.add(btnThemNV);

		// JButton Sua Nhan Vien
		btnSuaNV = new CircleBtn("Sửa");
		btnSuaNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSuaNV.setBackground(new Color(233, 180, 46));
		btnSuaNV.setBounds(10, 15, 150, 50);
		btnSuaNV.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnSuaNV);

		// JButton Xoa Nhan Vien
		btnXoa = new CircleBtn("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXoa.setBackground(new Color(233, 180, 46));
		btnXoa.setBounds(170, 15, 150, 50);
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnXoa);

		// Làm mới
		btnLamMoi = new CircleBtn("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLamMoi.setBackground(new Color(233, 180, 46));
		btnLamMoi.setBounds(1424, 15, 150, 50);
		btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnLamMoi);

		// JButton Tim Kiem
		btnTimKiem = new CircleBtn("Tìm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnTimKiem.setBackground(new Color(233, 180, 46));
		btnTimKiem.setBounds(1265, 15, 150, 50);
		btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnTimKiem);

		// JTextField Tim Kiem
		txtTImKiem = new RoundTextField("", 100);
		txtTImKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTImKiem.setBounds(613, 20, 439, 40);
		pnlNgang.add(txtTImKiem);

		// JCombobox Tim kiem
		String loai[] = { "Tìm theo tên", "Tìm theo mã", "Giá dưới 10 triệu", "Giá dưới 20 triệu",
				"Giá dưới 50 triệu" };
		cmbLoaiTimKiem = new JComboBox(loai);
		cmbLoaiTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbLoaiTimKiem.setBounds(1062, 20, 193, 40);
		pnlNgang.add(cmbLoaiTimKiem);

		/*
		 * Phan Content
		 */
		// BackGround Content
		pnlContent = new JPanel();
		pnlContent.setLayout(null);
		pnlContent.setBackground(new Color(242, 129, 25));
		pnlContent.setBounds(0, 180, 1600, 866);
		add(pnlContent);

		// JLable title Bang
		lblThongTinSP = new JLabel("Thông tin sản phẩm");
		lblThongTinSP.setForeground(Color.WHITE);
		lblThongTinSP.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblThongTinSP.setBounds(10, 11, 216, 34);
		pnlContent.add(lblThongTinSP);

		/*
		 * Hien So Luong Nhan Vien
		 */
		// JTextField Tong so Nhan Vien
		txtTongSoSP = new JTextField();
		txtTongSoSP.setForeground(Color.BLACK);
		txtTongSoSP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongSoSP.setEnabled(false);
		txtTongSoSP.setColumns(10);
		txtTongSoSP.setBounds(1400, 11, 174, 32);
		pnlContent.add(txtTongSoSP);

		// JLable Tong so Nhan Vien
		lblTongSoSP = new JLabel("Tổng số sản phẩm:");
		lblTongSoSP.setForeground(Color.WHITE);
		lblTongSoSP.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTongSoSP.setBounds(1180, 11, 210, 34);
		pnlContent.add(lblTongSoSP);

		/*
		 * Bang thong tin Nhan Vien
		 */
		// Thanh Cuon
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 47, 1585, 818);
		pnlContent.add(scrollPane);
		// Header Title Nhan Vien
		String headerTitle[] = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại", "Nhà Cung Cấp", "Giá Thành" };
		// Model Table
		model = new DefaultTableModel(headerTitle, 50);
		// Table
		table = new JTable(model);
		table.setRowHeight(35); // set height items
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		// Set Font title table
		JTableHeader headerTable = table.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		scrollPane.setViewportView(table);

		// Thêm sự kiện cho các chức năng
		btnXoa.addActionListener(this);
		btnSuaNV.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		cmbLoaiTimKiem.addItemListener(this);

		daoSP = new SanPhamDao();
		listSP = daoSP.getAllSanPham();

		LoadThongTinSanPham(listSP);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnSuaNV)) {
			if (table.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Hãy chọn Nhân Viên cần sửa");
			} else {

				String maSP = model.getValueAt(table.getSelectedRow(), 0).toString();
				SanPham sp = daoSP.getSanPham(maSP);
				new Gui_SuaThongTinSanPham(sp).setVisible(true);

			}
		} else if (o.equals(btnXoa)) {
			if (table.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Hãy chọn Nhân Viên cần xóa");
			} else {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Nhân viên này không ?",
						"Cảnh báo", JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					boolean rs = false;
					while (table.getSelectedRowCount() > 0) {
						int index = table.getSelectedRow();
						rs = daoSP.xoaSanPhamTheoMa(model.getValueAt(table.getSelectedRow(), 0).toString());
						model.removeRow(index);
					}
					if (rs == true)
						JOptionPane.showMessageDialog(this, "Xóa thành công");
					else
						JOptionPane.showMessageDialog(this, "Xóa không thành công");
				}

			}
		} else if (o.equals(btnLamMoi)) {
			LoadThongTinSanPham(daoSP.getAllSanPham());
		} else if (o.equals(btnTimKiem)) {
			String data = txtTImKiem.getText();
			String loaiTK = cmbLoaiTimKiem.getSelectedItem().toString();
			if (loaiTK.equals("Tìm theo tên")) {
				ChucNang.clearDataTable(model);
				List<SanPham> list = daoSP.getSanPhamThoTen(data);
				LoadThongTinSanPham(list);
			} else if (loaiTK.equals("Tìm theo mã")) {
				SanPham sanPham = daoSP.getSanPham(data);
				if (sanPham == null)
					LoadThongTinSanPham(listSP);
				else {
					ChucNang.clearDataTable(model);
					load1ThongTinSanPham(sanPham);
					ChucNang.addNullDataTable(model);
					ChucNang.addNullDataTable(model);
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox cmb = (JComboBox) e.getSource();
		if (cmb.getSelectedItem().equals("Giá dưới 10 triệu")) {
			ChucNang.clearDataTable(model);
			for (SanPham sanPham : listSP) {
				if (sanPham.getGiaThanh() < 10000000) {
					load1ThongTinSanPham(sanPham);
				}
			}
			ChucNang.addNullDataTable(model);
			ChucNang.addNullDataTable(model);
		} else if (cmb.getSelectedItem().equals("Giá dưới 20 triệu")) {
			ChucNang.clearDataTable(model);
			for (SanPham sanPham : listSP) {
				if (sanPham.getGiaThanh() < 20000000);
				load1ThongTinSanPham(sanPham);
			}
			ChucNang.addNullDataTable(model);
			ChucNang.addNullDataTable(model);
		} else if (cmb.getSelectedItem().equals("Giá dưới 50 triệu")) {
			ChucNang.clearDataTable(model);
			for (SanPham sanPham : listSP) {
				if (sanPham.getGiaThanh() < 50000000);
				load1ThongTinSanPham(sanPham);
			}
			ChucNang.addNullDataTable(model);
			ChucNang.addNullDataTable(model);
		}
	}

	/**
	 * Load Data to JTable NhanVien Load TongSoNhanVien to JTextField Tong So
	 * NhanVien
	 * 
	 * @param list
	 */
	private void LoadThongTinSanPham(List<SanPham> list) {
		ChucNang.clearDataTable(model);
		for (SanPham sanPham : list) {
			load1ThongTinSanPham(sanPham);
		}
		txtTongSoSP.setText(list.size() + "");
		ChucNang.addNullDataTable(model);
		ChucNang.addNullDataTable(model);
	}

	public void load1ThongTinSanPham(SanPham sanPham) {
		String n[] = { sanPham.getMaSanpham(), sanPham.getTenSanPham(), sanPham.getLoai(), sanPham.getnCC(),
				vnFormat.format(sanPham.getGiaThanh()) };
		model.addRow(n);
	}

}
