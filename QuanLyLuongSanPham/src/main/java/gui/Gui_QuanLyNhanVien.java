package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import gui_package.ChucNang;
import gui_package.CircleBtn;
import gui_package.RoundTextField;
import model.NhanVien;
import services.QuanLyNhanVienService;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhanVienDao;
import javax.swing.SwingConstants;

public class Gui_QuanLyNhanVien extends JPanel implements ActionListener, ItemListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTImKiem;
	private JTextField txtTongSoSV;
	private JTextField txtSoTrang;

	protected JPanel pnlHead;
	private JPanel pnlContent;

	private JLabel lblNgay;
	private JLabel lblGio;
	private JLabel lblTitleHeader;
	private JLabel lblThongTinNV;
	private JLabel lblTongSoNV;

	private JButton btnThemNV;
	private JButton btnSuaNV;
	private JButton btnXaThai;
	private JButton btnTimKiem;
	private JButton btnDoubleTrai;
	private JButton btnTrai;
	private JButton btnPhai;
	private JButton btnDoublePhai;
	private JButton btnLamMoi;

	private JComboBox cmbLoaiTimKiem;

	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	private NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private List<NhanVien> list50NV;
	private List<String> listMaNV;
	private QuanLyNhanVienService nvSV;
	private int soTrang;
	private int tongSV;
	private int tongSotrang;
	private int index;

	/**
	 * Create the panel.
	 */
	public Gui_QuanLyNhanVien() {
		setSize(1600, 1002);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		/*
		 * Phan: Header
		 */
		// Background header
		pnlHead = new JPanel();
		pnlHead.setLayout(null);
		pnlHead.setBackground(new Color(242, 129, 25));
		pnlHead.setBounds(0, 0, 1600, 92);
		add(pnlHead);

		// Jlable Title Header
		lblTitleHeader = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitleHeader.setForeground(Color.WHITE);
		lblTitleHeader.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblTitleHeader.setBounds(519, 0, 535, 92);
		pnlHead.add(lblTitleHeader);

		// Jlable Date
		lblNgay = new JLabel("17/10/2021");
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setBounds(10, 11, 122, 29);
		pnlHead.add(lblNgay);

		// Jlable Time
		lblGio = new JLabel("7:27:50");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(10, 51, 81, 29);

		pnlHead.add(lblGio);
		ChucNang.setGio(lblGio, lblNgay);

		Image imgUser = new ImageIcon("img\\userNho.png").getImage();
		Image imgDX = new ImageIcon("img\\thoatNho.png").getImage();
		// JLable Icon Logout

		/*
		 * Phan: Chuc Nang
		 */
		// Background Chuc Nang
		JPanel pnlNgang = new JPanel();
		pnlNgang.setLayout(null);
		pnlNgang.setBackground(new Color(194, 93, 0));
		pnlNgang.setBounds(0, 92, 1600, 72);
		add(pnlNgang);

		// JButton Them Nhan Vien
		btnThemNV = new JButton("Thêm");
		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThemNV.setBackground(new Color(233, 180, 46));
		btnThemNV.setBounds(10, 13, 150, 45);
		btnThemNV.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnThemNV);

		// JButton Sua Nhan Vien
		btnSuaNV = new JButton("Sửa");
		btnSuaNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSuaNV.setBackground(new Color(233, 180, 46));
		btnSuaNV.setBounds(170, 13, 150, 45);
		btnSuaNV.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnSuaNV);

		// JButton Xoa Nhan Vien
		btnXaThai = new JButton("Sa Thải");
		btnXaThai.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXaThai.setBackground(new Color(233, 180, 46));
		btnXaThai.setBounds(330, 13, 150, 45);
		btnXaThai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnXaThai);

		// Làm mới
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLamMoi.setBackground(new Color(233, 180, 46));
		btnLamMoi.setBounds(1424, 13, 150, 45);
		btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnLamMoi);

		// JButton Tim Kiem
		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnTimKiem.setBackground(new Color(233, 180, 46));
		btnTimKiem.setBounds(1265, 13, 150, 45);
		btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnTimKiem);

		// JTextField Tim Kiem
		txtTImKiem = new JTextField("", 100);
		txtTImKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTImKiem.setBounds(490, 16, 439, 40);
		pnlNgang.add(txtTImKiem);

		// JCombobox Tim kiem
		String loai[] = { "Tìm theo tên", "Tìm theo mã", "Tìm theo tuổi", "Đang làm việc", "Đã nghỉ việc" };
		cmbLoaiTimKiem = new JComboBox(loai);
		cmbLoaiTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbLoaiTimKiem.setBounds(939, 16, 316, 40);
		pnlNgang.add(cmbLoaiTimKiem);

		/*
		 * Phan Content
		 */
		// BackGround Content
		pnlContent = new JPanel();
		pnlContent.setLayout(null);
		pnlContent.setBackground(new Color(242, 129, 25));
		pnlContent.setBounds(0, 164, 1600, 845);
		add(pnlContent);

		// JLable title Bang
		lblThongTinNV = new JLabel("Thông tin nhân viên");
		lblThongTinNV.setForeground(Color.WHITE);
		lblThongTinNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblThongTinNV.setBounds(10, 11, 216, 34);
		pnlContent.add(lblThongTinNV);

		/*
		 * Hien So Luong Nhan Vien
		 */
		// JTextField Tong so Nhan Vien
		txtTongSoSV = new JTextField();
		txtTongSoSV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongSoSV.setEditable(false);
		txtTongSoSV.setColumns(10);
		txtTongSoSV.setBounds(1400, 11, 174, 32);
		pnlContent.add(txtTongSoSV);

		// JLable Tong so Nhan Vien
		lblTongSoNV = new JLabel("Tổng số nhân viên:");
		lblTongSoNV.setForeground(Color.WHITE);
		lblTongSoNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTongSoNV.setBounds(1180, 11, 210, 34);
		pnlContent.add(lblTongSoNV);

		/*
		 * Bang thong tin Nhan Vien
		 */
		// Thanh Cuon
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 1564, 723);
		pnlContent.add(scrollPane);
		// Header Title Nhan Vien
		String headerTitle[] = { "Mã","Họ và Tên", "Ngày Sinh", "SĐT", "Email", "Mức Lương", "Trạng Thái", "Địa chỉ" };
		// Model Table
		model = new DefaultTableModel(headerTitle, 50) {
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
		// Table
		table = new JTable(model);
		table.setRowHeight(35); // set height items
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Set Font title table
		JTableHeader headerTable = table.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		scrollPane.setViewportView(table);
		scrollPane.setEnabled(false);
		
		int[] i = {5};
		ChucNang.setRightAlignmentTable(i, table);

		JPanel panel = new JPanel();
		panel.setBounds(0, 780, 1600, 57);
		panel.setBackground(new Color(194, 93, 0));
		pnlContent.add(panel);
		panel.setLayout(null);

		txtSoTrang = new JTextField();
		txtSoTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoTrang.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSoTrang.setEditable(false);
		txtSoTrang.setBounds(725, 8, 150, 40);
		panel.add(txtSoTrang);

		btnTrai = new JButton("<");
		btnTrai.setForeground(Color.WHITE);
		btnTrai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrai.setBounds(626, 8, 89, 40);
		btnTrai.setBackground(new Color(233, 180, 46));
		btnTrai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnTrai);

		btnDoubleTrai = new JButton("<<");
		btnDoubleTrai.setForeground(Color.WHITE);
		btnDoubleTrai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDoubleTrai.setBounds(527, 8, 89, 40);
		btnDoubleTrai.setBackground(new Color(233, 180, 46));
		btnDoubleTrai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnDoubleTrai);

		btnPhai = new JButton(">");
		btnPhai.setForeground(Color.WHITE);
		btnPhai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPhai.setBounds(885, 8, 89, 40);
		btnPhai.setBackground(new Color(233, 180, 46));
		btnPhai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnPhai);

		btnDoublePhai = new JButton(">>");
		btnDoublePhai.setForeground(Color.WHITE);
		btnDoublePhai.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoublePhai.setBounds(984, 8, 89, 40);
		btnDoublePhai.setBackground(new Color(233, 180, 46));
		btnDoublePhai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnDoublePhai);

		// Thêm sự kiện cho các chức năng
		btnThemNV.addActionListener(this);
		btnXaThai.addActionListener(this);
		btnSuaNV.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnTrai.addActionListener(this);
		btnDoubleTrai.addActionListener(this);
		btnPhai.addActionListener(this);
		btnDoublePhai.addActionListener(this);
		cmbLoaiTimKiem.addItemListener(this);
		txtSoTrang.addActionListener(this);
		txtTImKiem.addActionListener(this);
		table.addMouseListener(this);

		/*
		 * Khai bao
		 */
		nvSV = new QuanLyNhanVienService();
		tongSV = 0;
		soTrang = 1;
		tongSotrang = 0;
		index = 0;
		list50NV = new ArrayList<NhanVien>();

		// Load Data To Table and JTextField Tong So NhanVien
		LoadMacDinh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// Sự kiện thêm nhân viên
		if (o.equals(btnThemNV)) {
			Gui_ThemNhanVien frm = new Gui_ThemNhanVien();
			frm.setVisible(true);
			if (frm.isVisible() == false) {
				System.out.println("test");
			}
			// Sự kiện sửa nhân viên
		} else if (o.equals(btnSuaNV)) {
			if (table.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Hãy chọn Nhân Viên cần sửa");
			} else {
				int index = table.getSelectedRow();
				NhanVien nv = nvSV.getNhanVienTheoMa(listMaNV.get(index));
				Gui_SuaNhanVien frm = new Gui_SuaNhanVien(nv);
				frm.setVisible(true);
			}
			// Sự kiện sa thải nhân viên
		} else if (o.equals(btnXaThai)) {
			if (table.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên để xa thải");
			} else {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xa thải Nhân viên này không ?",
						"Cảnh báo", JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					boolean rs = false;
					NhanVien nv = nvSV.getNhanVienTheoMa(listMaNV.get(table.getSelectedRow()));
					nv.settrangThaiLamViec(false);
					rs = nvSV.capNhatNhanVien(nv);
					if (rs == true) {
						JOptionPane.showMessageDialog(this, "Bạn đã xa thải nhân viên thành công");
						LoadMacDinh();
					} else
						JOptionPane.showMessageDialog(this, "Bạn đã xa thải nhân viên không thành công");
				}

			}
			// SỰ kiện Làm mới bản
		} else if (o.equals(btnLamMoi)) {
			LoadMacDinh();
			// Sự kiện chó nút tìm kiếm
		} else if (o.equals(btnTimKiem)) {
			String data = txtTImKiem.getText();
			String loaiTK = cmbLoaiTimKiem.getSelectedItem().toString();
			if (loaiTK.equals("Tìm theo tên")) {
				if (data.equals("")) {
					LoadMacDinh();
				} else {
					index = -1;
					List<NhanVien> list = nvSV.getNhanVienTheoTen(data);
					loadDuLieuCustom(list, 1, list.size());
				}
			} else if (loaiTK.equals("Tìm theo mã")) {
				NhanVien nv = nvSV.getNhanVienTheoMa(data);
				if (nv == null) {
					LoadMacDinh();
				} else {
					index = -1;
					ChucNang.clearDataTable(model);
					load1ThongTinNhanVien(nv);
					txtSoTrang.setText(1 + "");
					txtTongSoSV.setText(1 + "");
				}
			} else if (loaiTK.equals("Tìm theo tuổi")) {
				ChucNang.clearDataTable(model);
				try {
					if (data.equals("")) {
						LoadMacDinh();
					} else {
						index = -1;
						int tuoi = Integer.parseInt(data);
						List<NhanVien> list = nvSV.getDsNhanVienTheoTuoi(tuoi);
						loadDuLieuCustom(list, 1, list.size());
					}
				} catch (NumberFormatException e2) {
					LoadMacDinh();
					JOptionPane.showMessageDialog(this,
							"Lỗi nhập dữ liệu!\nKhông nhận kiểu dữ liệu ký tự\nHãy nhập số tuổi cần tìm\n");
				}
			}
			// Sự kiện chọn hàng trên
		} else if (o.equals(btnTrai)) {
			if (soTrang > 1 && soTrang <= tongSotrang && index != -1) {
				index = index - 50;
				list50NV = nvSV.get50NhanVienTheoViTriSapXepTheoTen(index);
				soTrang--;
				loadDuLieuCustom(list50NV, soTrang, tongSV);
			}
			// Sự kiện Chọn hàng đàu tiên
		} else if (o.equals(btnDoubleTrai)) {
			if (soTrang > 1 && soTrang <= tongSotrang && index != -1) {
				list50NV = nvSV.get50NhanVienTheoViTriSapXepTheoTen(0);
				soTrang = 1;
				index = 0;
				loadDuLieuCustom(list50NV, soTrang, tongSV);
			}
			// Sự kiện chọn hàng cuối
		} else if (o.equals(btnPhai)) {
			if (soTrang < tongSotrang && soTrang >= 1 && index != -1) {
				index = index + 50;
				list50NV = nvSV.get50NhanVienTheoViTriSapXepTheoTen(index);
				soTrang++;
				loadDuLieuCustom(list50NV, soTrang, tongSV);
			}
			// sự kiện chọn hàng cuối cùng
		} else if (o.equals(btnDoublePhai)) {
			if (soTrang < tongSotrang && soTrang >= 1 && index != -1) {
				for (int i = soTrang; i < tongSotrang; i++) {
					index += 50;
				}
				list50NV = nvSV.get50NhanVienTheoViTriSapXepTheoTen(index);
				soTrang = tongSotrang;
				loadDuLieuCustom(list50NV, soTrang, tongSV);
			}
			// Sự kiện cho nút Enter cho Text Số trang
		} else if (o.equals(txtSoTrang)) {
			// Chua lam
			// Sự kiện cho Text Tìm kiếm
		} else if (o.equals(txtTImKiem)) {
			String data = txtTImKiem.getText();
			String loaiTK = cmbLoaiTimKiem.getSelectedItem().toString();
			if (loaiTK.equals("Tìm theo tên")) {
				if (data.equals("")) {
					LoadMacDinh();
				} else {
					index = -1;
					List<NhanVien> list = nvSV.getNhanVienTheoTen(data);
					loadDuLieuCustom(list, 1, list.size());
				}
			} else if (loaiTK.equals("Tìm theo mã")) {
				NhanVien nv = nvSV.getNhanVienTheoMa(data);
				if (nv == null) {
					LoadMacDinh();
				} else {
					index = -1;
					ChucNang.clearDataTable(model);
					load1ThongTinNhanVien(nv);
					txtSoTrang.setText(1 + "");
					txtTongSoSV.setText(1 + "");
				}
			} else if (loaiTK.equals("Tìm theo tuổi")) {
				ChucNang.clearDataTable(model);
				try {
					if (data.equals("")) {
						LoadMacDinh();
					} else {
						index = -1;
						int tuoi = Integer.parseInt(data);
						List<NhanVien> list = nvSV.getDsNhanVienTheoTuoi(tuoi);
						loadDuLieuCustom(list, 1, list.size());
					}
				} catch (NumberFormatException e2) {
					LoadMacDinh();
					JOptionPane.showMessageDialog(this,
							"Lỗi nhập dữ liệu!\nKhông nhận kiểu dữ liệu ký tự\nHãy nhập số tuổi cần tìm\n");
				}
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox<String> cmb = (JComboBox<String>) e.getSource();
		if (cmb.getSelectedItem().equals("Đang làm việc")) {
			ChucNang.clearDataTable(model);
			index = -1;
			soTrang = 1;
			List<NhanVien> list = nvSV.getDsNhanVienTheoTrangThai(true);
			loadDuLieuCustom(list, soTrang, list.size());
		} else if (cmb.getSelectedItem().equals("Đã nghỉ việc")) {
			ChucNang.clearDataTable(model);
			index = -1;
			soTrang = 1;
			List<NhanVien> list = nvSV.getDsNhanVienTheoTrangThai(false);
			loadDuLieuCustom(list, soTrang = 1, list.size());
		} else {
			LoadMacDinh();
		}
	}

	/**
	 * Load Data to JTable NhanVien Load TongSoNhanVien to JTextField Tong So
	 * NhanVien
	 * 
	 * @param list
	 */
	private void LoadThongTinNhanVien(List<NhanVien> list) {
		ChucNang.clearDataTable(model);
		for (NhanVien nv : list) {
			load1ThongTinNhanVien(nv);
		}
		listMaNV = getDsMaNV(list);
	}

	public void load1ThongTinNhanVien(NhanVien nv) {
		String n[] = { nv.getMaNhanVien(), nv.getTenNhanVien(), dtf.format(nv.getNgaySinh()), nv.getsDT(), nv.getEmail(),
				vnFormat.format(nv.getMucLuong()), nv.gettrangThaiLamViec() == true ? "Đang Làm" : "Đã Nghỉ",
				nv.getDiaChi() };
		model.addRow(n);
		listMaNV = new ArrayList<String>();
		listMaNV.add(nv.getMaNhanVien());
	}

	private List<String> getDsMaNV(List<NhanVien> list) {
		List<String> listMa = new ArrayList<String>();
		for (NhanVien nv : list) {
			listMa.add(nv.getMaNhanVien());
		}
		return listMa;
	}

	private void loadDuLieuCustom(List<NhanVien> l, int st, int tsv) {
		LoadThongTinNhanVien(l);
		txtSoTrang.setText(st + "");
		txtTongSoSV.setText(tsv + "");
	}

	public void LoadMacDinh() {
		index = 0;
		List<NhanVien> list = nvSV.get50NhanVienTheoViTriSapXepTheoTen(index);
		LoadThongTinNhanVien(list);
		soTrang = 1;
		tongSV = nvSV.getNhanvienCount();
		tongSotrang = getSoTrang(tongSV);
		txtSoTrang.setText("1");
		txtTongSoSV.setText(tongSV + "");
	}

	public int getSoTrang(int tongsv) {
		double rs = (double) tongsv / (double) 50;
		double rs2 = tongsv / 50;
		if (rs == rs2)
			return (int) rs2;
		else
			return (int) rs2 + 1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
