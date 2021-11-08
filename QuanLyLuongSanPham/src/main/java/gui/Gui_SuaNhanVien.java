package gui;

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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

import dao.NhanVienDao;
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

public class Gui_SuaNhanVien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlInput;

	private JLabel lblMaNV;
	private JLabel lblTTNhanVien;
	private JLabel lblHoTen;
	private JLabel lblDiaChi;
	private JLabel lblCMND;
	private JLabel lblSDT;
	private JTextField txtHeSoLuong;
	private JLabel lblEmail;
	private JLabel lblNgaySinh;

	private JButton btnLuu;
	private JButton btnXoaRong;
	private JButton btnHuyBo;
	private JButton btnXaThai;
	private JLabel lblHeSoLuong;

	private NhanVien nhanVien;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtCMND;
	private JTextField txtEmail;

	private JComboBox<String> cmbNgay;
	private JComboBox<String> cmbThang;
	private JComboBox<String> cmbNam;
	
	private NhanVienDao daoNV;
	private DecimalFormat fm = new DecimalFormat("#");

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
		pnlHeader.setBounds(0, 0, 1440, 150);
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
		pnlContent.setBounds(0, 151, 1440, 873);
		contentPane.add(pnlContent);

		// Hiện mã nhân viên
		lblMaNV = new JLabel("Mã Nhân Viên: ");
		lblMaNV.setForeground(Color.WHITE);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMaNV.setBounds(184, 48, 484, 37);
		pnlContent.add(lblMaNV);

		// Hiện trạng thái nhân viên làm việc
		lblTTNhanVien = new JLabel();
		lblTTNhanVien.setForeground(Color.WHITE);
		lblTTNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTTNhanVien.setBounds(941, 48, 339, 37);
		pnlContent.add(lblTTNhanVien);

		// Nút Lưu
		btnLuu = new CircleBtn("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLuu.setBackground(new Color(233, 180, 46));
		btnLuu.setBounds(104, 733, 230, 70);
		btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnLuu);

		// Nút Xóa Rổng
		btnXoaRong = new CircleBtn("Xóa Rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXoaRong.setBackground(new Color(233, 180, 46));
		btnXoaRong.setBounds(772, 733, 230, 70);
		btnXoaRong.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnXoaRong);

		// Nút Hủy Bỏ
		btnHuyBo = new CircleBtn("Hủy Bỏ");
		btnHuyBo.setForeground(Color.WHITE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHuyBo.setBackground(new Color(233, 180, 46));
		btnHuyBo.setBounds(1106, 733, 230, 70);
		btnHuyBo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlContent.add(btnHuyBo);

		// Nút Xa Thải
		btnXaThai = new CircleBtn("Xa Thải");
		btnXaThai.setForeground(Color.WHITE);
		btnXaThai.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnXaThai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXaThai.setBackground(new Color(233, 180, 46));
		btnXaThai.setBounds(438, 733, 230, 70);
		pnlContent.add(btnXaThai);

		/*
		 * Phần Nhập thông tin 
		 */
		// Background Nhập thông tin
		pnlInput = new RoundedPanel();
		((RoundedPanel) pnlInput).setArcs(new DimensionUIResource(100, 100));
		pnlInput.setBackground(new Color(248, 198, 153));
		pnlInput.setLayout(null);
		pnlInput.setBounds(120, 83, 1200, 597);
		pnlContent.add(pnlInput);

		// Nhập tên
		lblHoTen = new JLabel("Họ Và Tên:");
		lblHoTen.setForeground(Color.BLACK);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHoTen.setBounds(81, 39, 225, 40);
		pnlInput.add(lblHoTen);

		txtTen = new RoundTextField("", 1000);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTen.setBounds(316, 37, 801, 45);
		pnlInput.add(txtTen);

		// Nhập địa chỉ
		lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDiaChi.setBounds(81, 276, 225, 40);
		pnlInput.add(lblDiaChi);

		txtDiaChi = new RoundTextField("", 1000);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtDiaChi.setBounds(316, 274, 801, 45);
		pnlInput.add(txtDiaChi);

		// Nhập số điện thoại
		lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSDT.setBounds(81, 355, 225, 40);
		pnlInput.add(lblSDT);

		txtSDT = new RoundTextField("", 1000);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setBounds(316, 353, 801, 45);
		pnlInput.add(txtSDT);

		// Nhập chứng minh nhân dân
		lblCMND = new JLabel("CMND:");
		lblCMND.setForeground(Color.BLACK);
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCMND.setBounds(81, 434, 225, 40);
		pnlInput.add(lblCMND);

		txtCMND = new RoundTextField("", 1000);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setBounds(316, 432, 801, 45);
		pnlInput.add(txtCMND);

		// Nhập email
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmail.setBounds(81, 513, 225, 40);
		pnlInput.add(lblEmail);

		txtEmail = new RoundTextField("", 1000);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtEmail.setBounds(316, 511, 801, 45);
		pnlInput.add(txtEmail);

		// Nhập ngày sinh
		lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgaySinh.setBounds(81, 118, 225, 40);
		pnlInput.add(lblNgaySinh);

		// Ngày
		cmbNgay = new JComboBox<String>();
		DefaultComboBoxModel modelNgay = new DefaultComboBoxModel();
		for (int i = 1; i <= 31; i++) {
			modelNgay.addElement(i);
		}
		cmbNgay.setModel(modelNgay);
		cmbNgay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbNgay.setBackground(Color.WHITE);
		cmbNgay.setBounds(316, 116, 250, 45);
		pnlInput.add(cmbNgay);

		// Tháng
		cmbThang = new JComboBox<String>();
		DefaultComboBoxModel modelThang = new DefaultComboBoxModel();
		for (int i = 1; i <= 12; i++) {
			modelThang.addElement("Tháng " + i);
		}
		cmbThang.setModel(modelThang);
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cmbThang.setBackground(Color.WHITE);
		cmbThang.setBounds(590, 116, 250, 45);
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
		cmbNam.setBounds(867, 116, 250, 45);
		pnlInput.add(cmbNam);

		// Nhập hệ số lương
		lblHeSoLuong = new JLabel("Hệ số lương");
		lblHeSoLuong.setForeground(Color.BLACK);
		lblHeSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHeSoLuong.setBounds(81, 197, 225, 40);
		pnlInput.add(lblHeSoLuong);

		txtHeSoLuong = new RoundTextField("", 1000);
		txtHeSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtHeSoLuong.setBounds(316, 195, 801, 45);
		pnlInput.add(txtHeSoLuong);

		/*
		 * Thiêt lập Sự kiện cho nút
		 */
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnHuyBo.addActionListener(this);
		btnXaThai.addActionListener(this);

		/*
		 * Hiện dữ liệu vào các tool
		 */
		daoNV = new NhanVienDao();
		nhanVien = nv;
		loadDuLieuLen(nv);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnHuyBo)) {
			NhanVien nv = getNhanVienTuTextfield();
			nv.setMaNhanVien(nhanVien.getMaNhanVien());
			if (nhanVien == nv) {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không?", "Thông báo thoát",
						JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					this.dispose();
				}
			} else {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu thông tin Nhân Viên trước khi thoát không?", "Thông báo lưu",
						JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					daoNV.capNhatNhanVien(nv);
					this.dispose();
				}
			}
			
			
		} else if (o.equals(btnXoaRong)) {
			xoaRongText();
		} else if (o.equals(btnXaThai)) {
			if (btnXaThai.getText().equals("Xa Thải")) {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn xa thải nhân viên này không?",
						"Thông báo", JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					lblTTNhanVien.setText("Trang thái: Nghĩ việc");
					nhanVien.setTrangThaiLamViec(false);
					btnXaThai.setText("Nhận");
				}
			} else {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn nhận nhân viên làm này không?",
						"Thông báo", JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					lblTTNhanVien.setText("Trang thái: Đang làm");
					nhanVien.setTrangThaiLamViec(true);
					btnXaThai.setText("Xa Thải");
				}
			}
		} else if (o.equals(btnLuu)) {
			if (kiemTraRegex()) {
				NhanVien nv = getNhanVienTuTextfield();
				nv.setMaNhanVien(nhanVien.getMaNhanVien());
				boolean rs = daoNV.capNhatNhanVien(nv);
				if (rs) {
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				} else {
					JOptionPane.showMessageDialog(this, "Sửa không thành công");
				}
				
			}
		}

	}
	
	private void loadDuLieuLen(NhanVien nv) {
		lblMaNV.setText("Mã Nhân Viên: " + nhanVien.getMaNhanVien());
		txtTen.setText(nhanVien.getTenNhanVien());
		txtDiaChi.setText(nhanVien.getDiaChi());
		txtCMND.setText(nhanVien.getcCCD());
		txtEmail.setText(nhanVien.getEmail());
		txtHeSoLuong.setText(fm.format(nhanVien.getMucLuong()));
		txtSDT.setText(nhanVien.getsDT());
		int day = nv.getNgaySinh().getDayOfMonth();
		int month = nv.getNgaySinh().getMonthValue();
		int year = nv.getNgaySinh().getYear();
		setDate(day, month, year);
		if (nv.gettrangThaiLamViec() == true) {
			lblTTNhanVien.setText("Trang thái: Đang làm");
			btnXaThai.setText("Xa Thải");
		} else if (nv.gettrangThaiLamViec() == false) {
			lblTTNhanVien.setText("Trang thái: Nghĩ việc");
			btnXaThai.setText("Nhận");
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

	/**
	 * Lấy thông tin nhân viên
	 * 
	 * @return
	 */
	private NhanVien getNhanVienTuTextfield() {

		String ten = capitalizer(txtTen.getText());
		LocalDate date = getDate();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		String CMND = txtCMND.getText();
		boolean trangThai = btnXaThai.getText() == "Nhận" ? false : true;
		String email = txtEmail.getText();
		double hsl = Double.parseDouble(txtHeSoLuong.getText());
		return new NhanVien(ten, diaChi, sdt, CMND, trangThai, email, date, hsl);
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
	
	public void setDate(int ngay, int thang, int nam) {
		cmbNgay.setSelectedItem(ngay);
		cmbThang.setSelectedItem("Tháng " + thang);
		cmbNam.setSelectedItem(nam);
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
	}
}
