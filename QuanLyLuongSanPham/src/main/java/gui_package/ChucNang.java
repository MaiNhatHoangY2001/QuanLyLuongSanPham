package gui_package;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class ChucNang {
	/**
	 * chỉnh giờ cho lable
	 * 
	 * @param lblGio
	 */
	public static void setGio(JLabel lblGio) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				lblGio.setText((new Date().getHours() >= 10 ? "" : "0") + (new Date().getHours())
						+ ((new Date().getSeconds() % 2) != 0 ? " " : ":")
						+ ((new Date().getMinutes() >= 10 ? "" : "0") + (new Date().getMinutes())));
			}

		};
		long delay = 1000L;
		Timer timer = new Timer("Timer");
		timer.schedule(timerTask, 0, delay);
	}

	/**
	 * Giúp di chuyển giao diện khi kéo thả giao diện
	 * 
	 * @param frame
	 */
	public static void setDiChuyenGD(JFrame frame) {

		AtomicInteger xClicked = new AtomicInteger(0);
		AtomicInteger yClicked = new AtomicInteger(0);

		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xClicked.set(e.getX());
				yClicked.set(e.getY());
			}
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x - xClicked.get(), y - yClicked.get());
			}
		});
	}

	/**
	 * Chức năng giúp làm cách 1 hàng của bảng có màu
	 */
	public static void setTableAlternateRow() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(255, 240, 226));
	}
	
	/**
	 * chức năng giúp xóa tất cả dữ liệu có trong bảng
	 * @param model
	 */
	public static void clearDateTable(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	
	/**
	 * Chức năng giúp thêm vào những hàng rỗng cho đẹp bảng
	 * @param model
	 */
	public static void addNullDataTable(DefaultTableModel model) {
		for (int i = 0; i < 10; i++) {
			model.addRow(new Object[] { null, null, null, null, null, null, null });
		}
	}
	

}
