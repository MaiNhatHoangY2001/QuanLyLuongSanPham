package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JYearChooser;

import gui_package.ChucNang;
import model.BangLuong;
import model.NhanVien;
import services.ThongKeService;
import gui_package.RoundedPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_ThongKeThuChi extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblGio;
	private JLabel lblNgay;
	private JYearChooser spnYear;
	private JButton btnHienTai;
	private String[] colsThongKe = { "Tháng", "Tổng Tiền bán sản phẩm", "Tiền nhập sản phẩm", "Tiền Lương nhân viên" };
	private String[] colsSanPham = { "STT", "Tên sản phẩm", "Số lượng bán" };
	private JTable tblThongKe;
	private DefaultTableModel modelThongKe;
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	// Format tiền theo VND
	private NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
	private JLabel lblTongDoanhThu;
	private JLabel lblTongTienChi;
	private JLabel lblTongTienThu;
	private JTable tblSanPham;
	private DefaultTableModel modelSanPham;
	protected JPanel pnlHead;

	/**
	 * Create the frame.
	 */
	public Gui_ThongKeThuChi() {
		setSize(1600, 1046);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		pnlHead = new JPanel();
		pnlHead.setLayout(null);
		pnlHead.setBackground(new Color(242, 129, 25));
		pnlHead.setBounds(0, 0, 1600, 92);
		add(pnlHead);

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
		Image imgUser = new ImageIcon("img\\user1.png").getImage();
		Image imgDX = new ImageIcon("img\\dangxuat.png").getImage();

		/**
		 * 
		 * spnYear
		 */

		spnYear = new JYearChooser();
		spnYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnYear.setBounds(605, 14, 112, 47);
		panel_1_1.add(spnYear);

		spnYear.addPropertyChangeListener("year", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setDataThongKe(spnYear.getYear());
			}
		});

		btnHienTai = new JButton("Hiện tại");
		btnHienTai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHienTai.setForeground(Color.WHITE);
		btnHienTai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHienTai.setFocusPainted(false);
		btnHienTai.setBorderPainted(false);
		btnHienTai.setBackground(new Color(233, 180, 46));
		btnHienTai.setBounds(727, 14, 112, 47);
		panel_1_1.add(btnHienTai);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(e -> {
			setDataThongKe(spnYear.getYear());
		});
		btnLamMoi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorderPainted(false);
		btnLamMoi.setBackground(new Color(233, 180, 46));
		btnLamMoi.setBounds(849, 14, 112, 47);
		panel_1_1.add(btnLamMoi);
		btnHienTai.addActionListener(e -> {
			spnYear.setYear(LocalDate.now().getYear());
		});

		/**
		 * Thống kê dữ liệu trong tháng
		 */
		new DefaultTableModel(colsThongKe, 0);
		tblThongKe = new JTable(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null } },
				colsThongKe)) {

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
		thanhCuon.setBounds(10, 797, 750, 205);
		thanhCuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon.setToolTipText("Thống kê dữ liệu trong tháng");

		add(thanhCuon);
		modelThongKe = (DefaultTableModel) tblThongKe.getModel();

		// Căn chữ của cột sang phải
		int[] listCanPhaiTblThongKe = { 1, 2, 3 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblThongKe, tblThongKe);

		// Căn chữ của cột sang giua
		int[] listCanGiuaTblThongKe = { 0 };
		ChucNang.setCenterAlignmentTable(listCanGiuaTblThongKe, tblThongKe);

		/**
		 * Bảng sản phẩm
		 */
		new DefaultTableModel(colsThongKe, 0);
		tblSanPham = new JTable(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, { null, null, null } }, colsSanPham)) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tblSanPham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblSanPham.setRowMargin(5);
		tblSanPham.setRowHeight(30);
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblSanPham.setToolTipText("Bảng xếp hạng những sản phẩm bán chạy");
		JTableHeader headerTable1 = tblSanPham.getTableHeader();
		headerTable1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable1.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon1 = new JScrollPane(tblSanPham);
		thanhCuon1.setBounds(770, 797, 794, 205);
		thanhCuon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon1.setToolTipText("Thống kê dữ liệu trong tháng");

		add(thanhCuon1);
		modelSanPham = (DefaultTableModel) tblSanPham.getModel();

		// Căn chữ của cột sang phải
		int[] listCanPhaiTblSanPham = { 2 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblSanPham, tblSanPham);

		// Căn chữ của cột sang giua
		int[] listCanGiuaTblSanPham = { 0 };
		ChucNang.setCenterAlignmentTable(listCanGiuaTblSanPham, tblSanPham);

		/**
		 * panel thu chi
		 */
		RoundedPanel panel_2 = new RoundedPanel();
		panel_2.setBackground(new Color(248, 198, 153));
		panel_2.setBounds(78, 172, 428, 92);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tổng tiền thu");
		lblNewLabel_1.setBounds(0, 11, 428, 22);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);

		lblTongTienThu = new JLabel("10.000.000đ");
		lblTongTienThu.setBounds(0, 40, 428, 37);
		lblTongTienThu.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTongTienThu.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblTongTienThu);

		RoundedPanel panel_2_1 = new RoundedPanel();
		panel_2_1.setBackground(new Color(248, 198, 153));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(585, 172, 428, 92);
		add(panel_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng tiền chi");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(0, 11, 428, 22);
		panel_2_1.add(lblNewLabel_1_1);

		lblTongTienChi = new JLabel("10.000.000đ");
		lblTongTienChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTienChi.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTongTienChi.setBounds(0, 44, 428, 37);
		panel_2_1.add(lblTongTienChi);

		RoundedPanel panel_2_2 = new RoundedPanel();
		panel_2_2.setBackground(new Color(248, 198, 153));
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(1092, 172, 428, 92);
		add(panel_2_2);

		JLabel lblNewLabel_1_2 = new JLabel("Tổng doanh thu");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 11, 408, 22);
		panel_2_2.add(lblNewLabel_1_2);

		lblTongDoanhThu = new JLabel("10.000.000đ");
		lblTongDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTongDoanhThu.setBounds(20, 44, 398, 37);
		panel_2_2.add(lblTongDoanhThu);

		// Đổ dữ liệu
		if (spnYear != null) {
			setDataThongKe(spnYear.getYear());
		}

		/**
		 * Biểu đồ doanh thu
		 */
		ChartPanel chartPanel = new ChartPanel(createChart());
		chartPanel.setBounds(10, 275, 1554, 479);
		add(chartPanel);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

		JLabel lblChiTit = new JLabel("Chi tiết");
		lblChiTit.setForeground(Color.WHITE);
		lblChiTit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChiTit.setBounds(22, 765, 201, 29);
		add(lblChiTit);

		JLabel lblGio_1_1 = new JLabel("Sản phẩm bán chạy");
		lblGio_1_1.setForeground(Color.WHITE);
		lblGio_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGio_1_1.setBounds(785, 765, 228, 29);
		add(lblGio_1_1);

	}

	/**
	 * Đổ dữ liệu vào table bảng lương
	 * 
	 * @param month
	 * @param year
	 */
	public void setDataThongKe(int year) {
		ChucNang.clearDataTable(modelThongKe);
		dataset.clear();

		ThongKeService thongKeService = new ThongKeService();

		double tongTienThu = 0.0;
		double tongTienChi = 0.0;

		for (int i = 1; i <= 12; i++) {
			int month = i;
			double tongTienDaBan = thongKeService.getTongBanTheoThoiGian(month, year);
			double tongTienNhap = thongKeService.getTongNhapTheoThoiGian(month, year);
			double tongTienLuong = thongKeService.getTongLuongNhanVien(month, year);

			modelThongKe.addRow(new Object[] { month, vnFormat.format(tongTienDaBan), vnFormat.format(tongTienNhap),
					vnFormat.format(tongTienLuong) });

			dataset.addValue(tongTienDaBan / 1000000000, "Tiền thu", month + "/" + year);
			dataset.addValue((tongTienLuong + tongTienNhap) / 1000000000, "Tiền vốn", month + "/" + year);

			tongTienThu += tongTienDaBan;
			tongTienChi += tongTienLuong + tongTienNhap;
		}

		// set Text on label Thu Chi
		lblTongTienChi.setText(vnFormat.format(BigDecimal.valueOf(tongTienChi)) + "đ");
		lblTongTienThu.setText(vnFormat.format(BigDecimal.valueOf(tongTienThu)) + "đ");
		lblTongDoanhThu.setText(
				(tongTienThu - tongTienChi < 0 ? 0 : vnFormat.format(BigDecimal.valueOf(tongTienThu - tongTienChi)))
						+ "đ");

		// set data table sản phẩm

		ChucNang.clearDataTable(modelSanPham);
		List<?> listSP = thongKeService.getListSoLuongBanChay(year);
		int STT = 1;
		for (Object object : listSP) {
			Object[] o = (Object[]) object;
			modelSanPham.addRow(new Object[] { STT, o[0], o[1] });
			STT++;
		}

		ChucNang.addNullDataTable(modelSanPham);
		ChucNang.addNullDataTable(modelThongKe);
	}

	public JFreeChart createChart() {
		JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ THỐNG KÊ DOANH THU", "Tháng", "Số tiền (tỷ/VNĐ)",
				dataset, PlotOrientation.VERTICAL, true, true, false);
		return barChart;
	}
}
