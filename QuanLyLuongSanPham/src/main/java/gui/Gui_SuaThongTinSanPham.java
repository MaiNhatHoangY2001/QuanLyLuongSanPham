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
		JLabel lblNewLabel = new JLabel("S???A TH??NG TIN S???N PH???M");
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
		JLabel lblNewLabel_1 = new JLabel("T??n S???n Ph???m:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(81, 48, 225, 40);
		pnlInput.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Gi?? Th??nh:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(81, 136, 225, 40);
		pnlInput.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Lo???i:");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1_1.setBounds(81, 224, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nh?? Cung C???p:");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1_1_1.setBounds(81, 312, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ng??y S???n Xu???t:");
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

		// Ng??y
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

		// Th??ng
		cmbThang = new JComboBox();
		DefaultComboBoxModel<String> modelThang = new DefaultComboBoxModel<String>();
		for (int i = 1; i <= 12; i++) {
			modelThang.addElement("Th??ng " + i);
		}
		cmbThang.setModel(modelThang);
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbThang.setBackground(Color.WHITE);
		cmbThang.setBounds(590, 400, 250, 40);
		pnlInput.add(cmbThang);

		// N??m
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
		String[] dsLoai = { "??i???n tho???i", "ipad", "Loa", "Linh ki???n ??i???n t???" };
		cmbLoai = new JComboBox(dsLoai);
		cmbLoai.setBackground(Color.WHITE);
		cmbLoai.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbLoai.setBounds(316, 224, 800, 40);
		pnlInput.add(cmbLoai);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tr???ng Th??i:");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1_1_1_1_1.setBounds(81, 488, 225, 40);
		pnlInput.add(lblNewLabel_1_1_1_1_1_1);

		radConBan = new JRadioButton("C??n B??n");
		radConBan.setSelected(true);
		radConBan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		radConBan.setBounds(316, 488, 250, 40);
		radConBan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlInput.add(radConBan);

		radHetBan = new JRadioButton("H???t B??n");
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
		btnLuu = new CircleBtn("L??u");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setBackground(new Color(233, 180, 46));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLuu.setBounds(172, 756, 250, 70);
		btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnLuu);

		// Nut Xoa rong
		btnXoaRong = new CircleBtn("X??a R???ng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(594, 756, 250, 70);
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnXoaRong);

		// Nut huy bo
		btnHuyBo = new CircleBtn("H???y B???");
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

		JLabel lblNewLabel_2 = new JLabel("S???n Ph???m");
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
						JOptionPane.showMessageDialog(this, "C???p nh???t th??ng tin s???n ph???m th??nh c??ng");
				}
			}
		} else if (o.equals(btnHuyBo)) {
			SanPham sanPham1 = daoSP.getSanPham(txtSanPham.getText());
			SanPham sanPham2 = layThongTinTuJtextField();
			sanPham2.setMaSanpham(txtSanPham.getText());
			if (kiemTraHaiSanPham(sanPham1, sanPham2)) {
				int tl = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n tho??t kh??ng?", "Th??ng b??o tho??t",
						JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					this.dispose();
				}
			} else {
				int tl = JOptionPane.showConfirmDialog(this,
						"B???n c?? mu???n l??u th??ng tin S???n ph???m tr?????c khi tho??t kh??ng?", "Th??ng b??o l??u",
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
	 * Ki???m tra JtextField Ch??a nh???p d??? li???u
	 * 
	 * @return true: c??c JtextField nh???p ?????y ????? d??? li???u
	 * @return false: c?? 1 JtextField ch??a nh???p d??? li???u
	 */
	public boolean kiemTraRong() {
		if (txtTenSanPham.getText().equals("")) {
			txtTenSanPham.requestFocus();
			JOptionPane.showMessageDialog(this, "Ch??a nh???p t??n s???n ph???m!");
			return true;
		}
		if (txtGiaThanh.getText().equals("")) {
			txtGiaThanh.requestFocus();
			JOptionPane.showMessageDialog(this, "Ch??a nh???p gi?? th??nh s???n ph???m!");
			return true;
		}
		if (txtNCC.getText().equals("")) {
			txtNCC.requestFocus();
			JOptionPane.showMessageDialog(this, "Ch??a nh???p Nh?? cung c???p s???n ph???m");
			return true;
		}
		return false;
	}

	/**
	 * Ki???m tr??? 2 S???n Ph???m c?? gi???ng nhay hay kh??ng
	 * 
	 * @param sanp: S???n Ph???m 1
	 * @param sp2:  S???n Ph???m 2
	 * @return true: 2 S???n Ph???m gi???ng nhau
	 * @return false: 2 S???n Ph???m kh??ng gi???ng nhau
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
	 * L??y th??ng tin t??? c??c JtextField
	 * 
	 * @return SanPham: S???n Ph???m
	 * @return null: JtextField Gi?? Th??nh nh???p ch???
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
			JOptionPane.showMessageDialog(this, "Gi?? th??nh ch??? cho ph??p nh???p s???");
		}
		return null;
	}

	/**
	 * L???y ng??y trong combobox
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
	 * X??a r???ng c??c JtextField v?? Focus v??o JtextField T??n s???n ph???m C??c Jcombobox
	 * tr??? v??? index ?????u ti??n
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
	 * Hi???n th??? th??ng tin S???n Ph???m li??n c??c JtextField
	 * 
	 * @param sp1: Th??ng tin s???n ph???m
	 */
	public void hienThongTinSanPham(SanPham sp1) {
		txtTenSanPham.setText(sp1.getTenSanPham());
		txtGiaThanh.setText(fm.format(sp1.getGiaThanh()));
		txtNCC.setText(sp1.getnCC());
		txtSanPham.setText(sp1.getMaSanpham());
		int ngay = sp1.getNgaySanXuat().getDayOfMonth();
		cmbNgay.setSelectedItem(ngay + "");
		int thang = sp1.getNgaySanXuat().getMonthValue();
		cmbThang.setSelectedItem("Th??ng " + thang);
		int nam = sp1.getNgaySanXuat().getYear();
		cmbNam.setSelectedItem(nam + "");
		cmbLoai.setSelectedItem(sp1.getLoai());
		if (sp1.isTrangThai() == true)
			radConBan.setSelected(true);
		else
			radHetBan.setSelected(true);
	}
}
