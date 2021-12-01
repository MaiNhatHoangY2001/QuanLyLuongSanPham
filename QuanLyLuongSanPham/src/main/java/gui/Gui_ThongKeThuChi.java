package gui;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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

import gui_package.ChucNang;
import services.ThongKeService;
import gui_package.RoundedPanel;

public class Gui_ThongKeThuChi extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	/**
	 * Create the frame.
	 */
	public Gui_ThongKeThuChi() {
		setSize(1600, 812);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

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
		thanhCuon.setBounds(10, 587, 750, 205);
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
		thanhCuon1.setBounds(770, 587, 794, 205);
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
		panel_2.setBounds(77, 11, 428, 92);
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
		panel_2_1.setBounds(584, 11, 428, 92);
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
		panel_2_2.setBounds(1091, 11, 428, 92);
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

		/**
		 * Biểu đồ doanh thu
		 */
		ChartPanel chartPanel = new ChartPanel(createChart());
		chartPanel.setBounds(10, 119, 1554, 430);
		add(chartPanel);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

		JLabel lblChiTit = new JLabel("Chi tiết");
		lblChiTit.setForeground(Color.WHITE);
		lblChiTit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChiTit.setBounds(20, 560, 201, 29);
		add(lblChiTit);

		JLabel lblGio_1_1 = new JLabel("Sản phẩm bán chạy");
		lblGio_1_1.setForeground(Color.WHITE);
		lblGio_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGio_1_1.setBounds(784, 560, 228, 29);
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
