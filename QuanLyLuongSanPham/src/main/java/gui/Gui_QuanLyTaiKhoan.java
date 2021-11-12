package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.TaiKhoanDao;
import gui_package.ChucNang;
import gui_package.CircleBtn;
import gui_package.RoundedPanel;
import model.TaiKhoan;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Gui_QuanLyTaiKhoan extends JPanel implements ActionListener  {
	private String[] colsnameLK = { "Tên Nhân Viên", "Tên Tài Khoản", "Mật Khẩu" };
	private DefaultTableModel modelTaiKhoan;
	private JPanel panel;
	private JLabel lblQLTK;
	private JLabel lblNgay;
	private JLabel lblGio;
	private JLabel lblLogoNV;
	private JPanel panelXoa;
	private JPanel panelTable;
	private JPanel panelThem;
	private JTable tblTaiKhoan;
	private JPanel panelThongTin;
	private JLabel lblTTNV;
	private JLabel lblMa;
	private JLabel lblSDT;
	private JLabel lblEmail;
	private JLabel lblThemTaiKhoan;
	private JLabel lblSuaTaiKhoan;
	private JLabel lblTen_1;
	private JLabel lblTen_2;
	private JLabel lblTen_3;
	private JLabel lblTen_4;
	private JTextField txtMa;
	private JTextField txtTenNV;
	private JTextField txtTenTK;
	private JTextField txtMK;
	private JButton btnXoaRong;
	private JButton btnThem;
	
	private TaiKhoanDao daoTK;
	private List<TaiKhoan> listTK;


	public Gui_QuanLyTaiKhoan() {
		setSize(1600, 1046);
		setBackground(new Color(194, 93, 0));
		setLayout(null);
		/**
		 * Phần Trên chứa thanh menu và thanh bar ngang
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(242, 129, 25));
		panel.setBounds(0, 0, 1600, 100);
		add(panel);

		lblQLTK = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblQLTK.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblQLTK.setForeground(Color.WHITE);
		lblQLTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLTK.setBounds(499, 0, 601, 100);
		panel.add(lblQLTK);

		lblNgay = new JLabel("New label");
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setBounds(0, 16, 233, 33);
		panel.add(lblNgay);

		lblGio = new JLabel("New label");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(0, 50, 201, 42);
		panel.add(lblGio);

		ChucNang.setGio(lblGio, lblNgay);

		lblLogoNV = new JLabel("Chinh");
		lblLogoNV.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLogoNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogoNV.setForeground(Color.WHITE);
		lblLogoNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogoNV.setBounds(1371, 10, 192, 45);
		panel.add(lblLogoNV);

		/**
		 * Phần dưới chứa bảng
		 */
		panelTable = new JPanel();
		panelTable.setBackground(new Color(242, 129, 25));
		panelTable.setBounds(0, 173, 1600, 873);
		add(panelTable);
		panelTable.setLayout(null);

		panelThem = new RoundedPanel();
		panelThem.setBackground(getBackground());
		panelThem.setLayout(null);
		panelThem.setBounds(975, 45, 600, 373);
		panelTable.add(panelThem);
		
		lblThemTaiKhoan = new JLabel("THÊM TÀI KHOẢN MỚI");
		lblThemTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemTaiKhoan.setForeground(Color.WHITE);
		lblThemTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThemTaiKhoan.setBounds(99, 0, 421, 46);
		panelThem.add(lblThemTaiKhoan);
		
		lblTen_1 = new JLabel("Tên Nhân Viên:");
		lblTen_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen_1.setBounds(27, 128, 116, 29);
		panelThem.add(lblTen_1);
		
		lblTen_2 = new JLabel("Mã Nhân Viên:");
		lblTen_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen_2.setBounds(27, 58, 116, 29);
		panelThem.add(lblTen_2);
		
		lblTen_3 = new JLabel("Mật Khẩu:");
		lblTen_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen_3.setBounds(27, 268, 116, 29);
		panelThem.add(lblTen_3);
		
		lblTen_4 = new JLabel("Tên Tài Khoản:");
		lblTen_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen_4.setBounds(27, 198, 116, 29);
		panelThem.add(lblTen_4);
		
		txtMa = new JTextField();
		txtMa.setBounds(146, 59, 405, 30);
		panelThem.add(txtMa);
		txtMa.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(146, 127, 405, 30);
		panelThem.add(txtTenNV);
		
		txtTenTK = new JTextField();
		txtTenTK.setColumns(10);
		txtTenTK.setBounds(146, 199, 405, 30);
		panelThem.add(txtTenTK);
		
		txtMK = new JTextField();
		txtMK.setColumns(10);
		txtMK.setBounds(146, 268, 405, 30);
		panelThem.add(txtMK);
		
		btnThem = new CircleBtn("Tạo Tài Khoản");
		btnThem.setBackground(new Color(233, 180, 46));
		btnThem.setBounds(400, 317, 120, 40);
		panelThem.add(btnThem);
		
		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(167, 317, 120, 40);
		panelThem.add(btnXoaRong);
		
		new DefaultTableModel(colsnameLK, 0);
		
		tblTaiKhoan = new JTable(new DefaultTableModel(new Object[][] { 
			{ null, null, null }, { null, null, null },{ null, null, null },{ null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null } }, colsnameLK)) {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int col) {
			switch (col) {
			default:
				return false;
			}
		}
	};
	tblTaiKhoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	tblTaiKhoan.setRowMargin(5);
	tblTaiKhoan.setRowHeight(30);
	tblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 24));
	
	JTableHeader headerTable2 = tblTaiKhoan.getTableHeader();
	headerTable2.setFont(new Font("Tahoma", Font.PLAIN, 24));
	headerTable2.setBackground(new Color(248, 198, 153));
	JScrollPane thanhCuon2 = new JScrollPane(tblTaiKhoan);
	thanhCuon2.setEnabled(false);
	thanhCuon2.setBounds(0, 20, 955, 500);
	thanhCuon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
	panelTable.add(thanhCuon2);
	
	JLabel lblThongTinTK = new JLabel("Thông Tin Tài Khoản");
	lblThongTinTK.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblThongTinTK.setForeground(Color.WHITE);
	lblThongTinTK.setBounds(0, 0, 366, 22);
	panelTable.add(lblThongTinTK);
	
	modelTaiKhoan = (DefaultTableModel) tblTaiKhoan.getModel();
	
	panelXoa = new RoundedPanel();
	panelXoa.setBackground(getBackground());
	panelXoa.setBounds(975, 458, 600, 373);
	panelTable.add(panelXoa);
	panelXoa.setLayout(null);
	
	lblSuaTaiKhoan = new JLabel("SỬA TÀI KHOẢN");
	lblSuaTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
	lblSuaTaiKhoan.setForeground(Color.WHITE);
	lblSuaTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 25));
	lblSuaTaiKhoan.setBounds(89, 23, 421, 46);
	panelXoa.add(lblSuaTaiKhoan);
	
	panelThongTin = new RoundedPanel();
	panelThongTin.setBounds(25, 541, 930, 290);
	panelThongTin.setBackground(new Color(248, 198, 153));
	panelTable.add(panelThongTin);
	panelThongTin.setLayout(null);
	
	JLabel lblHinhNhanVien = new JLabel("");
	lblHinhNhanVien.setIcon(new ImageIcon("D:\\gitfolder\\QuanLyLuongSanPham\\QuanLyLuongSanPham\\src\\main\\resources\\img\\nv.png"));
	lblHinhNhanVien.setBounds(84, 71, 187, 166);
	panelThongTin.add(lblHinhNhanVien);
	
	lblTTNV = new JLabel("THÔNG TIN NHÂN VIÊN");
	lblTTNV.setForeground(Color.WHITE);
	lblTTNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
	lblTTNV.setHorizontalAlignment(SwingConstants.CENTER);
	lblTTNV.setBounds(341, 11, 421, 46);
	panelThongTin.add(lblTTNV);
	
	lblMa = new JLabel("Mã Nhân Viên:");
	lblMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblMa.setBounds(341, 54, 421, 29);
	panelThongTin.add(lblMa);
	
	JLabel lblTen = new JLabel("Tên Nhân Viên:");
	lblTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblTen.setBounds(341, 94, 421, 29);
	panelThongTin.add(lblTen);
	
	JLabel lblDC = new JLabel("Địa Chỉ:");
	lblDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblDC.setBounds(341, 134, 421, 29);
	panelThongTin.add(lblDC);
	
	lblSDT = new JLabel("Số Điện Thoại:");
	lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblSDT.setBounds(341, 174, 421, 29);
	panelThongTin.add(lblSDT);
	
	lblEmail = new JLabel("Email:");
	lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblEmail.setBounds(341, 214, 421, 29);
	panelThongTin.add(lblEmail);
	
	/**
	 * các chức năng
	 * 
	 */
	btnThem.addActionListener(this);
	
	
	
	//load data
	daoTK = new TaiKhoanDao();
	//listTK = daoTK.getDsTaiKhoan();
	//LoadTaiKhoan(listTK);
	}


	@Override
	public void actionPerformed(ActionEvent e) { 
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			TaiKhoan tk = getTaiKhoanTuTextfield();
			if(daoTK.themTaiKhoan(tk)) {
				JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công");
			}else 
				JOptionPane.showMessageDialog(this, "Thêm thất bại");
		}
	}
	private TaiKhoan getTaiKhoanTuTextfield() {
		
		String tenTK = txtTenTK.getText();
		String mk = txtMK.getText();
		return new TaiKhoan(tenTK,mk);
	}
	private void LoadTaiKhoan(List<TaiKhoan> list) {
		ChucNang.clearDataTable(modelTaiKhoan);
		for (TaiKhoan tk : list) {
			load1TaiKhoan(tk);
		}
	}
	private void load1TaiKhoan(TaiKhoan tk) {
		String n[]= {
			tk.getTenTaiKhoan(),tk.getMatKhau()
		};
		modelTaiKhoan.addRow(n);
	}
}

