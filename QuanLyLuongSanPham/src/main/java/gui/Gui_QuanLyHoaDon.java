package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import gui_package.ChucNang;
import services.QuanLyHoaDonService;

public class Gui_QuanLyHoaDon extends JPanel implements MouseListener {
	private JTextField txtTimKiem;
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
	private QuanLyHoaDonService quanLyHoaDonService = new QuanLyHoaDonService();
	private DefaultTableModel modelHoaDon;
	private DefaultTableModel modelChiTiet;
	private JDateChooser txtNgayLap;
	private JComboBox cboLoaiHoaDon;

	/**
	 * Create the panel.
	 */
	public Gui_QuanLyHoaDon() {

		setBackground(new Color(242, 129, 25));
		setPreferredSize(new Dimension(1600, 1046));
		setMinimumSize(new Dimension(1600, 1046));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 129, 25));
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
		lblNewLabel_5.setIcon(new ImageIcon("src/main/resources/images/img_bill/uerlogin.PNG"));
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

		cboLoaiHoaDon = new JComboBox();
		cboLoaiHoaDon.setBounds(0, 11, 207, 45);
		cboLoaiHoaDon.setModel(new DefaultComboBoxModel(new String[] { "Hóa đơn bán", "Hóa đơn nhập" }));
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

		txtNgayLap = new JDateChooser((new JCalendar()).getDate());
		txtNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNgayLap.setForeground(Color.WHITE);
		txtNgayLap.setBounds(222, 11, 161, 45);
		txtNgayLap.setDateFormatString("dd/MM/yyyy");
		panel_1.add(txtNgayLap);

		cboTimKiem = new JComboBox();
		cboTimKiem.setToolTipText("Tìm kiếm hóa đơn theo các tiêu chí ");
		cboTimKiem.setModel(new DefaultComboBoxModel(new String[] { "Mã hóa đơn" , "Số điện thoại Khách", "Theo tên khách"}));
		cboTimKiem.setSelectedIndex(0);
		cboTimKiem.setForeground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboTimKiem.setBackground(new Color(233, 180, 46));
		cboTimKiem.setBounds(1360, 11, 225, 45);
		panel_1.add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setToolTipText("Nhập vào thông tin tìm kiếm");
		txtTimKiem.setBounds(1001, 11, 349, 45);
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 153, 0));
		scrollPane.setBounds(0, 206, 1600, 426);
		add(scrollPane);

		modelHoaDon = new DefaultTableModel(new String[] { "M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp",
				"Khuy\u1EBFn m\u00E3i", "Thu\u1EBF", "Th\u00E0nh ti\u1EC1n" },10) {
			@Override
			public boolean isCellEditable(int row,int col) {
				return false;
			}
		};
		
		
		tblHoaDon = new JTable(modelHoaDon);
		tblHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblHoaDon.setRowMargin(5);
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblHoaDon.setRowHeight(36);
		JTableHeader headerTable = tblHoaDon.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		scrollPane.setViewportView(tblHoaDon);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		scrollPane_1.setBounds(0, 679, 1150, 362);
		add(scrollPane_1);

		modelChiTiet = new DefaultTableModel(new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
				"\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng ti\u1EC1n" }, 0){
			@Override
			public boolean isCellEditable(int row,int col) {
				return false;
			}
		};
		tblChiTiet = new JTable();
		tblChiTiet.setRowHeight(36);
		tblChiTiet.setModel(modelChiTiet);
		JTableHeader headerTable1 = tblChiTiet.getTableHeader();
		headerTable1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable1.setBackground(new Color(248, 198, 153));
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
		lblSdt.setBounds(15, 115, 381, 35);
		panel_4.add(lblSdt);

		lblDiaChi = new JLabel("Địa chỉ: Đăk Nông");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setBounds(15, 226, 381, 35);
		panel_4.add(lblDiaChi);

		lblNgaySinh = new JLabel("Mã nhân viên:");
		lblNgaySinh.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNgaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgaySinh.setBorder(new LineBorder(Color.WHITE));
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgaySinh.setBounds(0, 272, 396, 90);
		panel_4.add(lblNgaySinh);

		JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
		lblThngTinKhch.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblThngTinKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinKhch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblThngTinKhch.setBounds(0, 0, 396, 51);
		panel_4.add(lblThngTinKhch);

		lblTenKhachHang = new JLabel("Ten: Hoang Van Chinh");
		lblTenKhachHang.setBounds(15, 168, 381, 42);
		panel_4.add(lblTenKhachHang);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ChucNang.setTableAlternateRow();
		tblHoaDon.addMouseListener(this);
		txtNgayLap.addPropertyChangeListener(e -> {
			modelHoaDon.getDataVector().removeAllElements();
			tblHoaDon.removeAll();
			modelChiTiet.getDataVector().removeAllElements();
			tblChiTiet.removeAll();
			Date input = txtNgayLap.getDate();
			LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			System.out.println(date);
			loadTableHoaDon(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
		});
		btnThemHoaDon.addActionListener(e -> {
			int i = cboLoaiHoaDon.getSelectedIndex();
			if (i == 0) {
				Gui_ThemHoaDonBan themHoaDonBan = new Gui_ThemHoaDonBan();
				themHoaDonBan.setVisible(getFocusTraversalKeysEnabled());
			} else {
				Gui_ThemHoaDonNhap themHoaDonNhap = new Gui_ThemHoaDonNhap();
				themHoaDonNhap.setVisible(getFocusTraversalKeysEnabled());
			}

		});
		cboLoaiHoaDon.addActionListener(e -> {
			modelHoaDon.getDataVector().removeAllElements();
			tblHoaDon.removeAll();
			modelChiTiet.getDataVector().removeAllElements();
			tblChiTiet.removeAll();
			txtNgayLap.getJCalendar();
			Date input = txtNgayLap.getDate();
			LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			loadTableHoaDon(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
		});
	}

	/**
	 * load hóa đơn mặc định là ngày hiện tại
	 */
	private void loadTableHoaDon(int ngay, int thang, int nam) {
		int temp = cboLoaiHoaDon.getSelectedIndex();
		if (temp == 0) {
			List<?> list = quanLyHoaDonService.getHoaDonTheoNgay(ngay, thang, nam);
			for (Object object : list) {
				Object[] o = (Object[]) object;

				NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
				o[4] = format.format(Double.parseDouble(o[4].toString()));
				modelHoaDon.addRow(o);
			}
		} else if (temp == 1) {
			List<?> list1 = quanLyHoaDonService.getHoaDonNhapTheoNgay(ngay, thang, nam);
			for (Object object : list1) {
				Object[] o = (Object[]) object;
				NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
				o[2] = format.format(Double.parseDouble(o[2].toString()));
				o[4] = format.format(Double.parseDouble(o[4].toString()));
				modelHoaDon.addRow(o);
			}
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1600, 1046);
		frame.getContentPane().add(new Gui_QuanLyHoaDon());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();
		if (ob.equals(tblHoaDon)) {
			int temp = cboLoaiHoaDon.getSelectedIndex();
			if (temp == 0) {
				modelChiTiet.getDataVector().removeAllElements();
				tblChiTiet.removeAll();
				int row = tblHoaDon.getSelectedRow();
				String maHoaDon = (String) tblHoaDon.getValueAt(row, 0);
				List<?> listChiTiet = quanLyHoaDonService.getChiTietHoaDonBanTheoMaHoaDon(maHoaDon);
				if (listChiTiet.size() != 0) {
					for (Object object : listChiTiet) {
						Object[] o = (Object[]) object;
						NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
						o[4] = format.format(Double.parseDouble(o[4].toString()));
						o[2] = format.format(Double.parseDouble(o[2].toString()));
						modelChiTiet.addRow(o);
						System.out.println(o);
					}
				}
			} else if (temp == 1) {
				modelChiTiet.getDataVector().removeAllElements();
				tblChiTiet.removeAll();
				int row = tblHoaDon.getSelectedRow();
				String maHoaDon = (String) tblHoaDon.getValueAt(row, 0);
				List<?> listChiTiet = quanLyHoaDonService.getChiTietHoaDonNhapTheoMaHoaNhap(maHoaDon);
				if (listChiTiet.size() != 0) {
					for (Object object : listChiTiet) {
						Object[] o = (Object[]) object;
						NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
						o[4] = format.format(Double.parseDouble(o[4].toString()));
						o[2] = format.format(Double.parseDouble(o[2].toString()));
						modelChiTiet.addRow(o);
						System.out.println(o);
					}
				}
			}
		}

	}

	public void chucNangCboTimKIem() {
		int temp = cboTimKiem.getSelectedIndex();
		if (temp == 1) {

		} else if (temp == 2) {

		} else if (temp == 3) {

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
