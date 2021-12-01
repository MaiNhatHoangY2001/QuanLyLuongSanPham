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

public class Gui_ThongKeLuong extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] colsThongKe = { "Tháng", "Tiền Lương nhân viên" };
	private String[] colsSanPham = { "STT", "Mã nhân viên", "Tên nhân viên", "Lương" };
	private JTable tblThongKe;
	private DefaultTableModel modelThongKe;
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	// Format tiền theo VND
	private NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
	private JTable tblSanPham;
	private DefaultTableModel modelSanPham;

	/**
	 * Create the frame.
	 */
	public Gui_ThongKeLuong() {
		setSize(1600, 812);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		/**
		 * Thống kê dữ liệu trong tháng
		 */
		new DefaultTableModel(colsThongKe, 0);
		tblThongKe = new JTable(
				new DefaultTableModel(new Object[][] { { null, null }, { null, null }, { null, null } }, colsThongKe)) {

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
		int[] listCanPhaiTblThongKe = { 1 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblThongKe, tblThongKe);

		// Căn chữ của cột sang giua
		int[] listCanGiuaTblThongKe = { 0 };
		ChucNang.setCenterAlignmentTable(listCanGiuaTblThongKe, tblThongKe);

		/**
		 * Bảng sản phẩm
		 */
		new DefaultTableModel(colsThongKe, 0);
		tblSanPham = new JTable(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null } },
				colsSanPham)) {

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
		tblSanPham.setToolTipText("Bảng xếp hạng lương nhân viên");
		JTableHeader headerTable1 = tblSanPham.getTableHeader();
		headerTable1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable1.setBackground(new Color(248, 198, 153));
		JScrollPane thanhCuon1 = new JScrollPane(tblSanPham);
		thanhCuon1.setBounds(770, 587, 794, 205);
		thanhCuon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thanhCuon1.setToolTipText("Bảng xếp hạng lương nhân viên");

		add(thanhCuon1);
		modelSanPham = (DefaultTableModel) tblSanPham.getModel();

		// Căn chữ của cột sang phải
		int[] listCanPhaiTblSanPham = { 3 };
		ChucNang.setRightAlignmentTable(listCanPhaiTblSanPham, tblSanPham);

		// Căn chữ của cột sang giua
		int[] listCanGiuaTblSanPham = { 0 };
		ChucNang.setCenterAlignmentTable(listCanGiuaTblSanPham, tblSanPham);

		/**
		 * Biểu đồ doanh thu
		 */
		ChartPanel chartPanel = new ChartPanel(createChart());
		chartPanel.setBounds(10, 33, 1554, 516);
		add(chartPanel);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

		JLabel lblChiTit = new JLabel("Chi tiết");
		lblChiTit.setForeground(Color.WHITE);
		lblChiTit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChiTit.setBounds(20, 560, 201, 29);
		add(lblChiTit);

		JLabel lblGio_1_1 = new JLabel("Bảng xếp hạng lương");
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

		for (int i = 1; i <= 12; i++) {
			int month = i;
			double tongTienLuong = thongKeService.getTongLuongNhanVien(month, year);

			modelThongKe.addRow(new Object[] { month, vnFormat.format(tongTienLuong) });

			dataset.addValue(tongTienLuong / 1000000, "Tiền lương", month + "/" + year);
		}
		// set data table sản phẩm

		ChucNang.clearDataTable(modelSanPham);
		List<?> listTop10 = thongKeService.getTop10LuongNhanVien(year);
		int STT = 1;
		for (Object object : listTop10) {
			Object[] o = (Object[]) object;
			modelSanPham.addRow(new Object[] { STT, o[0], o[1], vnFormat.format(o[2]) });
			STT++;
		}

		ChucNang.addNullDataTable(modelSanPham);
		ChucNang.addNullDataTable(modelThongKe);
	}

	public JFreeChart createChart() {
		JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ THỐNG KÊ LƯƠNG", "Tháng", "Số tiền (triệu/VNĐ)",
				dataset, PlotOrientation.VERTICAL, true, true, false);
		return barChart;
	}
}
