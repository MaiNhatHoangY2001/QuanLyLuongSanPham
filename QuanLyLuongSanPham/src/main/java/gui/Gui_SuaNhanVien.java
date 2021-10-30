package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

import gui_package.CircleBtn;
import gui_package.Regex;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Gui_SuaNhanVien extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel lblMaNV;

	private JButton btnLuu;
	private JButton btnXoaRong;
	private JButton btnHuyBo;
	private JButton btnXaThai;

	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTextField txtEmail;
	private JTextField txtSDT;

	private JComboBox<String> cmbNgay;
	private JComboBox<String> cmbThang;
	private JComboBox<String> cmbNam;

	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JPanel pnlNam;
	private JLabel lblNam;
	private JPanel pnlNu;
	private JLabel lblNu;
	private JLabel lblTTNhanVien;
	private NhanVien nhanVien;

	public static void main(String[] args) {
		NhanVien nv = new NhanVien("Mai Ngoc Long", "Tan Xuan, Ba Tri, Ben Tre", "0334172541", "321780336", false,
				"maingoclong395@gmail.com", LocalDate.of(2000, 11, 04), false);
		nv.setMaNhanVien("MV0001");
		new Gui_SuaNhanVien(nv).setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Gui_SuaNhanVien(NhanVien nv) {
		setUndecorated(true);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/*
		 * Phần Header
		 */
		// Background Header
		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBorder(new MatteBorder(0, 0, 5, 0, (Color) Color.WHITE));
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1424, 150);
		contentPane.add(pnlHeader);

		// Title Header
		JLabel lblTitleHeader = new JLabel("SỬA THÔNG TIN NHÂN VIÊN");
		lblTitleHeader.setForeground(Color.WHITE);
		lblTitleHeader.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblTitleHeader.setBounds(281, 28, 861, 93);
		pnlHeader.add(lblTitleHeader);

		// Icon
		JLabel lblIcon = new JLabel("");
		Image imgUser = new ImageIcon("img\\dtVua.png").getImage();
		lblIcon.setIcon(new ImageIcon(imgUser));
		lblIcon.setBounds(50, 42, 96, 66);
		pnlHeader.add(lblIcon);

		/*
		 * Phần Content
		 */
		// Background Content
		JPanel pnlContent = new JPanel();
		pnlContent.setLayout(null);
		pnlContent.setBackground(new Color(242, 129, 25));
		pnlContent.setBounds(0, 151, 1424, 834);
		contentPane.add(pnlContent);

		// Hiện mã nhân viên
		lblMaNV = new JLabel("Mã Nhân Viên: " + nv.getMaNhanVien());
		lblMaNV.setForeground(Color.WHITE);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMaNV.setBounds(152, 26, 339, 37);
		pnlContent.add(lblMaNV);

		// Hiện trạng thái nhân viên làm việc
		lblTTNhanVien = new JLabel();
		lblTTNhanVien.setForeground(Color.WHITE);
		lblTTNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTTNhanVien.setBounds(970, 26, 339, 37);
		pnlContent.add(lblTTNhanVien);

		// Nút Lưu
		btnLuu = new CircleBtn("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLuu.setBackground(new Color(233, 180, 46));
		btnLuu.setBounds(183, 726, 230, 70);
		btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnLuu);

		// Nút Xóa Rổng
		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(733, 726, 230, 70);
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnXoaRong);

		// Nút Hủy Bỏ
		btnHuyBo = new CircleBtn("Hủy Bỏ");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(1008, 726, 230, 70);
		btnHuyBo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnHuyBo);

		// Nút Xa Thải
		btnXaThai = new CircleBtn("Xa Thải");
		btnXaThai.setForeground(Color.WHITE);
		btnXaThai.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXaThai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXaThai.setBackground(new Color(233, 180, 46));
		btnXaThai.setBounds(458, 726, 230, 70);
		pnlContent.add(btnXaThai);

		// Background input
		RoundedPanel pnlInput = new RoundedPanel();
		((RoundedPanel) pnlInput).setArcs(new DimensionUIResource(50, 50));
		pnlInput.setLayout(null);
		pnlInput.setBackground(new Color(248, 198, 153));
		pnlInput.setBounds(109, 63, 1200, 623);
		pnlContent.add(pnlInput);

		// Nhập tên nhân viên
		JLabel lblHoTen = new JLabel("Họ Và Tên:");
		lblHoTen.setForeground(Color.BLACK);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHoTen.setBounds(81, 42, 225, 40);
		pnlInput.add(lblHoTen);

		txtTen = new RoundTextField("", 1000);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTen.setColumns(10);
		txtTen.setBounds(387, 37, 730, 50);
		pnlInput.add(txtTen);

		// Nhập địa chỉ
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDiaChi.setBounds(81, 288, 225, 40);
		pnlInput.add(lblDiaChi);

		txtDiaChi = new RoundTextField("", 1000);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(387, 283, 730, 50);
		pnlInput.add(txtDiaChi);

		// Nhập số điện thoại
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSDT.setBounds(81, 370, 225, 40);
		pnlInput.add(lblSDT);

		txtSDT = new RoundTextField("", 1000);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setColumns(10);
		txtSDT.setBounds(387, 365, 730, 50);
		pnlInput.add(txtSDT);

		// Nhập chứng minh nhân dân
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setForeground(Color.BLACK);
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCMND.setBounds(81, 452, 225, 40);
		pnlInput.add(lblCMND);

		txtCMND = new RoundTextField("", 1000);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setColumns(10);
		txtCMND.setBounds(387, 447, 730, 50);
		pnlInput.add(txtCMND);

		// Nhập email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEmail.setBounds(81, 534, 225, 40);
		pnlInput.add(lblEmail);

		txtEmail = new RoundTextField("", 1000);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtEmail.setColumns(10);
		txtEmail.setBounds(387, 529, 730, 50);
		pnlInput.add(txtEmail);

		/*
		 * Nhập ngày sinh
		 */
		// title
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNgaySinh.setBounds(81, 120, 225, 40);
		pnlInput.add(lblNgaySinh);

		// Ngày
		cmbNgay = new JComboBox<String>();
		cmbNgay.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		cmbNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNgay.setBackground(Color.WHITE);
		cmbNgay.setBounds(387, 115, 220, 50);
		pnlInput.add(cmbNgay);

		// Tháng
		cmbThang = new JComboBox<String>();
		cmbThang.setModel(new DefaultComboBoxModel(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5",
				"Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbThang.setBackground(Color.WHITE);
		cmbThang.setBounds(646, 115, 220, 50);
		pnlInput.add(cmbThang);

		// Năm
		int namTu18Tuoi = LocalDate.now().getYear() - 18;
		DefaultComboBoxModel modelNam = new DefaultComboBoxModel();
		for (int i = namTu18Tuoi; i >= 1900; i--) {
			modelNam.addElement(i);
		}
		cmbNam = new JComboBox<String>();
		cmbNam.setModel(modelNam);
		cmbNam.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNam.setBackground(Color.WHITE);
		cmbNam.setBounds(897, 115, 220, 50);
		pnlInput.add(cmbNam);

		/*
		 * Nhập giới tính
		 */
		// title giới tính
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setForeground(Color.BLACK);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGioiTinh.setBounds(81, 200, 225, 40);
		pnlInput.add(lblGioiTinh);

		// Giới tính nam
		pnlNam = new JPanel();
		pnlNam.setBackground(Color.WHITE);
		pnlNam.setBounds(387, 194, 220, 50);
		pnlInput.add(pnlNam);
		pnlNam.setLayout(null);
		pnlNam.setCursor(new Cursor(Cursor.HAND_CURSOR));

		rdbtnNam = new JRadioButton("");
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setPreferredSize(new Dimension(30, 30));
		rdbtnNam.setMaximumSize(new Dimension(30, 30));
		rdbtnNam.setIconTextGap(6);
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnNam.setBounds(194, 0, 20, 50);
		rdbtnNam.setSelected(true);
		pnlNam.add(rdbtnNam);
		rdbtnNam.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblNam = new JLabel("Nam");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNam.setBounds(10, 11, 49, 28);
		pnlNam.add(lblNam);
		lblNam.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// giới tính nữ
		pnlNu = new JPanel();
		pnlNu.setLayout(null);
		pnlNu.setBackground(Color.WHITE);
		pnlNu.setBounds(646, 194, 220, 50);
		pnlNu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlInput.add(pnlNu);

		rdbtnNu = new JRadioButton("");
		rdbtnNu.setPreferredSize(new Dimension(30, 30));
		rdbtnNu.setMaximumSize(new Dimension(30, 30));
		rdbtnNu.setIconTextGap(6);
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setBounds(194, 0, 20, 50);
		pnlNu.add(rdbtnNu);

		lblNu = new JLabel("Nữ");
		lblNu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNu.setBounds(10, 11, 37, 28);
		lblNu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNu.add(lblNu);

		// GroundButton
		ButtonGroup btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);

		/*
		 * Thiêt lập Sự kiện cho nút
		 */
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnHuyBo.addActionListener(this);
		btnXaThai.addActionListener(this);
		pnlNam.addMouseListener(this);
		lblNam.addMouseListener(this);
		pnlNu.addMouseListener(this);
		lblNu.addMouseListener(this);

		/*
		 * Hiện dữ liệu vào các tool
		 */
		nhanVien = nv;
		loadDuLieuLen(nv);
	}

	private void loadDuLieuLen(NhanVien nv) {
		txtTen.setText(nv.getTenNhanVien());
		txtDiaChi.setText(nv.getDiaChi());
		txtSDT.setText(nv.getsDT());
		txtEmail.setText(nv.getEmail());
		txtCMND.setText(nv.getcCCD());
		int day = nv.getNgaySinh().getDayOfMonth();
		cmbNgay.setSelectedIndex(day - 1);
		int month = nv.getNgaySinh().getMonthValue();
		cmbThang.setSelectedIndex(month - 1);
		int year = nv.getNgaySinh().getYear();
		cmbNam.setSelectedItem(year);
		if (nv.isGioiTinh() == true)
			rdbtnNam.setSelected(true);
		else
			rdbtnNu.setSelected(true);
		if (nv.gettrangThaiLamViec() == true) {
			btnXaThai.setText("Nghỉ việc");
		} else if (nv.gettrangThaiLamViec() == false) {
			lblTTNhanVien.setText("Nhân viên đã nghỉ việc");
			btnXaThai.setText("Nhận");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnHuyBo)) {
			int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không?", "Thông báo thoát",
					JOptionPane.YES_NO_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (o.equals(btnXoaRong)) {
			xoaRongText();
		} else if (o.equals(btnXaThai)) {
			if (btnXaThai.getText().equals("Nghỉ việc")) {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn xa thải nhân viên này không?",
						"Thông báo", JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					lblTTNhanVien.setText("Nhân viên đã nghỉ việc");
					nhanVien.setTrangThaiLamViec(false);
					btnXaThai.setText("Nhận");
				}
			} else {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn nhận nhân viên làm này không?",
						"Thông báo", JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					lblTTNhanVien.setText("");
					nhanVien.setTrangThaiLamViec(true);
					btnXaThai.setText("Nghỉ việc");
				}
			}
		} else if (o.equals(btnLuu)) {
			if (kiemTraRegex()) {
				NhanVien nv = getNhanVienTuTextfield();
				nv.setMaNhanVien(nhanVien.getMaNhanVien());
				System.out.println(nv);
				JOptionPane.showMessageDialog(this, "Bạn đã thêm thành công");
				loadDuLieuLen(nv);
			}
		}

	}
	
	public boolean kiemTraRegex() {
		Regex rs = new Regex();
		if (rs.kiemTraSDT(txtSDT))
			return false;
		else if (rs.kiemTraCMND(txtCMND))
			return false;
		else if (rs.kiemTraEmail(txtEmail))
			return false;
		else if (KiemTraRongText(txtDiaChi))
			return false;
		else
			return true;
	}
	
	public boolean getGioiTinhTuInput() {
		if (rdbtnNam.isSelected())
			return true;
		return false;
	}
	
	/**
	 * Lấy thông tin nhân viên
	 * 
	 * @return
	 */
	private NhanVien getNhanVienTuTextfield() {

		String ten = txtTen.getText();
		LocalDate date = getDate();
		boolean gioiTinh = getGioiTinhTuInput();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		String CMND = txtCMND.getText();
		boolean trangThai = btnXaThai.getText() == "Nhận" ? false : true;
		String email = txtEmail.getText();
		return new NhanVien(ten, diaChi, sdt, CMND, trangThai, email, date, gioiTinh);
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
	
	public boolean KiemTraRongText(JTextField txt) {
		return txt.getText().equals("") ? true : false;
	}

	private void xoaRongText() {
		txtTen.setText("");
		txtDiaChi.setText("");
		txtCMND.setText("");
		txtSDT.setText("");
		txtEmail.setText("");
		rdbtnNam.setSelected(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(pnlNam) || o.equals(lblNam)) { // thiết lập chọn Giới tính là Nam
			rdbtnNam.setSelected(true);

		} else if (o.equals(pnlNu) || o.equals(lblNu)) { // Thiết lập chọn giới tính là Nữ
			rdbtnNu.setSelected(true);
		}
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
