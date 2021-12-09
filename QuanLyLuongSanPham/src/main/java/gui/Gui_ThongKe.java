package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JYearChooser;

import gui_package.ChucNang;
import gui_package.CustomTab;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class Gui_ThongKe extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblGio;
	private JLabel lblNgay;
	private JYearChooser spnYear;
	private JButton btnHienTai;
	protected JPanel pnlHead;
	private JTabbedPane tabbedPane;
	private Gui_ThongKeThuChi trangTKThuChi = new Gui_ThongKeThuChi();
	private Gui_ThongKeLuong trangTKLuong = new Gui_ThongKeLuong();

	/**
	 * Create the frame.
	 */
	public Gui_ThongKe() {
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
				trangTKThuChi.setDataThongKe(spnYear.getYear());
				trangTKLuong.setDataThongKe(spnYear.getYear());
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
			trangTKThuChi.setDataThongKe(spnYear.getYear());
			trangTKLuong.setDataThongKe(spnYear.getYear());
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

		UIManager.put("TabbedPane.selected", new Color(242, 129, 25));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 160, 1600, 886);
		tabbedPane.setBackground(new Color(194, 93, 0));

		add(tabbedPane);

		/**
		 * tab
		 */

		tabbedPane.add("Thống kê doanh thu", trangTKThuChi);
		trangTKThuChi.setDataThongKe(spnYear.getYear());
		tabbedPane.setTabComponentAt(0, new CustomTab(tabbedPane));

		tabbedPane.add("Thống kê lương", trangTKLuong);
		trangTKLuong.setDataThongKe(spnYear.getYear());
		tabbedPane.setTabComponentAt(1, new CustomTab(tabbedPane));

	}

}
