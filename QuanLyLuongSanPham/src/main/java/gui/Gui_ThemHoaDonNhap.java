package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import gui_package.ChucNang;
import model.ChiTietHoaDonNhap;
import model.HoaDonNhapHang;
import model.NhanVien;
import model.SanPham;
import model.TaiKhoan;
import services.QuanLyHoaDonService;

public class Gui_ThemHoaDonNhap extends JDialog {

	private JPanel contentPane;
	private JTextField txtTenSp;
	private JTextField txtGiaThanh;
	private JTextField txtSoLuong;
	private JTextField txtThue;
	private JDateChooser txtNgaySanXuat;
	private JButton btnThem;
	private JComboBox cboLoai;
	private QuanLyHoaDonService quanLyHoaDonService;
	private JTable tblSanPham;
	private JMenuItem mnXoa;
	private JComboBox cboNhaCungCap;
	private JButton btnLapHoaDon;
	private JButton btnCong;
	private DefaultTableModel model;
	private TaiKhoan taiKhoan;
	private JTextField txtTongTien;
	private List<SanPham> dsSanPham;
	private List<ChiTietHoaDonNhap> dsChiTiet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_ThemHoaDonNhap frame = new Gui_ThemHoaDonNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_ThemHoaDonNhap() {
		setTitle("Thêm hóa đơn nhập hàng");
		setModal(true);

//			try {
//				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (InstantiationException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IllegalAccessException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (UnsupportedLookAndFeelException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		dsSanPham = new ArrayList<SanPham>();
		dsChiTiet = new ArrayList<ChiTietHoaDonNhap>();
		setIconImage(new ImageIcon("img/logo.png").getImage());
		quanLyHoaDonService = new QuanLyHoaDonService();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 998, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 129, 25));
		panel.setLocation(0, 0);
		panel.setSize(new Dimension(988, 84));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("THÊM HÓA ĐƠN NHẬP HÀNG");
		lblNewLabel.setBounds(0, 0, 985, 84);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(242, 129, 25));
		panel_1.setBounds(0, 86, 988, 553);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 198, 153));
		panel_2.setBounds(10, 10, 957, 201);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(39, 10, 175, 35);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Giá thành:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(569, 100, 119, 35);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Ngày sản xuất:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_3.setBounds(39, 100, 180, 35);
		panel_2.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Số lượng:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4.setBounds(37, 145, 139, 35);
		panel_2.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Nhà cung cấp:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_5.setBounds(39, 55, 201, 35);
		panel_2.add(lblNewLabel_1_5);

		txtTenSp = new JTextField();
		txtTenSp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenSp.setBounds(236, 10, 323, 35);
		panel_2.add(txtTenSp);
		txtTenSp.setColumns(10);

		txtGiaThanh = new JTextField();
		txtGiaThanh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGiaThanh.setColumns(10);
		txtGiaThanh.setBounds(698, 100, 238, 35);
		panel_2.add(txtGiaThanh);

		txtNgaySanXuat = new JDateChooser(new Date());
		txtNgaySanXuat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNgaySanXuat.setBounds(236, 100, 323, 35);
		txtNgaySanXuat.setDateFormatString("dd/MM/yyyy");
		panel_2.add(txtNgaySanXuat);

		txtSoLuong = new JTextField();
		txtSoLuong.setText("1");
		txtSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(290, 145, 214, 35);
		panel_2.add(txtSoLuong);

		txtThue = new JTextField();
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtThue.setToolTipText("Nhâp vào thuế từ 0% đến 100%");
		txtThue.setColumns(10);
		txtThue.setBounds(697, 145, 238, 35);
		
		panel_2.add(txtThue);

		JLabel lblNewLabel_1_4_1 = new JLabel("Thuế:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4_1.setBounds(569, 145, 79, 35);
		panel_2.add(lblNewLabel_1_4_1);

		cboNhaCungCap = new JComboBox();
		cboNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cboNhaCungCap.setBounds(236, 55, 323, 35);
		panel_2.add(cboNhaCungCap);

		cboLoai = new JComboBox();
		cboLoai.setBounds(697, 55, 239, 35);
		panel_2.add(cboLoai);
		cboLoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cboLoai.setModel(new DefaultComboBoxModel(new String[] { "Điện Thoại", "Phụ kiện" }));

		JLabel lblNewLabel_1_2 = new JLabel("Loại:");
		lblNewLabel_1_2.setBounds(569, 55, 70, 35);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnTru = new JButton("-");
		btnTru.setToolTipText("Hủy thao tác thêm");
		btnTru.setForeground(Color.WHITE);
		btnTru.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnTru.setBackground(new Color(233, 180, 46));
		btnTru.setBounds(236, 145, 56, 35);
		panel_2.add(btnTru);

		btnCong = new JButton("+");
		btnCong.setToolTipText("Hủy thao tác thêm");
		btnCong.setForeground(Color.WHITE);
		btnCong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCong.setBackground(new Color(233, 180, 46));
		btnCong.setBounds(503, 145, 56, 35);
		panel_2.add(btnCong);

		btnThem = new JButton("Thêm");
		btnThem.setToolTipText("Hoàn tất thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setBackground(new Color(233, 180, 46));
		btnThem.setBounds(661, 221, 127, 34);
		panel_1.add(btnThem);

		JButton btnHuy = new JButton("Hủy bỏ");
		btnHuy.setToolTipText("Hủy thao tác thêm");
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnHuy.setBackground(new Color(233, 180, 46));
		btnHuy.setBounds(534, 221, 127, 34);
		panel_1.add(btnHuy);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 265, 964, 278);
		panel_1.add(scrollPane);

		tblSanPham = new JTable();
		tblSanPham.setRowHeight(24);
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JTableHeader headerTable = tblSanPham.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headerTable.setBackground(new Color(248, 198, 153));

		model = new DefaultTableModel(new String[] { "T\u00EAn s\u1EA3n ph\u1EA9m", "Nh\u00E0 cung c\u1EA5p",
				"Ng\u00E0y s\u1EA3n xu\u1EA5t ", "Lo\u1EA1i ", "Gi\u00E1 th\u00E0nh ", "Thu\u1EBF ","Số lượng"}, 15);
		tblSanPham.setModel(model);
		scrollPane.setViewportView(tblSanPham);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tblSanPham, popupMenu);

		mnXoa = new JMenuItem("Xóa");
		popupMenu.add(mnXoa);
		ChucNang.setTableAlternateRow();
		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setToolTipText("Hoàn tất thêm");
		btnLapHoaDon.setForeground(Color.WHITE);
		btnLapHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLapHoaDon.setBackground(new Color(233, 180, 46));
		btnLapHoaDon.setBounds(786, 221, 181, 34);
		panel_1.add(btnLapHoaDon);

		JLabel lblNewLabel_2 = new JLabel("Tổng tiền");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 222, 106, 33);
		panel_1.add(lblNewLabel_2);

		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(114, 222, 238, 35);
		panel_1.add(txtTongTien);

		loadNcc();
		btnHuy.addActionListener(e -> {
			this.dispose();
		});
		btnCong.addActionListener(e -> {
			try {
				int sl = 1;
				if (txtSoLuong.getText().trim().equals("")) {
					txtSoLuong.setText("" + sl);
					return;
				}
				sl = Integer.parseInt(txtSoLuong.getText().trim());
				if (sl < 1) {
					txtSoLuong.setText("" + 1);
					return;
				}
				sl++;
				txtSoLuong.setText("" + sl);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Phải nhập số");
				txtSoLuong.requestFocus();
				txtSoLuong.selectAll();
			}

		});
		btnTru.addActionListener(e -> {
			try {
				int sl = 1;
				if (txtSoLuong.getText().trim().equals("")) {
					txtSoLuong.setText("" + sl);
					return;
				}
				sl = Integer.parseInt(txtSoLuong.getText().trim());
				if (sl <= 1) {
					txtSoLuong.setText("" + 1);
					return;
				}
				sl--;
				txtSoLuong.setText("" + sl);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Phải nhập số");
				txtSoLuong.requestFocus();
				txtSoLuong.selectAll();
			}
		});
		btnThem.addActionListener(e -> {
			if (kiemTraDuLieu() == true) {
//				SinhMaThuCong sinhMaThuCong= new SinhMaThuCong("SP",HibernateConfig.getInstance().getSessionFactory().getCurrentSession() );
				HoaDonNhapHang hoaDonNhapHang = getHoaDonNhapByForm();
				ChiTietHoaDonNhap chiTietHoaDonNhap = getChiTietFromForm();
				SanPham sanPham = getSanPhamFromForm();
				dsSanPham.add(sanPham);
				dsChiTiet.add(chiTietHoaDonNhap);
				hoaDonNhapHang.setDsChiTietHoaDonNhap(dsChiTiet);
				NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
				Object[] rowData = { sanPham.getTenSanPham(), sanPham.getnCC(), sanPham.getNgaySanXuat(),
						sanPham.getLoai(), format.format(sanPham.getGiaThanh()), hoaDonNhapHang.getThue()*100 +"%", chiTietHoaDonNhap.getSoLoHang() };
				txtTongTien.setText(format.format(hoaDonNhapHang.getThanhTien()) + " VND");
				ChucNang.clearDataNullTable(model);
				model.addRow(rowData);
				ChucNang.addNullDataTable(model);
			}
		});
		
		mnXoa.addActionListener(e->{
			int index = tblSanPham.getSelectedRow();
			if(tblSanPham.getValueAt(index, 0)== null) {
				return;
			}
			dsChiTiet.remove(index);
			dsSanPham.remove(index);
			model.removeRow(index);
		});
		btnLapHoaDon.addActionListener(e -> {
			if (dsChiTiet.size() <= 0) {
				JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào được thêm", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return;
			}
//			temp=JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm hóa đơn với "++"")
			HoaDonNhapHang hoaDonNhapHang = getHoaDonNhapByForm();
			hoaDonNhapHang.setDsChiTietHoaDonNhap(dsChiTiet);
			if (quanLyHoaDonService.themHoaDonNhap(hoaDonNhapHang)) {
				for (ChiTietHoaDonNhap chiTietHoaDonNhap : dsChiTiet) {
					chiTietHoaDonNhap.setHoaDonNhapHang(hoaDonNhapHang);
					quanLyHoaDonService.themChiTietNhap(chiTietHoaDonNhap);
				}
				JOptionPane.showMessageDialog(this, "lập hóa đơn thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTenSp.requestFocus();
				txtTenSp.selectAll();
			} else
				JOptionPane.showMessageDialog(this, "Lập hóa đơn thất bại", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);

		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public HoaDonNhapHang getHoaDonNhapByForm() {
		NhanVien nhanVien = taiKhoan.getNhanVien();
		double thue = Double.parseDouble(txtThue.getText().trim());
		return new HoaDonNhapHang(thue/100, nhanVien);
	}

	public SanPham getSanPhamFromForm() {
		String ten = txtTenSp.getText().trim();
		String ncc = (String) cboNhaCungCap.getSelectedItem();
		String loai = (String) cboLoai.getSelectedItem();
		LocalDate nsx = txtNgaySanXuat.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		double gia = Double.parseDouble(txtGiaThanh.getText().trim());

		SanPham sanPham = new SanPham(ten, gia, ncc, loai, nsx, true);
		return sanPham;
	}

	public ChiTietHoaDonNhap getChiTietFromForm() {
		HoaDonNhapHang hoaDonNhapHang = getHoaDonNhapByForm();
		SanPham sanPham = getSanPhamFromForm();
		int sl = Integer.parseInt(txtSoLuong.getText().trim());
		ChiTietHoaDonNhap chiTietHoaDonNhap = new ChiTietHoaDonNhap(sanPham.getGiaThanh(), sl);
		chiTietHoaDonNhap.setSanPham(sanPham);
		chiTietHoaDonNhap.setHoaDonNhapHang(hoaDonNhapHang);
		return chiTietHoaDonNhap;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public boolean kiemTraDuLieu() {
		String ten = txtTenSp.getText().trim();
		LocalDate date = txtNgaySanXuat.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		if (!ten.matches(
				"[A-Za-z0-9a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s\\.'\\-]+")) {
			JOptionPane.showMessageDialog(this, "Tên không được để trống, không chưa kí tự đặc biệt", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (date.isAfter(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "Ngày sản xuất phải có trước ngày hiện tại", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			double thue = Double.parseDouble(txtThue.getText().trim());
			if(thue<0) {
				JOptionPane.showMessageDialog(this, "Thuế không được âm", "Lỗi", JOptionPane.ERROR_MESSAGE);
				txtThue.requestFocus();
				txtThue.selectAll();
				return false;
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Thuế phải là số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtThue.requestFocus();
			txtThue.selectAll();
			return false;
		}
		try {
			int sl = Integer.parseInt(txtSoLuong.getText().trim());
			if(sl<0) {
				JOptionPane.showMessageDialog(this, "Số lượng không được âm", "Lỗi", JOptionPane.ERROR_MESSAGE);
				txtThue.requestFocus();
				txtThue.selectAll();
				return false;
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public void loadNcc() {
		List<String> dsNcc = quanLyHoaDonService.getNhaCungCap();
		for (String string : dsNcc) {
			cboNhaCungCap.addItem(string);
		}
	}
}
