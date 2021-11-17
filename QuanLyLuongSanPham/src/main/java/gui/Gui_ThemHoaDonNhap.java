package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import model.ChiTietHoaDonNhap;
import model.HoaDonBanHang;
import model.HoaDonNhapHang;
import model.NhanVien;
import model.SanPham;
import services.QuanLyHoaDonService;

public class Gui_ThemHoaDonNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenSp;
	private JTextField txtGiaThanh;
	private JTextField txtNhaCungCap;
	private JTextField txtSoLuong;
	private JTextField txtThue;
	private JDateChooser txtNgaySanXuat;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JComboBox cboLoai;
	private QuanLyHoaDonService quanLyHoaDonService;

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
		setIconImage(new ImageIcon("img/logo.png").getImage());
		quanLyHoaDonService = new QuanLyHoaDonService();
		setMinimumSize(new Dimension(1440, 1024));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1440, 833);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 129, 25));
		panel.setLocation(0, 0);
		panel.setSize(new Dimension(1440, 137));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("THÊM HÓA ĐƠN NHẬP HÀNG");
		lblNewLabel.setBounds(282, 32, 871, 73);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(242, 129, 25));
		panel_1.setBounds(0, 140, 1440, 845);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 198, 153));
		panel_2.setBounds(134, 65, 1174, 627);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(95, 110, 201, 59);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Giá thành:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(95, 189, 158, 59);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Loại:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(95, 271, 201, 59);
		panel_2.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Ngày sản xuất:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_3.setBounds(95, 453, 201, 59);
		panel_2.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Số lượng:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4.setBounds(95, 537, 139, 59);
		panel_2.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Nhà cung cấp:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_5.setBounds(95, 359, 201, 59);
		panel_2.add(lblNewLabel_1_5);

		txtTenSp = new JTextField();
		txtTenSp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenSp.setBounds(300, 110, 734, 59);
		panel_2.add(txtTenSp);
		txtTenSp.setColumns(10);

		txtGiaThanh = new JTextField();
		txtGiaThanh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtGiaThanh.setColumns(10);
		txtGiaThanh.setBounds(300, 189, 734, 59);
		panel_2.add(txtGiaThanh);

		txtNhaCungCap = new JTextField();
		txtNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNhaCungCap.setColumns(10);
		txtNhaCungCap.setBounds(300, 359, 734, 59);
		panel_2.add(txtNhaCungCap);

		txtNgaySanXuat = new JDateChooser();
		txtNgaySanXuat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtNgaySanXuat.setBounds(300, 453, 734, 59);
		txtNgaySanXuat.setDateFormatString("dd/mm/yyyy");
		panel_2.add(txtNgaySanXuat);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(300, 537, 323, 59);
		panel_2.add(txtSoLuong);

		txtThue = new JTextField();
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtThue.setToolTipText("Nhâp vào thuế từ 0% đến 100%");
		txtThue.setColumns(10);
		txtThue.setBounds(711, 537, 323, 59);
		panel_2.add(txtThue);

		JLabel lblNewLabel_1_4_1 = new JLabel("Thuế:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4_1.setBounds(633, 537, 79, 59);
		panel_2.add(lblNewLabel_1_4_1);

		cboLoai = new JComboBox();
		cboLoai.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboLoai.setModel(new DefaultComboBoxModel(new String[] { "Điện Thoại", "Phụ kiện" }));
		cboLoai.setBounds(300, 271, 734, 59);
		panel_2.add(cboLoai);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox_1.setBounds(300, 31, 733, 59);
		panel_2.add(comboBox_1);
		comboBox_1.setToolTipText("Nhập mã sản phẩm");
		comboBox_1.setEditable(true);

		JLabel lblNewLabel_2 = new JLabel("Tìm sản phẩm cũ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(95, 31, 201, 50);
		panel_2.add(lblNewLabel_2);

		btnThem = new JButton("Thêm");
		btnThem.setToolTipText("Hoàn tất thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnThem.setBackground(new Color(233, 180, 46));
		btnThem.setBounds(224, 725, 250, 90);
		panel_1.add(btnThem);

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setToolTipText("Làm rỗng textBox");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(574, 725, 250, 90);
		panel_1.add(btnXoaRong);

		JButton btnHuy = new JButton("Hủy bỏ");
		btnHuy.setToolTipText("Hủy thao tác thêm");
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHuy.setBackground(new Color(233, 180, 46));
		btnHuy.setBounds(915, 725, 250, 90);
		panel_1.add(btnHuy);
		btnHuy.addActionListener(e -> {
			this.dispose();
		});
		btnXoaRong.addActionListener(e -> {
			SanPham sanPham = new SanPham(getTitle(), ABORT, getWarningString(), getName(), null,
					rootPaneCheckingEnabled);

		});
		btnThem.addActionListener(e -> {
			HoaDonNhapHang hoaDonNhapHang = getHoaDonFromTextBox();

		});

	}

	public SanPham getSanPhamFromTextBox() {
		String tenSp = txtTenSp.getText().trim();
		String gia = txtGiaThanh.getText().trim();
		String loai = (String) cboLoai.getSelectedItem();
		String ncc = txtNhaCungCap.getText().trim();
		Date date = txtNgaySanXuat.getDate();
		LocalDate nsx = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
		SanPham sanPham = new SanPham(tenSp, Double.parseDouble(gia), ncc, loai, nsx, true);
		quanLyHoaDonService.themSanPham(sanPham);
		return sanPham;

	}

	public HoaDonNhapHang getHoaDonFromTextBox() {
		String soLuong = txtSoLuong.getText().trim();
		String thue = txtThue.getText().trim();
		NhanVien nhanVien = new NhanVien("NV20110002");
		HoaDonNhapHang hoaDon = new HoaDonNhapHang(Double.parseDouble(thue) / 100, nhanVien);
		SanPham SanPham = this.getSanPhamFromTextBox();
		ChiTietHoaDonNhap chiTiet = new ChiTietHoaDonNhap(SanPham.getGiaThanh(), Integer.parseInt(soLuong));
		chiTiet.setSanPham(SanPham);
		chiTiet.setHoaDonNhapHang(hoaDon);
		hoaDon.setDsChiTietHoaDonNhap(Arrays.asList(chiTiet));

		if (quanLyHoaDonService.themHoaDonNhap(hoaDon)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(this, "Thêm thất bại");
		}
		quanLyHoaDonService.themChiTietNhap(chiTiet);

		return hoaDon;

	}
}
