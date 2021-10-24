package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Gui_ChiTietHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField txtThu;
	private JTextField txtThnhTin;
	private JTable tblChiTiet;
	private JLabel lblMaHoaDon;
	private JLabel lblNhanVien;
	private JLabel lblMaNhanVien;
	private JButton btnXacNhan;
	private JLabel lblSdtKH;
	private JLabel lblTenKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_ChiTietHoaDon frame = new Gui_ChiTietHoaDon();
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
	public Gui_ChiTietHoaDon() {
		setMinimumSize(new Dimension(1440, 872));
		setSize(new Dimension(1440, 872));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1421, 822);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242,129,25));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 1424, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel.setBounds(443, 25, 582, 73);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/images/img_bill/logoChung.PNG"));
		lblNewLabel_4.setBounds(15, 25, 152, 73);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(194,93,0));
		panel_1.setBounds(0, 123, 1424, 94);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblMaHoaDon = new JLabel("mã hóa đơn:HDB102421000");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMaHoaDon.setBounds(15, 28, 323, 50);
		lblMaHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMaHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaHoaDon.setForeground(new Color(255, 255, 255));
		panel_1.add(lblMaHoaDon);
		
		lblNhanVien = new JLabel("Nhân viên lập hóa đơn: Hoàng Văn Chinh");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setBounds(409, 28, 638, 50);
		panel_1.add(lblNhanVien);
		
		lblMaNhanVien = new JLabel("Mã nhân viên : NV19120800");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMaNhanVien.setForeground(new Color(255, 255, 255));
		lblMaNhanVien.setBounds(1082, 28, 313, 50);
		panel_1.add(lblMaNhanVien);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(242,129,25));
		panel_2.setBounds(0, 217, 1424, 616);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 90, 1394, 283);
		panel_2.add(scrollPane);
		
		tblChiTiet = new JTable();
		tblChiTiet.setRowHeight(45);
		tblChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(tblChiTiet);
		
		txtThu = new JTextField();
		txtThu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtThu.setText("Thuế:");
		txtThu.setBounds(15, 373, 1394, 44);
		panel_2.add(txtThu);
		txtThu.setColumns(10);
		
		txtThnhTin = new JTextField();
		txtThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtThnhTin.setText("Thành tiền:");
		txtThnhTin.setColumns(10);
		txtThnhTin.setBounds(15, 417, 1394, 44);
		panel_2.add(txtThnhTin);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXacNhan.setBackground(new Color(255, 204, 0));
		btnXacNhan.setBounds(620, 504, 229, 77);
		panel_2.add(btnXacNhan);
		
		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTenKH.setHorizontalTextPosition(SwingConstants.LEFT);
		lblTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKH.setForeground(Color.WHITE);
		lblTenKH.setBounds(15, 16, 442, 50);
		panel_2.add(lblTenKH);
		
		lblSdtKH = new JLabel("Số điện thoại:");
		lblSdtKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSdtKH.setHorizontalTextPosition(SwingConstants.LEFT);
		lblSdtKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblSdtKH.setForeground(Color.WHITE);
		lblSdtKH.setBounds(648, 16, 442, 50);
		panel_2.add(lblSdtKH);
		pack();
	}
	 private void formWindowClosing(WindowEvent e) {//GEN-FIRST:event_formWindowClosing
		 this.disable();
	 }
	public  void setLblMaHoaDon(String lblMaHoaDon) {
		this.lblMaHoaDon.setText(lblMaHoaDon);
	}
	
}
