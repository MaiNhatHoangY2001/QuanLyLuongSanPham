package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

import dao.SanPhamDao;
import gui_package.CircleBtn;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;
import model.SanPham;

public class Gui_SuaThongTinSanPham extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtTenSanPham;
	private JTextField txtGiaThanh;
	private JTextField txtNCC;
	private JTextField txtSanPham;

	private JButton btnLuu;
	private JButton btnXoaRong;
	private JButton btnHuyBo;

	private JComboBox cmbNgay;
	private JComboBox cmbThang;
	private JComboBox cmbNam;
	private JComboBox cmbLoai;

	private SanPham sp;
	private DecimalFormat fm = new DecimalFormat("#");
	private SanPhamDao daoSP;
	private JRadioButton radConBan;
	private JRadioButton radHetBan;

	/**
	 * Create the frame.
	 */
	public Gui_SuaThongTinSanPham(SanPham sanPham) {
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		/*
		 * Header
		 */
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBorder(new MatteBorder(0, 0, 5, 0, (Color) Color.WHITE));
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1440, 150);
		contentPane.add(pnlHeader);
		pnlHeader.setLayout(null);

		// Title Header
		JLabel lblNewLabel = new JLabel("SỬA THÔNG TIN SẢN PHẨM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(294, 28, 835, 93);
		pnlHeader.add(lblNewLabel);

		// Icon
		JLabel lblIcon = new JLabel("New label");
		Image imgUser = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/dtVua.png"))).getImage();
		lblIcon.setIcon(new ImageIcon(imgUser));
		lblIcon.setBounds(50, 42, 96, 66);
		pnlHeader.add(lblIcon);

		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(new Color(242, 129, 25));
		pnlContent.setBounds(0, 151, 1440, 873);
		contentPane.add(pnlContent);
		pnlContent.setLayout(null);

		/*
		 * Content
		 */
		JPanel pnlInput = new RoundedPanel();
		((RoundedPanel) pnlInput).setArcs(new DimensionUIResource(50, 50));
		pnlInput.setBackground(new Color(248, 198, 153));
		pnlInput.setBounds(120, 110, 1200, 581);
		pnlContent.add(pnlInput);
		pnlInput.setLayout(null);

		/*
		 * Cac Title input
		 */
		JLabel lblNewLabel_1 = new JLabel("Tên Sản Phẩm:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(81, 48, 225, 40);
		pnlInput.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Giá Thành:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(81, 136, 225, 40);
		pnlInput.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Loại:");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1_1.setBounds(81, 224, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nhà Cung Cấp:");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1_1_1.setBounds(81, 312, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày Sản Xuất:");
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1_1_1_1.setBounds(81, 400, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1_1_1);

		/*
		 * Cac input
		 */
		// Ten San Pham
		txtTenSanPham = new RoundTextField("", 1000);
		txtTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenSanPham.setBounds(316, 48, 800, 40);
		pnlInput.add(txtTenSanPham);
		txtTenSanPham.setColumns(10);

		// Gia thanh
		txtGiaThanh = new RoundTextField("", 1000);
		txtGiaThanh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtGiaThanh.setColumns(10);
		txtGiaThanh.setBounds(316, 136, 800, 40);
		pnlInput.add(txtGiaThanh);

		// Nha cung cap
		txtNCC = new RoundTextField("", 1000);
		txtNCC.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNCC.setColumns(10);
		txtNCC.setBounds(316, 312, 800, 40);
		pnlInput.add(txtNCC);

		// Ngày
		cmbNgay = new JComboBox();
		DefaultComboBoxModel<String> modelNgay = new DefaultComboBoxModel<String>();
		for (int i = 1; i <= 31; i++) {
			modelNgay.addElement(i + "");
		}
		cmbNgay.setModel(modelNgay);
		cmbNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNgay.setBackground(Color.WHITE);
		cmbNgay.setBounds(316, 400, 250, 40);
		pnlInput.add(cmbNgay);

		// Tháng
		cmbThang = new JComboBox();
		DefaultComboBoxModel<String> modelThang = new DefaultComboBoxModel<String>();
		for (int i = 1; i <= 12; i++) {
			modelThang.addElement("Tháng " + i);
		}
		cmbThang.setModel(modelThang);
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbThang.setBackground(Color.WHITE);
		cmbThang.setBounds(590, 400, 250, 40);
		pnlInput.add(cmbThang);

		// Năm
		DefaultComboBoxModel<String> modelNam = new DefaultComboBoxModel<String>();
		for (int i = LocalDate.now().getYear(); i >= 2000; i--) {
			modelNam.addElement(i + "");
		}
		cmbNam = new JComboBox();
		cmbNam.setModel(modelNam);
		cmbNam.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNam.setBackground(Color.WHITE);
		cmbNam.setBounds(867, 400, 250, 40);
		pnlInput.add(cmbNam);

		// Loai
		String[] dsLoai = { "Điện thoại", "ipad", "Loa", "Linh kiện điện tử" };
		cmbLoai = new JComboBox(dsLoai);
		cmbLoai.setBackground(Color.WHITE);
		cmbLoai.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbLoai.setBounds(316, 224, 800, 40);
		pnlInput.add(cmbLoai);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Trạng Thái:");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1_1_1_1_1.setBounds(81, 488, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1_1_1_1);

		radConBan = new JRadioButton("Còn Bán");
		radConBan.setSelected(true);
		radConBan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		radConBan.setBounds(316, 488, 250, 40);
		radConBan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlInput.add(radConBan);

		radHetBan = new JRadioButton("Hết Bán");
		radHetBan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		radHetBan.setBounds(590, 488, 250, 40);
		radHetBan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlInput.add(radHetBan);

		ButtonGroup group = new ButtonGroup();
		group.add(radConBan);
		group.add(radHetBan);

		/*
		 * Cac nut
		 */
		// Nut luu
		btnLuu = new CircleBtn("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setBackground(new Color(233, 180, 46));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLuu.setBounds(172, 756, 250, 70);
		btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnLuu);

		// Nut Xoa rong
		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(594, 756, 250, 70);
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnXoaRong);

		// Nut huy bo
		btnHuyBo = new CircleBtn("Hủy Bỏ");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(1016, 756, 250, 70);
		btnHuyBo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnHuyBo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 180, 46));
		panel.setBounds(120, 50, 279, 43);
		pnlContent.add(panel);
		panel.setLayout(null);

		// Hien Ma San Pham
		txtSanPham = new JTextField();
		txtSanPham.setEditable(false);
		txtSanPham.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSanPham.setBounds(114, 0, 165, 43);
		panel.add(txtSanPham);
		txtSanPham.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Sản Phẩm");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 0, 106, 43);
		panel.add(lblNewLabel_2);

		/*
		 * Them su kien
		 */
		btnHuyBo.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);

		sp = sanPham;
		daoSP = new SanPhamDao();

		hienThongTinSanPham(sanPham);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLuu)) {
			if (!kiemTraRong()) {
				SanPham sanPham = layThongTinTuJtextField();
				sanPham.setMaSanpham(sp.getMaSanpham());
				if (sanPham != null) {
					boolean rs = daoSP.capNhatSanPham(sanPham);
					if (rs)
						JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm thành công");
				}
			}
		} else if (o.equals(btnHuyBo)) {
			SanPham sanPham1 = daoSP.getSanPham(txtSanPham.getText());
			SanPham sanPham2 = layThongTinTuJtextField();
			sanPham2.setMaSanpham(txtSanPham.getText());
			if (kiemTraHaiSanPham(sanPham1, sanPham2)) {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không?", "Thông báo thoát",
						JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					this.dispose();
				}
			} else {
				int tl = JOptionPane.showConfirmDialog(this,
						"Bạn có muốn lưu thông tin Sản phẩm trước khi thoát không?", "Thông báo lưu",
						JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					daoSP.capNhatSanPham(sanPham2);
					this.dispose();
				} else {
					this.dispose();
				}
			}
		} else if (o.equals(btnXoaRong)) {
			XoaRongTextField();
		}

	}

	/**
	 * Kiểm tra JtextField Chưa nhập dữ liệu
	 * 
	 * @return true: các JtextField nhập đầy đủ dữ liệu
	 * @return false: có 1 JtextField chưa nhập dữ liệu
	 */
	public boolean kiemTraRong() {
		if (txtTenSanPham.getText().equals("")) {
			txtTenSanPham.requestFocus();
			JOptionPane.showMessageDialog(this, "Chưa nhập tên sản phẩm!");
			return true;
		}
		if (txtGiaThanh.getText().equals("")) {
			txtGiaThanh.requestFocus();
			JOptionPane.showMessageDialog(this, "Chưa nhập giá thành sản phẩm!");
			return true;
		}
		if (txtNCC.getText().equals("")) {
			txtNCC.requestFocus();
			JOptionPane.showMessageDialog(this, "Chưa nhập Nhà cung cấp sản phẩm");
			return true;
		}
		return false;
	}

	/**
	 * Kiểm trả 2 Sản Phẩm có giống nhay hay không
	 * 
	 * @param sanp: Sản Phẩm 1
	 * @param sp2:  Sản Phẩm 2
	 * @return true: 2 Sản Phẩm giống nhau
	 * @return false: 2 Sản Phẩm không giống nhau
	 */
	private boolean kiemTraHaiSanPham(SanPham sanp, SanPham sp2) {
		if (!sanp.getTenSanPham().equals(sp2.getTenSanPham())) {
			return false;
		} else if (!sanp.getnCC().equals(sp2.getnCC())) {
			return false;
		} else if (!sanp.getNgaySanXuat().equals(sp2.getNgaySanXuat())) {
			return false;
		} else if (!sanp.getLoai().equals(sp2.getLoai())) {
			return false;
		} else if (sanp.getGiaThanh() != sp2.getGiaThanh()) {
			return false;
		} else if (sanp.isTrangThai() != sp2.isTrangThai())
			return false;
		return true;
	}

	/**
	 * Láy thông tin từ các JtextField
	 * 
	 * @return SanPham: Sản Phẩm
	 * @return null: JtextField Giá Thành nhập chữ
	 */
	private SanPham layThongTinTuJtextField() {
		String ten = txtTenSanPham.getText();
		String NCC = txtNCC.getText();
		String loai = cmbLoai.getSelectedItem().toString();
		LocalDate date = getDate();
		boolean trangthai = radConBan.isSelected() == true;
		try {
			double gia = Double.parseDouble(txtGiaThanh.getText());
			return new SanPham(ten, gia, NCC, loai, date, trangthai);
		} catch (NumberFormatException e) {
			txtGiaThanh.requestFocus();
			JOptionPane.showMessageDialog(this, "Giá thành chỉ cho phép nhập số");
		}
		return null;
	}

	/**
	 * Lấy ngày trong combobox
	 * 
	 * @return date
	 */
	public LocalDate getDate() {
		int day = Integer.parseInt((cmbNgay.getSelectedItem().toString()));
		String word[] = cmbThang.getSelectedItem().toString().split(" ");
		int month = Integer.parseInt(word[1]);
		int year = Integer.parseInt(cmbNam.getSelectedItem().toString());
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}

	/**
	 * Xóa rỗng các JtextField và Focus vào JtextField Tên sản phẩm Các Jcombobox
	 * trờ về index đầu tiên
	 */
	public void XoaRongTextField() {
		txtTenSanPham.setText("");
		txtNCC.setText("");
		txtGiaThanh.setText("");
		cmbLoai.setSelectedIndex(0);
		cmbNgay.setSelectedIndex(0);
		cmbThang.setSelectedIndex(0);
		cmbNam.setSelectedIndex(0);
		radConBan.setSelected(true);
		txtTenSanPham.requestFocus();
	}

	/**
	 * Hiển thị thông tin Sản Phẩm liên các JtextField
	 * 
	 * @param sp1: Thông tin sản phẩm
	 */
	public void hienThongTinSanPham(SanPham sp1) {
		txtTenSanPham.setText(sp1.getTenSanPham());
		txtGiaThanh.setText(fm.format(sp1.getGiaThanh()));
		txtNCC.setText(sp1.getnCC());
		txtSanPham.setText(sp1.getMaSanpham());
		int ngay = sp1.getNgaySanXuat().getDayOfMonth();
		cmbNgay.setSelectedItem(ngay + "");
		int thang = sp1.getNgaySanXuat().getMonthValue();
		cmbThang.setSelectedItem("Tháng " + thang);
		int nam = sp1.getNgaySanXuat().getYear();
		cmbNam.setSelectedItem(nam + "");
		cmbLoai.setSelectedItem(sp1.getLoai());
		if (sp1.isTrangThai() == true)
			radConBan.setSelected(true);
		else
			radHetBan.setSelected(true);
	}
}
