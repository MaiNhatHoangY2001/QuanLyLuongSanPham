package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.table.DefaultTableModel;

public class ThemHoaDonBan extends JFrame {
	private JTable table_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemHoaDonBan frame = new ThemHoaDonBan();
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
	public ThemHoaDonBan() {
		setMinimumSize(new Dimension(1440, 1024));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 129, 25));
		panel.setBounds(0, 0, 1424, 154);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("QU\u1EA2N L\u00DD H\u00D3A \u0110\u01A0N");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 59));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(448, 27, 580, 91);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(0, 158, 1424, 50);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm sản phẩm:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(21, 11, 170, 28);
		panel_1.add(lblNewLabel);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Tìm theo mã, tên, nhà sản xuất");
		textField_7.setBounds(195, 11, 1206, 28);
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(242, 129, 25));
		panel_2.setBounds(0, 204, 1424, 323);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		String[] colsname = { "Mã hóa đơn", "Số lượng", "Ngày lập", "Khuyến mãi", "Thuế", "Tên nhân viên",
				"Thành tiền" };
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 11, 1380, 288);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setRowHeight(52);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm", "Giá thành", "Nhà cung cấp", "Loại", "Ngày sản xuất"
			}
		));
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(242, 129, 25));
		panel_3.setBounds(0, 532, 1424, 453);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(248, 198, 153));
		panel_4.setBounds(24, 33, 676, 350);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Khuyễn mãi:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(69, 224, 132, 42);
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_1.setBounds(31, 25, 178, 35);
		panel_4.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Số điện thoại: ");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_2.setBounds(59, 154, 155, 35);
		panel_4.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Địa chỉ:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_3.setBounds(128, 95, 80, 35);
		panel_4.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("Thuế:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_4.setBounds(386, 224, 64, 35);
		panel_4.add(lblNewLabel_3_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(233, 23, 390, 44);
		panel_4.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(233, 93, 390, 44);
		panel_4.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(233, 152, 390, 44);
		panel_4.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(233, 222, 132, 44);
		panel_4.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(449, 222, 174, 44);
		panel_4.add(textField_6);
		
		JLabel lblNewLabel_3_5 = new JLabel("Nhân Viên:");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_5.setBounds(82, 283, 132, 42);
		panel_4.add(lblNewLabel_3_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(233, 281, 390, 44);
		panel_4.add(textField);
		
		JButton btnThmHan_1 = new JButton("Thêm hóa đơn");
		btnThmHan_1.setForeground(Color.WHITE);
		btnThmHan_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThmHan_1.setBackground(new Color(233, 180, 46));
		btnThmHan_1.setBounds(24, 404, 190, 44);
		panel_3.add(btnThmHan_1);
		
		JButton btnXaRng = new JButton("Xóa Rỗng");
		btnXaRng.setForeground(Color.WHITE);
		btnXaRng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXaRng.setBackground(new Color(233, 180, 46));
		btnXaRng.setBounds(273, 404, 190, 44);
		panel_3.add(btnXaRng);
		
		JButton btnHyB = new JButton("Hủy bỏ");
		btnHyB.setForeground(Color.WHITE);
		btnHyB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHyB.setBackground(new Color(233, 180, 46));
		btnHyB.setBounds(510, 404, 190, 44);
		panel_3.add(btnHyB);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(732, 33, 671, 350);
		panel_3.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table_2.setRowHeight(50);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
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
				"STT", "Tên sản phẩm", "Giá thành", "Số lượng", "Xóa"
			}
		));
		scrollPane_1.setViewportView(table_2);
	}
}
