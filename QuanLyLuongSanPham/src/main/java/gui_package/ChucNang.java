package gui_package;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import gui.Gui_Chinh;
import gui.Gui_DangNhap;

public class ChucNang {
	/**
	 * chỉnh giờ cho lable
	 * 
	 * @param lblGio
	 */
	public static void setGio(JLabel lblGio,JLabel lblNgay) {
		TimerTask timerTask = new TimerTask() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
				lblNgay.setText(formatter.format(LocalDate.now()));
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
	 * 
	 * @param model
	 */
	public static void clearDataTable(DefaultTableModel model) {

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	public static void clearDataNullTable(DefaultTableModel model) {
		for (int i = model.getDataVector().size()-1; i >=0; i--) {
			if(model.getValueAt(i, 0)==null)
				model.removeRow(i);
		}
	}
	/**
	 * Chức năng giúp thêm vào những hàng rỗng cho đẹp bảng
	 * 
	 * @param model
	 */
	public static void addNullDataTable(DefaultTableModel model) {
		for (int i = 0; i < 15; i++) {
			model.addRow(new Object[] { null, null, null, null, null, null, null });
		}
	}

	/**
	 * Chức năng căn phải các cột trong bảng
	 * 
	 * @param list
	 */
	public static void setRightAlignmentTable(int[] list, JTable table) {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		for (int i : list) {
			table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		}

	}

	/**
	 * Chức năng căn giữa các cột trong bảng
	 * 
	 * @param list
	 */
	public static void setCenterAlignmentTable(int[] list, JTable table) {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i : list) {
			table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		}

	}
	public static void setLabelName(String name,JPanel panel,Gui_Chinh fChinh,Gui_DangNhap fDangNhap, JPanel panelChinh){
		/**
		 * Tên đăng nhập
		 */
		Component temp = panel.getComponentAt(1272, 11);
		panel.remove(temp);
		panel.revalidate();
		panel.repaint();
		JLabel lblTenDN = new JLabel();
		lblTenDN.setText(name);
		lblTenDN.setHorizontalTextPosition(SwingConstants.LEFT);
		lblTenDN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenDN.setForeground(Color.WHITE);
		lblTenDN.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTenDN.setBounds(1272, 11, 260, 33);
		panel.add(lblTenDN);

		JLabel lblIconUser = new JLabel("");
		Image imgUser = new ImageIcon(Toolkit.getDefaultToolkit().getImage(panelChinh.getClass().getResource("/img/userNho.png"))).getImage();
		lblIconUser.setIcon(new ImageIcon(imgUser));
		lblIconUser.setBounds(1536, 10, 38, 30);
		panel.add(lblIconUser);

		/**
		 * Đăng xuất
		 */
		JLabel lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDangXuat.setBounds(1419, 55, 110, 24);
		panel.add(lblDangXuat);

		JLabel lblIconDX = new JLabel("");
		Image imgDX = new ImageIcon(Toolkit.getDefaultToolkit().getImage(panelChinh.getClass().getResource("/img/thoatNho.png"))).getImage();
		lblIconDX.setIcon(new ImageIcon(imgDX));
		lblIconDX.setBounds(1536, 50, 38, 30);
		panel.add(lblIconDX);
		lblDangXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lblDangXuat.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int temp= JOptionPane.showConfirmDialog(fChinh, "Bạn có muốn đăng xuất","Thông báo", JOptionPane.YES_NO_OPTION);
				if(temp==JOptionPane.YES_OPTION) {
					fDangNhap.setVisible(true);
					fChinh.setVisible(false);
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblDangXuat.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDangXuat.setForeground(Color.GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
}
