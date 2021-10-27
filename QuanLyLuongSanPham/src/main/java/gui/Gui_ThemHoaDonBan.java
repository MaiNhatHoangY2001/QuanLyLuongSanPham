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
import gui_package.ChucNang;
import model.SanPham;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Gui_ThemHoaDonBan extends JFrame {
	private JTable tblSanPham;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSdt;
	private JTextField txtKhuyenMai;
	private JTextField txtThue;
	private JTable tblGioHang;
	private JTextField txtMaNhanVien;
	
	private GioHang gioHang= new GioHang();
	private TableGioHang modelGioHang; 
	private JButton btnThem;
	private JButton btnThmHan;
	private JButton btnHuyBo;
	private JButton btnXoaRong;
	private JTextField txtTimSp;
	private JTextField txtTimKh;
	private JTextField txtMaNhanVienc;
	private JButton btnXoa;

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
		ChucNang.setTableAlternateRow();
		setMinimumSize(new Dimension(1440, 1046));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
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
		lblNewLabel_4.setBounds(28, 44, 152, 73);
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(0, 158, 1424, 59);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtTimSp = new JTextField();
		txtTimSp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimSp.setColumns(10);
		txtTimSp.setBounds(27, 13, 419, 44);
		panel_1.add(txtTimSp);
		
		JComboBox cboTimSp = new JComboBox();
		cboTimSp.setToolTipText("Tìm kiếm nhanh sản phẩm");
		cboTimSp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cboTimSp.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo tên", "Tìm theo NCC"}));
		cboTimSp.setBounds(458, 13, 249, 44);
		panel_1.add(cboTimSp);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(242, 129, 25));
		panel_2.setBounds(0, 204, 1424, 370);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		String[] colsname = { "Mã hóa đơn", "Số lượng", "Ngày lập", "Khuyến mãi", "Thuế", "Tên nhân viên",
				"Thành tiền" };
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 27, 687, 330);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(scrollPane);

		tblSanPham = new JTable();
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblSanPham.setRowHeight(40);
		tblSanPham.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"T\u00EAn s\u1EA3n ph\u1EA9m", "Gi\u00E1 th\u00E0nh", "Nh\u00E0 cung c\u1EA5p", "Lo\u1EA1i"
			}
		));
		tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(141);
		tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(108);
		tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(125);
		tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(90);
		scrollPane.setViewportView(tblSanPham);
		
		btnThem = new JButton(">>");
		btnThem.setToolTipText("Thêm sản phẩm vào giỏ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setBackground(new Color(255, 204, 0));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBounds(712, 91, 80, 54);
		panel_2.add(btnThem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(795, 27, 614, 330);
		panel_2.add(scrollPane_1);
		tblGioHang = new JTable();
		tblGioHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblGioHang.setRowHeight(50);
		tblGioHang.setModel(new DefaultTableModel(
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
				"STT", "T\u00EAn s\u1EA3n ph\u1EA9m", "Gi\u00E1 th\u00E0nh", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n"
			}
		));
		tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(15);
		tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(168);
		tblGioHang.getColumnModel().getColumn(4).setPreferredWidth(119);
		tblGioHang.revalidate();
		scrollPane_1.setViewportView(tblGioHang);
		
		btnXoa = new JButton("<<");
		btnXoa.setToolTipText("Xóa sản phẩm ra khỏi giỏ");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnXoa.setBackground(new Color(255, 204, 0));
		btnXoa.setBounds(712, 192, 80, 54);
		panel_2.add(btnXoa);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(242, 129, 25));
		panel_3.setBounds(0, 559, 1424, 440);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\u0110\u1ED1i v\u1EDBi kh\u00E1ch h\u00E0ng m\u1EDBi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(248, 198, 153));
		panel_4.setBounds(24, 40, 684, 324);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Khuyễn mãi:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(54, 199, 155, 42);
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_1.setBounds(21, 25, 188, 35);
		panel_4.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Số điện thoại:");
		lblNewLabel_3_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_2.setBounds(42, 145, 167, 35);
		panel_4.add(lblNewLabel_3_2);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setBounds(120, 85, 89, 35);
		panel_4.add(lblDiaChi);

		JLabel lblNewLabel_3_4 = new JLabel("Thuế:");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_4.setBounds(386, 203, 64, 35);
		panel_4.add(lblNewLabel_3_4);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(233, 23, 390, 44);
		panel_4.add(txtTenKhachHang);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(233, 83, 390, 44);
		panel_4.add(txtDiaChi);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSdt.setColumns(10);
		txtSdt.setBounds(233, 143, 390, 44);
		panel_4.add(txtSdt);
		
		txtKhuyenMai = new JTextField();
		txtKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKhuyenMai.setColumns(10);
		txtKhuyenMai.setBounds(233, 201, 132, 44);
		panel_4.add(txtKhuyenMai);
		
		txtThue = new JTextField();
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThue.setColumns(10);
		txtThue.setBounds(449, 201, 174, 44);
		panel_4.add(txtThue);
		
		JLabel lblNewLabel_3_5 = new JLabel("Mã nhân viên:");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_5.setBounds(54, 257, 158, 42);
		panel_4.add(lblNewLabel_3_5);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(233, 261, 390, 40);
		panel_4.add(txtMaNhanVien);
		
		btnThmHan = new JButton("Thêm hóa đơn");
		btnThmHan.setToolTipText("Tiến hành thêm khi đã nhập liệu xong");
		btnThmHan.setForeground(Color.WHITE);
		btnThmHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThmHan.setBackground(new Color(233, 180, 46));
		btnThmHan.setBounds(518, 380, 190, 44);
		panel_3.add(btnThmHan);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setToolTipText("Xóa rỗng các textbox");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(275, 380, 190, 44);
		panel_3.add(btnXoaRong);
		
		btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.setToolTipText("Hủy thao tác thêm");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(24, 380, 190, 44);
		panel_3.add(btnHuyBo);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110\u1ED1i v\u1EDBi kh\u00E1ch h\u00E0ng c\u0169", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4_1.setBackground(new Color(248, 198, 153));
		panel_4_1.setBounds(796, 40, 611, 324);
		panel_3.add(panel_4_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Số điện thoại:");
		lblNewLabel_3_2_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_2_1.setBounds(24, 83, 167, 35);
		panel_4_1.add(lblNewLabel_3_2_1);
		
		txtTimKh = new JTextField();
		txtTimKh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKh.setColumns(10);
		txtTimKh.setBounds(197, 81, 383, 44);
		panel_4_1.add(txtTimKh);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_3_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_5_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3_5_1.setBounds(24, 204, 158, 42);
		panel_4_1.add(lblNewLabel_3_5_1);
		
		txtMaNhanVienc = new JTextField();
		txtMaNhanVienc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNhanVienc.setColumns(10);
		txtMaNhanVienc.setBounds(197, 206, 390, 40);
		panel_4_1.add(txtMaNhanVienc);
		
		SanPham sanPham=new  SanPham();
		gioHang.themMatHang(sanPham,3);
		modelGioHang=new TableGioHang(gioHang);
	}
}
