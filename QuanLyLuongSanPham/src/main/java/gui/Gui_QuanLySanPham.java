package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import gui_package.ChucNang;
import gui_package.CircleBtn;
import gui_package.RoundTextField;
import model.NhanVien;
import model.SanPham;
import services.QuanlySanPhamService;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.SanPhamDao;
import javax.swing.SwingConstants;

public class Gui_QuanLySanPham extends JPanel implements ActionListener, ItemListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTImKiem;
	private JTextField txtTongSoSP;

	JPanel pnlHead;
	private JPanel pnlContent;

	private JLabel lblNgay;
	private JLabel lblGio;
	private JLabel lblTitleHeader;
	private JLabel lblThongTinSP;
	private JLabel lblTongSoSP;

	private JButton btnSuaNV;
	private JButton btnTimKiem;
	private JButton btnLamMoi;

	private JComboBox cmbLoaiTimKiem;

	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	private NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
	private List<String> listMaSp;
	private JPanel panel;
	private JTextField txtSoTrang;
	private JButton btnTrai;
	private JButton btnDoubleTrai;
	private JButton btnPhai;
	private JButton btnDoublePhai;
	private List<SanPham> list50Sp;
	private QuanlySanPhamService sv;
	private int index;
	private int tongSP;
	private int soTrang;
	private int tongSoTrang;

	/**
	 * Create the panel.
	 */
	public Gui_QuanLySanPham() {
		setSize(1600, 1006);
		setBackground(new Color(242, 129, 25));
		setLayout(null);

		/*
		 * Phan: Header
		 */
		// Background header
		pnlHead = new JPanel();
		pnlHead.setLayout(null);
		pnlHead.setBackground(new Color(242, 129, 25));
		pnlHead.setBounds(0, 0, 1600, 92);
		add(pnlHead);

		// Jlable Title Header
		lblTitleHeader = new JLabel("QU???N L?? S???N PH???M");
		lblTitleHeader.setForeground(Color.WHITE);
		lblTitleHeader.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblTitleHeader.setBounds(519, 11, 535, 78);
		pnlHead.add(lblTitleHeader);

		// Jlable Date
		lblNgay = new JLabel("17/10/2021");
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgay.setBounds(10, 24, 122, 29);
		pnlHead.add(lblNgay);

		// Jlable Time
		lblGio = new JLabel("7:27:50");
		lblGio.setForeground(Color.WHITE);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGio.setBounds(10, 57, 81, 29);

		pnlHead.add(lblGio);
		ChucNang.setGio(lblGio, lblNgay);

		/*
		 * Phan: Chuc Nang
		 */
		// Background Chuc Nang
		JPanel pnlNgang = new JPanel();
		pnlNgang.setLayout(null);
		pnlNgang.setBackground(new Color(194, 93, 0));
		pnlNgang.setBounds(0, 92, 1600, 72);
		add(pnlNgang);

		// JButton Sua Nhan Vien
		btnSuaNV = new JButton("S???a");
		btnSuaNV.setForeground(Color.WHITE);
		btnSuaNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSuaNV.setBackground(new Color(233, 180, 46));
		btnSuaNV.setBounds(10, 13, 150, 45);
		btnSuaNV.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnSuaNV);

		// L??m m???i
		btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLamMoi.setBackground(new Color(233, 180, 46));
		btnLamMoi.setBounds(1424, 13, 150, 45);
		btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnLamMoi);

		// JButton Tim Kiem
		btnTimKiem = new JButton("T??m");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnTimKiem.setBackground(new Color(233, 180, 46));
		btnTimKiem.setBounds(1265, 13, 150, 45);
		btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNgang.add(btnTimKiem);

		// JTextField Tim Kiem
		txtTImKiem = new JTextField("", 100);
		txtTImKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTImKiem.setBounds(330, 16, 505, 40);
		pnlNgang.add(txtTImKiem);

		// JCombobox Tim kiem
		String loai[] = { "T??m theo t??n", "T??m theo m??", "Gi?? d?????i 10 tri???u", "Gi?? 10 - 20 tri???u",
				"Gi?? 20 - 50 tri???u" };
		cmbLoaiTimKiem = new JComboBox(loai);
		cmbLoaiTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbLoaiTimKiem.setBounds(845, 16, 410, 40);
		pnlNgang.add(cmbLoaiTimKiem);

		/*
		 * Phan Content
		 */
		// BackGround Content
		pnlContent = new JPanel();
		pnlContent.setLayout(null);
		pnlContent.setBackground(new Color(242, 129, 25));
		pnlContent.setBounds(0, 164, 1600, 882);
		add(pnlContent);

		// JLable title Bang
		lblThongTinSP = new JLabel("Th??ng tin s???n ph???m");
		lblThongTinSP.setForeground(Color.WHITE);
		lblThongTinSP.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblThongTinSP.setBounds(10, 11, 216, 34);
		pnlContent.add(lblThongTinSP);

		/*
		 * Hien So Luong Nhan Vien
		 */
		// JTextField Tong so Nhan Vien
		txtTongSoSP = new JTextField();
		txtTongSoSP.setForeground(Color.BLACK);
		txtTongSoSP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongSoSP.setEnabled(false);
		txtTongSoSP.setColumns(10);
		txtTongSoSP.setBounds(1400, 11, 174, 32);
		pnlContent.add(txtTongSoSP);

		// JLable Tong so Nhan Vien
		lblTongSoSP = new JLabel("T???ng s??? s???n ph???m:");
		lblTongSoSP.setForeground(Color.WHITE);
		lblTongSoSP.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTongSoSP.setBounds(1180, 11, 210, 34);
		pnlContent.add(lblTongSoSP);

		/*
		 * Bang thong tin Nhan Vien
		 */
		// Thanh Cuon
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 1564, 723);
		pnlContent.add(scrollPane);
		// Header Title Nhan Vien
		String headerTitle[] = { "T??n S???n Ph???m", "Lo???i", "Nh?? Cung C???p", "Gi?? Th??nh", "Tr???ng Th??i" };
		// Model Table
		model = new DefaultTableModel(headerTitle, 50) {

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
		// Table
		table = new JTable(model);
		table.setRowHeight(35); // set height items
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		// Set Font title table
		JTableHeader headerTable = table.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
		headerTable.setBackground(new Color(248, 198, 153));
		scrollPane.setViewportView(table);
		
		int[] i = {3};
		ChucNang.setRightAlignmentTable(i, table);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(194, 93, 0));
		panel.setBounds(0, 780, 1600, 57);
		pnlContent.add(panel);

		txtSoTrang = new JTextField();
		txtSoTrang.setText("");
		txtSoTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoTrang.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSoTrang.setColumns(10);
		txtSoTrang.setEditable(false);
		txtSoTrang.setBounds(725, 8, 150, 40);
		panel.add(txtSoTrang);

		btnTrai = new JButton("<");
		btnTrai.setForeground(Color.WHITE);
		btnTrai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrai.setBounds(626, 8, 89, 40);
		btnTrai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTrai.setBackground(new Color(233, 180, 46));
		panel.add(btnTrai);

		btnDoubleTrai = new JButton("<<");
		btnDoubleTrai.setForeground(Color.WHITE);
		btnDoubleTrai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDoubleTrai.setBounds(527, 8, 89, 40);
		btnDoubleTrai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDoubleTrai.setBackground(new Color(233, 180, 46));
		panel.add(btnDoubleTrai);

		btnPhai = new JButton(">");
		btnPhai.setForeground(Color.WHITE);
		btnPhai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPhai.setBounds(885, 8, 89, 40);
		btnPhai.setBackground(new Color(233, 180, 46));
		btnPhai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnPhai);

		btnDoublePhai = new JButton(">>");
		btnDoublePhai.setForeground(Color.WHITE);
		btnDoublePhai.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoublePhai.setBounds(984, 8, 89, 40);
		btnDoublePhai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDoublePhai.setBackground(new Color(233, 180, 46));
		panel.add(btnDoublePhai);
		
		btnSuaNV.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnTrai.addActionListener(this);
		btnDoubleTrai.addActionListener(this);
		btnPhai.addActionListener(this);
		btnDoublePhai.addActionListener(this);
		cmbLoaiTimKiem.addItemListener(this);
		txtSoTrang.addActionListener(this);
		txtTImKiem.addActionListener(this);
		table.addMouseListener(this);

		tongSP = 0;
		tongSoTrang = 0;
		soTrang = 0;
		index = 0;
		sv = new QuanlySanPhamService();
		list50Sp = sv.get50SanPhamTheoViTri(0);

		loadMacDinh();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnSuaNV)) {
			if (table.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "H??y ch???n Nh??n Vi??n c???n s???a");
			} else {
				SanPham sp = sv.getSanPhamTheoMa(listMaSp.get(table.getSelectedRow()));
				new Gui_SuaThongTinSanPham(sp).setVisible(true);
			}
		} else if (o.equals(btnLamMoi)) {
			loadMacDinh();
		} else if (o.equals(btnTimKiem)) {
			String data = txtTImKiem.getText();
			String loaiTK = cmbLoaiTimKiem.getSelectedItem().toString();
			if (data.equals("")) {
				loadMacDinh();
			} else {
				if (loaiTK.equals("T??m theo t??n")) {
					ChucNang.clearDataTable(model);
					List<SanPham> list = sv.getDsSanPhamTheoTenSanPham(data);
					index = 0;
					tongSP = list.size();
					soTrang = 1;
					tongSoTrang = 1;
					loadTableCustom(list, soTrang, tongSP);
				} else if (loaiTK.equals("T??m theo m??")) {
					SanPham sanPham = sv.getSanPhamTheoMa(data);
					if (sanPham == null)
						loadMacDinh();
					else {
						index = 0;
						tongSP = 1;
						soTrang = 1;
						tongSoTrang = 1;
						ChucNang.clearDataTable(model);
						load1ThongTinSanPham(sanPham);
					}
				}
			}
		} else if (o.equals(btnTrai)) {
			if (1 < soTrang) {
				index -= 50;
				list50Sp = sv.get50SanPhamTheoViTri(index);
				soTrang--;
				loadTableCustom(list50Sp, soTrang, tongSP);
			}
			// S??? ki???n Ch???n h??ng ????u ti??n
		} else if (o.equals(btnDoubleTrai)) {
			if (1 < soTrang) {
				index = 0;
				list50Sp = sv.get50SanPhamTheoViTri(index);
				soTrang = 1;
				loadTableCustom(list50Sp, soTrang, tongSP);
			}
			// S??? ki???n ch???n h??ng cu???i
		} else if (o.equals(btnPhai)) {
			if (soTrang < tongSoTrang) {
				index += 50;
				list50Sp = sv.get50SanPhamTheoViTri(index);
				soTrang++;
				loadTableCustom(list50Sp, soTrang, tongSP);
			}
			// s??? ki???n ch???n h??ng cu???i c??ng
		} else if (o.equals(btnDoublePhai)) {
			if (soTrang < tongSoTrang) {
				for (int i = soTrang; soTrang < tongSoTrang; i++) {
					index += 50;
					soTrang++;
				}
				list50Sp = sv.get50SanPhamTheoViTri(index);
				loadTableCustom(list50Sp, soTrang, tongSP);
			}
			// S??? ki???n cho n??t Enter cho Text S??? trang
		} else if (o.equals(txtTImKiem)) {
			String data = txtTImKiem.getText();
			String loaiTK = cmbLoaiTimKiem.getSelectedItem().toString();
			if (data.equals("")) {
				loadMacDinh();
			} else {
				if (loaiTK.equals("T??m theo t??n")) {
					ChucNang.clearDataTable(model);
					List<SanPham> list = sv.getDsSanPhamTheoTenSanPham(data);
					index = 0;
					tongSP = list.size();
					soTrang = 1;
					tongSoTrang = 1;
					loadTableCustom(list, soTrang, tongSP);
				} else if (loaiTK.equals("T??m theo m??")) {
					SanPham sanPham = sv.getSanPhamTheoMa(data);
					if (sanPham == null)
						loadMacDinh();
					else {
						index = 0;
						tongSP = 1;
						soTrang = 1;
						tongSoTrang = 1;
						ChucNang.clearDataTable(model);
						load1ThongTinSanPham(sanPham);
					}
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox cmb = (JComboBox) e.getSource();
		if (cmb.getSelectedItem().equals("Gi?? d?????i 10 tri???u")) {
			ChucNang.clearDataTable(model);
			List<SanPham> list = sv.getDsSanPhamTheoGiaThanh(0, 10000000);
			index = 0;
			tongSP = list.size();
			soTrang = 1;
			tongSoTrang = 1;
			loadTableCustom(list, soTrang, tongSP);
		} else if (cmb.getSelectedItem().equals("Gi?? 10 - 20 tri???u")) {
			ChucNang.clearDataTable(model);
			List<SanPham> list = sv.getDsSanPhamTheoGiaThanh(10000000, 20000000);
			index = 0;
			tongSP = list.size();
			soTrang = 1;
			tongSoTrang = 1;
			loadTableCustom(list, soTrang, tongSP);
		} else if (cmb.getSelectedItem().equals("Gi?? 20 - 50 tri???u")) {
			ChucNang.clearDataTable(model);
			List<SanPham> list = sv.getDsSanPhamTheoGiaThanh(20000000, 50000000);
			index = 0;
			tongSP = list.size();
			soTrang = 1;
			tongSoTrang = 1;
			loadTableCustom(list, soTrang, tongSP);
		} else {
			loadMacDinh();
		}
	}

	private void loadMacDinh() {
		index = 0;
		soTrang = 1;
		tongSP = sv.getTongSoSanPham();
		tongSoTrang = getTongSoTrangTheoTongSanPham(tongSP);
		List<SanPham> list = sv.get50SanPhamTheoViTri(0);
		LoadThongTinSanPham(list);
		txtSoTrang.setText(soTrang + "");
		txtTongSoSP.setText(tongSP + "");
	}

	public int getTongSoTrangTheoTongSanPham(int tongsv) {
		double rs = (double) tongsv / (double) 50;
		double rs2 = tongsv / 50;
		if (rs == rs2)
			return (int) rs2;
		else
			return (int) rs2 + 1;
	}

	/**
	 * Load Data to JTable NhanVien Load TongSoNhanVien to JTextField Tong So
	 * NhanVien
	 * 
	 * @param list
	 */
	private void LoadThongTinSanPham(List<SanPham> list) {
		txtSoTrang.setText("");
		ChucNang.clearDataTable(model);
		for (SanPham sanPham : list) {
			load1ThongTinSanPham(sanPham);
		}
		txtTongSoSP.setText(list.size() + "");
		listMaSp = getDsMaSP(list);
	}

	private void loadTableCustom(List<SanPham> list, int st, int tongsp) {
		LoadThongTinSanPham(list);
		txtSoTrang.setText(st + "");
		txtTongSoSP.setText(tongsp + "");
	}

	public void load1ThongTinSanPham(SanPham sanPham) {
		txtSoTrang.setText("");
		String n[] = { sanPham.getTenSanPham(), sanPham.getLoai(), sanPham.getnCC(),
				vnFormat.format(sanPham.getGiaThanh()), sanPham.isTrangThai() == true ? "C??n b??n" : "H???t b??n" };
		model.addRow(n);
		listMaSp = new ArrayList<String>();
		listMaSp.add(sanPham.getMaSanpham());
	}

	private List<String> getDsMaSP(List<SanPham> list) {
		List<String> listMa = new ArrayList<String>();
		for (SanPham sanPham : list) {
			listMa.add(sanPham.getMaSanpham());
		}
		return listMa;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
