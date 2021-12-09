package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

import dao.NhanVienDao;
import dao.TaiKhoanDao;
import gui_package.CircleBtn;
import gui_package.Regex;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;
import model.NhanVien;
import model.TaiKhoan;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class Gui_ThemNhanVien extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTextField txtEmail;
	private JTextField txtSDT;

	private JButton btnLuu;
	private JButton btnXoaRong;
	private JButton btnHuyBo;
	private JComboBox<String> cmbNgay;
	private JComboBox<String> cmbThang;
	private JComboBox<String> cmbNam;
	private NhanVienDao daoNV;
	private RoundTextField txtHeSoLuong;
	private TaiKhoanDao daoTK;
	private JRadioButton rdbtnHanhChinh;
	private JRadioButton rdbtnBanHang;

	/**
	 * Create the frame.
	 */
	public Gui_ThemNhanVien() {
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		/**
		 * Phần Header
		 */
		// Background Header
		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBorder(new MatteBorder(0, 0, 5, 0, (Color) Color.WHITE));
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1440, 150);
		contentPane.add(pnlHeader);

		// Titile
		JLabel lblThmNhnVin = new JLabel("THÊM NHÂN VIÊN");
		lblThmNhnVin.setForeground(Color.WHITE);
		lblThmNhnVin.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblThmNhnVin.setBounds(441, 28, 541, 93);
		pnlHeader.add(lblThmNhnVin);

		// Logo
		JLabel lblNewLabel = new JLabel("");
		Image imgUser = new ImageIcon("img\\dtVua.png").getImage();
		lblNewLabel.setIcon(new ImageIcon(imgUser));
		lblNewLabel.setBounds(50, 42, 96, 66);
		pnlHeader.add(lblNewLabel);

		/**
		 * Phần Content
		 */
		// Background content
		JPanel pnlContent = new JPanel();
		pnlContent.setLayout(null);
		pnlContent.setBackground(new Color(242, 129, 25));
		pnlContent.setBounds(0, 151, 1440, 862);
		contentPane.add(pnlContent);

		// Background Input
		JPanel pnlInput = new RoundedPanel();
		((RoundedPanel) pnlInput).setArcs(new DimensionUIResource(100, 100));
		pnlInput.setLayout(null);
		pnlInput.setBackground(new Color(248, 198, 153));
		pnlInput.setBounds(120, 42, 1200, 666);
		pnlContent.add(pnlInput);

		// Nhập tên nhân viên
		JLabel lblHoTen = new JLabel("Họ Và Tên:");
		lblHoTen.setForeground(Color.BLACK);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHoTen.setBounds(81, 38, 225, 40);
		pnlInput.add(lblHoTen);

		txtTen = new RoundTextField("", 1000);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTen.setColumns(10);
		txtTen.setBounds(316, 34, 801, 45);
		pnlInput.add(txtTen);

		// Nhập dịa chỉ
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setBounds(81, 272, 225, 40);
		pnlInput.add(lblDiaChi);

		txtDiaChi = new RoundTextField("", 1000);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(316, 271, 801, 45);
		pnlInput.add(txtDiaChi);

		// Nhập số điện thoại
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSDT.setBounds(81, 350, 225, 40);
		pnlInput.add(lblSDT);

		txtSDT = new RoundTextField("", 1000);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setColumns(10);
		txtSDT.setBounds(316, 350, 801, 45);
		pnlInput.add(txtSDT);

		// Nhập chứng minh nhân dân
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setForeground(Color.BLACK);
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCMND.setBounds(81, 428, 225, 40);
		pnlInput.add(lblCMND);

		txtCMND = new RoundTextField("", 1000);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setColumns(10);
		txtCMND.setBounds(316, 429, 801, 45);
		pnlInput.add(txtCMND);

		// Nhập Email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmail.setBounds(81, 506, 225, 40);
		pnlInput.add(lblEmail);

		txtEmail = new RoundTextField("", 1000);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtEmail.setColumns(10);
		txtEmail.setBounds(316, 508, 801, 45);
		pnlInput.add(txtEmail);

		/*
		 * Nhập ngày sinh
		 */
		// title
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgaySinh.setBounds(81, 116, 225, 40);
		pnlInput.add(lblNgaySinh);

		// Ngày
		cmbNgay = new JComboBox<String>();
		cmbNgay.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		cmbNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNgay.setBackground(Color.WHITE);
		cmbNgay.setBounds(316, 113, 250, 45);
		pnlInput.add(cmbNgay);

		// Tháng
		cmbThang = new JComboBox<String>();
		cmbThang.setModel(new DefaultComboBoxModel<String>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4",
				"Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbThang.setBackground(Color.WHITE);
		cmbThang.setBounds(590, 113, 250, 45);
		pnlInput.add(cmbThang);

		// Năm
		int namTu18Tuoi = LocalDate.now().getYear() - 18;
		DefaultComboBoxModel<String> modelNam = new DefaultComboBoxModel<String>();
		for (int i = namTu18Tuoi; i >= 1900; i--) {
			modelNam.addElement(i + "");
		}
		cmbNam = new JComboBox<String>();
		cmbNam.setModel(modelNam);
		cmbNam.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNam.setBackground(Color.WHITE);
		cmbNam.setBounds(867, 113, 250, 45);
		pnlInput.add(cmbNam);

		/*
		 * Input HeSoLuong
		 */
		// JLable HeSoLuong
		JLabel lblHeSoLuong = new JLabel("Mức Lương:");
		lblHeSoLuong.setForeground(Color.BLACK);
		lblHeSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHeSoLuong.setBounds(81, 194, 225, 40);
		pnlInput.add(lblHeSoLuong);

		// JtextField HeSoLuong
		txtHeSoLuong = new RoundTextField("", 1000);
		txtHeSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtHeSoLuong.setBounds(316, 192, 801, 45);
		pnlInput.add(txtHeSoLuong);

		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setForeground(Color.BLACK);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChcV.setBounds(81, 584, 225, 40);
		pnlInput.add(lblChcV);

		rdbtnHanhChinh = new JRadioButton("   Hành Chính");
		rdbtnHanhChinh.setMargin(new Insets(2, 10, 2, 2));
		rdbtnHanhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnHanhChinh.setBounds(316, 587, 250, 45);
		pnlInput.add(rdbtnHanhChinh);

		rdbtnBanHang = new JRadioButton("   Bán Hàng");
		rdbtnBanHang.setMargin(new Insets(2, 10, 2, 2));
		rdbtnBanHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnBanHang.setBounds(590, 587, 250, 45);
		pnlInput.add(rdbtnBanHang);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnBanHang);
		group.add(rdbtnHanhChinh);

		/*
		 * Các nút
		 */
		// Button Lưu
		btnLuu = new CircleBtn("Thêm");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLuu.setBackground(new Color(233, 180, 46));
		btnLuu.setBounds(188, 750, 230, 70);
		btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnLuu);

		// Button xóa rỗng
		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(605, 750, 230, 70);
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnXoaRong);

		// Button Hủy Bỏ
		btnHuyBo = new CircleBtn("Hủy Bỏ");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(1022, 750, 230, 70);
		btnHuyBo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnHuyBo);

		/**
		 * Các chức năng
		 */
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnHuyBo.addActionListener(this);

		daoNV = new NhanVienDao();
		daoTK = new TaiKhoanDao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLuu)) {
			if (kiemTraRegex()) {
				NhanVien nv = getNhanVienTuTextfield();
				if (daoNV.themNhanVien(nv)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công");
					if (rdbtnHanhChinh.isSelected() == true) {
						TaiKhoan taikhoan = new TaiKhoan(nv.getMaNhanVien(), nv.getMaNhanVien());
						taikhoan.setNhanVien(nv);
						daoTK.themTaiKhoan(taikhoan);
					}
				} else
					JOptionPane.showMessageDialog(this, "Thêm thất bại");

			}
		} else if (o.equals(btnXoaRong)) {
			xoaRongText();
		} else if (o.equals(btnHuyBo)) {
			int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không?", "Thông báo thoát",
					JOptionPane.YES_NO_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}
	}

	public void xoaRongText() {
		txtTen.setText("");
		txtSDT.setText("");
		txtCMND.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
		txtHeSoLuong.setText("");
		cmbNgay.setSelectedIndex(0);
		cmbThang.setSelectedIndex(0);
		cmbNam.setSelectedIndex(0);
		txtTen.requestFocus();
	}

	public boolean KiemTraRongText(JTextField txt) {
		return txt.getText().equals("") ? true : false;
	}

	/**
	 * Viết hoa chữ cái đầu tiên của từng chuỗi
	 * 
	 * @param Word
	 * @return
	 */
	private String capitalizer(String Word) {
		String[] words = Word.split(" ");
		StringBuilder sb = new StringBuilder();
		if (words[0].length() > 0) {
			sb.append(Character.toUpperCase(words[0].charAt(0))
					+ words[0].subSequence(1, words[0].length()).toString().toLowerCase());
			for (int i = 1; i < words.length; i++) {
				sb.append(" ");
				sb.append(Character.toUpperCase(words[i].charAt(0))
						+ words[i].subSequence(1, words[i].length()).toString().toLowerCase());
			}
		}
		return sb.toString();
	}

	/**
	 * Lấy thông tin nhân viên
	 * 
	 * @return
	 */
	private NhanVien getNhanVienTuTextfield() {
		String ten = txtTen.getText();
		LocalDate date = getDate();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		String CMND = txtCMND.getText();
		boolean trangThai = true;
		String email = txtEmail.getText();
		double hsl = Double.parseDouble(txtHeSoLuong.getText());
		return new NhanVien(capitalizer(ten), diaChi, sdt, CMND, trangThai, email, date, hsl);
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
	 * Kiểm tra Regex SĐT, kiểm tra Regex CMND, Kiểm tra Regex email, Kiểm tra rỗng
	 * DiaChi
	 * 
	 * @return
	 */
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
}
