package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

import jiconfont.swing.IconFontSwing;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class Gui_QuanLyHoaDon extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_QuanLyHoaDon frame = new Gui_QuanLyHoaDon();
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
	public Gui_QuanLyHoaDon() {
		setMinimumSize(new Dimension(1440, 1024));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 129, 25));
		panel.setBounds(0, 0, 1440, 154);
		getContentPane().add(panel);
		panel.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 27, 52, 45);
		panel.add(menuBar);

		IconFontSwing.register(FontAwesome.getIconFont());
		Icon iconMenu = IconFontSwing.buildIcon(FontAwesome.TASKS, 40, Color.WHITE);
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(iconMenu);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_3);

		JLabel lblNewLabel = new JLabel("New label");
		mnNewMenu.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("QU\u1EA2N L\u00DD H\u00D3A \u0110\u01A0N");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 59));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(448, 27, 580, 91);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(194, 93, 0));
		panel_1.setBounds(0, 154, 1424, 95);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(233, 180, 46));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 36));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "H\u00F3a \u0111\u01A1n b\u00E1n", "H\u00F3a \u0111\u01A1n nh\u1EADp" }));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(30, 20, 282, 54);
		panel_1.add(comboBox);

		JButton btnNewButton = new JButton("12/03/2021");
		btnNewButton.setBackground(new Color(233, 180, 46));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 36));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(336, 20, 282, 54);
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(242, 129, 25));
		panel_2.setBounds(0, 246, 1424, 352);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		String[] colsname = { "Mã hóa đơn", "Số lượng", "Ngày lập", "Khuyến mãi", "Thuế", "Tên nhân viên",
				"Thành tiền" };
		DefaultTableModel model = new DefaultTableModel(colsname, 4);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setBounds(23, 11, 1380, 288);
		panel_2.add(scrollPane);

		table = new JTable(model);
		table.setSelectionBackground(new Color(255, 165, 0));
		table.setGridColor(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setFillsViewportHeight(true);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(242, 129, 25));
		panel_3.setBounds(0, 598, 1424, 387);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(248, 198, 153));
		panel_4.setBounds(23, 0, 676, 350);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");

		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/images/img_bill/user.PNG"));
		lblNewLabel_2.setBounds(47, 51, 190, 181);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Hoang Van Chinh");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(47, 259, 211, 42);
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("M\u00E3 Kh\u00E1ch H\u00E0ng: KH123");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_1.setBounds(268, 60, 345, 35);
		panel_4.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i: 0967127083");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_2.setBounds(268, 125, 356, 35);
		panel_4.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("\u0110\u1ECBa ch\u1EC9: \u0110\u0103k N\u00F4ng");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_3.setBounds(268, 191, 368, 35);
		panel_4.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("Ng\u00E0y sinh: 15/06/2001");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_4.setBounds(268, 259, 356, 35);
		panel_4.add(lblNewLabel_3_4);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(248, 198, 153));
		panel_4_1.setBounds(723, 0, 676, 350);
		panel_3.add(panel_4_1);

		JButton btnThmHan = new JButton("Th\u00EAm h\u00F3a \u0111\u01A1n");
		btnThmHan.setBounds(24, 23, 193, 44);
		btnThmHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4_1.setLayout(null);
		btnThmHan.setForeground(Color.WHITE);
		btnThmHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThmHan.setBackground(new Color(233, 180, 46));
		panel_4_1.add(btnThmHan);

		JButton btnTmKim = new JButton("T\u00ECm ki\u1EBFm");
		btnTmKim.setBounds(24, 114, 193, 44);
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTmKim.setBackground(new Color(233, 180, 46));
		panel_4_1.add(btnTmKim);

		JButton btnXemChiTit = new JButton("Xem chi ti\u1EBFt");
		btnXemChiTit.setBounds(247, 23, 177, 44);
		btnXemChiTit.setForeground(Color.WHITE);
		btnXemChiTit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXemChiTit.setBackground(new Color(233, 180, 46));
		panel_4_1.add(btnXemChiTit);

		JButton btnXa = new JButton("X\u00F3a");
		btnXa.setBounds(460, 23, 177, 44);
		btnXa.setForeground(Color.WHITE);
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXa.setBackground(new Color(233, 180, 46));
		panel_4_1.add(btnXa);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "T\u00ECm theo m\u00E3 h\u00F3a \u0111\u01A1n", "T\u00ECm theo ng\u00E0y l\u1EADp",
						"T\u00ECm theo m\u00E3 kh\u00E1ch h\u00E0ng", "T\u00ECm theo m\u00E3 s\u1EA3n ph\u1EA9m" }));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setForeground(Color.WHITE);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBackground(new Color(233, 180, 46));
		comboBox_1.setBounds(24, 207, 613, 44);
		panel_4_1.add(comboBox_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(247, 114, 390, 44);
		panel_4_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("T\u1ED5ng ti\u1EC1n: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(65, 277, 157, 44);
		panel_4_1.add(lblNewLabel_4);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(247, 278, 390, 44);
		panel_4_1.add(textField_1);
	}
}
