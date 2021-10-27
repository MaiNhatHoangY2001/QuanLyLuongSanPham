package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import collections.GioHang;
import collections.TableGioHang;
import model.SanPham;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Gui_ThemHoaDonBan extends JFrame {
	private JTable tblSanPham;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSdt;
	private JTextField txtKhuyenMai;
	private JTextField txtThue;
	private JTextField txtTimSanPham;
	private JTable tblGioHang;
	private JTextField txtMaNhanVien;
	
	private GioHang gioHang= new GioHang();
	private TableGioHang modelGioHang; 
	private JButton btnThem;
	private JButton btnThmHan;
	private JButton btnHuyBo;
	private JButton btnXoaRong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_ThemHoaDonBan frame = new Gui_ThemHoaDonBan();
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
	public Gui_ThemHoaDonBan() {
		setMinimumSize(new Dimension(1440, 1024));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 129, 25));
		panel.setBounds(0, 0, 1424, 154);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("THÊM HÓA ĐƠN BÁN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 59));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(389, 27, 639, 91);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/images/img_bill/logoChung.PNG"));
		lblNewLabel_4.setBounds(15, 45, 152, 73);
		panel.add(lblNewLabel_4);

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
		
		txtTimSanPham = new JTextField();
		txtTimSanPham.setToolTipText("Tìm theo mã, tên, nhà sản xuất");
		txtTimSanPham.setBounds(195, 11, 1097, 28);
		panel_1.add(txtTimSanPham);
		txtTimSanPham.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(242, 129, 25));
		panel_2.setBounds(0, 204, 1424, 323);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		String[] colsname = { "Mã hóa đơn", "Số lượng", "Ngày lập", "Khuyến mãi", "Thuế", "Tên nhân viên",
				"Thành tiền" };
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 11, 1269, 288);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(scrollPane);

		tblSanPham = new JTable();
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tblSanPham.setRowHeight(52);
		tblSanPham.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(tblSanPham);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setBackground(new Color(255, 204, 0));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBounds(1302, 245, 99, 54);
		panel_2.add(btnThem);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(242, 129, 25));
		panel_3.setBounds(0, 531, 1424, 468);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(248, 198, 153));
		panel_4.setBounds(24, 33, 676, 350);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Khuyễn mãi:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(54, 224, 155, 42);
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_1.setBounds(21, 25, 188, 35);
		panel_4.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Số điện thoại: ");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_2.setBounds(54, 154, 155, 35);
		panel_4.add(lblNewLabel_3_2);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setBounds(119, 95, 89, 35);
		panel_4.add(lblDiaChi);

		JLabel lblNewLabel_3_4 = new JLabel("Thuế:");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_4.setBounds(386, 224, 64, 35);
		panel_4.add(lblNewLabel_3_4);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(233, 23, 390, 44);
		panel_4.add(txtTenKhachHang);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(233, 93, 390, 44);
		panel_4.add(txtDiaChi);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSdt.setColumns(10);
		txtSdt.setBounds(233, 152, 390, 44);
		panel_4.add(txtSdt);
		
		txtKhuyenMai = new JTextField();
		txtKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKhuyenMai.setColumns(10);
		txtKhuyenMai.setBounds(233, 222, 132, 44);
		panel_4.add(txtKhuyenMai);
		
		txtThue = new JTextField();
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThue.setColumns(10);
		txtThue.setBounds(449, 222, 174, 44);
		panel_4.add(txtThue);
		
		JLabel lblNewLabel_3_5 = new JLabel("Mã nhân viên:");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_5.setBounds(51, 279, 158, 42);
		panel_4.add(lblNewLabel_3_5);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(233, 281, 390, 44);
		panel_4.add(txtMaNhanVien);
		
		btnThmHan = new JButton("Thêm hóa đơn");
		btnThmHan.setForeground(Color.WHITE);
		btnThmHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThmHan.setBackground(new Color(233, 180, 46));
		btnThmHan.setBounds(24, 404, 190, 44);
		panel_3.add(btnThmHan);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(273, 404, 190, 44);
		panel_3.add(btnXoaRong);
		
		btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(510, 404, 190, 44);
		panel_3.add(btnHuyBo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(732, 33, 671, 350);
		panel_3.add(scrollPane_1);
		
		SanPham sanPham=new  SanPham();
		gioHang.themMatHang(sanPham,3);
		modelGioHang=new TableGioHang(gioHang);
		tblGioHang = new JTable();
		tblGioHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblGioHang.setRowHeight(50);
		tblGioHang.setModel(modelGioHang);
		tblGioHang.revalidate();
		scrollPane_1.setViewportView(tblGioHang);
	}
}
