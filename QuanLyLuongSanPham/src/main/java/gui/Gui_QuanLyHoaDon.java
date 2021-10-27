package gui;
//chinh pro
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import gui_package.ChucNang;

import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Gui_QuanLyHoaDon extends JPanel {
	private JTextField textField;
	private JTable tblHoaDon;
	private JTable tblChiTiet;
	private JLabel lblNgay;
	private JButton btnThemHoaDon;
	private JLabel lblGio;
	private JLabel lblMaKhachHang;
	private JLabel lblSdt;
	private JLabel lblTenKhachHang;
	private JLabel lblDiaChi;
	private JLabel lblNgaySinh;
	private JComboBox cboTimKiem;

	/**
	 * Create the panel.
	 */
	public Gui_QuanLyHoaDon() {
		
		setBackground(new Color(242,129,25));
		setPreferredSize(new Dimension(1600, 1046));
		setMinimumSize(new Dimension(1600, 1046));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242,129,25));
		panel.setBounds(0, 0, 1600, 92);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_2.setBounds(491, 0, 531, 92);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Chinh");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setIcon(new ImageIcon("D:\\workspace\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\src\\main\\resources\\images\\img_bill\\uerlogin.PNG"));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_5.setBounds(1393, 10, 192, 45);
		panel.add(lblNewLabel_5);
		
		lblNgay = new JLabel("New label");
		lblNgay.setForeground(new Color(255, 255, 255));
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setBounds(0, 16, 233, 33);
		panel.add(lblNgay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(194, 93, 0));
		panel_1.setPreferredSize(new Dimension(1600, 72));
		panel_1.setBounds(0, 92, 1600, 72);
		add(panel_1);
		
		btnThemHoaDon = new JButton("Thêm hóa đơn");
		btnThemHoaDon.setBounds(409, 15, 204, 41);
		panel_1.setLayout(null);
		
		JComboBox cboLoaiHoaDon = new JComboBox();
		cboLoaiHoaDon.setBounds(0, 11, 207, 45);
		cboLoaiHoaDon.setModel(new DefaultComboBoxModel(new String[] {"Hóa đơn bán", "Hóa đơn nhập"}));
		cboLoaiHoaDon.setSelectedIndex(0);
		cboLoaiHoaDon.setForeground(Color.WHITE);
		cboLoaiHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboLoaiHoaDon.setBackground(new Color(233, 180, 46));
		panel_1.add(cboLoaiHoaDon);
		btnThemHoaDon.setForeground(Color.WHITE);
		btnThemHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThemHoaDon.setBackground(new Color(233, 180, 46));
		panel_1.add(btnThemHoaDon);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(630, 16, 161, 40);
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXoa.setBackground(new Color(233, 180, 46));
		panel_1.add(btnXoa);
		
		JDateChooser txtNgayLap = new JDateChooser(new Date());
		txtNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNgayLap.setForeground(Color.WHITE);
		txtNgayLap.setBounds(222, 11, 161, 45);
		txtNgayLap.setDateFormatString("dd/MM /yyyy");
		panel_1.add(txtNgayLap);
		
		cboTimKiem = new JComboBox();
		cboTimKiem.setToolTipText("Loại tìm kiếm");
		cboTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên", "tìm mã khách"}));
		cboTimKiem.setSelectedIndex(1);
		cboTimKiem.setForeground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboTimKiem.setBackground(new Color(233, 180, 46));
		cboTimKiem.setBounds(1400, 11, 185, 45);
		panel_1.add(cboTimKiem);
		
		textField = new JTextField();
		textField.setBounds(1109, 11, 276, 45);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 153, 0));
		scrollPane.setBounds(0, 206, 1600, 426);
		add(scrollPane);
		
		tblHoaDon = new JTable();
		tblHoaDon.setRowHeight(36);
		tblHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "Khuy\u1EBFn m\u00E3i", "Thu\u1EBF", "Th\u00E0nh ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(tblHoaDon);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		scrollPane_1.setBounds(0, 674, 1150, 362);
		add(scrollPane_1);
		
		tblChiTiet = new JTable();
		tblChiTiet.setRowHeight(36);
		tblChiTiet.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(tblChiTiet);
		
		JLabel lblNewLabel = new JLabel("Bảng hóa đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 170, 161, 20);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Chi tiết hóa đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 648, 268, 20);
		add(lblNewLabel_1);
		
		
		lblGio = new JLabel("New label");
		lblGio.setForeground(new Color(255, 255, 255));
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(0, 50, 201, 42);
		panel.add(lblGio);
		
		ChucNang.setGio(lblGio, lblNgay);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(248, 198, 153));
		panel_4.setBounds(1177, 674, 396, 362);
		add(panel_4);
		
		lblMaKhachHang = new JLabel("Mã Khách Hàng: KH123");
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMaKhachHang.setBounds(15, 64, 345, 35);
		panel_4.add(lblMaKhachHang);
		
		lblSdt = new JLabel("Số điện thoại: 0967127083");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSdt.setBounds(15, 115, 356, 35);
		panel_4.add(lblSdt);
		
		lblDiaChi = new JLabel("Địa chỉ: Đăk Nông");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setBounds(15, 226, 368, 35);
		panel_4.add(lblDiaChi);
		
		lblNgaySinh = new JLabel("Ngày sinh: 15/06/2001");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgaySinh.setBounds(15, 277, 356, 35);
		panel_4.add(lblNgaySinh);
		
		JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
		lblThngTinKhch.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblThngTinKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinKhch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblThngTinKhch.setBounds(0, 0, 396, 51);
		panel_4.add(lblThngTinKhch);
		
		lblTenKhachHang = new JLabel("Ten: Hoang Van Chinh");
		lblTenKhachHang.setBounds(15, 168, 368, 42);
		panel_4.add(lblTenKhachHang);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ChucNang.setTableAlternateRow();
		btnThemHoaDon.addActionListener(e->{
			int i= cboLoaiHoaDon.getSelectedIndex();
			if(i==0) {
				Gui_ThemHoaDonBan themHoaDonBan= new Gui_ThemHoaDonBan();
				themHoaDonBan.setVisible(getFocusTraversalKeysEnabled());
			}
			else {
				Gui_ThemHoaDonNhap themHoaDonNhap= new Gui_ThemHoaDonNhap();
				themHoaDonNhap.setVisible(getFocusTraversalKeysEnabled());
			}
			
		});
	}
	public static void main(String[] args) {
		JFrame frame= new JFrame();
		frame.setSize(1600,1046);
		frame.getContentPane().add(new Gui_QuanLyHoaDon());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
