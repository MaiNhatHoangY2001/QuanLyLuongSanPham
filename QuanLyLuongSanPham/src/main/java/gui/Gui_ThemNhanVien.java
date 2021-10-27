package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

import org.hibernate.annotations.Parent;

import dao.NhanVienDao;
import gui_package.CircleBtn;
import gui_package.RoundTextField;
import gui_package.RoundedPanel;
import model.NhanVien;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class Gui_ThemNhanVien extends JFrame implements ActionListener, MouseListener {

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

	private JComboBox<String> cmbChucVu;
	private JComboBox<String> cmbNgay;
	private JComboBox<String> cmbThang;
	private JComboBox<String> cmbNam;

	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JPanel pnlNam;
	private JLabel lblNam;
	private JPanel pnlNu;
	private JLabel lblNu;
	private NhanVienDao daoNV;

	/**
	 * Create the frame.
	 */
	public Gui_ThemNhanVien() {
		setUndecorated(true);
		setBounds(100, 100, 1440, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		/**
		 * Phần Header
		 */
		// Background Header
		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBorder(new MatteBorder(0, 0, 5, 0, (Color) Color.WHITE));
		pnlHeader.setBackground(new Color(242, 129, 25));
		pnlHeader.setBounds(0, 0, 1424, 150);
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
		pnlContent.setBounds(0, 151, 1424, 834);
		contentPane.add(pnlContent);

		// Background Input
		JPanel pnlInput = new RoundedPanel();
		((RoundedPanel) pnlInput).setArcs(new DimensionUIResource(100, 100));
		pnlInput.setLayout(null);
		pnlInput.setBackground(new Color(248, 198, 153));
		pnlInput.setBounds(112, 40, 1200, 666);
		pnlContent.add(pnlInput);

		// Nhập tên nhân viên
		JLabel lblHoTen = new JLabel("Họ Và Tên:");
		lblHoTen.setForeground(Color.BLACK);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHoTen.setBounds(81, 38, 225, 40);
		pnlInput.add(lblHoTen);

		txtTen = new RoundTextField("", 1000);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTen.setColumns(10);
		txtTen.setBounds(387, 33, 730, 50);
		pnlInput.add(txtTen);

		// Nhập dịa chỉ
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDiaChi.setBounds(81, 272, 225, 40);
		pnlInput.add(lblDiaChi);

		txtDiaChi = new RoundTextField("", 1000);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(387, 267, 730, 50);
		pnlInput.add(txtDiaChi);

		// Nhập số điện thoại
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSDT.setBounds(81, 350, 225, 40);
		pnlInput.add(lblSDT);

		txtSDT = new RoundTextField("", 1000);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setColumns(10);
		txtSDT.setBounds(387, 345, 730, 50);
		pnlInput.add(txtSDT);

		// Nhập chứng minh nhân dân
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setForeground(Color.BLACK);
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCMND.setBounds(81, 428, 225, 40);
		pnlInput.add(lblCMND);

		txtCMND = new RoundTextField("", 1000);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setColumns(10);
		txtCMND.setBounds(387, 423, 730, 50);
		pnlInput.add(txtCMND);

		// Nhập chức vụ
		JLabel lblChucVu = new JLabel("Chức Vụ:");
		lblChucVu.setForeground(Color.BLACK);
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblChucVu.setBounds(81, 506, 225, 40);
		pnlInput.add(lblChucVu);

		cmbChucVu = new JComboBox<String>();
		cmbChucVu.setModel(new DefaultComboBoxModel(new String[] { "Kế Toán", "Bán Hàng", "Đã Nghĩ" }));
		cmbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbChucVu.setBackground(Color.WHITE);
		cmbChucVu.setBounds(387, 501, 730, 50);
		pnlInput.add(cmbChucVu);

		// Nhập Email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEmail.setBounds(81, 584, 225, 40);
		pnlInput.add(lblEmail);

		txtEmail = new RoundTextField("", 1000);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtEmail.setColumns(10);
		txtEmail.setBounds(387, 579, 730, 50);
		pnlInput.add(txtEmail);

		/*
		 * Nhập ngày sinh
		 */
		// title
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNgaySinh.setBounds(81, 116, 225, 40);
		pnlInput.add(lblNgaySinh);

		// Ngày
		cmbNgay = new JComboBox<String>();
		cmbNgay.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		cmbNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNgay.setBackground(Color.WHITE);
		cmbNgay.setBounds(387, 117, 220, 50);
		pnlInput.add(cmbNgay);

		// Tháng
		cmbThang = new JComboBox<String>();
		cmbThang.setModel(new DefaultComboBoxModel(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5",
				"Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbThang.setBackground(Color.WHITE);
		cmbThang.setBounds(646, 117, 220, 50);
		pnlInput.add(cmbThang);

		// Năm
		cmbNam = new JComboBox<String>();
		cmbNam.setModel(new DefaultComboBoxModel(
				new String[] { "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992",
						"1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980",
						"1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970" }));
		cmbNam.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNam.setBackground(Color.WHITE);
		cmbNam.setBounds(897, 117, 220, 50);
		pnlInput.add(cmbNam);

		/*
		 * Nhập giới tính
		 */
		// title giới tính
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setForeground(Color.BLACK);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGioiTinh.setBounds(81, 194, 225, 40);
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

		// Thiết lập: Chi cho phép chọn 1 button radio
		ButtonGroup btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);

		/*
		 * Các nút
		 */
		// Button Lưu
		btnLuu = new CircleBtn("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLuu.setBackground(new Color(233, 180, 46));
		btnLuu.setBounds(183, 730, 230, 70);
		btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnLuu);

		// Button xóa rỗng
		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(596, 730, 230, 70);
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnXoaRong);

		// Button Hủy Bỏ
		btnHuyBo = new CircleBtn("Hủy Bỏ");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(1009, 730, 230, 70);
		btnHuyBo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnHuyBo);

		/**
		 * Các chức năng
		 */
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnHuyBo.addActionListener(this);
		pnlNam.addMouseListener(this);
		lblNam.addMouseListener(this);
		pnlNu.addMouseListener(this);
		lblNu.addMouseListener(this);
		
		daoNV =  new NhanVienDao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLuu)) {
			if (!KiemTraRong()) {
				NhanVien nv = getNhanVienTuTextfield();
				System.out.println(nv);
				JOptionPane.showMessageDialog(this, "Bạn đã thêm thành công");
			}
		} else if (o.equals(btnXoaRong)) {
			txtTen.setText("");
			txtSDT.setText("");
			txtCMND.setText("");
			txtEmail.setText("");
			txtDiaChi.setText("");
			txtTen.requestFocus();
		} else if (o.equals(btnHuyBo)) {
			int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không?", "Thông báo thoát",
					JOptionPane.YES_NO_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}
	}

	public boolean KiemTraRong() {
		if (KiemTraRongText(txtTen)) {
			JOptionPane.showMessageDialog(this, "Họ tên nhân viên không được để trống");
			txtTen.requestFocus();
			return true;
		} else if (KiemTraRongText(txtSDT)) {
			JOptionPane.showMessageDialog(this, "Số điện thoại nhân viên không được để trống");
			txtSDT.requestFocus();
			return true;
		} else if (KiemTraRongText(txtCMND)) {
			JOptionPane.showMessageDialog(this, "CMND/CCCD nhân viên không được để trống");
			txtCMND.requestFocus();
			return true;
		} else if (KiemTraRongText(txtEmail)) {
			JOptionPane.showMessageDialog(this, "Họ tên nhân viên không được để trống");
			txtEmail.requestFocus();
			return true;
		} else if (KiemTraRongText(txtDiaChi)) {
			JOptionPane.showMessageDialog(this, "Họ tên nhân viên không được để trống");
			txtEmail.requestFocus();
			return true;
		}
		return false;
	}

	public boolean KiemTraRongText(JTextField txt) {
		return txt.getText().equals("") ? true : false;
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
	 * @return
	 */
	private NhanVien getNhanVienTuTextfield() {
		
		String ten = capitalizer(txtTen.getText());
		LocalDate date = getDate();
		boolean gioiTinh = getGioiTinhTuInput();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		String CMND = txtCMND.getText();
		String chucVu = cmbChucVu.getSelectedItem().toString();
		String email = txtEmail.getText();
		return new NhanVien("NV0005", ten, diaChi, sdt, CMND, chucVu, email, date, gioiTinh);
	}
	
	/**
	 * Lấy ngày trong combobox
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
	
	public boolean getGioiTinhTuInput() {
		if (rdbtnNam.isSelected())
			return true;
		return false;
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
