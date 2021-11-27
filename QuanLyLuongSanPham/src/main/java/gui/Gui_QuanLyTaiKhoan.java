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

import dao.NhanVienDao;
import dao.TaiKhoanDao;
import gui_package.ChucNang;
import gui_package.CircleBtn;
import gui_package.RoundedPanel;
import model.NhanVien;
import model.TaiKhoan;
import services.QuanLyLuongService;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;

public class Gui_QuanLyTaiKhoan extends JPanel implements ActionListener, MouseListener {
	private String[] colsnameLK = { "Tên Tài Khoản", "Mật Khẩu" };
	private DefaultTableModel modelTaiKhoan;
	JPanel pnlHead;
	private JLabel lblQLTK;
	private JLabel lblNgay;
	private JLabel lblGio;
	private JPanel panelTable;
	private JPanel panelThem;
	private JTable tblTaiKhoan;

	private TaiKhoanDao daoTK;
	private List<TaiKhoan> listTK;
	private JPanel panelThemTK;
	private JLabel lblTen_1;
	private JLabel lblTen_2;
	private JTextField txt1;
	private JTextField txt2;
	private CircleBtn btnThem;
	private CircleBtn btnXoaRong;
	private JPanel panelSuaTK;
	private JLabel lblTen_3;
	private JLabel lblTen_4;
	private JTextField txtTenTK;
	private JTextField txtMK;
	private CircleBtn btnXoa;
	private CircleBtn btnLuu;
	private JPanel panelTTNV;
	private JLabel lblMa;
	private JLabel lblTen;
	private JLabel lblDC;
	private JLabel lblSDT;
	private JLabel lblEmail;
	private JLabel lblNS;

	public Gui_QuanLyTaiKhoan() {
		setSize(1600, 1046);
		setBackground(new Color(194, 93, 0));
		setLayout(null);
		/**
		 * Phần Trên chứa thanh menu và thanh bar ngang
		 */
		pnlHead = new JPanel();
		pnlHead.setLayout(null);
		pnlHead.setBackground(new Color(242, 129, 25));
		pnlHead.setBounds(0, 0, 1600, 100);
		add(pnlHead);

		lblQLTK = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblQLTK.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblQLTK.setForeground(Color.WHITE);
		lblQLTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLTK.setBounds(499, 0, 601, 100);
		pnlHead.add(lblQLTK);

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
		Image imgUser = new ImageIcon("img\\userNho.png").getImage();
		Image imgDX = new ImageIcon("img\\thoatNho.png").getImage();

		/**
		 * Phần dưới chứa bảng
		 */
		panelTable = new JPanel();
		panelTable.setBackground(new Color(242, 129, 25));
		panelTable.setBounds(0, 173, 1600, 873);
		add(panelTable);
		panelTable.setLayout(null);

		panelThem = new RoundedPanel();
		panelThem.setBackground(new Color(248, 198, 153));
		panelThem.setLayout(null);
		panelThem.setBounds(976, 20, 600, 811);
		panelTable.add(panelThem);

		panelThemTK = new JPanel();
		panelThemTK.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"TH\u00CAM T\u00C0I KHO\u1EA2N M\u1EDAI", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null,
				new Color(0, 0, 0)));
		panelThemTK.setBounds(20, 11, 556, 233);
		panelThemTK.setBackground(new Color(248, 198, 153));
		panelThem.add(panelThemTK);
		panelThemTK.setLayout(null);

		lblTen_1 = new JLabel("Mật Khẩu:");
		lblTen_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTen_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen_1.setBounds(33, 106, 106, 29);
		panelThemTK.add(lblTen_1);

		lblTen_2 = new JLabel("Tên Tài Khoản:");
		lblTen_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTen_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen_2.setBounds(23, 36, 116, 29);
		panelThemTK.add(lblTen_2);

		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(149, 37, 380, 30);
		panelThemTK.add(txt1);

		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(149, 107, 380, 30);
		panelThemTK.add(txt2);

		btnThem = new CircleBtn("Tạo Tài Khoản");
		btnThem.setBackground(new Color(233, 180, 46));
		btnThem.setBounds(168, 168, 120, 40);
		panelThemTK.add(btnThem);

		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(364, 168, 120, 40);
		panelThemTK.add(btnXoaRong);

		panelSuaTK = new JPanel();
		panelSuaTK.setLayout(null);
		panelSuaTK.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"S\u1EECA T\u00C0I KHO\u1EA2N", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelSuaTK.setBackground(new Color(248, 198, 153));
		panelSuaTK.setBounds(20, 255, 556, 233);
		panelThem.add(panelSuaTK);

		lblTen_3 = new JLabel("Mật Khẩu:");
		lblTen_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTen_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen_3.setBounds(33, 106, 106, 29);
		panelSuaTK.add(lblTen_3);

		lblTen_4 = new JLabel("Tên Tài Khoản:");
		lblTen_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTen_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen_4.setBounds(23, 36, 116, 29);
		panelSuaTK.add(lblTen_4);

		txtTenTK = new JTextField();
		txtTenTK.setEditable(false);
		txtTenTK.setColumns(10);
		txtTenTK.setBounds(149, 37, 380, 30);
		panelSuaTK.add(txtTenTK);

		txtMK = new JTextField();
		txtMK.setColumns(10);
		txtMK.setBounds(149, 107, 380, 30);
		panelSuaTK.add(txtMK);

		btnXoa = new CircleBtn("Xóa Tài Khoản");
		btnXoa.setBounds(168, 168, 120, 40);
		btnXoa.setBackground(new Color(233, 180, 46));
		panelSuaTK.add(btnXoa);

		btnLuu = new CircleBtn("Lưu Tài Khoản");
		btnLuu.setBounds(364, 168, 120, 40);
		btnLuu.setBackground(new Color(233, 180, 46));
		panelSuaTK.add(btnLuu);

		panelTTNV = new JPanel();
		panelTTNV.setLayout(null);
		panelTTNV.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"TH\u00D4NG TIN NH\u00C2N VI\u00CAN", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null,
				new Color(0, 0, 0)));
		panelTTNV.setBackground(new Color(248, 198, 153));
		panelTTNV.setBounds(20, 499, 556, 289);
		panelThem.add(panelTTNV);

		lblMa = new JLabel("Mã Nhân Viên:");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMa.setBounds(32, 40, 492, 29);
		panelTTNV.add(lblMa);

		lblTen = new JLabel("Tên Nhân Viên:");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen.setBounds(32, 80, 492, 29);
		panelTTNV.add(lblTen);

		lblDC = new JLabel("Địa Chỉ:");
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDC.setBounds(32, 120, 492, 29);
		panelTTNV.add(lblDC);

		lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSDT.setBounds(32, 160, 492, 29);
		panelTTNV.add(lblSDT);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(32, 236, 492, 29);
		panelTTNV.add(lblEmail);

		lblNS = new JLabel("Ngày Sinh:");
		lblNS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNS.setBounds(32, 200, 492, 29);
		panelTTNV.add(lblNS);

		new DefaultTableModel(colsnameLK, 0);

		tblTaiKhoan = new JTable(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null } },
				colsnameLK)) {

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
		thanhCuon2.setBounds(0, 20, 955, 811);
		thanhCuon2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		panelTable.add(thanhCuon2);

		JLabel lblThongTinTK = new JLabel("Thông Tin Tài Khoản");
		lblThongTinTK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThongTinTK.setForeground(Color.WHITE);
		lblThongTinTK.setBounds(0, 0, 366, 22);
		panelTable.add(lblThongTinTK);

		modelTaiKhoan = (DefaultTableModel) tblTaiKhoan.getModel();

		// Su kien
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		tblTaiKhoan.addMouseListener(this);

		// load data
		daoTK = new TaiKhoanDao();
		listTK = daoTK.getDsTaiKhoan();
		LoadTaiKhoan(listTK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			NhanVienDao nv = new NhanVienDao();
			NhanVien nv1 = nv.getNhanVienTheoMa(txt1.getText().trim());
			if (daoTK.themTaiKhoan(new TaiKhoan(nv1, txt2.getText().trim()))) {
				JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công");
				listTK = daoTK.getDsTaiKhoan();
				LoadTaiKhoan(listTK);
			} else
				JOptionPane.showMessageDialog(this, "Thêm thất bại");
		} else if (o.equals(btnXoa)) {
			if (tblTaiKhoan.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Chọn dòng muốn xóa");
			} else {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa tài khoản này không?",
						"Xóa Tài Khoản", JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					String tenTaiKhoan = modelTaiKhoan.getValueAt(tblTaiKhoan.getSelectedRow(), 0).toString();
					boolean x = daoTK.xoaTaiKhoanTheoMa(tenTaiKhoan);
					if (x) {
						JOptionPane.showMessageDialog(this, "Xóa tài khoản thành công");
						listTK = daoTK.getDsTaiKhoan();
						LoadTaiKhoan(listTK);
					} else
						JOptionPane.showMessageDialog(this, "Xóa tài khoản thất bại");
				}

			}

		} else if (o.equals(btnLuu)) {
			TaiKhoan nv1 = daoTK.getTaiKhoan(txtTenTK.getText());
			if (daoTK.capNhatTaiKhoan(nv1)) {
				JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công");
				listTK = daoTK.getDsTaiKhoan();
				LoadTaiKhoan(listTK);
			} else
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
		}
	}

	private void LoadTaiKhoan(List<TaiKhoan> list) {
		ChucNang.clearDataTable(modelTaiKhoan);
		for (TaiKhoan tk : list) {
			load1TaiKhoan(tk);
		}
	}

	private void load1TaiKhoan(TaiKhoan tk) {
		String n[] = { tk.getTenTaiKhoan(), tk.getMatKhau() };
		modelTaiKhoan.addRow(n);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object tenTaiKhoan = modelTaiKhoan.getValueAt(tblTaiKhoan.getSelectedRow(), 0);
		Object matKhau = modelTaiKhoan.getValueAt(tblTaiKhoan.getSelectedRow(), 1);
		txtTenTK.setText((String) tenTaiKhoan);
		txtMK.setText((String) matKhau);
		setDataPanelThongTinNV(tenTaiKhoan);

	}

	public void setDataPanelThongTinNV(Object maNhanVien) {
		QuanLyLuongService quanLyLuongService = new QuanLyLuongService();
		NhanVien nhanVien = new NhanVien();
		if (maNhanVien != null) {
			nhanVien = quanLyLuongService.getNhanVien(maNhanVien.toString());
			lblMa.setText("Mã Nhân viên: " + nhanVien.getMaNhanVien());
			lblTen.setText("Tên Nhân viên: " + nhanVien.getTenNhanVien());
			lblDC.setText("Địa Chỉ: " + nhanVien.getDiaChi());
			lblSDT.setText("Số điện thoại: " + nhanVien.getsDT());
			lblNS.setText("Ngày sinh: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(nhanVien.getNgaySinh()));
			lblEmail.setText("Email: " + nhanVien.getEmail());
		} else {
			clearThongTinNhanVien();
		}
	}

	public void clearThongTinNhanVien() {
		lblTen.setText("Tên Nhân Viên:");
		lblMa.setText("Mã Nhân viên:");
		lblSDT.setText("Số điện thoại:");
		lblDC.setText("Địa Chỉ: ");
		lblNS.setText("Ngày sinh:");
		lblEmail.setText("Email: ");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
